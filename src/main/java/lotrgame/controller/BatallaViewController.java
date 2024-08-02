package lotrgame.controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
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

// TODO: Auto-generated Javadoc
/**
 * The Class BatallaViewController.
 * <p>
 * Clase controladora de la vista principal, se encarga de manejar la logica de
 * la aplicacion. Controla los eventos de los botones y la interaccion con las
 * listas de heroes y bestias.
 * </p>
 */
public class BatallaViewController implements Initializable {

    /**
     * The btn add personajes.
     * <p>
     * Boton que llama a la ventana para agregar personajes
     * </p>
     */
    @FXML
    private JFXButton btn_addPersonajes;

    /**
     * The btn bajar b.
     * <p>
     * Boton para bajar una posicion el item seleccionado de la lista de bestias.
     * </p>
     */
    @FXML
    private JFXButton btn_bajar_b;

    /**
     * The btn bajar h.
     * <p>
     * Boton para bajar una posicion el item seleccionado de la lista de heroes.
     * </p>
     */
    @FXML
    private JFXButton btn_bajar_h;

    /**
     * The btn ejercitos.
     * <p>
     * Boton para cargar ejercitos predefinidos de heroes y bestias.
     * </p>
     */
    @FXML
    private JFXButton btn_ejercitos;

    /**
     * The btn eliminados.
     * <p>
     * Boton que llama a la ventanaque muestra la lista de los personajes
     * eliminados.
     * </p>
     */
    @FXML
    private JFXButton btn_eliminados;

    /**
     * The btn eliminar b.
     * <p>
     * Boton para eliminar el item seleccionado de la lista de bestias.
     * </p>
     */
    @FXML
    private JFXButton btn_eliminar_b;

    /**
     * The btn eliminar h.
     * <p>
     * Boton para eliminar el item seleccionado de la lista de heroes.
     * </p>
     */
    @FXML
    private JFXButton btn_eliminar_h;

    /**
     * The btn lucha.
     * <p>
     * Boton que inicia la batalla, y llama a la ventana de lucha y resultado.
     * </p>
     */
    @FXML
    private JFXButton btn_lucha;

    /**
     * The btn reset.
     * <p>
     * Boton utilizado para reiniciar los valores de todas las listas y datos de la
     * batalla.
     * </p>
     */
    @FXML
    private JFXButton btn_reset;

    /**
     * The btn resultado.
     * <p>
     * Boton que llama a la ventana que muestra el resultado de la batalla.
     * </p>
     */
    @FXML
    private JFXButton btn_resultado;

    /**
     * The btn subir b.
     * <p>
     * Boton para subir una posicion el item seleccionado de la lista de bestias.
     * </p>
     */
    @FXML
    private JFXButton btn_subir_b;

    /**
     * The btn subir h.
     * <p>
     * Boton para subir una posicion el item seleccionado de la lista de heroes.
     * </p>
     */
    @FXML
    private JFXButton btn_subir_h;

    /**
     * The lv bestias.
     * <p>
     * Listview que muestra el listado de bestias.
     * </p>
     */
    @FXML
    private JFXListView<Bestias> lv_bestias;

    /**
     * The lv heroes.
     * <p>
     * ListView que muestra el listado de heroes.
     * </p>
     **/
    @FXML
    private JFXListView<Heroes> lv_heroes;

    /**
     * The root pane.
     * <p>
     * Panel principal de la vista.
     * </p>
     */
    @FXML
    private BorderPane rootPane;

    /**
     * The batalla controller.
     * <p>
     * Crea una instancia de la clase BatallaController encaragada de manejar la
     * logica de la aplicacion(batalla).
     * </p>
     */
    private final BatallaController BATALLA_CONTROLLER = new BatallaController();

    /**
     * The subir.
     * <p>
     * Constante para subir una posicion el item seleccionado de la lista, se
     * utiliza para verificar que boton se presiono.
     * </p>
     */
    private final String SUBIR = "Subir";

    /**
     * The bajar.
     * <p>
     * Constante para bajar una posicion el item seleccionado de la lista, se
     * utiliza para verificar que boton se presiono.
     * </p>
     */
    private final String BAJAR = "Bajar";

