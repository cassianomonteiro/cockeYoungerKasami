/**
 * 
 */
package ct200.cyk.control;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author cassiano
 *
 */
public class ExamplesFactoryTest {

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
	 * Test method for {@link ct200.cyk.control.ExamplesFactory#getExamplesList()}.
	 */
	@Test
	public void testGetExamplesList() {
		List<String> examples = ExamplesFactory.getExamplesList();
		
		// Devem existir 6 exemplos
		assertEquals(6,examples.size());
	}

	/**
	 * Test method for {@link ct200.cyk.control.ExamplesFactory#getExample(String)}.
	 */
	@Test
	public void testGetExample() {
		List<String> examples = ExamplesFactory.getExamplesList();

		// Todos os exemplos devem estar com a gramática correta
		for (String example : examples) {
			assertTrue(GrammarParser.grammarTextIsCorrect(ExamplesFactory.getExample(example)));
		}
	}

	/**
	 * Test method for {@link ct200.cyk.control.ExamplesFactory#getTestString(String)}.
	 */
	@Test
	public void testGetTestString() {
		List<String> examples = ExamplesFactory.getExamplesList();

		// Todos os exemplos devem estar com a gramática correta
		for (String example : examples) {
			assertTrue(ExamplesFactory.getTestString(example).length() > 0);
		}
	}

}
