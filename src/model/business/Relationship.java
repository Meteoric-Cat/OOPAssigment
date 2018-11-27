package model.business;

public class Relationship {
	private String type;
	
	public Relationship(String type) {
		setType(type);
//		increaseRelationshipAmount();
	}
	// getter
	public String getType() {
		return type;
	}
	// setter
	public void setType(String type) {
		this.type = type;
	}
}
