package com.onepiece.cardmanager.util;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Component
public class CardBulkImporter {
    private static final Logger logger = LoggerFactory.getLogger(CardBulkImporter.class);
    private static final Pattern CARD_NUMBER_PATTERN = Pattern.compile("(OP\\d{2}-\\d{3})");
    
    private final CardRepository cardRepository;
    
    @Autowired
    public CardBulkImporter(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    
    public List<String> importCardsFromDirectory(String relativePath) {
        List<String> results = new ArrayList<>();
        Path resourceDirectory = Paths.get("src", "main", "resources", "static", relativePath);
        
        try (Stream<Path> paths = Files.walk(resourceDirectory)) {
            paths.filter(Files::isRegularFile)
                 .filter(path -> path.toString().toLowerCase().endsWith(".png"))
                 .filter(path -> !path.toString().toLowerCase().contains("_small"))
                 .forEach(path -> processCardImage(path, results));
        } catch (IOException e) {
            logger.error("Error walking through directory: {}", e.getMessage());
            results.add("Error: " + e.getMessage());
        }
        
        return results;
    }
    
    private void processCardImage(Path imagePath, List<String> results) {
        String filename = imagePath.getFileName().toString();
        Matcher matcher = CARD_NUMBER_PATTERN.matcher(filename);
        
        if (matcher.find()) {
            String cardNumber = matcher.group(1);
            
            // Skip if card already exists
            if (cardRepository.findByCardNumber(cardNumber).isPresent()) {
                results.add("Skipped " + cardNumber + " - already exists");
                return;
            }
            
            // Create new card with basic information
            Card card = new Card();
            card.setCardNumber(cardNumber);
            card.setName(generateNameFromCardNumber(cardNumber));
            
            // Set the image path relative to the static directory
            String relativePath = imagePath.toString()
                .substring(imagePath.toString().indexOf("static") + 7)
                .replace('\\', '/');
            card.setImagePath(relativePath);
            
            // Set default values based on card number
            setDefaultCardValues(card);
            
            try {
                cardRepository.save(card);
                results.add("Successfully imported " + cardNumber);
            } catch (Exception e) {
                results.add("Error importing " + cardNumber + ": " + e.getMessage());
                logger.error("Error saving card {}: {}", cardNumber, e.getMessage());
            }
        } else {
            results.add("Skipped " + filename + " - invalid filename format");
        }
    }
    
    private String generateNameFromCardNumber(String cardNumber) {
        // For OP01 cards, we'll set a generic name that can be updated later
        return "One Piece Card " + cardNumber;
    }
    
    private void setDefaultCardValues(Card card) {
        String cardNumber = card.getCardNumber();
        
        // Set card type based on number range
        if (cardNumber.startsWith("OP")) {
            if (cardNumber.endsWith("001")) {
                card.setCardType("LEADER");
                card.setLife(4);
            } else {
                card.setCardType("CHARACTER");
            }
        }
        
        // Set default values
        card.setPower(5000);
        card.setAttribute("None");
        card.setTiming("Main");
        card.setEffect("Effect description will be added later");
        card.setAffiliations("Unknown");
    }
} 