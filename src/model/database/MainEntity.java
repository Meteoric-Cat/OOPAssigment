package model.database;

abstract class MainEntity {
	private String type;
	private String identifier;
	private String label;
	private String description;
	private Origin origin;
	
	// setters
	public String getType() {
		return this.type;
	}
	public String getIdentifier() {
		return this.identifier;
	}
	public String getLabel() {
		return this.label;
	}
	public String getDescription() {
		return this.description;
	}
	public Origin getOrigin() {
		return this.origin;
	}
	// getters
	public void setType(String type) {
		this.type = type;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setOrigin(Origin origin) {
		this.origin = origin;
	}
	
}
