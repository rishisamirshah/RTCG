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
        logger.info("Looking for cards in directory: {}", resourceDirectory.toAbsolutePath());
        
        if (!Files.exists(resourceDirectory)) {
            String error = "Directory not found: " + resourceDirectory.toAbsolutePath();
            logger.error(error);
            results.add(error);
            return results;
        }
        
        try (Stream<Path> paths = Files.walk(resourceDirectory)) {
            paths.filter(Files::isRegularFile)
                 .filter(path -> path.toString().toLowerCase().endsWith(".png"))
                 .filter(path -> !path.toString().toLowerCase().contains("_small"))
                 .forEach(path -> {
                     logger.info("Processing file: {}", path.getFileName());
                     processCardImage(path, results);
                 });
        } catch (IOException e) {
            String error = "Error walking through directory: " + e.getMessage();
            logger.error(error);
            results.add(error);
        }
        
        return results;
    }
    
    private void processCardImage(Path imagePath, List<String> results) {
        String filename = imagePath.getFileName().toString();
        Matcher matcher = CARD_NUMBER_PATTERN.matcher(filename);
        
        if (matcher.find()) {
            String cardNumber = matcher.group(1);
            logger.info("Found card number: {}", cardNumber);
            
            // Skip if card already exists
            if (cardRepository.findByCardNumber(cardNumber).isPresent()) {
                logger.info("Card {} already exists, skipping", cardNumber);
                results.add("Skipped " + cardNumber + " - already exists");
                return;
            }
            
            // Create new card with basic information
            Card card = new Card();
            card.setCardNumber(cardNumber);
            card.setName(generateNameFromCardNumber(cardNumber));
            
            // Set the image path relative to the static directory
            String relativePath = "/images/cards/OP01/" + filename;
            card.setImagePath(relativePath);
            logger.info("Setting image path for card {}: {}", cardNumber, relativePath);
            
            // Set default values based on card number
            setDefaultCardValues(card);
            
            try {
                cardRepository.save(card);
                logger.info("Successfully saved card: {}", cardNumber);
                results.add("Successfully imported " + cardNumber);
            } catch (Exception e) {
                String error = "Error importing " + cardNumber + ": " + e.getMessage();
                logger.error(error);
                results.add(error);
            }
        } else {
            logger.warn("Invalid filename format: {}", filename);
            results.add("Skipped " + filename + " - invalid filename format");
        }
    }
    
    private String generateNameFromCardNumber(String cardNumber) {
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
        card.setColor("RED"); // Default color
        card.setCost(3); // Default cost
    }
} 