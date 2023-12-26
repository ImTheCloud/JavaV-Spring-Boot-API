package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.FightTactics;
import be.helb.cpopadiuc.service.FightTacticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Configuring Cross-Origin Resource Sharing (CORS) for the controller
@CrossOrigin(origins = "http://localhost:3000")
@RestController

// Request mapping for the API endpoints related to fight tactics
@RequestMapping("/api/fight-tactics")
public class FightTacticsController {

    // Injecting FightTacticsService dependency
    private final FightTacticsService fightTacticsService;

    @Autowired
    public FightTacticsController(FightTacticsService fightTacticsService) {
        this.fightTacticsService = fightTacticsService;
    }

    // Handling HTTP GET request to retrieve all fight tactics
    @GetMapping
    public List<FightTactics> getAllFightTactics() {
        return fightTacticsService.getAllFightTactics();
    }

    // Handling HTTP POST request to add a new fight tactics
    @PostMapping("/add")
    public ResponseEntity<String> addFightTactics(@RequestBody FightTactics fightTactics) {
        fightTacticsService.addFightTactics(fightTactics);
        return new ResponseEntity<>("FightTactics added successfully!", HttpStatus.OK);
    }

    // Handling HTTP DELETE request to delete a fight tactics by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFightTactics(@PathVariable Long id) {
        if (fightTacticsService.deleteFightTacticsById(id)) {
            return new ResponseEntity<>("FightTactics deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("FightTactics not found or unable to delete", HttpStatus.NOT_FOUND);
        }
    }
}
