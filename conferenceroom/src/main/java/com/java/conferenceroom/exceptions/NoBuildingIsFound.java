package com.java.conferenceroom.exceptions;

public class NoBuildingIsFound extends RuntimeException {
    public NoBuildingIsFound(String no_building_is_found) {
        super(no_building_is_found);
    }
}
