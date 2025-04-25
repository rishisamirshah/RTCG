package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(20) // Order after ST09
public class ST10Initializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public ST10Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        String setCode = "ST10";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // --- Add Card definitions here ---
        
        // Trafalgar Law (Leader) - ST10-001
        Card card1 = new Card();
        card1.setName("Trafalgar Law");
        card1.setCardNumber("ST10-001");
        card1.setCardType("Leader");
        card1.setColor("Blue");
        card1.setLife(4);
        card1.setPower(5000);
        card1.setAttribute("Slash");
        card1.setTiming("Activate: Main");
        card1.setEffect("Once Per Turn DON!!-3 Return one of your opponent's characters with 3000 Power or less to the bottom of their deck. Then play one 4 cost or lower character from your hand.");
        card1.setAffiliations("Heart Pirates");
        card1.setImagePath("/images/cards/ST10/ST10-001.png");
        card1.setSet(setCode);
        cardRepository.save(card1);
        
        // Monkey D. Luffy (Leader) - ST10-002
        Card card2 = new Card();
        card2.setName("Monkey D. Luffy");
        card2.setCardNumber("ST10-002");
        card2.setCardType("Leader");
        card2.setColor("Yellow");
        card2.setLife(3);
        card2.setPower(6000);
        card2.setAttribute("Strike");
        card2.setTiming("Activate: Main");
        card2.setEffect("Once Per Turn If your field has 0 DON!!, or your board has 8 or more DON!!, add 1 DON!! from your DON!! deck active");
        card2.setAffiliations("Straw Hat Crew");
        card2.setImagePath("/images/cards/ST10/ST10-002.png");
        card2.setSet(setCode);
        cardRepository.save(card2);
        
        // Eustass Kidd (Leader) - ST10-003
        Card card3 = new Card();
        card3.setName("Eustass Kidd");
        card3.setCardNumber("ST10-003");
        card3.setCardType("Leader");
        card3.setColor("Purple");
        card3.setLife(5);
        card3.setPower(5000);
        card3.setAttribute("Special");
        card3.setTiming("Your Turn");
        card3.setEffect("If you have 4 or more life, this leader has power -1000.\nWhen Attacking DON!! -1 This leader gains +2000 power for this turn");
        card3.setAffiliations("Kid Pirates");
        card3.setImagePath("/images/cards/ST10/ST10-003.png");
        card3.setSet(setCode);
        cardRepository.save(card3);
        
        // Sanji - ST10-004
        Card card4 = new Card();
        card4.setName("Sanji");
        card4.setCardNumber("ST10-004");
        card4.setCardType("Character");
        card4.setColor("Red");
        card4.setCost(6);
        card4.setPower(6000);
        card4.setCounter(1000);
        card4.setAttribute("Strike");
        card4.setTiming("On Play");
        card4.setEffect("If your opponent has a Character with 5000 power or more, this Character gains Rush during this turn. (This card can attack on the turn in which it is played.)");
        card4.setAffiliations("Straw Hat Crew");
        card4.setImagePath("/images/cards/ST10/ST10-004.png");
        card4.setSet(setCode);
        cardRepository.save(card4);
        
        // Jinbe - ST10-005
        Card card5 = new Card();
        card5.setName("Jinbe");
        card5.setCardNumber("ST10-005");
        card5.setCardType("Character");
        card5.setColor("Red");
        card5.setCost(2);
        card5.setPower(2000);
        card5.setCounter(2000);
        card5.setAttribute("Strike");
        card5.setTiming("When Attacking");
        card5.setEffect("DON!! ×1 Give up to one of your opponent's Characters -2000 power for this turn.");
        card5.setAffiliations("Fishmen/Straw Hat Crew");
        card5.setImagePath("/images/cards/ST10/ST10-005.png");
        card5.setSet(setCode);
        cardRepository.save(card5);
        
        // Monkey D. Luffy - ST10-006
        Card card6 = new Card();
        card6.setName("Monkey D. Luffy");
        card6.setCardNumber("ST10-006");
        card6.setCardType("Character");
        card6.setColor("Red");
        card6.setCost(10);
        card6.setPower(11000);
        card6.setAttribute("Strike");
        card6.setEffect("Rush (This card can attack on the turn in which it is played.)\nOnce Per Turn After your opponent activates Blocker, K.O. up to one of your opponent's Characters with 8000 power or less");
        card6.setAffiliations("Straw Hat Crew");
        card6.setImagePath("/images/cards/ST10/ST10-006.png");
        card6.setSet(setCode);
        cardRepository.save(card6);
        
        // Killer - ST10-007
        Card card7 = new Card();
        card7.setName("Killer");
        card7.setCardNumber("ST10-007");
        card7.setCardType("Character");
        card7.setColor("Blue");
        card7.setCost(5);
        card7.setPower(6000);
        card7.setCounter(1000);
        card7.setAttribute("Slash");
        card7.setTiming("Your Turn");
        card7.setEffect("Once Per Turn When DON!! is returned from your field to your DON!! deck, KO up to 1 of your opponents rested characters with a cost of 3 or less");
        card7.setAffiliations("Kid Pirates");
        card7.setImagePath("/images/cards/ST10/ST10-007.png");
        card7.setSet(setCode);
        cardRepository.save(card7);
        
        // Shachi and Penguin - ST10-008
        Card card8 = new Card();
        card8.setName("Shachi and Penguin");
        card8.setCardNumber("ST10-008");
        card8.setCardType("Character");
        card8.setColor("Purple");
        card8.setCost(4);
        card8.setPower(5000);
        card8.setCounter(2000);
        card8.setAttribute("Special");
        card8.setTiming("On Play");
        card8.setEffect("If there are 3 or less DON!! on your field, you may add up to 2 DON!! from your DON!! deck set as rested.");
        card8.setAffiliations("Heart Pirates");
        card8.setImagePath("/images/cards/ST10/ST10-008.png");
        card8.setSet(setCode);
        cardRepository.save(card8);
        
        // Jean Bart - ST10-009
        Card card9 = new Card();
        card9.setName("Jean Bart");
        card9.setCardNumber("ST10-009");
        card9.setCardType("Character");
        card9.setColor("Purple");
        card9.setCost(4);
        card9.setPower(5000);
        card9.setCounter(1000);
        card9.setAttribute("Strike");
        card9.setTiming("On Play");
        card9.setEffect("1 (You may rest the specified number of DON!! cards in your Cost Area) You may add up to 1 DON!! from your DON!! deck set as active.");
        card9.setAffiliations("Heart Pirates");
        card9.setImagePath("/images/cards/ST10/ST10-009.png");
        card9.setSet(setCode);
        cardRepository.save(card9);
        
        // Trafalgar Law - ST10-010
        Card card10 = new Card();
        card10.setName("Trafalgar Law");
        card10.setCardNumber("ST10-010");
        card10.setCardType("Character");
        card10.setColor("Blue");
        card10.setCost(4);
        card10.setPower(5000);
        card10.setCounter(1000);
        card10.setAttribute("Slash");
        card10.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\nOn Play DON!!: 1 If your opponent has 7 or more cards in hand, you may trash 2 cards from their hand.");
        card10.setAffiliations("Heart Pirates");
        card10.setImagePath("/images/cards/ST10/ST10-010.png");
        card10.setSet(setCode);
        cardRepository.save(card10);
        
        // Heat - ST10-011
        Card card11 = new Card();
        card11.setName("Heat");
        card11.setCardNumber("ST10-011");
        card11.setCardType("Character");
        card11.setColor("Purple");
        card11.setCost(3);
        card11.setPower(4000);
        card11.setCounter(1000);
        card11.setAttribute("Special");
        card11.setTiming("Your Turn");
        card11.setEffect("Once Per Turn When a DON!! is returned to the DON!! deck from your field, this Character gains +2000 power until the start of your next turn.");
        card11.setAffiliations("Kid Pirates");
        card11.setImagePath("/images/cards/ST10/ST10-011.png");
        card11.setSet(setCode);
        cardRepository.save(card11);
        
        // Bepo - ST10-012
        Card card12 = new Card();
        card12.setName("Bepo");
        card12.setCardNumber("ST10-012");
        card12.setCardType("Character");
        card12.setColor("Purple");
        card12.setCost(4);
        card12.setPower(5000);
        card12.setCounter(1000);
        card12.setAttribute("Special");
        card12.setTiming("On Play / When Attacking");
        card12.setEffect("If the number of DON!! cards on your opponent's field is greater than the number of DON!! cards on your field, add 1 DON!! card from your DON!! deck rested to your cost area.");
        card12.setAffiliations("Mink Tribe/Heart Pirates");
        card12.setImagePath("/images/cards/ST10/ST10-012.png");
        card12.setSet(setCode);
        cardRepository.save(card12);
        
        // Eustass \"Captain\" Kid - ST10-013
        Card card13 = new Card();
        card13.setName("Eustass \"Captain\" Kid");
        card13.setCardNumber("ST10-013");
        card13.setCardType("Character");
        card13.setColor("Purple");
        card13.setCost(7);
        card13.setPower(8000);
        card13.setAttribute("Special");
        card13.setTiming("On Play / When Attacking");
        card13.setEffect("DON!!-1 Up to 1 of your Leader gains +1000 power until the start of your next turn.");
        card13.setAffiliations("Kid Pirates");
        card13.setImagePath("/images/cards/ST10/ST10-013.png");
        card13.setSet(setCode);
        cardRepository.save(card13);
        
        // Wire - ST10-014
        Card card14 = new Card();
        card14.setName("Wire");
        card14.setCardNumber("ST10-014");
        card14.setCardType("Character");
        card14.setColor("Blue");
        card14.setCost(3);
        card14.setPower(3000);
        card14.setCounter(1000);
        card14.setAttribute("Slash");
        card14.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\nOnce Per Turn If a DON!! card is returned to the DON!! deck, draw 1 and discard 1 card from your hand.");
        card14.setAffiliations("Kid Pirates");
        card14.setImagePath("/images/cards/ST10/ST10-014.png");
        card14.setSet(setCode);
        cardRepository.save(card14);
        
        // Gum Gum Giant Thrust - ST10-015
        Card card15 = new Card();
        card15.setName("Gum Gum Giant Thrust");
        card15.setCardNumber("ST10-015");
        card15.setCardType("Event");
        card15.setColor("Red");
        card15.setCost(1);
        card15.setAttribute("Strike");
        card15.setTiming("Counter");
        card15.setEffect("Up to 1 of your leaders or characters gains +2000 Power during this battle, and K.O. up to 1 of your opponent's characters with 2000 Power or less.");
        card15.setAffiliations("Straw Hat Pirates");
        card15.setImagePath("/images/cards/ST10/ST10-015.png");
        card15.setSet(setCode);
        cardRepository.save(card15);
        
        // Gum Gum Kong Gatling - ST10-016
        Card card16 = new Card();
        card16.setName("Gum Gum Kong Gatling");
        card16.setCardNumber("ST10-016");
        card16.setCardType("Event");
        card16.setColor("Red");
        card16.setCost(5);
        card16.setAttribute("Strike");
        card16.setTiming("Main");
        card16.setEffect("K.O. up to 1 of your opponent's characters with 7000 Power or less.");
        card16.setTrigger("Until the end of your next turn, up to 1 of your leaders gains +1000 Power.");
        card16.setAffiliations("Straw hat Pirates");
        card16.setImagePath("/images/cards/ST10/ST10-016.png");
        card16.setSet(setCode);
        cardRepository.save(card16);
        
        // Punk Vice - ST10-017
        Card card17 = new Card();
        card17.setName("Punk Vice");
        card17.setCardNumber("ST10-017");
        card17.setCardType("Event");
        card17.setColor("Purple");
        card17.setCost(3);
        card17.setAttribute("Special");
        card17.setTiming("Main");
        card17.setEffect("Rest up to 1 of your opponent's characters with a cost of 2 or less. Add up to 1 DON!! from your DON!! deck set as rested.");
        card17.setTrigger("Add up to 1 DON!! from your DON!! deck set as active.");
        card17.setAffiliations("Kid Pirates");
        card17.setImagePath("/images/cards/ST10/ST10-017.png");
        card17.setSet(setCode);
        cardRepository.save(card17);

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 