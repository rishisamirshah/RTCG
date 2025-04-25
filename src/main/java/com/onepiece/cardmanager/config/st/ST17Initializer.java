package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(27) // Order after ST16
public class ST17Initializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public ST17Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        String setCode = "ST17";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // Character Cards
        Card crocodile = new Card();
        crocodile.setCardNumber("ST17-001");
        crocodile.setName("Crocodile");
        crocodile.setCardType("CHARACTER");
        crocodile.setColor("BLUE");
        crocodile.setPower(5000);
        crocodile.setCost(4);
        crocodile.setAffiliations("The Seven Warlords of the Sea/Baroque Works");
        crocodile.setAttribute(null);
        crocodile.setTiming("On Play");
        crocodile.setEffect("Reveal 1 card from the top of your deck. If that card has the {The Seven Warlords of the Sea} type, draw 2 cards and place 1 card from your hand on the top of your deck.");
        crocodile.setImagePath("/images/cards/ST17/ST17-001.png");
        crocodile.setCounter(1000);
        cardRepository.save(crocodile);
        
        Card trafalgarLaw = new Card();
        trafalgarLaw.setCardNumber("ST17-002");
        trafalgarLaw.setName("Trafalgar Law");
        trafalgarLaw.setCardType("CHARACTER");
        trafalgarLaw.setColor("BLUE");
        trafalgarLaw.setPower(5000);
        trafalgarLaw.setCost(4);
        trafalgarLaw.setAffiliations("Seven Warlords of the Sea / Heart Pirates");
        trafalgarLaw.setAttribute(null);
        trafalgarLaw.setTiming("On Play");
        trafalgarLaw.setEffect("You may return one of your characters to its owner's hand: If your leader has the {Seven Warlords of the Sea} type, return up to one cost 4 or lower character to its owner's hand.");
        trafalgarLaw.setImagePath("/images/cards/ST17/ST17-002.png");
        trafalgarLaw.setCounter(1000);
        cardRepository.save(trafalgarLaw);
        
        Card buggy = new Card();
        buggy.setCardNumber("ST17-003");
        buggy.setName("Buggy");
        buggy.setCardType("CHARACTER");
        buggy.setColor("BLUE");
        buggy.setPower(2000);
        buggy.setCost(1);
        buggy.setAffiliations("The Seven Warlords of the Sea/Buggy's delivery");
        buggy.setAttribute(null);
        buggy.setTiming("On Play");
        buggy.setEffect("Look at the top 3 cards of your deck, then place them in any order on the top of your deck.");
        buggy.setImagePath("/images/cards/ST17/ST17-003.png");
        buggy.setCounter(2000);
        cardRepository.save(buggy);
        
        Card boaHancock = new Card();
        boaHancock.setCardNumber("ST17-004");
        boaHancock.setName("Boa Hancock");
        boaHancock.setCardType("CHARACTER");
        boaHancock.setColor("BLUE");
        boaHancock.setPower(6000);
        boaHancock.setCost(4);
        boaHancock.setAffiliations("Seven Warlords of the Sea/Kuja Pirates");
        boaHancock.setAttribute("DON!!×1");
        boaHancock.setTiming("On Play");
        boaHancock.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) Look at the top 3 cards of your deck, then place them in any order on the top or bottom of your deck. Then, give up to one of your {Seven Warlords of the Sea} type leader or characters up to one rested Don!!.");
        boaHancock.setImagePath("/images/cards/ST17/ST17-004.png");
        boaHancock.setCounter(null);
        cardRepository.save(boaHancock);
        
        Card marshallDTeach = new Card();
        marshallDTeach.setCardNumber("ST17-005");
        marshallDTeach.setName("Marshall D. Teach");
        marshallDTeach.setCardType("CHARACTER");
        marshallDTeach.setColor("BLUE");
        marshallDTeach.setPower(3000);
        marshallDTeach.setCost(2);
        marshallDTeach.setAffiliations("Seven Warlords of the Sea / Blackbeard Pirates");
        marshallDTeach.setAttribute(null);
        marshallDTeach.setTiming("Activate: Main");
        marshallDTeach.setEffect("Once Per Turn Place 1 card from your hand at the top of your deck: attach up to 2 rested DON!! to one of your leader or characters.");
        marshallDTeach.setImagePath("/images/cards/ST17/ST17-005.png");
        marshallDTeach.setCounter(1000);
        cardRepository.save(marshallDTeach);

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 