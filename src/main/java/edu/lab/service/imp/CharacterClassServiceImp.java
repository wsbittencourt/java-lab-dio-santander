package edu.lab.service.imp;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import edu.lab.model.CharacterClass;
import edu.lab.repository.CharacterClassRepository;
import edu.lab.service.CharacterClassService;

@Service
public class CharacterClassServiceImp implements CharacterClassService {

	private final CharacterClassRepository characterClassRepository;

    public CharacterClassServiceImp(CharacterClassRepository characterClassRepository) {
        this.characterClassRepository = characterClassRepository;
    }
	
	@Override
	public CharacterClass findById(Long id) {
		return this.characterClassRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}
	
	@Override
	public CharacterClass create(CharacterClass classToCreate) {
		boolean existingClass = characterClassRepository.existsByClassName(classToCreate.getClassName());

        if (existingClass) {
            throw new IllegalArgumentException("Classe de personagem com o mesmo nome já existe.");
        }

        return characterClassRepository.save(classToCreate);
    }

	@Override
	public List<CharacterClass> findAll() {
		return characterClassRepository.findAll();
	}

}
