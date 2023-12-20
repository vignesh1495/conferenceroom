package com.java.conferenceroom.service;

import com.java.conferenceroom.model.Buildings;
import com.java.conferenceroom.model.Floor;
import com.java.conferenceroom.repository.BuildingRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class BuilderService {

    BuildingRepository buildingRepository;

    public Buildings createBuilding(Buildings buildings){
        return buildingRepository.create(buildings);
    }

    public Floor addFloor(String buildingName, Floor floor){
        return  buildingRepository.addFloor(buildingName,floor);
    }


}
