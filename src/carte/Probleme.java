package carte;

public abstract class Probleme extends Carte{
	private Type type;

	public Probleme(Type t,int nombre) {
		super(nombre);
		this.type=t;
		// TODO Auto-generated constructor stub
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
}
