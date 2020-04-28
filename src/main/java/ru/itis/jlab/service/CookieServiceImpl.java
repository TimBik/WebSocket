package ru.itis.jlab.service;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import java.util.Optional;

@Component
public class CookieServiceImpl implements CookieService {

    @Override
    public Optional<String> getToken(Cookie... cookies) {
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                return Optional.of(cookie.getValue());
            }
        }
        return Optional.empty();
    }
}
