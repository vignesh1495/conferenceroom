package com.java.conferenceroom.dtos;


import com.java.conferenceroom.model.Buildings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CreateBuildingRequest {

    private String name="B";

    public Buildings toBuilding(){

      return   Buildings.builder().name(name).build();
    }

}
