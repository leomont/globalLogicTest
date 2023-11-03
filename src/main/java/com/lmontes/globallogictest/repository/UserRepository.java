package com.lmontes.globallogictest.repository;

import com.lmontes.globallogictest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Person, Long> {
    Person findByEmail(String email);

}
