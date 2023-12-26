package be.helb.cpopadiuc.repository;

import be.helb.cpopadiuc.model.FightTactics;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository for CRUD operations on FightTactics entity
public interface FightTacticsRepository extends JpaRepository<FightTactics, Long> {
}
