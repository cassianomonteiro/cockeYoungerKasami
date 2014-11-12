package ct200.cyk.control;

import java.util.ArrayList;
import java.util.List;

import ct200.cyk.model.Grammar;
import ct200.cyk.model.Production;

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
		
		int strLenght = testString.length();
		List<Production> grammarProductionL = grammar.getProductions();
		
		if( strLenght == 0 )
		{
			// TODO test for empty string;
			return;
		}
		
		ArrayList< ArrayList< ArrayList<Production> > > cykMatrix = 
				new ArrayList< ArrayList< ArrayList<Production> > >();

		for( int i = 0; i < strLenght; ++i )
		{
			ArrayList< ArrayList<Production> > lineList = 
					new ArrayList<ArrayList<Production>>();
			cykMatrix.add( lineList );

			for( int j = 0; j < strLenght - i; ++j )
				lineList.add( new ArrayList<Production>() );
		}		

		/// base
		for( int i = 0; i < strLenght; i++ )
		{
			char strSymbol = testString.charAt( i );
			
			for( Production prod : grammarProductionL )
			{
				if( prod.getBody().contains( String.valueOf( strSymbol ) ) )
					cykMatrix.get( 0 ).get( i ).add( prod );
			}
		}
		
		/// inducao
		for( int i = 1; i < strLenght; ++i )
		{
			for( int j = 0; j < strLenght - i; ++j )
			{
				int leftI = i-1;
				/// leftJ é o proprio valor de j na iteração

				int rightI = 0;
				int rightJ = i+j;
				
				ArrayList<Production> cykCell = cykMatrix.get( i ).get( j );
				
				while( leftI >= 0 )
				{
					// seja o produto cartesiano { A,B } x { C, D } = {AC,AD, BC,BD }
					// onde:
					//  - o lado direito representa cabeças de produção
					//  - o lado esquerdo representa as possíveis produções das novas cabeças
					//  nas linhas superiores da matriz triangular
					//
					// leftList corresponde ao grupo mais a esquerda do produto
					// rightList corresponde ao grupo mais a direita do produto
					
					ArrayList<Production> leftList = cykMatrix.get( leftI ).get( j );
					ArrayList<Production> rightList = cykMatrix.get( rightI ).get( rightJ );
					
					for( Production leftProd : leftList )
					{
						String strLeft = leftProd.getHead();
						
						for( Production rightProd : rightList )
						{
							String prod = strLeft + rightProd.getHead();
							
							for( Production candidateProduction : grammarProductionL )
							{
								if( candidateProduction.getBody().matches( prod )  )
								{
									boolean match = false;
									
									for( Production p: cykCell )
									{
										if( p.getHead().matches( candidateProduction.getHead() ) )
										{
											match = true;
											break;
										}
									}
									
									if( match == false ) cykCell.add( candidateProduction );
								}
							}
						}
					}

					++rightI; --rightJ; --leftI;
				}
			}
		}
		
		// Inicialização da matriz de strings a ser impressa
		lastTestedStringCYKTable = new String[strLenght][strLenght];
		for (int i = 0; i < lastTestedStringCYKTable.length; i++) {
			for (int j = 0; j < lastTestedStringCYKTable[i].length; j++) {
				lastTestedStringCYKTable[i][j] = "";
			}
		}
		
		for( int i = 0; i < strLenght; ++i )
		{
			for( int j = 0; j < strLenght - i; ++j )
			{
				ArrayList<Production> prodList = cykMatrix.get( i ).get( j );

				if( prodList.size() > 1 )
				{
					System.out.print( "{ " + prodList.get( 0 ).getHead() );
					lastTestedStringCYKTable[i][j] = "{" + prodList.get( 0 ).getHead();

					for( int k = 1; k < prodList.size(); ++k ) {
						System.out.print( "," + prodList.get( k ).getHead() );
						lastTestedStringCYKTable[i][j] += "," + prodList.get( k ).getHead();
					}
					
					System.out.print( " } " ); 
					lastTestedStringCYKTable[i][j] += "}";
				}
				else if( prodList.size() == 1 ) {
					System.out.print( "{ " + prodList.get( 0 ).getHead() + " } " );

					lastTestedStringCYKTable[i][j] = "{" +  prodList.get( 0 ).getHead() + "} ";
				}
				else {
					System.out.print( "{} " );
					lastTestedStringCYKTable[i][j] = "{}";
				}
			}
			
			System.out.println();
		}
		
		// TODO: Verificar se é isto mesmo. A string pertence à linguagem se a última iteração for diferente de {}?
		lastTestedStringBelongsToLanguage = !lastTestedStringCYKTable[strLenght-1][0].equals("{}");
		
		lastTestedString = testString;
	}
	
	/**
	 * Método retornar se a string pertence à linguagem.
	 * @param testString
	 * @return <code><b>true<b><code> se a string em teste pertence à linguagem
	 */
	public boolean stringBelongsToLanguage(String testString) {

		if (lastTestedString==null || !lastTestedString.equals(testString))
			performEvaluationForString(testString);

		return lastTestedStringBelongsToLanguage;
	}
	
	/**
	 * Método para retornar a tabela CYK utilizada para avaliar a string em teste
	 * @param testString
	 * @return a tabela CYK em formato String[linha][coluna]
	 */
	public String[][] cykTableForString(String testString) {
		
		if (lastTestedString==null || !lastTestedString.equals(testString))
			performEvaluationForString(testString);

		return lastTestedStringCYKTable;
	}

}
