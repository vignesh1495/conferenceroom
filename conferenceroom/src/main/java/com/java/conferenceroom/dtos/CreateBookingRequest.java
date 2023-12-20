package com.java.conferenceroom.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookingRequest {


    private Integer buildingId;
    private Integer FloorId;
    private Integer slotId;
    private String slotTime;


}
