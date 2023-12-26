// Fight.java
package be.helb.cpopadiuc.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

// Entity class representing a Fight
@Getter
@Setter
@Entity
@Table(name = "fights")
public class Fight {

    // Primary key for the Fight entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fight")
    private Long id;

    // Names of the characters involved in the fight
    @Column(name = "name1", nullable = false)
    private String name1;

    @Column(name = "name2", nullable = false)
    private String name2;

    // Result of the fight
    @Column(name = "result", nullable = false)
    private String result;
}

