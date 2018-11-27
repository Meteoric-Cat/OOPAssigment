package model.database;

public class Person extends MainEntity {
	private String position;
	
	// getter
	public String getPosition() {
		return this.position;
	}
	// setter
	public void setCPosition(String position) {
		this.position = position;
	}
}
