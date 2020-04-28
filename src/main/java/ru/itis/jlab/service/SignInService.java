package ru.itis.jlab.service;

import ru.itis.jlab.dto.SignInDto;
import ru.itis.jlab.dto.TokenDto;

public interface SignInService {
    TokenDto signIn(SignInDto signInData);
}
