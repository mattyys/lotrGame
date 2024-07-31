package lotrgame.utils;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javafx.stage.FileChooser;

// TODO: Auto-generated Javadoc
/**
 * The Class ExportTXT.
 * <p>
 * Clase que permite exportar una lista de Strings a un archivo .txt
 * </p>
 */
public class ExportTXT {

    /**
     * Exportar lista.
     * <p>
     * Exporta una lista de Strings a un archivo .txt, se muestra un FileChooser
     * para seleccionar la ruta donde se guardara el archivo.
     * </p>
     *
     * @param lista  the lista
     * @param nombre the nombre
     */
    public static void exportarLista(List<String> lista, String nombre) {
	// se crea un FileChooser para seleccionar la ruta donde se guardara el archivo
	FileChooser fileChooser = new FileChooser();

	// se agrega un filtro para que solo se puedan guardar archivos .txt
	FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
	fileChooser.getExtensionFilters().add(extFilter);

	// opcion para guardar el archivo con nombre predeterminado
	fileChooser.setInitialFileName(nombre);

	// se muestra el FileChooser y se guarda la ruta seleccionada
	File file = fileChooser.showSaveDialog(null);

	// si el archivo es diferente de null se procede a guardar el archivo
	if (file != null) {
	    try (PrintWriter writer = new PrintWriter(file)) {
		for (String linea : lista) {
		    writer.println(linea);
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

}
