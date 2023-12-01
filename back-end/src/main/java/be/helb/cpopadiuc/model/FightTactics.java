package be.helb.cpopadiuc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "fighttactics")
public class FightTactics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fighttactics")
    private Long id;

    @Column(name = "name_tactics", nullable = false)
    private String nameTactics;

    @Column(name = "type", nullable = false)
    private String type;
}
