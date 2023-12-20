package com.java.conferenceroom.repository;

import com.java.conferenceroom.model.Buildings;
import com.java.conferenceroom.model.Floor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BuildingRepository {
    static Integer counter= 0;
    Map<Integer,Buildings> buildingsMap = new HashMap<>();
    public Buildings create(Buildings buildings) {
            buildingsMap.put(counter+1,buildings);
            return buildings;
    }
    public Floor addFloor (String buildingName, Floor floor){
            for(Map.Entry<Integer,Buildings>map : buildingsMap.entrySet()){
                if(map.getValue().getName().equals(buildingName)){
                    Buildings buildings = map.getValue();
                    buildings.getFloors().add(floor);
                    break;
                }
            }
            return floor;
    }



}
