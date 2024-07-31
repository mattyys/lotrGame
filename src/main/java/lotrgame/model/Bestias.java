/**
 * Self.
 *
 * @return the bestias. bestias builder impl
 */
package lotrgame.model;

import java.util.Random;

import lombok.experimental.SuperBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class BestiasBuilderImpl.
 * <p>
 * Clase que extiende de Personaje y representa a las bestias del juego.
 * Implementa los metodos atacar y recibirAtaque. Implementa el Builder de
 * Personajes.
 * </p>
 */
@SuperBuilder
public class Bestias extends Personaje {

    /**
     * Atacar.
     * <p>
     * Método que genera un ataque aleatorio entre 0 y 90, con solo una tirada de
     * dados.
     * </p>
     * 
     * @param contrario the contrario (Personaje que recibe el ataque).
     * @return the string (mensaje con el resultado del ataque).
     */
    @Override
    public String atacar(Personaje contrario) {

	// se genera un ataque aleatorio de 0 a 90
	int ataque = new Random().nextInt(0, 91);

	// se retorna el mensaje de la batalla con el ataque
	return contrario.recibirAtaque(ataque, this);
    }

    /**
     * Recibir ataque.
     * <p>
     * Metodo que recibe un ataque y calcula el daño que se le hace al personaje en
     * base a las especificaciones del personaje.
     * </p>
     *
     * @param ataque   the ataque (valor del ataque).
     * @param atacante the atacante (Personaje que ataca).
     * @return the string (mensaje con el resultado del ataque).
     */
    @Override
    public String recibirAtaque(Integer ataque, Personaje atacante) {

	// variable para ataque final
	int ataqueFinal = 0;

	// se comprueba si la armadura es menor al ataque
	if (this.getArmadura() < ataque) {
	    // se resta la armadura al ataque
	    ataqueFinal = ataque - this.getArmadura();
	    // se resta el ataque final a la vida
	    this.setVida(this.getVida() - ataqueFinal);
	}

	// se retorna el mensaje de la batalla
	return mensajeBatalla(atacante, ataque, ataqueFinal, this);

    }

}
