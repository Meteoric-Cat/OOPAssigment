package model.database;

public class Person extends MainEntity {
	private String position;
	
	public Person(String type, String identifier, String label, String description, Origin origin, String position) {
        super(type, identifier, label, description, origin);
        this.position = position;
    }
	// getter
	public String getPosition() {
		return this.position;
	}
	// setter
	public void setCPosition(String position) {
		this.position = position;
	}
}
