package com.java.conferenceroom.controllers;

import com.java.conferenceroom.dtos.CreateFloorRequest;
import com.java.conferenceroom.dtos.CreateRoomRequest;
import com.java.conferenceroom.model.Room;
import com.java.conferenceroom.service.FloorService;
import com.java.conferenceroom.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class RoomController {


    RoomService roomService;
    CreateRoomRequest createRoomRequest;

    public  void createFloor(String[] command){
        createRoomRequest.setFloorName(command[3]);
        createRoomRequest.setBuildingName(command[4]);
       Room room = roomService.createRoom(createRoomRequest.toRoom(command[2]),createRoomRequest);
       System.out.println(room);

    }

    public void listRooms(){
        roomService.getAvailableSlotInfo();
    }
}
