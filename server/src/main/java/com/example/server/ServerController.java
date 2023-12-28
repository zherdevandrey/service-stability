package com.example.server;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    @GetMapping("/server")
    public ResponseEntity<String> response() {

        if (System.currentTimeMillis() % 2 == 0) {
            throw new IllegalArgumentException();
        }

        return ResponseEntity.ok("Success from server");
    }

}
