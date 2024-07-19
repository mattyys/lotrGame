package lotrgame.utils;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class MyAlerta {
    private String titulo;
    private String header;
    private String mensaje;
    private Alert.AlertType tipo;
    public static final ButtonType BTN_SI = new ButtonType("Si");
    public static final ButtonType BTN_NO = new ButtonType("No");
    
    public MyAlerta(String titulo, String header, String mensaje, Alert.AlertType tipo) {
	this.titulo = titulo;
	this.header = header;
	this.mensaje = mensaje;
	this.tipo = tipo;
    }
    
    public Optional<ButtonType> mostrar() {
	Alert alert = new Alert(tipo);
	if (tipo == Alert.AlertType.CONFIRMATION) {
	    alert.getButtonTypes().setAll(BTN_SI, BTN_NO);
	}
	alert.setTitle(titulo);
	alert.setHeaderText(header);
	alert.setContentText(mensaje);
	return alert.showAndWait();
    }
    

}
