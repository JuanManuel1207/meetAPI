package edu.uptc.api.services;

import edu.uptc.api.entities.Room;
import edu.uptc.api.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RoomService {
    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getRooms(){return  roomRepository.findAll();}
    public Room save(Room room){return  roomRepository.save(room);}
    public Room findById(int id){
        Optional<Room> optional = roomRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public Room update(Room room){
        return  (findById(room.getId()) != null) ? roomRepository.save(room) : null;
    }

    public boolean delete(Room room){
        if (room != null){
            roomRepository.delete(room);
            return true;
        }else{
            return false;
        }
    }
}
