package edu.lab.service.imp;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import edu.lab.model.Player;
import edu.lab.repository.PlayerRepository;
import edu.lab.service.PlayerService;

@Service
public class PlayerServiceImp implements PlayerService {
	
	private final PlayerRepository playerRepository;
	
	public PlayerServiceImp(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	@Override
	public Player findById(Long id) {
		return playerRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Player create(Player playerToCreate) {
		if (playerRepository.existsByName(playerToCreate.getName())) {
			throw new IllegalArgumentException("This player name already existis.");
		}
		return playerRepository.save(playerToCreate);
	}

	@Override
	public List<Player> findAll() {
		return playerRepository.findAll();
	}

}
