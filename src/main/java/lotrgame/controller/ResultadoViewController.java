package lotrgame.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import lotrgame.utils.ExportTXT;
import lotrgame.utils.MyAlerta;

// TODO: Auto-generated Javadoc
/**
 * The Class ResultadoViewController.
 * <p>
 * Clase controladora del formulario(vista) para presentar los resultados de la
 * batalla. Se Utiliza para mostrar tanto los resultados de la batalla como la
 * lista de los personajes eliminados. Gestiona la exportacion a un archivo de
 * texto de los resultados mostrados.
 * </p>
 */
public class ResultadoViewController implements Initializable {

    /**
     * The boton exportar.
     * <p>
     * Boton encargado de ejecutar la exportacion de la lista de resultados a un
     * archivo de texto.
     * </p>
     */
    @FXML
    private JFXButton btn_exportar;

    /**
     * The label nombre.
     * <p>
     * Este label muestra el nombre del tipo de listado de la vista de resultados.
     * </p>
     */
    @FXML
    private Label lb_nombre;

    /**
     * The listview detalle lucha.
     * <p>
     * En este listview se muestra la lista de los resultados de la lucha o la lista
     * de los personajes eliminados.
     * </p>
     */
    @FXML
    private JFXListView<String> lv_detalle_lucha;

    /**
     * Initialize.
     * 
     * <p>
     * Se actualiza la lista de la vista de resultados al momento de inicializar la
     * vista.
     * </p>
     *
     * @param location  the location
     * @param resources the resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	lv_detalle_lucha.refresh();

    }

    /**
     * On export.
     * 
     * <p>
     * Llama al metodo estatico exportarLista de la clase ExportTXT para exportar el
     * contenido del listview a un archivo de texto.
     * </p>
     *
     * @param event the event
     */
    @FXML
    void onExport(ActionEvent event) {
	String nombre = lb_nombre.getText();
	if (!lv_detalle_lucha.getItems().isEmpty())
	    ExportTXT.exportarLista(lv_detalle_lucha.getItems(), nombre);
	else {
	    MyAlerta msj = new MyAlerta(nombre, "No hay elementos", "Nada para exportar", AlertType.INFORMATION);
	    msj.mostrar();
	}
    }

    /**
     * Cargar resultado.
     * 
     * <p>
     * Metodo para cargar los resultados de la lucha en la vista de resultados y el
     * nombre del tipo de listado.
     * </p>
     *
     * @param lista  the lista (listado de resultados a mostrar).
     * @param nombre the nombre (nombre del tipo de listado).
     */
    public void cargarResultado(List<String> lista, String nombre) {
	lb_nombre.setText(nombre);
	lv_detalle_lucha.getItems().addAll(lista);
    }

}
