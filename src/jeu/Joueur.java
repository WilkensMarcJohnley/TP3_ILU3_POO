package jeu;

import java.util.List;
import java.util.ListIterator;
import java.util.NavigableSet;

import carte.Bataille;
import carte.Borne;
import carte.Botte;
import carte.Carte;
import carte.Limite;

public class Joueur {
	private String nom;
	private NavigableSet<Botte> pileBotte;//il faut un comparateur
	private List<Bataille> pileBataille; // il faut aussi faire des initialisations avec vide
	private List<Limite> pileLimite;
	private List<Borne> pileBorne;
	private MainAsListe main;
	
	public Joueur(String nom, NavigableSet<Botte> pileBotte, List<Bataille> pileBataille, List<Limite> pileLimite,
			List<Borne> pileBorne, MainAsListe main) {
		this.nom = nom;
		this.pileBotte = pileBotte;
		this.pileBataille = pileBataille;
		this.pileLimite = pileLimite;
		this.pileBorne = pileBorne;
		this.main=main;
	}

	public String getNom() {
		return nom;
	}

	public NavigableSet<Botte> getPileBotte() {
		return pileBotte;
	}

	public List<Bataille> getPileBataille() {
		return pileBataille;
	}

	public List<Limite> getPileLimite() {
		return pileLimite;
	}

	public List<Borne> getPileBorne() {
		return pileBorne;
	}
	
	public MainAsListe getMain() {
		return main;
	}

	@Override
	public String toString() {
		return nom;
	}
	
	@Override
	public boolean  equals(Object obj) {
		boolean result= false;
		if(obj instanceof Joueur) {
			Joueur newJoueur= (Joueur) obj;
			result=toString().equals(newJoueur.toString());
		}
		return result;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(List<Carte> sabot) {
		if(!sabot.isEmpty()) {
			Carte carte=sabot.get(0);
			donner(carte);
			sabot.remove(0);
			return carte;
		}
		return null;
	}
	
	public int getKM() {
		int somme=0;
		for(ListIterator<Borne> it=pileBorne.listIterator(); it.hasNext();) {
			somme+=it.next().getKm();		}
		return somme;
	}

	
	
}
