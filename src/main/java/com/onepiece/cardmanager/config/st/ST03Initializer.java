package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(13) // Order after ST02
public class ST03Initializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public ST03Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        String setCode = "ST03";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // --- Add Card definitions here ---
        // Card Data for ST03

        // ST03-001: Crocodile (Leader)
        Card crocoLeader = new Card();
        crocoLeader.setCardNumber("ST03-001");
        crocoLeader.setName("Crocodile");
        crocoLeader.setCardType("Leader");
        crocoLeader.setColor("Blue");
        crocoLeader.setPower(5000);
        crocoLeader.setLife(5);
        crocoLeader.setAttribute("Special"); // Attribute inferred, might need adjustment
        crocoLeader.setAffiliations("The Seven Warlords of the Sea/Baroque Works");
        crocoLeader.setEffect("Activate: Main Once Per Turn DON!! -4 (You may return the specified number of DON!! cards from your field to your DON!! deck): Return up to 1 Character with a cost of 5 or less to the owner's hand.");
        crocoLeader.setImagePath("/images/cards/ST03/ST03-001.png");
        cardRepository.save(crocoLeader);

        // ST03-002: Edward Weevil
        Card weevil = new Card();
        weevil.setCardNumber("ST03-002");
        weevil.setName("Edward Weevil");
        weevil.setCardType("Character");
        weevil.setColor("Blue");
        weevil.setCost(3);
        weevil.setPower(5000);
        weevil.setCounter(1000);
        weevil.setAttribute("Slash");
        weevil.setAffiliations("The Seven Warlords of the Sea");
        // weevil.setEffect(null); // No effect
        weevil.setImagePath("/images/cards/ST03/ST03-002.png");
        cardRepository.save(weevil);

        // ST03-003: Crocodile (Character)
        Card crocoChar = new Card();
        crocoChar.setCardNumber("ST03-003");
        crocoChar.setName("Crocodile");
        crocoChar.setCardType("Character");
        crocoChar.setColor("Blue");
        crocoChar.setCost(5);
        crocoChar.setPower(6000);
        // crocoChar.setCounter(null); // No counter
        crocoChar.setAttribute("Special");
        crocoChar.setAffiliations("The Seven Warlords of the Sea/Baroque Works");
        crocoChar.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\nDON!!x1 On Block Place up to 1 Character with a cost of 2 or less at the bottom of the owner's deck.");
        crocoChar.setImagePath("/images/cards/ST03/ST03-003.png");
        cardRepository.save(crocoChar);

        // ST03-004: Gecko Moria
        Card moria = new Card();
        moria.setCardNumber("ST03-004");
        moria.setName("Gecko Moria");
        moria.setCardType("Character");
        moria.setColor("Blue");
        moria.setCost(4);
        moria.setPower(5000);
        moria.setCounter(1000);
        moria.setAttribute("Special");
        moria.setAffiliations("The Seven Warlords of the Sea/Thriller Bark Pirates");
        moria.setEffect("On Play Add up to 1 {The Seven Warlords of the Sea} or {Thriller Bark Pirates} type Character with a cost of 4 or less other than [Gecko Moria] from your trash to your hand.");
        moria.setImagePath("/images/cards/ST03/ST03-004.png");
        cardRepository.save(moria);

        // ST03-005: Dracule Mihawk
        Card mihawk = new Card();
        mihawk.setCardNumber("ST03-005");
        mihawk.setName("Dracule Mihawk");
        mihawk.setCardType("Character");
        mihawk.setColor("Blue");
        mihawk.setCost(4);
        mihawk.setPower(5000);
        mihawk.setCounter(2000);
        mihawk.setAttribute("Slash");
        mihawk.setAffiliations("The Seven Warlords of the Sea");
        mihawk.setEffect("DON!!x1 When Attacking Draw 2 cards and trash 2 cards from your hand.");
        mihawk.setImagePath("/images/cards/ST03/ST03-005.png");
        cardRepository.save(mihawk);

        // ST03-006: Jinbe
        Card jinbe = new Card();
        jinbe.setCardNumber("ST03-006");
        jinbe.setName("Jinbe");
        jinbe.setCardType("Character");
        jinbe.setColor("Blue");
        jinbe.setCost(2);
        jinbe.setPower(4000);
        jinbe.setCounter(1000);
        jinbe.setAttribute("Strike");
        jinbe.setAffiliations("Fish-Man/The Seven Warlords of the Sea/Sun Pirates");
        // jinbe.setEffect(null); // No effect
        jinbe.setImagePath("/images/cards/ST03/ST03-006.png");
        cardRepository.save(jinbe);

        // ST03-007: Sentomaru
        Card sentomaru = new Card();
        sentomaru.setCardNumber("ST03-007");
        sentomaru.setName("Sentomaru");
        sentomaru.setCardType("Character");
        sentomaru.setColor("Blue");
        sentomaru.setCost(3);
        sentomaru.setPower(4000);
        sentomaru.setCounter(1000);
        sentomaru.setAttribute("Slash");
        sentomaru.setAffiliations("Navy");
        sentomaru.setEffect("DON!!x1 Activate: Main Once Per Turn [2] (You may rest the specified number of DON!! cards in your Cost Area): Play up to 1 [Pacifista] with a cost of 4 or less from your deck, then shuffle your deck.");
        sentomaru.setImagePath("/images/cards/ST03/ST03-007.png");
        cardRepository.save(sentomaru);

        // ST03-008: Trafalgar Law
        Card law = new Card();
        law.setCardNumber("ST03-008");
        law.setName("Trafalgar Law");
        law.setCardType("Character");
        law.setColor("Blue");
        law.setCost(1);
        law.setPower(1000);
        // law.setCounter(null); // No counter
        law.setAttribute("Slash");
        law.setAffiliations("The Seven Warlords of the Sea/Heart Pirates");
        law.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        law.setImagePath("/images/cards/ST03/ST03-008.png");
        cardRepository.save(law);

        // ST03-009: Donquixote Doflamingo
        Card doffy = new Card();
        doffy.setCardNumber("ST03-009");
        doffy.setName("Donquixote Doflamingo");
        doffy.setCardType("Character");
        doffy.setColor("Blue");
        doffy.setCost(7);
        doffy.setPower(7000);
        // doffy.setCounter(null); // No counter
        doffy.setAttribute("Special");
        doffy.setAffiliations("The Seven Warlords of the Sea/Donquixote Pirates");
        doffy.setEffect("On Play Return up to 1 Character with a cost of 7 or less to the owner's hand.");
        doffy.setImagePath("/images/cards/ST03/ST03-009.png");
        cardRepository.save(doffy);

        // ST03-010: Bartholomew Kuma
        Card kuma = new Card();
        kuma.setCardNumber("ST03-010");
        kuma.setName("Bartholomew Kuma");
        kuma.setCardType("Character");
        kuma.setColor("Blue");
        kuma.setCost(2);
        kuma.setPower(3000);
        // kuma.setCounter(null); // No counter
        kuma.setAttribute("Strike");
        kuma.setAffiliations("The Seven Warlords of the Sea/Revolutionary Army");
        kuma.setEffect("On Play Look at 3 cards from the top of your deck and return them to the top or bottom of the deck in any order.\\nTrigger Play this card.");
        kuma.setImagePath("/images/cards/ST03/ST03-010.png");
        cardRepository.save(kuma);

        // ST03-011: Buggy
        Card buggy = new Card();
        buggy.setCardNumber("ST03-011");
        buggy.setName("Buggy");
        buggy.setCardType("Character");
        buggy.setColor("Blue");
        buggy.setCost(1);
        buggy.setPower(3000);
        buggy.setCounter(1000);
        buggy.setAttribute("Slash");
        buggy.setAffiliations("The Seven Warlords of the Sea/Buggy's Delivery");
        // buggy.setEffect(null); // No effect
        buggy.setImagePath("/images/cards/ST03/ST03-011.png");
        cardRepository.save(buggy);

        // ST03-012: Pacifista
        Card pacifista = new Card();
        pacifista.setCardNumber("ST03-012");
        pacifista.setName("Pacifista");
        pacifista.setCardType("Character");
        pacifista.setColor("Blue");
        pacifista.setCost(4);
        pacifista.setPower(6000);
        pacifista.setCounter(1000);
        pacifista.setAttribute("Special"); // Inferred from similar cards, adjust if needed
        pacifista.setAffiliations("Biological Weapon/Navy");
        // pacifista.setEffect(null); // No effect
        pacifista.setImagePath("/images/cards/ST03/ST03-012.png");
        cardRepository.save(pacifista);

        // ST03-013: Boa Hancock
        Card hancock = new Card();
        hancock.setCardNumber("ST03-013");
        hancock.setName("Boa Hancock");
        hancock.setCardType("Character");
        hancock.setColor("Blue");
        hancock.setCost(3);
        hancock.setPower(1000);
        hancock.setCounter(1000);
        hancock.setAttribute("Special");
        hancock.setAffiliations("The Seven Warlords of the Sea/Kuja Pirates");
        hancock.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\nTrigger Play this card.");
        hancock.setImagePath("/images/cards/ST03/ST03-013.png");
        cardRepository.save(hancock);

        // ST03-014: Marshall.D.Teach
        Card teach = new Card();
        teach.setCardNumber("ST03-014");
        teach.setName("Marshall.D.Teach");
        teach.setCardType("Character");
        teach.setColor("Blue");
        teach.setCost(4);
        teach.setPower(4000);
        teach.setCounter(1000);
        teach.setAttribute("Special");
        teach.setAffiliations("The Seven Warlords of the Sea/Blackbeard Pirates");
        teach.setEffect("On Play Return up to 1 Character with a cost of 3 or less to the owner's hand.");
        teach.setImagePath("/images/cards/ST03/ST03-014.png");
        cardRepository.save(teach);

        // ST03-015: Sables
        Card sables = new Card();
        sables.setCardNumber("ST03-015");
        sables.setName("Sables");
        sables.setCardType("Event");
        sables.setColor("Blue");
        sables.setCost(4);
        // sables.setCounter(null);
        sables.setAffiliations("The Seven Warlords of the Sea/Baroque Works");
        sables.setEffect("Main Return up to 1 Character with a cost of 7 or less to the owner's hand.\\nTrigger Activate this card's Main effect.");
        sables.setImagePath("/images/cards/ST03/ST03-015.png");
        cardRepository.save(sables);

        // ST03-016: Thrust Pad Cannon
        Card thrustPadCannon = new Card();
        thrustPadCannon.setCardNumber("ST03-016");
        thrustPadCannon.setName("Thrust Pad Cannon");
        thrustPadCannon.setCardType("Event");
        thrustPadCannon.setColor("Blue");
        thrustPadCannon.setCost(2);
        // thrustPadCannon.setCounter(null);
        thrustPadCannon.setAffiliations("The Seven Warlords of the Sea/Revolutionary Army");
        thrustPadCannon.setEffect("Counter Return up to 1 Character with a cost of 3 or less to the owner's hand.\\nTrigger Activate this card's Counter effect.");
        thrustPadCannon.setImagePath("/images/cards/ST03/ST03-016.png");
        cardRepository.save(thrustPadCannon);

        // ST03-017: Love-Love Beam
        Card loveLoveBeam = new Card();
        loveLoveBeam.setCardNumber("ST03-017");
        loveLoveBeam.setName("Love-Love Beam");
        loveLoveBeam.setCardType("Event");
        loveLoveBeam.setColor("Blue");
        loveLoveBeam.setCost(2);
        // loveLoveBeam.setCounter(null);
        loveLoveBeam.setAffiliations("The Seven Warlords of the Sea/Kuja Pirates");
        loveLoveBeam.setEffect("Counter Your Leader or up to 1 of your Characters gains +4000 power during this battle. Then, draw 1 card if you have 3 or less cards in your hand.");
        loveLoveBeam.setImagePath("/images/cards/ST03/ST03-017.png");
        cardRepository.save(loveLoveBeam);

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 