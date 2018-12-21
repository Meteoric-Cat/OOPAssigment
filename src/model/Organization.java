package model;

import java.util.LinkedList;

public class Organization extends MainEntity {
	private String headquarter;
	
	public Organization(String type, String identifier, String label, String description, LinkedList<Origin> origins, String headquarter) {
        super(type, identifier, label, description, origins);
        this.headquarter = headquarter;
    }
	
	// getter
	public String getHeadquarter() {
		return this.headquarter;
	}
	// setter
	public void setHeadequarter(String headquarter) {
		this.headquarter = headquarter;
	}
	
}
