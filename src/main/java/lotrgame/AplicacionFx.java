package lotrgame;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AplicacionFx extends Application {

	@Override
	public void start(Stage primaryStage) {
	    
	    URL url = getClass().getResource("/fxml/BatallaView.fxml");
	    System.out.println("Ruta pincipal: " + url);
	    Parent root = null;
	    
	    try{
		root = FXMLLoader.load(url);
	    }catch(Exception e) {
		e.printStackTrace();
		throw new RuntimeException("No se pudo cargar el archivo FXML", e);
	    }
	    root.getStylesheets().add("/css/batallaView.css");
	    Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Lord of the Rings Game");
	    primaryStage.show();		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
