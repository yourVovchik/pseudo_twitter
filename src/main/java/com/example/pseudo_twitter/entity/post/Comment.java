package com.example.pseudo_twitter.entity.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
@Entity
public class Comment extends Post {
    @OneToOne
    private Post post;
}
