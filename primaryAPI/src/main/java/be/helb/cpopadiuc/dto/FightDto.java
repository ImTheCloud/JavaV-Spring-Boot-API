package be.helb.cpopadiuc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Data Transfer Object (DTO) for Fight
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FightDto {
    private Long id; // Unique identifier for the fight
    private String allFight; // Details of the fight
}
