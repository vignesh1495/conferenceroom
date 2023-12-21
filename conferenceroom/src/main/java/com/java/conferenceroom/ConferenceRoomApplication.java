package com.java.conferenceroom;

import com.java.conferenceroom.commands.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ConferenceRoomApplication  implements CommandLineRunner {

CommandExecutor commandExecutor;

	private Scanner sc =new Scanner(System.in);
	public static void main(String[] args) {
		SpringApplication.run(ConferenceRoomApplication.class, args);
	}

	@Autowired
	public ConferenceRoomApplication(CommandExecutor commandExecutor, BuildingCommand buildingCommand, FloorCommand floorCommand,
									 RoomCommand roomCommand, ListRoomCommand listRoomCommand,CreateBookingCommand createBookingCommand,
		ListBookingCommand listBookingCommand,CancelBookingCommand cancelBookingCommand){

		this.commandExecutor=commandExecutor;
	}


	@Override
	public void run(String... args) throws Exception {
		commandExecutor.execute("ADD BUILDING");
		commandExecutor.execute("ADD FLOOR B1 1");
		commandExecutor.execute("ADD BUILDING");
		commandExecutor.execute("ADD FLOOR B2 1");
		commandExecutor.execute("ADD FLOOR B2 2");
		commandExecutor.execute("ADD CONFROOM C2 F1 B2");
		commandExecutor.execute("ADD CONFROOM C1 F1 B1");
		commandExecutor.execute("ADD CONFROOM C3 F1 B1");
		commandExecutor.execute("LIST ROOMS");
		commandExecutor.execute("BOOK 1 5 C1");
		commandExecutor.execute("CANCEL 1");
		commandExecutor.execute("LIST ROOMS");
		while (true) {
			try {
				String input = sc.nextLine();
				commandExecutor.execute(input);
				System.out.println("*******************************************************************");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		}

}
