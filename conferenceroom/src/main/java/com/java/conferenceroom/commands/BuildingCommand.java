package com.java.conferenceroom.commands;

import com.java.conferenceroom.controllers.BuildingController;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
@AllArgsConstructor
public class BuildingCommand implements Command{

    private BuildingController buildingController;



    private final String commands ="ADD BUILDING";

    @Override
    public boolean matches(String input) {
        return input.equalsIgnoreCase(commands);
    }

    @Override
    public void execute(String input) {
        buildingController.createBuilding();
    }
}
