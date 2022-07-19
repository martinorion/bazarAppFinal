package com.example.backend.User;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    //Vytvaranie použivateľa s rolou USER
    @Override
    public User addUser(User user) {
    //String encodedPassword = passwordEncoder.encode(user.getPassword());
    //user.setPassword(encodedPassword);
        user.setRoles("USER");
        return this.repository.save(user);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return this.repository.findByUserName(username);
    }

    @Override
    public User updateUser(User user) {
        return this.repository.save(user);
    }


    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    User loggedUser;

    @Override
    public void findLoggedUsers(String username) {
       setLoggedUser(this.repository.findByUserName(username).get());
    }
}

