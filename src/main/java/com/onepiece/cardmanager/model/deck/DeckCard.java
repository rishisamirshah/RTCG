package com.onepiece.cardmanager.model.deck;

import com.onepiece.cardmanager.model.Card;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "deck_cards")
@Data
@NoArgsConstructor
public class DeckCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deck_id", nullable = false)
    private Deck deck;

    @ManyToOne(fetch = FetchType.EAGER) // Usually want card info when fetching DeckCard
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @Column(nullable = false)
    private int quantity;

    // Constructor for easier creation
    public DeckCard(Deck deck, Card card, int quantity) {
        this.deck = deck;
        this.card = card;
        this.quantity = quantity;
    }

    // hashCode and equals are important for Set operations
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeckCard deckCard = (DeckCard) o;

        if (!deck.equals(deckCard.deck)) return false;
        return card.equals(deckCard.card);
    }

    @Override
    public int hashCode() {
        int result = deck.hashCode();
        result = 31 * result + card.hashCode();
        return result;
    }
} 