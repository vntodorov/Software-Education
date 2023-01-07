package com.example.demo.services;

import com.example.demo.models.Account;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void register(String username, int age) {
        if (username == null || username.trim().isEmpty() || age < 18){
            throw new IllegalArgumentException("Validation failed");
        }

        Optional<User> byUsername = this.userRepository.findByUsername(username);
        if (byUsername.isPresent()){
            throw new IllegalArgumentException("Username already in database.");
        }

        Account account = new Account();
        User user = new User(username, age, account);

        this.userRepository.save(user);

    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username).get();
    }
}
