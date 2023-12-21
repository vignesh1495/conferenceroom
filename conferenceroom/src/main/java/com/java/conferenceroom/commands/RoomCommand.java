package com.java.conferenceroom.commands;


import com.java.conferenceroom.controllers.RoomController;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class RoomCommand implements Command{



    private RoomController roomController;




    private final String commands ="ADD CONFROOM";

    @Override
    public boolean matches(String input) {
     String[] array =   input.split(" ");
        return array.length>=2 && array[0].equals("ADD") && array[1].equals("CONFROOM");
    }

    @Override
    public void execute(String input) {

        roomController.createFloor(input.split(" "));
    }
}
