package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(15) // Order after ST04
public class ST05Initializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public ST05Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        String setCode = "ST05";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // --- Add Card definitions here ---
        
        // ST05-001: Shanks (Leader)
        Card shanksLeader = new Card();
        shanksLeader.setCardNumber("ST05-001");
        shanksLeader.setName("Shanks");
        shanksLeader.setCardType("Leader");
        shanksLeader.setColor("Purple");
        shanksLeader.setPower(5000);
        shanksLeader.setLife(5);
        shanksLeader.setAttribute("Slash");
        shanksLeader.setAffiliations("FILM/The Four Emperors/Red Hair Pirates");
        shanksLeader.setEffect("Activate: Main Once Per Turn DON!! -3 (You may return the specified number of DON!! cards from your field to your DON!! deck): Your {FILM} type Characters gain +2000 Power during this turn.");
        shanksLeader.setImagePath("/images/cards/ST05/ST05-001.png");
        cardRepository.save(shanksLeader);

        // ST05-002: Ain
        Card ain = new Card();
        ain.setCardNumber("ST05-002");
        ain.setName("Ain");
        ain.setCardType("Character");
        ain.setColor("Purple");
        ain.setCost(4);
        ain.setPower(5000);
        ain.setCounter(1000);
        ain.setAttribute("Special");
        ain.setAffiliations("FILM/Neo Navy");
        ain.setEffect("On Play Add 1 DON!! card from your DON!! deck and rest it.");
        ain.setImagePath("/images/cards/ST05/ST05-002.png");
        cardRepository.save(ain);

        // ST05-003: Ann
        Card ann = new Card();
        ann.setCardNumber("ST05-003");
        ann.setName("Ann");
        ann.setCardType("Character");
        ann.setColor("Purple");
        ann.setCost(2);
        ann.setPower(3000);
        ann.setCounter(1000);
        ann.setAttribute("Special");
        ann.setAffiliations("FILM/Pirate Fest");
        ann.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        ann.setImagePath("/images/cards/ST05/ST05-003.png");
        cardRepository.save(ann);

        // ST05-004: Uta
        Card uta = new Card();
        uta.setCardNumber("ST05-004");
        uta.setName("Uta");
        uta.setCardType("Character");
        uta.setColor("Purple");
        uta.setCost(4);
        uta.setPower(5000);
        uta.setCounter(1000);
        uta.setAttribute("Special");
        uta.setAffiliations("FILM");
        uta.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\\\nOn Block DON!! -1 (You may return the specified number of DON!! cards from your field to your DON!! deck): Rest up to 1 of your opponent's Characters with a cost of 5 or less.");
        uta.setImagePath("/images/cards/ST05/ST05-004.png");
        cardRepository.save(uta);

        // ST05-005: Carina
        Card carina = new Card();
        carina.setCardNumber("ST05-005");
        carina.setName("Carina");
        carina.setCardType("Character");
        carina.setColor("Purple");
        carina.setCost(2);
        carina.setPower(3000);
        carina.setCounter(1000);
        carina.setAttribute("Wisdom");
        carina.setAffiliations("FILM/Gran Tesoro");
        carina.setEffect("Activate: Main Once Per Turn Rest this Character, you may trash 1 {FILM} type card from your hand: If your opponent has more DON!! cards on their field than you, add 2 DON!! cards from your DON!! deck and rest them.");
        carina.setImagePath("/images/cards/ST05/ST05-005.png");
        cardRepository.save(carina);

        // ST05-006: Gild Tesoro
        Card gildTesoro = new Card();
        gildTesoro.setCardNumber("ST05-006");
        gildTesoro.setName("Gild Tesoro");
        gildTesoro.setCardType("Character");
        gildTesoro.setColor("Purple");
        gildTesoro.setCost(5);
        gildTesoro.setPower(6000);
        gildTesoro.setAttribute("Special");
        gildTesoro.setAffiliations("FILM/Gran Tesoro");
        gildTesoro.setEffect("When Attacking DON!! -2 (You may return the specified number of DON!! cards from your field to your DON!! deck): Draw 2 cards.");
        gildTesoro.setImagePath("/images/cards/ST05/ST05-006.png");
        cardRepository.save(gildTesoro);

        // ST05-007: Gordon
        Card gordon = new Card();
        gordon.setCardNumber("ST05-007");
        gordon.setName("Gordon");
        gordon.setCardType("Character");
        gordon.setColor("Purple");
        gordon.setCost(1);
        gordon.setPower(3000);
        gordon.setCounter(1000);
        gordon.setAttribute("Wisdom");
        gordon.setAffiliations("FILM");
        gordon.setImagePath("/images/cards/ST05/ST05-007.png");
        cardRepository.save(gordon);

        // ST05-008: Shiki
        Card shiki = new Card();
        shiki.setCardNumber("ST05-008");
        shiki.setName("Shiki");
        shiki.setCardType("Character");
        shiki.setColor("Purple");
        shiki.setCost(6);
        shiki.setPower(7000);
        shiki.setCounter(1000);
        shiki.setAttribute("Slash");
        shiki.setAffiliations("FILM/Golden Lion Pirates");
        shiki.setEffect("If you have 8 or more DON!! cards on your field, this Character cannot be K.O'd in battle.");
        shiki.setImagePath("/images/cards/ST05/ST05-008.png");
        cardRepository.save(shiki);

        // ST05-009: Scarlet
        Card scarlet = new Card();
        scarlet.setCardNumber("ST05-009");
        scarlet.setName("Scarlet");
        scarlet.setCardType("Character");
        scarlet.setColor("Purple");
        scarlet.setCost(2);
        scarlet.setPower(3000);
        scarlet.setCounter(1000);
        scarlet.setAttribute("Strike");
        scarlet.setAffiliations("FILM/Animal/Golden Lion Pirates");
        scarlet.setTrigger("Play this card.");
        scarlet.setImagePath("/images/cards/ST05/ST05-009.png");
        cardRepository.save(scarlet);

        // ST05-010: Z
        Card z = new Card();
        z.setCardNumber("ST05-010");
        z.setName("Z");
        z.setCardType("Character");
        z.setColor("Purple");
        z.setCost(7);
        z.setPower(8000);
        z.setCounter(1000);
        z.setAttribute("Strike");
        z.setAffiliations("FILM/NEO Navy");
        z.setEffect("If this Character battles with a (Strike) attribute Character, this Character gains +3000 Power during this turn.\\\\nActivate: Main Once Per Turn DON!! -1 (You may return the specified number of DON!! cards from your field to your DON!! deck): This Character gains +2000 Power during this turn.");
        z.setImagePath("/images/cards/ST05/ST05-010.png");
        cardRepository.save(z);

        // ST05-011: Douglass Bullet
        Card douglassBullet = new Card();
        douglassBullet.setCardNumber("ST05-011");
        douglassBullet.setName("Douglass Bullet");
        douglassBullet.setCardType("Character");
        douglassBullet.setColor("Purple");
        douglassBullet.setCost(8);
        douglassBullet.setPower(10000);
        douglassBullet.setAttribute("Special");
        douglassBullet.setAffiliations("FILM/Pirate Fest");
        douglassBullet.setEffect("Activate: Main Once Per Turn DON!! -4 (You may return the specified number of DON!! cards from your field to your DON!! deck): Rest up to 2 of your opponent's Characters with a cost of 6 or less. Then, this Character gains Double Attack during this turn. (This card deals 2 damage.)");
        douglassBullet.setImagePath("/images/cards/ST05/ST05-011.png");
        cardRepository.save(douglassBullet);

        // ST05-012: Baccarat
        Card baccarat = new Card();
        baccarat.setCardNumber("ST05-012");
        baccarat.setName("Baccarat");
        baccarat.setCardType("Character");
        baccarat.setColor("Purple");
        baccarat.setCost(3);
        baccarat.setPower(5000);
        baccarat.setCounter(1000);
        baccarat.setAttribute("Special");
        baccarat.setAffiliations("FILM/Gran Tesoro");
        baccarat.setImagePath("/images/cards/ST05/ST05-012.png");
        cardRepository.save(baccarat);

        // ST05-013: Binz
        Card binz = new Card();
        binz.setCardNumber("ST05-013");
        binz.setName("Binz");
        binz.setCardType("Character");
        binz.setColor("Purple");
        binz.setCost(4);
        binz.setPower(6000);
        binz.setCounter(1000);
        binz.setAttribute("Special");
        binz.setAffiliations("FILM/Neo Navy");
        binz.setImagePath("/images/cards/ST05/ST05-013.png");
        cardRepository.save(binz);

        // ST05-014: Buena Fiesta
        Card buenaFiesta = new Card();
        buenaFiesta.setCardNumber("ST05-014");
        buenaFiesta.setName("Buena Fiesta");
        buenaFiesta.setCardType("Character");
        buenaFiesta.setColor("Purple");
        buenaFiesta.setCost(1);
        buenaFiesta.setPower(0);
        buenaFiesta.setCounter(2000);
        buenaFiesta.setAttribute("Wisdom");
        buenaFiesta.setAffiliations("FILM/Pirate Fest");
        buenaFiesta.setEffect("On Play Look at 5 cards from the top of your deck; reveal up to 1 {FILM} type card other than [Buena Fiesta] and add it to your hand. Then, place the rest at the bottom of your deck in any order.");
        buenaFiesta.setImagePath("/images/cards/ST05/ST05-014.png");
        cardRepository.save(buenaFiesta);

        // ST05-015: Dr. Indigo
        Card drIndigo = new Card();
        drIndigo.setCardNumber("ST05-015");
        drIndigo.setName("Dr. Indigo");
        drIndigo.setCardType("Character");
        drIndigo.setColor("Purple");
        drIndigo.setCost(2);
        drIndigo.setPower(4000);
        drIndigo.setCounter(1000);
        drIndigo.setAttribute("Wisdom");
        drIndigo.setAffiliations("FILM/Scientist/Golden Lion Pirates");
        drIndigo.setImagePath("/images/cards/ST05/ST05-015.png");
        cardRepository.save(drIndigo);

        // ST05-016: Lion's Threat: Imperial Earth Bind
        Card lionsImperial = new Card();
        lionsImperial.setCardNumber("ST05-016");
        lionsImperial.setName("Lion's Threat: Imperial Earth Bind");
        lionsImperial.setCardType("Event");
        lionsImperial.setColor("Purple");
        lionsImperial.setCost(3);
        lionsImperial.setAffiliations("FILM/Golden Lion Pirates");
        lionsImperial.setEffect("Main DON!! -2 (You may return the specified number of DON!! cards from your field to your DON!! deck): K.O. up to 1 of your opponent's Characters with a cost of 5 or less.");
        lionsImperial.setTrigger("Add 1 DON!! card from your DON!! deck and set it as active.");
        lionsImperial.setImagePath("/images/cards/ST05/ST05-016.png");
        cardRepository.save(lionsImperial);

        // ST05-017: Union Armado
        Card unionArmado = new Card();
        unionArmado.setCardNumber("ST05-017");
        unionArmado.setName("Union Armado");
        unionArmado.setCardType("Event");
        unionArmado.setColor("Purple");
        unionArmado.setCost(2);
        unionArmado.setAffiliations("FILM/Pirate Fest");
        unionArmado.setEffect("Counter Up to 1 of your {FILM} type Leader or Characters gains +4000 Power during this battle. If that card is a Character, that Character cannot be K.O'd during this turn.");
        unionArmado.setTrigger("Add 1 DON!! card from your DON!! deck and set it as active.");
        unionArmado.setImagePath("/images/cards/ST05/ST05-017.png");
        cardRepository.save(unionArmado);

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 