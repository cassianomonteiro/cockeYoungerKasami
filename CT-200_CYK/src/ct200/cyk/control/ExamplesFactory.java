/**
 * 
 */
package ct200.cyk.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Classe de produção de exemplos de gramática para rodar o algoritmo CYK
 * @author cassiano
 *
 */
public class ExamplesFactory {
	
	// Variável estática contendo um mapa de nomes e conteúdos de exemplos
	private static HashMap<String,String> examplesMap = new HashMap<String, String>();
	
	// Variável estática contendo um mapa de strings de teste para os exemplos
	private static HashMap<String,String> testStringsMap = new HashMap<String, String>();
	
	/**
	 * Método para retornar a lista de exemplos disponíveis a partir do Mapa de Exemplos
	 * @return
	 */
	public static List<String >getExamplesList() {
		createExamplesMap();
		
		// Obter lista de nomes de exemplos (keys do HashMap) em ordem alfabética
		List<String> examplesList = new ArrayList<String>(examplesMap.keySet());
		Collections.sort(examplesList);
		
		return examplesList;
	}
	
	/**
	 * Método para retornar o conteúdo de um exemplo localizado no índice desejado
	 * do mapa de exemplos
	 * @param example
	 * @return
	 */
	public static String getExample(String example) {
		createExamplesMap();
		return examplesMap.get(example);
	}

	/**
	 * Método para retornar a string de teste de um exemplo localizado no índice desejado
	 * do mapa de string de testes
	 * @param example
	 * @return
	 */
	public static String getTestString(String example) {
		createTestStringsMap();
		return testStringsMap.get(example);
	}
	
	/**
	 * Método para preencher o mapa de exemplos, caso ele ainda esteja vazio
	 */
	private static void createExamplesMap() {
		
		if (examplesMap.size() == 0) {
			
			examplesMap.put("Exemplo Aula 10", "S->XZ|XB\n" + 
										 	   "X->AW|AX|A\n" +
										 	   "Y->ST|SB|BS|BB|AW|AX|A\n" +
										 	   "Z->SY\n" +
										 	   "W->XS\n" +
										 	   "T->YS\n" +
										 	   "A->a\n" +
											   "B->b\n");
			
			examplesMap.put("Exemplo Exercício 5", "S->SX|TY|GZ|a|b|VA|VB|VC|VD\n" +
										 		   "T->TY|GZ|a|b|VA|VB|VC|VD\n" +
										 		   "U->GZ|a|b|VA|VB|VC|VD\n" +
										 		   "V->a|b|VA|VB|VC|VD\n" +
										 		   "X->ET\n" +
										 		   "Y->FU\n" +
										 		   "Z->SH\n" +
										 		   "A->a\n" +
										 		   "B->b\n" +
										 		   "C->c\n" +
										 		   "D->d\n" +
										 		   "E->e\n" +
										 		   "F->f\n" +
										 		   "G->g\n" +
												   "H->h\n");
			
			examplesMap.put("Exemplo 3", "S->C");
			
			examplesMap.put("Exemplo 4", "S->D");
			
			examplesMap.put("Exemplo 5", "S->E");
			
			examplesMap.put("Exemplo 6", "S->F");
		}
	}

	/**
	 * Método para preencher o mapa de string de testes, caso ele ainda esteja vazio
	 */
	private static void createTestStringsMap() {
		
		if (testStringsMap.size() == 0) {
			testStringsMap.put("Exemplo Aula 10", "abb");
			testStringsMap.put("Exemplo Exercício 5", "aeafa");
			testStringsMap.put("Exemplo 3", "abb");
			testStringsMap.put("Exemplo 4", "abb");
			testStringsMap.put("Exemplo 5", "abb");
			testStringsMap.put("Exemplo 6", "abb");
		}
	}

}
