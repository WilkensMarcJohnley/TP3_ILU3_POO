 package jeu;




import java.util.ListIterator;

import carte.Carte;

public interface Main {
	public void prendre(Carte carte);
	public void jouer(Carte carte);
	public ListIterator<Carte> iterateur();
}
