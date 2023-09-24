package edu.lab.service;

import java.util.List;

import edu.lab.model.Player;

public interface PlayerService {
	Player findById(Long id);
	
	Player create(Player playerToCreate);

	List<Player> findAll();
}
