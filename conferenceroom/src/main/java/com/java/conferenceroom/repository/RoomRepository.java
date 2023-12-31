package com.java.conferenceroom.repository;


import com.java.conferenceroom.model.Buildings;
import com.java.conferenceroom.model.Floor;
import com.java.conferenceroom.model.Room;
import com.java.conferenceroom.model.SlotType;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RoomRepository {

    static Integer counter= 0;
    public  Map<Integer, Room> roomMap = new HashMap<>();
    public Room create(Room room) {
        counter++;
        room.setId(counter);
        roomMap.put(counter,room);
        return room;
    }


    public Room getRoom (Integer id){
        return roomMap.get(id);
    }

    public  int getSize(){
        return roomMap.size();
    }


    public boolean isPresent(Room room){
      return   roomMap.entrySet().stream().filter(e->e.getValue().getName().equals(room.getName())).count()>0;
    }

    public Room findRoom (String roomName){
        for(Map.Entry<Integer, Room>map : roomMap.entrySet()){
            if(map.getValue().getName().equals(roomName)){
                return map.getValue();
            }
        }
        return null;
    }
}
