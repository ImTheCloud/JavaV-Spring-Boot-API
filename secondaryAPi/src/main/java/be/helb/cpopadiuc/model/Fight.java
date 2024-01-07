package be.helb.cpopadiuc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Classe représentant un combat dans le système
@Getter // Génère automatiquement les getters pour tous les champs
@Setter // Génère automatiquement les setters pour tous les champs
@NoArgsConstructor // Génère un constructeur sans arguments
@Entity // Indique qu'il s'agit d'une entité JPA
@Table(name = "fights") // Spécifie le nom de la table dans la base de données
public class Fight {

    @Id // Clé primaire de l'entité
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Stratégie de génération automatique de l'ID
    private Long id; // Identifiant unique du combat

    @Column(nullable = false) // Colonne 'allFight' ne peut pas être nulle
    private String allFight; // Détails du combat

    // Constructeur avec les détails du combat
    public Fight(String allFight) {
        this.allFight = allFight;
    }
}
