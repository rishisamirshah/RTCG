package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(11) // Assuming OP10Initializer is Order 10
public class ST01Initializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public ST01Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        String setCode = "ST01";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // --- Add Card definitions here ---
        // Card Data for ST01
        
        // ST01-001: Monkey D. Luffy (Leader)
        Card luffyLeader = new Card();
        luffyLeader.setCardNumber("ST01-001");
        luffyLeader.setName("Monkey D. Luffy");
        luffyLeader.setCardType("Leader");
        luffyLeader.setColor("Red");
        luffyLeader.setPower(5000);
        luffyLeader.setLife(5);
        luffyLeader.setAttribute("Strike");
        luffyLeader.setAffiliations("Supernovas/Straw Hat Crew");
        luffyLeader.setEffect("Activate: Main Once Per Turn Give this Leader or up to 1 of your Characters 1 rested DON!! card.");
        luffyLeader.setImagePath("/images/cards/ST01/ST01-001.png");
        cardRepository.save(luffyLeader);

        // ST01-002: Usopp
        Card usopp = new Card();
        usopp.setCardNumber("ST01-002");
        usopp.setName("Usopp");
        usopp.setCardType("Character");
        usopp.setColor("Red");
        usopp.setCost(2);
        usopp.setPower(2000);
        usopp.setCounter(1000);
        usopp.setAttribute("Ranged");
        usopp.setAffiliations("Straw Hat Crew");
        usopp.setEffect("DON!!x2 When Attacking Your opponent cannot activate a Blocker Character that has 5000 or more Power during this battle.\\nTrigger Play this card.");
        usopp.setImagePath("/images/cards/ST01/ST01-002.png");
        cardRepository.save(usopp);

        // ST01-003: Karoo
        Card karoo = new Card();
        karoo.setCardNumber("ST01-003");
        karoo.setName("Karoo");
        karoo.setCardType("Character");
        karoo.setColor("Red");
        karoo.setCost(1);
        karoo.setPower(3000);
        karoo.setCounter(1000);
        karoo.setAttribute("Strike");
        karoo.setAffiliations("Animal/Alabasta");
        // karoo.setEffect(null); // No effect
        karoo.setImagePath("/images/cards/ST01/ST01-003.png");
        cardRepository.save(karoo);

        // ST01-004: Sanji
        Card sanji = new Card();
        sanji.setCardNumber("ST01-004");
        sanji.setName("Sanji");
        sanji.setCardType("Character");
        sanji.setColor("Red");
        sanji.setCost(2);
        sanji.setPower(4000);
        // sanji.setCounter(null); // No counter
        sanji.setAttribute("Strike");
        sanji.setAffiliations("Straw Hat Crew");
        sanji.setEffect("DON!!x2 This Character gains Rush. (This card can attack on the turn in which it is played.)");
        sanji.setImagePath("/images/cards/ST01/ST01-004.png");
        cardRepository.save(sanji);

        // ST01-005: Jinbe
        Card jinbe = new Card();
        jinbe.setCardNumber("ST01-005");
        jinbe.setName("Jinbe");
        jinbe.setCardType("Character");
        jinbe.setColor("Red");
        jinbe.setCost(3);
        jinbe.setPower(5000);
        // jinbe.setCounter(null); // No counter
        jinbe.setAttribute("Strike");
        jinbe.setAffiliations("Fish-Man/Straw Hat Crew");
        jinbe.setEffect("DON!!x1 When Attacking Your Leader or up to 1 of your Characters other than this card gains +1000 Power during this turn.");
        jinbe.setImagePath("/images/cards/ST01/ST01-005.png");
        cardRepository.save(jinbe);

        // ST01-006: Tony Tony.Chopper
        Card chopper = new Card();
        chopper.setCardNumber("ST01-006");
        chopper.setName("Tony Tony.Chopper");
        chopper.setCardType("Character");
        chopper.setColor("Red");
        chopper.setCost(1);
        chopper.setPower(1000);
        // chopper.setCounter(null); // No counter
        chopper.setAttribute("Strike");
        chopper.setAffiliations("Animal/Straw Hat Crew");
        chopper.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        chopper.setImagePath("/images/cards/ST01/ST01-006.png");
        cardRepository.save(chopper);

        // ST01-007: Nami
        Card nami = new Card();
        nami.setCardNumber("ST01-007");
        nami.setName("Nami");
        nami.setCardType("Character");
        nami.setColor("Red");
        nami.setCost(1);
        nami.setPower(1000);
        nami.setCounter(1000);
        nami.setAttribute("Special");
        nami.setAffiliations("Straw Hat Crew");
        nami.setEffect("Activate: Main Once Per Turn Give up to 1 rested DON!! card to your Leader or 1 of your Characters.");
        nami.setImagePath("/images/cards/ST01/ST01-007.png");
        cardRepository.save(nami);

        // ST01-008: Nico Robin
        Card robin = new Card();
        robin.setCardNumber("ST01-008");
        robin.setName("Nico Robin");
        robin.setCardType("Character");
        robin.setColor("Red");
        robin.setCost(3);
        robin.setPower(5000);
        robin.setCounter(1000);
        robin.setAttribute("Wisdom");
        robin.setAffiliations("Straw Hat Crew");
        // robin.setEffect(null); // No effect
        robin.setImagePath("/images/cards/ST01/ST01-008.png");
        cardRepository.save(robin);

        // ST01-009: Nefertari Vivi
        Card vivi = new Card();
        vivi.setCardNumber("ST01-009");
        vivi.setName("Nefertari Vivi");
        vivi.setCardType("Character");
        vivi.setColor("Red");
        vivi.setCost(2);
        vivi.setPower(4000);
        vivi.setCounter(1000);
        vivi.setAttribute("Slash");
        vivi.setAffiliations("Alabasta");
        // vivi.setEffect(null); // No effect
        vivi.setImagePath("/images/cards/ST01/ST01-009.png");
        cardRepository.save(vivi);

        // ST01-010: Franky
        Card franky = new Card();
        franky.setCardNumber("ST01-010");
        franky.setName("Franky");
        franky.setCardType("Character");
        franky.setColor("Red");
        franky.setCost(4);
        franky.setPower(6000);
        franky.setCounter(1000);
        franky.setAttribute("Strike");
        franky.setAffiliations("Straw Hat Crew");
        // franky.setEffect(null); // No effect
        franky.setImagePath("/images/cards/ST01/ST01-010.png");
        cardRepository.save(franky);

        // ST01-011: Brook
        Card brook = new Card();
        brook.setCardNumber("ST01-011");
        brook.setName("Brook");
        brook.setCardType("Character");
        brook.setColor("Red");
        brook.setCost(2);
        brook.setPower(3000);
        brook.setCounter(2000);
        brook.setAttribute("Slash");
        brook.setAffiliations("Straw Hat Crew");
        brook.setEffect("On Play Give up to 2 rested DON!! cards to your Leader or 1 of your Characters.");
        brook.setImagePath("/images/cards/ST01/ST01-011.png");
        cardRepository.save(brook);

        // ST01-012: Monkey D. Luffy (Character)
        Card luffyChar = new Card();
        luffyChar.setCardNumber("ST01-012");
        luffyChar.setName("Monkey D. Luffy");
        luffyChar.setCardType("Character");
        luffyChar.setColor("Red");
        luffyChar.setCost(5);
        luffyChar.setPower(6000);
        // luffyChar.setCounter(null); // No counter
        luffyChar.setAttribute("Strike");
        luffyChar.setAffiliations("Supernovas/Straw Hat Crew");
        luffyChar.setEffect("Rush (This card can attack on the turn in which it is played.)\\nDON!!x2 When Attacking Your opponent cannot activate Blocker during this battle.");
        luffyChar.setImagePath("/images/cards/ST01/ST01-012.png");
        cardRepository.save(luffyChar);

        // ST01-013: Roronoa Zoro
        Card zoro = new Card();
        zoro.setCardNumber("ST01-013");
        zoro.setName("Roronoa Zoro");
        zoro.setCardType("Character");
        zoro.setColor("Red");
        zoro.setCost(3);
        zoro.setPower(5000);
        // zoro.setCounter(null); // No counter
        zoro.setAttribute("Slash");
        zoro.setAffiliations("Supernovas/Straw Hat Crew");
        zoro.setEffect("DON!!x1 This Character gains +1000 power.");
        zoro.setImagePath("/images/cards/ST01/ST01-013.png");
        cardRepository.save(zoro);

        // ST01-014: Guard Point
        Card guardPoint = new Card();
        guardPoint.setCardNumber("ST01-014");
        guardPoint.setName("Guard Point");
        guardPoint.setCardType("Event");
        guardPoint.setColor("Red");
        guardPoint.setCost(1);
        // guardPoint.setCounter(null); // No counter
        guardPoint.setAffiliations("Animal/Straw Hat Crew");
        guardPoint.setEffect("Counter Your Leader or up to 1 of your Characters gains +3000 power during this battle.\\nTrigger Your Leader or up to 1 of your Characters gains +1000 power during this turn.");
        guardPoint.setImagePath("/images/cards/ST01/ST01-014.png");
        cardRepository.save(guardPoint);

        // ST01-015: Gum-Gum Jet Pistol
        Card jetPistol = new Card();
        jetPistol.setCardNumber("ST01-015");
        jetPistol.setName("Gum-Gum Jet Pistol");
        jetPistol.setCardType("Event");
        jetPistol.setColor("Red");
        jetPistol.setCost(4);
        // jetPistol.setCounter(null); // No counter
        jetPistol.setAffiliations("Supernovas/Straw Hat Crew");
        jetPistol.setEffect("Main K.O. up to 1 of your opponent's Characters with 6000 power or less.\\nTrigger Activate this card's Main effect.");
        jetPistol.setImagePath("/images/cards/ST01/ST01-015.png");
        cardRepository.save(jetPistol);

        // ST01-016: Diable Jambe
        Card diableJambe = new Card();
        diableJambe.setCardNumber("ST01-016");
        diableJambe.setName("Diable Jambe");
        diableJambe.setCardType("Event");
        diableJambe.setColor("Red");
        diableJambe.setCost(1);
        // diableJambe.setCounter(null); // No counter
        diableJambe.setAffiliations("Straw Hat Crew");
        diableJambe.setEffect("Main Select up to 1 of your {Straw Hat Crew} type Leader or Character cards. Your opponent cannot activate Blocker if that Leader or Character attacks during this turn.\\nTrigger K.O. up to 1 of your opponent's Blocker Characters with a cost of 3 or less.");
        diableJambe.setImagePath("/images/cards/ST01/ST01-016.png");
        cardRepository.save(diableJambe);

        // ST01-017: Thousand Sunny
        Card thousandSunny = new Card();
        thousandSunny.setCardNumber("ST01-017");
        thousandSunny.setName("Thousand Sunny");
        thousandSunny.setCardType("Stage");
        thousandSunny.setColor("Red");
        thousandSunny.setCost(2);
        // thousandSunny.setCounter(null); // No counter
        thousandSunny.setAffiliations("Straw Hat Crew");
        thousandSunny.setEffect("Activate: Main You may rest this Stage: Up to 1 {Straw Hat Crew} type Leader or Character card on your field gains +1000 Power during this turn.");
        thousandSunny.setImagePath("/images/cards/ST01/ST01-017.png");
        cardRepository.save(thousandSunny);
        // -------------------------------

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 