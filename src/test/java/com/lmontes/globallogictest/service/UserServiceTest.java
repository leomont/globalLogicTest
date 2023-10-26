package com.lmontes.globallogictest.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.lmontes.globallogictest.dto.LoginRequest;
import com.lmontes.globallogictest.dto.LoginResponse;
import com.lmontes.globallogictest.dto.UserRequest;
import com.lmontes.globallogictest.exception.LoginException;
import com.lmontes.globallogictest.model.Person;
import com.lmontes.globallogictest.repository.UserRepository;
import com.lmontes.globallogictest.utils.JsonTokenUtils;
import com.lmontes.globallogictest.utils.PasswordUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private JsonTokenUtils jsonTokenUtils;

    @BeforeEach
    public void setUp() {
        // Configurar el comportamiento de los mocks si es necesario antes de cada prueba
    }

    @Test
    public void testSignup() {
        UserRequest userRequest = new UserRequest();
        Person person = new Person();

        when(modelMapper.map(userRequest, Person.class)).thenReturn(person);
        when(userRepository.save(person)).thenReturn(person);

        Optional<Person> result = userService.signup(userRequest);

        assertTrue(result.isPresent());
        assertEquals(person, result.get());
        verify(userRepository, times(1)).save(person);
    }

    //@Test
    public void testLoginSuccessful() {
        // Preparar datos de prueba
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("testuser@example.com");
        loginRequest.setPassword("password123");

        Person user = new Person();
        user.setEmail("testuser@example.com");
        user.setPassword(PasswordUtils.hashPassword("password123"));

        when(userRepository.findByEmail(loginRequest.getEmail())).thenReturn(user);
        when(jsonTokenUtils.generateToken(user)).thenReturn("token123");

        // Ejecutar el método login
        LoginResponse loginResponse = userService.login(loginRequest);

        // Verificar resultados
        assertNotNull(loginResponse);
        assertEquals("token123", loginResponse.getToken());
        // Agregar más verificaciones si es necesario
    }

    @Test
    public void testLoginUserNotFound() {
        // Preparar datos de prueba
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("nonexistent@example.com");
        loginRequest.setPassword("password123");

        when(userRepository.findByEmail(loginRequest.getEmail())).thenReturn(null);

        // Ejecutar el método login y esperar una excepción
        assertThrows(LoginException.class, () -> userService.login(loginRequest));
    }

    @Test
    public void testLoginIncorrectPassword() {
        // Preparar datos de prueba
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("testuser@example.com");
        loginRequest.setPassword("incorrectPassword");

        Person user = new Person();
        user.setEmail("testuser@example.com");
        user.setPassword(PasswordUtils.hashPassword("password123"));

        when(userRepository.findByEmail(loginRequest.getEmail())).thenReturn(user);

        // Ejecutar el método login y esperar una excepción
        assertThrows(LoginException.class, () -> userService.login(loginRequest));
    }
}
