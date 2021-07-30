package com.example.pseudo_twitter.controller;

import com.example.pseudo_twitter.entity.dto.PostDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/feed")
public class PostController {

    @GetMapping("/create")
    public String sendTweet(Model model){
        model.addAttribute("post", new PostDto());
        return "postForm";
    }

    @PostMapping("/create")
    public String postTweet(PostDto postDto){
        return "home";
    }
}