    /**
     * The resultado batalla.
     * <p>
     * Constatnte que guarda el nombre de la ventana de resultado de la batalla.
     * </p>
     */
    public final String RESULTADO_BATALLA = "Resultado Batalla";

    /**
     * The personajes eliminados.
     * <p>
     * Constante que guarda el nombre de la ventana de personajes eliminados.
     * </p>
     */
    public final String PERSONAJES_ELIMINADOS = "Personajes Eliminados";

    /**
     * Initialize.
     * <p>
     * Al cargar la ventana se inicializan los valores de los botones. Si estan
     * habilitados o no, chequeando las listyas disponibles.
     * </p>
     *
     * @param location  the location
     * @param resources the resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
	// inicializa estado de los botones
	estadoBotones();
    }

    /**
     * On acion bajar bestia.
     * <p>
     * Al pulsar sobre el boton baja una posicion el item de la lista Bestias.
     * </p>
     *
     * @param event the event
     */
    @FXML
    void onAcionBajarBestia(ActionEvent event) {
	// cambiar de posicion item seleccionado
	int index = lv_bestias.getSelectionModel().getSelectedIndex();
	if (index >= 0)
	    posicionarItem(index, BAJAR, lv_bestias.getItems().get(index));
    }

    /**
     * On acion bajar heroe.
     * <p>
     * Al pulsar sobre el boton baja una posicion el item de la lista Heroes.
     * </p>
     *
     * @param event the event
     */
    @FXML
    void onAcionBajarHeroe(ActionEvent event) {
	int index = lv_heroes.getSelectionModel().getSelectedIndex();
	if (index >= 0)
	    posicionarItem(index, BAJAR, lv_heroes.getItems().get(index));

    }

    /**
     * On action eliminar bestia.
     * <p>
     * Al pulsar sobre el boton elimina el item seleccionado de la lista Bestia.
     * </p>
     *
     * @param event the event
     */
    @FXML
    void onActionEliminarBestia(ActionEvent event) {
	int index = lv_bestias.getSelectionModel().getSelectedIndex();
	if (index >= 0)
	    eliminarPersonaje(index, lv_bestias.getItems().get(index));

    }

    /**
     * On action eliminar heroe.
     * <p>
     * Al pulsar sobre el boton elimina el item seleccionado de la lista Heroe.
     * </p>
     *
     * @param event the event
     */
    @FXML
    void onActionEliminarHeroe(ActionEvent event) {
	int index = lv_heroes.getSelectionModel().getSelectedIndex();
	if (index >= 0)
	    eliminarPersonaje(index, lv_heroes.getItems().get(index));
    }

    /**
     * On action lucha.
     * <p>
     * Al pulsar sobre el boton inicia la batalla, actualiza listas, estados de
     * botones y muestra ventana con gif de lucha y resultado
     * </p>
     *
     * @param event the event
     */
    @FXML
    void onActionLucha(ActionEvent event) {
	// iniciar batalla
	BATALLA_CONTROLLER.iniciarBatalla();

	// actualizan listaS
	updateListas();

	// actualizar estado de los botones
	estadoBotones();

	// abrir ventana de lucha
	mostrarLucha();

    }

    /**
     * On action subir bestia.
     * <p>
     * Al pulsar sobre el boton Sube una posicion el item seleccionado de la lista
     * de Bestias.
     * </p>
     *
     * @param event the event
     */
    @FXML
    void onActionSubirBestia(ActionEvent event) {
	int index = lv_bestias.getSelectionModel().getSelectedIndex();
	if (index >= 0)
	    posicionarItem(index, SUBIR, lv_bestias.getItems().get(index));

    }

    /**
     * On action subir heroe.
     * <p>
     * Al pulsar sobre el boton sube una posicion el item seleccionado de la lista
     * Heroes.
     * </p>
     *
     * @param event the event
     */
    @FXML
    void onActionSubirHeroe(ActionEvent event) {
	int index = lv_heroes.getSelectionModel().getSelectedIndex();
	if (index >= 0)
	    posicionarItem(index, SUBIR, lv_heroes.getItems().get(index));
    }

