package com.timbuchalka;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dev on 8/12/2015.
 */
public class Location implements Serializable{
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    private long serialVersionUID = 1L;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits != null) {
            this.exits = new LinkedHashMap<>(exits);
        } else {
            this.exits = new LinkedHashMap<>();
        }
        this.exits.put("Q", 0);
    }

    int getLocationID() {
        return locationID;
    }

    String getDescription() {
        return description;
    }

    Map<String, Integer> getExits() {
        return new LinkedHashMap<>(exits);
    }

    void addExit(String direction, int location) {
        exits.put(direction, location);
    }
}
