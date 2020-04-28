package ru.itis.jlab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.jlab.dto.SignInDto;
import ru.itis.jlab.dto.TokenDto;
import ru.itis.jlab.service.SignInService;
import ru.itis.jlab.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
public class SignInController {

    @RequestMapping(value = "signIn", method = RequestMethod.GET)
    public ModelAndView signIn() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signIn");
        return modelAndView;
    }

    @Autowired
    SignInService signInService;

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public ModelAndView signIn(HttpServletResponse response,
                               @RequestParam(value = "email") String login,
                               @RequestParam(value = "password") String password) {
        TokenDto tokenDto = signInService.signIn(SignInDto.builder().login(login).password(password).build());
        Cookie cookie = new Cookie("token", tokenDto.getToken());
        response.addCookie(cookie);
        ModelAndView modelAndView = new ModelAndView("redirect:/room");
        return modelAndView;
    }

}
