// HakiService.java
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
}