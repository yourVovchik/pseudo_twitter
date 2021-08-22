package com.example.pseudo_twitter.entity.dto;

import com.example.pseudo_twitter.entity.post.Post;
import com.example.pseudo_twitter.entity.user.User;
import com.example.pseudo_twitter.entity.user.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUserDto {
    private long id;
    private String username;
    private String country;
    private Sex sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private int postCount;
    private int followerCount;
    private int subscribersCount;

}
