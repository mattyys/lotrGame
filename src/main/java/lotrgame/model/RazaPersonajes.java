package lotrgame.model;

import java.util.List;

public enum RazaPersonajes {
	
	//Heroes
	HUMANO("Humano"), ELFO("Elfo"), ENANO("Enano"), HOBBIT("Hobbit"), MAGO("Mago"),
	//Bestias
	ORCO("Orco"), TRASGO("Trasgo"), URUKHAIS("Uruk-hais"), NAZGUL("Nazgul");
	
	private String nombreRaza;
	
	private RazaPersonajes(String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}
	
	public String getNombreRaza() {
		return nombreRaza;
	}
	
	//metodo estatico para obtener la raza segun el nombre seleccionado
	public static RazaPersonajes getRaza(String nombreRaza) {
		for (RazaPersonajes raza : RazaPersonajes.values()) {
			if (raza.getNombreRaza().equals(nombreRaza)) {
				return raza;
			}
		}
		return null;
	}
	
	//Ltado raza de Heroes
	public static List<RazaPersonajes> getRazaHeroes(){
		return List.of(HUMANO, ELFO, ENANO, HOBBIT, MAGO);
    }
		
	//Ltado raza de Bestias
	public static List<RazaPersonajes> getRazaBestias() {
		return List.of(ORCO, TRASGO, URUKHAIS, NAZGUL);
	}
	
	

}
