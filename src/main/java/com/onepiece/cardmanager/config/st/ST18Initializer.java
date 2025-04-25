package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(28) // Order after ST17
public class ST18Initializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public ST18Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        String setCode = "ST18";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // Character Cards
        Card usohachi = new Card();
        usohachi.setCardNumber("ST18-001");
        usohachi.setName("Usohachi");
        usohachi.setCardType("CHARACTER");
        usohachi.setColor("PURPLE");
        usohachi.setPower(3000);
        usohachi.setCost(3);
        usohachi.setAffiliations("Straw Hat Crew");
        usohachi.setAttribute("DON!!×1");
        usohachi.setTiming("On Play");
        usohachi.setEffect("If you have 8 or more Don!!, rest up to one of your opponents characters with a cost of 5 or less.");
        usohachi.setImagePath("/images/cards/ST18/ST18-001.png");
        usohachi.setCounter(2000);
        cardRepository.save(usohachi);
        
        Card onami = new Card();
        onami.setCardNumber("ST18-002");
        onami.setName("Onami");
        onami.setCardType("CHARACTER");
        onami.setColor("PURPLE");
        onami.setPower(2000);
        onami.setCost(4);
        onami.setAffiliations("Straw Hat Crew");
        onami.setAttribute("DON!!×1");
        onami.setTiming("On Play");
        onami.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) If you have 8 or more Don!! on your field, trash 1 card from your hand then draw 2 cards.");
        onami.setImagePath("/images/cards/ST18/ST18-002.png");
        onami.setCounter(1000);
        cardRepository.save(onami);
        
        Card sangoro = new Card();
        sangoro.setCardNumber("ST18-003");
        sangoro.setName("Sangoro");
        sangoro.setCardType("CHARACTER");
        sangoro.setColor("PURPLE");
        sangoro.setPower(6000);
        sangoro.setCost(5);
        sangoro.setAffiliations("Straw Hat Crew");
        sangoro.setAttribute(null);
        sangoro.setTiming("When Attacking");
        sangoro.setEffect("Once Per Turn If you have 8 or more Don!!, draw one card.");
        sangoro.setImagePath("/images/cards/ST18/ST18-003.png");
        sangoro.setCounter(1000);
        cardRepository.save(sangoro);
        
        Card zorojuro = new Card();
        zorojuro.setCardNumber("ST18-004");
        zorojuro.setName("Zorojuro");
        zorojuro.setCardType("CHARACTER");
        zorojuro.setColor("PURPLE");
        zorojuro.setPower(6000);
        zorojuro.setCost(4);
        zorojuro.setAffiliations("Straw Hat Crew");
        zorojuro.setAttribute(null);
        zorojuro.setTiming("On Play");
        zorojuro.setEffect("Look at the top 5 cards of your deck, reveal up to one purple {Straw Hat Crew} type card and put it into your hand. Then, place the rest of the cards on the bottom of your deck in any order.");
        zorojuro.setImagePath("/images/cards/ST18/ST18-004.png");
        zorojuro.setCounter(null);
        cardRepository.save(zorojuro);
        
        Card monkeyDLuffy = new Card();
        monkeyDLuffy.setCardNumber("ST18-005");
        monkeyDLuffy.setName("Monkey D. Luffy");
        monkeyDLuffy.setCardType("CHARACTER");
        monkeyDLuffy.setColor("PURPLE");
        monkeyDLuffy.setPower(8000);
        monkeyDLuffy.setCost(7);
        monkeyDLuffy.setAffiliations("Straw Hat Crew");
        monkeyDLuffy.setAttribute("DON!!×1");
        monkeyDLuffy.setTiming("On Play");
        monkeyDLuffy.setEffect("DON!!-1 (You may rest the specified number of DON!! cards in your Cost Area) Play up to 1 Purple {Straw Hat Crew} type Character card with a cost of 5 or less from your hand.");
        monkeyDLuffy.setImagePath("/images/cards/ST18/ST18-005.png");
        monkeyDLuffy.setCounter(null);
        cardRepository.save(monkeyDLuffy);

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 