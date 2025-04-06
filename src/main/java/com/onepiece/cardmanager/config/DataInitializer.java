package com.onepiece.cardmanager.config;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public DataInitializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) {
        // Check if the card already exists
        if (cardRepository.findByCardNumber("OP01-001").isEmpty()) {
            Card zoroCard = new Card();
            zoroCard.setName("Roronoa Zoro");
            zoroCard.setCardNumber("OP01-001");
            zoroCard.setLife(5);
            zoroCard.setCardType("LEADER");
            zoroCard.setAttribute("DON!!×1");
            zoroCard.setTiming("Your Turn");
            zoroCard.setEffect("All your Characters gain +1000 power.");
            zoroCard.setAffiliations("Supernovas / Straw Hat Crew");
            zoroCard.setPower(5000);
            zoroCard.setImagePath("/images/cards/OP01-001.png");
            
            cardRepository.save(zoroCard);
        }

        // Add Trafalgar Law card if it doesn't exist
        if (cardRepository.findByCardNumber("OP01-002").isEmpty()) {
            Card law = new Card();
            law.setCardNumber("OP01-002");
            law.setName("Trafalgar Law");
            law.setCardType("LEADER");
            law.setPower(5000);
            law.setLife(4);
            law.setAttribute("Red");
            law.setTiming("Activate: Main");
            law.setEffect("Once Per Turn (You may rest the specified number of DON!! cards in your Cost Area): If you have 5 Characters, return 1 of your Characters to the owner's hand, then play up to 1 Character with a cost of 5 or less of a different color as the returned Character from your hand.");
            law.setAffiliations("Supernovas / Heart Pirates");
            law.setImagePath("/images/cards/OP01/OP01-002.png");
            
            cardRepository.save(law);
        }

        // Add Monkey D. Luffy card
        if (cardRepository.findByCardNumber("OP01-003").isEmpty()) {
            Card luffy = new Card();
            luffy.setCardNumber("OP01-003");
            luffy.setName("Monkey D. Luffy");
            luffy.setCardType("LEADER");
            luffy.setPower(5000);
            luffy.setLife(4);
            luffy.setAttribute("Red");
            luffy.setTiming("Activate: Main");
            luffy.setEffect("Once Per Turn (You may rest the specified number of DON!! cards in your Cost Area): Set up to 1 of your (Supernovas) or (Straw Hat Crew) type Character cards with a cost of 5 or less as active. It gains +1000 power during this turn.");
            luffy.setAffiliations("Supernovas / Straw Hat Crew");
            luffy.setImagePath("/images/cards/OP01/OP01-003.png");
            cardRepository.save(luffy);
        }

        // Add Usopp card
        if (cardRepository.findByCardNumber("OP01-004").isEmpty()) {
            Card usopp = new Card();
            usopp.setCardNumber("OP01-004");
            usopp.setName("Usopp");
            usopp.setCardType("CHARACTER");
            usopp.setPower(3000);
            usopp.setAttribute("Red");
            usopp.setTiming("Your Turn");
            usopp.setEffect("DON!!×1 Your Turn Once Per Turn After your opponent activates an Event, Draw 1 card.");
            usopp.setAffiliations("Straw Hat Crew");
            usopp.setImagePath("/images/cards/OP01/OP01-004.png");
            cardRepository.save(usopp);
        }

        // Add Uta card
        if (cardRepository.findByCardNumber("OP01-005").isEmpty()) {
            Card uta = new Card();
            uta.setCardNumber("OP01-005");
            uta.setName("Uta");
            uta.setCardType("CHARACTER");
            uta.setPower(4000);
            uta.setAttribute("Red");
            uta.setTiming("On Play");
            uta.setEffect("Return up to 1 red Character card other than [Uta] with a cost of 3 or less from your trash to your hand.");
            uta.setAffiliations("FILM");
            uta.setImagePath("/images/cards/OP01/OP01-005.png");
            cardRepository.save(uta);
        }

        // Add Otama card
        if (cardRepository.findByCardNumber("OP01-006").isEmpty()) {
            Card otama = new Card();
            otama.setCardNumber("OP01-006");
            otama.setName("Otama");
            otama.setCardType("CHARACTER");
            otama.setPower(0);
            otama.setAttribute("Red");
            otama.setTiming("On Play");
            otama.setEffect("Give up to 1 of your opponent's Characters -2000 power during this turn.");
            otama.setAffiliations("Wano Country");
            otama.setImagePath("/images/cards/OP01/OP01-006.png");
            cardRepository.save(otama);
        }

        // Add Caribou card
        if (cardRepository.findByCardNumber("OP01-007").isEmpty()) {
            Card caribou = new Card();
            caribou.setCardNumber("OP01-007");
            caribou.setName("Caribou");
            caribou.setCardType("CHARACTER");
            caribou.setPower(4000);
            caribou.setAttribute("Red");
            caribou.setTiming("On K.O.");
            caribou.setEffect("K.O. up to 1 of your opponent's Characters with 4000 power or less.");
            caribou.setAffiliations("Supernovas / Caribou Pirates");
            caribou.setImagePath("/images/cards/OP01/OP01-007.png");
            cardRepository.save(caribou);
        }
    }
} 