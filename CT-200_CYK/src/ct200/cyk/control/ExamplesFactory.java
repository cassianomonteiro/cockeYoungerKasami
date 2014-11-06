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
	 * @param index
	 * @return
	 */
	public static String getExample(String example) {
		createExamplesMap();
		return examplesMap.get(example);
	}
	
	/**
	 * Método para preencher o mapa de exemplos, caso ele ainda esteja vazio
	 */
	private static void createExamplesMap() {
		
		if (examplesMap.size() == 0) {
			
			examplesMap.put("Exemplo 1", "S->A");
			
			examplesMap.put("Exemplo 2", "S->B");
			
			examplesMap.put("Exemplo 3", "S->C");
			
			examplesMap.put("Exemplo 4", "S->D");
			
			examplesMap.put("Exemplo 5", "S->E");
			
			examplesMap.put("Exemplo 6", "S->F");
		}
	}

}
