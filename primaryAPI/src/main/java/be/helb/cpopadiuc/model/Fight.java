package be.helb.cpopadiuc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// Class representing a fight in the system
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "fights")
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the fight
    @Column(nullable = false)
    private String nameFighter1;
    @Column(nullable = false)
    private String nameFighter2;
    @Column(nullable = false)
    private String winner;
}
