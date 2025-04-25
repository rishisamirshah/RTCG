package com.onepiece.cardmanager.repository;

import com.onepiece.cardmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Method to find a user by their username (case-insensitive)
    Optional<User> findByUsernameIgnoreCase(String username);

    // Method to check if a username already exists
    boolean existsByUsernameIgnoreCase(String username);

} 