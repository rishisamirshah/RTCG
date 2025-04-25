package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(31) // Order after ST20
public class ST21Initializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public ST21Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        String setCode = "ST21";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // --- Add Card definitions here ---
        // ST21-001 Monkey D. Luffy - Leader
        Card card1 = new Card();
        card1.setCardNumber(setCode + "-001");
        card1.setName("Monkey D. Luffy");
        card1.setCardType("Leader");
        card1.setColor("Red");
        card1.setCost(5);
        card1.setPower(5000);
        card1.setLife(5);
        card1.setAttribute("Strike");
        card1.setEffect("DON!!×1 Activate: Main Once Per Turn Give one of your characters up to 2 rested Don!! cards.");
        card1.setAffiliations("Four Emperors / Straw Hat Crew");
        card1.setImagePath("/images/cards/" + setCode + "/" + setCode + "-001.jpg");
        card1.setSet(setCode);
        Card savedCard1 = cardRepository.save(card1);
        System.out.println("Saved card " + savedCard1.getCardNumber());
        
        // ST21-002 Usopp - Character
        Card card2 = new Card();
        card2.setCardNumber(setCode + "-002");
        card2.setName("Usopp");
        card2.setCardType("Character");
        card2.setColor("Red");
        card2.setCost(2);
        card2.setPower(3000);
        card2.setCounter(2000);
        card2.setAttribute("Strike");
        card2.setEffect("DON!!×2 Opponent's Turn This Character gains +2000 power.");
        card2.setAffiliations("Straw Hat Crew");
        card2.setImagePath("/images/cards/" + setCode + "/" + setCode + "-002.jpg");
        card2.setSet(setCode);
        Card savedCard2 = cardRepository.save(card2);
        System.out.println("Saved card " + savedCard2.getCardNumber());
        
        // ST21-003 Sanji - Character
        Card card3 = new Card();
        card3.setCardNumber(setCode + "-003");
        card3.setName("Sanji");
        card3.setCardType("Character");
        card3.setColor("Red");
        card3.setCost(2);
        card3.setPower(3000);
        card3.setCounter(2000);
        card3.setAttribute("Strike");
        card3.setEffect("On Play Choose up to 1 of your (Straw Hat Crew) type Characters with a Power of 6000 or more. During this turn, your opponent may not activate Blocker when that character attacks.");
        card3.setAffiliations("Straw Hat Crew");
        card3.setImagePath("/images/cards/" + setCode + "/" + setCode + "-003.jpg");
        card3.setSet(setCode);
        Card savedCard3 = cardRepository.save(card3);
        System.out.println("Saved card " + savedCard3.getCardNumber());
        
        // ST21-004 Jewelry Bonney - Character
        Card card4 = new Card();
        card4.setCardNumber(setCode + "-004");
        card4.setName("Jewelry Bonney");
        card4.setCardType("Character");
        card4.setColor("Red");
        card4.setCost(1);
        card4.setPower(3000);
        card4.setCounter(0);
        card4.setAttribute("Special");
        card4.setEffect("DON!!×2 On K.O. Draw a card.");
        card4.setAffiliations("Egghead / Bonney Pirates");
        card4.setImagePath("/images/cards/" + setCode + "/" + setCode + "-004.jpg");
        card4.setSet(setCode);
        Card savedCard4 = cardRepository.save(card4);
        System.out.println("Saved card " + savedCard4.getCardNumber());
        
        // ST21-005 Jinbe - Character
        Card card5 = new Card();
        card5.setCardNumber(setCode + "-005");
        card5.setName("Jinbe");
        card5.setCardType("Character");
        card5.setColor("Red");
        card5.setCost(2);
        card5.setPower(4000);
        card5.setCounter(1000);
        card5.setAttribute("Strike");
        card5.setEffect("");
        card5.setAffiliations("Fishmen/Straw Hat Pirates");
        card5.setImagePath("/images/cards/" + setCode + "/" + setCode + "-005.jpg");
        card5.setSet(setCode);
        Card savedCard5 = cardRepository.save(card5);
        System.out.println("Saved card " + savedCard5.getCardNumber());
        
        // ST21-006 Stussy - Character
        Card card6 = new Card();
        card6.setCardNumber(setCode + "-006");
        card6.setName("Stussy");
        card6.setCardType("Character");
        card6.setColor("Red");
        card6.setCost(3);
        card6.setPower(5000);
        card6.setCounter(1000);
        card6.setAttribute("Special");
        card6.setEffect("");
        card6.setAffiliations("Egghead");
        card6.setImagePath("/images/cards/" + setCode + "/" + setCode + "-006.jpg");
        card6.setSet(setCode);
        Card savedCard6 = cardRepository.save(card6);
        System.out.println("Saved card " + savedCard6.getCardNumber());
        
        // ST21-007 Sentomaru - Character
        Card card7 = new Card();
        card7.setCardNumber(setCode + "-007");
        card7.setName("Sentomaru");
        card7.setCardType("Character");
        card7.setColor("Red");
        card7.setCost(2);
        card7.setPower(2000);
        card7.setCounter(1000);
        card7.setAttribute("Slash");
        card7.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        card7.setAffiliations("Egghead/Navy");
        card7.setImagePath("/images/cards/" + setCode + "/" + setCode + "-007.jpg");
        card7.setSet(setCode);
        Card savedCard7 = cardRepository.save(card7);
        System.out.println("Saved card " + savedCard7.getCardNumber());
        
        // ST21-008 Tony Tony Chopper - Character
        Card card8 = new Card();
        card8.setCardNumber(setCode + "-008");
        card8.setName("Tony Tony Chopper");
        card8.setCardType("Character");
        card8.setColor("Red");
        card8.setCost(4);
        card8.setPower(6000);
        card8.setCounter(1000);
        card8.setAttribute("Wisdom");
        card8.setEffect("");
        card8.setAffiliations("Animal/Straw Hat Crew");
        card8.setImagePath("/images/cards/" + setCode + "/" + setCode + "-008.jpg");
        card8.setSet(setCode);
        Card savedCard8 = cardRepository.save(card8);
        System.out.println("Saved card " + savedCard8.getCardNumber());
        
        // ST21-009 Nami - Character
        Card card9 = new Card();
        card9.setCardNumber(setCode + "-009");
        card9.setName("Nami");
        card9.setCardType("Character");
        card9.setColor("Red");
        card9.setCost(3);
        card9.setPower(1000);
        card9.setCounter(1000);
        card9.setAttribute("Special");
        card9.setEffect("Activate: Main Once Per Turn Give up to 2 rested DON!! cards to 1 of your (Straw Hat Crew) type Leader or Characters.");
        card9.setAffiliations("Straw Hat Crew");
        card9.setImagePath("/images/cards/" + setCode + "/" + setCode + "-009.jpg");
        card9.setSet(setCode);
        Card savedCard9 = cardRepository.save(card9);
        System.out.println("Saved card " + savedCard9.getCardNumber());
        
        // ST21-010 Nico Robin - Character
        Card card10 = new Card();
        card10.setCardNumber(setCode + "-010");
        card10.setName("Nico Robin");
        card10.setCardType("Character");
        card10.setColor("Red");
        card10.setCost(3);
        card10.setPower(4000);
        card10.setCounter(1000);
        card10.setAttribute("Strike");
        card10.setEffect("DON!!×2 When Attacking KO up to one of your opponents characters with a power of 4000 or less.");
        card10.setAffiliations("Straw Hat Crew");
        card10.setImagePath("/images/cards/" + setCode + "/" + setCode + "-010.jpg");
        card10.setSet(setCode);
        Card savedCard10 = cardRepository.save(card10);
        System.out.println("Saved card " + savedCard10.getCardNumber());
        
        // ST21-011 Franky - Character
        Card card11 = new Card();
        card11.setCardNumber(setCode + "-011");
        card11.setName("Franky");
        card11.setCardType("Character");
        card11.setColor("Red");
        card11.setCost(3);
        card11.setPower(4000);
        card11.setCounter(1000);
        card11.setAttribute("Strike");
        card11.setEffect("DON!!×2 Opponent's Turn All of your (Straw Hat Crew) type Characters with an original base power of 4000 or less gain +1000 power.");
        card11.setAffiliations("Straw Hat Crew");
        card11.setImagePath("/images/cards/" + setCode + "/" + setCode + "-011.jpg");
        card11.setSet(setCode);
        Card savedCard11 = cardRepository.save(card11);
        System.out.println("Saved card " + savedCard11.getCardNumber());
        
        // ST21-012 Brook - Character
        Card card12 = new Card();
        card12.setCardNumber(setCode + "-012");
        card12.setName("Brook");
        card12.setCardType("Character");
        card12.setColor("Red");
        card12.setCost(3);
        card12.setPower(4000);
        card12.setCounter(1000);
        card12.setAttribute("Slash");
        card12.setEffect("When Attacking Give up to 2 rested DON!! cards to your Leader or 1 of your Characters.");
        card12.setAffiliations("Straw Hat Crew");
        card12.setImagePath("/images/cards/" + setCode + "/" + setCode + "-012.jpg");
        card12.setSet(setCode);
        Card savedCard12 = cardRepository.save(card12);
        System.out.println("Saved card " + savedCard12.getCardNumber());
        
        // ST21-013 Vegapunk - Character
        Card card13 = new Card();
        card13.setCardNumber(setCode + "-013");
        card13.setName("Vegapunk");
        card13.setCardType("Character");
        card13.setColor("Red");
        card13.setCost(1);
        card13.setPower(3000);
        card13.setCounter(1000);
        card13.setAttribute("Wisdom");
        card13.setEffect("");
        card13.setAffiliations("Scientist/Egghead");
        card13.setImagePath("/images/cards/" + setCode + "/" + setCode + "-013.jpg");
        card13.setSet(setCode);
        Card savedCard13 = cardRepository.save(card13);
        System.out.println("Saved card " + savedCard13.getCardNumber());
        
        // ST21-014 Monkey D. Luffy - Character
        Card card14 = new Card();
        card14.setCardNumber(setCode + "-014");
        card14.setName("Monkey D. Luffy");
        card14.setCardType("Character");
        card14.setColor("Red");
        card14.setCost(5);
        card14.setPower(6000);
        card14.setCounter(0);
        card14.setAttribute("Strike");
        card14.setEffect("Rush (This card can attack on the turn in which it is played.) When Attacking Give your leader or up to 1 of your characters 1 rested Don!! card.");
        card14.setAffiliations("Four Emperors / Straw Hat Pirates");
        card14.setImagePath("/images/cards/" + setCode + "/" + setCode + "-014.jpg");
        card14.setSet(setCode);
        Card savedCard14 = cardRepository.save(card14);
        System.out.println("Saved card " + savedCard14.getCardNumber());
        
        // ST21-015 Roronoa Zoro - Character
        Card card15 = new Card();
        card15.setCardNumber(setCode + "-015");
        card15.setName("Roronoa Zoro");
        card15.setCardType("Character");
        card15.setColor("Red");
        card15.setCost(4);
        card15.setPower(5000);
        card15.setCounter(1000);
        card15.setAttribute("Slash");
        card15.setEffect("DON!!×2 This character gains Rush. On K.O. You may play a Red character with 6000 base power or below other than 'Roronoa Zoro' from your hand.");
        card15.setAffiliations("Straw Hat Pirates");
        card15.setImagePath("/images/cards/" + setCode + "/" + setCode + "-015.jpg");
        card15.setSet(setCode);
        Card savedCard15 = cardRepository.save(card15);
        System.out.println("Saved card " + savedCard15.getCardNumber());
        
        // ST21-016 Gum Gum Dawn Whip - Event
        Card card16 = new Card();
        card16.setCardNumber(setCode + "-016");
        card16.setName("Gum Gum Dawn Whip");
        card16.setCardType("Event");
        card16.setColor("Red");
        card16.setCost(2);
        card16.setEffect("Main Give up to one of your leaders or characters +1000 power during this turn. Then, up to one of your opponent's character with a power of 4000 or less power cannot activate Blocker during this turn. Trigger K.O. up to one of your opponent's characters with a power of 4000 or less.");
        card16.setAffiliations("Four Emperors / Straw Hat Crew");
        card16.setImagePath("/images/cards/" + setCode + "/" + setCode + "-016.jpg");
        card16.setSet(setCode);
        Card savedCard16 = cardRepository.save(card16);
        System.out.println("Saved card " + savedCard16.getCardNumber());
        
        // ST21-017 Gum-Gum Mole Gun - Event
        Card card17 = new Card();
        card17.setCardNumber(setCode + "-017");
        card17.setName("Gum-Gum Mole Gun");
        card17.setCardType("Event");
        card17.setColor("Red");
        card17.setCost(4);
        card17.setEffect("Main Give up to one of your opponent's characters - 5000 power during this turn. Then, if you have a character with 6000 power or more, KO up to one of your opponents characters with a power of 2000 or less. Trigger Activate this card's Main effect.");
        card17.setAffiliations("Four Emperors / Straw Hat Crew");
        card17.setImagePath("/images/cards/" + setCode + "/" + setCode + "-017.jpg");
        card17.setSet(setCode);
        Card savedCard17 = cardRepository.save(card17);
        System.out.println("Saved card " + savedCard17.getCardNumber());

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 