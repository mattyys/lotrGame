package lotrgame.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.Setter;
import lotrgame.model.Bestias;
import lotrgame.model.Heroes;
import lotrgame.model.Personaje;

// TODO: Auto-generated Javadoc
/**
 * The Class BatallaController.
 * <p>
 * Clase controladora de la batalla entre ejercitos de Heroes y Bestias. Permite
 * agregar Heroes y Bestias a sus respectivas listas, iniciar la batalla, crear
 * mensajes de progreso de la batalla y mensajes de eliminación de personajes.
 * </p>
 */
@Getter
@Setter
public class BatallaController {

    /**
     * Lista de heroes.
     * <p>
     * Lista de Heroes que participan en la batalla.
     * </p>
     */
    private ObservableList<Heroes> heroes;

    /**
     * Lista de bestias.
     * <p>
     * Lista de Bestias que participan en la batalla.
     * </p>
     */
    private ObservableList<Bestias> bestias;

    /**
     * Lista del pogreso de la batalla.
     * <p>
     * Lista que contiene los mensajes de progreso de la batalla.
     * </p>
     */
    private List<String> batalla;

    /**
     * Lista de personajes eliminados.
     * <p>
     * Lista que continene los mensajes de eliminación de personajes.
     * </p>
     */
    private List<String> personajesEliminados;

    /**
     * Instantiates a new batalla controller.
     * <p>
     * Constructor de la clase BatallaController. Inicializa las listas de heroes,
     * bestias, batalla y personajes eliminados.
     * </p>
     */
    public BatallaController() {
	this.heroes = FXCollections.observableArrayList();
	this.bestias = FXCollections.observableArrayList();
	this.batalla = new ArrayList<String>();
	this.personajesEliminados = new ArrayList<String>();
    }

    /**
     * Iniciar batalla.
     * <p>
     * Método que controla la batalla entre ejercitos, guardando las inteacciones en
     * un lista para la batalla y personajes eliminados.
     * </p>
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
	    addBatalla("Lucha entre " + heroe.mostrarEstado() + " y " + bestia.mostrarEstado());

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
	addBatalla("Fin de la batalla...");
    }

    /**
     * Adds the batalla.
     * <p>
     * Agrega un mensaje del progreso de la batalla a la lista de batalla.
     * </p>
     *
     * @param mensaje the mensaje
     */
    private void addBatalla(String mensaje) {
	batalla.add(mensaje);
    }

    /**
     * Adds the heroes.
     * <p>
     * Agrega un Heroe a la lista de Heroes.
     * </p>
     *
     * @param heroe the heroe
     */
    public void addHeroes(Heroes heroe) {
	heroes.add(heroe);
    }

    /**
     * Adds the personaje.
     * <p>
     * Agrega un Personaje a la lista de Heroes o Bestias segun su tipo.
     * </p>
     *
     * @param personaje the personaje
     */
    public void addPersonaje(Personaje personaje) {
	if (personaje instanceof Heroes) {
	    heroes.add((Heroes) personaje);
	}
	if (personaje instanceof Bestias) {
	    bestias.add((Bestias) personaje);
	}

    }

    /**
     * Adds the bestias.
     * <p>
     * Agrega una Bestia a la lista de Bestias.
     * </p>
     * 
     * @param bestia the bestia
     */
    public void addBestias(Bestias bestia) {
	bestias.add(bestia);
    }

    /**
     * Eliminar heroe.
     * <p>
     * Elimina el Heroe pasado por parametro.
     * </p>
     * 
     * @param heroe the heroe
     */
    public void eliminarHeroe(Heroes heroe) {
	heroes.remove(heroe);
    }

    /**
     * Eliminar bestia.
     * <p>
     * Elimina la Bestia pasada por parametro.
     * </p>
     * 
     * @param bestia the bestia
     */
    public void eliminarBestia(Bestias bestia) {
	bestias.remove(bestia);
    }

    /**
     * Clear all ejercitos.
     * <p>
     * Vacía la lista de los ejecitos de Bestias y Heroes.
     * </p>
     */
    public void clearAllEjercitos() {
	this.heroes.clear();
	this.bestias.clear();
    }

    /**
     * Adds the personaje eliminado.
     * <p>
     * Crea un mensaje de eliminación de personaje y lo agrega a la lista de
     * Personajes Eliminados. Recibe como primer parametro al personaje eliminado,
     * segundo parametro al personaje atacante, tercer parametro el turno.
     * </p>
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
     * Crear un mensaje de eliminación de personaje. Recibe un Personaje (Bestia o
     * Heroe) como parametro y devuelve un String con los detalles de raza y nombre
     * del personaje eliminado.
     * </p>
     *
     * @param personaje the personaje eliminado
     * @return the string
     */
    private String mensajeEliminacion(Personaje personaje) {
	return "¡Muere " + personaje.getRaza().getNombreRaza() + " " + personaje.getNombre() + "!";
    }

}
