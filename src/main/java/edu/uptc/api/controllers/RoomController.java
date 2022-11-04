package edu.uptc.api.controllers;

import edu.uptc.api.entities.Room;
import edu.uptc.api.services.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rooms")
public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    @GetMapping
    public List<Room> getMeets(){return  roomService.getRooms();}
    @GetMapping("/{id}")
    public Room findById(@PathVariable int id){return  roomService.findById(id);}

    @PostMapping
    public Room save(@RequestBody Room room){return roomService.save(room);}

    @PutMapping("/{id}")
    public Room update(@RequestBody Room room, @PathVariable int id){return roomService.update(room);}

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        return roomService.delete(findById(id));
    }
}
