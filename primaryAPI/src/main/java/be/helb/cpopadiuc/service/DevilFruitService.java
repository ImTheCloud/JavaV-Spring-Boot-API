package be.helb.cpopadiuc.service;

import be.helb.cpopadiuc.model.DevilFruit;
import be.helb.cpopadiuc.repository.DevilFruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service class to manage business logic for DevilFruit entity
@Service
public class DevilFruitService {

    // Injecting DevilFruitRepository dependency
    private final DevilFruitRepository devilFruitRepository;

    @Autowired
    public DevilFruitService(DevilFruitRepository devilFruitRepository) {
        this.devilFruitRepository = devilFruitRepository;
    }

    // Method to retrieve all devil fruits
    public List<DevilFruit> getAllDevilFruits() {
        return devilFruitRepository.findAll();
    }

    // Method to add a new devil fruit
    public void addDevilFruit(DevilFruit devilFruit) {
        devilFruitRepository.save(devilFruit);
    }

    // Method to delete a devil fruit by ID
    public boolean deleteDevilFruitById(Long id) {
        Optional<DevilFruit> optionalDevilFruit = devilFruitRepository.findById(id);
        if (optionalDevilFruit.isPresent()) {
            devilFruitRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
