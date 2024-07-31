/**
 * Self.
 *
 * @return the b
 */
/*
 * Clase abstracta Personaje
 * 
 */
package lotrgame.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class Personaje.
 * <p>
 * Crea un personaje con nombre, raza, vida y armadura. Proporciona metodos
 * abstractos para atacar y recibir ataques. Proporciona metodos para mostrar el
 * estado del personaje y si esta vivo o no. Esta clase es abstracta y debe ser
 * implementada por las clases Heroes y Bestias.
 * </p>
 */
@Getter
@Setter
/**
 * The Class PersonajeBuilder.
 *
 * @param <C> the generic type
 * @param <B> the generic type
 */
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class Personaje {

    /**
     * The nombre.
     * <p>
     * Variable que almacena el nombre del personaje.
     * </p>
     */
    private String nombre;

    /**
     * The raza.
     * <p>
     * Variable que almacena la raza del personaje del tipo Enum RazaPersonaje.
     * </p>
     */
    private RazaPersonajes raza;

    /**
     * The vida.
     * <p>
     * Variable que almacena la vida del personaje.
     * </p>
     */
    private Integer vida;

    /**
     * The armadura.
     * <p>
     * Variable que almacena la armadura del personaje.
     * </p>
     */
    private Integer armadura;

    /**
     * Atacar.
     * <p>
     * Mediante la tirada de dados se selecciona la potencia del ataque, y se
     * aplican modificadores segun la raza del personaje
     * </p>
     *
     * @param contrario the contrario(Personaje que recibe el ataque).
     * @return String mensaje con el resultado del ataque.
     */
    public abstract String atacar(Personaje contrario);

    /**
     * Recibir ataque.
     * <p>
     * Recibe un ataque y calcula el daño que se le hace al personaje en base a las
     * especificaciones del personaje
     * </p>
     * 
     * @param ataque   la potencia recibida del ataque.
     * @param atacante the atacante (Personaje que ataca).
     * @return String un mensaje con el resultado del ataque.
     */
    public abstract String recibirAtaque(Integer ataque, Personaje atacante);

    /**
     * Esta vivo.
     * <p>
     * Chequea si la vida del personaje es mayor a 0.
     * </p>
     *
     * @return true, si la vida del personaje es mayor a 0
     */
    public boolean estaVivo() {
	return vida > 0;
    }

    /**
     * Mostrar estado.
     * <p>
     * Devuelve una cadena de texto con el estado del personaje nombnre, vida y
     * armadura.
     * </p>
     *
     * @return String mensaje con el estado del personaje
     */
    public String mostrarEstado() {
	return nombre + " (Vida=" + vida + " Armadura=" + armadura + ")";
    }

    /**
     * Mensaje batalla.
     * <p>
     * Muestra el mensaje de la batalla, el atacante, el ataque, el ataque
     * final(puntos que realmente quita el ataque) y el atacado
     * </p>
     * 
     * @param atacante    the atacante
     * @param ataque      the ataque
     * @param ataqueFinal the ataque final
     * @param atacado     the atacado
     * @return the string
     */
    protected String mensajeBatalla(Personaje atacante, Integer ataque, Integer ataqueFinal, Personaje atacado) {
	return ("\t" + atacante.getNombre() + " saca " + ataque + " y le quita " + ataqueFinal + " de vida a "
		+ atacado.getNombre());
    }

    /**
     * To string.
     * <p>
     * Devuelve una cadena de texto con el nombre del personaje, la raza , la vida y
     * la armadura.
     * </p>
     * 
     * @return the string
     */
    @Override
    public String toString() {
	return nombre + " - " + raza.getNombreRaza() + "( " + vida + ", " + armadura + " )";
    }

}
