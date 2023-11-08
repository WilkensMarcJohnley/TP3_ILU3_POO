package jeu;

import carte.*;

public class Coup {
	private Carte carte;
	private Joueur joueurCible;
	
	public Coup(Carte carte, Joueur joueurCible) {
		this.carte = carte;
		this.joueurCible = joueurCible;
	}

	public Carte getCarte() {
		return carte;
	}

	public Joueur getJoueurCible() {
		return joueurCible;
	}
	
	public boolean estValide(Joueur j) {
		if(carte instanceof Attaque || carte instanceof FinLimite) {
			return !(j.equals(joueurCible));
		}
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Coup) {
			Coup coup= (Coup) obj;
			return carte.equals(coup.carte) && joueurCible.equals(coup.joueurCible) ;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31*carte.hashCode()*joueurCible.hashCode();
	}
	
}
