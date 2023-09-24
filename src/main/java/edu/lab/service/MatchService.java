package edu.lab.service;

import java.util.List;

import edu.lab.model.Match;



public interface MatchService {
	Match findById(Long id);
	
	Match create(Match classToCreate);

	List<Match> findAll();
}
