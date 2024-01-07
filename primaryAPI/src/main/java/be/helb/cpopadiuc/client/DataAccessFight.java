package be.helb.cpopadiuc.client;


import be.helb.cpopadiuc.dto.FightDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface DataAccessFight {

    @RequestLine("GET /fights/getAllFights")
    @Headers("Content-Type: application/json")
    List<FightDto> getAllFights();
}
