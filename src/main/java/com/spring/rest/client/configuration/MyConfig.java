package com.spring.rest.client.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.spring.rest.client")
public class MyConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
