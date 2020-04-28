package ru.itis.jlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChoiceRoomController {


    @RequestMapping(value = "room", method = RequestMethod.GET)
    public ModelAndView room() {
        return new ModelAndView("choiceRoom");
    }
}
