package ct200.cyk.control;

import java.util.Arrays;

/**
 * Classe para formatar o resultado do algoritmo CYK para ser exibido na interface
 * @author cassiano
 *
 */
public class OutputFormatter {

	/**
	 * Este método recebe o resultado do algoritmo CYK e formata para exibição na tela
	 * @param cykTable String[linha][coluna]: linha zero é a primeira iteração do CYK, 
	 * 			coluna zero é o referente ao primeiro caractere da string de teste
	 * @param testString
	 * @return String em formato de tabela do resultado do CYK
	 */
	public static String formattedCYKOutput(String[][] cykTable, String testString) {
		String cykOutput = "";
		
		// Evitar erro de tabela vazia
		if (cykTable == null) {
			return cykOutput;
		}
		
		// Obter tamanhos de cada coluna
		int columnSizes[] = new int[cykTable[0].length];
		
		// Loop para obter o tamanho máximo de cada coluna
		// Percorrer as linhas
		for (int i = 0; i < cykTable.length; i++) {
			
			// Iteração nas colunas
			for (int j = 0; j < cykTable[i].length; j++) {
				if (cykTable[i][j].length() > columnSizes[j]) {
					columnSizes[j] = cykTable[i][j].length();
				}
			}
			
		}
		
		// Loop para preenchimento do output com os valores da tabela
		// Iteração nas linhas em ordem reversa para imprimir primeiro as últimas iterações do algoritmo CYK
		for (int i = cykTable.length-1; i >= 0; i--) {
			
			// Iteração nas colunas
			for (int j = 0; j < cykTable[i].length; j++) {
				cykOutput += centralizedSymbol(cykTable[i][j], columnSizes[j]);
				
				// Inserir separador de coluna
				if (j != cykTable[i].length - 1) {
					cykOutput += "|";
				}
			}
			
			// Inserir quebra de linha
			cykOutput = cykOutput + "\n";
		}
		
		// Inserir separador horizontal (separar tabela da string de teste)
		// fazendo uma iteração nas colunas
		for (int j = 0; j < cykTable[0].length; j++) {
			cykOutput += getSeparatorWithLenght(columnSizes[j]);
			// Inserir separador de coluna
			if (j != cykTable[0].length - 1) {
				cykOutput += "|";
			}
		}

		// Inserir quebra de linha
		cykOutput = cykOutput + "\n";
		
		// Inserir caracteres da string de teste
		// fazendo uma iteração nas colunas
		for (int j = 0; j < testString.length(); j++) {
			cykOutput += centralizedSymbol(testString.substring(j, j+1), columnSizes[j]);
			// Inserir separador de coluna
			if (j != testString.length() - 1) {
				cykOutput += "|";
			}
		}
		
		return cykOutput;
	}
	
	
	/**
	 * Este método centraliza o símbolo de acordo com o comprimento de string desejado.
	 * @param symbol
	 * @param length
	 * @return
	 */
	protected static String centralizedSymbol(String symbol, int length) {
		
		// Calcular quantos caracteres "espaço" devem ser preenchidos
		int spacesRemaining = length - symbol.length();
		
		char[] leftPad = new char[spacesRemaining/2];		// Metade do número de espaços arredondado para baixo vai à esquerda 
		char[] rightPad = new char[(spacesRemaining+1)/2];	// Metade do número de espaços arredondado para cima vai à direita
		
		// Preencher os arrays de char com caractere "espaço"
		Arrays.fill(leftPad, ' ');
		Arrays.fill(rightPad, ' ');
		
		// Retornar as strings concatenadas
		return ((new String(leftPad)) + symbol + (new String(rightPad)));
	}
	
	/**
	 * Este método cria um separador com o número de underscores requisitado
	 * @param lenght
	 * @return String formada por underscores
	 */
	protected static String getSeparatorWithLenght(int lenght) {

		// Criar array de char
		char[] separator = new char[lenght];		// Metade do número de espaços arredondado para baixo vai à esquerda 
		
		// Preencher os arrays de char com caractere "underscore"
		Arrays.fill(separator, '_');
		
		// Retornar uma string preenchida com o array de char
		return new String(separator);
	}
}
