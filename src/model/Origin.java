package model;

public class Origin {
	private String link;
	private Time time;
	
	public Origin(String link, Time time) {
		this.link = link;
		this.time = time;
	}
	
	public Origin(String link, String time) {
		this.link = link;
		this.time = new Time(time);
	}
	
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
	
	@Override
	public String toString() {
		return "{" + "Link:" + this.link + ", time:" + this.time.getDate() + "}";
	}
}
