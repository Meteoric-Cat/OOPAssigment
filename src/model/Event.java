package model;

import java.util.LinkedList;

public class Event extends MainEntity {
	public Event(String type, String identifier, String label, String description, LinkedList<Origin> origins) {
        super(type, identifier, label, description, origins);
    }
}
