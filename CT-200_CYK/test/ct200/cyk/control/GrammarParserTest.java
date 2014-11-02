package ct200.cyk.control;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
		
		// Exemplos de produção que devem retornar true
		assertTrue(GrammarParser.grammarTextIsCorrect("S -> a"));
		assertTrue(GrammarParser.grammarTextIsCorrect("S-> A"));
		assertTrue(GrammarParser.grammarTextIsCorrect("S  ->Aa"));
		assertTrue(GrammarParser.grammarTextIsCorrect("S ->   AA"));
		assertTrue(GrammarParser.grammarTextIsCorrect("S->a"));

		// Exemplos de produção que devem retornar false
		assertFalse(GrammarParser.grammarTextIsCorrect("S --> a"));
		assertFalse(GrammarParser.grammarTextIsCorrect("s -> a"));
		assertFalse(GrammarParser.grammarTextIsCorrect("s --> A"));
		assertFalse(GrammarParser.grammarTextIsCorrect("SA --> a"));
		assertFalse(GrammarParser.grammarTextIsCorrect("AB --> a"));
		
		// Múltiplas linhas que devem retornar true
		assertTrue(GrammarParser.grammarTextIsCorrect("S -> A\nA->a"));
		assertTrue(GrammarParser.grammarTextIsCorrect("S -> A\nA->a\n"));
		assertTrue(GrammarParser.grammarTextIsCorrect("S -> A   \nA->a\n   B->b"));
		
		// Múltiplas linhas que devem retornar false
		assertFalse(GrammarParser.grammarTextIsCorrect("S -> A\nA->a\nB"));
		assertFalse(GrammarParser.grammarTextIsCorrect("S -> A\nA->a\nB-"));
		assertFalse(GrammarParser.grammarTextIsCorrect("S -> A\nA->a\nB->"));
		assertFalse(GrammarParser.grammarTextIsCorrect("S -> A\nA->a\na->B"));
		
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
		fail("Not yet implemented");
	}

}
