package com.java.conferenceroom.commands;

import com.java.conferenceroom.controllers.BookingController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CancelBookingCommand implements Command{

    private BookingController bookingController;
    private final String commands ="CANCEL";

    @Override
    public boolean matches(String input) {
        String[] array =   input.split(" ");
        return array.length==2 && array[0].equals("CANCEL");
    }

    @Override
    public void execute(String input) {
        bookingController.cancelBooking(Integer.parseInt(input.split(" ")[1]));
    }
}
