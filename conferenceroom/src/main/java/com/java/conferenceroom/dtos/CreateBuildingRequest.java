package com.java.conferenceroom.dtos;


import com.java.conferenceroom.model.Buildings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBuildingRequest {

    private Integer id;
    private String name;

    public Buildings toBuilding(Integer id,String name){
      return   Buildings.builder().id(id).name(name).build();
    }

}
