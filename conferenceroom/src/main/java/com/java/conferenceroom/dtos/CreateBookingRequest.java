package com.java.conferenceroom.dtos;


import com.java.conferenceroom.model.Booking;
import com.java.conferenceroom.model.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CreateBookingRequest {


    private Integer buildingId;
    private Integer roomId;
    private Integer floorId;
    private Integer startTime;
    private Integer endTime;

    public Booking toBooking(Integer startTime,Integer endTime){
        return  Booking.builder().startTime(startTime).endTime(endTime).bookingStatus(BookingStatus.CONFIRMED).build();
    }

}
