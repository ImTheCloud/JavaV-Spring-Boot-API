package be.helb.cpopadiuc.repository;

import be.helb.cpopadiuc.model.DevilFruit;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository for CRUD operations on DevilFruit entity
public interface DevilFruitRepository extends JpaRepository<DevilFruit, Long> {
}
