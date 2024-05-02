/**
 * 
 * @author Varun Shah
 *
 */
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.MainController;
/**
 *  This is the driver class to invoke the launch() method. 
 *
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/MainView.fxml")); 
		HBox hbox = new HBox();
		VBox vbox = new VBox();
		BorderPane borderPane = new BorderPane();
		AnchorPane root = (AnchorPane) loader.load();
		MainController controller = loader.getController();
		controller.start(primaryStage);
		Scene scene = new Scene(root);
		primaryStage.setTitle("Tuition Manager GUI");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}
	/**
	 *  @param args launch()
	 *
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
