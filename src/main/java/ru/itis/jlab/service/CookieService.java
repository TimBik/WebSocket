package ru.itis.jlab.service;

import javax.servlet.http.Cookie;
import java.util.Optional;

public interface CookieService {

    Optional<String> getToken(Cookie ...cookie);
}
