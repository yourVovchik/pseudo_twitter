package com.example.pseudo_twitter.entity.user;

import com.example.pseudo_twitter.entity.user.enums.Role;
import com.example.pseudo_twitter.entity.user.enums.Sex;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.script.ScriptEngineManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String mail;
    private String password;
    private String country;
    private Sex sex;
    private LocalDate birthday;
    @ManyToMany
    @JoinTable(
        name = "subscription_follower",
        joinColumns = @JoinColumn(name = "follower_id"),
        inverseJoinColumns = @JoinColumn(name = "subscription_id"))
    private Set<User> subscriptions;
    @ManyToMany(mappedBy = "subscriptions")
    private Set<User> followers;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dateOfCreation;
    @Transient
    private String passwordConfirm;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
    private boolean verification;
    private boolean active;


    public User(String mail, String password, Set<Role> roles, boolean active) {
        this.mail = mail;
        this.password = password;
        this.roles = roles;
        this.active = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.active;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(mail, user.mail) && Objects.equals(password, user.password) && Objects.equals(country, user.country) && sex == user.sex && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, mail, password, country, sex, birthday);
    }
}
