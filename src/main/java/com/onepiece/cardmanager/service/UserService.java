package com.onepiece.cardmanager.service;

import com.onepiece.cardmanager.model.User;
import com.onepiece.cardmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User registerNewUser(String username, String rawPassword) {
        // Check if username already exists
        if (userRepository.existsByUsernameIgnoreCase(username)) {
            // Consider throwing a more specific exception
            throw new IllegalArgumentException("Username already exists: " + username);
        }

        // Encode the password
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // Create and save the new user
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(encodedPassword);
        // Set roles if applicable

        return userRepository.save(newUser);
    }

    // Add other user-related methods here if needed (e.g., findById, updateProfile)
} 