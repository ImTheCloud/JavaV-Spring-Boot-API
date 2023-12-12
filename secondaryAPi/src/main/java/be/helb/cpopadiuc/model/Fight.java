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



    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "duration", nullable = false)
    private String duration;

    @Column(name = "result", nullable = false)
    private String result;



}
