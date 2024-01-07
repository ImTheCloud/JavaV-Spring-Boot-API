package be.helb.cpopadiuc.service;

import be.helb.cpopadiuc.repository.FightRepository;
import be.helb.cpopadiuc.model.Fight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FightService {

    private final FightRepository fightRepository;

    @Autowired
    public FightService(FightRepository fightRepository) {
        this.fightRepository = fightRepository;
    }

    // Get all fights
    public List<Fight> getAllFights() {
        return fightRepository.findAll();
    }

    // Add a new fight
    public Fight addFight(Fight fight) {
        return fightRepository.save(fight);
    }

    // Get a fight by ID
    public Optional<Fight> getFightById(Long id) {
        return fightRepository.findById(id);
    }

    // Delete a fight by ID
    public void deleteFightById(Long id) {
        fightRepository.deleteById(id);
    }
}
