package lotrgame.model;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Enum RazaPersonajes.
 * <p>
 * Enum que contiene las razas de los personajes
 * </p>
 */
public enum RazaPersonajes {

    // Heroes
    /**
     * The humano.
     * <p>
     * Perteneciente a los heroes, representa a los humanos.
     * </p>
     */
    HUMANO("Humano"),
    /**
     * The elfo.
     * <p>
     * Perteneciente a los heroes, representa a los elfos.
     * </p>
     */
    ELFO("Elfo"),
    /**
     * The enano.
     * <p>
     * Perteneciente a los heroes, representa a los enanos.
     * </p>
     */
    ENANO("Enano"),
    /**
     * The hobbit.
     * <p>
     * Perteneciente a los heroes, representa a los hobbits.
     * </p>
     */
    HOBBIT("Hobbit"),
    /**
     * The mago.
     * <p>
     * Perteneciente a los heroes, representa a los magos.
     * </p>
     */
    MAGO("Mago"),

    // Bestias
    /**
     * The orco.
     * <p>
     * Perteneciente a las bestias, representa a los orcos.
     * </p>
     */
    ORCO("Orco"),
    /**
     * The trasgo.
     * <p>
     * Pereneciente a las bestias, representa a los trasgos.
     * </p>
     */
    TRASGO("Trasgo"),
    /**
     * The urukhais.
     * <p>
     * Perteneciente a las bestias, representa a los uruk-hais.
     * </p>
     */
    URUKHAIS("Uruk-hais"),
    /**
     * The nazgul.
     * <p>
     * Perteneciente a las bestias, representa a los nazgul.
     * </p>
     */
    NAZGUL("Nazgul");

    /**
     * The nombre raza.
     * <p>
     * Variabla que almacena el nombre de la raza.
     * </p>
     */
    private String nombreRaza;

    /**
     * Instantiates a new raza personajes.
     * <p>
     * Inicializa la raza con el nombre de la misma.
     * </p>
     * 
     * @param nombreRaza the nombre raza
     */
    private RazaPersonajes(String nombreRaza) {
	this.nombreRaza = nombreRaza;
    }

    /**
     * Gets the nombre raza.
     * <p>
     * Devuelve el nombre de la raza.
     * </p>
     * @return the nombre raza
     */
    public String getNombreRaza() {
	return nombreRaza;
    }

    /**
     * Gets the raza.
     * <p>
     * Obtener la raza segun el nombre seleccionado
     * </p>
     * 
     * @param nombreRaza the nombre raza
     * @return the raza
     */
    public static RazaPersonajes getRaza(String nombreRaza) {
	for (RazaPersonajes raza : RazaPersonajes.values()) {
	    if (raza.getNombreRaza().equals(nombreRaza)) {
		return raza;
	    }
	}
	return null;
    }

    // Ltado raza de Heroes
    /**
     * Gets the raza heroes.
     * <p>
     * Devuelve la lista de razas de los heroes.
     * </p>
     * 
     * @return the raza heroes
     */
    public static List<RazaPersonajes> getRazaHeroes() {
	return List.of(HUMANO, ELFO, ENANO, HOBBIT, MAGO);
    }

    // Ltado raza de Bestias
    /**
     * Gets the raza bestias.
     * <p>
     * Devuelve la lista de razas de las bestias.
     * </p>
     * 
     * @return the raza bestias
     */
    public static List<RazaPersonajes> getRazaBestias() {
	return List.of(ORCO, TRASGO, URUKHAIS, NAZGUL);
    }

    /**
     * Gets the raza personajes.
     * <p>
     * Devuelve todas las razas de los personajes
     * </p>
     * 
     * @return the raza personajes
     */
    // Listado de todas las razas
    public static List<RazaPersonajes> getRazaPersonajes() {
	return List.of(values());
    }

}
