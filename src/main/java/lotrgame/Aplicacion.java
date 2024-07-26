package lotrgame;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lotrgame.controller.BatallaController;
import lotrgame.model.Bestias;
import lotrgame.model.Heroes;
import lotrgame.utils.EjercitoGenerator;

public class Aplicacion {

	public static void main(String[] args) {
	
	//se crea un nuevo controlador de batalla
	    BatallaController batalla = new BatallaController();
	    
	    //se crean los ejercitos basicos
	    ObservableList<Heroes> heroes = FXCollections.observableArrayList();
	    heroes = (ObservableList<Heroes>) new EjercitoGenerator().getHeroesBasico();
	    batalla.setHeroes(heroes);
	    
	    ObservableList<Bestias> bestias = FXCollections.observableArrayList();
	    bestias = (ObservableList<Bestias>) new EjercitoGenerator().getBestiasBasico();
	    batalla.setBestias(bestias);
	    
	    //se inicia la batalla
	    batalla.iniciarBatalla();
	    
	    //se muestra el resultado
	    batalla.getBatalla().forEach(System.out::println);
	    
	    System.out.println();
	    
	    System.out.println("Personajes eliminados: ");
	    
	    batalla.getPersonajesEliminados().forEach(System.out::println);

	}

}
