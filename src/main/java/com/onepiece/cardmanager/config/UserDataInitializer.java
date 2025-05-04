package com.onepiece.cardmanager.config;

import com.onepiece.cardmanager.model.User;
import com.onepiece.cardmanager.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Profile("!test") // Don't run this during tests
public class UserDataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserDataInitializer.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Use final fields and constructor injection
    @Autowired
    public UserDataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional // Ensure operations are transactional
    public void run(String... args) throws Exception {
        String defaultUsername = "rishi";
        String defaultPassword = "rishi1";

        // Check if the default user already exists
        if (!userRepository.existsByUsernameIgnoreCase(defaultUsername)) {
            User defaultUser = new User();
            defaultUser.setUsername(defaultUsername);
            // IMPORTANT: Always encode the password before saving!
            defaultUser.setPassword(passwordEncoder.encode(defaultPassword));
            // Set roles/authorities here if needed in the future
            // defaultUser.setRoles("ROLE_ADMIN,ROLE_USER"); 

            userRepository.save(defaultUser);
            log.info("Created default user: {}", defaultUsername);
        } else {
            log.info("Default user '{}' already exists, skipping creation.", defaultUsername);
        }
    }
} 