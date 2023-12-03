// CharacterService.java
package be.helb.cpopadiuc.service;

import be.helb.cpopadiuc.model.Character;
import be.helb.cpopadiuc.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
