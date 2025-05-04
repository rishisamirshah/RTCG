package com.onepiece.cardmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "card")
@SequenceGenerator(name = "card_seq", sequenceName = "card_sequence", allocationSize = 1)
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(columnDefinition = "TEXT")
    private String name;                // e.g. "Roronoa Zoro"
    
    @Column(columnDefinition = "TEXT")
    private String cardNumber;          // e.g. "OP01-001"
    
    private Integer life;               // e.g. 5 (null for character cards)
    
    @Column(columnDefinition = "TEXT")
    private String cardType;            // e.g. "LEADER" or "CHARACTER"
    
    @Column(nullable = true, columnDefinition = "TEXT")
    private String color;               // e.g. "RED", "BLUE", "GREEN", "PURPLE"
    
    @Column(nullable = true)
    private Integer cost;
    
    @Column(columnDefinition = "TEXT")
    private String attribute;           // e.g. "DON!!×1"
    
    @Column(columnDefinition = "TEXT")
    private String timing;              // e.g. "Your Turn"
    
    @Column(columnDefinition = "TEXT")
    private String effect;              // e.g. "All your Characters gain +1000 power."
    
    @Column(columnDefinition = "TEXT")
    private String affiliations;        // e.g. "Supernovas / Straw Hat Crew"
    
    private Integer power;              // e.g. 5000
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String imagePath;           // Path to card image file
    
    @Column(name = "card_set", columnDefinition = "TEXT", nullable = false)
    private String set;                 // e.g. "OP01", "ST01", etc.
    
    @Column(nullable = true)
    private Integer counter;            // Counter field for the card
    
    @Column(columnDefinition = "TEXT", nullable = true)
    private String trigger;             // Trigger effect for event cards
    
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
        
        // Set the set based on the card number if not already set
        if (set == null && cardNumber != null) {
            set = cardNumber.substring(0, 4); // Extract OP01, ST01, etc.
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
        if (cardNumber != null) {
            this.set = cardNumber.substring(0, 4); // Set the set when card number is set
        }
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
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public Integer getCost() {
        return cost;
    }
    
    public void setCost(Integer cost) {
        this.cost = cost;
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
    
    public String getSet() {
        return set;
    }
    
    public void setSet(String set) {
        this.set = set;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }
} 