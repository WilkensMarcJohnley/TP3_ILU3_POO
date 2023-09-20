package carte;

public class Parade extends Bataille{

	public Parade(Type t, int nombre) {
		super(t, nombre);
		// TODO Auto-generated constructor stub
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
		
		case ACCIDENT: return "Réparations";
		default: return "Fin de limite de vitese";
	}
	
	}
}
