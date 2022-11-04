package edu.uptc.api.services;

import edu.uptc.api.entities.Meet;
import edu.uptc.api.repositories.MeetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MeetService {
    private MeetRepository meetRepository;

    public MeetService(MeetRepository meetRepository) {
        this.meetRepository = meetRepository;
    }

    public List<Meet> getMeets(){return  meetRepository.findAll();}
    public Meet save(Meet meet){return  meetRepository.save(meet);}
    public Meet findById(int id){
        Optional<Meet> optional = meetRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public Meet update(Meet meet){
        return  (findById(meet.getId()) != null) ? meetRepository.save(meet) : null;
    }

    public boolean delete(Meet meet){
        if (meet != null){
            meetRepository.delete(meet);
            return true;
        }else{
            return false;
        }
    }

}
