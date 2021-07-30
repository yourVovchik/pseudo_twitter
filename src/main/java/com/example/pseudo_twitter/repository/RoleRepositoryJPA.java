package com.example.pseudo_twitter.repository;

import com.example.pseudo_twitter.entity.user.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepositoryJPA extends JpaRepository<Role,Long> {
}
