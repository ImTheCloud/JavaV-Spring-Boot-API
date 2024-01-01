package be.helb.cpopadiuc.service;

import be.helb.cpopadiuc.model.FightTactics;
import be.helb.cpopadiuc.repository.FightTacticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service class to manage business logic for FightTactics entity
@Service
public class FightTacticsService {

    private final FightTacticsRepository fightTacticsRepository;

    @Autowired
    public FightTacticsService(FightTacticsRepository fightTacticsRepository) {
        this.fightTacticsRepository = fightTacticsRepository;
    }

    public List<FightTactics> getAllFightTactics() {
        return fightTacticsRepository.findAll();
    }

    public void addFightTactics(FightTactics fightTactics) {
        fightTacticsRepository.save(fightTactics);
    }

    public boolean deleteFightTacticsById(Long id) {
        Optional<FightTactics> optionalFightTactics = fightTacticsRepository.findById(id);
        if (optionalFightTactics.isPresent()) {
            fightTacticsRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // New method to get a specific fight tactics by ID
    public Optional<FightTactics> getFightTacticsById(Long id) {
        return fightTacticsRepository.findById(id);
    }

    // New method to update a fight tactics by ID
    public boolean updateFightTactics(Long id, FightTactics updatedFightTactics) {
        Optional<FightTactics> optionalFightTactics = fightTacticsRepository.findById(id);
        if (optionalFightTactics.isPresent()) {
            updatedFightTactics.setId(id);
            fightTacticsRepository.save(updatedFightTactics);
            return true;
        } else {
            return false;
        }
    }
}