package edu.uptc.api.repositories;

import edu.uptc.api.entities.Meet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetRepository extends JpaRepository<Meet, Integer> {
}
