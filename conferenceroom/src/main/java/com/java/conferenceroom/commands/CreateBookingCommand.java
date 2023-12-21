package com.java.conferenceroom.commands;

import com.java.conferenceroom.controllers.BookingController;
import com.java.conferenceroom.controllers.FloorController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Component
@AllArgsConstructor
public class CreateBookingCommand implements Command{


    private BookingController bookingController;





    private final String commands ="BOOK";

    @Override
    public boolean matches(String input) {
        String[] array =   input.split(" ");
        return array.length>=2 && array[0].equals("BOOK");
    }

    @Override
    public void execute(String input) {
        String[] array =   input.split(" ");

        bookingController.createBooking(Integer.parseInt(array[1]),Integer.parseInt(array[2]),array[3]);
    }
}
