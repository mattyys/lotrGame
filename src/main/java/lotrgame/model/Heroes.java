/**
 * Self.
 *
 * @return the heroes. heroes builder impl
 */
/**
 * Self.
 *
 * @return the heroes. heroes builder impl
 */
package lotrgame.model;

import java.util.Random;

import lombok.experimental.SuperBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class HeroesBuilderImpl.
 * <p>
 * Esta clase extiende de Personaje y representa a los heroes del juego.
 * Implementa los metodos atacar y recibirAtaque. Implementa el
 * Builder de Personajes.
 * </p>
 */
@SuperBuilder
public class Heroes extends Personaje {

    /**
     * The disminuir armadura.
     * <p>
     * Constante con el valor a dismunir de 10% aplicado a la armadura segun la
     * especificacion del tipo de raza.
     * </p>
     */
    private final float DISMINUIR_ARMADURA = 0.1f;

    /**
     * Atacar.
     * <p>
     * Metodo que genera un ataque aleatorio entre 0 y 100 resultante de dos tiros
     * de dados yseleccionando el mayor numero. Si el atacante es un Elfo y el
     * atacado es un Orco, el ataque aumenta 10 puntos. Si el atacante es un Hobbit
     * y el atacado es un Trasgo, el ataque disminuye 5 puntos.
     * </p>
     *
     * @param contrario the contrario (Personaje que recibe el ataque).
     * @return the string (mensaje con el resultado del ataque)
     */
    @Override
    public String atacar(Personaje contrario) {
	int dado1 = new Random().nextInt(0, 101);
	int dado2 = new Random().nextInt(0, 101);
	int ataque = Math.max(dado1, dado2);

	// si el atacante es un Elfo y el atacado es un Orco, el ataque aumenta 10
	// puntos
	if (this.getRaza().equals(RazaPersonajes.ELFO) && contrario.getRaza().equals(RazaPersonajes.ORCO)) {
	    ataque += 10;
	}
	// si el atacante es un Hobbit y el atacado es un Trasgo, el ataque disminuye 5
	// puntos
	if (this.getRaza().equals(RazaPersonajes.HOBBIT) && contrario.getRaza().equals(RazaPersonajes.TRASGO)) {
	    ataque -= 5;
	}

	return contrario.recibirAtaque(ataque, this);
    }

    /**
     * Recibir ataque.
     * <p>
     * Metodo que recibe un ataque y calcula el daño que se le hace al personaje. Si
     * el atacante es un Orco la armadura disminuye un 10% solo en el ataque. Si el
     * ataque es mayor a la armadura, se resta la diferencia a la vida.
     * </p>
     * 
     * @param ataque   the ataque (la potencia recibida del ataque).
     * @param atacante the atacante (Personaje que ataca).
     * @return the string (un mensaje con el resultado del ataque).
     */
    @Override
    public String recibirAtaque(Integer ataque, Personaje atacante) {

	// se guarada la armadura del personaje en una variable
	int armadura = this.getArmadura();
	int ataqueFinal = 0;

	// si el que realiza el ataque es un Orco la armadua dismunuye un 10% solo en el
	// ataque
	if (atacante.getRaza().equals(RazaPersonajes.ORCO)) {
	    armadura -= (armadura * DISMINUIR_ARMADURA);
	}

	// si el ataque es mayor a la armadura, se resta la diferencia a la vida
	if (ataque > armadura) {
	    ataqueFinal = ataque - armadura;
	    this.setVida(this.getVida() - ataqueFinal);
	}

	return mensajeBatalla(atacante, ataque, ataqueFinal, this);

    }

}
