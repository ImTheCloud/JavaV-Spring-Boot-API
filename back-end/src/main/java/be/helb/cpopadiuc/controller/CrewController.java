package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.Crew;
import be.helb.cpopadiuc.service.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Configuring Cross-Origin Resource Sharing (CORS) for the controller
@CrossOrigin(origins = "http://localhost:3000")
@RestController

// Request mapping for the API endpoints related to crews
@RequestMapping("/api/crews")
public class CrewController {

    // Injecting CrewService dependency
    private final CrewService crewService;

    @Autowired
    public CrewController(CrewService crewService) {
        this.crewService = crewService;
    }

    // Handling HTTP GET request to retrieve all crews
    @GetMapping
    public List<Crew> getAllCrews() {
        return crewService.getAllCrews();
    }

    // Handling HTTP POST request to add a new crew
    @PostMapping("/add")
    public ResponseEntity<String> addCrew(@RequestBody Crew crew) {
        crewService.addCrew(crew);
        return new ResponseEntity<>("Crew added successfully!", HttpStatus.OK);
    }

    // Handling HTTP DELETE request to delete a crew by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCrew(@PathVariable Long id) {
        if (crewService.deleteCrewById(id)) {
            return new ResponseEntity<>("Crew deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Crew not found or unable to delete", HttpStatus.NOT_FOUND);
        }
    }
}
