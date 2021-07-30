package com.example.pseudo_twitter.entity.user.enums;

import com.example.pseudo_twitter.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_role")
public class Role implements GrantedAuthority {
    @Id
    private Long id;
    private String name;
    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String getAuthority() {
        return getName();
    }
}
