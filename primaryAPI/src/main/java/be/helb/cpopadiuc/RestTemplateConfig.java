package be.helb.cpopadiuc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// Configuration class for RestTemplate
@Configuration
public class RestTemplateConfig {

    // Creating a RestTemplate bean
    @Bean
    public RestTemplate restTemplate() {
        // Creating a new instance of RestTemplate, a class provided by Spring for making HTTP requests
        // This bean can be injected into other components or services that need to communicate with external APIs
        return new RestTemplate();
    }
}
