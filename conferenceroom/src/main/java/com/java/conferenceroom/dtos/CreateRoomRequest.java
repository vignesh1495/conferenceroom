package com.java.conferenceroom.dtos;


import com.java.conferenceroom.model.Floor;
import com.java.conferenceroom.model.Room;
import com.java.conferenceroom.model.SlotType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CreateRoomRequest {


    private String name;
    private String floorName;
    private String buildingName;


    public Room toRoom(String roomName){
        SlotType[] type= new SlotType[24];
        for(int i=0;i<type.length;i++){
            type[i]=SlotType.AVAILABE;
        }
      return   Room.builder().name(roomName).slots(type).build();
    }

}
