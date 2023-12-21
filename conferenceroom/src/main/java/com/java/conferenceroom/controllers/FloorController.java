package com.java.conferenceroom.controllers;


import com.java.conferenceroom.dtos.CreateBuildingRequest;
import com.java.conferenceroom.dtos.CreateFloorRequest;
import com.java.conferenceroom.model.Floor;
import com.java.conferenceroom.service.BuilderService;
import com.java.conferenceroom.service.FloorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class FloorController {

    FloorService floorService;
    CreateFloorRequest createFloorRequest;

    public  void createFloor(String[] command){
        createFloorRequest.setBuildingName(command[2]);
       Floor floor=  floorService.createFloor(createFloorRequest.toFloor(command[3]),createFloorRequest);
        System.out.println(floor.toString());
       // System.out.println(floor.getBuildings().getFloors().size());
    }

}
