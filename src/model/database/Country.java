package model.database;

public class Country extends MainEntity{
	private String continent;
	
	public Country(String type, String identifier, String label, String description, Origin origin, String continent) {
        super(type, identifier, label, description, origin);
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