package ru.itis.jlab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.jlab.service.CookieService;
import ru.itis.jlab.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class IndexController {

    @Autowired
    CookieService cookieService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/index/{room}", method = RequestMethod.GET)
    public ModelAndView getIndexPage(@PathVariable("room") String room, HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageId", UUID.randomUUID().toString());
        modelAndView.addObject("room", room);
        modelAndView.setViewName("/chat");
        return modelAndView;
    }
}