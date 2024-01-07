package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.Fight;
import be.helb.cpopadiuc.service.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fights")
public class FightController {

    private final FightService fightService;

    @Autowired
    public FightController(FightService fightService) {
        this.fightService = fightService;
    }

    @GetMapping("/getAllFights")
    public ResponseEntity<List<Fight>> getAllFights() {
        List<Fight> fights = fightService.getAllFights();
        return ResponseEntity.ok(fights);
    }

    @PostMapping("/addFight")
    public ResponseEntity<Fight> addFight(@RequestBody Fight fight) {
        Fight newFight = fightService.addFight(fight);
        return new ResponseEntity<>(newFight, HttpStatus.CREATED);
    }

    @GetMapping("/findFight/{id}")
    public ResponseEntity<Fight> getFightById(@PathVariable Long id) {
        return fightService.getFightById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deleteFight/{id}")
    public ResponseEntity<Void> deleteFight(@PathVariable Long id) {
        fightService.deleteFightById(id);
        return ResponseEntity.ok().build();
    }
}
