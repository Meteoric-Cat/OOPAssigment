package model.business;

public class Location extends MainEntity{
	public Location(String type, String identifier, String label, String description, Origin origin) {
        super(type, identifier, label, description, origin);
    }
}
