package com.java.conferenceroom.repository;

import com.java.conferenceroom.model.Buildings;
import com.java.conferenceroom.model.Floor;
import com.java.conferenceroom.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class FloorRepository {

    static Integer counter= 0;
    public  Map<Integer, Floor> floorMap = new HashMap<>();

    public Floor create(Floor floor) {

        counter++;
        floor.setId(counter);
        floorMap.put(counter,floor);
        return floor;
    }


    public Room addRoom (String floorName, Room room){
        for(Map.Entry<Integer,Floor>map : floorMap.entrySet()){
            if(map.getValue().getName().equals(floorName)){
                Floor floors = map.getValue();
                floors.addFloor(room);
                break;
            }
        }
        return room;
    }


    public Floor getFloor (String floorName){
        for(Map.Entry<Integer,Floor>map : floorMap.entrySet()){
            if(map.getValue().getName().equals(floorName)){
                Floor floor = map.getValue();
                return floor;
            }
        }
        return null;
    }
}
