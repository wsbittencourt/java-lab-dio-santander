package edu.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.lab.model.Match;

public interface MatchRepository extends JpaRepository<Match, Long>{

	boolean existsById(Long id);

}
