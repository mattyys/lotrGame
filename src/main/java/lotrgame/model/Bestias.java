package lotrgame.model;

import java.util.Random;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Bestias extends Personaje {

    @Override
    public String atacar(Personaje contrario) {

	// se genera un ataque aleatorio de 0 a 90
	int ataque = new Random().nextInt(0, 91);

	// se retorna el mensaje de la batalla con el ataque
	return contrario.recibirAtaque(ataque, this);
    }

    @Override
    public String recibirAtaque(Integer ataque, Personaje atacante) {

	// variable para ataque final
	int ataqueFinal = 0;

	//se comprueba si la armadura es menor al ataque
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
