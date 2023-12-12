package be.helb.cpopadiuc.repository;

import be.helb.cpopadiuc.model.Fight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FightRepository extends JpaRepository<Fight, Long> {
}
