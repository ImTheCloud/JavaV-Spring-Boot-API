// FightTacticsService.java
package be.helb.cpopadiuc.service;

import be.helb.cpopadiuc.model.FightTactics;
import be.helb.cpopadiuc.repository.FightTacticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
