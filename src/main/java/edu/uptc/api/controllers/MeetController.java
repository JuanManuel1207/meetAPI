package edu.uptc.api.controllers;

import edu.uptc.api.entities.Meet;
import edu.uptc.api.services.MeetService;
import edu.uptc.api.services.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/meets")
public class MeetController {
    private MeetService meetService;
    private RoomService roomService;

    public MeetController(MeetService meetService, RoomService roomService) {
        this.meetService = meetService;
        this.roomService = roomService;
    }

    @GetMapping
    public List<Meet> getMeets(){return  meetService.getMeets();}

    @GetMapping("/{id}")
    public Meet findById(@PathVariable int id){return  meetService.findById(id);}

    /*
    public Act save(@RequestBody Act act){
        if (meetService.findById(act.getMeet().getId()) != null){
            return actService.save(new Act(act.getDescription(), meetService.findById(act.getMeet().getId())));
        }else {
            return null;
        }
    }
     */
    @PostMapping
    public Meet save(@RequestBody Meet meet){
        if(roomService.findById(meet.getRoom().getId()) != null){
            return meetService.save(new Meet(meet.getAffair(), meet.getDateMeet(), roomService.findById(meet.getRoom().getId())));
        }
        return null;
    }

    @PutMapping("/{id}")
    public Meet update(@RequestBody Meet meet, @PathVariable int id){
        if(roomService.findById(meet.getRoom().getId()) != null){
            return meetService.update(new Meet(meet.getAffair(), meet.getDateMeet(), roomService.findById(meet.getRoom().getId())));
        }else{
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        return meetService.delete(findById(id));
    }
}
