package com.java.conferenceroom.exceptions;

public class FloorAlreadyExists extends RuntimeException{
    public FloorAlreadyExists(String floor_already_exists) {
        super(floor_already_exists);
    }
}
