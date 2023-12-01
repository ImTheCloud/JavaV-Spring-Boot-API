package be.helb.cpopadiuc.controller;
import be.helb.cpopadiuc.model.*;
import be.helb.cpopadiuc.model.Character;
import be.helb.cpopadiuc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class Controller {

    private final CharacterRepository characterRepository;
    private final FightTacticsRepository fightTacticsRepository;
    private final CrewRepository crewRepository;
    private final PoneglyphRepository poneglyphRepository;
    private final HakiRepository hakiRepository;
    private final DevilFruitRepository devilFruitRepository;

    @Autowired
    public Controller(CharacterRepository characterRepository, FightTacticsRepository fightTacticsRepository, CrewRepository crewRepository, PoneglyphRepository poneglyphRepository, HakiRepository hakiRepository, DevilFruitRepository devilFruitRepository) {
        this.characterRepository = characterRepository;
        this.fightTacticsRepository = fightTacticsRepository;
        this.crewRepository = crewRepository;
        this.poneglyphRepository = poneglyphRepository;
        this.hakiRepository = hakiRepository;
        this.devilFruitRepository = devilFruitRepository;
    }

    // Endpoints for Characters
    @GetMapping("/characters")
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    @PostMapping("/characters/add")
    public ResponseEntity<String> addCharacter(@RequestBody Character character) {
        characterRepository.save(character);
        return new ResponseEntity<>("Character added successfully!", HttpStatus.OK);
    }

    // Endpoints for FightTactics
    @GetMapping("/fight-tactics")
    public List<FightTactics> getAllFightTactics() {
        return fightTacticsRepository.findAll();
    }

    @PostMapping("/fight-tactics/add")
    public ResponseEntity<String> addFightTactics(@RequestBody FightTactics fightTactics) {
        fightTacticsRepository.save(fightTactics);
        return new ResponseEntity<>("FightTactics added successfully!", HttpStatus.OK);
    }

    // Endpoints for Crews
    @GetMapping("/crews")
    public List<Crew> getAllCrews() {
        return crewRepository.findAll();
    }

    @PostMapping("/crews/add")
    public ResponseEntity<String> addCrew(@RequestBody Crew crew) {
        crewRepository.save(crew);
        return new ResponseEntity<>("Crew added successfully!", HttpStatus.OK);
    }

    // Endpoints for Poneglyphs
    @GetMapping("/poneglyphs")
    public List<Poneglyph> getAllPoneglyphs() {
        return poneglyphRepository.findAll();
    }

    @PostMapping("/poneglyphs/add")
    public ResponseEntity<String> addPoneglyph(@RequestBody Poneglyph poneglyph) {
        poneglyphRepository.save(poneglyph);
        return new ResponseEntity<>("Poneglyph added successfully!", HttpStatus.OK);
    }

    // Endpoints for Haki
    @GetMapping("/haki")
    public List<Haki> getAllHaki() {
        return hakiRepository.findAll();
    }

    @PostMapping("/haki/add")
    public ResponseEntity<String> addHaki(@RequestBody Haki haki) {
        hakiRepository.save(haki);
        return new ResponseEntity<>("Haki added successfully!", HttpStatus.OK);
    }

    // Endpoints for DevilFruits
    @GetMapping("/devil-fruits")
    public List<DevilFruit> getAllDevilFruits() {
        return devilFruitRepository.findAll();
    }

    @PostMapping("/devil-fruits/add")
    public ResponseEntity<String> addDevilFruit(@RequestBody DevilFruit devilFruit) {
        devilFruitRepository.save(devilFruit);
        return new ResponseEntity<>("DevilFruit added successfully!", HttpStatus.OK);
    }
}
