package be.helb.cpopadiuc.configuration;


import be.helb.cpopadiuc.client.DataAccessFight;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignFightConfiguration {

    @Bean
    public DataAccessFight dataAccessFight() {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .target(DataAccessFight.class, "http://localhost:8081");
    }
}
