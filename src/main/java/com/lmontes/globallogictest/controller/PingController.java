package com.lmontes.globallogictest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Ping")
public class PingController {

    @GetMapping("/ping")
    @Operation(summary = "Servicio de prueba ping/pong")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }
}
