package be.helb.cpopadiuc.configuration;

import be.helb.cpopadiuc.dataAccess.DataAccessFight;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuration class for Feign client related to fights
@Configuration
public class FeignFightConfiguration {

    // Define the base URL for the Feign client
    private static final String BASE_URL = "http://localhost:8081";

    @Bean
    public DataAccessFight dataAccessFight() {
        // Configures and creates Feign client for DataAccessFight
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .target(DataAccessFight.class, BASE_URL);
    }
}
