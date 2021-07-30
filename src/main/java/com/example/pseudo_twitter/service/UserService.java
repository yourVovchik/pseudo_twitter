package com.example.pseudo_twitter.service;

import com.example.pseudo_twitter.entity.dto.RegistrationUserDto;
import com.example.pseudo_twitter.entity.user.User;
import com.example.pseudo_twitter.entity.user.enums.Role;
import com.example.pseudo_twitter.repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    UserRepositoryJPA userRepositoryJPA;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public void add(RegistrationUserDto userDto){
        if(!userRepositoryJPA.existsByMail(userDto.getEmail())){
            User user = createUser(userDto);
            userRepositoryJPA.save(user);
        }
    }

    public User getById(Long id){
        if(userRepositoryJPA.existsById(id)){
            return userRepositoryJPA.getById(id);
        }
        return null;
    }

    private User createUser(RegistrationUserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setMail(userDto.getEmail());
        user.setCountry(userDto.getCountry());
        user.setBirthday(userDto.getBirthday());
        user.setSex(userDto.getSex());
        user.setRoles(Collections.singleton(new Role(1L, "USER")));
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return user;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepositoryJPA.findUserByMail(s);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
