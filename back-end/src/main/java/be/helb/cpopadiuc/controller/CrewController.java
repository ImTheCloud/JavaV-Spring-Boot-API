package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.Crew;
import be.helb.cpopadiuc.service.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/crews")
public class CrewController {

    private final CrewService crewService;

    @Autowired
    public CrewController(CrewService crewService) {
        this.crewService = crewService;
    }

    @GetMapping
    public List<Crew> getAllCrews() {
        return crewService.getAllCrews();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCrew(@RequestBody Crew crew) {
        crewService.addCrew(crew);
        return new ResponseEntity<>("Crew added successfully!", HttpStatus.OK);
    }
}
