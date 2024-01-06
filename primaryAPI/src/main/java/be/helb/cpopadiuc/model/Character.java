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
@Table(name = "characters")
public class Character {

    // Primary key annotation for the ID field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Column annotation for the ID field in the database table
    @Column(name = "id_character")
    private Long id;

    // Column annotation for the name field in the database table
    @Column(name = "name_character", nullable = false)
    private String name;

    // Column annotation for the rank field in the database table
    @Column(name = "rank", nullable = false)
    private String rank;

    // Column annotation for the job field in the database table
    @Column(name = "job", nullable = false)
    private String job;

    // Column annotation for the bounty field in the database table
    @Column(name = "bounty", nullable = false)
    private long bounty;

    // Column annotation for the imageUrl field in the database table
    @Column(name = "imageUrl", nullable = false, length = 1000)
    private String imageUrl;

    // One-to-One relationship with DevilFruit entity
    @OneToOne
    @JoinColumn(name = "devilfruit_id")
    private DevilFruit devilFruit;

    // Many-to-One relationship with Crew entity
    @ManyToOne
    @JoinColumn(name = "crew_id")
    private Crew crew;

    // Many-to-One relationship with Haki entity
    @ManyToOne
    @JoinColumn(name = "haki_id")
    private Haki haki;

    // Many-to-One relationship with FightTactics entity
    @ManyToOne
    @JoinColumn(name = "fighttactics_id")
    private FightTactics fightTactics;
}
