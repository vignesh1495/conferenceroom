package com.java.conferenceroom.service;

import com.java.conferenceroom.dtos.CreateFloorRequest;
import com.java.conferenceroom.exceptions.FloorAlreadyExists;
import com.java.conferenceroom.exceptions.NoBuildingIsFound;
import com.java.conferenceroom.model.Buildings;
import com.java.conferenceroom.model.Floor;
import com.java.conferenceroom.model.Room;
import com.java.conferenceroom.repository.BuildingRepository;
import com.java.conferenceroom.repository.FloorRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class FloorService {

    FloorRepository floorRepository;
    BuildingRepository buildingRepository;

    public Floor createFloor(Floor floor, CreateFloorRequest createFloorRequest){
        Buildings buildings = buildingRepository.getBuilding(createFloorRequest.getBuildingName());
        if(buildings==null){
            throw new NoBuildingIsFound("No Building is Found");
        }
        if(checkIfFloorAleadyExists(floor)){
            throw  new FloorAlreadyExists("floor Already exists");
        }
        floor.setBuildings(buildings);
        floorRepository.create(floor);
         buildings.addFloor(floor);
        return floor;
    }

    private boolean checkIfFloorAleadyExists(Floor floor) {
        return floorRepository.floorMap.entrySet().stream().filter(e->e.getValue().equals(floor.getName())).count()>0;
    }

    public Room addRoom(String floorName, Room room){
        return floorRepository.addRoom(floorName,room);
    }

}
