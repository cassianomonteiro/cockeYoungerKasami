package ct200.cyk.control;

import ct200.cyk.model.Grammar;

/**
 * Esta classe contém o algoritmo CYK.
 * @author cassiano
 *
 */
public class CYKParser {
	
	private Grammar grammar = null;
	private String lastTestedString = null;
	private boolean lastTestedStringBelongsToLanguage = false;
	private String[][] lastTestedStringCYKTable;
	
	/**
	 * @return the grammar
	 */
	public Grammar getGrammar() {
		return grammar;
	}

	/**
	 * @param grammar the grammar to set
	 */
	public void setGrammar(Grammar grammar) {
		this.grammar = grammar;
		this.lastTestedString = null;
		lastTestedStringBelongsToLanguage = false;
	}

	/**
	 * Construtor que inicializa com gramática
	 * @param grammar
	 * @param testString
	 */
	public CYKParser(Grammar grammar) {
		setGrammar(grammar);
	}
	
	/**
	 * Método para avaliar se a string em teste pertence à linguagem
	 * da gramática cadastrada.
	 * @param testString
	 */
	protected void performEvaluationForString(String testString) {
		// TODO Implementar algoritmo CYK aqui, preenchendo as variáveis
		// lastTestedString e lastTestedStringBelongsToLanguage
	}
	
	/**
	 * Método retornar se a string pertence à linguagem.
	 * @param testString
	 * @return <code><b>true<b><code> se a string em teste pertence à linguagem
	 */
	public boolean stringBelongsToLanguage(String testString) {
		// TODO Executar o método performEvaluationForString caso esta string
		// ainda não tenha sido avaliada
		// Retornar o valor da variável lastTestedStringBelongsToLanguage
		
		return false;
	}
	
	/**
	 * Método para retornar a tabela CYK utilizada para avaliar a string em teste
	 * @param testString
	 * @return a tabela CYK em formato String[linha][coluna]
	 */
	public String[][] cykTableForString(String testString) {
		// TODO Executar o método performEvaluationForString caso esta string
		// ainda não tenha sido avaliada
		// Retornar o valor da variável lastTestedStringCYKTable
		return null;
	}

}
