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
		// TODO: Verificar aqui se todas as produções estão corretamente formuladas
		return false;
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
