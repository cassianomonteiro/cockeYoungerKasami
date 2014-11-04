package ct200.cyk.control;

import ct200.cyk.model.Grammar;
import ct200.cyk.model.Production;

/**
 * Classe de funções para interpretar as entradas do usuário e criar objetos
 * a serem utilizados no algoritmo CYK
 * @author cassiano
 *
 */
public class GrammarParser {
	
	/**
	 * Este método verifica se o texto de entrada da gramática está completo
	 * para que o algoritmo CYK possa ser executado corretamente.
	 * @param grammarText
	 * @return <code><b>true</b></code> se a gramática está pronta para ser avaliada
	 */
	public static boolean grammarTextIsCorrect(String grammarText) {
		
		// Evitar erro de string nula
		if (grammarText == null) {
			return false;
		}
		
		// Variáveis booleanas de controle
		boolean allLinesMatchRegex = true;
		boolean initialProductionFound = false;
		
		// Regular expression que encontra produções do tipo A -> Ba|a
		String productionRegex = "^[A-Z]\\s*->\\s*[A-Za-z]+(\\s*\\|\\s*[A-Za-z])*$";
		
		// Quebrar as linhas da gramática
		String[] grammarLines = grammarText.split("\n");
		
		// Avaliar cada uma das linhas
		for (int i = 0; i < grammarLines.length; i++) {
			// Se a linha não é compatível com o regex, parar
			if (!grammarLines[i].trim().matches(productionRegex)) {
				allLinesMatchRegex = false;
				break;
			}
			// Procurar a produção do símbolo inicial "S"
			else if (grammarLines[i].trim().startsWith("S")) {
				initialProductionFound = true;
			}
		}

		// A gramática está correta se:
		// - todas as linhas são compatíveis com o regex
		// - a produção inicial S->**** foi encontrada
		return (allLinesMatchRegex && initialProductionFound);
	}
	
	/**
	 * Esse método interpreta o texto da gramática retornando um objeto Grammar
	 * com todas as produções unitárias desta gramática.
	 * @param grammarText
	 * @return objeto {@link Grammar} preenchido com produções unitárias
	 */
	public static Grammar parsedGrammarFromText(String grammarText) {
		
		// Evitar gramática incorreta
		if (!grammarTextIsCorrect(grammarText)) {
			return null;
		}
		
		// Quebrar as linhas da gramática
		String[] productionTexts = grammarText.split("\n");
		Grammar grammar = new Grammar();
		
		// Interpretar cada uma das linhas
		for (int i = 0; i < productionTexts.length; i++) {

			// Separar cabeça e corpo
			String[] productionComponents = productionTexts[i].trim().split("->");
			String head = productionComponents[0].trim();
			
			// Separar múltiplos componentes do corpo
			String[] bodyComponents = productionComponents[1].trim().split("\\|");
			
			// Criar as produções para cada corpo
			for (int j = 0; j < bodyComponents.length; j++) {
				String body = bodyComponents[j].trim();
				grammar.addProduction(new Production(head, body));
			}
			
		}
		
		return grammar;
	}

}
