package com.java.conferenceroom.dtos;


import com.java.conferenceroom.model.Buildings;
import com.java.conferenceroom.model.Floor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CreateFloorRequest {

    private Integer id;
    private String name;
    private String buildingName;

    public Floor toFloor( String name){

      return   Floor.builder().id(Integer.parseInt(name)).name("F"+name).build();
    }

}
