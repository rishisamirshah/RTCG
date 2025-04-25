package com.onepiece.cardmanager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;
import com.onepiece.cardmanager.model.deck.Deck;

@Entity
@Table(name = "users") // Use "users" as table name, "user" can be reserved
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password; // Store hashed password

    // TODO: Add roles/authorities if needed
    // private String roles;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // Relationship to Decks owned by the user
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Deck> decks = new HashSet<>();

    // Constructor (optional)
    public User(String username, String password) {
        this.username = username;
        this.password = password; // Remember to hash before saving!
    }
} 