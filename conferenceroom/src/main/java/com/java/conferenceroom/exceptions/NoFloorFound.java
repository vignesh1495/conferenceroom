package com.java.conferenceroom.exceptions;

public class NoFloorFound extends RuntimeException {
    public NoFloorFound(String floor_not_found) {
        super(floor_not_found);
    }
}
