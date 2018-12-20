package model.business;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	private Date date;
	
	public Time(String date) {
		try {
			this.date = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
