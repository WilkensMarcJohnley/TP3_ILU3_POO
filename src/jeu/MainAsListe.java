package jeu;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import carte.Carte;

public class MainAsListe implements Main{
	private List<Carte> main;
	

	public MainAsListe(List<Carte> main) {
		this.main = main;
	}
	
	

	public List<Carte> getMain() {
		return main;
	}



	@Override
	public void prendre(Carte carte) {
		main.add(carte);
	}

	@Override
	public void jouer(Carte carte) {
		assert(main.contains(carte));
		main.remove(carte);
	}

	@Override
	public ListIterator<Carte> iterateur(){
		return main.listIterator();
	}

}
