package com.example.pseudo_twitter.service;

import com.example.pseudo_twitter.entity.dto.PostDto;
import com.example.pseudo_twitter.entity.post.Post;
import com.example.pseudo_twitter.repository.PostRepository;
import com.example.pseudo_twitter.repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;

public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepositoryJPA userRepositoryJPA;

    public void add(PostDto postDto){
        if(!existsAuthorById(postDto.getUser_id())){
            postRepository.save(create(postDto));
        }
    }

    private Post create(PostDto postDto){
        Post post = new Post();
        post.setText(postDto.getText());
        post.setAuthor(userRepositoryJPA.getById(post.getId()));
        return post;
    }

    private boolean existsAuthorById(Long id){
        return userRepositoryJPA.existsById(id);
    }
}
