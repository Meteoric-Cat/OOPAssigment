package model;

import java.util.LinkedList;

public class Country extends MainEntity{
	private String continent;
	
	public Country(String type, String identifier, String label, String description, LinkedList<Origin> origins, String continent) {
        super(type, identifier, label, description, origins);
        this.continent = continent; 
    }
	// getter
	public String getContinent() {
		return this.continent;
	}
	// setter
	public void setContinent(String continent) {
		this.continent = continent;
	}
}