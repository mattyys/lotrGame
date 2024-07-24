package lotrgame.controller;

import java.util.Optional;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import lotrgame.model.Bestias;
import lotrgame.model.Heroes;
import lotrgame.model.RazaPersonajes;
import lotrgame.utils.MyAlerta;

/**
 * The Class AgregarPersonajesController.
 */
public class AgregarPersonajesController {

    /** The btn agregar. */
    @FXML
    private JFXButton btn_agregar;

    /** The cb raza. */
    @FXML
    private JFXComboBox<RazaPersonajes> cb_raza;

    /** The rb bestias. */
    @FXML
    private JFXRadioButton rb_bestias;

    /** The rb heroes. */
    @FXML
    private JFXRadioButton rb_heroes;

    /** The tg rb tipo personajes. */
    @FXML
    private ToggleGroup tg_rb_tipo_personajes;

    /** The txf armadura. */
    @FXML
    private TextField txf_armadura;

    /** The txf nombre. */
    @FXML
    private TextField txf_nombre;

    /** The txf vida. */
    @FXML
    private TextField txf_vida;

    /** The batalla controller. */
    private BatallaController batallaController;

    /** The batalla view controller. */
    private BatallaViewController batallaViewController;

    /**
     * Sets the batalla controller.
     *
     * @param batallaController the new batalla controller
     */
    public void setBatallaController(BatallaController batallaController) {
	this.batallaController = batallaController;
    }

    /**
     * Sets the batalla view controller.
     *
     * @param batallaViewController the new batalla view controller
     */
    public void setBatallaViewController(BatallaViewController batallaViewController) {
	this.batallaViewController = batallaViewController;
    }

    /**
     * On select bestias.
     * <p>
     * Al seleccionar carga la lista de Raza de Bestias en el comboBox.
     * </p>
     *
     * @param event the event
     */
    @FXML
    void onSelectBestias(ActionEvent event) {
	// limpiar campos
	cb_raza.getItems().clear();
	// agregar listado bestias
	RazaPersonajes.getRazaBestias().forEach(cb_raza.getItems()::add);

    }

    /**
     * On select heroes.
     * <p>
     * Al seleccionar carga la lista de Raza de Heroes en el comboBox.
     * </p>
     *
     * @param event the event
     */
    @FXML
    void onSelectHeroes(ActionEvent event) {
	// limpiar campos
	cb_raza.getItems().clear();
	// agregar listado heroes
	RazaPersonajes.getRazaHeroes().forEach(cb_raza.getItems()::add);
    }

    /**
     * On action agregar.
     * <p>
     * Chequea los campos de texto, si son numericos y si estan vacios, si no lo
     * estan chequea si es heroe o bestia y guarda el personaje en su
     * correspondiente lista.
     * </p>
     *
     * @param event the event
     */
    @FXML
    void onActionAgregar(ActionEvent event) {

	// chequear todos los campos
	if (txf_nombre.getText().isEmpty() || txf_vida.getText().isEmpty() || txf_armadura.getText().isEmpty()
		|| cb_raza.getSelectionModel().isEmpty() || tg_rb_tipo_personajes.getSelectedToggle() == null) {
	    return;
	} else {
	    if (checkCamposNumericos()) {
		// chequear si es heroe o bestia
		if (tg_rb_tipo_personajes.getSelectedToggle().equals(rb_heroes)) {
		    guardarHeroe();
		} else {
		    guardarBestia();
		}
	    } else {
		MyAlerta alerta = new MyAlerta("Error", "Campos numericos incorrectos",
			"Debe ingresar valores numericos en los campos de vida y/o armadura", Alert.AlertType.ERROR);
		alerta.mostrar();
	    }
	}
	batallaViewController.updateListas();

    }

    /**
     * Clear fields.
     * <p>
     * Limpia los campos de texto, la seleccion de raza y el tipo de personaje
     * </p>
     */
    private void clearFields() {
	txf_nombre.clear();
	txf_vida.clear();
	txf_armadura.clear();
	cb_raza.getSelectionModel().clearSelection();
	tg_rb_tipo_personajes.getSelectedToggle().setSelected(false);
	txf_nombre.requestFocus();
    }

    /**
     * Volver menu.
     * <p>
     * Vuelve al menu principal de la aplicacion, actualiza los estados de los
     * botones.
     * </p>
     */
    private void volverMenu() {
	Stage stage = (Stage) btn_agregar.getScene().getWindow();
	stage.close();
	batallaViewController.estadoBotones();
    }

    /**
     * Check campos numericos.
     * <p>
     * Chequea que los campos de Armadura y Vida sean numericos.
     * </p>
     *
     * @return true, if successful
     */
    private boolean checkCamposNumericos() {
	// chequear si los campos de armadura y vida son numericos
	if (!txf_vida.getText().matches("[0-9]+")) {
	    txf_vida.requestFocus();
	    return false;
	} else if (!txf_armadura.getText().matches("[0-9]+")) {
	    txf_armadura.requestFocus();
	    return false;
	}
	return true;

    }

    /**
     * Guardar heroe.
     * <p>
     * Guarda el heroe en la lista de heroes
     * </p>
     */
    private void guardarHeroe() {
	// crear heroe
	Heroes newHeroe = Heroes.builder().nombre(txf_nombre.getText()).raza(cb_raza.getValue())
		.vida(Integer.parseInt(txf_vida.getText())).armadura(Integer.parseInt(txf_armadura.getText())).build();

	// agregar heroe a la lista de heroes
	batallaController.addHeroes(newHeroe);

	MyAlerta alerta = new MyAlerta("Personaje agregado", "Heroe agregado",
		"Se ha agregado un nuevo heroe, Agregar otro personaje?", Alert.AlertType.CONFIRMATION);

	resultadoAlerta(alerta.mostrar());
    }

    /**
     * Guardar bestia.
     * <p>
     * Guarda la bestia en la lista de bestias
     * </p>
     */
    private void guardarBestia() {
	// crear bestia
	Bestias newBestia = Bestias.builder().nombre(txf_nombre.getText()).raza(cb_raza.getValue())
		.vida(Integer.parseInt(txf_vida.getText())).armadura(Integer.parseInt(txf_armadura.getText())).build();
	batallaController.addBestias(newBestia);
	MyAlerta alerta = new MyAlerta("Personaje agregado", "Bestia agregada",
		"Se ha agregado una nueva bestia, Agregar otro personaje?", Alert.AlertType.CONFIRMATION);

	resultadoAlerta(alerta.mostrar());
    }

    /**
     * Resultado alerta.
     * <p>
     * Chequea el resultado de la alerta de confirmacion, Si es "si" limpia los
     * campos y sino vuelve al menu.
     * </p>
     * 
     * @param result the result
     */
    private void resultadoAlerta(Optional<ButtonType> result) {
	if (result.get() == MyAlerta.BTN_SI) {
	    clearFields();
	} else {
	    volverMenu();
	}
    }

}
