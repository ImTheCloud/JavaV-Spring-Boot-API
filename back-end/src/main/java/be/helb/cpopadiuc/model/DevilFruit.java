package be.helb.cpopadiuc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "devilfruit")
public class DevilFruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_devilfruit")
    private Long id;

    @Column(name = "name_fruit", nullable = false)
    private String nameFruit;

    @Column(name = "abilities", nullable = false)
    private String abilities;

    @Column(name = "type", nullable = false)
    private String type;

}
