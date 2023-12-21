package com.java.conferenceroom.repository;

import com.java.conferenceroom.exceptions.SlotNotAvailable;
import com.java.conferenceroom.model.Booking;
import com.java.conferenceroom.model.BookingStatus;
import com.java.conferenceroom.model.Room;
import com.java.conferenceroom.model.SlotType;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BookingRepository {

    static Integer  counter =0;

    Map<Integer, Booking> map = new HashMap<>();

    public void bookSlot(Integer startTime,Integer endTime,Room room){
        SlotType[]slot = room.getSlots();
        for(int i=startTime;i<endTime;i++){
            slot[i]=SlotType.BOOKED;
        }
    }
    public boolean  checkSlotAvailable(Integer startTime, Integer endTime, Room room) {
        SlotType[]slot = room.getSlots();
        for(int i = startTime; i< endTime; i++){
           if(slot[i].equals(SlotType.BOOKED)){
              return false;
           }
        }
        return true;
    }

    public Integer addBooking(Booking booking){
        counter++;
        booking.setId(counter);
        map.put(counter,booking);
        return counter ;
    }

    public void listAllBooking(){
        for(Map.Entry<Integer,Booking>m : map.entrySet()){
           String buildingName =  m.getValue().getRoom().getBuildings().getName();
           String roomName =  m.getValue().getRoom().getName();
           String floorName = m.getValue().getRoom().getFloor().getName();
           Integer startTime = m.getValue().getStartTime();
           Integer entTime = m.getValue().getEndTime();
           System.out.println(m.getValue().getId()+" building: "+buildingName+" floor: "+
                   floorName+" roomNumber: "+roomName+" startTime: "
                   +startTime+" endTime: "+entTime);
        }
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
