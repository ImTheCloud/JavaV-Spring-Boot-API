// FightTacticsService.java
package be.helb.cpopadiuc.service;

import be.helb.cpopadiuc.model.FightTactics;
import be.helb.cpopadiuc.repository.FightTacticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
}