package com.java.conferenceroom.commands;


import com.java.conferenceroom.controllers.BuildingController;
import com.java.conferenceroom.controllers.FloorController;
import com.java.conferenceroom.dtos.CreateFloorRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class FloorCommand implements Command{


    private FloorController floorController;





    private final String commands ="ADD FLOOR";

    @Override
    public boolean matches(String input) {
     String[] array =   input.split(" ");
        return array.length>=2 && array[0].equals("ADD") && array[1].equals("FLOOR");
    }

    @Override
    public void execute(String input) {

        floorController.createFloor(input.split(" "));
    }
}
