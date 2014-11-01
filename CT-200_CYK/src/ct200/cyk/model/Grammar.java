package ct200.cyk.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe para representar uma gramática, composta de várias produções unitárias.
 * @author cassiano
 *
 */
public class Grammar {

	private List<Production> productions = new ArrayList<Production>();
	
	public void addProduction(Production production) {
		this.productions.add(production);
	}

	public List<Production> getProductions() {
		return productions;
	}

	public void removeProduction(Production production) {
		this.productions.remove(production);
	}

}
