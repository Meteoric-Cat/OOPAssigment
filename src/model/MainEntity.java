package model;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class MainEntity {
	private String type;
	private String identifier;
	private String label;
	private String description;
	private LinkedList<Origin> origins;
	
	public MainEntity(String type, String identifier, String label, String description, LinkedList<Origin> origins) {
        setType(type);
        setIdentifier(identifier);
        setLabel(label);
        setDescription(description);
        setOrigins(origins);
    }
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
	public String getOriginsAsString() {
		StringBuilder result = new StringBuilder();
		Iterator<Origin> iter = this.origins.iterator();
		while (iter.hasNext()) {
			result.append(iter.next().toString());
		}
		return result.toString();
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
	public void setOrigins(LinkedList<Origin> origins) {
		this.origins = origins;
	}
}
