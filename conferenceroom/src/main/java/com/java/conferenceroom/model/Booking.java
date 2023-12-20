package com.java.conferenceroom.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    private int id;
    private Room room;
    private  int startTime;
    private  int endTime;
    private BookingStatus bookingStatus;


}
