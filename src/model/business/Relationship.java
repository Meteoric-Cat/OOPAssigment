package model.business;

import model.database.MainEntity;

public class Relationship {
	private String type;
	private MainEntity start;
	private MainEntity end;
	
	public Relationship(String type) {
		setType(type);
	}
	// getter
	public String getType() {
		return type;
	};
	public MainEntity getStart() {
		return start;
	};
	public MainEntity getEnd() {
		return end;
	};
	// setter
	public void setType(String type) {
		this.type = type;
	};
	public void setStart(MainEntity start) {
		this.start = start;
	};
	public void setEnd(MainEntity end) {
		this.end = end;
	};
}
