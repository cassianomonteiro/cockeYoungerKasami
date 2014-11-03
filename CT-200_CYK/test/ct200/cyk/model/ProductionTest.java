/**
 * 
 */
package ct200.cyk.model;

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
public class ProductionTest {

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
	 * Test method for {@link ct200.cyk.model.Production#Production(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testProductionStringString() {
		// Teste do construtor com parâmetros
		Production p = new Production("S" , "A");
		assertEquals("S", p.getHead());
		assertEquals("A", p.getBody());
	}

}
