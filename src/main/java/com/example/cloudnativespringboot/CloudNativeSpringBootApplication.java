package com.example.cloudnativespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CloudNativeSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudNativeSpringBootApplication.class, args);
    }

}
