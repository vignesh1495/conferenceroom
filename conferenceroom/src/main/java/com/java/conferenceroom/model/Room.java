package com.java.conferenceroom.model;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Room {

    private  int id;
    private String name;
    private Floor floor;
    private Buildings buildings;
    private SlotType[]slots;


    public SlotType[] getSlotFromModel() {
        SlotType[] type= new SlotType[24];
        for(int i=0;i<type.length;i++){
            type[i]=SlotType.AVAILABE;
        }
        this.slots=type;
        return  type;
    }
}
