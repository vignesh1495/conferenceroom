package com.java.conferenceroom.service;


import com.java.conferenceroom.model.Booking;
import com.java.conferenceroom.model.BookingStatus;
import com.java.conferenceroom.model.SlotType;
import com.java.conferenceroom.repository.BookingRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class BookingService {

    BookingRepository bookingRepository;

    public void  cancelBooking(Integer id){
        Booking booking = bookingRepository.getBooking(id);
        booking.setBookingStatus(BookingStatus.CANCELLED);
        SlotType[]slots= booking.getRoom().getSlots();
        for(int i=booking.getStartTime();i<booking.getEndTime();i++){
           slots[i]=SlotType.AVAILABE;
        }
    }






}
