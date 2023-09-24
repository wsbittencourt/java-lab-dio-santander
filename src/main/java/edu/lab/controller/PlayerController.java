package edu.lab.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.lab.model.Player;
import edu.lab.service.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

	private final PlayerService playerService;
	
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	@GetMapping
	public List<Player> findAll() {
		return playerService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Player> findById(@PathVariable Long id) {
		var player = playerService.findById(id);
		return ResponseEntity.ok(player);
	}
	
	@PostMapping
	public ResponseEntity<Player> create(@RequestBody Player playerToCreate) {
		var playerCreated = playerService.create(playerToCreate);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(playerCreated.getId())
				.toUri();
		return ResponseEntity.created(location).body(playerCreated);
	}
}
