package tests;

import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import carte.*;
import carte.Probleme.Type;
import jeu.*;

import java.util.ArrayList;
import utils.*;
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
		
//		Test test= new Test();
//		JeuDeCartes jeu= new JeuDeCartes(carte1,carte3,carte2,carte4,carte5,carte6,carte4,carte7);
//		test.testlisteCartes(jeu.getListeCartes());
//		
//		JeuDeCartes jeu = new JeuDeCartes();
//		List<Carte> listeCarteNonMelangee = jeu.getListeCartes();
//		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
//		System.out.println(listeCartes);
//		listeCartes = Utils.melanger(listeCartes);
//		System.out.println(listeCartes);
//		System.out.println("liste mélangée sans erreur ? "
//		+ Utils.verifierMelange(listeCarteNonMelangee, listeCartes));
//		listeCartes = Utils.rassembler(listeCartes);
//		System.out.println(listeCartes);
//		System.out.println("liste rassemblée sans erreur ? " + Utils.verifierRassemblement(listeCartes));
//		
		
		/* test pour le TP3*/
		
		// test getKM
		Carte b0= new Borne(3,1);
		Carte b1= new Borne(5,3);
		Carte b2= new Borne(2,2);
		
		NavigableSet<Botte> pileBotte = new TreeSet<>();//il faut un comparateur
		List<Bataille> pileBataille= new ArrayList<>(); // il faut aussi faire des initialisations avec vide
		List<Limite> pileLimite=new ArrayList<>();
		List<Borne> pileBorne =new ArrayList<>();
		MainAsListe main = new MainAsListe(new ArrayList<>());
		
		JeuDeCartes jeu1= new JeuDeCartes(b0,b1,b2);
		System.out.println(jeu1.getListeCartes());
		pileBorne.add((Borne)b0);
		pileBorne.add((Borne)b1);
		pileBorne.add((Borne)b2);
		Joueur j1= new Joueur("J1",pileBotte,pileBataille,pileLimite,pileBorne);
		System.out.println(j1.getKM());
		
		Carte a1= new Attaque(Type.ACCIDENT,3); 
		Carte a2= new Attaque(Type.FEU,2);
		
		Carte p1= new Parade(Type.ACCIDENT,2);
		Carte p2= new Parade(Type.ESSENCE,4);
		Carte p3= new Parade(Type.CREVAISON,2);
		
		Carte d1= new DebutLimite(2);
		Carte f1= new FinLimite(3);
		
		
	}
}
