package be.helb.cpopadiuc.repository;

import be.helb.cpopadiuc.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// JpaRepository for CRUD operations on Character entity
public interface CharacterRepository extends JpaRepository<Character, Long> {

    // Custom query method to find characters by crew ID
    List<Character> findByCrewId(Long crewId);

    // Custom query method to find characters by job
    List<Character> findByJob(String job);

    // Custom query method to find characters by rank
    List<Character> findByRank(String rank);

    // Custom query method to find characters with high bounty and no Devil Fruit
    List<Character> findByBountyGreaterThanAndDevilFruitIsNull(long bounty);
    // For the tests
    @Query("SELECT MAX(c.id) FROM Character c")

    Long findMaxId();
}
