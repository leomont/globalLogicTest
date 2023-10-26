package com.lmontes.globallogictest.utils;

import static org.junit.jupiter.api.Assertions.*;

import com.lmontes.globallogictest.model.Person;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

public class JsonTokenUtilsTest {

    private JsonTokenUtils jsonTokenUtils;

    @BeforeEach
    public void setUp() {
        jsonTokenUtils = new JsonTokenUtils();
        // Configurar el secreto y el tiempo de expiración (puedes usar valores de prueba)
        jsonTokenUtils.setSecret("mi_secreto");
        jsonTokenUtils.setExpiration(3600L); // 1 hora en segundos
    }

    @Test
    public void testGenerateToken() {
        // Crear un usuario de prueba
        Person user = new Person();
        user.setId(UUID.randomUUID());
        user.setEmail("usuario@ejemplo.com");

        // Generar un token utilizando el método generateToken
        String token = jsonTokenUtils.generateToken(user);

        // Decodificar el token y verificar su contenido
        Jws<Claims> claims = Jwts.parser().setSigningKey("mi_secreto").parseClaimsJws(token);

        assertEquals(1L, claims.getBody().get("userId"));
        assertEquals("usuario@ejemplo.com", claims.getBody().get("email"));

        // Verificar que el token no ha expirado
        Date expirationDate = claims.getBody().getExpiration();
        assertTrue(expirationDate.after(new Date()));
    }
}
