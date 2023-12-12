package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.Character;
import be.helb.cpopadiuc.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/characters")

public class CharacterController {

    private final CharacterService characterService;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${fight.api.url}")
    private String fightApiUrl;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable Long id) {
        if (characterService.deleteCharacterById(id)) {
            return new ResponseEntity<>("Character deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Character not found or unable to delete", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byCrew/{crewId}")
    public List<Character> getCharactersByCrew(@PathVariable Long crewId) {
        return characterService.getCharactersByCrew(crewId);
    }

    @GetMapping("/byJob/{job}")
    public List<Character> getCharactersByJob(@PathVariable String job) {
        return characterService.getCharactersByJob(job);
    }

    @GetMapping("/byRank/{rank}")
    public List<Character> getCharactersByRank(@PathVariable String rank) {
        return characterService.getCharactersByRank(rank);
    }

    @GetMapping("/highBountyAndNoDevilFruit")
    public List<Character> getCharactersWithHighBountyAndNoDevilFruit() {
        return characterService.getCharactersWithHighBountyAndNoDevilFruit();
    }

    @GetMapping("/fight/{name1}/{name2}")
    public ResponseEntity<String> initiateFight(@PathVariable String name1, @PathVariable String name2) {
        String fightApiEndpoint = fightApiUrl + "/api/fights/fightResult/{name1}/{name2}";
        ResponseEntity<String> response = restTemplate.exchange(
                fightApiEndpoint,
                HttpMethod.GET,
                null,
                String.class,
                name1,
                name2
        );
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }
}
