package com.onepiece.cardmanager.model.deck;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.model.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "decks")
@Data // Lombok for getters/setters/etc.
@NoArgsConstructor
@EqualsAndHashCode(exclude = "deckCards") // Exclude collection from equals/hashCode
@ToString(exclude = "deckCards")      // Exclude collection from toString
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // Relationship to the Leader Card
    @ManyToOne(fetch = FetchType.EAGER) // Eager fetch leader info
    @JoinColumn(name = "leader_card_id", nullable = false)
    private Card leader;

    // Relationship to the Cards in the deck (via DeckCard entity)
    @OneToMany(mappedBy = "deck", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<DeckCard> deckCards = new HashSet<>();

    // Relationship to the User who owns the deck
    @ManyToOne(fetch = FetchType.LAZY) // Lazy fetch user unless needed
    @JoinColumn(name = "user_id", nullable = false) // Assuming decks must have an owner
    private User user;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Helper method to add cards (ensures bidirectional link)
    public void addCard(Card card, int quantity) {
        DeckCard deckCard = new DeckCard(this, card, quantity);
        deckCards.add(deckCard);
    }

    // Helper method (optional) to remove cards
    public void removeCard(Card card) {
        deckCards.removeIf(deckCard -> deckCard.getDeck().equals(this) &&
                                        deckCard.getCard().equals(card));
    }

} 