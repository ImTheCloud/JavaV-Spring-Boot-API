package be.helb.cpopadiuc.repository;

import be.helb.cpopadiuc.model.Haki;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// JpaRepository for CRUD operations on Haki entity
public interface HakiRepository extends JpaRepository<Haki, Long> {
    @Query("SELECT MAX(h.id) FROM Haki h")
    Long findMaxId();
}
