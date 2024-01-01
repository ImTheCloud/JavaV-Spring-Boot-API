package be.helb.cpopadiuc.repository;

import be.helb.cpopadiuc.model.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


// JpaRepository for CRUD operations on Crew entity
public interface CrewRepository extends JpaRepository<Crew, Long> {
    @Query("SELECT MAX(cr.id) FROM Crew cr")
    Long findMaxId();

}
