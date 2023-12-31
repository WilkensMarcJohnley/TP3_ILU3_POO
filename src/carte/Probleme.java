package carte;

public abstract class Probleme extends Carte{
	private Type type;

	public Probleme(Type t,int nombre) {
		super(nombre);
		this.type=t;
	}
	
	public Type getType() {
		return type;
	}
	
	public static enum Type {
		FEU("feu"), ESSENCE("essence"), CREVAISON("crevaison"), ACCIDENT("accident");
		
		private String type;

		private Type(String type) {
			this.type = type;
		}
		
		public String toString() {
			return type.toString();
		}
		
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Probleme) {
			if(super.equals(obj)) {
				Probleme new_obj= (Probleme) obj;
				return type==new_obj.getType();
			}
		}
		return false;
	}
}
