package com.example.pseudo_twitter.controller;

import com.example.pseudo_twitter.entity.dto.UserDataDto;
import com.example.pseudo_twitter.entity.message.Message;
import com.example.pseudo_twitter.entity.user.User;
import com.example.pseudo_twitter.exception.NotFoundException;
import com.example.pseudo_twitter.exception.WrongDataException;
import com.example.pseudo_twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ModelAndView getById(@PathVariable Long id, Model model){
        try {
            model.addAttribute("user", userService.getProfileForm(id));
        } catch (NotFoundException e) {
            model.addAttribute("message",new Message("Пользователь не найден"));
            return new ModelAndView("errorPage");
        }
        return new ModelAndView("user");
    }

    @GetMapping("/edit")
    public ModelAndView editForm(Model model,@AuthenticationPrincipal User user){
        try {
            model.addAttribute("editUser", userService.getUserForm(user.getId()));
        } catch (NotFoundException e) {
            model.addAttribute("message",new Message("Пользователь не найден"));
            return new ModelAndView("errorPage");
        }
        return new ModelAndView("editProfile");
    }

    @PostMapping("/edit")
    public ModelAndView editProfile(@Valid @ModelAttribute("editUser") UserDataDto editUser, BindingResult bindingResult, @AuthenticationPrincipal User user,Model model){
        if(bindingResult.hasErrors()){
            return new ModelAndView("editProfile");
        }
        try {
            userService.editPublicDataUser(editUser, user.getId());
        } catch (NotFoundException e) {
            model.addAttribute("message",new Message("Пользователь не найден"));
            return new ModelAndView("errorPage");
        } catch (WrongDataException e) {
            model.addAttribute("message",new Message("Неверный пароль"));
            return new ModelAndView("editProfile");
        }
        return new ModelAndView("home");
    }

    @GetMapping("/editPassword")
    public ModelAndView editPasswordForm(Model model){
        return new ModelAndView("editPassword");
    }

    @PostMapping("/editPassword")
    public ModelAndView editPassword(String oldPassword, String newPassword,@AuthenticationPrincipal User user, Model model){
        try {
            userService.editPassword(oldPassword,newPassword,user.getId());
        }  catch (NotFoundException e) {
            model.addAttribute("message",new Message("Пользователь не найден"));
            return new ModelAndView("errorPage");
        } catch (WrongDataException e) {
            model.addAttribute("message",new Message("Неверный пароль"));
            return new ModelAndView("editProfile");
        }
        return new ModelAndView("home");
    }



}
