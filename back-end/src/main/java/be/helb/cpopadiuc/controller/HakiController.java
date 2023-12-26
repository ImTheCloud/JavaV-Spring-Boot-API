package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.Haki;
import be.helb.cpopadiuc.service.HakiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Configuring Cross-Origin Resource Sharing (CORS) for the controller
@CrossOrigin(origins = "http://localhost:3000")
@RestController

// Request mapping for the API endpoints related to haki
@RequestMapping("/api/haki")
public class HakiController {

    // Injecting HakiService dependency
    private final HakiService hakiService;

    @Autowired
    public HakiController(HakiService hakiService) {
        this.hakiService = hakiService;
    }

    // Handling HTTP GET request to retrieve all haki
    @GetMapping
    public List<Haki> getAllHaki() {
        return hakiService.getAllHaki();
    }

    // Handling HTTP POST request to add a new haki
    @PostMapping("/add")
    public ResponseEntity<String> addHaki(@RequestBody Haki haki) {
        hakiService.addHaki(haki);
        return new ResponseEntity<>("Haki added successfully!", HttpStatus.OK);
    }

    // Handling HTTP DELETE request to delete a haki by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHaki(@PathVariable Long id) {
        if (hakiService.deleteHakiById(id)) {
            return new ResponseEntity<>("Haki deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Haki not found or unable to delete", HttpStatus.NOT_FOUND);
        }
    }
}
