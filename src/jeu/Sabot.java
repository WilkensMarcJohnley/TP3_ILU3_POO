package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import carte.Carte;

public class Sabot<C extends Carte> implements Iterable<C> {
	private C[] tabCarte;
	private int maxnbCartes=110;
	private int indicenbCartes=0;
	private int nbCartes;
	private int indiceIterator=0;
	private int nbOperations=0;
	
	public Sabot(int nbCartes) {
		this.nbCartes = nbCartes;
		tabCarte= (C[]) new Carte[nbCartes];	
	}


	public Carte[] getTabCarte() {
		return tabCarte;
	}
	
	private class Iterateur implements Iterator<C>{
		private int nbOperationsReference=nbOperations;
		private boolean nexteffectue=false;
		
		private void verificationConcurrence(){
			 if (nbOperations != nbOperationsReference) 
			 throw new ConcurrentModificationException();
			 
			 }
		
		@Override
		public boolean hasNext() {
			return indiceIterator<nbCartes;
		}

		@Override
		public C next() {
			verificationConcurrence();
			if(hasNext()) {
				C carte= tabCarte[indiceIterator];
				indiceIterator++;
				nexteffectue=true;
				return carte;
				
			}else {
				throw new NoSuchElementException();		}
		}
		
		@Override
		public void remove() {
			verificationConcurrence();
			if(nbCartes<1 || !nexteffectue) {
				throw new IllegalArgumentException();
			}
			for(int i=indiceIterator-1; i<nbCartes-1;i++) {
				tabCarte[i]=tabCarte[i+1];
			}
			nexteffectue=false;
			indiceIterator--;
			nbCartes--;
			nbOperations++;
			nbOperationsReference++;
		}
	}
	
	public boolean estVide() {
		return nbCartes==0;
	}
	
	public void ajouterCarte(C carte) {
		if(indicenbCartes<nbCartes) {
			tabCarte[indicenbCartes]=carte;
			//setTabCarte(tabCarte);
			indicenbCartes++;
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	public int getNbCartes() {
		return nbCartes;
	}

	public void ajouterCarteFamille(C...cartes) {
		for(C carte: cartes) {
			ajouterCarte(carte);
		}
	}

	
	public Carte piocher() {
		Iterator<C> iter= iterator(); 
		Carte carte=iter.next();
		iter.remove();
		return carte;
	}

	@Override
	public Iterator<C> iterator() {
		return new Iterateur();
	}

	
}
