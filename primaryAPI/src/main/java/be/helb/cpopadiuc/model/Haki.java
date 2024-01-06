package be.helb.cpopadiuc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

// Lombok annotations to generate getters and setters
@Getter
@Setter

// Entity annotation to mark this class as a JPA entity
@Entity

// Table annotation to specify the name of the database table
@Table(name = "haki")
public class Haki {

    // Primary key annotation for the ID field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Column annotation for the ID field in the database table
    @Column(name = "id_haki")
    private Long id;

    // Column annotation for the nameHaki field in the database table
    @Column(name = "name_haki", nullable = false)
    private String nameHaki;

    // Column annotation for the descriptionHaki field in the database table
    @Column(name = "description_haki", nullable = false)
    private String descriptionHaki;

    @OneToMany(mappedBy = "haki")
    @JsonIgnore
    private List<Character> characters;
}
