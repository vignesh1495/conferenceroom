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
public class Buildings {

    private Integer id;
    private String name;
    private List<Floor> floors =new ArrayList<>();

    @Override
    public String toString() {
        return "Buildings{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", floors=" + floors +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public void addFloor(Floor floor){
        if(floors==null){
            floors=new ArrayList<>();
        }
        floors.add(floor);
    }

}
