package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
class DemoApplicationTests {
    @Autowired
    WebTestClient client;

    @Test
    void contextLoads() {
        client.get().uri("/issue").exchange().expectStatus().isOk();
    }

}
