package com.example.pseudo_twitter.entity.dto;

import com.example.pseudo_twitter.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long user_id;
    private String text;
}
