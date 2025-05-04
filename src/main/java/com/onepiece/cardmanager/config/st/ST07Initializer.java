package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.config.BaseInitializer;
import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(17) // Order after ST06
public class ST07Initializer extends BaseInitializer {

    private final CardRepository cardRepository;

    @Autowired
    public ST07Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    protected void initialize(String... args) throws Exception {
        String setCode = "ST07";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // --- Add Card definitions here ---
        
        // Charlotte Linlin (Leader) - ST07-001
        Card card1 = new Card();
        card1.setName("Charlotte Linlin");
        card1.setCardNumber("ST07-001");
        card1.setCardType("Leader");
        card1.setColor("Purple");
        card1.setCost(5);
        card1.setLife(5);
        card1.setPower(5000);
        card1.setAttribute("Special");
        card1.setTiming("When Attacking");
        card1.setEffect("You may add 1 card from the top or bottom of your Life area to your hand. If your Life is at 2 or less, you may place up to 1 card from your hand at the top of your Life area.");
        card1.setAffiliations("The Four Emperors/Big Mom Pirates");
        card1.setImagePath("/images/cards/ST07/ST07-001.png");
        card1.setSet(setCode);
        cardRepository.save(card1);
        
        // Charlotte Anana - ST07-002
        Card card2 = new Card();
        card2.setName("Charlotte Anana");
        card2.setCardNumber("ST07-002");
        card2.setCardType("Character");
        card2.setColor("Green");
        card2.setCost(1);
        card2.setPower(3000);
        card2.setCounter(1000);
        card2.setAttribute("Wisdom");
        card2.setAffiliations("Big Mom Pirates");
        card2.setImagePath("/images/cards/ST07/ST07-002.png");
        card2.setSet(setCode);
        cardRepository.save(card2);
        
        // Charlotte Katakuri - ST07-003
        Card card3 = new Card();
        card3.setName("Charlotte Katakuri");
        card3.setCardNumber("ST07-003");
        card3.setCardType("Character");
        card3.setColor("Yellow");
        card3.setCost(4);
        card3.setPower(6000);
        card3.setAttribute("Strike");
        card3.setTiming("On Play");
        card3.setEffect("Look at up to 1 Life card from the top of your or your opponent's Life Area and put it either on the top or the bottom of the Life Area. Then, if you have less Life Cards than your opponent, this Character gains [Rush].");
        card3.setAffiliations("Big Mom Pirates");
        card3.setImagePath("/images/cards/ST07/ST07-003.png");
        card3.setSet(setCode);
        cardRepository.save(card3);
        
        // Charlotte Snack - ST07-004
        Card card4 = new Card();
        card4.setName("Charlotte Snack");
        card4.setCardNumber("ST07-004");
        card4.setCardType("Character");
        card4.setColor("Blue");
        card4.setCost(5);
        card4.setPower(6000);
        card4.setAttribute("Slash");
        card4.setTiming("When Attacking");
        card4.setEffect("DON!! ×1 You may add the top or bottom card of your Life area to your hand: This Character gains [Banish] and +1000 Power during this battle.");
        card4.setAffiliations("Big Mom Pirates");
        card4.setImagePath("/images/cards/ST07/ST07-004.png");
        card4.setSet(setCode);
        cardRepository.save(card4);
        
        // Charlotte Daifuku - ST07-005
        Card card5 = new Card();
        card5.setName("Charlotte Daifuku");
        card5.setCardNumber("ST07-005");
        card5.setCardType("Character");
        card5.setColor("Blue");
        card5.setCost(4);
        card5.setPower(5000);
        card5.setCounter(1000);
        card5.setAttribute("Slash");
        card5.setTiming("When Attacking");
        card5.setEffect("DON!! ×1 You may add 1 card from the top or bottom of your Life Area to your hand: Place up to 1 card from the top of your deck at the top of your Life Area.");
        card5.setAffiliations("Big Mom Pirates");
        card5.setImagePath("/images/cards/ST07/ST07-005.png");
        card5.setSet(setCode);
        cardRepository.save(card5);
        
        // Charlotte Flampé - ST07-006
        Card card6 = new Card();
        card6.setName("Charlotte Flampé");
        card6.setCardNumber("ST07-006");
        card6.setCardType("Character");
        card6.setColor("Purple");
        card6.setCost(2);
        card6.setPower(4000);
        card6.setCounter(1000);
        card6.setAttribute("Special");
        card6.setAffiliations("Big Mom Pirates");
        card6.setImagePath("/images/cards/ST07/ST07-006.png");
        card6.setSet(setCode);
        cardRepository.save(card6);
        
        // Charlotte Brûlée - ST07-007
        Card card7 = new Card();
        card7.setName("Charlotte Brûlée");
        card7.setCardNumber("ST07-007");
        card7.setCardType("Character");
        card7.setColor("Purple");
        card7.setCost(3);
        card7.setPower(1000);
        card7.setCounter(1000);
        card7.setAttribute("Special");
        card7.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        card7.setTrigger("Play this card.");
        card7.setAffiliations("Big Mom Pirates");
        card7.setImagePath("/images/cards/ST07/ST07-007.png");
        card7.setSet(setCode);
        cardRepository.save(card7);
        
        // Charlotte Pudding - ST07-008
        Card card8 = new Card();
        card8.setName("Charlotte Pudding");
        card8.setCardNumber("ST07-008");
        card8.setCardType("Character");
        card8.setColor("Green");
        card8.setCost(2);
        card8.setPower(3000);
        card8.setCounter(2000);
        card8.setAttribute("Wisdom");
        card8.setTiming("On Play");
        card8.setEffect("Look at up to 1 Life card from the top of your or your opponent's Life Area and put it either on the top or the bottom of the Life Area.");
        card8.setAffiliations("Big Mom Pirates");
        card8.setImagePath("/images/cards/ST07/ST07-008.png");
        card8.setSet(setCode);
        cardRepository.save(card8);
        
        // Charlotte Mont D'Or - ST07-009
        Card card9 = new Card();
        card9.setName("Charlotte Mont D'Or");
        card9.setCardNumber("ST07-009");
        card9.setCardType("Character");
        card9.setColor("Purple");
        card9.setCost(3);
        card9.setPower(4000);
        card9.setCounter(1000);
        card9.setAttribute("Special");
        card9.setTiming("Activate: Main");
        card9.setEffect("You may rest this Character and add the top or bottom card of your Life Area to your hand: K.O. up to 1 of your opponent's Characters with a cost of 3 or less.");
        card9.setTrigger("You may trash 1 card from your hand: Play this card.");
        card9.setAffiliations("Big Mom Pirates");
        card9.setImagePath("/images/cards/ST07/ST07-009.png");
        card9.setSet(setCode);
        cardRepository.save(card9);
        
        // Charlotte Linlin (Character) - ST07-010
        Card card10 = new Card();
        card10.setName("Charlotte Linlin");
        card10.setCardNumber("ST07-010");
        card10.setCardType("Character");
        card10.setColor("Purple");
        card10.setCost(7);
        card10.setPower(8000);
        card10.setAttribute("Special");
        card10.setTiming("On Play");
        card10.setEffect("Your opponent chooses 1 of the following effects.\n• Trash 1 Life card from the top card of your opponent's Life area.\n• Put 1 card from the top of your deck on top of your Life area.");
        card10.setAffiliations("Four Emperors/Big Mom Pirates");
        card10.setImagePath("/images/cards/ST07/ST07-010.png");
        card10.setSet(setCode);
        cardRepository.save(card10);
        
        // Zeus - ST07-011
        Card card11 = new Card();
        card11.setName("Zeus");
        card11.setCardNumber("ST07-011");
        card11.setCardType("Character");
        card11.setColor("Purple");
        card11.setCost(3);
        card11.setPower(3000);
        card11.setCounter(1000);
        card11.setAttribute("Special");
        card11.setTiming("Activate: Main");
        card11.setEffect("You may rest this card: Up to 1 of your [Charlotte Linlin] gains [Banish] during this turn.");
        card11.setTrigger("Play this card.");
        card11.setAffiliations("Big Mom Pirates/Homies");
        card11.setImagePath("/images/cards/ST07/ST07-011.png");
        card11.setSet(setCode);
        cardRepository.save(card11);
        
        // Baron Tamago - ST07-012
        Card card12 = new Card();
        card12.setName("Baron Tamago");
        card12.setCardNumber("ST07-012");
        card12.setCardType("Character");
        card12.setColor("Yellow");
        card12.setCost(4);
        card12.setPower(6000);
        card12.setCounter(1000);
        card12.setAttribute("Strike");
        card12.setAffiliations("Big Mom Pirates");
        card12.setImagePath("/images/cards/ST07/ST07-012.png");
        card12.setSet(setCode);
        cardRepository.save(card12);
        
        // Prometheus - ST07-013
        Card card13 = new Card();
        card13.setName("Prometheus");
        card13.setCardNumber("ST07-013");
        card13.setCardType("Character");
        card13.setColor("Purple");
        card13.setCost(3);
        card13.setPower(3000);
        card13.setCounter(1000);
        card13.setAttribute("Special");
        card13.setTiming("Activate: Main");
        card13.setEffect("You may rest this card: Up to 1 of your [Charlotte Linlin] gain [Double Attack] during this turn.");
        card13.setTrigger("Play this card.");
        card13.setAffiliations("Big Mom Pirates/Homies");
        card13.setImagePath("/images/cards/ST07/ST07-013.png");
        card13.setSet(setCode);
        cardRepository.save(card13);
        
        // Pekoms - ST07-014
        Card card14 = new Card();
        card14.setName("Pekoms");
        card14.setCardNumber("ST07-014");
        card14.setCardType("Character");
        card14.setColor("Yellow");
        card14.setCost(3);
        card14.setPower(5000);
        card14.setCounter(1000);
        card14.setAttribute("Strike");
        card14.setAffiliations("Minks/Big Mom Pirates");
        card14.setImagePath("/images/cards/ST07/ST07-014.png");
        card14.setSet(setCode);
        cardRepository.save(card14);
        
        // Soul Pocus - ST07-015
        Card card15 = new Card();
        card15.setName("Soul Pocus");
        card15.setCardNumber("ST07-015");
        card15.setCardType("Event");
        card15.setColor("Purple");
        card15.setCost(5);
        card15.setAttribute("Special");
        card15.setTiming("Main");
        card15.setEffect("Your opponent chooses 1 of the following effects.\n• Trash 1 Life card from the top of your opponent's Life area.\n• Put 1 card from the top of your deck on top of your Life area.");
        card15.setTrigger("Activate this card's Main effect");
        card15.setAffiliations("The Four Emperors/Big Mom Pirates");
        card15.setImagePath("/images/cards/ST07/ST07-015.png");
        card15.setSet(setCode);
        cardRepository.save(card15);
        
        // Power Mochi - ST07-016
        Card card16 = new Card();
        card16.setName("Power Mochi");
        card16.setCardNumber("ST07-016");
        card16.setCardType("Event");
        card16.setColor("Yellow");
        card16.setCost(1);
        card16.setAttribute("Strike");
        card16.setTiming("Counter");
        card16.setEffect("Look at up to 1 card from the top of your or your opponent's Life area and place it at the top or bottom of the Life area. Then, up to 1 of your Leader or Characters gains +2000 Power during this battle.");
        card16.setTrigger("Draw 1 card. Look at up to 1 card from the top of your or your opponent's Life area and place it at the top or bottom of the Life area.");
        card16.setAffiliations("Big Mom Pirates");
        card16.setImagePath("/images/cards/ST07/ST07-016.png");
        card16.setSet(setCode);
        cardRepository.save(card16);
        
        // Queen Mama Chanter - ST07-017
        Card card17 = new Card();
        card17.setName("Queen Mama Chanter");
        card17.setCardNumber("ST07-017");
        card17.setCardType("Stage");
        card17.setColor("Yellow");
        card17.setCost(2);
        card17.setAttribute("Strike");
        card17.setTiming("Activate: Main");
        card17.setEffect("Rest this stage, you may add 1 card from the top or bottom of your Life area to your hand: Place up to 1 of your Characters with a cost of 3 on top of the owner's Life area face-up.");
        card17.setTrigger("Play this card.");
        card17.setAffiliations("Big Mom Pirates/Homies");
        card17.setImagePath("/images/cards/ST07/ST07-017.png");
        card17.setSet(setCode);
        cardRepository.save(card17);

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 