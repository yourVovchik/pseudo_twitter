package com.example.pseudo_twitter.entity.post;

import com.example.pseudo_twitter.entity.post.Post;
import com.example.pseudo_twitter.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "likes")
@Entity
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private User user;
    @OneToOne
    private Post post;
    private LocalDateTime date;

}
