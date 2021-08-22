package com.example.pseudo_twitter.repository;

import com.example.pseudo_twitter.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepositoryJPA extends JpaRepository<User,Long>{
    boolean existsByMail(String mail);
    User findUserByMail(String mail);
    List<User> getAllBy();
}