    /**
     * On cargar ejercitos.
     * <p>
     * Al pulsar sobre el boton carga los ejercitos basicos de heroes y bestias,
     * actualiza listas y estados de los botones, luego de la confirmacion
     * </p>
     *
     * @param event the event
     */
    @FXML
    void onCargarEjercitos(ActionEvent event) {

	MyAlerta alerta = new MyAlerta("Cargar Ejercitos", "Se agregaran ejercitos predefinidos de heroes y bestias",
		"¿Desea continuar?", AlertType.CONFIRMATION);

	Optional<ButtonType> result = alerta.mostrar();
	if (result.get() == MyAlerta.BTN_SI) {
	    // cargar ejercitos
	    EjercitoGenerator ejercitoGenerator = new EjercitoGenerator();

	    BATALLA_CONTROLLER.getHeroes().addAll(ejercitoGenerator.getHeroesBasico());
	    BATALLA_CONTROLLER.getBestias().addAll(ejercitoGenerator.getBestiasBasico());

	    // actualizar listas y estados de botones
	    updateListas();
	    estadoBotones();
	}

    }

    /**
     * On per eliminados.
     * <p>
     * Al pulsar sobre el boton abre ventana con la lista de los personajes
     * eliminados.
     * </p>
     *
     * @param event the event
     */
    @FXML
    void onPerEliminados(ActionEvent event) {
	llamarResultado(BATALLA_CONTROLLER.getPersonajesEliminados(), PERSONAJES_ELIMINADOS);
	estadoBotones();

    }

    /**
     * On resultado.
     * <p>
     * Al pulsar sobre el boton abre ventana con la lista de el resultado de la
     * batalla.
     * </p>
     *
     * @param event the event
     */
    @FXML
    void onResultado(ActionEvent event) {
	llamarResultado(BATALLA_CONTROLLER.getBatalla(), RESULTADO_BATALLA);
    }

    /**
     * On reset.
     * <p>
     * Al pulsar sobre el boton reinicia los valores de las listas de heroes,
     * bestias y datos de la batalla.
     * </p>
     *
     * @param event the event
     */
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

    /**
     * Open agr personajes.
     * <p>
     * Al pulsar sobre el boton abre ventana para agregar personajes.
     * </p>
     *
     * @param event the event
     */
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

