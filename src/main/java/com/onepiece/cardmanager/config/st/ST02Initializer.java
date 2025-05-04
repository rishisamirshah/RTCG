package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.config.BaseInitializer;
import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(12) // Order after ST01
public class ST02Initializer extends BaseInitializer {

    private final CardRepository cardRepository;

    @Autowired
    public ST02Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    protected void initialize(String... args) throws Exception {
        String setCode = "ST02";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // --- Add Card definitions here ---
        // Card Data for ST02

        // ST02-001: Eustass "Captain" Kid (Leader)
        Card kidLeader = new Card();
        kidLeader.setCardNumber("ST02-001");
        kidLeader.setName("Eustass \"Captain\" Kid");
        kidLeader.setCardType("Leader");
        kidLeader.setColor("Green");
        kidLeader.setPower(5000);
        kidLeader.setLife(5);
        kidLeader.setAttribute("Special");
        kidLeader.setAffiliations("Supernovas/Kid Pirates");
        kidLeader.setEffect("Activate: Main Once Per Turn [3] (You may rest the specified number of DON!! cards in your Cost Area): You may trash 1 card from your hand: Set this Leader as active.");
        kidLeader.setImagePath("/images/cards/ST02/ST02-001.png");
        cardRepository.save(kidLeader);

        // ST02-002: Vito
        Card vito = new Card();
        vito.setCardNumber("ST02-002");
        vito.setName("Vito");
        vito.setCardType("Character");
        vito.setColor("Green");
        vito.setCost(3);
        vito.setPower(5000);
        vito.setCounter(1000);
        vito.setAttribute("Ranged");
        vito.setAffiliations("Firetank Pirates");
        // vito.setEffect(null); // No effect
        vito.setImagePath("/images/cards/ST02/ST02-002.png");
        cardRepository.save(vito);

        // ST02-003: Urouge
        Card urouge = new Card();
        urouge.setCardNumber("ST02-003");
        urouge.setName("Urouge");
        urouge.setCardType("Character");
        urouge.setColor("Green");
        urouge.setCost(2);
        urouge.setPower(3000);
        urouge.setCounter(1000);
        urouge.setAttribute("Strike");
        urouge.setAffiliations("Supernovas/Fallen Monk Pirates");
        urouge.setEffect("DON!!x1 If you have 3 or more Characters, this card gains +2000 power.");
        urouge.setImagePath("/images/cards/ST02/ST02-003.png");
        cardRepository.save(urouge);

        // ST02-004: Capone "Gang" Bege
        Card bege = new Card();
        bege.setCardNumber("ST02-004");
        bege.setName("Capone \"Gang\" Bege");
        bege.setCardType("Character");
        bege.setColor("Green");
        bege.setCost(1);
        bege.setPower(1000);
        // bege.setCounter(null); // No counter
        bege.setAttribute("Special");
        bege.setAffiliations("Supernovas/Firetank Pirates");
        bege.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        bege.setImagePath("/images/cards/ST02/ST02-004.png");
        cardRepository.save(bege);

        // ST02-005: Killer
        Card killer = new Card();
        killer.setCardNumber("ST02-005");
        killer.setName("Killer");
        killer.setCardType("Character");
        killer.setColor("Green");
        killer.setCost(3);
        killer.setPower(3000);
        killer.setCounter(1000);
        killer.setAttribute("Slash");
        killer.setAffiliations("Supernovas/Kid Pirates");
        killer.setEffect("On Play K.O. up to 1 of your opponent's rested Characters with a cost of 3 or less.\\nTrigger Play this card.");
        killer.setImagePath("/images/cards/ST02/ST02-005.png");
        cardRepository.save(killer);

        // ST02-006: Koby
        Card koby = new Card();
        koby.setCardNumber("ST02-006");
        koby.setName("Koby");
        koby.setCardType("Character");
        koby.setColor("Green");
        koby.setCost(4);
        koby.setPower(6000);
        koby.setCounter(1000);
        koby.setAttribute("Strike");
        koby.setAffiliations("Navy");
        // koby.setEffect(null); // No effect
        koby.setImagePath("/images/cards/ST02/ST02-006.png");
        cardRepository.save(koby);

        // ST02-007: Jewelry Bonney
        Card bonney = new Card();
        bonney.setCardNumber("ST02-007");
        bonney.setName("Jewelry Bonney");
        bonney.setCardType("Character");
        bonney.setColor("Green");
        bonney.setCost(1);
        bonney.setPower(1000);
        bonney.setCounter(1000);
        bonney.setAttribute("Special");
        bonney.setAffiliations("Supernovas/Bonney Pirates");
        bonney.setEffect("Activate: Main [1] (You may rest the specified number of DON!! cards in your Cost Area) You may rest this card: Look at up to 5 cards from the top of your deck; reveal up to 1 {Supernovas} type card and add it to your hand. Then, place the rest at the bottom of your deck in any order.");
        bonney.setImagePath("/images/cards/ST02/ST02-007.png");
        cardRepository.save(bonney);

        // ST02-008: Scratchmen Apoo
        Card apoo = new Card();
        apoo.setCardNumber("ST02-008");
        apoo.setName("Scratchmen Apoo");
        apoo.setCardType("Character");
        apoo.setColor("Green");
        apoo.setCost(2);
        apoo.setPower(3000);
        apoo.setCounter(2000);
        apoo.setAttribute("Ranged");
        apoo.setAffiliations("Supernovas/On Air Pirates");
        apoo.setEffect("DON!!x1 When Attacking Rest up to 1 of your opponent's DON!! cards.");
        apoo.setImagePath("/images/cards/ST02/ST02-008.png");
        cardRepository.save(apoo);

        // ST02-009: Trafalgar Law
        Card law = new Card();
        law.setCardNumber("ST02-009");
        law.setName("Trafalgar Law");
        law.setCardType("Character");
        law.setColor("Green");
        law.setCost(5);
        law.setPower(6000);
        law.setCounter(1000);
        law.setAttribute("Slash");
        law.setAffiliations("Supernovas/Heart Pirates");
        law.setEffect("On Play Set up to 1 of your {Supernovas} or {Heart Pirates} type rested Characters with a cost of 5 or less as active.");
        law.setImagePath("/images/cards/ST02/ST02-009.png");
        cardRepository.save(law);

        // ST02-010: Basil Hawkins
        Card hawkins = new Card();
        hawkins.setCardNumber("ST02-010");
        hawkins.setName("Basil Hawkins");
        hawkins.setCardType("Character");
        hawkins.setColor("Green");
        hawkins.setCost(5);
        hawkins.setPower(6000);
        // hawkins.setCounter(null); // No counter
        hawkins.setAttribute("Slash");
        hawkins.setAffiliations("Supernovas/Hawkins Pirates");
        hawkins.setEffect("DON!!x1 Once Per Turn Your Turn If this Character battles your opponent's Character, set this card as active.");
        hawkins.setImagePath("/images/cards/ST02/ST02-010.png");
        cardRepository.save(hawkins);

        // ST02-011: Heat
        Card heat = new Card();
        heat.setCardNumber("ST02-011");
        heat.setName("Heat");
        heat.setCardType("Character");
        heat.setColor("Green");
        heat.setCost(2);
        heat.setPower(4000);
        heat.setCounter(1000);
        heat.setAttribute("Special");
        heat.setAffiliations("Kid Pirates");
        // heat.setEffect(null); // No effect
        heat.setImagePath("/images/cards/ST02/ST02-011.png");
        cardRepository.save(heat);

        // ST02-012: Bepo
        Card bepo = new Card();
        bepo.setCardNumber("ST02-012");
        bepo.setName("Bepo");
        bepo.setCardType("Character");
        bepo.setColor("Green");
        bepo.setCost(1);
        bepo.setPower(3000);
        bepo.setCounter(1000);
        bepo.setAttribute("Strike");
        bepo.setAffiliations("Mink Tribe/Heart Pirates");
        // bepo.setEffect(null); // No effect
        bepo.setImagePath("/images/cards/ST02/ST02-012.png");
        cardRepository.save(bepo);

        // ST02-013: Eustass "Captain" Kid (Character)
        Card kidChar = new Card();
        kidChar.setCardNumber("ST02-013");
        kidChar.setName("Eustass \"Captain\" Kid");
        kidChar.setCardType("Character");
        kidChar.setColor("Green");
        kidChar.setCost(7);
        kidChar.setPower(7000);
        // kidChar.setCounter(null); // No counter
        kidChar.setAttribute("Special");
        kidChar.setAffiliations("Supernovas/Kid Pirates");
        kidChar.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\nDON!!x1 End of Your Turn Set this card as active.");
        kidChar.setImagePath("/images/cards/ST02/ST02-013.png");
        cardRepository.save(kidChar);

        // ST02-014: X.Drake
        Card drake = new Card();
        drake.setCardNumber("ST02-014");
        drake.setName("X.Drake");
        drake.setCardType("Character");
        drake.setColor("Green");
        drake.setCost(4);
        drake.setPower(5000);
        drake.setCounter(1000);
        drake.setAttribute("Slash");
        drake.setAffiliations("Navy/Supernovas/Drake Pirates");
        drake.setEffect("DON!!x1 Your Turn If this Character is rested, your {Supernovas} or {Navy} type Leaders and Characters gain +1000 power.");
        drake.setImagePath("/images/cards/ST02/ST02-014.png");
        cardRepository.save(drake);

        // ST02-015: Scalpel
        Card scalpel = new Card();
        scalpel.setCardNumber("ST02-015");
        scalpel.setName("Scalpel");
        scalpel.setCardType("Event");
        scalpel.setColor("Green");
        scalpel.setCost(1);
        // scalpel.setCounter(null); // No counter
        scalpel.setAffiliations("Supernovas/Heart Pirates");
        scalpel.setEffect("Counter Your Leader or up to 1 of your Characters gains +2000 power during this battle. Then, set up to 1 of DON!! cards as active.\\nTrigger Set up to 2 of your DON!! cards as active.");
        scalpel.setImagePath("/images/cards/ST02/ST02-015.png");
        cardRepository.save(scalpel);

        // ST02-016: Repel
        Card repel = new Card();
        repel.setCardNumber("ST02-016");
        repel.setName("Repel");
        repel.setCardType("Event");
        repel.setColor("Green");
        repel.setCost(2);
        // repel.setCounter(null); // No counter
        repel.setAffiliations("Supernovas/Kid Pirates");
        repel.setEffect("Counter Your Leader or up to 1 of your Characters gains +4000 power during this battle. Then, set up to 1 of your DON!! cards as active.");
        repel.setImagePath("/images/cards/ST02/ST02-016.png");
        cardRepository.save(repel);

        // ST02-017: Straw Sword
        Card strawSword = new Card();
        strawSword.setCardNumber("ST02-017");
        strawSword.setName("Straw Sword");
        strawSword.setCardType("Event");
        strawSword.setColor("Green");
        strawSword.setCost(2);
        // strawSword.setCounter(null); // No counter
        strawSword.setAffiliations("Supernovas/Hawkins Pirates");
        strawSword.setEffect("Main Rest up to 1 of your opponent's Characters.\\nTrigger Play up to 1 {Supernovas} type Character or Stage card with a cost of 2 or less from your hand.");
        strawSword.setImagePath("/images/cards/ST02/ST02-017.png");
        cardRepository.save(strawSword);
        // -------------------------------

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 