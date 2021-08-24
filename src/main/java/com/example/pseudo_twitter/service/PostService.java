package com.example.pseudo_twitter.service;

import com.example.pseudo_twitter.entity.dto.PostDto;
import com.example.pseudo_twitter.entity.post.Post;
import com.example.pseudo_twitter.entity.user.User;
import com.example.pseudo_twitter.exception.NotFoundException;
import com.example.pseudo_twitter.repository.PostRepository;
import com.example.pseudo_twitter.repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepositoryJPA userRepositoryJPA;

    public void add(PostDto postDto) throws NotFoundException {
        if(existsAuthorById(postDto.getUser_id())){
            postRepository.save(create(postDto));
        }else{
            throw new NotFoundException();
        }
    }

    public List<Post> getSubsPostById(Long id) throws NotFoundException {
        if(existsAuthorById(id)){
            return getByAuthors(userRepositoryJPA.getById(id).getSubscriptions());
        }else{
            throw new NotFoundException();
        }
    }

    public List<Post> getByAuthor(Long id) throws NotFoundException {
        if(existsAuthorById(id)){
            return postRepository.getByAuthorOrderByDateDesc(userRepositoryJPA.getById(id));
        }else{
            throw new NotFoundException();
        }
    }

    public List<Post> getByAuthors(Set<User> authors) throws NotFoundException {
        for(User author : authors){
            if(!existsAuthorById(author.getId())){
                throw new NotFoundException();
            }
        }
        return postRepository.getByAuthors(authors);
    }


    private Post create(PostDto postDto){
        Post post = new Post();
        post.setText(postDto.getText());
        post.setAuthor(userRepositoryJPA.getById(postDto.getUser_id()));
        return post;
    }

    private boolean existsAuthorById(Long id){
        return userRepositoryJPA.existsById(id);
    }
}
