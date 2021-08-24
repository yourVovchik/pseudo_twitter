package com.example.pseudo_twitter.repository;

import com.example.pseudo_twitter.entity.post.Post;
import com.example.pseudo_twitter.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> getAllBy();
    List<Post> getByAuthorOrderByDateDesc(User author);
    @Query("select ba from Post ba where ba.author in :authors order by ba.date desc ")
    List<Post> getByAuthors(@Param("authors") Set<User> authors);
}
