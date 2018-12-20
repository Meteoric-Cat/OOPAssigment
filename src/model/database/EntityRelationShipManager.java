package model.database;

public class EntityRelationShipManager {
	public final String[] ENTITY_TYPE = {"LOCATION", "PERSON", "ORGANIZATION", "COUNTRY", "EVENT"};	
	private static EntityRelationShipManager instance;	
	
	private int personAmount = 0;
	private int organizationAmount = 0;
	private int countryAmount = 0;
	private int eventAmount = 0;
	private int locationAmount = 0;
	private int relationshipAmount = 0;
	
	private EntityRelationShipManager() {		
	}
	
	public static EntityRelationShipManager getInstance() {
		if (instance == null) {
			instance = new EntityRelationShipManager();
		}
		return instance;
	}
	
	// getters
	public int getPersonAmount() {
		return personAmount;
	}
	public int getOrganizationAmount() {
		return organizationAmount;
	}
	public int getCountryAmount() {
		return countryAmount;
	}
	public int getRelationshipAmount() {
		return relationshipAmount;
	}
	public int getEventAmount() {
		return eventAmount;
	}
	public int getLocationAmount() {
		return locationAmount;
	}
	
	// setters
	public void setPersonAmount(int quantity) {
		this.personAmount = quantity;
	}
	public void setOrganizationAmount(int quantity) {
		this.organizationAmount = quantity;
	}
	public void setCountryAmount(int quantity) {
		this.countryAmount = quantity;
	}
	public void setRelationshipAmount(int quantity) {
		this.relationshipAmount = quantity;
	}
	public void setEventAmount(int quantity) {
		this.eventAmount = quantity;
	}
	public void setLocationAmount(int quantity) {
		this.locationAmount = quantity;
	}
}
