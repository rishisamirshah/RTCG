package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(14) // Order after ST03
public class ST04Initializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public ST04Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        String setCode = "ST04";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // --- Add Card definitions here ---
        // Card Data for ST04

        // ST04-001: Kaido (Leader)
        Card kaidoLeader = new Card();
        kaidoLeader.setCardNumber("ST04-001");
        kaidoLeader.setName("Kaido");
        kaidoLeader.setCardType("Leader");
        kaidoLeader.setColor("Purple");
        kaidoLeader.setPower(5000);
        kaidoLeader.setLife(5);
        kaidoLeader.setAttribute("Strike");
        kaidoLeader.setAffiliations("The Four Emperors/Animal Kingdom Pirates");
        kaidoLeader.setEffect("Activate: Main Once Per Turn DON!! -7 (You may return the specified number of DON!! cards from your field to your DON!! deck): Trash 1 of your opponents Life cards.");
        kaidoLeader.setImagePath("/images/cards/ST04/ST04-001.png");
        cardRepository.save(kaidoLeader);

        // ST04-002: Ulti
        Card ulti = new Card();
        ulti.setCardNumber("ST04-002");
        ulti.setName("Ulti");
        ulti.setCardType("Character");
        ulti.setColor("Purple");
        ulti.setCost(4);
        ulti.setPower(5000);
        ulti.setCounter(2000);
        ulti.setAttribute("Strike");
        ulti.setAffiliations("Animal Kingdom Pirates");
        ulti.setEffect("On Play DON!! -1 (You may return the specified number of DON!! cards from your field to your DON!! deck): Play 1 [Page One] card with a cost of 4 or less from your hand.");
        ulti.setImagePath("/images/cards/ST04/ST04-002.png");
        cardRepository.save(ulti);

        // ST04-003: Kaido (Character)
        Card kaidoChar = new Card();
        kaidoChar.setCardNumber("ST04-003");
        kaidoChar.setName("Kaido");
        kaidoChar.setCardType("Character");
        kaidoChar.setColor("Purple");
        kaidoChar.setCost(9);
        kaidoChar.setPower(10000);
        // kaidoChar.setCounter(null); // No counter
        kaidoChar.setAttribute("Strike");
        kaidoChar.setAffiliations("The Four Emperors/Animal Kingdom Pirates");
        kaidoChar.setEffect("On Play DON!! -5 (You may return the specified number of DON!! cards from your field to your DON!! deck): K.O. 1 of your opponent's Characters with a cost of 6 or less. This Character gains Rush during this turn. (This card can attack on the turn in which it is played)");
        kaidoChar.setImagePath("/images/cards/ST04/ST04-003.png");
        cardRepository.save(kaidoChar);

        // ST04-004: King
        Card king = new Card();
        king.setCardNumber("ST04-004");
        king.setName("King");
        king.setCardType("Character");
        king.setColor("Purple");
        king.setCost(6);
        king.setPower(7000);
        // king.setCounter(null); // No counter
        king.setAttribute("Special");
        king.setAffiliations("Animal Kingdom Pirates");
        king.setEffect("On Play DON!! -1 (You may return the specified number of DON!! cards from your field to your DON!! deck): K.O. 1 of your opponent's Characters with a cost of 4 or less.");
        king.setImagePath("/images/cards/ST04/ST04-004.png");
        cardRepository.save(king);

        // ST04-005: Queen
        Card queen = new Card();
        queen.setCardNumber("ST04-005");
        queen.setName("Queen");
        queen.setCardType("Character");
        queen.setColor("Purple");
        queen.setCost(5);
        queen.setPower(6000);
        queen.setCounter(1000);
        queen.setAttribute("Strike");
        queen.setAffiliations("Animal Kingdom Pirates");
        queen.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\\\nOn Play DON!! -1 (You may return the specified number of DON!! cards from your field to your DON!! deck): Draw 2 cards and trash 1 card from your hand.");
        queen.setImagePath("/images/cards/ST04/ST04-005.png");
        cardRepository.save(queen);

        // ST04-006: Sasaki
        Card sasaki = new Card();
        sasaki.setCardNumber("ST04-006");
        sasaki.setName("Sasaki");
        sasaki.setCardType("Character");
        sasaki.setColor("Purple");
        sasaki.setCost(3);
        sasaki.setPower(4000);
        sasaki.setCounter(1000);
        sasaki.setAttribute("Ranged");
        sasaki.setAffiliations("Animal Kingdom Pirates");
        sasaki.setEffect("On Play DON!! -1 (You may return the specified number of DON!! cards from your field to your DON!! deck): Draw 1 card.");
        sasaki.setImagePath("/images/cards/ST04/ST04-006.png");
        cardRepository.save(sasaki);

        // ST04-007: Sheepshead
        Card sheepshead = new Card();
        sheepshead.setCardNumber("ST04-007");
        sheepshead.setName("Sheepshead");
        sheepshead.setCardType("Character");
        sheepshead.setColor("Purple");
        sheepshead.setCost(2);
        sheepshead.setPower(4000);
        sheepshead.setCounter(1000);
        sheepshead.setAttribute("Slash");
        sheepshead.setAffiliations("Animal Kingdom Pirates/Smile");
        // sheepshead.setEffect(null); // No effect
        sheepshead.setImagePath("/images/cards/ST04/ST04-007.png");
        cardRepository.save(sheepshead);

        // ST04-008: Jack
        Card jack = new Card();
        jack.setCardNumber("ST04-008");
        jack.setName("Jack");
        jack.setCardType("Character");
        jack.setColor("Purple");
        jack.setCost(3);
        jack.setPower(4000);
        jack.setCounter(1000);
        jack.setAttribute("Strike");
        jack.setAffiliations("Animal Kingdom Pirates");
        jack.setEffect("On Play You may trash 1 card from your hand: Add 1 card from your DON!! deck and set it as active.");
        jack.setImagePath("/images/cards/ST04/ST04-008.png");
        cardRepository.save(jack);

        // ST04-009: Ginrummy
        Card ginrummy = new Card();
        ginrummy.setCardNumber("ST04-009");
        ginrummy.setName("Ginrummy");
        ginrummy.setCardType("Character");
        ginrummy.setColor("Purple");
        ginrummy.setCost(1);
        ginrummy.setPower(3000);
        ginrummy.setCounter(1000);
        ginrummy.setAttribute("Strike");
        ginrummy.setAffiliations("Animal Kingdom Pirates/Smile");
        // ginrummy.setEffect(null); // No effect
        ginrummy.setImagePath("/images/cards/ST04/ST04-009.png");
        cardRepository.save(ginrummy);

        // ST04-010: Who's.Who
        Card whosWho = new Card();
        whosWho.setCardNumber("ST04-010");
        whosWho.setName("Who's.Who");
        whosWho.setCardType("Character");
        whosWho.setColor("Purple");
        whosWho.setCost(3);
        whosWho.setPower(3000);
        // whosWho.setCounter(null); // No counter
        whosWho.setAttribute("Slash");
        whosWho.setAffiliations("Animal Kingdom Pirates");
        whosWho.setEffect("On Play DON!! -1 (You may return the specified number of DON!! cards from your field to your DON!! deck): K.O. 1 of your opponent's Characters with a cost of 3 or less.\\\\nTrigger Play this card");
        whosWho.setImagePath("/images/cards/ST04/ST04-010.png");
        cardRepository.save(whosWho);

        // ST04-011: Black Maria
        Card blackMaria = new Card();
        blackMaria.setCardNumber("ST04-011");
        blackMaria.setName("Black Maria");
        blackMaria.setCardType("Character");
        blackMaria.setColor("Purple");
        blackMaria.setCost(2);
        blackMaria.setPower(2000);
        blackMaria.setCounter(1000);
        blackMaria.setAttribute("Special");
        blackMaria.setAffiliations("Animal Kingdom Pirates");
        blackMaria.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        blackMaria.setImagePath("/images/cards/ST04/ST04-011.png");
        cardRepository.save(blackMaria);

        // ST04-012: Page One
        Card pageOne = new Card();
        pageOne.setCardNumber("ST04-012");
        pageOne.setName("Page One");
        pageOne.setCardType("Character");
        pageOne.setColor("Purple");
        pageOne.setCost(4);
        pageOne.setPower(6000);
        pageOne.setCounter(1000);
        pageOne.setAttribute("Strike");
        pageOne.setAffiliations("Animal Kingdom Pirates");
        pageOne.setEffect("");
        pageOne.setImagePath("/images/cards/ST04/ST04-012.png");
        cardRepository.save(pageOne);

        // ST04-013: X.Drake
        Card xDrake = new Card();
        xDrake.setCardNumber("ST04-013");
        xDrake.setName("X.Drake");
        xDrake.setCardType("Character");
        xDrake.setColor("Purple");
        xDrake.setCost(3);
        xDrake.setPower(5000);
        xDrake.setCounter(1000);
        xDrake.setAttribute("Slash");
        xDrake.setAffiliations("Navy/Drake Pirates/Animal Kingdom Pirates");
        xDrake.setEffect("");
        xDrake.setImagePath("/images/cards/ST04/ST04-013.png");
        cardRepository.save(xDrake);

        // ST04-014: Lead Performer "Disaster"
        Card leadPerformer = new Card();
        leadPerformer.setCardNumber("ST04-014");
        leadPerformer.setName("Lead Performer \"Disaster\"");
        leadPerformer.setCardType("Event");
        leadPerformer.setColor("Purple");
        leadPerformer.setCost(4);
        leadPerformer.setAffiliations("Animal Kingdom Pirates");
        leadPerformer.setEffect("Main Draw 1 card, then add 1 card from your DON!! deck and set it as active.");
        leadPerformer.setTrigger("Activate this card's Main effect.");
        leadPerformer.setImagePath("/images/cards/ST04/ST04-014.png");
        cardRepository.save(leadPerformer);

        // ST04-015: Brachio Bomber
        Card brachioBomber = new Card();
        brachioBomber.setCardNumber("ST04-015");
        brachioBomber.setName("Brachio Bomber");
        brachioBomber.setCardType("Event");
        brachioBomber.setColor("Purple");
        brachioBomber.setCost(6);
        brachioBomber.setAffiliations("Animal Kingdom Pirates");
        brachioBomber.setEffect("Main K.O. 1 of your opponent's Characters with a cost of 6 or less, then add 1 DON!! card from your DON!! deck and set it as active.");
        brachioBomber.setTrigger("Add 1 DON!! card from your DON!! deck and set it as active.");
        brachioBomber.setImagePath("/images/cards/ST04/ST04-015.png");
        cardRepository.save(brachioBomber);

        // ST04-016: Blast Breath
        Card blastBreath = new Card();
        blastBreath.setCardNumber("ST04-016");
        blastBreath.setName("Blast Breath");
        blastBreath.setCardType("Event");
        blastBreath.setColor("Purple");
        blastBreath.setCost(1);
        blastBreath.setAffiliations("The Four Emperors/Animal Kingdom Pirates");
        blastBreath.setEffect("Counter DON!! -1 (You may return the specified number of DON!! cards from your field to your DON!! deck): Your Leader or 1 of your Character gains +4000 Power during this battle.");
        blastBreath.setImagePath("/images/cards/ST04/ST04-016.png");
        cardRepository.save(blastBreath);

        // ST04-017: Onigashima Island
        Card onigashimaIsland = new Card();
        onigashimaIsland.setCardNumber("ST04-017");
        onigashimaIsland.setName("Onigashima Island");
        onigashimaIsland.setCardType("Stage");
        onigashimaIsland.setColor("Purple");
        onigashimaIsland.setCost(3);
        onigashimaIsland.setAffiliations("Animal Kingdom Pirates");
        onigashimaIsland.setEffect("Activate: Main You may rest this Stage: If your Leader has the {Animal Kingdom Pirates} type, add 1 DON!! card from your DON!! deck and rest it.");
        onigashimaIsland.setImagePath("/images/cards/ST04/ST04-017.png");
        cardRepository.save(onigashimaIsland);

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 