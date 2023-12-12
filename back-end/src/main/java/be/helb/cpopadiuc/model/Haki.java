package be.helb.cpopadiuc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "haki")
public class Haki {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_haki")
    private Long id;

    @Column(name = "name_haki", nullable = false)
    private String nameHaki;

    @Column(name = "description_haki", nullable = false)
    private String descriptionHaki;

//    @OneToMany(mappedBy = "haki")
//    private List<Character> characters;
}
