package com.lmontes.globallogictest.controller;

import com.lmontes.globallogictest.dto.LoginRequest;
import com.lmontes.globallogictest.dto.LoginResponse;
import com.lmontes.globallogictest.dto.UserRequest;
import com.lmontes.globallogictest.model.Person;
import com.lmontes.globallogictest.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
//import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.persistence.*;
import lombok.*;


@RequiredArgsConstructor
@RestController
@Tag(name = "User")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @Operation(summary = "Registra un nuevo usuario en el microservicio")
    public ResponseEntity<Person> signup(@Valid @RequestBody UserRequest user) {
        Person userSave = userService.signup(user).get();
        return ResponseEntity.ok(userSave);
    }

    @PostMapping("/login")
    @Operation(summary = "Loguea un usuario en el miroservicio")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest login) {
        return ResponseEntity.ok(userService.login(login));
    }
}
