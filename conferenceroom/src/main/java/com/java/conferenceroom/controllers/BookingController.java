package com.java.conferenceroom.controllers;

import com.java.conferenceroom.dtos.CreateBookingRequest;
import com.java.conferenceroom.dtos.CreateBuildingRequest;
import com.java.conferenceroom.model.Booking;
import com.java.conferenceroom.model.Buildings;
import com.java.conferenceroom.model.Room;
import com.java.conferenceroom.service.BookingService;
import com.java.conferenceroom.service.BuilderService;
import com.java.conferenceroom.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class BookingController {

    BookingService bookingService;
    CreateBookingRequest createBookingRequest;
    RoomService roomService;

    public  void createBooking(Integer startTime,Integer EndTime,String roomName){
        Room room =roomService.getRoomByName(roomName);
        System.out.println(room);
        Booking booking = createBookingRequest.toBooking(startTime,EndTime);
       Integer id= bookingService.createBooking(booking.getStartTime(),booking.getEndTime(),room);
        System.out.println("Booking id: "+id);
    }

    public  void listBooking(){
        bookingService.listBooking();
    }

    public void cancelBooking(Integer id){
        bookingService.cancelBooking(id);
        System.out.println("Booking cancelled");
    }


}
