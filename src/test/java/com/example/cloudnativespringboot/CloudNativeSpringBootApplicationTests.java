package com.example.cloudnativespringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudNativeSpringBootApplicationTests {
    @Autowired
    WebTestClient webTestClient;

    @Test
    void whenGetRootReturnMessage() {
        webTestClient.get().uri("/").exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Spring boot on the cloud");
    }

}
