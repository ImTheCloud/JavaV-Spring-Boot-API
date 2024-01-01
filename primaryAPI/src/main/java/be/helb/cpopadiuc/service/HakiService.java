package be.helb.cpopadiuc.service;

import be.helb.cpopadiuc.model.Haki;
import be.helb.cpopadiuc.repository.HakiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HakiService {

    private final HakiRepository hakiRepository;

    @Autowired
    public HakiService(HakiRepository hakiRepository) {
        this.hakiRepository = hakiRepository;
    }

    public List<Haki> getAllHaki() {
        return hakiRepository.findAll();
    }

    public void addHaki(Haki haki) {
        hakiRepository.save(haki);
    }

    public boolean deleteHakiById(Long id) {
        Optional<Haki> optionalHaki = hakiRepository.findById(id);
        if (optionalHaki.isPresent()) {
            hakiRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // New method to get a specific Haki by ID
    public Optional<Haki> getHakiById(Long id) {
        return hakiRepository.findById(id);
    }

    // New method to update a Haki by ID
    public boolean updateHaki(Long id, Haki updatedHaki) {
        Optional<Haki> optionalHaki = hakiRepository.findById(id);
        if (optionalHaki.isPresent()) {
            updatedHaki.setId(id);
            hakiRepository.save(updatedHaki);
            return true;
        } else {
            return false;
        }
    }
}
