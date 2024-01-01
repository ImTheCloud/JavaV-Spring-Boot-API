package be.helb.cpopadiuc.repository;

import be.helb.cpopadiuc.model.DevilFruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// JpaRepository for CRUD operations on DevilFruit entity
public interface DevilFruitRepository extends JpaRepository<DevilFruit, Long> {
    @Query("SELECT MAX(d.id) FROM DevilFruit d")
    Long findMaxId();
}
