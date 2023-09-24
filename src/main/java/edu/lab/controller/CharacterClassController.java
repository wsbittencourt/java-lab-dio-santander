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

import edu.lab.model.CharacterClass;
import edu.lab.service.CharacterClassService;


@RestController
@RequestMapping("/classes")
public class CharacterClassController {

	private final CharacterClassService characterClassService;
	
	public CharacterClassController(CharacterClassService characterClassService) {
		this.characterClassService = characterClassService;
	}
	
	@GetMapping
	public List<CharacterClass> findAll() {
		return characterClassService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CharacterClass> findById(@PathVariable Long id) {
		var characterClass = characterClassService.findById(id);
		return ResponseEntity.ok(characterClass);
	}
	
	@PostMapping
	public ResponseEntity<CharacterClass> create(@RequestBody CharacterClass classToCreate) {
		var characterClassCreated = characterClassService.create(classToCreate);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(characterClassCreated.getId())
				.toUri();
		return ResponseEntity.created(location).body(characterClassCreated);
	}
}
