package lotrgame.controller;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lotrgame.model.Bestias;
import lotrgame.model.Heroes;
import lotrgame.model.Personaje;

/**
 * The Class BatallaController.
 */
@Getter
@Setter
public class BatallaController {

    /** The heroes. */
    private List<Heroes> heroes;

    /** The bestias. */
    private List<Bestias> bestias;

    /** The batalla. */
    private List<String> batalla;

    /** The personajes eliminados. */
    private List<String> personajesEliminados;

    /**
     * Instantiates a new batalla controller.
     */
    public BatallaController() {
	this.heroes = new ArrayList<Heroes>();
	this.bestias = new ArrayList<Bestias>();
	this.batalla = new ArrayList<String>();
	this.personajesEliminados = new ArrayList<String>();
    }

    /**
     * Iniciar batalla.
     * <p>
     * Método que controla la batalla entre ejercitos guardando las inteacciones en
     * un List<>() para la batalla y personajes eliminados.
     */
    public void iniciarBatalla() {

	addBatalla("Inicia la batalla...");

	int i = 0;
	int menorEjercito = 0;
	int turno = 1;

	// Se realiza la batalla mientras haya personajes en ambos ejercitos
	while (!heroes.isEmpty() && !bestias.isEmpty()) {

	    Heroes heroe = heroes.get(i);
	    Bestias bestia = bestias.get(i);

	    // se obtiene el ejercito con menos personajes
	    menorEjercito = Math.min(heroes.size(), bestias.size());

	    // Se muestra turno y combatientes
	    addBatalla("Turno " + turno++ + ":");
	    addBatalla("Lucha entre" + heroe.mostrarEstado() + " y " + bestia.mostrarEstado());

	    // comienza la batalla con el heroe atacando primero luego la bestia
	    addBatalla(heroe.atacar(bestia));
	    addBatalla(bestia.atacar(heroe));

	    // se verifica si ha muerto algun personaje
	    if (!heroe.estaVivo()) {
		// se muestra mensaje de eliminacion
		addBatalla(mensajeEliminacion(heroe));

		// se agrega pesonaje eliminado a lista de eliminados
		addPersonajeEliminado(heroe, bestia, turno);

		// se elimina de la lita del ejercito de heroes
		heroes.remove(heroe);
	    }

	    if (!bestia.estaVivo()) {
		addBatalla(mensajeEliminacion(bestia));
		addPersonajeEliminado(bestia, heroe, turno);
		bestias.remove(bestia);
	    }

	    // se verifica si algun equipo quedo sin pesonajes
	    if (heroes.isEmpty()) {
		addBatalla("VICTORIA DE LAS BESTIAS!!");
		break;
	    } else if (bestias.isEmpty()) {
		addBatalla("VICTORIA DE LOS HEROES!!");
		break;
	    }

	    // se pasa al siguiente en la lista
	    i++;

	    // controla que el contador (i) no sobrepase el tamaño de la lista luego de
	    // eliminarun pesonaje
	    if (i == heroes.size() || i == bestias.size()) {
		i = 0;
	    }

	    // si se llega al final del ejercito menor se reincia el contador
	    if (i == menorEjercito) {
		i = 0;
	    }

	}

    }

    /**
     * Adds the batalla.
     * <p> Agrega un mensaje del progreso de la batalla a la lista de batalla.
     *
     * @param mensaje the mensaje
     */
    private void addBatalla(String mensaje) {
	batalla.add(mensaje);
    }

    /**
     * Adds the heroes.
     * <p> Agrega un Heroe a la lista de Heroes.
     *
     * @param heroe the heroe
     */
    public void addHeroes(Heroes heroe) {
	heroes.add(heroe);
    }
    
    /**
     * Adds the personaje.
     * <p> Agrega un Personaje a la lista de Heroes o Bestias segun su tipo.
     *
     * @param personaje the personaje
     */
    public void addPersonaje(Personaje personaje) {
	if (personaje instanceof Heroes) {
	    heroes.add((Heroes)personaje);
	}
	if(personaje instanceof Bestias) {
	    bestias.add((Bestias)personaje);
	}
	
    }

    /**
     * Adds the bestias.
     * <p> Agrega una Bestia a la lista de Bestias.
     *
     * @param bestia the bestia
     */
    public void addBestias(Bestias bestia) {
	bestias.add(bestia);
    }

    /**
     * Eliminar heroe.
     *<p> Elimina el Heroe pasado por parametro.
     * @param heroe the heroe
     */
    public void eliminarHeroe(Heroes heroe) {
	heroes.remove(heroe);
    }

    /**
     * Eliminar bestia.
     * <p> Elimina la Bestia pasada por parametro
     *
     * @param bestia the bestia
     */
    public void eliminarBestia(Bestias bestia) {
	bestias.remove(bestia);
    }

    /**
     * Clear all ejercitos.
     * <p>Vacía la lista de los ejecitos de Bestias y Heroes.
     */
    public void clearAllEjercitos() {
	this.heroes.clear();
	this.bestias.clear();
    }

    /**
     * Adds the personaje eliminado.
     * <p>
     * Recibe como primer parametro al personaje eliminado, segundo parametro al
     * personaje atacante, tercer parametro el turno. Se crea un String formateado
     * con los datos de la eliminación el turno correspondiente y se agrega a la
     * lista de Pesonajes Eliminados.
     *
     * @param personajeEliminado the personaje eliminado
     * @param atacante           the atacante
     * @param turno              the turno
     */
    private void addPersonajeEliminado(Personaje personajeEliminado, Personaje atacante, int turno) {
	StringBuilder mensaje = new StringBuilder();
	mensaje.append(personajeEliminado.getRaza().getNombreRaza()).append(" ").append(personajeEliminado.getNombre())
		.append(" eliminado por ").append(atacante.getRaza().getNombreRaza()).append(" ")
		.append(atacante.getNombre()).append(" en el turno ").append(turno);
	personajesEliminados.add(mensaje.toString());
    }

    /**
     * Mensaje eliminacion.
     * <p>
     * Recibe un Personaje (Bestia o Heroe) como parametro y devuelve un String con
     * los detalles de raza y nombre del personaje eliminado.
     *
     * @param personaje the personaje
     * @return the string
     */
    private String mensajeEliminacion(Personaje personaje) {
	return "¡Muere " + personaje.getRaza().getNombreRaza() + " " + personaje.getNombre() + "!";
    }

}
