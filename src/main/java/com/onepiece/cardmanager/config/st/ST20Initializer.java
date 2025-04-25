package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(30) // Order after ST19
public class ST20Initializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public ST20Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        String setCode = "ST20";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // --- Add Card definitions here ---
        // ST20-001 Katakuri
        Card card1 = new Card();
        card1.setCardNumber(setCode + "-001");
        card1.setName("Katakuri");
        card1.setCardType("Character");
        card1.setColor("Yellow");
        card1.setCost(5);
        card1.setPower(6000);
        card1.setCounter(1000);
        card1.setAttribute("Strike");
        card1.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the target of the attack.)\nActivate: Main Once Per Turn You may turn the top card of your life cards face up: Give your leader or up to 1 of your characters up to 1 rested Don!!");
        card1.setAffiliations("Big Mom Pirates");
        card1.setImagePath("/images/cards/" + setCode + "/" + setCode + "-001.png");
        card1.setSet(setCode);
        Card savedCard1 = cardRepository.save(card1);
        System.out.println("Saved card " + savedCard1.getCardNumber());
        
        // ST20-002 Charlotte Cracker
        Card card2 = new Card();
        card2.setCardNumber(setCode + "-002");
        card2.setName("Charlotte Cracker");
        card2.setCardType("Character");
        card2.setColor("Yellow");
        card2.setCost(4);
        card2.setPower(5000);
        card2.setCounter(1000);
        card2.setAttribute("Slash");
        card2.setEffect("Once Per Turn When this character would be KO'd by an effect, you may instead trash the top card of your life.\nTrigger You may trash 1 card from your hand: Play this card.");
        card2.setAffiliations("Big Mom Pirates");
        card2.setImagePath("/images/cards/" + setCode + "/" + setCode + "-002.png");
        card2.setSet(setCode);
        Card savedCard2 = cardRepository.save(card2);
        System.out.println("Saved card " + savedCard2.getCardNumber());
        
        // ST20-003 Charlotte Brûlée
        Card card3 = new Card();
        card3.setCardNumber(setCode + "-003");
        card3.setName("Charlotte Brûlée");
        card3.setCardType("Character");
        card3.setColor("Yellow");
        card3.setCost(3);
        card3.setPower(3000);
        card3.setCounter(2000);
        card3.setAttribute("Special");
        card3.setEffect("Trigger Look at the top card of your or your opponent's life and put it back on the top or bottom of the life pile. Then, add this card to your hand.");
        card3.setAffiliations("Big Mom Pirates");
        card3.setImagePath("/images/cards/" + setCode + "/" + setCode + "-003.png");
        card3.setSet(setCode);
        Card savedCard3 = cardRepository.save(card3);
        System.out.println("Saved card " + savedCard3.getCardNumber());
        
        // ST20-004 Charlotte Pudding
        Card card4 = new Card();
        card4.setCardNumber(setCode + "-004");
        card4.setName("Charlotte Pudding");
        card4.setCardType("Character");
        card4.setColor("Yellow");
        card4.setCost(3);
        card4.setPower(2000);
        card4.setCounter(1000);
        card4.setAttribute("Wisdom");
        card4.setEffect("On Play You may add the top card of your life to your hand: Set up to one of your cost 3 or less (Big Mom Pirates) type characters as active.\nTrigger Rest up to one of your opponents cost 3 or lower characters.");
        card4.setAffiliations("Big Mom Pirates");
        card4.setImagePath("/images/cards/" + setCode + "/" + setCode + "-004.png");
        card4.setSet(setCode);
        Card savedCard4 = cardRepository.save(card4);
        System.out.println("Saved card " + savedCard4.getCardNumber());
        
        // ST20-005 Charlotte Linlin
        Card card5 = new Card();
        card5.setCardNumber(setCode + "-005");
        card5.setName("Charlotte Linlin");
        card5.setCardType("Character");
        card5.setColor("Yellow");
        card5.setCost(6);
        card5.setPower(7000);
        card5.setCounter(0);
        card5.setAttribute("Special");
        card5.setEffect("On Play You may trash 1 card from your hand: Your opponent chooses one: Your opponent discards 2 cards from hand. Trash 1 card from the top of your opponent's Life cards.");
        card5.setAffiliations("The Four Emperors / Big Mom Pirates");
        card5.setImagePath("/images/cards/" + setCode + "/" + setCode + "-005.png");
        card5.setSet(setCode);
        Card savedCard5 = cardRepository.save(card5);
        System.out.println("Saved card " + savedCard5.getCardNumber());

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 