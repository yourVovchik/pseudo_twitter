package com.example.pseudo_twitter.repository;

import com.example.pseudo_twitter.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJPA extends JpaRepository<User,Long>{
    boolean existsByMail(String mail);
    User findUserByMail(String mail);
}
