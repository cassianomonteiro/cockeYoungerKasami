package ct200.cyk.control;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
public class CYKParserTest {

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
	 * Test method for {@link ct200.cyk.control.CYKParser#getGrammar()}.
	 */
	@Test
	public void testGetGrammar() {
		Grammar grammar = new Grammar();
		CYKParser parser = new CYKParser(grammar);	
		assertEquals(grammar, parser.getGrammar());
	}

	/**
	 * Test method for {@link ct200.cyk.control.CYKParser#setGrammar(ct200.cyk.model.Grammar)}.
	 */
	@Test
	public void testSetGrammar() {
		Grammar grammar = new Grammar();
		CYKParser parser = new CYKParser(grammar);	
		assertEquals(grammar, parser.getGrammar());
		
		Grammar newGrammar = new Grammar();
		parser.setGrammar(newGrammar);
		assertEquals(newGrammar, parser.getGrammar());
	}

	/**
	 * Test method for {@link ct200.cyk.control.CYKParser#CYKParser(ct200.cyk.model.Grammar)}.
	 */
	@Test
	public void testCYKParser() {
		Grammar grammar = new Grammar();
		CYKParser parser = new CYKParser(grammar);
		assertNotNull(parser);
	}

	/**
	 * Test method for {@link ct200.cyk.control.CYKParser#stringBelongsToLanguage(java.lang.String)}.
	 */
	@Test
	public void testStringBelongsToLanguage() {
		
		// Exceto o exemplo da Washington University,
		// todos os exemplos devem ter a string de teste pertencentes à linguagem
		List<String> examples = ExamplesFactory.getExamplesList();
		CYKParser parser = new CYKParser(null);
		for (String example : examples) {
			parser.setGrammar(GrammarParser.parsedGrammarFromText(ExamplesFactory.getExample(example)));
			
			if (example.contains("Washington")) {
				assertFalse(parser.stringBelongsToLanguage(ExamplesFactory.getTestString(example)));
			}
			else {
				assertTrue(parser.stringBelongsToLanguage(ExamplesFactory.getTestString(example)));
			}
		}
	}

	/**
	 * Test method for {@link ct200.cyk.control.CYKParser#cykTableForString(java.lang.String)}.
	 */
	@Test
	public void testCykTableForString() {
		
		// Teste do da impressão da tabela CYK do exemplo do requisito do laboratório
		Grammar testGrammar = GrammarParser.parsedGrammarFromText("S->AB|BC\n" +
																   "A->BA|a\n" +
																   "B->CC|b\n" +
																   "C->AB|a\n");
		String testString = "baaba";

		String[][] oracleTable = {{"{B}", "{A,C}", "{A,C}","{B}","{A,C}"},
								  {"{A,S}", "{B}", "{S,C}","{A,S}",""},
								  {"{}", "{B}", "{B}","",""},
								  {"{}", "{A,S,C}", "","",""},
								  {"{S,C,A}", "", "","",""}};
		

		CYKParser parser = new CYKParser(testGrammar);
		String[][] cykTable = parser.cykTableForString(testString);
		
		for (int i = 0; i < oracleTable.length; i++) {
			assertArrayEquals(oracleTable[i], cykTable[i]);
		}	
	}

}
