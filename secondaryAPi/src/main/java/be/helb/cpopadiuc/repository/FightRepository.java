package be.helb.cpopadiuc.repository;

import be.helb.cpopadiuc.model.Fight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FightRepository extends JpaRepository<Fight, Long> {

    @Query("SELECT f FROM Fight f WHERE (f.name1 = :name1 AND f.name2 = :name2) OR (f.name1 = :name2 AND f.name2 = :name1)")
    Optional<Fight> findByNames(@Param("name1") String name1, @Param("name2") String name2);
}

