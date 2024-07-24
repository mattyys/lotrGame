package lotrgame.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


/**
 * The Class ImagenBatallaController.
 */
public class ImagenBatallaController implements Initializable {

    /** The img imagen. */
    @FXML
    private ImageView img_imagen;

    /** The anchorpane root. */
    @FXML
    private AnchorPane apRoot;

    /** The batalla view controller. */
    BatallaViewController batallaViewController;
    
    /** The batalla controller. */
    BatallaController batallaController;

    /** The lista. */
    List<String> lista;
    
    /** The nombre. */
    String nombre;

    /**
     * Sets the batalla view controller.
     *
     * @param batallaViewController the new batalla view controller
     */
    public void setBatallaViewController(BatallaViewController batallaViewController) {
	this.batallaViewController = batallaViewController;

    }

    /**
     * Sets the batalla controller.
     *
     * @param batallaController the new batalla controller
     */
    public void setBatallaController(BatallaController batallaController) {
	this.batallaController = batallaController;
    }

    /**
     * Sets the lista.
     *
     * @param lista the new lista
     */
    public void setLista(List<String> lista) {
	this.lista = lista;

    }

    /**
     * Sets the nombre.
     *
     * @param nombre the new nombre
     */
    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    /**
     * Initialize.
     * 
     * Inicializa la imagen de la batalla
     *
     * @param location the location
     * @param resources the resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
	img_imagen.setImage(new Image("/video/pelea.gif"));

	
    }



}
