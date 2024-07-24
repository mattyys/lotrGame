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

public class ResultadoViewController implements Initializable {

    @FXML
    private JFXButton btn_exportar;

    @FXML
    private Label lb_nombre;

    @FXML
    private JFXListView<String> lv_detalle_lucha;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	lv_detalle_lucha.refresh();

    }

    @FXML
    void onExport(ActionEvent event) {
	String nombre = lb_nombre.getText();
	if (!lv_detalle_lucha.getItems().isEmpty())
	    ExportTXT.exportarLista(lv_detalle_lucha.getItems(), nombre);
	else {
	    MyAlerta msj = new MyAlerta(nombre, "No hay elementos","Nada para exportar" ,AlertType.INFORMATION);
	    msj.mostrar();
	}
    }

    public void cargarResultado(List<String> lista, String nombre) {
	lb_nombre.setText(nombre);
	lv_detalle_lucha.getItems().addAll(lista);
    }

}
