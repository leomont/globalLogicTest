package com.lmontes.globallogictest.service;

import com.lmontes.globallogictest.model.Person;
import com.lmontes.globallogictest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Optional<Person> signup(Person user) {

        return Optional.of(userRepository.save(user));
    }
}
