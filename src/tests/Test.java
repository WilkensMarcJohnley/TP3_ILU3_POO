package tests;

import java.util.List;

import carte.*;
import carte.Probleme.Type;

public class Test {
	
	public void testlisteCartes(List<Carte> liste) {
		System.out.println(liste);
	}
	
	public int occCarte(List<Carte> listecarte, Carte carte) {
		int nb=0;
		for(Carte car: listecarte) {
			if(car.equals(carte)) {
				nb++;
			}
		}
		return nb;
	}
	
	public void checkCount() {
		
	}
	
	public static void main(String[] args) {
		Carte carte1= new Attaque(Type.ACCIDENT,3); 
		Carte carte2= new Attaque(Type.FEU,2);
		
		Carte carte3= new Parade(Type.ACCIDENT,2);
		Carte carte4= new Parade(Type.ESSENCE,4);
		
		Carte carte5= new Parade(Type.CREVAISON,2);
		
		Carte carte6= new DebutLimite(2);
		Carte carte7= new FinLimite(3);
		
//		System.out.println(carte1.equals(carte2));
//		System.out.println(carte1.equals(carte3));
//		System.out.println(carte3.equals(carte4));
//		System.out.println(carte4.equals(carte5));
//		System.out.println(carte6.equals(carte7));
//		System.out.println(carte5.equals(carte6));
		
		Test test= new Test();
		JeuDeCartes jeu= new JeuDeCartes(carte1,carte2,carte3,carte4,carte5,carte6,carte7);
		test.testlisteCartes(jeu.getListeCartes());
		
	}
}
