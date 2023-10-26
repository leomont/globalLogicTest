package com.lmontes.globallogictest.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordUtilsTest {

    @Test
    public void testHashPassword() {
        String password = "password123";
        String hashedPassword = PasswordUtils.hashPassword(password);

        assertNotNull(hashedPassword);
        assertNotEquals(password, hashedPassword); // El hash debe ser diferente de la contraseña original
    }

    @Test
    public void testCheckPassword() {
        String password = "password123";
        String hashedPassword = PasswordUtils.hashPassword(password);

        assertTrue(PasswordUtils.checkPassword(password, hashedPassword));
        assertFalse(PasswordUtils.checkPassword("incorrectPassword", hashedPassword));
    }
}