package lotrgame.utils;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

// TODO: Auto-generated Javadoc
/**
 * The Class MyAlerta.
 * <p>
 * Clase que permite mostrar alertas personalizadas con botones de confirmación
 * personalizados "Si - No"
 * </p>
 */
public class MyAlerta {

    /**
     * The titulo.
     * <p>
     * Variable que almacena el titulo de la alerta
     * <p>
     */
    private String titulo;

    /**
     * The header.
     * <p>
     * Variable que almacena el encabezado de la alerta
     * </p>
     */
    private String header;

    /**
     * The mensaje.
     * <p>
     * Variable que almacena el mensaje informativo a mostrar en la alerta
     * </p>
     */
    private String mensaje;

    /**
     * The tipo.
     * <p>
     * Variable que almacena el tipo de alerta que se va a mostrar
     * </p>
     */
    private Alert.AlertType tipo;

    /**
     * The Constant BTN_SI.
     * <p>
     * Constante que almacena el boton de confirm "Si".
     * </p>
     */
    public static final ButtonType BTN_SI = new ButtonType("Si");

    /**
     * The Constant BTN_NO.
     * <p>
     * Constante que almacena el boton de confirmación "No"
     * </p>
     */
    public static final ButtonType BTN_NO = new ButtonType("No");

    /**
     * Instantiates a new my alerta.
     * <p>
     * Constructor que recibe los parametros para mostrar la alerta
     * </p>
     *
     * @param titulo  the titulo de la alerta
     * @param header  the header (encabezado) de la alerta
     * @param mensaje the mensaje informativo de la alerta
     * @param tipo    the tipo de alerta a mostrar
     */
    public MyAlerta(String titulo, String header, String mensaje, Alert.AlertType tipo) {
	this.titulo = titulo;
	this.header = header;
	this.mensaje = mensaje;
	this.tipo = tipo;
    }

    /**
     * Mostrar.
     * <p>
     * Ejecuta la alerta y retorna el tipo de boton seleccionado
     * </p>
     *
     * @return the optional
     */
    public Optional<ButtonType> mostrar() {
	Alert alert = new Alert(tipo);
	if (tipo == Alert.AlertType.CONFIRMATION) {
	    alert.getButtonTypes().setAll(BTN_NO, BTN_SI);
	}
	alert.setTitle(titulo);
	alert.setHeaderText(header);
	alert.setContentText(mensaje);
	return alert.showAndWait();
    }

}
