package be.helb.cpopadiuc.repository;

import be.helb.cpopadiuc.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    List<Character> findByCrewId(Long crewId);
    List<Character> findByJob(String job);
}
