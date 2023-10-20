package carte;

public class Borne extends Carte {
	private int km;
	public Borne(int km, int n) {
		super(n);
		this.km=km;
		// TODO Auto-generated constructor stub
	}
	
public int getKm() {
		return km;
	}

public String toString() {
		
		return "Borne";
	}

public boolean equals(Object obj) {
	if(obj instanceof Borne) {
		if(super.equals(obj)) {
			Borne new_obj= (Borne) obj;
			return new_obj.km==km;
		}
	}
	return false;
}
	
}
