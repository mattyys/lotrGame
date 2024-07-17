package lotrgame.utils;


import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javafx.stage.FileChooser;

public class ExportTXT {

    public static void exportarLista(List<String> lista) {
	FileChooser fileChooser = new FileChooser();

	FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
	fileChooser.getExtensionFilters().add(extFilter);

	File file = fileChooser.showSaveDialog(null);

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
