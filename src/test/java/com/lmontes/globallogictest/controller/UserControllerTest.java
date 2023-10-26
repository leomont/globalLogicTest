package com.lmontes.globallogictest.controller;

import com.lmontes.globallogictest.dto.LoginRequest;
import com.lmontes.globallogictest.dto.LoginResponse;
import com.lmontes.globallogictest.dto.UserRequest;
import com.lmontes.globallogictest.model.Person;
import com.lmontes.globallogictest.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    private UserController userController;
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = mock(UserService.class);
        userController = new UserController(userService);
    }

    @Test
    public void testSignup() {
        UserRequest userRequest = new UserRequest();
        Person user = new Person();

        when(userService.signup(userRequest)).thenReturn(Optional.of(user));

        ResponseEntity<Person> response = userController.signup(userRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());

        verify(userService, times(1)).signup(userRequest);
    }

    @Test
    public void testLogin() {
        LoginRequest loginRequest = new LoginRequest();
        LoginResponse loginResponse = new LoginResponse();

        when(userService.login(loginRequest)).thenReturn(loginResponse);

        ResponseEntity<LoginResponse> response = userController.login(loginRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(loginResponse, response.getBody());

        verify(userService, times(1)).login(loginRequest);
    }
}