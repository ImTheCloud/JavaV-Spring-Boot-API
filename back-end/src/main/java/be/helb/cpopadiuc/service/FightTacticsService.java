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

    // Injecting FightTacticsRepository dependency
    private final FightTacticsRepository fightTacticsRepository;

    @Autowired
    public FightTacticsService(FightTacticsRepository fightTacticsRepository) {
        this.fightTacticsRepository = fightTacticsRepository;
    }

    // Method to retrieve all fight tactics
    public List<FightTactics> getAllFightTactics() {
        return fightTacticsRepository.findAll();
    }

    // Method to add a new fight tactics
    public void addFightTactics(FightTactics fightTactics) {
        fightTacticsRepository.save(fightTactics);
    }

    // Method to delete a fight tactics by ID
    public boolean deleteFightTacticsById(Long id) {
        Optional<FightTactics> optionalFightTactics = fightTacticsRepository.findById(id);
        if (optionalFightTactics.isPresent()) {
            fightTacticsRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
