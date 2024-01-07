package be.helb.cpopadiuc.mapper;

import be.helb.cpopadiuc.dto.FightDto;
import be.helb.cpopadiuc.model.Fight;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

// Mapper interface for mapping between Fight and FightDto
@Mapper(componentModel = "spring")
public interface FightMapper {
    FightMapper INSTANCE = Mappers.getMapper(FightMapper.class);

    // Mapping method from Fight to FightDto
    FightDto fightToFightDto(Fight fight);

    // Mapping method from FightDto to Fight
    Fight fightDtoToFight(FightDto fightDto);
}
