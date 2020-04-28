package ru.itis.jlab.service;

import ru.itis.jlab.dto.UserDto;
import ru.itis.jlab.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> getAllUsers();

    void deleteUser(Long userId);

    Optional<User> findByEmail(String email);

    Optional<User> findByLogin(String login);


}
