package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.Crew;
import be.helb.cpopadiuc.service.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // Handling HTTP GET request to retrieve a specific crew by ID
    @GetMapping("/getByID/{id}")
    public ResponseEntity<Crew> getCrewById(@PathVariable Long id) {
        Optional<Crew> crew = crewService.getCrewById(id);
        return crew.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Handling HTTP PUT request to update the details of a crew by ID
    @PutMapping("/put/{id}")
    public ResponseEntity<String> updateCrew(@PathVariable Long id, @RequestBody Crew updatedCrew) {
        if (crewService.updateCrew(id, updatedCrew)) {
            return new ResponseEntity<>("Crew updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Crew not found or unable to update", HttpStatus.NOT_FOUND);
        }
    }

}
