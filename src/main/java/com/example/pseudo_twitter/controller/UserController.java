package com.example.pseudo_twitter.controller;

import com.example.pseudo_twitter.entity.dto.UserDataDto;
import com.example.pseudo_twitter.entity.user.User;
import com.example.pseudo_twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.getProfileForm(id));
        return "user";
    }

    @GetMapping("/edit")
    public ModelAndView editForm(Model model,@AuthenticationPrincipal User user){
        model.addAttribute("editUser", userService.getUserForm(user.getId()));
        return new ModelAndView("editProfile");
    }

    @PostMapping("/edit")
    public ModelAndView editProfile(@ModelAttribute("editUser") UserDataDto editUser,@AuthenticationPrincipal User user){
        userService.editPublicDataUser(editUser, user.getId());
        return new ModelAndView("home");
    }

    @GetMapping("/editPassword")
    public ModelAndView editPasswordForm(Model model){
        return new ModelAndView("editPassword");
    }

    @PostMapping("/editPassword")
    public ModelAndView editPassword(String oldPassword, String newPassword,@AuthenticationPrincipal User user){
        userService.editPassword(oldPassword,newPassword,user.getId());
        return new ModelAndView("/home");
    }



}
