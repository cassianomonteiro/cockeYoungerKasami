package ct200.cyk.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import ct200.cyk.control.CYKParser;
import ct200.cyk.control.ExamplesFactory;
import ct200.cyk.control.GrammarParser;
import ct200.cyk.control.OutputFormatter;

/**
 * Sample Skeleton for "MainView.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 * @author cassiano
 * 
 **/
public class MainViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="comboExamples"
    private ComboBox<?> comboExamples; // Value injected by FXMLLoader

    @FXML // fx:id="cykTableTextArea"
    private TextArea cykTableTextArea; // Value injected by FXMLLoader

    @FXML // fx:id="evaluateButton"
    private Button evaluateButton; // Value injected by FXMLLoader

    @FXML // fx:id="grammarTextArea"
    private TextArea grammarTextArea; // Value injected by FXMLLoader
    
    @FXML // fx:id="resultLabel"
    private Label resultLabel; // Value injected by FXMLLoader

    @FXML // fx:id="testStringTextField"
    private TextField testStringTextField; // Value injected by FXMLLoader

    // Handler for ComboBox[fx:id="comboExamples"] onAction
    @FXML
    void comboExampleChanged(ActionEvent event) {
        // handle the event here
    	
    	String selectedExample = (String) comboExamples.getValue();
    	
    	// Inserir a gramática de exemplo na área de texto da gramática
    	grammarTextArea.setText(ExamplesFactory.getExample(selectedExample));
    	
    	// Inserir a string de teste de exemplo
    	testStringTextField.setText(ExamplesFactory.getTestString(selectedExample));
    	
    	// Executar handler
    	grammarTextChanged(null);
    }

    // Handler for Button[Button[id="evaluateButton", styleClass=button]] onMouseClicked
    @FXML
    void evaluateClicked(MouseEvent event) {
        // handle the event here

    	// Inicializar o CYKParser
    	CYKParser cykParser = new CYKParser(GrammarParser.parsedGrammarFromText(grammarTextArea.getText()));
    	String testString = testStringTextField.getText();
    	
    	// Verificar se a string pertence à linguagem executando o parser
    	if (cykParser.stringBelongsToLanguage(testString)) {
    		resultLabel.setText("String pertence à linguagem.");
    		resultLabel.setTextFill(Color.GREEN);
    	}
    	else {
    		resultLabel.setText("String não pertence à linguagem.");
    		resultLabel.setTextFill(Color.RED);
    	}
    	
    	// FIXME: retirar esta string dummy
		testString = "baaba";
		
		// Preencher a tabela CYK
		cykTableTextArea.setText(OutputFormatter.formattedCYKOutput(cykParser.cykTableForString(testString), testString));
    }

    // Handler for TextField[fx:id="grammarTextArea"] onKeyReleased
    @FXML
    void grammarTextChanged(KeyEvent event) {
    	
    	boolean grammarTextisCorrect = GrammarParser.grammarTextIsCorrect(grammarTextArea.getText());
    	
    	// Quando algo é digitado na gramática, ela deve ficar vermelha
    	// enquanto não estiver correta
    	if (grammarTextisCorrect) {
    		grammarTextArea.setStyle("-fx-text-fill: black;");
    	}
    	else {
    		grammarTextArea.setStyle("-fx-text-fill: red;");
    	}

    	// O botão "Avaliar" só fica desabilitado quando a gramática está incorreta
    	// ou quando a string de teste ainda não foi preenchida
		evaluateButton.setDisable(!grammarTextisCorrect || testStringTextField.getText().length() == 0);
    }

    // Handler for TextField[fx:id="testStringTextField"] onKeyReleased
    @FXML
    void testStringChanged(KeyEvent event) {
    	boolean grammarTextisCorrect = GrammarParser.grammarTextIsCorrect(grammarTextArea.getText());
    	
    	// O botão "Avaliar" só fica desabilitado quando a gramática está incorreta
    	// ou quando a string de teste ainda não foi preenchida
		evaluateButton.setDisable(!grammarTextisCorrect || testStringTextField.getText().length() == 0);
    }

    // Ignorados estes warning por causa de algum bug do eclipse
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() { 
        assert comboExamples != null : "fx:id=\"comboExamples\" was not injected: check your FXML file 'MainView.fxml'.";
    	assert cykTableTextArea != null : "fx:id=\"cykTableTextArea\" was not injected: check your FXML file 'MainView.fxml'.";
    	assert evaluateButton != null : "fx:id=\"evaluateButton\" was not injected: check your FXML file 'MainView.fxml'.";
    	assert grammarTextArea != null : "fx:id=\"grammarTextArea\" was not injected: check your FXML file 'MainView.fxml'.";
    	assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file 'MainView.fxml'.";
    	assert testStringTextField != null : "fx:id=\"testStringTextField\" was not injected: check your FXML file 'MainView.fxml'.";

    	// Initialize your logic here: all @FXML variables will have been injected

    	// Popular combo de exemplos
		ObservableList obList = FXCollections.observableArrayList(ExamplesFactory.getExamplesList());
    	comboExamples.getItems().clear();
    	comboExamples.setItems(obList);

    	// Botão "Avaliar" é desabilitado na inicialização
    	evaluateButton.setDisable(true);

    	// Mudar a fonte das caixas de texto
    	Font codeFont = Font.font(
    			"Courier New", 
    			FontWeight.BOLD, 
    			13);
		grammarTextArea.setFont(codeFont);
		cykTableTextArea.setFont(codeFont);
    	
    	// A área para digitar a gramática é inicializada com texto vermelho (incorreta)
		grammarTextArea.setStyle("-fx-text-fill: red;");
		
		// Deixar o label de resultado em negrito
    	resultLabel.setFont(Font.font(
    			resultLabel.getFont().getFamily(), 
    			FontWeight.BOLD, 
    			resultLabel.getFont().getSize()));
		
		// Iniciar com foco na área para digitar a gramática
    	Platform.runLater(new Runnable() {
			@Override
			public void run() {
		    	grammarTextArea.requestFocus();
			}
		});
    	
    }

}

