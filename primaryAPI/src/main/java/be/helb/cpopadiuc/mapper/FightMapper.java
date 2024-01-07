package be.helb.cpopadiuc.mapper;

import be.helb.cpopadiuc.dto.FightDto;
import be.helb.cpopadiuc.model.Fight;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FightMapper {
    FightMapper INSTANCE = Mappers.getMapper(FightMapper.class);

    FightDto fightToFightDto(Fight fight);

    Fight fightDtoToFight(FightDto fightDto);
}
