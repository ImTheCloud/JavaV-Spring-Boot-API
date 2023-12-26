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
@Table(name = "crews")
public class Crew {

    // Primary key annotation for the ID field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Column annotation for the ID field in the database table
    @Column(name = "id_crew")
    private Long id;

    // Column annotation for the nameCrew field in the database table
    @Column(name = "name_crew", nullable = false)
    private String nameCrew;

    // Column annotation for the shipName field in the database table
    @Column(name = "ship_name", nullable = false)
    private String shipName;

    // Column annotation for the numberPirate field in the database table
    @Column(name = "number_pirate", nullable = false)
    private int numberPirate;

}
