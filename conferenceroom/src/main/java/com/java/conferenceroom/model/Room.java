package com.java.conferenceroom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Room {

    private  int id;
    private String name;
    private Floor floor;
    private Buildings buildings;
    SlotType[]slots= new SlotType[24];


}
