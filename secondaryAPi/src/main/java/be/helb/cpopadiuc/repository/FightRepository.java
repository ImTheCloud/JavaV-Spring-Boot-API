// FightRepository.java
package be.helb.cpopadiuc.repository;

import be.helb.cpopadiuc.model.Fight;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for Fight entity, extends JpaRepository for basic CRUD operations
public interface FightRepository extends JpaRepository<Fight, Long> {



}
