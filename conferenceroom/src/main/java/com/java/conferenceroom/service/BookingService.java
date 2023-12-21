package com.java.conferenceroom.service;


import com.java.conferenceroom.exceptions.InvalidBookingId;
import com.java.conferenceroom.exceptions.InvalidRoomNumber;
import com.java.conferenceroom.exceptions.InvalidTimeException;
import com.java.conferenceroom.exceptions.NoSlotAvailable;
import com.java.conferenceroom.model.Booking;
import com.java.conferenceroom.model.BookingStatus;
import com.java.conferenceroom.model.Room;
import com.java.conferenceroom.model.SlotType;
import com.java.conferenceroom.repository.BookingRepository;
import com.java.conferenceroom.repository.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class BookingService {

    BookingRepository bookingRepository;

    RoomRepository roomRepository;

    public void  cancelBooking(Integer id){
        Booking booking = bookingRepository.getBooking(id);
        if(booking==null){
          throw new InvalidBookingId();
        }
        booking.setBookingStatus(BookingStatus.CANCELLED);
        SlotType[]slots= booking.getRoom().getSlots();
        for(int i=booking.getStartTime();i<booking.getEndTime();i++){
           slots[i]=SlotType.AVAILABE;
        }
    }

    public Integer createBooking(Integer startTime,Integer endTime,Room room){
        if(!roomRepository.isPresent(room)){
            throw new InvalidRoomNumber();
        }
      if(startTime>endTime || ( startTime>=0 && startTime<24 ) || ( endTime>=0 && endTime<24 ) )  {

          if(!bookingRepository.checkSlotAvailable(startTime,endTime,room)){
              throw new NoSlotAvailable();
          }

          bookingRepository.bookSlot(startTime,endTime,room);
          Booking booking=  Booking.builder().bookingStatus(BookingStatus.CONFIRMED).startTime(startTime).
                  endTime(endTime).room(room).build();
          bookingRepository.addBooking(booking);
        return booking.getId();
      }else{
          throw new InvalidTimeException("Invalid Time Exception");
      }

    }


    public  void listBooking(){
        bookingRepository.listAllBooking();
    }





}
