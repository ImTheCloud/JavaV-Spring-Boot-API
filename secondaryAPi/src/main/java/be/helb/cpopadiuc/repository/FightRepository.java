package be.helb.cpopadiuc.repository;

import be.helb.cpopadiuc.model.Fight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// Repository interface for Fight entity, extends JpaRepository for basic CRUD operations
public interface FightRepository extends JpaRepository<Fight, Long> {
// for the test
    @Query("SELECT MAX(f.id) FROM Fight f")
    Long findMaxId();
}
