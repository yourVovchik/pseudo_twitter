package com.example.pseudo_twitter.service;

import com.example.pseudo_twitter.entity.dto.ProfileUserDto;
import com.example.pseudo_twitter.entity.dto.UserDataDto;
import com.example.pseudo_twitter.entity.user.User;
import com.example.pseudo_twitter.entity.user.enums.Role;
import com.example.pseudo_twitter.repository.PostRepository;
import com.example.pseudo_twitter.repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepositoryJPA userRepositoryJPA;

    @Autowired
    private PostService postService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void add(UserDataDto userDto) {
        if (!userRepositoryJPA.existsByMail(userDto.getEmail())) {
            User user = createUser(userDto);
            userRepositoryJPA.save(user);
        }
    }

    public void delete(Long id){
        if (userRepositoryJPA.existsById(id)) {
            userRepositoryJPA.deleteById(id);
        }
    }


    public Set<User> getSubById(Long id){
        if (userRepositoryJPA.existsById(id)) {
            return userRepositoryJPA.getById(id).getSubscriptions();
        }
        return null;
    }

    public void setRoleAdmin(Long id){
        if(userRepositoryJPA.existsById(id)){
            User user = userRepositoryJPA.getById(id);
            user.getRoles().add(new Role(2L,"ROLE_ADMIN"));
            userRepositoryJPA.save(user);
        }
    }

    public Set<User> getFollowerById(Long id){
        if (userRepositoryJPA.existsById(id)) {
            return userRepositoryJPA.getById(id).getFollowers();
        }
        return null;
    }

    public void subscribe(Long subscribe_id, Long follower_id){
        if (userRepositoryJPA.existsById(follower_id) && userRepositoryJPA.existsById(subscribe_id)) {
            User user = userRepositoryJPA.getById(follower_id);
            user.getSubscriptions().add(userRepositoryJPA.getById(subscribe_id));
            userRepositoryJPA.save(user);
        }
    }

    public User getById(Long id) {
        if (userRepositoryJPA.existsById(id)) {
            return userRepositoryJPA.getById(id);
        }
        return null;
    }

    public UserDataDto getUserForm(Long id) {
        if (userRepositoryJPA.existsById(id)) {
            return createDataUserDto(userRepositoryJPA.getById(id));
        }
        return null;
    }

    public ProfileUserDto getProfileForm(Long id){
        if (userRepositoryJPA.existsById(id)) {
            return createProfileUser(userRepositoryJPA.getById(id));
        }
        return null;
    }

    public void editPublicDataUser(UserDataDto editUser, Long id) {
        if(checkPassword(editUser.getPassword(),id)){
            User user = createUser(editUser);
            user.setId(id);
            userRepositoryJPA.save(user);
        }
    }

    private ProfileUserDto createProfileUser(User user){
        ProfileUserDto profileUserDto = new ProfileUserDto();
        profileUserDto.setId(user.getId());
        profileUserDto.setUsername(user.getUsername());
        profileUserDto.setSex(user.getSex());
        profileUserDto.setBirthday(user.getBirthday());
        profileUserDto.setCountry(user.getCountry());
        profileUserDto.setFollowerCount(getFollowerById(user.getId()).size());
        profileUserDto.setSubscribersCount(getSubById(user.getId()).size());
        profileUserDto.setPostCount(postService.getByAuthor(user.getId()).size());
        return profileUserDto;
    }

    private boolean checkPassword(String password, Long id){
        if (userRepositoryJPA.existsById(id)) {
            return passwordEncoder.matches(password, userRepositoryJPA.getById(id).getPassword());
        }
        return false;
    }

    public void editPassword(String oldPassword, String newPassword, Long id){
        if(checkPassword(oldPassword,id)){
            User user = userRepositoryJPA.getById(id);
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepositoryJPA.save(user);
        }
    }


    public List<User> getAll(){
        return userRepositoryJPA.getAllBy();
    }

    private User createUser(UserDataDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setMail(userDto.getEmail());
        user.setCountry(userDto.getCountry());
        user.setBirthday(userDto.getBirthday());
        user.setSex(userDto.getSex());
        user.setRoles(Collections.singleton(new Role(1L, "USER")));
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Set users = new HashSet();
        Set followers = new HashSet();
        user.setFollowers(followers);
        user.setSubscriptions(users);
        user.setActive(true);
        return user;
    }


    private UserDataDto createDataUserDto(User user) {
        UserDataDto userDataDto = new UserDataDto();
        userDataDto.setEmail(user.getMail());
        userDataDto.setUsername(user.getUsername());
        userDataDto.setBirthday(user.getBirthday());
        userDataDto.setSex(user.getSex());
        userDataDto.setCountry(user.getCountry());
        return userDataDto;
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
