package model;

import java.util.LinkedList;

public class Person extends MainEntity {
	private String position;
	
	public Person(String type, String identifier, String label, 
			String description, LinkedList<Origin> origins, String position) {
        super(type, identifier, label, description, origins);
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
