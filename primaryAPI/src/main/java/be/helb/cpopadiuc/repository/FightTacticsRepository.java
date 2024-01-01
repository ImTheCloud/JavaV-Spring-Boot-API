package be.helb.cpopadiuc.repository;

import be.helb.cpopadiuc.model.FightTactics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// JpaRepository for CRUD operations on FightTactics entity
public interface FightTacticsRepository extends JpaRepository<FightTactics, Long> {
    @Query("SELECT MAX(f.id) FROM FightTactics f")
    Long findMaxId();
}
