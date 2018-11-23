package model.database;

public class Country extends MainEntity{
	private String continent;
	
	// getter
	public String getContinent() {
		return this.continent;
	}
	// setter
	public void setContinent(String continent) {
		this.continent = continent;
	}
}