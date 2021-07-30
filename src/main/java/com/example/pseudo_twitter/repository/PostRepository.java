package com.example.pseudo_twitter.repository;

import com.example.pseudo_twitter.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> getAllBy();
}
