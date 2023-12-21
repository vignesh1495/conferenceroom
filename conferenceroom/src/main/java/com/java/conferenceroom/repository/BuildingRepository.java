package com.java.conferenceroom.repository;

import com.java.conferenceroom.model.Buildings;
import com.java.conferenceroom.model.Floor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BuildingRepository {
    static Integer counter= 0;
    Map<Integer,Buildings> buildingsMap = new HashMap<>();
    public Buildings create(Buildings buildings) {
        counter++;
        buildings.setId(counter);
        StringBuilder sb = new StringBuilder(buildings.getName());
        sb.append(String.valueOf(counter));
        buildings.setName(sb.toString());
        buildingsMap.put(counter,buildings);
        return buildings;
    }
    public Floor addFloor (String buildingName, Floor floor){
            for(Map.Entry<Integer,Buildings>map : buildingsMap.entrySet()){
                if(map.getValue().getName().equals(buildingName)){
                    Buildings buildings = map.getValue();
                    System.out.println(buildings.toString());
                    buildings.addFloor(floor);
                    return floor;
                }
            }
            return null;
    }

    public Buildings getBuilding (String buildingName){
        for(Map.Entry<Integer,Buildings>map : buildingsMap.entrySet()){
            if(map.getValue().getName().equals(buildingName)){
                Buildings buildings = map.getValue();
                return buildings;
            }
        }
        return null;
    }


}
