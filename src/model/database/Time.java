package model.database;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	private Date date;
	
	public String getDate() {
		return toString(this.date);
	};
	
	public void setDate(Date date) {
		this.date = date;
	};
	
	public String toString(Date date) {
		Format formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(date);
	}
}
