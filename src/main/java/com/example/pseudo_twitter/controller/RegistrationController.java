package com.example.pseudo_twitter.controller;

import com.example.pseudo_twitter.entity.dto.RegistrationUserDto;
import com.example.pseudo_twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    UserService userService;

    @GetMapping()
    public String registration(Model model){
        model.addAttribute("regUser", new RegistrationUserDto());
        return "reg";
    }

    @PostMapping()
    public String registrationUser(@ModelAttribute("regUser") RegistrationUserDto user){
        System.out.println(user);
        System.out.println(user.getEmail());
        userService.add(user);
        return "/home";
    }
}
