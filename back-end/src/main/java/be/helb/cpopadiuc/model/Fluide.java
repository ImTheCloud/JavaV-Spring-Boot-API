package be.helb.cpopadiuc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "fluide")
public class Fluide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fluide")
    private Long id;

    @Column(name = "name_fluide", nullable = false)
    private String nameFluide;

    @Column(name = "abilities", nullable = false)
    private String abilities;


}
