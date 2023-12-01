package be.helb.cpopadiuc.repository;

import be.helb.cpopadiuc.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}
