package com.lmontes.globallogictest.service;

import com.lmontes.globallogictest.dto.LoginRequest;
import com.lmontes.globallogictest.dto.LoginResponse;
import com.lmontes.globallogictest.dto.UserRequest;
import com.lmontes.globallogictest.exception.LoginException;
import com.lmontes.globallogictest.model.Person;
import com.lmontes.globallogictest.repository.UserRepository;
import com.lmontes.globallogictest.utils.JsonTokenUtils;
import com.lmontes.globallogictest.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private final JsonTokenUtils jsonTokenUtils;

    public Optional<Person> signup(UserRequest user) {
        Person person = modelMapper.map(user, Person.class);

        person.setPassword(PasswordUtils.hashPassword(person.getPassword()));
        person.setCreated(LocalDateTime.now());

        return Optional.of(userRepository.save(person));
    }

    public LoginResponse login(LoginRequest login) {
        Person user = userRepository.findByEmail(login.getEmail());

        if(Objects.isNull(user) || !PasswordUtils.checkPassword(login.getPassword(), user.getPassword()) ) {
            throw new LoginException("Los datos no son correctos");
        }

        user.setLastLogin(LocalDateTime.now());
        userRepository.save(user);

        LoginResponse loginResponse = modelMapper.map(user, LoginResponse.class);
        String jwt = jsonTokenUtils.generateToken(user);
        loginResponse.setToken(jwt);

        return loginResponse;
    }
}
