package com.java.conferenceroom.commands;


import com.java.conferenceroom.controllers.BookingController;
import com.java.conferenceroom.controllers.RoomController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class ListBookingCommand implements Command{



    private BookingController bookingController;




    private final String commands ="LIST BOOKING";

    @Override
    public boolean matches(String input) {
     String[] array =   input.split(" ");
        return array.length==2 && array[0].equals(commands.split(" ")[0]) && array[1].equals(commands.split(" ")[1]);
    }

    @Override
    public void execute(String input) {

        bookingController.listBooking();
    }
}
