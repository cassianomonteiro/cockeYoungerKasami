package ct200.cyk.control;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ct200.cyk.model.Grammar;

/**
 * @author cassiano
 *
 */
public class GrammarParserTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ct200.cyk.control.GrammarParser#grammarTextIsCorrect(java.lang.String)}.
	 */
	@Test
	public void testGrammarTextIsCorrect() {
		
		// String vazia ou nula deve retornar false
		assertFalse(GrammarParser.grammarTextIsCorrect(null));
		assertFalse(GrammarParser.grammarTextIsCorrect(""));
		
		// Exemplos de produção que devem retornar true (FNC)
		assertTrue(GrammarParser.grammarTextIsCorrect("S -> a"));
		assertTrue(GrammarParser.grammarTextIsCorrect("S-> A"));
		assertTrue(GrammarParser.grammarTextIsCorrect("S ->   AA"));
		assertTrue(GrammarParser.grammarTextIsCorrect("S->AA"));
		assertTrue(GrammarParser.grammarTextIsCorrect("S-> AA|a"));
		assertTrue(GrammarParser.grammarTextIsCorrect("S-> AA |a"));
		assertTrue(GrammarParser.grammarTextIsCorrect("S-> AA|  a  "));

		// Exemplos de produção que devem retornar false
		assertFalse(GrammarParser.grammarTextIsCorrect("S --> a"));
		assertFalse(GrammarParser.grammarTextIsCorrect("S  ->Aa"));
		assertFalse(GrammarParser.grammarTextIsCorrect("s -> a"));
		assertFalse(GrammarParser.grammarTextIsCorrect("s -> A"));
		assertFalse(GrammarParser.grammarTextIsCorrect("SA -> a"));
		assertFalse(GrammarParser.grammarTextIsCorrect("AB -> a"));
		
		// Múltiplas linhas que devem retornar true
		assertTrue(GrammarParser.grammarTextIsCorrect("S -> A\nA->a"));
		assertTrue(GrammarParser.grammarTextIsCorrect("S -> A\nA->a\n"));
		assertTrue(GrammarParser.grammarTextIsCorrect("S -> A   \nA->a\n   B->b"));
		assertTrue(GrammarParser.grammarTextIsCorrect("S -> A   \nA->a|A\n   B->b"));
		
		// Múltiplas linhas que devem retornar false
		assertFalse(GrammarParser.grammarTextIsCorrect("S -> A\nA->a\nB"));
		assertFalse(GrammarParser.grammarTextIsCorrect("S -> A\nA->a\nB-"));
		assertFalse(GrammarParser.grammarTextIsCorrect("S -> A\nA->a\nB->"));
		assertFalse(GrammarParser.grammarTextIsCorrect("S -> A\nA->a\na->B"));
		assertFalse(GrammarParser.grammarTextIsCorrect("S -> A\nA->A|a\na->B"));
		
		// Produção inicial não encontrada deve retornar false
		assertFalse(GrammarParser.grammarTextIsCorrect("A -> B"));
		assertFalse(GrammarParser.grammarTextIsCorrect("A -> S"));
		assertFalse(GrammarParser.grammarTextIsCorrect("C -> A\nA->a"));
	}

	/**
	 * Test method for {@link ct200.cyk.control.GrammarParser#parsedGrammarFromText(java.lang.String)}.
	 */
	@Test
	public void testParsedGrammarFromText() {
		
		Grammar grammar = new Grammar();

		// Gramática incorreta deve retornar null
		grammar = GrammarParser.parsedGrammarFromText("");
		assertNull(grammar);
		
		// Gramática de uma produção única
		grammar = GrammarParser.parsedGrammarFromText("S -> a");
		assertEquals(1, grammar.getProductions().size());
		assertEquals("S", grammar.getProductions().get(0).getHead());
		assertEquals("a", grammar.getProductions().get(0).getBody());

		// Gramática de uma produção múltipla
		grammar = GrammarParser.parsedGrammarFromText("S -> AA | a");
		assertEquals(2, grammar.getProductions().size());
		assertEquals("S", grammar.getProductions().get(0).getHead());
		assertEquals("AA", grammar.getProductions().get(0).getBody());
		assertEquals("S", grammar.getProductions().get(1).getHead());
		assertEquals("a", grammar.getProductions().get(1).getBody());

		// Gramática de várias produções únicas
		grammar = GrammarParser.parsedGrammarFromText("S -> AA\n A->a");
		assertEquals(2, grammar.getProductions().size());
		assertEquals("S", grammar.getProductions().get(0).getHead());
		assertEquals("AA", grammar.getProductions().get(0).getBody());
		assertEquals("A", grammar.getProductions().get(1).getHead());
		assertEquals("a", grammar.getProductions().get(1).getBody());

		// Gramática de várias produções múltiplas
		grammar = GrammarParser.parsedGrammarFromText("S -> AA|A \n A-> AA | a");
		assertEquals(4, grammar.getProductions().size());
		assertEquals("S", grammar.getProductions().get(0).getHead());
		assertEquals("AA", grammar.getProductions().get(0).getBody());
		assertEquals("S", grammar.getProductions().get(1).getHead());
		assertEquals("A", grammar.getProductions().get(1).getBody());
		assertEquals("A", grammar.getProductions().get(2).getHead());
		assertEquals("AA", grammar.getProductions().get(2).getBody());
		assertEquals("A", grammar.getProductions().get(3).getHead());
		assertEquals("a", grammar.getProductions().get(3).getBody());
	}

}
