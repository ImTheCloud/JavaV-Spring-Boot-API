package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.Haki;
import be.helb.cpopadiuc.service.HakiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/haki")
public class HakiController {

    private final HakiService hakiService;

    @Autowired
    public HakiController(HakiService hakiService) {
        this.hakiService = hakiService;
    }

    @GetMapping
    public List<Haki> getAllHaki() {
        return hakiService.getAllHaki();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addHaki(@RequestBody Haki haki) {
        hakiService.addHaki(haki);
        return new ResponseEntity<>("Haki added successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHaki(@PathVariable Long id) {
        if (hakiService.deleteHakiById(id)) {
            return new ResponseEntity<>("Haki deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Haki not found or unable to delete", HttpStatus.NOT_FOUND);
        }
    }

    // New endpoint to get a specific Haki by ID
    @GetMapping("/getByID/{id}")
    public ResponseEntity<Haki> getHakiById(@PathVariable Long id) {
        Optional<Haki> haki = hakiService.getHakiById(id);
        return haki.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // New endpoint to update the details of a Haki by ID
    @PutMapping("/put/{id}")
    public ResponseEntity<String> updateHaki(@PathVariable Long id, @RequestBody Haki updatedHaki) {
        if (hakiService.updateHaki(id, updatedHaki)) {
            return new ResponseEntity<>("Haki updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Haki not found or unable to update", HttpStatus.NOT_FOUND);
        }
    }
}
