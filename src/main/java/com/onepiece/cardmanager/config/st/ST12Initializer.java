package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.config.BaseInitializer;
import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(22) // Order after ST11
public class ST12Initializer extends BaseInitializer {

    private final CardRepository cardRepository;

    @Autowired
    public ST12Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    protected void initialize(String... args) throws Exception {
        String setCode = "ST12";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // --- Add Card definitions here ---
        
        // Roronoa Zoro & Sanji (Leader) - ST12-001
        Card card1 = new Card();
        card1.setName("Roronoa Zoro & Sanji");
        card1.setCardNumber("ST12-001");
        card1.setCardType("Leader");
        card1.setColor("Blue");
        card1.setLife(4);
        card1.setPower(5000);
        card1.setAttribute("Slash");
        card1.setTiming("When Attacking");
        card1.setEffect("DON!! ×1 Once Per Turn You may return one of your cost 2 or higher characters to its owner's hand: Set up to one of your Power 7000 or less characters as active.");
        card1.setAffiliations("Straw Hat Crew");
        card1.setImagePath("/images/cards/ST12/ST12-001.png");
        card1.setSet(setCode);
        cardRepository.save(card1);
        
        // Kuina - ST12-002
        Card card2 = new Card();
        card2.setName("Kuina");
        card2.setCardNumber("ST12-002");
        card2.setCardType("Character");
        card2.setColor("Blue");
        card2.setCost(3);
        card2.setPower(2000);
        card2.setCounter(1000);
        card2.setAttribute("Slash");
        card2.setTiming("Activate: Main");
        card2.setEffect("You may rest this character: rest up to 1 of your opponent's cost 4 or lower characters.");
        card2.setTrigger("Play this card.");
        card2.setAffiliations("Shimotsuki Village");
        card2.setImagePath("/images/cards/ST12/ST12-002.png");
        card2.setSet(setCode);
        cardRepository.save(card2);
        
        // Dracule Mihawk - ST12-003
        Card card3 = new Card();
        card3.setName("Dracule Mihawk");
        card3.setCardNumber("ST12-003");
        card3.setCardType("Character");
        card3.setColor("Blue");
        card3.setCost(3);
        card3.setPower(4000);
        card3.setCounter(2000);
        card3.setAttribute("Slash");
        card3.setTiming("On Play");
        card3.setEffect("If you have 2 or less characters, play up to 1 4 cost or lower \"Shikearu Kingdom\" type or 'Slash' trait character card other than \"Dracule Mihawk\" from your hand rested.");
        card3.setAffiliations("Seven Warlords of the Sea/Shikearu Kingdom");
        card3.setImagePath("/images/cards/ST12/ST12-003.png");
        card3.setSet(setCode);
        cardRepository.save(card3);
        
        // Humandrill - ST12-004
        Card card4 = new Card();
        card4.setName("Humandrill");
        card4.setCardNumber("ST12-004");
        card4.setCardType("Character");
        card4.setColor("Green");
        card4.setCost(3);
        card4.setPower(5000);
        card4.setCounter(1000);
        card4.setAttribute("Wisdom");
        card4.setAffiliations("Animal/Shikearu Kingdom");
        card4.setImagePath("/images/cards/ST12/ST12-004.png");
        card4.setSet(setCode);
        cardRepository.save(card4);
        
        // Perona - ST12-005
        Card card5 = new Card();
        card5.setName("Perona");
        card5.setCardNumber("ST12-005");
        card5.setCardType("Character");
        card5.setColor("Purple");
        card5.setCost(4);
        card5.setPower(6000);
        card5.setCounter(1000);
        card5.setAttribute("Special");
        card5.setAffiliations("Shikearu Kingdom/Thriller Bark Pirates");
        card5.setImagePath("/images/cards/ST12/ST12-005.png");
        card5.setSet(setCode);
        cardRepository.save(card5);
        
        // Yosaku & Johnny - ST12-006
        Card card6 = new Card();
        card6.setName("Yosaku & Johnny");
        card6.setCardNumber("ST12-006");
        card6.setCardType("Character");
        card6.setColor("Blue");
        card6.setCost(2);
        card6.setPower(3000);
        card6.setCounter(1000);
        card6.setAttribute("Slash");
        card6.setTiming("When Attacking");
        card6.setEffect("DON!! ×1 Choose up to 1 of the following effects:\n• Rest up to 1 of your opponent's cost 2 or lower characters\n• KO up to 1 of your opponent's cost 2 or lower rested characters");
        card6.setAffiliations("East Blue");
        card6.setImagePath("/images/cards/ST12/ST12-006.png");
        card6.setSet(setCode);
        cardRepository.save(card6);
        
        // Rika - ST12-007
        Card card7 = new Card();
        card7.setName("Rika");
        card7.setCardNumber("ST12-007");
        card7.setCardType("Character");
        card7.setColor("Green");
        card7.setCost(2);
        card7.setPower(0);
        card7.setCounter(2000);
        card7.setAttribute("Wisdom");
        card7.setTiming("On Play");
        card7.setEffect("2 (You may rest the specified number of DON!! cards in your Cost Area) If your opponent has 3 or more lives, set up to 1 of your \"Slash\" trait character with a cost of 4 or less active");
        card7.setAffiliations("East Blue");
        card7.setImagePath("/images/cards/ST12/ST12-007.png");
        card7.setSet(setCode);
        cardRepository.save(card7);
        
        // Roronoa Zoro - ST12-008
        Card card8 = new Card();
        card8.setName("Roronoa Zoro");
        card8.setCardNumber("ST12-008");
        card8.setCardType("Character");
        card8.setColor("Blue");
        card8.setCost(4);
        card8.setPower(6000);
        card8.setAttribute("Slash");
        card8.setTiming("When Attacking");
        card8.setEffect("DON!! ×1 Rest up to 1 of your opponent's cost 6 or lower characters.");
        card8.setAffiliations("Straw Hat Crew");
        card8.setImagePath("/images/cards/ST12/ST12-008.png");
        card8.setSet(setCode);
        cardRepository.save(card8);
        
        // Blue-Finned Elephant Tuna - ST12-009
        Card card9 = new Card();
        card9.setName("Blue-Finned Elephant Tuna");
        card9.setCardNumber("ST12-009");
        card9.setCardType("Character");
        card9.setColor("Blue");
        card9.setCost(1);
        card9.setPower(3000);
        card9.setCounter(1000);
        card9.setAttribute("Slash");
        card9.setAffiliations("Animal");
        card9.setImagePath("/images/cards/ST12/ST12-009.png");
        card9.setSet(setCode);
        cardRepository.save(card9);
        
        // Emporio Ivankov - ST12-010
        Card card10 = new Card();
        card10.setName("Emporio Ivankov");
        card10.setCardNumber("ST12-010");
        card10.setCardType("Character");
        card10.setColor("Purple");
        card10.setCost(3);
        card10.setPower(4000);
        card10.setCounter(1000);
        card10.setAttribute("Special");
        card10.setTiming("On Play");
        card10.setEffect("Reveal the top card of your deck. Play up to 1 cost 2 Character Card, then return the remaining card to the top or bottom of your deck.");
        card10.setTiming("When Attacking");
        card10.setEffect("Once Per Turn If your hand has 6 cards or less, draw a card.");
        card10.setAffiliations("Impel Down/Revolutionary Army");
        card10.setImagePath("/images/cards/ST12/ST12-010.png");
        card10.setSet(setCode);
        cardRepository.save(card10);
        
        // Sanji - ST12-011
        Card card11 = new Card();
        card11.setName("Sanji");
        card11.setCardNumber("ST12-011");
        card11.setCardType("Character");
        card11.setColor("Yellow");
        card11.setCost(2);
        card11.setPower(3000);
        card11.setAttribute("Strike");
        card11.setTiming("When Attacking");
        card11.setEffect("DON!! ×1 If you have 5 or less cards in your hand, this character gains +2000 power until the start of your next turn.");
        card11.setAffiliations("Straw Hat Crew");
        card11.setImagePath("/images/cards/ST12/ST12-011.png");
        card11.setSet(setCode);
        cardRepository.save(card11);
        
        // Charlotte Pudding - ST12-012
        Card card12 = new Card();
        card12.setName("Charlotte Pudding");
        card12.setCardNumber("ST12-012");
        card12.setCardType("Character");
        card12.setColor("Blue");
        card12.setCost(2);
        card12.setPower(2000);
        card12.setCounter(2000);
        card12.setAttribute("Wisdom");
        card12.setTiming("Activate: Main");
        card12.setEffect("Return this character to the owner's hand.");
        card12.setAffiliations("Big Mom Pirates");
        card12.setImagePath("/images/cards/ST12/ST12-012.png");
        card12.setSet(setCode);
        cardRepository.save(card12);
        
        // Zeff - ST12-013
        Card card13 = new Card();
        card13.setName("Zeff");
        card13.setCardNumber("ST12-013");
        card13.setCardType("Character");
        card13.setColor("Blue");
        card13.setCost(5);
        card13.setPower(5000);
        card13.setCounter(1000);
        card13.setAttribute("Strike");
        card13.setTiming("On Play");
        card13.setEffect("Look at the top 3 cards of your deck, and place them at the top or bottom of your deck in any order.");
        card13.setTiming("When Attacking");
        card13.setEffect("Reveal the top card of your deck, you may play up to one cost 2 character card rested. Then, return the remaining card to the top or bottom of your deck.");
        card13.setAffiliations("East Blue");
        card13.setImagePath("/images/cards/ST12/ST12-013.png");
        card13.setSet(setCode);
        cardRepository.save(card13);
        
        // Duval - ST12-014
        Card card14 = new Card();
        card14.setName("Duval");
        card14.setCardNumber("ST12-014");
        card14.setCardType("Character");
        card14.setColor("Blue");
        card14.setCost(2);
        card14.setPower(1000);
        card14.setCounter(1000);
        card14.setAttribute("Slash");
        card14.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\nOn Play Look at 3 cards from the top of your deck and place them at the top or bottom of the deck in any order.");
        card14.setAffiliations("Flying Fish Riders");
        card14.setImagePath("/images/cards/ST12/ST12-014.png");
        card14.setSet(setCode);
        cardRepository.save(card14);
        
        // Patty & Carne - ST12-015
        Card card15 = new Card();
        card15.setName("Patty & Carne");
        card15.setCardNumber("ST12-015");
        card15.setCardType("Character");
        card15.setColor("Blue");
        card15.setCost(2);
        card15.setPower(4000);
        card15.setCounter(1000);
        card15.setAttribute("Slash");
        card15.setAffiliations("East Blue");
        card15.setImagePath("/images/cards/ST12/ST12-015.png");
        card15.setSet(setCode);
        cardRepository.save(card15);
        
        // Lion's Song - ST12-016
        Card card16 = new Card();
        card16.setName("Lion's Song");
        card16.setCardNumber("ST12-016");
        card16.setCardType("Event");
        card16.setColor("Green");
        card16.setCost(2);
        card16.setAttribute("Wisdom");
        card16.setTiming("Main / Counter");
        card16.setEffect("Rest up to 1 of your opponent's Leaders or Cost 4 or lower characters.");
        card16.setTrigger("Activate this card's Main effect.");
        card16.setAffiliations("Straw Hat Crew");
        card16.setImagePath("/images/cards/ST12/ST12-016.png");
        card16.setSet(setCode);
        cardRepository.save(card16);
        
        // Parrage Shot - ST12-017
        Card card17 = new Card();
        card17.setName("Parrage Shot");
        card17.setCardNumber("ST12-017");
        card17.setCardType("Event");
        card17.setColor("Blue");
        card17.setCost(1);
        card17.setAttribute("Slash");
        card17.setTiming("Counter");
        card17.setEffect("Give up to 1 of your Leaders or Characters +2000 power for this battle. Then, reveal the top card of your deck, play up to one cost 2 character. Then, place the remaining cards at the top or bottom of your deck.");
        card17.setAffiliations("Straw Hat Crew");
        card17.setImagePath("/images/cards/ST12/ST12-017.png");
        card17.setSet(setCode);
        cardRepository.save(card17);

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 