package com.onepiece.cardmanager.controller;

import com.onepiece.cardmanager.dto.RegisterDTO;
import com.onepiece.cardmanager.model.User;
import com.onepiece.cardmanager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map; // For returning user info

@RestController
@RequestMapping("/api/auth")
// Apply global CORS config from SecurityConfig, or uncomment below for specific origin
// @CrossOrigin(origins = "http://localhost:3001")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDTO registerDTO) {
        try {
            User registeredUser = userService.registerNewUser(registerDTO.getUsername(), registerDTO.getPassword());
            // You might want to return a different DTO without the password
            return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            // Handle username already exists or other validation errors from service
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            // Catch broader exceptions for unexpected errors
             throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error during registration", e);
        }
    }

    // Login endpoint (/api/auth/login) is handled by Spring Security's formLogin configuration
    // Logout endpoint (/api/auth/logout) is handled by Spring Security's logout configuration

    // Endpoint to get current user info
    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No authenticated user.");
        }
        Object principal = authentication.getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else if (principal instanceof String) {
            username = (String) principal;
        } else {
            // Fallback or error if principal is unexpected type
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not determine username.");
        }
        // Return username (or more details if needed)
        return ResponseEntity.ok(Map.of("username", username));
    }

} 