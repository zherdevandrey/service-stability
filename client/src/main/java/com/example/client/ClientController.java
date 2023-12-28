package com.example.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final RestTemplate restTemplate;

    @GetMapping("/client")
    @CircuitBreaker(name = "CircuitBreakerService")
    public String getClient() {
        ResponseEntity<String> response = restTemplate.getForEntity("/server", String.class);
        return response.getBody();
    }

}
