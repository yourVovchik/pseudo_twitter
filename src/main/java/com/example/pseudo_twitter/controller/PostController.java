package com.example.pseudo_twitter.controller;

import com.example.pseudo_twitter.entity.dto.PostDto;
import com.example.pseudo_twitter.entity.message.Message;
import com.example.pseudo_twitter.entity.user.User;
import com.example.pseudo_twitter.exception.NotFoundException;
import com.example.pseudo_twitter.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/feed")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ModelAndView feed(Model model, @AuthenticationPrincipal User user){
        try {
            model.addAttribute("posts",postService.getSubsPostById(user.getId()));
        } catch (NotFoundException e) {
            model.addAttribute("message",new Message("Пользователь не найден"));
            return new ModelAndView("/errorPage");
        }
        return new ModelAndView("home");
    }

    @GetMapping("/post")
    public ModelAndView sendTweet(Model model){
        model.addAttribute("post", new PostDto());
        return new ModelAndView("postForm");
    }

    @GetMapping("/{id}")
    public ModelAndView sendTweet(@PathVariable Long id, Model model){
        try {
            model.addAttribute("posts", postService.getByAuthor(id));
        } catch (NotFoundException e) {
            model.addAttribute("message",new Message("Пользователь не найден"));
            return new ModelAndView("/errorPage");
        }
        return new ModelAndView("userPosts");
    }

    @PostMapping("/post")
    public ModelAndView postTweet(@Valid @ModelAttribute("post")PostDto postDto, BindingResult bindingResult, @AuthenticationPrincipal User user, Model model){
        if(bindingResult.hasErrors()){
            return new ModelAndView("postForm");
        }
        postDto.setUser_id(user.getId());
        try {
            postService.add(postDto);
            model.addAttribute("posts", postService.getByAuthor(user.getId()));
        } catch (NotFoundException e) {
            model.addAttribute("message",new Message("Пользователь не найден"));
            return new ModelAndView("/errorPage");
        }
        return new ModelAndView("userPosts");
    }
}
