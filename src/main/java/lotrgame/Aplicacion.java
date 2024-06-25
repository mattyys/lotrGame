package lotrgame;

import java.util.List;

import lotrgame.controller.BatallaController;
import lotrgame.model.Bestias;
import lotrgame.model.Heroes;
import lotrgame.utils.EjercitoGenerator;

public class Aplicacion {

	public static void main(String[] args) {
	
	    List<Heroes> heroes = new EjercitoGenerator().getHeroesBasico();
	    List<Bestias> bestias = new  EjercitoGenerator().getBestiasBasico();
	    BatallaController batalla = new BatallaController();
	    
	    batalla.setHeroes(heroes);
	    batalla.setBestias(bestias);
	    
	    batalla.iniciarBatalla();
	    
	    batalla.getBatalla().forEach(System.out::println);
	    
	    System.out.println();
	    
	    System.out.println("Personajes eliminados: ");
	    
	    batalla.getPersonajesEliminados().forEach(System.out::println);

	}

}
