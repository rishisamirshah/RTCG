package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.config.BaseInitializer;
import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(19) // Order after ST08
public class ST09Initializer extends BaseInitializer {

    private final CardRepository cardRepository;

    @Autowired
    public ST09Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    protected void initialize(String... args) throws Exception {
        String setCode = "ST09";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // --- Add Card definitions here ---
        
        // Yamato (Leader) - ST09-001
        Card card1 = new Card();
        card1.setName("Yamato");
        card1.setCardNumber("ST09-001");
        card1.setCardType("Leader");
        card1.setColor("Yellow");
        card1.setLife(5);
        card1.setPower(5000);
        card1.setAttribute("Strike");
        card1.setTiming("Opponent's Turn");
        card1.setEffect("DON!! ×1 While your Life area has 2 or less cards, this Leader gains +1000 Power.");
        card1.setAffiliations("Land of Wano");
        card1.setImagePath("/images/cards/ST09/ST09-001.png");
        card1.setSet(setCode);
        cardRepository.save(card1);
        
        // Uzuki Tempura - ST09-002
        Card card2 = new Card();
        card2.setName("Uzuki Tempura");
        card2.setCardNumber("ST09-002");
        card2.setCardType("Character");
        card2.setColor("Yellow");
        card2.setCost(4);
        card2.setPower(5000);
        card2.setCounter(1000);
        card2.setAttribute("Strike");
        card2.setTrigger("Rest up to 1 of your opponent's Characters with a cost of 2 or less, and add this card to your hand.");
        card2.setAffiliations("Land of Wano");
        card2.setImagePath("/images/cards/ST09/ST09-002.png");
        card2.setSet(setCode);
        cardRepository.save(card2);
        
        // Ulti - ST09-003
        Card card3 = new Card();
        card3.setName("Ulti");
        card3.setCardNumber("ST09-003");
        card3.setCardType("Character");
        card3.setColor("Yellow");
        card3.setCost(4);
        card3.setPower(6000);
        card3.setCounter(1000);
        card3.setAttribute("Strike");
        card3.setAffiliations("Animal Kingdom Pirates");
        card3.setImagePath("/images/cards/ST09/ST09-003.png");
        card3.setSet(setCode);
        cardRepository.save(card3);
        
        // Kaido - ST09-004
        Card card4 = new Card();
        card4.setName("Kaido");
        card4.setCardNumber("ST09-004");
        card4.setCardType("Character");
        card4.setColor("Purple");
        card4.setCost(4);
        card4.setPower(5000);
        card4.setCounter(1000);
        card4.setAttribute("Special");
        card4.setEffect("DON!! ×1 While you have 2 cards or less in your life area, this Character can't be K.O'ed in battle.");
        card4.setAffiliations("Four Emperors/Animal Kingdom Pirates");
        card4.setImagePath("/images/cards/ST09/ST09-004.png");
        card4.setSet(setCode);
        cardRepository.save(card4);
        
        // Kozuki Oden - ST09-005
        Card card5 = new Card();
        card5.setName("Kozuki Oden");
        card5.setCardNumber("ST09-005");
        card5.setCardType("Character");
        card5.setColor("Yellow");
        card5.setCost(7);
        card5.setPower(7000);
        card5.setAttribute("Strike");
        card5.setEffect("DON!! ×1 This character gains Double Attack (This card deals 2 damage).\nOn K.O. You may trash 2 cards from your hand: Add up to 1 card from the top of your deck to the top of your Life Area.");
        card5.setAffiliations("Land of Wano/Kozuki Family");
        card5.setImagePath("/images/cards/ST09/ST09-005.png");
        card5.setSet(setCode);
        cardRepository.save(card5);
        
        // Kozuki Momonosuke - ST09-006
        Card card6 = new Card();
        card6.setName("Kozuki Momonosuke");
        card6.setCardNumber("ST09-006");
        card6.setCardType("Character");
        card6.setColor("Purple");
        card6.setCost(2);
        card6.setPower(4000);
        card6.setCounter(1000);
        card6.setAttribute("Special");
        card6.setAffiliations("Land of Wano/Kozuki Family");
        card6.setImagePath("/images/cards/ST09/ST09-006.png");
        card6.setSet(setCode);
        cardRepository.save(card6);
        
        // Shinobu - ST09-007
        Card card7 = new Card();
        card7.setName("Shinobu");
        card7.setCardNumber("ST09-007");
        card7.setCardType("Character");
        card7.setColor("Purple");
        card7.setCost(3);
        card7.setPower(2000);
        card7.setAttribute("Special");
        card7.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\nOn Block You may add 1 card from the top or bottom of your Life area to your hand: This Character gains +4000 Power during this battle.");
        card7.setAffiliations("Land of Wano");
        card7.setImagePath("/images/cards/ST09/ST09-007.png");
        card7.setSet(setCode);
        cardRepository.save(card7);
        
        // Shimotsuki Ushimaru - ST09-008
        Card card8 = new Card();
        card8.setName("Shimotsuki Ushimaru");
        card8.setCardNumber("ST09-008");
        card8.setCardType("Character");
        card8.setColor("Yellow");
        card8.setCost(5);
        card8.setPower(6000);
        card8.setAttribute("Strike");
        card8.setTiming("When Attacking");
        card8.setEffect("DON!! ×1 You may add the top or bottom card of your Life area to your hand: Play up to 1 yellow {Land of Wano} type Character card with a cost of 4 or less from your hand.");
        card8.setAffiliations("Land of Wano");
        card8.setImagePath("/images/cards/ST09/ST09-008.png");
        card8.setSet(setCode);
        cardRepository.save(card8);
        
        // Fuugetsu Omusubi - ST09-009
        Card card9 = new Card();
        card9.setName("Fuugetsu Omusubi");
        card9.setCardNumber("ST09-009");
        card9.setCardType("Character");
        card9.setColor("Yellow");
        card9.setCost(3);
        card9.setPower(4000);
        card9.setCounter(1000);
        card9.setAttribute("Strike");
        card9.setTrigger("K.O. up to 1 of your opponent's Characters with a cost of 1 or less, and add this card to your hand.");
        card9.setAffiliations("Land of Wano");
        card9.setImagePath("/images/cards/ST09/ST09-009.png");
        card9.setSet(setCode);
        cardRepository.save(card9);
        
        // Portgas D. Ace - ST09-010
        Card card10 = new Card();
        card10.setName("Portgas D. Ace");
        card10.setCardNumber("ST09-010");
        card10.setCardType("Character");
        card10.setColor("Purple");
        card10.setCost(6);
        card10.setPower(7000);
        card10.setAttribute("Special");
        card10.setTiming("Once Per Turn");
        card10.setEffect("If this character would be K.O'ed, you can trash 1 card from the top or bottom of your Life Area instead");
        card10.setAffiliations("Wano Country/Whitebeard Pirates");
        card10.setImagePath("/images/cards/ST09/ST09-010.png");
        card10.setSet(setCode);
        cardRepository.save(card10);
        
        // Monkey D. Luffy - ST09-011
        Card card11 = new Card();
        card11.setName("Monkey D. Luffy");
        card11.setCardNumber("ST09-011");
        card11.setCardType("Character");
        card11.setColor("Yellow");
        card11.setCost(3);
        card11.setPower(5000);
        card11.setCounter(1000);
        card11.setAttribute("Strike");
        card11.setAffiliations("Land of Wano/Straw Hat Crew");
        card11.setImagePath("/images/cards/ST09/ST09-011.png");
        card11.setSet(setCode);
        cardRepository.save(card11);
        
        // Yamato (Character) - ST09-012
        Card card12 = new Card();
        card12.setName("Yamato");
        card12.setCardNumber("ST09-012");
        card12.setCardType("Character");
        card12.setColor("Yellow");
        card12.setCost(3);
        card12.setPower(3000);
        card12.setCounter(2000);
        card12.setAttribute("Strike");
        card12.setTiming("When Attacking");
        card12.setEffect("You may add the top or bottom card of your Life area to your hand: This Character gains +2000 Power until the start of your next turn.");
        card12.setAffiliations("Land of Wano");
        card12.setImagePath("/images/cards/ST09/ST09-012.png");
        card12.setSet(setCode);
        cardRepository.save(card12);
        
        // Yamato (Character) - ST09-013
        Card card13 = new Card();
        card13.setName("Yamato");
        card13.setCardNumber("ST09-013");
        card13.setCardType("Character");
        card13.setColor("Purple");
        card13.setCost(5);
        card13.setPower(7000);
        card13.setCounter(1000);
        card13.setAttribute("Special");
        card13.setAffiliations("Land of Wano");
        card13.setImagePath("/images/cards/ST09/ST09-013.png");
        card13.setSet(setCode);
        cardRepository.save(card13);
        
        // Narikabura Arrow - ST09-014
        Card card14 = new Card();
        card14.setName("Narikabura Arrow");
        card14.setCardNumber("ST09-014");
        card14.setCardType("Event");
        card14.setColor("Yellow");
        card14.setCost(1);
        card14.setAttribute("Strike");
        card14.setTiming("Counter");
        card14.setEffect("If you have 2 or less cards in your life area, give up to 1 of your opponent's Leader or Characters -3000 Power during this turn.");
        card14.setTrigger("You may trash 2 cards from your hand: You may place up to 1 card from the top of your deck at the top of your Life area.");
        card14.setAffiliations("Land of Wano");
        card14.setImagePath("/images/cards/ST09/ST09-014.png");
        card14.setSet(setCode);
        cardRepository.save(card14);
        
        // Thunder Bagua - ST09-015
        Card card15 = new Card();
        card15.setName("Thunder Bagua");
        card15.setCardNumber("ST09-015");
        card15.setCardType("Event");
        card15.setColor("Yellow");
        card15.setCost(2);
        card15.setAttribute("Strike");
        card15.setTiming("Counter");
        card15.setEffect("Up to 1 of your Leader or Characters gains +4000 Power during this battle. Then, if you have 2 or less cards in your life area, place up to 1 of your opponent's Characters with a cost of 3 or less face down at the top or bottom of their Life.");
        card15.setTrigger("Draw 1 card.");
        card15.setAffiliations("Land of Wano");
        card15.setImagePath("/images/cards/ST09/ST09-015.png");
        card15.setSet(setCode);
        cardRepository.save(card15);

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 