package model.database;

public class Organization extends MainEntity {
	private String headquarter;
	
	// getter
	public String getHeadquarter() {
		return this.headquarter;
	}
	// setter
	public void setHeadequarter(String headquarter) {
		this.headquarter = headquarter;
	}
	
}
