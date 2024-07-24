package lotrgame.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ImagenBatallaController implements Initializable {

    @FXML
    private ImageView img_imagen;

    @FXML
    private AnchorPane apRoot;

    BatallaViewController batallaViewController;
    BatallaController batallaController;

    List<String> lista;
    String nombre;

    public void setBatallaViewController(BatallaViewController batallaViewController) {
	this.batallaViewController = batallaViewController;

    }

    public void setBatallaController(BatallaController batallaController) {
	this.batallaController = batallaController;
    }

    public void setLista(List<String> lista) {
	this.lista = lista;

    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
	img_imagen.setImage(new Image("/video/pelea.gif"));

	
    }



}
