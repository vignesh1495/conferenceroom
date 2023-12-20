package com.java.conferenceroom.service;


import com.java.conferenceroom.model.Floor;
import com.java.conferenceroom.model.Room;
import com.java.conferenceroom.model.SlotType;
import com.java.conferenceroom.repository.FloorRepository;
import com.java.conferenceroom.repository.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class RoomService {

    RoomRepository roomRepository;
    FloorRepository floorRepository;

    public Room createRoom(Room room){
        Room newRoom =  roomRepository.create(room);
        floorRepository.addRoom(room.getFloor().getName(),newRoom);
        return room;
    }

    public void getAvailableSlotInformation(){
        int size= roomRepository.getSize();;
        for(int i=1;i<=size;i++){
           Room room =  roomRepository.getRoom(i);
            listAvailableSlotByRoom(room);
        }
    }



    public void listAvailableSlotByRoom (Room room){

        boolean flag=false;
        SlotType[] slotType=room.getSlots();
        int startTime=0;
        int endTime=0;
        List<Integer[]> availableSlot = new ArrayList<>();
        for(int i=0;i<slotType.length;i++){
            if(!flag && slotType[i].equals(SlotType.AVAILABE)){
                startTime=i;
                flag=true;
            }else if(flag && slotType[i].equals(SlotType.BOOKED)){
                endTime=i;
                flag=false;
                availableSlot.add(new Integer[]{startTime,endTime});
               // System.out.println(room.getName()+" "+room.getFloor().getId()+" "room.getBuildings().getId()+" - ");
            }
        }
        if(flag){
            endTime=slotType.length;
            availableSlot.add(new Integer[]{startTime,endTime});
        }
        if(availableSlot.size()>0) {
            System.out.println(room.getName() + " " + room.getFloor().getId() + " " + room.getBuildings().getId() + " - " + availableSlot);
        }
    }

}
