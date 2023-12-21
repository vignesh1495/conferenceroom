package com.java.conferenceroom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Floor {

    private Integer id;
    private Buildings buildings;
    private String name;
    private List<Room> rooms ;

    @Override
    public String toString() {
        return "Floor{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Buildings getBuildings() {
        return buildings;
    }

    public void setBuildings(Buildings buildings) {
        this.buildings = buildings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void addFloor(Room room){
        if(rooms==null){
            rooms=new ArrayList<>();
        }
        rooms.add(room);
    }




}
