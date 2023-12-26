package be.helb.cpopadiuc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// Lombok annotations to generate getters and setters
@Getter
@Setter

// Entity annotation to mark this class as a JPA entity
@Entity

// Table annotation to specify the name of the database table
@Table(name = "fighttactics")
public class FightTactics {

    // Primary key annotation for the ID field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Column annotation for the ID field in the database table
    @Column(name = "id_fighttactics")
    private Long id;

    // Column annotation for the nameTactics field in the database table
    @Column(name = "name_tactics", nullable = false)
    private String nameTactics;

    // Column annotation for the type field in the database table
    @Column(name = "type", nullable = false)
    private String type;
}
