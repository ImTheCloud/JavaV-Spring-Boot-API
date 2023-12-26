package be.helb.cpopadiuc.repository;

import be.helb.cpopadiuc.model.Haki;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository for CRUD operations on Haki entity
public interface HakiRepository extends JpaRepository<Haki, Long> {
}
