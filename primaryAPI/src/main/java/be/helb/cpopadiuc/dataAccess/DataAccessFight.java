package be.helb.cpopadiuc.dataAccess;

import be.helb.cpopadiuc.dto.FightDto;
import feign.Headers;
import feign.RequestLine;

import java.util.List;

// Feign client interface for accessing fight data
    public interface DataAccessFight {
        String GET_ALL_FIGHTS_URL = "/fights/getAllFights";

        @RequestLine("GET " + GET_ALL_FIGHTS_URL)
        @Headers("Content-Type: application/json")
        List<FightDto> getAllFights();
    }

