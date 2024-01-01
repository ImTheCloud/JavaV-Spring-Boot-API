package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.Character;
import be.helb.cpopadiuc.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import java.util.List;

// Configuring Cross-Origin Resource Sharing (CORS) for the controller
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    // Injecting CharacterService and RestTemplate dependencies
    private final CharacterService characterService;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${fight.api.url}")
    private String fightApiUrl;

    // Constructor for CharacterController, injecting CharacterService
    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    // Handling HTTP GET request to retrieve all characters
    @GetMapping
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    // Handling HTTP POST request to add a new character
    @PostMapping("/add")
    public ResponseEntity<String> addCharacter(@RequestBody Character character) {
        characterService.addCharacter(character);
        return new ResponseEntity<>("Character added successfully!", HttpStatus.OK);
    }

    // Handling HTTP DELETE request to delete a character by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable Long id) {
        if (characterService.deleteCharacterById(id)) {
            return new ResponseEntity<>("Character deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Character not found or unable to delete", HttpStatus.NOT_FOUND);
        }
    }

    // Handling HTTP GET request to retrieve characters by crew ID
    @GetMapping("/byCrew/{crewId}")
    public List<Character> getCharactersByCrew(@PathVariable Long crewId) {
        return characterService.getCharactersByCrew(crewId);
    }

    // Handling HTTP GET request to retrieve characters by job
    @GetMapping("/byJob/{job}")
    public List<Character> getCharactersByJob(@PathVariable String job) {
        return characterService.getCharactersByJob(job);
    }

    // Handling HTTP GET request to retrieve characters by rank
    @GetMapping("/byRank/{rank}")
    public List<Character> getCharactersByRank(@PathVariable String rank) {
        return characterService.getCharactersByRank(rank);
    }

    // Handling HTTP GET request to retrieve characters with high bounty and no Devil Fruit
    @GetMapping("/highBountyAndNoDevilFruit")
    public List<Character> getCharactersWithHighBountyAndNoDevilFruit() {
        return characterService.getCharactersWithHighBountyAndNoDevilFruit();
    }

    // Handling HTTP GET request to initiate a fight between two characters with the secondary API
    @GetMapping("/fight/{name1}/{name2}")
    public ResponseEntity<String> initiateFight(@PathVariable String name1, @PathVariable String name2) {
        // Constructing the API endpoint for the fight service
        String fightApiEndpoint = fightApiUrl + "/api/fights/fightResult/{name1}/{name2}";

        // Making a GET request to the fight service API using RestTemplate
        ResponseEntity<String> response = restTemplate.exchange(
                fightApiEndpoint,
                HttpMethod.GET,
                null,
                String.class,
                name1,
                name2
        );

        // Returning the response from the fight service
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

}
