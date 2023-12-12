package be.helb.cpopadiuc.service;

import be.helb.cpopadiuc.model.Fight;
import be.helb.cpopadiuc.repository.FightRepository;
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

    public List<Fight> getAllFights() {
        return fightRepository.findAll();
    }
//    public String getFightResult(String name1, String name2) {
//        return fightRepository.findResultByNames(name1, name2);
//    }
    public String getFightResult(String name1, String name2) {
        Optional<Fight> optionalFight = fightRepository.findByNames(name1, name2);
        return optionalFight.map(Fight::getResult).orElse("No fight found");
    }
    public void addFight(Fight fight) {
        fightRepository.save(fight);
    }
}