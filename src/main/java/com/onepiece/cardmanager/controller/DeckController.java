package com.onepiece.cardmanager.controller;

import com.onepiece.cardmanager.dto.DeckDTO;
import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.model.User;
import com.onepiece.cardmanager.model.deck.Deck;
import com.onepiece.cardmanager.model.deck.DeckCard;
import com.onepiece.cardmanager.repository.CardRepository;
import com.onepiece.cardmanager.repository.DeckRepository;
import com.onepiece.cardmanager.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/decks")
// Configure CORS for the deck builder frontend origin
@CrossOrigin(origins = "http://localhost:3001")
public class DeckController {

    private final DeckRepository deckRepository;
    private final CardRepository cardRepository; // Needed to find cards by number
    private final UserRepository userRepository; // Inject UserRepository

    @Autowired
    public DeckController(DeckRepository deckRepository, CardRepository cardRepository, UserRepository userRepository) {
        this.deckRepository = deckRepository;
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
    }

    // --- Helper to get User from Authentication ---
    private User getAuthenticatedUser(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        String username;
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else if (principal instanceof String) {
            username = (String) principal;
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Could not determine username from principal");
        }

        return userRepository.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authenticated user not found in database"));
    }

    // --- GET Endpoints ---

    @GetMapping
    public ResponseEntity<List<DeckDTO>> getAllDecks(Authentication authentication) {
        User user = getAuthenticatedUser(authentication);
        List<Deck> decks = deckRepository.findByUserId(user.getId());
        List<DeckDTO> deckDTOs = decks.stream().map(this::convertToDto).collect(Collectors.toList());
        return ResponseEntity.ok(deckDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeckDTO> getDeckById(@PathVariable Long id, Authentication authentication) {
        User user = getAuthenticatedUser(authentication);
        Deck deck = deckRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Deck not found with id: " + id));

        // Verify deck belongs to the user
        if (!deck.getUser().getId().equals(user.getId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You do not have permission to access this deck.");
        }

        return ResponseEntity.ok(convertToDto(deck));
    }

    // --- POST Endpoint ---

    @PostMapping
    @Transactional
    public ResponseEntity<DeckDTO> saveDeck(@Valid @RequestBody DeckDTO deckDTO, Authentication authentication) {
        User user = getAuthenticatedUser(authentication);
        Deck deck = convertToEntity(deckDTO, user);
        Deck savedDeck = deckRepository.save(deck);
        return new ResponseEntity<>(convertToDto(savedDeck), HttpStatus.CREATED);
    }

    // --- PUT Endpoint ---

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DeckDTO> updateDeck(@PathVariable Long id, @Valid @RequestBody DeckDTO deckDTO, Authentication authentication) {
        User user = getAuthenticatedUser(authentication);
        Deck existingDeck = deckRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Deck not found with id: " + id));

        // Verify deck belongs to the user before updating
        if (!existingDeck.getUser().getId().equals(user.getId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You do not have permission to update this deck.");
        }

        updateEntityFromDto(existingDeck, deckDTO, user);
        Deck updatedDeck = deckRepository.save(existingDeck);
        return ResponseEntity.ok(convertToDto(updatedDeck));
    }

    // --- DELETE Endpoint ---

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteDeck(@PathVariable Long id, Authentication authentication) {
        User user = getAuthenticatedUser(authentication);
        Deck deck = deckRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Deck not found with id: " + id));

        // Verify deck belongs to the user before deleting
        if (!deck.getUser().getId().equals(user.getId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You do not have permission to delete this deck.");
        }

        deckRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // --- Helper Methods (DTO Conversion) ---

    private DeckDTO convertToDto(Deck deck) {
        DeckDTO dto = new DeckDTO();
        dto.setId(deck.getId());
        dto.setName(deck.getName());
        if (deck.getLeader() != null) {
             dto.setLeaderCardNumber(deck.getLeader().getCardNumber());
             // Fix image path if needed
             String imagePath = fixImagePath(deck.getLeader().getImagePath());
             dto.setLeaderImagePath(imagePath);
        }

        List<DeckDTO.DeckCardEntry> cardEntries = deck.getDeckCards().stream()
                .map(deckCard -> {
                    DeckDTO.DeckCardEntry entry = new DeckDTO.DeckCardEntry();
                    entry.setCardNumber(deckCard.getCard().getCardNumber());
                    entry.setQuantity(deckCard.getQuantity());
                    return entry;
                })
                .collect(Collectors.toList());
        dto.setCards(cardEntries);

        // Optional: Add createdAt, updatedAt if needed in DTO
        return dto;
    }

    // Converts DTO to a new Deck entity (for POST)
    private Deck convertToEntity(DeckDTO dto, User user) {
        Deck deck = new Deck();
        updateEntityFromDto(deck, dto, user);
        return deck;
    }

    // Updates an existing Deck entity from a DTO (for PUT & POST)
    private void updateEntityFromDto(Deck deck, DeckDTO dto, User user) {
        deck.setUser(user);
        deck.setName(dto.getName());

        // Find Leader
        Card leader = cardRepository.findByCardNumberIgnoreCase(dto.getLeaderCardNumber())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Leader card not found: " + dto.getLeaderCardNumber()));
        // Basic validation: Ensure it's actually a leader card
        if (!"LEADER".equalsIgnoreCase(leader.getCardType())) {
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Card specified as leader is not a Leader type: " + dto.getLeaderCardNumber());
        }
        deck.setLeader(leader);

        // Clear existing cards and add new ones
        deck.getDeckCards().clear(); // Clear existing relationships before adding new ones
        if (dto.getCards() != null) {
            dto.getCards().forEach(entry -> {
                Card card = cardRepository.findByCardNumberIgnoreCase(entry.getCardNumber())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                                "Card not found in deck list: " + entry.getCardNumber()));
                // Add validation here if needed (e.g., card type, quantity limits)
                 if ("LEADER".equalsIgnoreCase(card.getCardType())) {
                     throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                                "Cannot add Leader card to main deck: " + entry.getCardNumber());
                 }
                deck.addCard(card, entry.getQuantity()); // Use helper method
            });
        }
        // TODO: Add more validation (deck size, card limits, color compatibility) if desired on backend
    }
    
    /**
     * Fixes image paths for ST06-ST20 cards to use .png extension instead of .jpg
     * @param imagePath The image path to fix
     * @return The fixed image path
     */
    private String fixImagePath(String imagePath) {
        if (imagePath != null && imagePath.endsWith(".jpg")) {
            // Pattern to match ST06-ST20 card image paths
            Pattern pattern = Pattern.compile("/ST(\\d+)/ST\\d+-\\d+\\.jpg$");
            Matcher matcher = pattern.matcher(imagePath);
            
            if (matcher.find()) {
                int stNumber = Integer.parseInt(matcher.group(1));
                if (stNumber >= 6 && stNumber <= 20) {
                    String fixedPath = imagePath.replace(".jpg", ".png");
                    System.out.println("Fixing image path in deck: " + imagePath + " -> " + fixedPath);
                    return fixedPath;
                }
            }
        }
        return imagePath;
    }
} 