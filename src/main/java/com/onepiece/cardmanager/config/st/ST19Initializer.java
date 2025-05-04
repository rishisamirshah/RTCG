package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.config.BaseInitializer;
import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(29) // Order after ST18
public class ST19Initializer extends BaseInitializer {

    private final CardRepository cardRepository;

    @Autowired
    public ST19Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    protected void initialize(String... args) throws Exception {
        String setCode = "ST19";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // Character Cards
        Card smoker = new Card();
        smoker.setCardNumber("ST19-001");
        smoker.setName("Smoker");
        smoker.setCardType("CHARACTER");
        smoker.setColor("BLACK");
        smoker.setPower(8000);
        smoker.setCost(6);
        smoker.setAffiliations("Navy");
        smoker.setAttribute("DON!!×1");
        smoker.setTiming("On Play");
        smoker.setEffect("You may trash 1 black {Navy} type card from your hand: Up to two of your opponents cost 4 or less characters cannot attack during your opponents next turn.");
        smoker.setImagePath("/images/cards/ST19/ST19-001.png");
        smoker.setCounter(null);
        cardRepository.save(smoker);
        
        Card sengoku = new Card();
        sengoku.setCardNumber("ST19-002");
        sengoku.setName("Sengoku");
        sengoku.setCardType("CHARACTER");
        sengoku.setColor("GREEN");
        sengoku.setPower(1000);
        sengoku.setCost(1);
        sengoku.setAffiliations("Navy");
        sengoku.setAttribute(null);
        sengoku.setTiming("On Play");
        sengoku.setEffect("You may trash 2 black {Navy} type cards from your hand: If your leader has the {Navy} type, draw 3 cards.");
        sengoku.setImagePath("/images/cards/ST19/ST19-002.png");
        sengoku.setCounter(1000);
        cardRepository.save(sengoku);
        
        Card tashigi = new Card();
        tashigi.setCardNumber("ST19-003");
        tashigi.setName("Tashigi");
        tashigi.setCardType("CHARACTER");
        tashigi.setColor("BLUE");
        tashigi.setPower(6000);
        tashigi.setCost(5);
        tashigi.setAffiliations("Navy");
        tashigi.setAttribute(null);
        tashigi.setTiming("On Play / Activate: Main");
        tashigi.setEffect("On Play: If your leader is [Smoker], give up to one of your opponents characters -4 cost for this turn. Activate: Main: Once Per Turn If it is the turn this character was played, place up to one of your opponents cost 0 characters into its owner's trash.");
        tashigi.setImagePath("/images/cards/ST19/ST19-003.png");
        tashigi.setCounter(1000);
        cardRepository.save(tashigi);
        
        Card hina = new Card();
        hina.setCardNumber("ST19-004");
        hina.setName("Hina");
        hina.setCardType("CHARACTER");
        hina.setColor("BLACK");
        hina.setPower(6000);
        hina.setCost(4);
        hina.setAffiliations("Navy");
        hina.setAttribute("DON!!×1");
        hina.setTiming("Opponent's Turn / Activate: Main");
        hina.setEffect("Opponent's Turn: This character has +4 cost. Activate: Main: Once Per Turn You may place one card from your trash on the bottom of your deck: Give your leader or up to one of your characters up to 1 rested Don!!.");
        hina.setImagePath("/images/cards/ST19/ST19-004.png");
        hina.setCounter(null);
        cardRepository.save(hina);
        
        Card monkeyDGarp = new Card();
        monkeyDGarp.setCardNumber("ST19-005");
        monkeyDGarp.setName("Monkey D. Garp");
        monkeyDGarp.setCardType("CHARACTER");
        monkeyDGarp.setColor("YELLOW");
        monkeyDGarp.setPower(4000);
        monkeyDGarp.setCost(3);
        monkeyDGarp.setAffiliations("Navy");
        monkeyDGarp.setAttribute(null);
        monkeyDGarp.setTiming("Activate: Main");
        monkeyDGarp.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) Once Per Turn Place one card from your trash at the bottom of your deck: Give up to one of your opponents characters cost-1 for the turn.");
        monkeyDGarp.setImagePath("/images/cards/ST19/ST19-005.png");
        monkeyDGarp.setCounter(1000);
        cardRepository.save(monkeyDGarp);

        System.out.println("Finished initializing " + setCode + " cards.");
    }
}

 