package com.lmontes.globallogictest.dto;

import com.lmontes.globallogictest.model.Phone;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class LoginResponse {

    private String id;
    private LocalDateTime created;
    private LocalDateTime lastLogin;
    private String token;
    private boolean isActive;
    private String name;
    private String email;
    private String password;
    private List<Phone> phones;
}