	    // con esta propiedad se actualiza la lista de personajes al cerrar la ventana
	    stage.showingProperty().addListener((obs, oldValue, newValue) -> {
		if (!newValue) {
		    // actualizar listas y estados de botones
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

    /**
     * Open Git Hub.
     * <p>
     * Al dal click en el link abre ventana en el navegador predeterminado del
     * sistema con la direccion de GitHub del proyecto.
     * </p>
     *
     * @param event the event
     */
    @FXML
    void openGitHub(ActionEvent event) {
	// direccion del repositorio
	String url = "https://github.com/mattyys/lotrGame.git";
	// chequea si se puede abrir el navegador
	try {
	    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
		Desktop.getDesktop().browse(new URI(url));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    /**
     * Update listas.
     * <p>
     * Carga las listas de heroes y bestias y actualiza las modificaciones.
     * </p>
     */
    public void updateListas() {

	// recargar listas
	lv_bestias.setItems(BATALLA_CONTROLLER.getBestias());
	lv_heroes.setItems(BATALLA_CONTROLLER.getHeroes());

	lv_bestias.refresh();
	lv_heroes.refresh();

    }

    /**
     * Eliminar personaje.
     * 
     * <p>
     * Elimina un personaje de la lista chequeando que tipo de personaje es
     * </p>
     *
     * @param index     the index del item seleccionado
     * @param personaje the personaje a eliminar
     */
    private void eliminarPersonaje(int index, Personaje personaje) {

	if (personaje instanceof Bestias) {
	    // ver si es necesario ya que se vuleve a cargar la lista desde el listview
	    if (lv_bestias.getSelectionModel().getSelectedItem() != null && !lv_bestias.getItems().isEmpty()) {
		Bestias bestia = (Bestias) personaje;
		BATALLA_CONTROLLER.eliminarBestia(bestia);
	    }
	} else {
	    if (lv_heroes.getSelectionModel().getSelectedItem() != null && !lv_heroes.getItems().isEmpty()) {
		Heroes heroe = (Heroes) personaje;
		BATALLA_CONTROLLER.eliminarHeroe(heroe);
	    }
	}
	estadoBotones();

    }

    /**
     * Posicionar item.
     * <p>
     * Metodo para subir o bajar una posicion el item seleccionado de la lista,
     * chequea si es heroe o bestia y que boton se presiono.
     * </p>
     *
     * @param index     the index del item seleccionado
     * @param accion    the accion que se realizara
     * @param personaje the personaje a posicionar
     */
    private void posicionarItem(int index, String accion, Personaje personaje) {
	// se chequea que boton se presiono
	if (accion.equals(SUBIR)) {
	    // si el personaje es bestia se sube una posicion de lo contrario se sube una
	    // posicion al heroe
	    if (personaje instanceof Bestias) {
		if (index > 0) {
		    Bestias bestia = (Bestias) personaje;
		    BATALLA_CONTROLLER.getBestias().remove(index);
		    BATALLA_CONTROLLER.getBestias().add(index - 1, bestia);
		    // se mantiene la seleccion del item
		    lv_bestias.getSelectionModel().select(index - 1);
		}
	    } else {
		if (index > 0) {
		    Heroes heroe = (Heroes) personaje;
		    BATALLA_CONTROLLER.getHeroes().remove(index);
		    BATALLA_CONTROLLER.getHeroes().add(index - 1, heroe);
		    lv_heroes.getSelectionModel().select(index - 1);
		}
	    }

	} else {
	    // si el personaje es bestia se baja una posicion de lo contrario se baja una
	    // posicion al heroe
	    if (personaje instanceof Bestias) {
		if (index < lv_bestias.getItems().size() - 1) {
		    Bestias bestia = (Bestias) personaje;
		    BATALLA_CONTROLLER.getBestias().remove(index);
		    BATALLA_CONTROLLER.getBestias().add(index + 1, bestia);
		    lv_bestias.getSelectionModel().select(index + 1);
		}
	    } else {
		if (index < lv_heroes.getItems().size() - 1) {
		    Heroes heroe = (Heroes) personaje;
		    BATALLA_CONTROLLER.getHeroes().remove(index);
		    BATALLA_CONTROLLER.getHeroes().add(index + 1, heroe);
		    lv_heroes.getSelectionModel().select(index + 1);
		}
	    }
	}

    }

    /**
     * Estado botones.
     * <p>
     * Por defecto los botones estan deshabilitados, se habilitan segun las
     * condiciones, se comprueba que esten cargadas las listas de heroes y bestias
     * para habilitar la Lucha y cada boton correspondiente a su lista y tambien se
     * comprueba si las listas de resultados esta disponible
     * </p>
     */
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
	if (BATALLA_CONTROLLER.getHeroes().isEmpty() && BATALLA_CONTROLLER.getBestias().isEmpty()
		&& BATALLA_CONTROLLER.getBatalla().isEmpty()
		&& BATALLA_CONTROLLER.getPersonajesEliminados().isEmpty()) {
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

    /**
     * Llamar resultado.
     * <p>
     * Abre la ventana de Resultado, pasando la lista y el nombre a mostrar
     * </p>
     *
     * @param listado the listado de resultados a mostrar
     * @param nombre  the nombre del titulo de los resultados
     */
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

    /**
     * Mostrar lucha.
     * <p>
     * Abre la ventana que muestra un gif de una batalla por 2 segundos y luego abre
     * la ventana de resultados.
     * </p>
     */
    private void mostrarLucha() {

	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ImagenBatalla.fxml"));

	try {

	    Parent iRoot = loader.load();
	    Scene scene = new Scene(iRoot);
	    Stage stage = new Stage();
	    stage.setTitle("Lucha");
	    stage.initOwner(rootPane.getScene().getWindow());
	    stage.initModality(Modality.APPLICATION_MODAL);
	    stage.setResizable(false);
	    stage.setIconified(false);
	    stage.setScene(scene);
	    stage.show();

	    // transicion para cerrar la ventana luego de 2 segundos
	    PauseTransition pause = new PauseTransition(Duration.seconds(2));
	    pause.setOnFinished(e -> stage.close());
	    pause.play();

	    // al cerrar la ventana se llama a la ventas de resultado
	    stage.setOnHidden(e -> llamarResultado(BATALLA_CONTROLLER.getBatalla(), RESULTADO_BATALLA));
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}

    }

}
