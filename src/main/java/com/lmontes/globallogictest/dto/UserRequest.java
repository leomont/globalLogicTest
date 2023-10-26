package com.lmontes.globallogictest.dto;

import com.lmontes.globallogictest.model.Phone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class UserRequest {

    private String name;
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no cumple con los valores requeridos")
    private String email;
    @NotBlank(message = "El password es obligatorio")
    @Size(message = "El password debe tener entre 8 y 12 caracteres", min = 8, max = 12)
    @Pattern(regexp = "^(?=.*[A-Z])(?=(?:[^0-9]*[0-9]){2})[a-zA-Z0-9]*$", message = "El password debe tener solo una mayuscula, dos numeros y letras minusculas")
    private String password;
    private List<Phone> phones;
}
