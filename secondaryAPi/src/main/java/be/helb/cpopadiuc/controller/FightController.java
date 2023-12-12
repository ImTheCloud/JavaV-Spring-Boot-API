package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.Fight;
import be.helb.cpopadiuc.service.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fights")
public class FightController {

    private final FightService fightService;

    @Autowired
    public FightController(FightService fightService) {
        this.fightService = fightService;
    }

    @GetMapping
    public List<Fight> getAllFights() {
        return fightService.getAllFights();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addFight(@RequestBody Fight fight) {
        fightService.addFight(fight);
        return new ResponseEntity<>("Fight added successfully!", HttpStatus.OK);
    }
    @GetMapping("/fight/{name1}/{name2}")
    public ResponseEntity<String> getFightResult(@PathVariable String name1, @PathVariable String name2) {
        String result = fightService.getFightResult(name1, name2);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

//    @GetMapping("/result")
//    public ResponseEntity<String> getFightResult(
//            @RequestParam(name = "name1") String name1,
//            @RequestParam(name = "name2") String name2) {
//
//        String result = fightService.getFightResult(name1, name2);
//
//        if (result != null) {
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Combat non trouvé", HttpStatus.NOT_FOUND);
//        }
//    }


}