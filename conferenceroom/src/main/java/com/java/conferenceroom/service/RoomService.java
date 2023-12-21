package com.java.conferenceroom.service;


import com.java.conferenceroom.dtos.CreateRoomRequest;
import com.java.conferenceroom.exceptions.NoBuildingIsFound;
import com.java.conferenceroom.exceptions.NoFloorFound;
import com.java.conferenceroom.model.Buildings;
import com.java.conferenceroom.model.Floor;
import com.java.conferenceroom.model.Room;
import com.java.conferenceroom.model.SlotType;
import com.java.conferenceroom.repository.BookingRepository;
import com.java.conferenceroom.repository.BuildingRepository;
import com.java.conferenceroom.repository.FloorRepository;
import com.java.conferenceroom.repository.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class RoomService {

    RoomRepository roomRepository;
    FloorRepository floorRepository;
    BuildingRepository buildingRepository;

    public Room createRoom(Room room, CreateRoomRequest createRoomRequest){
       Buildings building= buildingRepository.getBuilding(createRoomRequest.getBuildingName());
        Floor floor= floorRepository.getFloor(createRoomRequest.getFloorName());
        if(building==null){
            throw new NoBuildingIsFound("No Building is Found");
        }
        if(floor==null){
           throw  new NoFloorFound("Floor Not found");
        }
        room.setBuildings(building);
        room.setFloor(floor);
        Room newRoom =  roomRepository.create(room);
        floorRepository.addRoom(room.getFloor().getName(),newRoom);
        return room;
    }

    public void getAvailableSlotInfo(){
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
            endTime=slotType.length-1;
            availableSlot.add(new Integer[]{startTime,endTime});
        }
        if(availableSlot.size()>0) {
            System.out.print(room.getName() + " " + room.getFloor().getName() + " - " +
                    room.getBuildings().getName());
            for(int i=0;i<availableSlot.size();i++){
                System.out.print( " [ " + availableSlot.get(i)[0]+":"+availableSlot.get(i)[1]+ " ] ");
            }
            System.out.println();
        }
    }

    public Room getRoomByName(String roomName) {

     return roomRepository.roomMap.entrySet().stream().filter(e->e.getValue().getName().equalsIgnoreCase(roomName)).findFirst().get().getValue();
    }
}
