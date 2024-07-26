package lotrgame.model;

import java.util.List;

/**
 * The Enum RazaPersonajes.
 */
public enum RazaPersonajes {

    /** The humano. */
    // Heroes
    HUMANO("Humano"),
    /** The elfo. */
    ELFO("Elfo"),
    /** The enano. */
    ENANO("Enano"),
    /** The hobbit. */
    HOBBIT("Hobbit"),
    /** The mago. */
    MAGO("Mago"),

    /** The orco. */
    // Bestias
    ORCO("Orco"),
    /** The trasgo. */
    TRASGO("Trasgo"),
    /** The urukhais. */
    URUKHAIS("Uruk-hais"),
    /** The nazgul. */
    NAZGUL("Nazgul");

    /** The nombre raza. */
    private String nombreRaza;

    /**
     * Instantiates a new raza personajes.
     *
     * @param nombreRaza the nombre raza
     */
    private RazaPersonajes(String nombreRaza) {
	this.nombreRaza = nombreRaza;
    }

    /**
     * Gets the nombre raza.
     *
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

    /**
     * Gets the raza heroes.
     * <p>
     * Obtener las razas de los heroes
     * </p>
     * 
     * @return the raza heroes
     */
    // Ltado raza de Heroes
    public static List<RazaPersonajes> getRazaHeroes() {
	return List.of(HUMANO, ELFO, ENANO, HOBBIT, MAGO);
    }

    /**
     * Gets the raza bestias.
     * <p>
     * Obtener las razas de las bestias
     * </p>
     * 
     * @return the raza bestias
     */
    // Ltado raza de Bestias
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
