package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.config.BaseInitializer;
import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(25) // Order after ST14
public class ST15Initializer extends BaseInitializer {

    private final CardRepository cardRepository;

    @Autowired
    public ST15Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    protected void initialize(String... args) throws Exception {
        String setCode = "ST15";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // Character Cards
        Card atmos = new Card();
        atmos.setCardNumber("ST15-001");
        atmos.setName("Atmos");
        atmos.setCardType("CHARACTER");
        atmos.setColor("RED");
        atmos.setPower(5000);
        atmos.setCost(4);
        atmos.setAffiliations("Whitebeard Pirates");
        atmos.setAttribute(null);
        atmos.setTiming("When Attacking");
        atmos.setEffect("If your Leader is [Edward Newgate], you cannot add Life cards to your hand using your own effects during this turn.");
        atmos.setImagePath("/images/cards/ST15/ST15-001.png");
        atmos.setCounter(1000);
        cardRepository.save(atmos);
        
        Card edwardNewgate = new Card();
        edwardNewgate.setCardNumber("ST15-002");
        edwardNewgate.setName("Edward Newgate");
        edwardNewgate.setCardType("CHARACTER");
        edwardNewgate.setColor("RED");
        edwardNewgate.setPower(8000);
        edwardNewgate.setCost(7);
        edwardNewgate.setAffiliations("The Four Emperors / Whitebeard Pirates");
        edwardNewgate.setAttribute("DON!!×1");
        edwardNewgate.setTiming("On Play / Activate: Main");
        edwardNewgate.setEffect("On Play: Give your leader or one of your characters up to one rested Don!!. Activate: Main: You may rest this character: KO up to one of your opponent's characters with 5000 or less power.");
        edwardNewgate.setImagePath("/images/cards/ST15/ST15-002.png");
        edwardNewgate.setCounter(null);
        cardRepository.save(edwardNewgate);
        
        Card kingdew = new Card();
        kingdew.setCardNumber("ST15-003");
        kingdew.setName("Kingdew");
        kingdew.setCardType("CHARACTER");
        kingdew.setColor("RED");
        kingdew.setPower(4000);
        kingdew.setCost(3);
        kingdew.setAffiliations("Whitebeard Pirates");
        kingdew.setAttribute(null);
        kingdew.setTiming("Opponent's Turn");
        kingdew.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) When this Character is K.O.'d by your opponent's effect, up to 1 of your Leader gains +2000 power during this turn.");
        kingdew.setImagePath("/images/cards/ST15/ST15-003.png");
        kingdew.setCounter(1000);
        cardRepository.save(kingdew);
        
        Card thatch = new Card();
        thatch.setCardNumber("ST15-004");
        thatch.setName("Thatch");
        thatch.setCardType("CHARACTER");
        thatch.setColor("BLUE");
        thatch.setPower(2000);
        thatch.setCost(1);
        thatch.setAffiliations("Whitebeard Pirates");
        thatch.setAttribute(null);
        thatch.setTiming("On Play");
        thatch.setEffect("If your leader has {Whitebeard Pirates} included in its types, give up to one of your opponent's characters -2000 power for this turn. Then, put the top card of your life into your hand.");
        thatch.setImagePath("/images/cards/ST15/ST15-004.png");
        thatch.setCounter(2000);
        cardRepository.save(thatch);
        
        Card portgasDAce = new Card();
        portgasDAce.setCardNumber("ST15-005");
        portgasDAce.setName("Portgas D. Ace");
        portgasDAce.setCardType("CHARACTER");
        portgasDAce.setColor("PURPLE");
        portgasDAce.setPower(6000);
        portgasDAce.setCost(5);
        portgasDAce.setAffiliations("Whitebeard Pirates");
        portgasDAce.setAttribute(null);
        portgasDAce.setEffect("If your leader has [Whitebeard Pirates] included in its types, this character gains Rush (This card can attack on the turn in which it is played.) Once Per Turn If this character would be removed from play by one of your opponent's effects, instead you may give this character -2000 power for this turn.");
        portgasDAce.setImagePath("/images/cards/ST15/ST15-005.png");
        portgasDAce.setCounter(1000);
        cardRepository.save(portgasDAce);

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 