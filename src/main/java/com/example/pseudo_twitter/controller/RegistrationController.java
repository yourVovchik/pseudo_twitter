package com.example.pseudo_twitter.controller;

import com.example.pseudo_twitter.entity.dto.UserDataDto;
import com.example.pseudo_twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ModelAndView registration(Model model){
        return new ModelAndView("reg","regUser",new UserDataDto());
    }

    @PostMapping()
    public ModelAndView registrationUser(@ModelAttribute("regUser") UserDataDto user){
        userService.add(user);
        return new ModelAndView("authorization");
    }
}
