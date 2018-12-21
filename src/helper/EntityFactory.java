package helper;

import java.util.LinkedList;

import model.Country;
import model.EntityRelationShipManager;
import model.Event;
import model.Location;
import model.MainEntity;
import model.Organization;
import model.Origin;
import model.Person;

public class EntityFactory {	
	public MainEntity getEntity(int typeID, LinkedList<Origin> origins, String... data) {
		//MainEntity mainEntity = new MainEntity(type, identifier, label, description, origin) {} ;
		//MainEntity entity = null;
		String type = EntityRelationShipManager.getInstance().ENTITY_TYPE[typeID];
				
		if (type.equalsIgnoreCase("LOCATION")) {
			return new Location(type, data[0], data[1], data[2], origins);			
		} 
		else if (type.equalsIgnoreCase("PERSON")) {
			return new Person(type, data[0], data[1], data[2], origins, data[3]);				
		} 
		else if (type.equalsIgnoreCase("COUNTRY")) {
			return new Country(type, data[0], data[1], data[2], origins, data[3]);
		} 
		else if (type.equalsIgnoreCase("ORGANIZATION")) {
			return new Organization(type, data[0], data[1], data[2], origins, data[3]);
		}
		else if (type.equalsIgnoreCase("EVENT")) {
			return new Event(type, data[0], data[1], data[2], origins);
		}
		
		return null;	
	}
}
