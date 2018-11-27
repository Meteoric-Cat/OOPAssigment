package model.business;

public class EntityRelationShipManager {
	private int personAmount = 0;
	private int organizationAmount = 0;
	private int countryAmount = 0;
	private int eventAmount = 0;
	private int locationAmount = 0;
	private int relationshipAmount = 0;
	
	public int getPersonAmount() {
		return personAmount;
	}
	public int getOrganizationAmount() {
		return organizationAmount;
	}
	public int getCountryAmount() {
		return countryAmount;
	}
	public int getRelatrionshipAmount() {
		return relationshipAmount;
	}
	public int getEventAmount() {
		return eventAmount;
	}
	public int getLocationAmount() {
		return locationAmount;
	}
	
	
	public void increasePersonAmount() {
		this.personAmount++;
	}
	public void increaseOrganizationAmount() {
		this.organizationAmount++;
	}
	public void increaseCountryAmount() {
		this.countryAmount++;
	}
	public void increaseLocationAmount() {
		this.locationAmount++;
	}
	public void increaseEventAmount() {
		this.eventAmount++;
	}
	public void increaseRelationshipAmount() {
		this.relationshipAmount++;
	}
	
	public void decreasePersonAmount() {
		this.personAmount--;
	}
	public void decreaseOrganizationAmount() {
		this.organizationAmount--;
	}
	public void decreaseCountryAmount() {
		this.countryAmount--;
	}
	public void decreaseLocationAmount() {
		this.locationAmount--;
	}
	public void decreaseEventAmount() {
		this.eventAmount--;
	}
	public void decreaseRelationshipAmount() {
		this.relationshipAmount--;
	}
}
