package com.java.conferenceroom.dtos;


import com.java.conferenceroom.model.Floor;
import com.java.conferenceroom.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoomRequest {

    private Integer id;
    private String name;
    private Integer FloorId;

    public Room toBuilding(Integer id, String name){
      return   Room.builder().id(id).name(name).build();
    }

}
