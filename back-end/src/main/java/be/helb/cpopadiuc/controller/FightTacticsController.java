package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.FightTactics;
import be.helb.cpopadiuc.service.FightTacticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
}