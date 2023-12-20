package com.java.conferenceroom.service;

import com.java.conferenceroom.model.Buildings;
import com.java.conferenceroom.model.Floor;
import com.java.conferenceroom.model.Room;
import com.java.conferenceroom.repository.BuildingRepository;
import com.java.conferenceroom.repository.FloorRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@NoArgsConstructor
@AllArgsConstructor
public class FloorService {

    FloorRepository floorRepository;
    BuildingRepository buildingRepository;

    public Floor createFloor(Floor floor){
        Floor newFloor =  floorRepository.create(floor);
        buildingRepository.addFloor(floor.getBuildings().getName(),floor);
        return newFloor;
    }

    public Room addRoom(String floorName, Room room){
        return floorRepository.addRoom(floorName,room);
    }

}
