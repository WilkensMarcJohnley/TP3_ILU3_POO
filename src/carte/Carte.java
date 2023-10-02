package carte;

public abstract class Carte {
	private int nombre;

	public Carte(int nombre) {
		this.nombre = nombre;
	}
	
	public boolean equals(Object obj) {
		return obj.getClass()==getClass();
	}

	public int getNombre() {
		return nombre;
	}
}
