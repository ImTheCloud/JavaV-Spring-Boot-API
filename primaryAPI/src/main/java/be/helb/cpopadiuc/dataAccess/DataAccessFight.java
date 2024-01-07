package be.helb.cpopadiuc.dataAccess;

import be.helb.cpopadiuc.dto.FightDto;
import feign.Headers;
import feign.RequestLine;

import java.util.List;

// Feign client interface for accessing fight data
public interface DataAccessFight {

    @RequestLine("GET /fights/getAllFights")
    @Headers("Content-Type: application/json")
    List<FightDto> getAllFights();
}
