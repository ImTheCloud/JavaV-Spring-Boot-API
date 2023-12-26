package be.helb.cpopadiuc.repository;

import be.helb.cpopadiuc.model.Crew;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository for CRUD operations on Crew entity
public interface CrewRepository extends JpaRepository<Crew, Long> {
}
