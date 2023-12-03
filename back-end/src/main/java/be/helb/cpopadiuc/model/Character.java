package be.helb.cpopadiuc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_character")
    private Long id;

    @Column(name = "name_character", nullable = false)
    private String name;

    @Column(name = "rank", nullable = false)
    private String rank;

    @Column(name = "job", nullable = false)
    private String job;

    @Column(name = "bounty", nullable = false)
    private int bounty;

    @ManyToOne
    @JoinColumn(name = "devilfruit_id")
    private DevilFruit devilFruit;

    @ManyToOne
    @JoinColumn(name = "crew_id")
    private Crew crew;

    @ManyToOne
    @JoinColumn(name = "haki_id")
    private Haki haki;

    @ManyToOne
    @JoinColumn(name = "fighttactics_id")
    private FightTactics fightTactics;


}
