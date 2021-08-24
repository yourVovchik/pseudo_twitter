package com.example.pseudo_twitter.service;

import com.example.pseudo_twitter.entity.dto.UserDataDto;
import com.example.pseudo_twitter.exception.DuplicateDataException;
import com.example.pseudo_twitter.repository.UserRepositoryJPA;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepositoryJPA userRepositoryJPA;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    void add() {
        UserDataDto userDataDto = new UserDataDto();
        try {
            userService.add(userDataDto);
        } catch (DuplicateDataException e) {
            e.printStackTrace();
        }
    }
}