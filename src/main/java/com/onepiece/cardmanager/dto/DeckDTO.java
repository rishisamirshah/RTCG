package com.onepiece.cardmanager.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Data
public class DeckDTO {

    private Long id; // Include ID for responses

    @NotBlank(message = "Deck name cannot be blank")
    @Size(max = 100, message = "Deck name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Leader card number is required")
    private String leaderCardNumber; // e.g., "ST01-001"

    @NotEmpty(message = "Deck must contain cards")
    private List<DeckCardEntry> cards;

    // Inner class for card entries in the DTO
    @Data
    public static class DeckCardEntry {
        @NotBlank(message = "Card number is required for each entry")
        private String cardNumber; // e.g., "OP01-025"

        @NotNull(message = "Quantity is required")
        private Integer quantity;
    }

    // Optional: Add fields like createdAt, updatedAt for responses
    private String leaderImagePath; // For displaying leader in lists

} 