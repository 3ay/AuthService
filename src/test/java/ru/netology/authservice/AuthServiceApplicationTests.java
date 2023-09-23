package ru.netology.authservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthServiceApplicationTests {
    private static final GenericContainer<?> devContainer = new GenericContainer<>("devapp:latest")
            .withExposedPorts(8080);
    private static final GenericContainer<?> prodContainer = new GenericContainer<>("prodapp:latest")
            .withExposedPorts(8081);

    @Autowired
    TestRestTemplate restTemplate;

    @BeforeAll
    public static void setUp() {
        devContainer.start();
        prodContainer.start();
    }

    @Test
    void testDevContainer() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + devContainer.getMappedPort(8080)
                + "/simple/authorize?user=freshdev&password=90$He_Y78", String.class);
        Assertions.assertEquals(200, forEntity.getStatusCode().value());
    }
    @Test
    void testProdContainer() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + prodContainer.getMappedPort(8081)
                + "/simple/authorize?user=freshdev&password=90$He_Y78", String.class);
        Assertions.assertEquals(200, forEntity.getStatusCode().value());
    }

}
