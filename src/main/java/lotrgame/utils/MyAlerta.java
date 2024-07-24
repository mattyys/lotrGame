package lotrgame.utils;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


/**
 * The Class MyAlerta.
 */
public class MyAlerta {
    
    /** The titulo. */
    private String titulo;
    
    /** The header. */
    private String header;
    
    /** The mensaje. */
    private String mensaje;
    
    /** The tipo. */
    private Alert.AlertType tipo;
    
    /** The Constant BTN_SI. */
    public static final ButtonType BTN_SI = new ButtonType("Si");
    
    /** The Constant BTN_NO. */
    public static final ButtonType BTN_NO = new ButtonType("No");
    
    /**
     * Instantiates a new my alerta.
     *
     * @param titulo the titulo
     * @param header the header
     * @param mensaje the mensaje
     * @param tipo the tipo
     */
    public MyAlerta(String titulo, String header, String mensaje, Alert.AlertType tipo) {
	this.titulo = titulo;
	this.header = header;
	this.mensaje = mensaje;
	this.tipo = tipo;
    }
    
    /**
     * Mostrar.
     * <p>Alert con botones de confirmación personalizados "Si - No"</p> 
     *
     * @return the optional
     */
    public Optional<ButtonType> mostrar() {
	Alert alert = new Alert(tipo);
	if (tipo == Alert.AlertType.CONFIRMATION) {
	    alert.getButtonTypes().setAll(BTN_NO,BTN_SI);
	}
	alert.setTitle(titulo);
	alert.setHeaderText(header);
	alert.setContentText(mensaje);
	return alert.showAndWait();
    }
    

}
