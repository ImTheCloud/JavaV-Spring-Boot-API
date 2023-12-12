package be.helb.cpopadiuc.service;

import be.helb.cpopadiuc.model.Character;
import be.helb.cpopadiuc.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    public void addCharacter(Character character) {
        characterRepository.save(character);
    }

    public List<Character> getCharactersByCrew(Long crewId) {
        return characterRepository.findByCrewId(crewId);
    }

    public boolean deleteCharacterById(Long id) {
        Optional<Character> optionalCharacter = characterRepository.findById(id);
        if (optionalCharacter.isPresent()) {
            characterRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
