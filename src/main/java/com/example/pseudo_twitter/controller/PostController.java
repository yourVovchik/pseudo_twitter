package com.example.pseudo_twitter.controller;

import com.example.pseudo_twitter.entity.dto.PostDto;
import com.example.pseudo_twitter.entity.user.User;
import com.example.pseudo_twitter.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/feed")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ModelAndView feed(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("posts",postService.getSubsPostById(user.getId()));
        return new ModelAndView("home");
    }

    @GetMapping("/post")
    public ModelAndView sendTweet(Model model){
        model.addAttribute("post", new PostDto());
        return new ModelAndView("postForm");
    }

    @GetMapping("/{id}")
    public ModelAndView sendTweet(@PathVariable Long id, Model model){
        model.addAttribute("posts", postService.getByAuthor(id));
        return new ModelAndView("userPosts");
    }

    @PostMapping("/post")
    public String postTweet(@ModelAttribute("post")PostDto postDto,@AuthenticationPrincipal User user){
        postDto.setUser_id(user.getId());
        postService.add(postDto);
        return "home";
    }
}
