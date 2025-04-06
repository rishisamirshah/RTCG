package com.onepiece.cardmanager.controller;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import com.onepiece.cardmanager.util.CardBulkImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin(origins = "*") // Enable CORS for frontend development
public class CardController {
    
    private final CardRepository cardRepository;
    private final CardBulkImporter cardBulkImporter;
    
    @Autowired
    public CardController(CardRepository cardRepository, CardBulkImporter cardBulkImporter) {
        this.cardRepository = cardRepository;
        this.cardBulkImporter = cardBulkImporter;
    }
    
    // Get all cards
    @GetMapping
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
    
    // Create a new card
    @PostMapping
    public Card createCard(@RequestBody Card card) {
        return cardRepository.save(card);
    }
    
    // Get card by ID
    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Long id) {
        return cardRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Search cards by name
    @GetMapping("/search/name/{name}")
    public List<Card> searchByName(@PathVariable String name) {
        return cardRepository.findByNameContainingIgnoreCase(name);
    }
    
    // Get cards by type
    @GetMapping("/type/{cardType}")
    public List<Card> getByCardType(@PathVariable String cardType) {
        return cardRepository.findByCardType(cardType);
    }
    
    // Get cards by affiliation
    @GetMapping("/affiliation/{affiliation}")
    public List<Card> getByAffiliation(@PathVariable String affiliation) {
        return cardRepository.findByAffiliationsContainingIgnoreCase(affiliation);
    }
    
    // Get card by card number
    @GetMapping("/number/{cardNumber}")
    public ResponseEntity<Card> getByCardNumber(@PathVariable String cardNumber) {
        return cardRepository.findByCardNumber(cardNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Search cards by multiple criteria
    @GetMapping("/search")
    public List<Card> searchCards(
            @RequestParam(required = false) String cardType,
            @RequestParam(required = false) Integer minPower,
            @RequestParam(required = false) Integer maxPower,
            @RequestParam(required = false) String affiliation) {
        return cardRepository.findByMultipleCriteria(cardType, minPower, maxPower, affiliation);
    }
    
    // Update a card
    @PutMapping("/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable Long id, @RequestBody Card cardDetails) {
        return cardRepository.findById(id)
                .map(existingCard -> {
                    existingCard.setName(cardDetails.getName());
                    existingCard.setCardNumber(cardDetails.getCardNumber());
                    existingCard.setLife(cardDetails.getLife());
                    existingCard.setCardType(cardDetails.getCardType());
                    existingCard.setAttribute(cardDetails.getAttribute());
                    existingCard.setTiming(cardDetails.getTiming());
                    existingCard.setEffect(cardDetails.getEffect());
                    existingCard.setAffiliations(cardDetails.getAffiliations());
                    existingCard.setPower(cardDetails.getPower());
                    existingCard.setImagePath(cardDetails.getImagePath());
                    return ResponseEntity.ok(cardRepository.save(existingCard));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Delete a card
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable Long id) {
        return cardRepository.findById(id)
                .map(card -> {
                    cardRepository.delete(card);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/import")
    public ResponseEntity<List<String>> importCards() {
        List<String> results = cardBulkImporter.importCardsFromDirectory("images/cards");
        return ResponseEntity.ok(results);
    }
} 