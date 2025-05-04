package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.config.BaseInitializer;
import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(21) // Order after ST10
public class ST11Initializer extends BaseInitializer {

    private final CardRepository cardRepository;

    @Autowired
    public ST11Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    protected void initialize(String... args) throws Exception {
        String setCode = "ST11";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // --- Add Card definitions here ---
        
        // Uta (Leader) - ST11-001
        Card card1 = new Card();
        card1.setName("Uta");
        card1.setCardNumber("ST11-001");
        card1.setCardType("Leader");
        card1.setColor("Green");
        card1.setLife(5);
        card1.setPower(5000);
        card1.setAttribute("Special");
        card1.setTiming("When Attacking");
        card1.setEffect("DON!! ×1 Once Per Turn Reveal the top card of your deck. If it is a {FILM} type card, add it to your hand. Then return the remaining card to the bottom of your deck.");
        card1.setAffiliations("FILM");
        card1.setImagePath("/images/cards/ST11/ST11-001.png");
        card1.setSet(setCode);
        cardRepository.save(card1);
        
        // Uta (Character) - ST11-002
        Card card2 = new Card();
        card2.setName("Uta");
        card2.setCardNumber("ST11-002");
        card2.setCardType("Character");
        card2.setColor("Green");
        card2.setCost(3);
        card2.setPower(4000);
        card2.setCounter(1000);
        card2.setAttribute("Wisdom");
        card2.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\nEnd of Your Turn You may discard 1 event card from your hand: Set up to 1 of your {FILM} type characters as active.");
        card2.setAffiliations("FILM");
        card2.setImagePath("/images/cards/ST11/ST11-002.png");
        card2.setSet(setCode);
        cardRepository.save(card2);
        
        // Backlight - ST11-003
        Card card3 = new Card();
        card3.setName("Backlight");
        card3.setCardNumber("ST11-003");
        card3.setCardType("Event");
        card3.setColor("Green");
        card3.setCost(2);
        card3.setAttribute("Wisdom");
        card3.setTiming("Main");
        card3.setEffect("If your leader is Uta, choose 1 of the below:\n• Rest up to 1 of your opponent's cost 5 or lower characters\n• KO up to 1 of your opponent's cost 5 or lower rested characters");
        card3.setAffiliations("Song/FILM");
        card3.setImagePath("/images/cards/ST11/ST11-003.png");
        card3.setSet(setCode);
        cardRepository.save(card3);
        
        // New Genesis - ST11-004
        Card card4 = new Card();
        card4.setName("New Genesis");
        card4.setCardNumber("ST11-004");
        card4.setCardType("Event");
        card4.setColor("Green");
        card4.setCost(1);
        card4.setAttribute("Wisdom");
        card4.setTiming("Main");
        card4.setEffect("If your leader is Uta, look at the top 3 cards of your deck, reveal up to 1 <<FILM>> type card other than [New Genesis] and add it to your hand. Return the remaining cards to the bottom of your deck in any order. Then, set up to 1 rested DON!! as active.");
        card4.setAffiliations("Song/FILM");
        card4.setImagePath("/images/cards/ST11/ST11-004.png");
        card4.setSet(setCode);
        cardRepository.save(card4);
        
        // I'm Invincible - ST11-005
        Card card5 = new Card();
        card5.setName("I'm Invincible");
        card5.setCardNumber("ST11-005");
        card5.setCardType("Event");
        card5.setColor("Green");
        card5.setCost(3);
        card5.setAttribute("Wisdom");
        card5.setTiming("Main");
        card5.setEffect("Set up to 1 of your Leader [Uta] Active.");
        card5.setTrigger("Give up to 1 of your leaders or characters power +1000 for this turn");
        card5.setAffiliations("Song/FILM");
        card5.setImagePath("/images/cards/ST11/ST11-005.png");
        card5.setSet(setCode);
        cardRepository.save(card5);

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 