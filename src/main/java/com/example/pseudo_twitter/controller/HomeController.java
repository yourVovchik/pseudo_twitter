package com.example.pseudo_twitter.controller;

import com.example.pseudo_twitter.entity.user.User;
import com.example.pseudo_twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping("/users")
    public ModelAndView allUser(Model model){
        model.addAttribute("users", userService.getAll());
        return new ModelAndView("/users");
    }
}
