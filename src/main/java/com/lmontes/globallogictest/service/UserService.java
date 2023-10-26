package com.lmontes.globallogictest.service;

import com.lmontes.globallogictest.dto.UserRequest;
import com.lmontes.globallogictest.model.Person;
import com.lmontes.globallogictest.repository.UserRepository;
import com.lmontes.globallogictest.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public Optional<Person> signup(UserRequest user) {
        Person person = modelMapper.map(user, Person.class);

        person.setPassword(PasswordUtils.hashPassword(person.getPassword()));

        return Optional.of(userRepository.save(person));
    }
}
