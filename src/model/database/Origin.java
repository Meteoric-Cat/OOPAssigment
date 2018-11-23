package model.database;

public class Origin {
	private String link;
	private Time time;
	
	// getters
	public String getLink() {
		return this.link;
	}
	public Time time() {
		return this.time;
	}
	// setters
	public void setLink(String link) {
		this.link = link;
	}
	public void setTime(Time time) {
		this.time = time;
	}
}
