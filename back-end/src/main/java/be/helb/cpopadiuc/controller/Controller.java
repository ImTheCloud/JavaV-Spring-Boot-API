package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.*;
import be.helb.cpopadiuc.service.*;
import be.helb.cpopadiuc.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class Controller {

    private final CharacterService characterService;
    private final FightTacticsService fightTacticsService;
    private final CrewService crewService;
    private final HakiService hakiService;
    private final DevilFruitService devilFruitService;

    @Autowired
    public Controller(CharacterService characterService, FightTacticsService fightTacticsService,
                      CrewService crewService, HakiService hakiService, DevilFruitService devilFruitService) {
        this.characterService = characterService;
        this.fightTacticsService = fightTacticsService;
        this.crewService = crewService;
        this.hakiService = hakiService;
        this.devilFruitService = devilFruitService;
    }

    // Endpoints for Characters
    @GetMapping("/characters")
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }


    @PostMapping("/characters/add")
    public ResponseEntity<String> addCharacter(@RequestBody Character character) {
        characterService.addCharacter(character);
        return new ResponseEntity<>("Character added successfully!", HttpStatus.OK);
    }

    // Endpoints for FightTactics
    @GetMapping("/fight-tactics")
    public List<FightTactics> getAllFightTactics() {
        return fightTacticsService.getAllFightTactics();
    }

    @PostMapping("/fight-tactics/add")
    public ResponseEntity<String> addFightTactics(@RequestBody FightTactics fightTactics) {
        fightTacticsService.addFightTactics(fightTactics);
        return new ResponseEntity<>("FightTactics added successfully!", HttpStatus.OK);
    }

    // Endpoints for Crews
    @GetMapping("/crews")
    public List<Crew> getAllCrews() {
        return crewService.getAllCrews();
    }

    @PostMapping("/crews/add")
    public ResponseEntity<String> addCrew(@RequestBody Crew crew) {
        crewService.addCrew(crew);
        return new ResponseEntity<>("Crew added successfully!", HttpStatus.OK);
    }

    // Endpoints for Haki
    @GetMapping("/haki")
    public List<Haki> getAllHaki() {
        return hakiService.getAllHaki();
    }

    @PostMapping("/haki/add")
    public ResponseEntity<String> addHaki(@RequestBody Haki haki) {
        hakiService.addHaki(haki);
        return new ResponseEntity<>("Haki added successfully!", HttpStatus.OK);
    }

    // Endpoints for DevilFruits
    @GetMapping("/devil-fruits")
    public List<DevilFruit> getAllDevilFruits() {
        return devilFruitService.getAllDevilFruits();
    }

    @PostMapping("/devil-fruits/add")
    public ResponseEntity<String> addDevilFruit(@RequestBody DevilFruit devilFruit) {
        devilFruitService.addDevilFruit(devilFruit);
        return new ResponseEntity<>("DevilFruit added successfully!", HttpStatus.OK);
    }
}
