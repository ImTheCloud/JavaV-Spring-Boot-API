// CrewService.java
package be.helb.cpopadiuc.service;

import be.helb.cpopadiuc.model.Crew;
import be.helb.cpopadiuc.repository.CrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrewService {

    private final CrewRepository crewRepository;

    @Autowired
    public CrewService(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    public List<Crew> getAllCrews() {
        return crewRepository.findAll();
    }

    public void addCrew(Crew crew) {
        crewRepository.save(crew);
    }
}
