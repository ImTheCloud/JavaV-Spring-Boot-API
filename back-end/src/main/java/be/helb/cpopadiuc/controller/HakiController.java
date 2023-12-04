package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.Haki;
import be.helb.cpopadiuc.service.HakiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
