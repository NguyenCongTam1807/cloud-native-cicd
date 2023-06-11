package com.example.cloudnativespringboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class DemoController {

    @ConfigurationProperties(prefix = "demo")
    record DemoProperties(String message) { }

    private final DemoProperties demoProperties;

    public DemoController(DemoProperties demoProperties) {
        this.demoProperties = demoProperties;
    }

    @GetMapping("/")
    Mono<String> getMessage() {
        return Mono.just(demoProperties.message);
    }
}
