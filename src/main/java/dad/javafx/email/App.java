package dad.javafx.email;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
	
	private static Stage primaryStage;
	private Controller controller;

	public void start(Stage primaryStage) throws Exception {
		
		App.primaryStage = primaryStage;
		controller = new Controller();
		
		Scene scene = new Scene(controller.getView());
		
		primaryStage.setTitle("Enviar Email");
		primaryStage.getIcons().add(new Image("/images/email-send-icon-32x32.png"));
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	public static void error(String header, String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.initOwner(primaryStage);
		alert.setTitle("Error");
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
	
	public static void info(String title, String header, String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.initOwner(primaryStage);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
	public static void main(String[] args) {
		launch(args);
	}

}