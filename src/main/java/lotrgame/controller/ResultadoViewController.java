package lotrgame.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lotrgame.utils.ExportTXT;

public class ResultadoViewController implements Initializable{

    @FXML
    private JFXButton btn_exportar;

    @FXML
    private Label lb_nombre;

    @FXML
    private JFXListView<String> lv_detalle_lucha;

    private BatallaViewController batallaViewController;
    private BatallaController batallaController;

    public void setBatallaViewController(BatallaViewController batallaViewController) {
	this.batallaViewController = batallaViewController;
    }

    public void setBatallaController(BatallaController batallaController) {
	this.batallaController = batallaController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	lv_detalle_lucha.refresh();
	
    }

    @FXML
    void onExport(ActionEvent event) {
	ExportTXT.exportarLista(lv_detalle_lucha.getItems());
    }
    
    public void cargarResultado(List<String> lista, String nombre) {
	lb_nombre.setText(nombre);
	lv_detalle_lucha.getItems().addAll(lista);
    }
//falta ver las exportaciones y detalles de validacion y pantalla de imagen

}
