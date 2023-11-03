package com.lmontes.globallogictest.repository;

import com.lmontes.globallogictest.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.*;



@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    public TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByEmail() {
        // Crea un objeto Person para insertarlo en la base de datos
        Person person = new Person();
        person.setEmail("test@example.com");
        // Otras configuraciones para el objeto Person si es necesario

        // Inserta el objeto en la base de datos utilizando el TestEntityManager
        entityManager.persist(person);
        //userRepository.save(person);

        // Llama al método findByEmail para buscar el usuario por su dirección de correo
        Person foundPerson = userRepository.findByEmail("test@example.com");

        // Verifica que se haya encontrado el usuario
        assertNotNull(foundPerson);
        assertEquals("test@example.com", foundPerson.getEmail());
        // Realiza más verificaciones según sea necesario
    }

    @Test
    public void testFindByNonExistentEmail() {
        // Llama al método findByEmail para buscar un correo que no existe
        Person foundPerson = userRepository.findByEmail("nonexistent@example.com");

        // Verifica que el resultado sea nulo (es decir, que no se encontró ningún usuario)
        assertNull(foundPerson);
    }

}
