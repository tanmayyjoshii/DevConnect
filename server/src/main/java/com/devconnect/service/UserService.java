package com.devconnect.service;

import com.devconnect.model.User;
import com.devconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getCurrentUser(UUID userId) {
        return userRepository.findById(userId);
    }

    public User updateProfile(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(UUID userId) {
        return userRepository.findById(userId);
    }
}