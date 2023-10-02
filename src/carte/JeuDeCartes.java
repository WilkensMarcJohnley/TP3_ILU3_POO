package carte;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class JeuDeCartes {
	private Carte[] typesDeCarte;
	private List<Carte> listeCartes= new ArrayList<>(); 

	public JeuDeCartes(Carte... cartes) {
		this.typesDeCarte = cartes;
		for (Carte carte: cartes) {
			for (int i = 0; i < carte.getNombre(); i++) {
				listeCartes.add(carte);
			}
		}
	}

	public List<Carte> getListeCartes() {
		return listeCartes;
	}
	
	
}
