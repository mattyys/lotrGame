package lotrgame;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//TODO: Auto-generated Javadoc
/**
 * The Class AplicacionFx.
 * <p>
 * Clase que inicializa la aplicacion de la vista de la batalla.
 * </p>
 */
public class AplicacionFx extends Application {

    /**
     * Start.
     * <p>
     * En este método se carga el archivo FXML de la vista de la batalla y se
     * muestra en la ventana principal.
     * </p>
     * 
     * @param primaryStage the primary stage
     */
    @Override
    public void start(Stage primaryStage) {

	URL url = getClass().getResource("/fxml/BatallaView.fxml");
	Parent root = null;

	try {
	    root = FXMLLoader.load(url);
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new RuntimeException("No se pudo cargar el archivo FXML", e);
	}
	Scene scene = new Scene(root);
	scene.getStylesheets().add(getClass().getResource("/css/batallaView.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.setTitle("Lord of the Rings Game");
	primaryStage.show();

    }

    /**
     * The main method.
     * <p>
     * Llamada al metodo launch de la clase Application de JavaFX
     * </p>
     * 
     * @param args the arguments
     */
    public static void main(String[] args) {
	launch(args);
    }
}
