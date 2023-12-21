package com.java.conferenceroom.service;

import com.java.conferenceroom.model.Buildings;
import com.java.conferenceroom.model.Floor;
import com.java.conferenceroom.repository.BuildingRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuilderService {

    BuildingRepository buildingRepository;

    public Buildings createBuilding(Buildings buildings){
        Buildings build = buildingRepository.create(buildings);
        System.out.println(build.getId()+" "+build.getName());
        return build;
    }

    public Floor addFloor(String buildingName, Floor floor){
        return  buildingRepository.addFloor(buildingName,floor);
    }


}
