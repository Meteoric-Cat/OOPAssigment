package model;

import java.util.LinkedList;

public class Location extends MainEntity{
	public Location(String type, String identifier, String label, String description, LinkedList<Origin> origins) {
        super(type, identifier, label, description, origins);
    }
}
