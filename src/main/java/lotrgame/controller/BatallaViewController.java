package lotrgame.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lotrgame.model.Bestias;
import lotrgame.model.Heroes;
import lotrgame.model.Personaje;
import lotrgame.utils.EjercitoGenerator;

public class BatallaViewController {

    @FXML
    private JFXButton btn_addPersonajes;

    @FXML
    private JFXButton btn_bajar_b;

    @FXML
    private JFXButton btn_bajar_h;

    @FXML
    private JFXButton btn_ejercitos;

    @FXML
    private JFXButton btn_eliminados;

    @FXML
    private JFXButton btn_eliminar_b;

    @FXML
    private JFXButton btn_eliminar_h;

    @FXML
    private JFXButton btn_lucha;

    @FXML
    private JFXButton btn_resultado;

    @FXML
    private JFXButton btn_subir_b;

    @FXML
    private JFXButton btn_subir_h;

    @FXML
    private JFXListView<Bestias> lv_bestias;

    @FXML
    private JFXListView<Heroes> lv_heroes;

    @FXML
    private BorderPane rootPane;

    private final BatallaController BATALLA_CONTROLLER = new BatallaController();

    private final String SUBIR = "Subir";
    private final String BAJAR = "Bajar";

    @FXML
    void onAcionBajarBestia(ActionEvent event) {
	// cambiar de posicion item seleccionado
	int index = lv_bestias.getSelectionModel().getSelectedIndex();
	posicionarItem(index, BAJAR, lv_bestias.getItems().get(index));
    }

    @FXML
    void onAcionBajarHeroe(ActionEvent event) {
	int index = lv_heroes.getSelectionModel().getSelectedIndex();
	posicionarItem(index, BAJAR, lv_heroes.getItems().get(index));

    }

    @FXML
    void onActionEliminarBestia(ActionEvent event) {
	int index = lv_bestias.getSelectionModel().getSelectedIndex();
	eliminarPersonaje(index, lv_bestias.getItems().get(index));

    }

    @FXML
    void onActionEliminarHeroe(ActionEvent event) {
	int index = lv_heroes.getSelectionModel().getSelectedIndex();
	eliminarPersonaje(index, lv_heroes.getItems().get(index));

    }

    @FXML
    void onActionLucha(ActionEvent event) {

    }

    @FXML
    void onActionSubirBestia(ActionEvent event) {
	int index = lv_bestias.getSelectionModel().getSelectedIndex();
	posicionarItem(index, SUBIR, lv_bestias.getItems().get(index));

    }

    @FXML
    void onActionSubirHeroe(ActionEvent event) {
	int index = lv_heroes.getSelectionModel().getSelectedIndex();
	posicionarItem(index, SUBIR, lv_heroes.getItems().get(index));
    }

    @FXML
    void onCargarEjercitos(ActionEvent event) {
	// cargar ejercitos
	EjercitoGenerator ejercitoGenerator = new EjercitoGenerator();
	
	BATALLA_CONTROLLER.getHeroes().addAll(ejercitoGenerator.getHeroesBasico());
	BATALLA_CONTROLLER.getBestias().addAll(ejercitoGenerator.getBestiasBasico());

	// actualizar listas
	updateListas();

    }

    @FXML
    void onPerEliminados(ActionEvent event) {

    }

    @FXML
    void onResultado(ActionEvent event) {

    }

    @FXML
    void openAgrPersonajes(ActionEvent event) {
	// abrir ventana para agregar personajes
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AgregarPersonajes.fxml"));
	// cargar la ventana
	try {
	    // cargar controlador
	    Parent apRoot = loader.load();

	    AgregarPersonajesController agregarPersonajesController = loader.getController();
	    agregarPersonajesController.setBatallaController(BATALLA_CONTROLLER);
	    agregarPersonajesController.setBatallaViewController(this);

	    Scene scene = new Scene(apRoot);
	    scene.getStylesheets().add(getClass().getResource("/css/AddPersonajes.css").toExternalForm());
	    Stage stage = new Stage();
	    stage.setTitle("Agregar Personajes");
	    stage.initOwner(rootPane.getScene().getWindow());
	    stage.initModality(Modality.APPLICATION_MODAL);
	    stage.setResizable(false);
	    stage.setIconified(false);
	    stage.setScene(scene);
	    stage.showAndWait();

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public void updateListas() {
	// limpiar listas
	lv_bestias.getItems().clear();
	lv_heroes.getItems().clear();
	// recargar listas
	lv_bestias.getItems().addAll(BATALLA_CONTROLLER.getBestias());
	lv_heroes.getItems().addAll(BATALLA_CONTROLLER.getHeroes());
	
	lv_bestias.refresh();
	lv_heroes.refresh();

    }

    private void eliminarPersonaje(int index, Personaje personaje) {
	if (personaje instanceof Bestias) {
	    // ver si es necesario ya que se vuleve a cargar la lista desde el listview
	    Bestias bestia = (Bestias) personaje;
	    BATALLA_CONTROLLER.eliminarBestia(bestia);
	    lv_bestias.getItems().remove(index);
	} else {
	    Heroes heroe = (Heroes) personaje;
	    BATALLA_CONTROLLER.eliminarHeroe(heroe);
	    lv_heroes.getItems().remove(index);
	}
    }

    private void posicionarItem(int index, String accion, Personaje personaje) {
	if (accion.equals(SUBIR)) {
	    if (personaje instanceof Bestias) {
		Bestias bestia = (Bestias) personaje;
		lv_bestias.getItems().remove(index);
		lv_bestias.getItems().add(index - 1, bestia);
		lv_bestias.getSelectionModel().select(index - 1);
		BATALLA_CONTROLLER.setBestias(lv_bestias.getItems());
	    } else {
		Heroes heroe = (Heroes) personaje;
		lv_heroes.getItems().remove(index);
		lv_heroes.getItems().add(index - 1, heroe);
		lv_heroes.getSelectionModel().select(index - 1);
		BATALLA_CONTROLLER.setHeroes(lv_heroes.getItems());
	    }

	} else {
	    if (personaje instanceof Bestias) {
		Bestias bestia = (Bestias) personaje;
		lv_bestias.getItems().remove(index);
		lv_bestias.getItems().add(index + 1, bestia);
		lv_bestias.getSelectionModel().select(index + 1);
		BATALLA_CONTROLLER.setBestias(lv_bestias.getItems());
	    } else {
		Heroes heroe = (Heroes) personaje;
		lv_heroes.getItems().remove(index);
		lv_heroes.getItems().add(index + 1, heroe);
		lv_heroes.getSelectionModel().select(index + 1);
		BATALLA_CONTROLLER.setHeroes(lv_heroes.getItems());
	    }
	}

    }

}
