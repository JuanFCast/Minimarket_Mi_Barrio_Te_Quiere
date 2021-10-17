package model;

public class User {
	
	// Atributes
	private Type type;
	private String numID;
	
	
	// Constructor
	public User(Type type, String numID) {
		this.type=type;
		this.numID=numID;
	}
	
	
	// Methods of getters and setters	
	public void setType(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setNumID(String numID) {
		this.numID = numID;
	}
	public String getNumID() {
		return numID;
	}
	


}
