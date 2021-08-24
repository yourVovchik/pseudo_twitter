package com.example.pseudo_twitter.controller;

import com.example.pseudo_twitter.entity.message.Message;
import com.example.pseudo_twitter.exception.NotFoundException;
import com.example.pseudo_twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView getLogin(Model model){
        model.addAttribute("users", userService.getAll());
        return new ModelAndView("users");
    }

    @PostMapping("/delete/{id}")
    public ModelAndView removeUser(Model model, @PathVariable Long id){
        try {
            userService.delete(id);
        } catch (NotFoundException e) {
            model.addAttribute("message",new Message("Пользователь не найден"));
            return new ModelAndView("errorPage");
        }
        model.addAttribute("users", userService.getAll());
        return new ModelAndView("users");
    }

    @PostMapping("/appoint/{id}")
    public ModelAndView setRoleAdmin(Model model, @PathVariable Long id){
        try {
            userService.setRoleAdmin(id);
        } catch (NotFoundException e) {
            model.addAttribute("message",new Message("Пользователь не найден"));
            return new ModelAndView("errorPage");
        }
        model.addAttribute("users", userService.getAll());
        return new ModelAndView("users");
    }


}
