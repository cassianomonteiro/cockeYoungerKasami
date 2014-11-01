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
public class GrammarTest {
	
	private Grammar grammar;

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
		grammar = new Grammar();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ct200.cyk.model.Grammar#addProduction(ct200.cyk.model.Production)}.
	 */
	@Test
	public void testAddProduction() {
		// Inicialmente a gramática deve estar vazia
		assertEquals(0, grammar.getProductions().size());
		
		// Adicionar uma produção
		grammar.addProduction(new Production());
		assertEquals(1, grammar.getProductions().size());

		// Adicionar outra produção
		grammar.addProduction(new Production());
		assertEquals(2, grammar.getProductions().size());
	}

	/**
	 * Test method for {@link ct200.cyk.model.Grammar#removeProduction(ct200.cyk.model.Production)}.
	 */
	@Test
	public void testRemoveProduction() {
		// Inicialmente a gramática deve estar vazia
		assertEquals(0, grammar.getProductions().size());
		
		Production a = new Production();
		Production b = new Production();
		
		// Adicionar produções
		grammar.addProduction(a);
		grammar.addProduction(b);
		assertEquals(2, grammar.getProductions().size());
		
		// Remover produções
		grammar.removeProduction(a);
		assertEquals(1, grammar.getProductions().size());
		assertEquals(b, grammar.getProductions().get(0));

		grammar.removeProduction(b);
		assertEquals(0, grammar.getProductions().size());
	}

}
