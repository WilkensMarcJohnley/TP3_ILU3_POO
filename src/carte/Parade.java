package carte;

public class Parade extends Bataille{

	public Parade(Type t, int nombre) {
		super(t, nombre);
	}

	public String toString() {
		switch (getType()) {
		case FEU: {
			
			return "Feu vert"; 
		}
		
		case ESSENCE:{
			return "Essence";
		}
		
		case CREVAISON: {
			return "Roue de secours";
		}
		
		case ACCIDENT: return "R�paration";
		
		default: return "Fin de limite de vitese";
	}
	
	}
}
