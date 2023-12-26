package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.DevilFruit;
import be.helb.cpopadiuc.service.DevilFruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Configuring Cross-Origin Resource Sharing (CORS) for the controller
@CrossOrigin(origins = "http://localhost:3000")
@RestController

// Request mapping for the API endpoints related to devil fruits
@RequestMapping("/api/devil-fruits")
public class DevilFruitController {

    // Injecting DevilFruitService dependency
    private final DevilFruitService devilFruitService;

    @Autowired
    public DevilFruitController(DevilFruitService devilFruitService) {
        this.devilFruitService = devilFruitService;
    }

    // Handling HTTP GET request to retrieve all devil fruits
    @GetMapping
    public List<DevilFruit> getAllDevilFruits() {
        return devilFruitService.getAllDevilFruits();
    }

    // Handling HTTP POST request to add a new devil fruit
    @PostMapping("/add")
    public ResponseEntity<String> addDevilFruit(@RequestBody DevilFruit devilFruit) {
        devilFruitService.addDevilFruit(devilFruit);
        return new ResponseEntity<>("DevilFruit added successfully!", HttpStatus.OK);
    }

    // Handling HTTP DELETE request to delete a devil fruit by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDevilFruit(@PathVariable Long id) {
        if (devilFruitService.deleteDevilFruitById(id)) {
            return new ResponseEntity<>("DevilFruit deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("DevilFruit not found or unable to delete", HttpStatus.NOT_FOUND);
        }
    }
}
