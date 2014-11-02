package ct200.cyk.control;

import ct200.cyk.model.Grammar;

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
		
		// Regular expression que encontra produções do tipo A -> Ba
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
		// TODO: Criar aqui o objeto grammar com a lista de produções a partir do texto
		return null;
	}

}
