package jeu;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import carte.Attaque;
import carte.Bataille;
import carte.Borne;
import carte.Botte;
import carte.Carte;
import carte.FinLimite;
import carte.Limite;
import carte.Parade;
import carte.Probleme;
import carte.Probleme.Type;

public class Joueur{
	private String nom;
	private NavigableSet<Botte> pileBotte = new TreeSet<>();//il faut un comparateur
	private List<Bataille> pileBataille= new ArrayList<>(); // il faut aussi faire des initialisations avec vide
	private List<Limite> pileLimite=new ArrayList<>();
	private List<Borne> pileBorne =new ArrayList<>();
	private MainAsListe main = new MainAsListe(new ArrayList<>());
	
	public Joueur(String nom, NavigableSet<Botte> pileBotte, List<Bataille> pileBataille, List<Limite> pileLimite,
			List<Borne> pileBorne) {
		this.nom = nom;
		this.pileBotte = pileBotte;
		this.pileBataille = pileBataille;
		this.pileLimite = pileLimite;
		this.pileBorne = pileBorne;
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
			result=nom.equals(newJoueur.toString());
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
			somme+=it.next().getKm();
			}
		return somme;
	}


	public int getLimite() {
		Carte feu= new Botte(Type.FEU,0);
		boolean aux= (pileBotte).contains(feu);
		if(pileLimite.isEmpty() || ((Carte)pileLimite.get(0) instanceof FinLimite)|| aux) {
			return 200;
		}
		return 50;
	}
	
	private boolean fct_aux() {
		Probleme carte= pileBataille.get(0);
		if(carte instanceof Attaque) {
			if(carte.getType()== Type.FEU) {
				return false;
			}
			Carte botte= new Botte(carte.getType(),0);
			return main.getMain().contains(botte);
		}
		return false;
	}
	
	public boolean estBloque() {
		Carte feu= new Botte(Type.FEU,0);
		Carte parade= new Parade(Type.FEU,0);
		Carte attaque= new Attaque(Type.FEU,0);
		boolean prioritaire= pileBotte.contains(feu);
		if((pileBataille.isEmpty() && prioritaire) || (pileBataille.get(0).equals(parade)) 
				|| ((Carte)pileBataille.get(0) instanceof Parade && prioritaire)
				|| (pileBataille.get(0).equals(attaque) && prioritaire)
				|| (fct_aux() && prioritaire)) {
			return false;
		}
		return true;
	}
	
	//TP4
	public Set<Coup> coupsPossibles(List<Joueur> participants) {
		Set<Coup> ensCoup= new HashSet<>();
		for(ListIterator<Carte> it= main.iterateur();it.hasNext();) {
			Carte auxCarte= it.next();
			for(Joueur j: participants) {
				Coup auxCoup= new Coup(auxCarte,j);
				if (auxCoup.estValide(this)) {
					ensCoup.add(auxCoup);
				}
			}
		}
		return ensCoup;
	}
	
	public Set<Coup> coupsParDefault(List<Joueur> participants) {
		Set<Coup> ensCoup=coupsPossibles(participants);
		for(Coup coup: ensCoup) {
			if(coup.getJoueurCible()!=null) {
				ensCoup.remove(coup);
			}
		}
		return ensCoup;
	}
	
	
}
