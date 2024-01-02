package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.DevilFruit;
import be.helb.cpopadiuc.service.DevilFruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    //  endpoint to get a specific devil fruit by ID
    @GetMapping("/getByID/{id}")
    public ResponseEntity<DevilFruit> getDevilFruitById(@PathVariable Long id) {
        Optional<DevilFruit> devilFruit = devilFruitService.getDevilFruitById(id);
        return devilFruit.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //  endpoint to update the details of a devil fruit by ID
    @PutMapping("/put/{id}")
    public ResponseEntity<String> updateDevilFruit(@PathVariable Long id, @RequestBody DevilFruit updatedDevilFruit) {
        if (devilFruitService.updateDevilFruit(id, updatedDevilFruit)) {
            return new ResponseEntity<>("DevilFruit updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("DevilFruit not found or unable to update", HttpStatus.NOT_FOUND);
        }
    }
}
