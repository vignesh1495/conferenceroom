package com.java.conferenceroom.dtos;


import com.java.conferenceroom.model.Buildings;
import com.java.conferenceroom.model.Floor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFloorRequest {

    private Integer id;
    private String name;
    private Integer buildingId;

    public Floor toBuilding(Integer id, String name){
      return   Floor.builder().id(id).name(name).build();
    }

}
