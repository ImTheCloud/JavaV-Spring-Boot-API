package be.helb.cpopadiuc.service;

import be.helb.cpopadiuc.model.Crew;
import be.helb.cpopadiuc.repository.CrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

// Service class to manage business logic for Crew entity
@Service
public class CrewService {

    // Injecting CrewRepository dependency
    private final CrewRepository crewRepository;

    @Autowired
    public CrewService(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    // Method to retrieve all crews
    public List<Crew> getAllCrews() {
        return crewRepository.findAll();
    }

    // Method to add a new crew
    public void addCrew(Crew crew) {
        crewRepository.save(crew);
    }

    // Method to delete a crew by ID
    public boolean deleteCrewById(Long id) {
        Optional<Crew> optionalCrew = crewRepository.findById(id);
        if (optionalCrew.isPresent()) {
            crewRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // Method to retrieve a crew by ID
    public Optional<Crew> getCrewById(Long id) {
        return crewRepository.findById(id);
    }

    // Method to update a crew by ID
    public boolean updateCrew(Long id, Crew updatedCrew) {
        Optional<Crew> optionalCrew = crewRepository.findById(id);
        if (optionalCrew.isPresent()) {
            updatedCrew.setId(id); // Set the ID of the updated crew
            crewRepository.save(updatedCrew);
            return true;
        } else {
            return false;
        }
    }
}
