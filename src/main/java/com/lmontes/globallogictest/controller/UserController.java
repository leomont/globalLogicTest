package com.lmontes.globallogictest.controller;

import com.lmontes.globallogictest.model.Person;
import com.lmontes.globallogictest.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Person> signup(@Valid @RequestBody Person user) {
        Person userSave = userService.signup(user).get();
        return ResponseEntity.ok(userSave);
    }
}
