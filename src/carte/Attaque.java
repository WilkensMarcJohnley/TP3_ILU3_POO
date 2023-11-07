package carte;

public class Attaque extends Bataille {

	public Attaque(Type t, int nombre) {
		super(t, nombre);
	}
	
	public String toString() {
		switch (getType()) {
		case FEU: {
			
			return "Feu rouge"; 
		}
		
		case ESSENCE:{
			return "Panne d'essence";
		}
		
		case CREVAISON: {
			return "Crevaison";
		}
		
		case ACCIDENT: return "Accident";
		
		default: return "Limite de vitese";
	}
	
	}

}
