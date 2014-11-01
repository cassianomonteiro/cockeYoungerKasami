package ct200.cyk;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Classe de execução principal do aplicativo CYK.
 * @author cassiano
 *
 */
public class MainApp extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Carregar a view principal e exibir em uma janela 800x600
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("view/MainView.fxml"));
			Scene scene = new Scene(root,800,600);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
