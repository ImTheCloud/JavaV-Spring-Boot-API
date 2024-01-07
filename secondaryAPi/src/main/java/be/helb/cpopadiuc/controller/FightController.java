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

    // Retrieve all fights
    @GetMapping("/getAllFights")
    public ResponseEntity<List<Fight>> getAllFights() {
        try {
            List<Fight> fights = fightService.getAllFights();
            return ResponseEntity.ok(fights);
        } catch (Exception e) {
            // Internal server error
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Add a new fight
    @PostMapping("/addFight")
    public ResponseEntity<String> addFight(@RequestBody Fight fight) {
        try {
            Fight newFight = fightService.addFight(fight);
            // Successfully added
            return new ResponseEntity<>("Fight added successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            // Bad request if unable to add
            return new ResponseEntity<>("Failed to add fight. Please check the request body.", HttpStatus.BAD_REQUEST);
        }
    }

    // Retrieve a fight by ID
    @GetMapping("/findFight/{id}")
    public ResponseEntity<Fight> getFightById(@PathVariable Long id) {
        try {
            return fightService.getFightById(id)
                    .map(ResponseEntity::ok)
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            // Internal server error
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete a fight by ID
    @DeleteMapping("/deleteFight/{id}")
    public ResponseEntity<String> deleteFight(@PathVariable Long id) {
        try {
            fightService.deleteFightById(id);
            // Successfully deleted
            return new ResponseEntity<>("Fight deleted successfully!", HttpStatus.OK);
        } catch (Exception e) {
            // Bad request if unable to delete
            return new ResponseEntity<>("Failed to delete fight. Please check the provided ID.", HttpStatus.BAD_REQUEST);
        }
    }
}
