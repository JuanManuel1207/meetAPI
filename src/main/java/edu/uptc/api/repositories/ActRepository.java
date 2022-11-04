package edu.uptc.api.repositories;

import edu.uptc.api.entities.Act;
import edu.uptc.api.entities.Meet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ActRepository extends JpaRepository<Act, Integer> {

}
