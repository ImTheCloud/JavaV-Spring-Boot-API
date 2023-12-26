package be.helb.cpopadiuc.service;

import be.helb.cpopadiuc.model.Haki;
import be.helb.cpopadiuc.repository.HakiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service class to manage business logic for Haki entity
@Service
public class HakiService {

    // Injecting HakiRepository dependency
    private final HakiRepository hakiRepository;

    @Autowired
    public HakiService(HakiRepository hakiRepository) {
        this.hakiRepository = hakiRepository;
    }

    // Method to retrieve all haki
    public List<Haki> getAllHaki() {
        return hakiRepository.findAll();
    }

    // Method to add a new haki
    public void addHaki(Haki haki) {
        hakiRepository.save(haki);
    }

    // Method to delete a haki by ID
    public boolean deleteHakiById(Long id) {
        Optional<Haki> optionalHaki = hakiRepository.findById(id);
        if (optionalHaki.isPresent()) {
            hakiRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
