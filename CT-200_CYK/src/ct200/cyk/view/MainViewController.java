package ct200.cyk.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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

    @FXML // fx:id="cykTableTextArea"
    private TextArea cykTableTextArea; // Value injected by FXMLLoader

    @FXML // fx:id="grammarTextArea"
    private TextArea grammarTextArea; // Value injected by FXMLLoader
    
    @FXML // fx:id="resultLabel"
    private Label resultLabel; // Value injected by FXMLLoader

    @FXML // fx:id="testStringTextField"
    private TextField testStringTextField; // Value injected by FXMLLoader

    // Handler for Button[Button[id=null, styleClass=button]] onMouseClicked
    @FXML
    void evaluateClicked(MouseEvent event) {
        // handle the event here
    	
    	Font boldFont = Font.font(
    			resultLabel.getFont().getFamily(), 
    			FontWeight.BOLD, 
    			resultLabel.getFont().getSize());
    	
    	resultLabel.setText("Não pertence à linguagem.");
    	resultLabel.setFont(boldFont);
    	resultLabel.setTextFill(Color.RED);
    	
    	cykTableTextArea.setText(
    			"It works!\n" +
    			"Grammar: " + grammarTextArea.getText() + "\n" +
    			"Test String: " + testStringTextField.getText());
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cykTableTextArea != null : "fx:id=\"cykTableTextArea\" was not injected: check your FXML file 'MainView.fxml'.";
        assert grammarTextArea != null : "fx:id=\"grammarTextArea\" was not injected: check your FXML file 'MainView.fxml'.";
        assert testStringTextField != null : "fx:id=\"testStringTextField\" was not injected: check your FXML file 'MainView.fxml'.";

        // Initialize your logic here: all @FXML variables will have been injected
    }

}

