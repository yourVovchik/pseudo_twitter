package com.example.pseudo_twitter.entity.dto;

import com.example.pseudo_twitter.entity.user.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDataDto {
    private String email;
    private String username;
    private String password;
    private String country;
    private Sex sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
}
