package lotrgame;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lotrgame.controller.BatallaController;
import lotrgame.model.Bestias;
import lotrgame.model.Heroes;
import lotrgame.utils.EjercitoGenerator;


//TODO: Auto-generated Javadoc
/**
 * The Class Aplicacion.
 * <p>
 * Esta clase inicia la aplicación en modo consola.
 * </p>
 */
public class Aplicacion {

    /**
     * The main method.
     * <p>
     * Este metodo contiene la logica de la aplicacion en modo consola, generando un
     * ejercito de heroes y otro de bestias, y luego inicia la batalla.
     * </p>
     * @param args the arguments
     */
    public static void main(String[] args) {

	// se crea un nuevo controlador de batalla
	BatallaController batalla = new BatallaController();

	// se crean los ejercitos basicos
	ObservableList<Heroes> heroes = FXCollections.observableArrayList();
	heroes = (ObservableList<Heroes>) new EjercitoGenerator().getHeroesBasico();
	batalla.setHeroes(heroes);

	ObservableList<Bestias> bestias = FXCollections.observableArrayList();
	bestias = (ObservableList<Bestias>) new EjercitoGenerator().getBestiasBasico();
	batalla.setBestias(bestias);

	// se inicia la batalla
	batalla.iniciarBatalla();

	// se muestra el resultado
	batalla.getBatalla().forEach(System.out::println);

	System.out.println();

	System.out.println("Personajes eliminados: ");

	batalla.getPersonajesEliminados().forEach(System.out::println);

    }

}
