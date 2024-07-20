package lotrgame.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ImagenBatallaController implements Initializable {

    @FXML
    private ImageView img_imagen;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
	img_imagen.setImage(new Image("/video/pelea.gif"));

	cerrarVentana();

    }

    private void cerrarVentana() {
	try {
	    Thread.sleep(5000);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	Stage stage = (Stage) img_imagen.getScene().getWindow();
	stage.close();
    }

}
