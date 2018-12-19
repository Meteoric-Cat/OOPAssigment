package helper;

import model.database.MainEntity;
import model.database.Origin;

public class EntityFactory {
	public MainEntity getEntity(String type, String identifier, String label, String description, Origin origin) {
		MainEntity mainEntity = new MainEntity(type, identifier, label, description, origin) {} ;
		return mainEntity;	
	}
}
