package model.business;

public class Organization extends MainEntity {
	private String headquarter;
	
	public Organization(String type, String identifier, String label, String description, Origin origin, String headquarter) {
        super(type, identifier, label, description, origin);
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
