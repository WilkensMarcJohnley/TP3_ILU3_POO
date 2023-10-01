package carte;

public class Botte extends Probleme {

	public Botte(Type t, int nombre) {
		super(t, nombre);
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		switch (getType()) {
		case FEU: {
			
			return "Vehicule prioritaire"; 
		}
		
		case ESSENCE:{
			return "Citerne d'essence";
		}
		
		case CREVAISON: {
			return "Increvable";
		}
		
		case ACCIDENT: return "As du volant";
		
		default: return null;
	}
	
	}
	
}
