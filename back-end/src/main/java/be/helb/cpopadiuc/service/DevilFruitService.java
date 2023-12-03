// DevilFruitService.java
package be.helb.cpopadiuc.service;

import be.helb.cpopadiuc.model.DevilFruit;
import be.helb.cpopadiuc.repository.DevilFruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevilFruitService {

    private final DevilFruitRepository devilFruitRepository;

    @Autowired
    public DevilFruitService(DevilFruitRepository devilFruitRepository) {
        this.devilFruitRepository = devilFruitRepository;
    }

    public List<DevilFruit> getAllDevilFruits() {
        return devilFruitRepository.findAll();
    }

    public void addDevilFruit(DevilFruit devilFruit) {
        devilFruitRepository.save(devilFruit);
    }
}
