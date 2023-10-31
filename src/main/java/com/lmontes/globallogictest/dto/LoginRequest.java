package com.lmontes.globallogictest.dto;

import javax.validation.constraints.*;
import javax.persistence.*;
import lombok.*;

//import jakarta.validation.constraints.NotBlank;
//import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "El email es obligatorio")
    private String email;
    @NotBlank(message = "El password es obligatorio")
    private String password;

}
