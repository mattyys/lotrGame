package lotrgame.model;

import java.util.Random;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Bestias extends Personaje {

	@Override
	public String atacar(Personaje contrario) {
		
		//se genera un ataque aleatorio de 0 a 90
		int ataque = new Random().nextInt(0,91);
		
		return contrario.recibirAtaque(ataque, this);
	}

	@Override
	public String recibirAtaque(Integer ataque, Personaje atacante) {
		
		int ataqueFinal = 0;
		
		if(this.getArmadura() < ataque) {
			ataqueFinal = ataque - this.getArmadura();
			this.setVida(this.getVida() - ataqueFinal);
		}
		
		return mensajeBatalla(atacante, ataque, ataqueFinal, this);
		//return("\t" + atacante.getNombre() + " saca " + ataque + " y le quita " + ataqueFinal + " de vida a " + this.getNombre());
		
	}
	
	

}
