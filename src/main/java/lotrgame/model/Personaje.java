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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class Personaje {

    private String nombre;
    private RazaPersonajes raza;
    private Integer vida, armadura;

    /**
     * Atacar.
     * <p>
     * Mediante la tirada de dados se selecciona la potencia del ataque, y se
     * aplican modificadores segun la raza del personaje
     * </p>
     * 
     * @param Personaje contrario: el personaje al que se le va a atacar
     * @return retorna un mensaje con el resultado del ataque
     */
    public abstract String atacar(Personaje contrario);

    /**
     * Recibir ataque.
     * <p>
     * Recibe un ataque y calcula el daño que se le hace al personaje en base a las
     * especificaciones del personaje
     * </p>
     * 
     * @param ataque   : la potencia recibida del ataque
     * @param atacante the atacante
     * @return retorna un mensaje con el resultado del ataque
     */
    public abstract String recibirAtaque(Integer ataque, Personaje atacante);

    /**
     * Esta vivo.
     *
     * @return true, si la vida del personaje es mayor a 0
     */
    public boolean estaVivo() {
	return vida > 0;
    }

    /**
     * Mostrar estado.
     *
     * @return retorna un mensaje con el estado del personaje
     */
    public String mostrarEstado() {
	return nombre + " (Vida=" + vida + " Armadura=" + armadura + ")";
    }

    /**
     * Mensaje batalla. muestra el mensaje de la batalla, el atacante, el ataque, el
     * ataque final(puntos que realmente quita el ataque) y el atacado
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

    @Override
    public String toString() {
	return nombre + " - " + raza.getNombreRaza() + "( " + vida + ", " + armadura + " )";
    }

}
