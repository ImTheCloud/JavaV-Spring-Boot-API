package be.helb.cpopadiuc.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "fights")
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fight")
    private Long id;

    @Column(name = "name1", nullable = false)
    private String name1;

    @Column(name = "name2", nullable = false)
    private String name2;

    @Column(name = "result", nullable = false)
    private String result;
}
