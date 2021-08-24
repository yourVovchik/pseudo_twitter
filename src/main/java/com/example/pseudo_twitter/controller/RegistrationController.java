package com.example.pseudo_twitter.controller;

import com.example.pseudo_twitter.entity.dto.UserDataDto;
import com.example.pseudo_twitter.exception.DuplicateDataException;
import com.example.pseudo_twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ModelAndView registration(Model model){
        return new ModelAndView("registration","regUser",new UserDataDto());
    }

    @PostMapping()
    public ModelAndView registrationUser(@Valid @ModelAttribute("regUser") UserDataDto user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return new ModelAndView("registration");
        }
        try {
            userService.add(user);
        } catch (DuplicateDataException e) {
            model.addAttribute("message","Адрес занят");
            return new ModelAndView("registration");
        }
        return new ModelAndView("authorization");
    }
}
