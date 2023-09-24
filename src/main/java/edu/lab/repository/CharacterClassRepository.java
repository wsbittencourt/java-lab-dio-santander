package edu.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.lab.model.CharacterClass;

public interface CharacterClassRepository extends JpaRepository<CharacterClass, Long>{

	boolean existsByClassName(String name);

}
