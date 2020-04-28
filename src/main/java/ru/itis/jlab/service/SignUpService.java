package ru.itis.jlab.service;


import ru.itis.jlab.dto.SignUpDto;
import ru.itis.jlab.dto.UserDto;

public interface SignUpService {
    UserDto loadUserFromParameters(SignUpDto params);

    void chageStateAccept(String url);
}
