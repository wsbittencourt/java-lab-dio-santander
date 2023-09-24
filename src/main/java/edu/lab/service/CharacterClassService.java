package edu.lab.service;

import java.util.List;

import edu.lab.model.CharacterClass;


public interface CharacterClassService {
	CharacterClass findById(Long id);
	
	CharacterClass create(CharacterClass classToCreate);

	List<CharacterClass> findAll();
}
