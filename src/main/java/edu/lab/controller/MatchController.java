package edu.lab.controller;

//import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.lab.dto.MatchDTO;
import edu.lab.model.Match;
import edu.lab.model.Player;
import edu.lab.repository.PlayerRepository;
import edu.lab.service.MatchService;


@RestController
@RequestMapping("/matchs")
public class MatchController {

	private final MatchService matchService;
	private final PlayerRepository playerRepository;
	
	public MatchController(MatchService matchService, PlayerRepository playerRepository) {
		this.matchService = matchService;
		this.playerRepository = playerRepository;
	}
	
	@GetMapping
	public List<Match> findAll() {
		return matchService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Match> findById(@PathVariable Long id) {
		var match = matchService.findById(id);
		return ResponseEntity.ok(match);
	}
	
	@PostMapping
	public ResponseEntity<Match> create(@RequestBody MatchDTO matchRequest) {
//		var matchCreated = matchService.create(matchToCreate);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}")
//				.buildAndExpand(matchCreated.getId())
//				.toUri();
//		return ResponseEntity.created(location).body(matchCreated);
		
		List<Long> playerIds = matchRequest.getPlayerIds();
	    List<Player> players = playerRepository.findAllById(playerIds);

	    // Crie o objeto Match com a lista de jogadores
	    Match matchToCreate = new Match();
	    matchToCreate.setPlayers(players);

	    // Configure o status e o jogador vencedor
	    matchToCreate.setStatus(matchRequest.getStatus());

	    // Obtenha o jogador vencedor com base no ID fornecido
	    Long winnerId = matchRequest.getWinnerId();
	    if (winnerId != null) {
	        Optional<Player> winnerOptional = playerRepository.findById(winnerId);
	        if (winnerOptional.isPresent()) {
	            matchToCreate.setWinner(winnerOptional.get());
	        } else {
	            // Lida com o caso em que o ID do jogador vencedor não corresponde a nenhum jogador
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }

	    // Salve o objeto Match no banco de dados
	    Match createdMatch = matchService.create(matchToCreate);

	    return new ResponseEntity<>(createdMatch, HttpStatus.CREATED);
	}
}
