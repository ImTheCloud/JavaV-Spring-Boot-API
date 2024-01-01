package be.helb.cpopadiuc.service;

import be.helb.cpopadiuc.model.Character;
import be.helb.cpopadiuc.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

// Service class to manage business logic for Character entity
@Service
public class CharacterService {

    // Injecting CharacterRepository dependency
    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    // Method to retrieve all characters
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    // Method to add a new character
    public void addCharacter(Character character) {
        characterRepository.save(character);
    }

    // Method to retrieve characters by crew ID
    public List<Character> getCharactersByCrew(Long crewId) {
        return characterRepository.findByCrewId(crewId);
    }

    // Method to retrieve characters by job
    public List<Character> getCharactersByJob(String job) {
        return characterRepository.findByJob(job);
    }

    // Method to retrieve characters by rank
    public List<Character> getCharactersByRank(String rank) {
        return characterRepository.findByRank(rank);
    }

    // Method to retrieve characters with high bounty and no Devil Fruit
    public List<Character> getCharactersWithHighBountyAndNoDevilFruit() {
        long minBounty = 1_000_000_000;
        return characterRepository.findByBountyGreaterThanAndDevilFruitIsNull(minBounty);
    }

    // Method to delete a character by ID
    public boolean deleteCharacterById(Long id) {
        Optional<Character> optionalCharacter = characterRepository.findById(id);
        if (optionalCharacter.isPresent()) {
            characterRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    // Method to get a character by ID
    public Optional<Character> getCharacterById(Long id) {
        return characterRepository.findById(id);
    }

    // Method to update a character by ID
    public boolean updateCharacter(Long id, Character updatedCharacter) {
        Optional<Character> optionalCharacter = characterRepository.findById(id);
        if (optionalCharacter.isPresent()) {
            Character existingCharacter = optionalCharacter.get();
            existingCharacter.setName(updatedCharacter.getName());
            existingCharacter.setRank(updatedCharacter.getRank());
            existingCharacter.setJob(updatedCharacter.getJob());
            existingCharacter.setBounty(updatedCharacter.getBounty());
            existingCharacter.setDevilFruit(updatedCharacter.getDevilFruit());
            existingCharacter.setCrew(updatedCharacter.getCrew());
            existingCharacter.setHaki(updatedCharacter.getHaki());
            existingCharacter.setFightTactics(updatedCharacter.getFightTactics());
            existingCharacter.setImageUrl(updatedCharacter.getImageUrl());

            characterRepository.save(existingCharacter);
            return true;
        } else {
            return false;
        }
    }

}
