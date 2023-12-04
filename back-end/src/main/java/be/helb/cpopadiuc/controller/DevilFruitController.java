package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.DevilFruit;
import be.helb.cpopadiuc.service.DevilFruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/devil-fruits")
public class DevilFruitController {

    private final DevilFruitService devilFruitService;

    @Autowired
    public DevilFruitController(DevilFruitService devilFruitService) {
        this.devilFruitService = devilFruitService;
    }

    @GetMapping
    public List<DevilFruit> getAllDevilFruits() {
        return devilFruitService.getAllDevilFruits();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDevilFruit(@RequestBody DevilFruit devilFruit) {
        devilFruitService.addDevilFruit(devilFruit);
        return new ResponseEntity<>("DevilFruit added successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDevilFruit(@PathVariable Long id) {
        if (devilFruitService.deleteDevilFruitById(id)) {
            return new ResponseEntity<>("DevilFruit deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("DevilFruit not found or unable to delete", HttpStatus.NOT_FOUND);
        }
    }
}