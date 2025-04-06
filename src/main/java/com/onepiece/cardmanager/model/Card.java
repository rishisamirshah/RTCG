package com.onepiece.cardmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;                // e.g. "Roronoa Zoro"
    private String cardNumber;          // e.g. "OP01-001"
    private Integer life;               // e.g. 5 (null for character cards)
    private String cardType;            // e.g. "LEADER" or "CHARACTER"
    private String attribute;           // e.g. "DON!!×1"
    private String timing;              // e.g. "Your Turn"
    private String effect;              // e.g. "All your Characters gain +1000 power."
    private String affiliations;        // e.g. "Supernovas / Straw Hat Crew"
    private Integer power;              // e.g. 5000
    
    @Column(nullable = false)
    private String imagePath;           // Path to card image file
    
    // Default constructor
    public Card() {}
    
    @PrePersist
    @PreUpdate
    private void validateAndSetCardType() {
        // If life is null, it's a character card
        if (life == null && (cardType == null || !cardType.equals("CHARACTER"))) {
            this.cardType = "CHARACTER";
        }
        // If life is not null and card type is CHARACTER, throw exception
        if (life != null && "CHARACTER".equals(cardType)) {
            throw new IllegalStateException("Character cards cannot have life points");
        }
    }
    
    // Helper method to check if card is a character card
    public boolean isCharacterCard() {
        return life == null || "CHARACTER".equals(cardType);
    }
    
    // Helper method to check if card is a leader card
    public boolean isLeaderCard() {
        return life != null && "LEADER".equals(cardType);
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }
    
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    public Integer getLife() {
        return life;
    }
    
    public void setLife(Integer life) {
        this.life = life;
    }
    
    public String getCardType() {
        return cardType;
    }
    
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    
    public String getAttribute() {
        return attribute;
    }
    
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
    
    public String getTiming() {
        return timing;
    }
    
    public void setTiming(String timing) {
        this.timing = timing;
    }
    
    public String getEffect() {
        return effect;
    }
    
    public void setEffect(String effect) {
        this.effect = effect;
    }
    
    public String getAffiliations() {
        return affiliations;
    }
    
    public void setAffiliations(String affiliations) {
        this.affiliations = affiliations;
    }
    
    public Integer getPower() {
        return power;
    }
    
    public void setPower(Integer power) {
        this.power = power;
    }
    
    public String getImagePath() {
        return imagePath;
    }
    
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
} 