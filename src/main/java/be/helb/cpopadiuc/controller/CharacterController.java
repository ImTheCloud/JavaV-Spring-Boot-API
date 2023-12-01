package be.helb.cpopadiuc.controller;
import be.helb.cpopadiuc.model.Character;
import be.helb.cpopadiuc.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @GetMapping
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCharacter(@RequestBody Character character) {
        characterRepository.save(character);

        return new ResponseEntity<>("Character added successfully!", HttpStatus.OK);
    }
}



