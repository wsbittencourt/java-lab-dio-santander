package edu.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.lab.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long>{

}
