package model.database;

public class Event extends MainEntity {
	public Event(String type, String identifier, String label, String description, Origin origin) {
        super(type, identifier, label, description, origin);
    }
}
