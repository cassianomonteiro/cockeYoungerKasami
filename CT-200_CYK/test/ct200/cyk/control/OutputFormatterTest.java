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
public class OutputFormatterTest {

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
	 * Test method for {@link ct200.cyk.control.OutputFormatter#formattedCYKOutput(java.lang.String[][], java.lang.String)}.
	 */
	@Test
	public void testFormattedCYKOutput() {
		
		String testString;
		String expectedOutput;
		
		// Tabela CYK de um elemento
		String[][] cykTable1 = {{"{B}"}};
		testString = "b";
		expectedOutput = "{B}\n" +
						 "___\n" +
						 " b ";
		assertEquals(expectedOutput, OutputFormatter.formattedCYKOutput(cykTable1, testString));

		// Tabela CYK de um elemento com duas linhas
		String[][] cykTable2 = {{"{B}"}, {"{C}"}};
		testString = "b";
		expectedOutput = "{C}\n" +
						 "{B}\n" +
						 "___\n" +
						 " b ";
		assertEquals(expectedOutput, OutputFormatter.formattedCYKOutput(cykTable2, testString));

		// Tabela CYK de um elemento com duas linhas com diferentes centralizações
		String[][] cykTable3 = {{"{B}"}, {"{C,A}"}};
		testString = "b";
		expectedOutput = "{C,A}\n" +
						 " {B} \n" +
						 "_____\n" +
						 "  b  ";
		assertEquals(expectedOutput, OutputFormatter.formattedCYKOutput(cykTable3, testString));

		// Tabela CYK de dois elementos
		String[][] cykTable4 = {{"{B}", "{C}"}};
		testString = "bc";
		expectedOutput = "{B}|{C}\n" +
						 "___|___\n" +
						 " b | c ";
		assertEquals(expectedOutput, OutputFormatter.formattedCYKOutput(cykTable4, testString));

		// Tabela CYK de dois elementos e duas linhas
		String[][] cykTable5 = {{"{A}", "{B}"},
								{"{C}", "{D}"}};
		testString = "bc";
		expectedOutput = "{C}|{D}\n" +
						 "{A}|{B}\n" +
						 "___|___\n" +
						 " b | c ";
		assertEquals(expectedOutput, OutputFormatter.formattedCYKOutput(cykTable5, testString));

		// Tabela CYK do requisito do trabalho
		String[][] cykTable6 = {{"{B}", "{A,C}", "{A,C}", "{B}", "{A,C}"},
								{"{S,A}", "{B}", "{S,C}", "{S,A}", ""},
								{"-", "{B}", "{B}", "", ""},
								{"-", "{S,A,C}", "", "", ""},
								{"{S,A,C}", "", "", "", ""}};
		testString = "baaba";
		expectedOutput = "{S,A,C}|       |     |     |     \n" +
						 "   -   |{S,A,C}|     |     |     \n" +
						 "   -   |  {B}  | {B} |     |     \n" +
						 " {S,A} |  {B}  |{S,C}|{S,A}|     \n" +
						 "  {B}  | {A,C} |{A,C}| {B} |{A,C}\n" +
						 "_______|_______|_____|_____|_____\n" +
						 "   b   |   a   |  a  |  b  |  a  ";
		assertEquals(expectedOutput, OutputFormatter.formattedCYKOutput(cykTable6, testString));
	}

	/**
	 * Test method for {@link ct200.cyk.control.OutputFormatter#centralizedSymbol(java.lang.String, int)}.
	 */
	@Test
	public void testCentralizedSymbol() {
		
		// Comprimento zero não deve modificar o símbolo
		assertEquals("a", OutputFormatter.centralizedSymbol("a", 0));
		
		// Comprimento menor ou igual ao comprimento do símbolo não deve modificá-lo
		assertEquals("a", OutputFormatter.centralizedSymbol("a", 1));
		assertEquals("abc", OutputFormatter.centralizedSymbol("abc", 2));

		// Comprimento igualmente espaçado deve centralizar o símbolo
		assertEquals(" a ", OutputFormatter.centralizedSymbol("a", 3));
		assertEquals("  a  ", OutputFormatter.centralizedSymbol("a", 5));
		assertEquals(" abc ", OutputFormatter.centralizedSymbol("abc", 5));

		// Comprimento desbalanceado deve deixar o símbolo central mais à esquerda
		assertEquals(" a  ", OutputFormatter.centralizedSymbol("a", 4));
		assertEquals(" abc  ", OutputFormatter.centralizedSymbol("abc", 6));
	}


	/**
	 * Test method for {@link ct200.cyk.control.OutputFormatter#getSeparatorWithLenght(int)}.
	 */
	@Test
	public void testGetSeparatorWithLenght() {
		
		// Separador vazio
		assertEquals("", OutputFormatter.getSeparatorWithLenght(0));

		// Separador unitário
		assertEquals("_", OutputFormatter.getSeparatorWithLenght(1));

		// Separadores múltiplos
		assertEquals("__", OutputFormatter.getSeparatorWithLenght(2));
		assertEquals("___", OutputFormatter.getSeparatorWithLenght(3));
	}

}
