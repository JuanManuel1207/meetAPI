package edu.uptc.api.repositories;

import edu.uptc.api.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RoomRepository extends JpaRepository<Room,Integer>{
}
