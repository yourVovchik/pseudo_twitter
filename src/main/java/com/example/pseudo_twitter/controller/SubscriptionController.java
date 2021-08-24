package com.example.pseudo_twitter.controller;

import com.example.pseudo_twitter.entity.message.Message;
import com.example.pseudo_twitter.entity.user.User;
import com.example.pseudo_twitter.exception.NotFoundException;
import com.example.pseudo_twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class SubscriptionController {

    @Autowired
    private UserService userService;

    @GetMapping("/subscription/{id}")
    public ModelAndView getSubscriptions(Model model,@PathVariable Long id){
        try {
            model.addAttribute("subscriptions",userService.getSubById(id));
        } catch (NotFoundException e) {
            model.addAttribute("message",new Message("Пользователь не найден"));
            return new ModelAndView("errorPage");
        }
        return new ModelAndView("subscriptions");
    }

    @PostMapping("/subscription/{id}")
    public ModelAndView addSubscription(Model model, @PathVariable Long id, @AuthenticationPrincipal User user){
        try {
            userService.subscribe(id,user.getId());
        } catch (NotFoundException e) {
            model.addAttribute("message",new Message("Пользователь не найден"));
            return new ModelAndView("errorPage");
        }
        return new ModelAndView("subscriptions");
    }

    @GetMapping("/followers/{id}")
    public ModelAndView getFollowers(Model model, @PathVariable Long id){
        try {
            model.addAttribute("followers",userService.getFollowerById(id));
        } catch (NotFoundException e) {
            model.addAttribute("message",new Message("Пользователь не найден"));
            return new ModelAndView("errorPage");
        }
        return new ModelAndView("followers");
    }

}
