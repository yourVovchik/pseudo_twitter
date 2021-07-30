package com.example.pseudo_twitter.controller;

import com.example.pseudo_twitter.entity.dto.RegistrationUserDto;
import com.example.pseudo_twitter.entity.user.User;
import com.example.pseudo_twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public String getById(Model model){
        RegistrationUserDto registrationUserDto = new RegistrationUserDto();
        registrationUserDto.setEmail("gmail.hello");
        userService.add(registrationUserDto);
        return "reg";
    }


}
