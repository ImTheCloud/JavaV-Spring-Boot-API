package be.helb.cpopadiuc.service;

import be.helb.cpopadiuc.model.Fight;
import be.helb.cpopadiuc.repository.FightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FightService {

    private final FightRepository fightRepository;

    @Autowired
    public FightService(FightRepository fightRepository) {
        this.fightRepository = fightRepository;
    }

    public List<Fight> getAllFights() {
        return fightRepository.findAll();
    }

    public void addFight(Fight fight) {
        fightRepository.save(fight);
    }
}