package lotrgame.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import lotrgame.model.Bestias;
import lotrgame.model.Heroes;
import lotrgame.model.Personaje;
import lotrgame.utils.EjercitoGenerator;
import lotrgame.utils.MyAlerta;

public class BatallaViewController implements Initializable {

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
    private JFXButton btn_reset;

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
    public final String RESULTADO_BATALLA = "Resultado Batalla";
    public final String PERSONAJES_ELIMINADOS = "Personajes Eliminados";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
	estadoBotones();
    }

    @FXML
    void onAcionBajarBestia(ActionEvent event) {
	// cambiar de posicion item seleccionado
	int index = lv_bestias.getSelectionModel().getSelectedIndex();
	if (index >= 0)
	    posicionarItem(index, BAJAR, lv_bestias.getItems().get(index));
    }

    @FXML
    void onAcionBajarHeroe(ActionEvent event) {
	int index = lv_heroes.getSelectionModel().getSelectedIndex();
	if (index >= 0)
	    posicionarItem(index, BAJAR, lv_heroes.getItems().get(index));

    }

    @FXML
    void onActionEliminarBestia(ActionEvent event) {
	int index = lv_bestias.getSelectionModel().getSelectedIndex();
	if (index >= 0)
	    eliminarPersonaje(index, lv_bestias.getItems().get(index));

    }

    @FXML
    void onActionEliminarHeroe(ActionEvent event) {
	int index = lv_heroes.getSelectionModel().getSelectedIndex();
	if (index >= 0)
	    eliminarPersonaje(index, lv_heroes.getItems().get(index));

    }

    @FXML
    void onActionLucha(ActionEvent event) {
	// iniciar batalla
	BATALLA_CONTROLLER.iniciarBatalla();
	
	updateListas();
	estadoBotones();

	// abrir ventana de lucha
	mostrarLucha();

    }

    @FXML
    void onActionSubirBestia(ActionEvent event) {
	int index = lv_bestias.getSelectionModel().getSelectedIndex();
	if (index >= 0)
	    posicionarItem(index, SUBIR, lv_bestias.getItems().get(index));

    }

    @FXML
    void onActionSubirHeroe(ActionEvent event) {
	int index = lv_heroes.getSelectionModel().getSelectedIndex();
	if (index >= 0)
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
	estadoBotones();

    }

    @FXML
    void onPerEliminados(ActionEvent event) {
	llamarResultado(BATALLA_CONTROLLER.getPersonajesEliminados(), PERSONAJES_ELIMINADOS);
	estadoBotones();

    }

    @FXML
    void onResultado(ActionEvent event) {
	llamarResultado(BATALLA_CONTROLLER.getBatalla(), RESULTADO_BATALLA);
    }

    @FXML
    void onReset(ActionEvent event) {
	MyAlerta alerta = new MyAlerta("Reset", "Se reiniciaran todos los valores", "¿Desea continuar?",
		AlertType.CONFIRMATION);

	Optional<ButtonType> result = alerta.mostrar();
	if (result.get() == MyAlerta.BTN_SI) {
	    // limpiar listas
	    lv_bestias.getItems().clear();
	    lv_heroes.getItems().clear();

	    // limpiar listas del controlador
	    BATALLA_CONTROLLER.getHeroes().clear();
	    BATALLA_CONTROLLER.getBestias().clear();
	    BATALLA_CONTROLLER.getBatalla().clear();
	    BATALLA_CONTROLLER.getPersonajesEliminados().clear();

	    estadoBotones();
	}

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

	    //con esta propiedad se actualiza la lista de personajes al cerrar la ventana
	    stage.showingProperty().addListener((obs, oldValue, newValue) -> {
		if (!newValue) {
		    updateListas();
		    estadoBotones();
		}
	    });

	    stage.showAndWait();

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public void updateListas() {
	// limpiar listas
	// lv_bestias.getItems().clear();
	// lv_heroes.getItems().clear();

	// recargar listas
	lv_bestias.setItems(BATALLA_CONTROLLER.getBestias());
	lv_heroes.setItems(BATALLA_CONTROLLER.getHeroes());

	lv_bestias.refresh();
	lv_heroes.refresh();

    }

    private void eliminarPersonaje(int index, Personaje personaje) {

	if (personaje instanceof Bestias) {
	    // ver si es necesario ya que se vuleve a cargar la lista desde el listview
	    if (lv_bestias.getSelectionModel().getSelectedItem() != null && !lv_bestias.getItems().isEmpty()) {
		Bestias bestia = (Bestias) personaje;
		BATALLA_CONTROLLER.eliminarBestia(bestia);
		lv_bestias.getItems().remove(index);
	    }
	} else {
	    if (lv_heroes.getSelectionModel().getSelectedItem() != null && !lv_heroes.getItems().isEmpty()) {
		Heroes heroe = (Heroes) personaje;
		BATALLA_CONTROLLER.eliminarHeroe(heroe);
		lv_heroes.getItems().remove(index);
	    }
	}

    }

    private void posicionarItem(int index, String accion, Personaje personaje) {

	if (accion.equals(SUBIR)) {
	    if (personaje instanceof Bestias) {
		if (index > 0) {
		    Bestias bestia = (Bestias) personaje;
		    lv_bestias.getItems().remove(index);
		    lv_bestias.getItems().add(index - 1, bestia);
		    lv_bestias.getSelectionModel().select(index - 1);
		    BATALLA_CONTROLLER.setBestias(lv_bestias.getItems());
		}
	    } else {
		if (index > 0) {
		    Heroes heroe = (Heroes) personaje;
		    lv_heroes.getItems().remove(index);
		    lv_heroes.getItems().add(index - 1, heroe);
		    lv_heroes.getSelectionModel().select(index - 1);
		    BATALLA_CONTROLLER.setHeroes(lv_heroes.getItems());
		}
	    }

	} else {
	    if (personaje instanceof Bestias) {
		Bestias bestia = (Bestias) personaje;
		if (index < lv_bestias.getItems().size() - 1) {
		    lv_bestias.getItems().remove(index);
		    lv_bestias.getItems().add(index + 1, bestia);
		    lv_bestias.getSelectionModel().select(index + 1);
		    BATALLA_CONTROLLER.setBestias(lv_bestias.getItems());
		}
	    } else {
		if (index < lv_heroes.getItems().size() - 1) {
		    Heroes heroe = (Heroes) personaje;
		    lv_heroes.getItems().remove(index);
		    lv_heroes.getItems().add(index + 1, heroe);
		    lv_heroes.getSelectionModel().select(index + 1);
		    BATALLA_CONTROLLER.setHeroes(lv_heroes.getItems());
		}
	    }
	}

    }

    public void estadoBotones() {
	boolean estado = false;

	btn_resultado.setDisable(estado);
	btn_lucha.setDisable(estado);
	btn_eliminados.setDisable(estado);
	btn_reset.setDisable(estado);
	btn_subir_b.setDisable(estado);
	btn_bajar_b.setDisable(estado);
	btn_eliminar_b.setDisable(estado);
	btn_subir_h.setDisable(estado);
	btn_bajar_h.setDisable(estado);
	btn_eliminar_h.setDisable(estado);

	if (BATALLA_CONTROLLER.getBatalla().isEmpty()) {
	    estado = true;
	    btn_resultado.setDisable(estado);
	}
	if (BATALLA_CONTROLLER.getPersonajesEliminados().isEmpty()) {
	    estado = true;
	    btn_eliminados.setDisable(estado);
	}
	if (BATALLA_CONTROLLER.getHeroes().isEmpty() || BATALLA_CONTROLLER.getBestias().isEmpty()) {
	    estado = true;
	    btn_lucha.setDisable(estado);
	}
	if (BATALLA_CONTROLLER.getHeroes().isEmpty() && BATALLA_CONTROLLER.getBestias().isEmpty()) {
	    estado = true;
	    btn_reset.setDisable(estado);
	}

	if (lv_bestias.getItems().isEmpty()) {
	    estado = true;
	    btn_subir_b.setDisable(estado);
	    btn_bajar_b.setDisable(estado);
	    btn_eliminar_b.setDisable(estado);
	}

	if (lv_heroes.getItems().isEmpty()) {
	    estado = true;
	    btn_subir_h.setDisable(estado);
	    btn_bajar_h.setDisable(estado);
	    btn_eliminar_h.setDisable(estado);
	}
    }

    public void llamarResultado(List<String> listado, String nombre) {
	// abrir ventana para mostrar resultado
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ResultadoView.fxml"));
	// cargar la ventana
	Parent resRoot = null;

	try {
	    resRoot = loader.load();
	    ResultadoViewController resultadoViewController = loader.getController();
	    resultadoViewController.cargarResultado(listado, nombre);

	    Scene scene = new Scene(resRoot);
	    scene.getStylesheets().add(getClass().getResource("/css/Resultado.css").toExternalForm());
	    Stage stage = new Stage();
	    stage.setTitle(RESULTADO_BATALLA);
	    stage.initOwner(rootPane.getScene().getWindow());
	    stage.initModality(Modality.APPLICATION_MODAL);
	    stage.setResizable(false);
	    stage.setIconified(false);
	    stage.setScene(scene);
	    stage.show();

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    private void mostrarLucha() {

	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ImagenBatalla.fxml"));

	try {

	    Parent iRoot = loader.load();
	    ImagenBatallaController imagenBatallaController = loader.getController();
	    imagenBatallaController.setBatallaController(BATALLA_CONTROLLER);
	    imagenBatallaController.setBatallaViewController(this);

	    Scene scene = new Scene(iRoot);
	    Stage stage = new Stage();
	    stage.setTitle("Lucha");
	    stage.initOwner(rootPane.getScene().getWindow());
	    stage.initModality(Modality.APPLICATION_MODAL);
	    stage.setResizable(false);
	    stage.setIconified(false);
	    stage.setScene(scene);
	    stage.show();
	    
	    //transicion para cerrar la ventana luego de 2 segundos
	    PauseTransition pause = new PauseTransition(Duration.seconds(2));
	    pause.setOnFinished(e -> stage.close());
	    pause.play();
	    
	    //al cerrar la ventana se llama a la ventas de resultado
	    stage.setOnHidden(e -> llamarResultado(BATALLA_CONTROLLER.getBatalla(), RESULTADO_BATALLA));
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}

    }

}
