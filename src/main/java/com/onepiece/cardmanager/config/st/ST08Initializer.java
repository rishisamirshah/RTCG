package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(18) // Order after ST07
public class ST08Initializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public ST08Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        String setCode = "ST08";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // --- Add Card definitions here ---
        
        // Monkey D. Luffy (Leader) - ST08-001
        Card card1 = new Card();
        card1.setName("Monkey D. Luffy");
        card1.setCardNumber("ST08-001");
        card1.setCardType("Leader");
        card1.setColor("Yellow");
        card1.setLife(5);
        card1.setPower(5000);
        card1.setAttribute("Strike");
        card1.setTiming("Your Turn");
        card1.setEffect("When a Character is K.O'd, give up to 1 rested DON!! cards to this Leader.");
        card1.setAffiliations("Straw Hat Crew");
        card1.setImagePath("/images/cards/ST08/ST08-001.png");
        card1.setSet(setCode);
        cardRepository.save(card1);
        
        // Uta - ST08-002
        Card card2 = new Card();
        card2.setName("Uta");
        card2.setCardNumber("ST08-002");
        card2.setCardType("Character");
        card2.setColor("Purple");
        card2.setCost(2);
        card2.setPower(3000);
        card2.setAttribute("Special");
        card2.setEffect("This character cannot be KO'ed by battling against a Leader.\nActivate: Main You may rest this card: Give up to 1 of your opponent's character cost -2 during this turn");
        card2.setAffiliations("FILM");
        card2.setImagePath("/images/cards/ST08/ST08-002.png");
        card2.setSet(setCode);
        cardRepository.save(card2);
        
        // Gaimon - ST08-003
        Card card3 = new Card();
        card3.setName("Gaimon");
        card3.setCardNumber("ST08-003");
        card3.setCardType("Character");
        card3.setColor("Green");
        card3.setCost(2);
        card3.setPower(4000);
        card3.setCounter(1000);
        card3.setAttribute("Wisdom");
        card3.setAffiliations("East Blue");
        card3.setImagePath("/images/cards/ST08/ST08-003.png");
        card3.setSet(setCode);
        cardRepository.save(card3);
        
        // Koby - ST08-004
        Card card4 = new Card();
        card4.setName("Koby");
        card4.setCardNumber("ST08-004");
        card4.setCardType("Character");
        card4.setColor("Yellow");
        card4.setCost(4);
        card4.setPower(1000);
        card4.setCounter(1000);
        card4.setAttribute("Strike");
        card4.setTiming("Activate: Main");
        card4.setEffect("You may rest this Character: K.O. up to 1 of your opponent's Character with a cost of 2 or less.");
        card4.setAffiliations("Navy");
        card4.setImagePath("/images/cards/ST08/ST08-004.png");
        card4.setSet(setCode);
        cardRepository.save(card4);
        
        // Shanks - ST08-005
        Card card5 = new Card();
        card5.setName("Shanks");
        card5.setCardNumber("ST08-005");
        card5.setCardType("Character");
        card5.setColor("Blue");
        card5.setCost(9);
        card5.setPower(10000);
        card5.setAttribute("Slash");
        card5.setTiming("On Play");
        card5.setEffect("You may trash 1 card from your hand: KO all characters with a cost of 1 or less");
        card5.setAffiliations("Red Haired Pirates");
        card5.setImagePath("/images/cards/ST08/ST08-005.png");
        card5.setSet(setCode);
        cardRepository.save(card5);
        
        // Shirahoshi - ST08-006
        Card card6 = new Card();
        card6.setName("Shirahoshi");
        card6.setCardNumber("ST08-006");
        card6.setCardType("Character");
        card6.setColor("Green");
        card6.setCost(4);
        card6.setPower(0);
        card6.setCounter(1000);
        card6.setAttribute("Wisdom");
        card6.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\nOn Play Give up to 1 of your opponent's Characters -4 cost during this turn.");
        card6.setAffiliations("Mermaid");
        card6.setImagePath("/images/cards/ST08/ST08-006.png");
        card6.setSet(setCode);
        cardRepository.save(card6);
        
        // Nefertari Vivi - ST08-007
        Card card7 = new Card();
        card7.setName("Nefertari Vivi");
        card7.setCardNumber("ST08-007");
        card7.setCardType("Character");
        card7.setColor("Blue");
        card7.setCost(3);
        card7.setPower(1000);
        card7.setCounter(1000);
        card7.setAttribute("Slash");
        card7.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        card7.setTrigger("Play this card.");
        card7.setAffiliations("Alabasta Kingdom");
        card7.setImagePath("/images/cards/ST08/ST08-007.png");
        card7.setSet(setCode);
        cardRepository.save(card7);
        
        // Higuma - ST08-008
        Card card8 = new Card();
        card8.setName("Higuma");
        card8.setCardNumber("ST08-008");
        card8.setCardType("Character");
        card8.setColor("Blue");
        card8.setCost(1);
        card8.setPower(2000);
        card8.setCounter(1000);
        card8.setAttribute("Slash");
        card8.setTiming("On Play");
        card8.setEffect("Give up to 1 of your opponent's Characters -2 cost during this turn.");
        card8.setAffiliations("Mountain Bandit");
        card8.setImagePath("/images/cards/ST08/ST08-008.png");
        card8.setSet(setCode);
        cardRepository.save(card8);
        
        // Makino - ST08-009
        Card card9 = new Card();
        card9.setName("Makino");
        card9.setCardNumber("ST08-009");
        card9.setCardType("Character");
        card9.setColor("Green");
        card9.setCost(2);
        card9.setPower(0);
        card9.setCounter(2000);
        card9.setAttribute("Wisdom");
        card9.setTiming("On Play");
        card9.setEffect("If there's a Character with a cost of 0 in play, draw 1 card.");
        card9.setAffiliations("East Blue");
        card9.setImagePath("/images/cards/ST08/ST08-009.png");
        card9.setSet(setCode);
        cardRepository.save(card9);
        
        // Monkey D. Garp - ST08-010
        Card card10 = new Card();
        card10.setName("Monkey D. Garp");
        card10.setCardNumber("ST08-010");
        card10.setCardType("Character");
        card10.setColor("Yellow");
        card10.setCost(5);
        card10.setPower(7000);
        card10.setCounter(1000);
        card10.setAttribute("Strike");
        card10.setAffiliations("Navy");
        card10.setImagePath("/images/cards/ST08/ST08-010.png");
        card10.setSet(setCode);
        cardRepository.save(card10);
        
        // Monkey D. Luffy (Character) - ST08-011
        Card card11 = new Card();
        card11.setName("Monkey D. Luffy");
        card11.setCardNumber("ST08-011");
        card11.setCardType("Character");
        card11.setColor("Yellow");
        card11.setCost(3);
        card11.setPower(5000);
        card11.setCounter(1000);
        card11.setAttribute("Strike");
        card11.setAffiliations("Straw Hat Crew");
        card11.setImagePath("/images/cards/ST08/ST08-011.png");
        card11.setSet(setCode);
        cardRepository.save(card11);
        
        // Laboon - ST08-012
        Card card12 = new Card();
        card12.setName("Laboon");
        card12.setCardNumber("ST08-012");
        card12.setCardType("Character");
        card12.setColor("Yellow");
        card12.setCost(4);
        card12.setPower(6000);
        card12.setCounter(1000);
        card12.setAttribute("Strike");
        card12.setAffiliations("Animal");
        card12.setImagePath("/images/cards/ST08/ST08-012.png");
        card12.setSet(setCode);
        cardRepository.save(card12);
        
        // Mr. 2 Bon Clay (Bentham) - ST08-013
        Card card13 = new Card();
        card13.setName("Mr. 2 Bon Clay (Bentham)");
        card13.setCardNumber("ST08-013");
        card13.setCardType("Character");
        card13.setColor("Yellow");
        card13.setCost(5);
        card13.setPower(6000);
        card13.setAttribute("Strike");
        card13.setEffect("DON!! ×1 At the end of the battle in which this Character battles an opponent's Character, you may K.O. your opponent's Character that battled. If you do, K.O. this Character.");
        card13.setAffiliations("Former Baroque Works");
        card13.setImagePath("/images/cards/ST08/ST08-013.png");
        card13.setSet(setCode);
        cardRepository.save(card13);
        
        // Gum-Gum Bell - ST08-014
        Card card14 = new Card();
        card14.setName("Gum-Gum Bell");
        card14.setCardNumber("ST08-014");
        card14.setCardType("Event");
        card14.setColor("Yellow");
        card14.setCost(2);
        card14.setAttribute("Strike");
        card14.setTiming("Main");
        card14.setEffect("You may add the top card of your life to your hand: Give up to 1 of your opponent's Characters -7 cost during this turn.");
        card14.setTrigger("Add up to 1 black Character card with a cost of 2 or less from your trash to your hand.");
        card14.setAffiliations("Straw Hat Crew");
        card14.setImagePath("/images/cards/ST08/ST08-014.png");
        card14.setSet(setCode);
        cardRepository.save(card14);
        
        // Gum Gum Pistol - ST08-015
        Card card15 = new Card();
        card15.setName("Gum Gum Pistol");
        card15.setCardNumber("ST08-015");
        card15.setCardType("Event");
        card15.setColor("Yellow");
        card15.setCost(3);
        card15.setAttribute("Strike");
        card15.setTiming("Main");
        card15.setEffect("KO up to 1 of your opponent's Characters with a cost of 2 or less.");
        card15.setTrigger("Draw 1 card.");
        card15.setAffiliations("Straw Hat Crew");
        card15.setImagePath("/images/cards/ST08/ST08-015.png");
        card15.setSet(setCode);
        cardRepository.save(card15);

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 