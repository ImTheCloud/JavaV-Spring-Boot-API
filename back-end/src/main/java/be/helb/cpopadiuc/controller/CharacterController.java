package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.Character;
import be.helb.cpopadiuc.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCharacter(@RequestBody Character character) {
        characterService.addCharacter(character);
        return new ResponseEntity<>("Character added successfully!", HttpStatus.OK);
    }
}
