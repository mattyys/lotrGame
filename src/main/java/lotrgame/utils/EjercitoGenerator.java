package lotrgame.utils;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lotrgame.model.Bestias;
import lotrgame.model.Heroes;
import lotrgame.model.RazaPersonajes;


// TODO: Auto-generated Javadoc
/**
 * The Class EjercitoGenerator.
 */
public class EjercitoGenerator {
	
	/** The heroes. */
	private ObservableList<Heroes> heroes;
	
	/** The bestias. */
	private ObservableList<Bestias> bestias;
	
	/**
	 * Instantiates a new ejercito generator.
	 */
	public EjercitoGenerator() {
		this.heroes = FXCollections.observableArrayList();
		this.bestias =  FXCollections.observableArrayList();
	}
	
	/**
	 * Gets the heroes basico.
	 * <p>Genera un ObservableList de heroes con valores predeterminados</p> 
	 * 
	 * @return the heroes basico
	 */
	public ObservableList<Heroes> getHeroesBasico() {
		heroes.add(Heroes.builder().nombre("Legolas").raza(RazaPersonajes.ELFO).vida(150).armadura(30).build());
		heroes.add(Heroes.builder().nombre("Aragorn").raza(RazaPersonajes.HUMANO).vida(150).armadura(50).build());
		heroes.add(Heroes.builder().nombre("Gimli").raza(RazaPersonajes.ENANO).vida(200).armadura(60).build());
		heroes.add(Heroes.builder().nombre("Boromir").raza(RazaPersonajes.HUMANO).vida(100).armadura(60).build());
		heroes.add(Heroes.builder().nombre("Glorfindel").raza(RazaPersonajes.ELFO).vida(200).armadura(50).build());
		heroes.add(Heroes.builder().nombre("Gandalf").raza(RazaPersonajes.MAGO).vida(300).armadura(70).build());
		heroes.add(Heroes.builder().nombre("Frodo").raza(RazaPersonajes.HOBBIT).vida(20).armadura(10).build());
		return heroes;
	}
	
	/**
	 * Gets the bestias basico.
	 * <p>Genera un ObservableList de bestias con valores predeterminados</p>
	 *
	 * @return the bestias basico
	 */
	public ObservableList<Bestias> getBestiasBasico(){
		bestias.add(Bestias.builder().nombre("Lurtz").raza(RazaPersonajes.ORCO).vida(200).armadura(60).build());
		bestias.add(Bestias.builder().nombre("Shagrat").raza(RazaPersonajes.ORCO).vida(220).armadura(50).build());
		bestias.add(Bestias.builder().nombre("Ugluk").raza(RazaPersonajes.TRASGO).vida(120).armadura(30).build());
		bestias.add(Bestias.builder().nombre("Gorbag").raza(RazaPersonajes.URUKHAIS).vida(250).armadura(50).build());
		bestias.add(Bestias.builder().nombre("Gothmog").raza(RazaPersonajes.TRASGO).vida(100).armadura(30).build());
		bestias.add(Bestias.builder().nombre("Rey Brujo").raza(RazaPersonajes.NAZGUL).vida(300).armadura(70).build());
		return bestias;
	}
		

}
