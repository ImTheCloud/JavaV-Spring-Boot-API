package be.helb.cpopadiuc.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double bounty;
    private String rank;
    private String job;

//    @ManyToOne
//    @JoinColumn(name = "course_id") // Le nom de la colonne dans la table "Student" qui fait référence à "Course"
//    private Course course;
}
