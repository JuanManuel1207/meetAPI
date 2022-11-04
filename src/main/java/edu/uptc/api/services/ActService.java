package edu.uptc.api.services;

import edu.uptc.api.entities.Act;
import edu.uptc.api.repositories.ActRepository;
import edu.uptc.api.repositories.MeetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ActService {
    private ActRepository actRepository;

    public ActService(ActRepository actRepository) {
        this.actRepository = actRepository;
    }

    public List<Act> getActs(){return actRepository.findAll();}

    public Act save(Act act){
            return actRepository.save(act);

    }
    public Act findById(int id){
        Optional<Act> optional = actRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public Act update(Act act){
        return  (findById(act.getId()) != null) ? actRepository.save(act) : null;
    }

    public boolean delete(Act act){
        if (act != null){
            actRepository.delete(act);
            return true;
        }else{
            return false;
        }
    }
}
