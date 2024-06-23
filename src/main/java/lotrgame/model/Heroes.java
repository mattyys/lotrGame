package lotrgame.model;

import java.util.Random;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Heroes extends Personaje{

	@Override
	public String atacar(Personaje contrario) {
		int dado1 = new Random().nextInt(0,101);
		int dado2 = new Random().nextInt(0,101);
		int ataque = Math.max(dado1, dado2);

		//si el atacante es un Elfo y el atacado es un Orco, el ataque aumenta 10 puntos
		if (this.getRaza().equals(RazaPersonajes.ELFO) && contrario.getRaza().equals(RazaPersonajes.ORCO)) {
			ataque += 10;
		}
		//si el atacante es un Hobbit y el atacado es un Trasgo, el ataque disminuye 5 puntos
		if (this.getRaza().equals(RazaPersonajes.HOBBIT) && contrario.getRaza().equals(RazaPersonajes.TRASGO)) {
			ataque -= 5;
		}
		
		return contrario.recibirAtaque(ataque, this);
	}

	@Override
	public String recibirAtaque(Integer ataque, Personaje atacante) {
		
		//se guarada la armadura del personaje en una variable
		int armadura = this.getArmadura();
		int ataqueFinal = 0;
		
		//si el que realiza el ataque es un Orco la armadua dimunuye un 10% solo en el ataque
		if(atacante.getRaza().equals(RazaPersonajes.ORCO)) {
			armadura -= (armadura * 0.1);
		}
		
		//si el ataque es mayor a la armadura, se resta la diferencia a la vida
		if(ataque> this.getArmadura()) {
			ataqueFinal = ataque - armadura;
			this.setVida(this.getVida() - ataqueFinal);
		}
		
		return mensajeBatalla(atacante, ataque, ataqueFinal, this);
		
		//return ("\t" + atacante.getNombre() + " saca " + ataque + " y le quita " + ataqueFinal + " de vida a " + this.getNombre());

	}

}
