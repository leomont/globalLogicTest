package com.lmontes.globallogictest.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PingControllerTest {

    private PingController pingController;

    @BeforeEach
    public void setUp() {
        pingController = new PingController();
    }

    @Test
    public void testPing() {
        ResponseEntity<String> response = pingController.ping();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("pong", response.getBody());
    }
}
