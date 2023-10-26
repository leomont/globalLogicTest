package com.lmontes.globallogictest.repository;

import com.lmontes.globallogictest.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByEmail() {
        // Crear un usuario de prueba y guardarlo en la base de datos
        Person user = new Person();
        user.setEmail("testuser@example.com");
        entityManager.persist(user);

        // Buscar el usuario por su dirección de correo electrónico
        Person foundUser = userRepository.findByEmail("testuser@example.com");

        assertNotNull(foundUser);
        assertEquals("testuser@example.com", foundUser.getEmail());
    }

    @Test
    public void testFindByEmailWhenNotExists() {
        // Buscar un usuario que no existe en la base de datos
        Person notFoundUser = userRepository.findByEmail("nonexistent@example.com");

        assertNull(notFoundUser);
    }
}
