package edu.uptc.api.controllers;

import edu.uptc.api.entities.Act;
import edu.uptc.api.services.ActService;
import edu.uptc.api.services.MeetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/acts")
public class ActController {
    private ActService actService;
    private MeetService meetService;

    public ActController(ActService actService, MeetService meetService) {
        this.actService = actService;
        this.meetService = meetService;
    }

    @GetMapping
    public List<Act> getActs(){return  actService.getActs();}

    @GetMapping("/{id}")
    public Act findById(@PathVariable int id){return actService.findById(id);}

    @PostMapping
    public Act save(@RequestBody Act act){
      if (meetService.findById(act.getMeet().getId()) != null){
            return actService.save(new Act(act.getDescription(), meetService.findById(act.getMeet().getId())));
        }

      return null;
    }

    @PutMapping
    public Act update(@RequestBody Act act, @PathVariable int id){
        if (meetService.findById(act.getMeet().getId()) != null){
            return actService.update(new Act(act.getDescription(), meetService.findById(act.getMeet().getId())));
        }else {
            return null;
        }
    }
    @DeleteMapping("/{id}")
    public  boolean delete(@PathVariable int id){return  actService.delete(findById(id));}
}
