package testsFonctionnels;

import java.util.Iterator;

import carte.*;
import carte.Probleme.Type;
import jeu.*;

public class test {
	public static void main(String[] args) {
		Sabot<Carte> sabot= new Sabot<>(6);
		Carte carteAttaque= new Attaque(Type.ACCIDENT,2);
		Carte carteParade= new Parade(Type.ACCIDENT,3);
		sabot.ajouterCarteFamille(carteAttaque,carteAttaque,carteAttaque,carteParade,carteParade,carteParade);
		Carte[] carte=sabot.getTabCarte();
		for (int i = 0; i < carte.length; i++) {
			System.out.println("Je pioche "+ carte[i]);
		}
		System.out.println("\n\n");
		
		Iterator<Carte> iter= sabot.iterator();
		for(;iter.hasNext();) {
			System.out.println("Je pioche "+ iter.next());
			iter.remove();
		}
	}
}
