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
@Table(name = "devilfruit")
public class DevilFruit {

    // Primary key annotation for the ID field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Column annotation for the ID field in the database table
    @Column(name = "id_devilfruit")
    private Long id;

    // Column annotation for the nameFruit field in the database table
    @Column(name = "name_fruit", nullable = false)
    private String nameFruit;

    // Column annotation for the abilities field in the database table
    @Column(name = "abilities", nullable = false)
    private String abilities;

    // Column annotation for the type field in the database table
    @Column(name = "type", nullable = false)
    private String type;
}
