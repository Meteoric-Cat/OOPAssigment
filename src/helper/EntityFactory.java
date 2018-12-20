package helper;

import model.business.Country;
import model.business.Event;
import model.business.Location;
import model.business.MainEntity;
import model.business.Organization;
import model.business.Origin;
import model.business.Person;
import model.business.Time;
import model.database.EntityRelationShipManager;

public class EntityFactory {	
	public MainEntity getEntity(int typeID, String... data) {
		//MainEntity mainEntity = new MainEntity(type, identifier, label, description, origin) {} ;
		//MainEntity entity = null;
		String type = EntityRelationShipManager.getInstance().ENTITY_TYPE[typeID];
		//create origin
		Origin origin = new Origin(data[0], data[1]);
				
		if (type.equalsIgnoreCase("LOCATION")) {
			return new Location(type, data[2], data[3], data[4], origin);			
		} 
		else if (type.equalsIgnoreCase("PERSON")) {
			return new Person(type, data[2], data[3], data[4], origin, data[5]);				
		} 
		else if (type.equalsIgnoreCase("COUNTRY")) {
			return new Country(type, data[2], data[3], data[4], origin, data[5]);
		} 
		else if (type.equalsIgnoreCase("ORGANIZATION")) {
			return new Organization(type, data[2], data[3], data[4], origin, data[5]);
		}
		else if (type.equalsIgnoreCase("EVENT")) {
			return new Event(type, data[2], data[3], data[4], origin);
		}
		
		return null;	
	}
}
