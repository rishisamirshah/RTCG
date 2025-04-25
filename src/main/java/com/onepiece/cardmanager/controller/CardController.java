package com.onepiece.cardmanager.controller;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
// CardBulkImporter import might be removed if not used elsewhere
// import com.onepiece.cardmanager.util.CardBulkImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.onepiece.cardmanager.specification.CardSpecification;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;
import java.util.Set; // Import Set for list parameters
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin(origins = "*") // Enable CORS for frontend development
public class CardController {
    
    private final CardRepository cardRepository;
    // Remove bulk importer if only used in commented-out code
    // private final CardBulkImporter cardBulkImporter;
    
    @Autowired
    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
        // Remove bulk importer injection
        // this.cardBulkImporter = cardBulkImporter;
    }
    
    // Modify GetMapping to accept RequestParams for filtering
    @GetMapping
    public List<Card> getFilteredCards(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false) Set<String> colors,
            @RequestParam(required = false) Set<Integer> costs,
            @RequestParam(required = false) Set<String> types,
            @RequestParam(required = false) Set<String> sets
            // Add more parameters here later (power, counter, keywords, sort)
    ) {
        // Create the specification based on the parameters
        Specification<Card> spec = CardSpecification.createSpecification(
            searchTerm, colors, costs, types, sets
            // Pass additional parameters here
        );

        // Use the repository's findAll method with the specification
        List<Card> cards = cardRepository.findAll(spec);
        
        // Fix image paths for ST06-ST20 cards
        cards.forEach(this::fixImagePath);
        
        return cards;
    }
    
    // Get card by ID
    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Long id) {
        return cardRepository.findById(id)
                .map(card -> {
                    fixImagePath(card);
                    return ResponseEntity.ok(card);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Fixes image paths for ST06-ST20 cards to use .png extension instead of .jpg
     * @param card The card to fix
     */
    private void fixImagePath(Card card) {
        if (card != null && card.getImagePath() != null && card.getImagePath().endsWith(".jpg")) {
            // Pattern to match ST06-ST20 card image paths
            Pattern pattern = Pattern.compile("/ST(\\d+)/ST\\d+-\\d+\\.jpg$");
            Matcher matcher = pattern.matcher(card.getImagePath());
            
            if (matcher.find()) {
                int stNumber = Integer.parseInt(matcher.group(1));
                if (stNumber >= 6 && stNumber <= 20) {
                    String fixedPath = card.getImagePath().replace(".jpg", ".png");
                    System.out.println("Fixing image path for " + card.getCardNumber() + ": " + card.getImagePath() + " -> " + fixedPath);
                    card.setImagePath(fixedPath);
                }
            }
        }
    }
    
    // Remove other unused endpoints like /set, /series, /search/name, etc.
    // unless they are still needed for other purposes.
    // We aim for a single powerful filtering endpoint.

    // Remove temporary test endpoint
    /*
    @GetMapping("/test/{cardNumber}")
    public ResponseEntity<Card> getCardByNumber(@PathVariable String cardNumber) {
        Optional<Card> cardOptional = cardRepository.findByCardNumber(cardNumber);
        return cardOptional.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }
    */
} 