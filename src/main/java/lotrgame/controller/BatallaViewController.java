package lotrgame.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import lotrgame.model.Bestias;
import lotrgame.model.Heroes;
import lotrgame.model.RazaPersonajes;

public class BatallaViewController implements Initializable {


    @FXML
    private JFXButton btn;

    @FXML
    private JFXButton btn_agregar;

    @FXML
    private JFXButton btn_bajar_b;

    @FXML
    private JFXButton btn_bajar_h;

    @FXML
    private JFXButton btn_eliminar_b;

    @FXML
    private JFXButton btn_eliminar_h;

    @FXML
    private JFXButton btn_lucha;

    @FXML
    private JFXButton btn_subir_b;

    @FXML
    private JFXButton btn_subir_h;

    @FXML
    private JFXComboBox<RazaPersonajes> cb_raza;

    @FXML
    private JFXListView<Bestias> lv_bestias;

    @FXML
    private JFXListView<String> lv_detalle_lucha;

    @FXML
    private JFXListView<String> lv_eliminados;

    @FXML
    private JFXListView<Heroes> lv_heroes;

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
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	
    }

    
    @FXML
    void onAcionBajarBestia(ActionEvent event) {

    }

    @FXML
    void onAcionBajarHeroe(ActionEvent event) {

    }

    @FXML
    void onActionAgregar(ActionEvent event) {

    }

    @FXML
    void onActionEliminarBestia(ActionEvent event) {

    }

    @FXML
    void onActionEliminarHeroe(ActionEvent event) {

    }

    @FXML
    void onActionLucha(ActionEvent event) {

    }

    @FXML
    void onActionSubirBestia(ActionEvent event) {

    }

    @FXML
    void onActionSubirHeroe(ActionEvent event) {

    }



}


