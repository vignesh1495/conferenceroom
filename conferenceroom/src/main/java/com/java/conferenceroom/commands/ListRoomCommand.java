package com.java.conferenceroom.commands;


import com.java.conferenceroom.controllers.RoomController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class ListRoomCommand implements Command{



    private RoomController roomController;




    private final String commands ="LIST ROOMS";

    @Override
    public boolean matches(String input) {
     String[] array =   input.split(" ");
        return array.length==2 && array[0].equals("LIST") && array[1].equals("ROOMS");
    }

    @Override
    public void execute(String input) {

        roomController.listRooms();
    }
}
