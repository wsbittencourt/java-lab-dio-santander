package edu.lab.service.imp;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import edu.lab.model.Match;
import edu.lab.repository.MatchRepository;
import edu.lab.service.MatchService;

@Service
public class MatchServiceImp implements MatchService {

	private final MatchRepository matchRepository;

    public MatchServiceImp(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }
	
	@Override
	public Match findById(Long id) {
		return this.matchRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}
	
	@Override
	public Match create(Match matchToCreate) {
		boolean existingClass = matchRepository.existsById(matchToCreate.getId());

        if (existingClass) {
            throw new IllegalArgumentException("Classe de personagem com o mesmo nome já existe.");
        }

        return matchRepository.save(matchToCreate);
    }

	@Override
	public List<Match> findAll() {
		return matchRepository.findAll();
	}

}
