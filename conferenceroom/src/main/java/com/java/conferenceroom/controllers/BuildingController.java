package com.java.conferenceroom.controllers;

import com.java.conferenceroom.dtos.CreateBuildingRequest;
import com.java.conferenceroom.model.Buildings;
import com.java.conferenceroom.service.BuilderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class BuildingController {

    BuilderService builderService;
    CreateBuildingRequest createBuildingRequest;

    public  void createBuilding(){
       Buildings buildings= builderService.createBuilding(createBuildingRequest.toBuilding());
        System.out.println(buildings.toString());
    }

}
