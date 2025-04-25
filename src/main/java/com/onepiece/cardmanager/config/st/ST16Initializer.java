package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(26) // Order after ST15
public class ST16Initializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public ST16Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        String setCode = "ST16";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // Leader Card
        Card uta = new Card();
        uta.setCardNumber("ST16-001");
        uta.setName("Uta");
        uta.setCardType("CHARACTER");
        uta.setColor("GREEN");
        uta.setPower(6000);
        uta.setCost(4);
        uta.setAffiliations("FILM");
        uta.setAttribute("DON!!×1");
        uta.setTiming("Activate: Main");
        uta.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) Once Per Turn You may trash 1 {Film} type card from your hand: Give your leader or up to one of your characters up to 1 rested Don!!");
        uta.setImagePath("/images/cards/ST16/ST16-001.png");
        uta.setCounter(null);
        cardRepository.save(uta);
        
        // Character Cards
        Card gordon = new Card();
        gordon.setCardNumber("ST16-002");
        gordon.setName("Gordon");
        gordon.setCardType("CHARACTER");
        gordon.setColor("GREEN");
        gordon.setPower(0);
        gordon.setCost(2);
        gordon.setAffiliations("FILM");
        gordon.setAttribute(null);
        gordon.setTiming("When opponent attack");
        gordon.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) You may trash any number of {Music} type cards from your hand: Your Leader or 1 of your Characters gains +1000 power during this battle for every card trashed.");
        gordon.setImagePath("/images/cards/ST16/ST16-002.png");
        gordon.setCounter(1000);
        cardRepository.save(gordon);
        
        Card charlotteKatakuri = new Card();
        charlotteKatakuri.setCardNumber("ST16-003");
        charlotteKatakuri.setName("Charlotte Katakuri");
        charlotteKatakuri.setCardType("CHARACTER");
        charlotteKatakuri.setColor("GREEN");
        charlotteKatakuri.setPower(4000);
        charlotteKatakuri.setCost(3);
        charlotteKatakuri.setAffiliations("FILM / Big Mom Pirates");
        charlotteKatakuri.setAttribute(null);
        charlotteKatakuri.setEffect("If your Leader has the {FILM} type and you have 6 or more rested cards, this Character gains +2000 power.");
        charlotteKatakuri.setImagePath("/images/cards/ST16/ST16-003.png");
        charlotteKatakuri.setCounter(1000);
        cardRepository.save(charlotteKatakuri);
        
        Card shanks = new Card();
        shanks.setCardNumber("ST16-004");
        shanks.setName("Shanks");
        shanks.setCardType("CHARACTER");
        shanks.setColor("GREEN");
        shanks.setPower(11000);
        shanks.setCost(9);
        shanks.setAffiliations("FILM / Four Emperors / Red Hair Pirates");
        shanks.setAttribute(null);
        shanks.setTiming("On Play");
        shanks.setEffect("KO up to one of your opponents rested characters.");
        shanks.setImagePath("/images/cards/ST16/ST16-004.png");
        shanks.setCounter(null);
        cardRepository.save(shanks);
        
        Card monkeyDLuffy = new Card();
        monkeyDLuffy.setCardNumber("ST16-005");
        monkeyDLuffy.setName("Monkey D. Luffy");
        monkeyDLuffy.setCardType("CHARACTER");
        monkeyDLuffy.setColor("GREEN");
        monkeyDLuffy.setPower(3000);
        monkeyDLuffy.setCost(2);
        monkeyDLuffy.setAffiliations("FILM / Supernovas / Straw Hat Crew");
        monkeyDLuffy.setAttribute(null);
        monkeyDLuffy.setEffect("If your [Uta] is rested, this character has +1000 power.");
        monkeyDLuffy.setImagePath("/images/cards/ST16/ST16-005.png");
        monkeyDLuffy.setCounter(2000);
        cardRepository.save(monkeyDLuffy);

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 