package com.java.conferenceroom.repository;

import com.java.conferenceroom.model.Booking;
import com.java.conferenceroom.model.BookingStatus;
import com.java.conferenceroom.model.Room;
import com.java.conferenceroom.model.SlotType;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BookingRepository {

    static Integer  counter =1;

    Map<Integer, Booking> map = new HashMap<>();

    public void bookSlot(Integer startTime,Integer endTime,Room room){
        SlotType[]slot = room.getSlots();
        for(int i=startTime;i<endTime;i++){
            slot[i]=SlotType.BOOKED;
        }
    }

    public Integer addBooking(Booking booking){
        counter++;
        map.put(counter,booking);
        return counter ;
    }

    public Booking getBooking(Integer id){
        Booking booking = map.get(id);
//        booking.setBookingStatus(BookingStatus.CANCELLED);
//        for(int i=startTime;i<endTime;i++){
//            slot[i]=SlotType.BOOKED;
//        }
        return  booking;
    }











}
