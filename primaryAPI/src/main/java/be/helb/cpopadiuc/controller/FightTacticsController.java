package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.FightTactics;
import be.helb.cpopadiuc.service.FightTacticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/fight-tactics")
public class FightTacticsController {

    private final FightTacticsService fightTacticsService;

    @Autowired
    public FightTacticsController(FightTacticsService fightTacticsService) {
        this.fightTacticsService = fightTacticsService;
    }

    @GetMapping
    public List<FightTactics> getAllFightTactics() {
        return fightTacticsService.getAllFightTactics();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addFightTactics(@RequestBody FightTactics fightTactics) {
        fightTacticsService.addFightTactics(fightTactics);
        return new ResponseEntity<>("FightTactics added successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFightTactics(@PathVariable Long id) {
        if (fightTacticsService.deleteFightTacticsById(id)) {
            return new ResponseEntity<>("FightTactics deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("FightTactics not found or unable to delete", HttpStatus.NOT_FOUND);
        }
    }

    // New endpoint to get a specific fight tactics by ID
    @GetMapping("/{id}")
    public ResponseEntity<FightTactics> getFightTacticsById(@PathVariable Long id) {
        Optional<FightTactics> fightTactics = fightTacticsService.getFightTacticsById(id);
        return fightTactics.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // New endpoint to update the details of a fight tactics by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateFightTactics(@PathVariable Long id, @RequestBody FightTactics updatedFightTactics) {
        if (fightTacticsService.updateFightTactics(id, updatedFightTactics)) {
            return new ResponseEntity<>("FightTactics updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("FightTactics not found or unable to update", HttpStatus.NOT_FOUND);
        }
    }
}
