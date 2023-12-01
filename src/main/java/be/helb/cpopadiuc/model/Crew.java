package be.helb.cpopadiuc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "crews")
public class Crew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_crew")
    private Long id;

    @Column(name = "name_crew", nullable = false)
    private String nameCrew;

    @Column(name = "ship_name", nullable = false)
    private String shipName;

    @Column(name = "number_pirate", nullable = false)
    private int numberPirate;

    @ManyToOne
    @JoinColumn(name = "poneglyph_id")
    private Poneglyph poneglyph;
}
