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

public class AgregarPersonajesController {

    @FXML
    private JFXButton btn_agregar;

    @FXML
    private JFXComboBox<RazaPersonajes> cb_raza;

    @FXML
    private JFXRadioButton rb_bestias;

    @FXML
    private JFXRadioButton rb_heroes;

    @FXML
    private ToggleGroup tg_rb_tipo_personajes;

    @FXML
    private TextField txf_armadura;

    @FXML
    private TextField txf_nombre;

    @FXML
    private TextField txf_vida;

    private BatallaController batallaController;
    private BatallaViewController batallaViewController;

    public void setBatallaController(BatallaController batallaController) {
	this.batallaController = batallaController;
    }

    public void setBatallaViewController(BatallaViewController batallaViewController) {
	this.batallaViewController = batallaViewController;
    }

    @FXML
    void onSelectBestias(ActionEvent event) {
	// limpiar campos
	cb_raza.getItems().clear();
	// agregar listado bestias
	RazaPersonajes.getRazaBestias().forEach(cb_raza.getItems()::add);

    }

    @FXML
    void onSelectHeroes(ActionEvent event) {
	// limpiar campos
	cb_raza.getItems().clear();
	// agregar listado heroes
	RazaPersonajes.getRazaHeroes().forEach(cb_raza.getItems()::add);
    }

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

    }

    private void clearFields() {
	txf_nombre.clear();
	txf_vida.clear();
	txf_armadura.clear();
	cb_raza.getSelectionModel().clearSelection();
	tg_rb_tipo_personajes.getSelectedToggle().setSelected(false);
	txf_nombre.requestFocus();
    }

    private void volverMenu() {
	Stage stage = (Stage) btn_agregar.getScene().getWindow();
	stage.close();
	batallaViewController.updateListas();
	batallaViewController.estadoBotones();
    }

    private boolean checkCamposNumericos() {
	// chequear si los campos de armadura y vida son numericos
	if (!txf_vida.getText().matches("[0-9]+")) {
	    txf_vida.requestFocus();
	    return false;
	}else if(!txf_armadura.getText().matches("[0-9]+")) {
	    txf_armadura.requestFocus();
	    return false;
	}
	return true;

    }

    private void guardarHeroe() {
	// crear heroe
	Heroes newHeroe = Heroes.builder().nombre(txf_nombre.getText()).raza(cb_raza.getValue())
		.vida(Integer.parseInt(txf_vida.getText())).armadura(Integer.parseInt(txf_armadura.getText())).build();

	// agregar heroe a la lista de heroes
	batallaController.addHeroes(newHeroe);

	MyAlerta alerta = new MyAlerta("Personaje agregado", "Heroe agregado",
		"Se ha agregado un nuevo heroe, Agregar otro personaje?", Alert.AlertType.CONFIRMATION);

	Optional<ButtonType> result = alerta.mostrar();
	if (result.get() == MyAlerta.BTN_SI) {
	    clearFields();
	} else {
	    volverMenu();
	}
    }

    private void guardarBestia() {
	// crear bestia
	Bestias newBestia = Bestias.builder().nombre(txf_nombre.getText()).raza(cb_raza.getValue())
		.vida(Integer.parseInt(txf_vida.getText())).armadura(Integer.parseInt(txf_armadura.getText())).build();
	batallaController.addBestias(newBestia);
	MyAlerta alerta = new MyAlerta("Personaje agregado", "Bestia agregada",
		"Se ha agregado una nueva bestia, Agregar otro personaje?", Alert.AlertType.CONFIRMATION);
	Optional<ButtonType> result = alerta.mostrar();
	if (result.get() == MyAlerta.BTN_SI) {
	    clearFields();
	} else {
	    volverMenu();
	}
    }

}
