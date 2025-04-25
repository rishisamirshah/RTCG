package com.onepiece.cardmanager.repository;

import com.onepiece.cardmanager.model.deck.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List; // Optional: if adding custom find methods later

@Repository
public interface DeckRepository extends JpaRepository<Deck, Long> {

    // Spring Data JPA will automatically implement basic CRUD operations.

    // Method to find decks belonging to a specific user
    List<Deck> findByUserId(Long userId);

    // Example of custom query methods you might add later:
    // List<Deck> findByNameContainingIgnoreCase(String name);
} 