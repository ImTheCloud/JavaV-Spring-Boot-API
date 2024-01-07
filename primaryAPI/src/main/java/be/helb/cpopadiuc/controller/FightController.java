package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.dto.FightDto;
import be.helb.cpopadiuc.dataAccess.DataAccessFight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Controller for handling fight-related HTTP requests
@RestController
@RequestMapping("/fights")
public class FightController {

    private final DataAccessFight dataAccessFight;

    @Autowired
    public FightController(DataAccessFight dataAccessFight) {
        // Constructor injection of DataAccessFight
        this.dataAccessFight = dataAccessFight;
    }

    @GetMapping("/getAllFights")
    public ResponseEntity<List<FightDto>> getAllFights() {
        // Handles GET request for all fights
        List<FightDto> fights = dataAccessFight.getAllFights();
        return ResponseEntity.ok(fights);
    }
}
