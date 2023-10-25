package com.lmontes.globallogictest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pingController {

    @GetMapping("/ping")
    public ResponseEntity<String> getEmployeeById() {
        return ResponseEntity.ok("pong");
    }
}
