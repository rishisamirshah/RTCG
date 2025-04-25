package com.onepiece.cardmanager.config;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(9) // Order after OP08
public class OP09Initializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public OP09Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Only initialize if we have no OP09 cards
        if (cardRepository.countBySetAndCardNumberStartingWith("OP09", "OP09") > 0) {
            System.out.println("OP09 cards already exist, skipping initialization");
            return;
        }

        System.out.println("Initializing OP09 cards...");
        
        // Initialize Red cards
        initializeOP09RedCards();

        // Initialize Green cards
        initializeOP09GreenCards();
        
        // Initialize Blue cards
        initializeOP09BlueCards();
        
        // Initialize Purple cards
        initializeOP09PurpleCards();
        
        // Initialize Black cards
        initializeOP09BlackCards();
        
        // Initialize Yellow cards
        initializeOP09YellowCards();

        System.out.println("Finished initializing OP09 cards");
    }

    private void initializeOP09RedCards() {
        System.out.println("Initializing OP09 Red cards...");

        // Leaders
        Card shanksLeader = new Card();
        shanksLeader.setCardNumber("OP09-001");
        shanksLeader.setName("Shanks");
        shanksLeader.setCardType("Leader");
        shanksLeader.setColor("Red");
        shanksLeader.setPower(5000);
        shanksLeader.setLife(5);
        shanksLeader.setAffiliations("The Four Emperors/Red Hair Pirates");
        shanksLeader.setAttribute("Slash");
        shanksLeader.setEffect("[Once Per Turn] You may activate this effect when your opponent attacks. Give up to 1 of your opponent's leader or characters Power -1000 for the turn.");
        shanksLeader.setImagePath("/images/cards/OP09/OP09-001.jpg");
        cardRepository.save(shanksLeader);

        // Characters
        Card utaRed = new Card();
        utaRed.setCardNumber("OP09-002");
        utaRed.setName("Uta");
        utaRed.setCardType("Character");
        utaRed.setColor("Red");
        utaRed.setCost(1);
        utaRed.setPower(2000);
        utaRed.setCounter(1000);
        utaRed.setAffiliations("FILM");
        utaRed.setAttribute("Special");
        utaRed.setEffect("[On Play] Look at the top 5 cards of your deck, reveal up to 1 \"Red Haired Pirates\" card and add it to your hand. Then, place the rest at the bottom of your deck in any order.");
        utaRed.setImagePath("/images/cards/OP09/OP09-002.jpg");
        cardRepository.save(utaRed);

        Card shachiPenguin = new Card();
        shachiPenguin.setCardNumber("OP09-003");
        shachiPenguin.setName("Shachi and Penguin");
        shachiPenguin.setCardType("Character");
        shachiPenguin.setColor("Red");
        shachiPenguin.setCost(4);
        shachiPenguin.setPower(5000);
        shachiPenguin.setCounter(1000);
        shachiPenguin.setAffiliations("Heart Pirates");
        shachiPenguin.setAttribute("Ranged");
        shachiPenguin.setEffect("[When Attacking] Give up to 1 of your opponent's characters Power -2000 for the turn.");
        shachiPenguin.setImagePath("/images/cards/OP09/OP09-003.jpg");
        cardRepository.save(shachiPenguin);

        Card shanksChar = new Card();
        shanksChar.setCardNumber("OP09-004");
        shanksChar.setName("Shanks");
        shanksChar.setCardType("Character");
        shanksChar.setColor("Red");
        shanksChar.setCost(10);
        shanksChar.setPower(12000);
        // No Counter
        shanksChar.setAffiliations("The Four Emperors / Red Hair Pirates");
        shanksChar.setAttribute("Slash");
        shanksChar.setEffect("All of your opponents characters have -1000 power.\\n[Rush] (This card can attack on the turn in which it is played)");
        shanksChar.setImagePath("/images/cards/OP09/OP09-004.jpg");
        cardRepository.save(shanksChar);

        Card silversRayleigh = new Card();
        silversRayleigh.setCardNumber("OP09-005");
        silversRayleigh.setName("Silvers Rayleigh");
        silversRayleigh.setCardType("Character");
        silversRayleigh.setColor("Red");
        silversRayleigh.setCost(5);
        silversRayleigh.setPower(6000);
        silversRayleigh.setCounter(1000);
        silversRayleigh.setAffiliations("Roger Pirates");
        silversRayleigh.setAttribute("Slash");
        silversRayleigh.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[On Play] If your opponent has two or more characters with an original power of 5000 or more, Draw 2 cards and discard 1 card from your hand.");
        silversRayleigh.setImagePath("/images/cards/OP09/OP09-005.jpg");
        cardRepository.save(silversRayleigh);

        Card howlingGabu = new Card();
        howlingGabu.setCardNumber("OP09-006");
        howlingGabu.setName("Howling Gabu");
        howlingGabu.setCardType("Character");
        howlingGabu.setColor("Red");
        howlingGabu.setCost(5);
        howlingGabu.setPower(7000);
        howlingGabu.setCounter(1000);
        howlingGabu.setAffiliations("Red Hair Pirates");
        howlingGabu.setAttribute("Special");
        // No Effect
        howlingGabu.setImagePath("/images/cards/OP09/OP09-006.jpg");
        cardRepository.save(howlingGabu);

        Card heat = new Card();
        heat.setCardNumber("OP09-007");
        heat.setName("Heat");
        heat.setCardType("Character");
        heat.setColor("Red");
        heat.setCost(3);
        heat.setPower(4000);
        heat.setCounter(1000);
        heat.setAffiliations("Kid Pirates");
        heat.setAttribute("Special");
        heat.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[On Play] Give up to 1 of your Power 4000 or lower leaders +1000 power for the turn.");
        heat.setImagePath("/images/cards/OP09/OP09-007.jpg");
        cardRepository.save(heat);

        Card buildingSnake = new Card();
        buildingSnake.setCardNumber("OP09-008");
        buildingSnake.setName("Building Snake");
        buildingSnake.setCardType("Character");
        buildingSnake.setColor("Red");
        buildingSnake.setCost(1);
        buildingSnake.setPower(2000);
        // No Counter
        buildingSnake.setAffiliations("Red Hair Pirates");
        buildingSnake.setAttribute("Slash");
        buildingSnake.setEffect("[Activate: Main] You may place this character on the bottom of its owner's deck: Give up to one of your opponent's characters -3000 power for this turn.");
        buildingSnake.setImagePath("/images/cards/OP09/OP09-008.jpg");
        cardRepository.save(buildingSnake);

        Card bennBeckman = new Card();
        bennBeckman.setCardNumber("OP09-009");
        bennBeckman.setName("Benn Beckman");
        bennBeckman.setCardType("Character");
        bennBeckman.setColor("Red");
        bennBeckman.setCost(7);
        bennBeckman.setPower(7000);
        bennBeckman.setCounter(1000);
        bennBeckman.setAffiliations("Red Hair Pirates");
        bennBeckman.setAttribute("Ranged");
        bennBeckman.setEffect("[On Play] Trash up to 1 of your opponent's Characters with a power of 6000 or less.");
        bennBeckman.setImagePath("/images/cards/OP09/OP09-009.jpg");
        cardRepository.save(bennBeckman);

        Card bonkPunch = new Card();
        bonkPunch.setCardNumber("OP09-010");
        bonkPunch.setName("Bonk Punch");
        bonkPunch.setCardType("Character");
        bonkPunch.setColor("Red");
        bonkPunch.setCost(4);
        bonkPunch.setPower(5000);
        bonkPunch.setCounter(1000);
        bonkPunch.setAffiliations("Red Hair Pirates");
        bonkPunch.setAttribute("Strike");
        bonkPunch.setEffect("[On Play] Play up to 1 \"Monster\" from your hand.\\n[DON!!x1] [When Attacking] This character gains Power +2000 for the turn.");
        bonkPunch.setImagePath("/images/cards/OP09/OP09-010.jpg");
        cardRepository.save(bonkPunch);

        Card hongo = new Card();
        hongo.setCardNumber("OP09-011");
        hongo.setName("Hongo");
        hongo.setCardType("Character");
        hongo.setColor("Red");
        hongo.setCost(3);
        hongo.setPower(3000);
        hongo.setCounter(2000);
        hongo.setAffiliations("Red Hair Pirates");
        hongo.setAttribute("Strike");
        hongo.setEffect("[Activate: Main] You may rest this character: If your leader has the type \"Red Haired Pirates\", give up to 1 of your opponent's characters -2000 power during this turn.");
        hongo.setImagePath("/images/cards/OP09/OP09-011.jpg");
        cardRepository.save(hongo);

        Card monster = new Card();
        monster.setCardNumber("OP09-012");
        monster.setName("Monster");
        monster.setCardType("Character");
        monster.setColor("Red");
        monster.setCost(3);
        monster.setPower(4000);
        monster.setCounter(1000);
        monster.setAffiliations("Animal / Red Hair Pirates");
        monster.setAttribute("Strike");
        monster.setEffect("If your character \"Bonk Punch\" would be KO'd by an effect, you may instead send this Character to the trash.");
        monster.setImagePath("/images/cards/OP09/OP09-012.jpg");
        cardRepository.save(monster);

        Card yasopp = new Card();
        yasopp.setCardNumber("OP09-013");
        yasopp.setName("Yasopp");
        yasopp.setCardType("Character");
        yasopp.setColor("Red");
        yasopp.setCost(5);
        yasopp.setPower(6000);
        yasopp.setCounter(1000);
        yasopp.setAffiliations("Red Hair Pirates");
        yasopp.setAttribute("Ranged");
        yasopp.setEffect("[On Play] Up to one of your leader gains + 1000 power until the end of your opponents next turn.\\n[DON!!x1] [When Attacking] Up to one of your opponents characters gets -1000 power for this turn.");
        yasopp.setImagePath("/images/cards/OP09/OP09-013.jpg");
        cardRepository.save(yasopp);

        Card limejuice = new Card();
        limejuice.setCardNumber("OP09-014");
        limejuice.setName("Limejuice");
        limejuice.setCardType("Character");
        limejuice.setColor("Red");
        limejuice.setCost(3);
        limejuice.setPower(3000);
        limejuice.setCounter(2000);
        limejuice.setAffiliations("Red Hair Pirates");
        limejuice.setAttribute("Special");
        limejuice.setEffect("[On Play] Up to one of your opponents characters with power 4000 or less cannot activate [Blocker] the rest of this turn.");
        limejuice.setImagePath("/images/cards/OP09/OP09-014.jpg");
        cardRepository.save(limejuice);

        Card luckyRoux = new Card();
        luckyRoux.setCardNumber("OP09-015");
        luckyRoux.setName("Lucky Roux");
        luckyRoux.setCardType("Character");
        luckyRoux.setColor("Red");
        luckyRoux.setCost(4);
        luckyRoux.setPower(5000);
        luckyRoux.setCounter(1000);
        luckyRoux.setAffiliations("Red Hair Pirates");
        luckyRoux.setAttribute("Ranged");
        luckyRoux.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[On K.O.] If your Leader has the {Red Hair Pirates} type, K.O. up to 1 of your opponent's Characters with an original power of 6000 or less.");
        luckyRoux.setImagePath("/images/cards/OP09/OP09-015.jpg");
        cardRepository.save(luckyRoux);

        Card rockstar = new Card();
        rockstar.setCardNumber("OP09-016");
        rockstar.setName("Rockstar");
        rockstar.setCardType("Character");
        rockstar.setColor("Red");
        rockstar.setCost(4);
        rockstar.setPower(6000);
        rockstar.setCounter(1000);
        rockstar.setAffiliations("Red Hair Pirates");
        rockstar.setAttribute("Slash");
        // No Effect
        rockstar.setImagePath("/images/cards/OP09/OP09-016.jpg");
        cardRepository.save(rockstar);

        Card wire = new Card();
        wire.setCardNumber("OP09-017");
        wire.setName("Wire");
        wire.setCardType("Character");
        wire.setColor("Red");
        wire.setCost(4);
        wire.setPower(4000);
        wire.setCounter(2000);
        wire.setAffiliations("Kid Pirates");
        wire.setAttribute("Slash");
        wire.setEffect("[DON!!x1] If your leader has Power 7000 or higher and the \"Kid Pirates\" type, this character gains [Rush].");
        wire.setImagePath("/images/cards/OP09/OP09-017.jpg");
        cardRepository.save(wire);

        // Events
        Card getLost = new Card();
        getLost.setCardNumber("OP09-018");
        getLost.setName("Get Lost");
        getLost.setCardType("Event");
        getLost.setColor("Red");
        getLost.setCost(3);
        getLost.setAffiliations("Red Hair Pirates");
        getLost.setEffect("[Main] KO Up To 2 of your opponent's characters with a combined Power of 4000 or less.");
        getLost.setImagePath("/images/cards/OP09/OP09-018.jpg");
        cardRepository.save(getLost);

        Card wontForgive = new Card();
        wontForgive.setCardNumber("OP09-019");
        wontForgive.setName("I won't forgive anyone who messes with my friends!!!!");
        wontForgive.setCardType("Event");
        wontForgive.setColor("Red");
        wontForgive.setCost(2);
        wontForgive.setAffiliations("Red Hair Pirates");
        wontForgive.setEffect("[Main] If your leader has the (Red Hair Pirates) type, give up to one of your opponents characters -3000 power for this turn. Then if your opponent has a character with power 5000 or greater in play, draw a card.\\n[Trigger] Draw a card.");
        wontForgive.setImagePath("/images/cards/OP09/OP09-019.jpg");
        cardRepository.save(wontForgive);

        Card comeOnWellFight = new Card();
        comeOnWellFight.setCardNumber("OP09-020");
        comeOnWellFight.setName("Come on!! We'll fight you!!");
        comeOnWellFight.setCardType("Event");
        comeOnWellFight.setColor("Red");
        comeOnWellFight.setCost(1);
        comeOnWellFight.setAffiliations("The Four Emperors / Red Hair Pirates");
        comeOnWellFight.setEffect("[Activate: Main] You may look at the top 5 cards of your deck, reveal and add one card with the type [Red Hair Pirates] that is not \"Come on!! We'll fight you!!\" To your hand. Then place the rest at the bottom of the deck in the order.\\n[Trigger] Draw one card.");
        comeOnWellFight.setImagePath("/images/cards/OP09/OP09-020.jpg");
        cardRepository.save(comeOnWellFight);
        
        // Add Red Force stage card at OP09-021
        Card redForce = new Card();
        redForce.setCardNumber("OP09-021");
        redForce.setName("Red Force");
        redForce.setCardType("Stage");
        redForce.setColor("Red");
        redForce.setCost(2);
        redForce.setAffiliations("Red Hair Pirates");
        redForce.setEffect("Activate: Main You may rest this stage: If your leader has the {Red Hair Pirates} type, give up to one of your opponent's characters -1000 power for this turn.");
        redForce.setImagePath("/images/cards/OP09/OP09-021.jpg");
        cardRepository.save(redForce);

        System.out.println("Finished initializing OP09 Red cards");
    }

    private void initializeOP09GreenCards() {
        System.out.println("Initializing OP09 Green cards...");

        // Leader
        Card limLeader = new Card();
        limLeader.setCardNumber("OP09-022");
        limLeader.setName("Lim");
        limLeader.setCardType("Leader");
        limLeader.setColor("Green");
        limLeader.setPower(5000);
        limLeader.setLife(4);
        limLeader.setAffiliations("ODYSSEY");
        limLeader.setAttribute("Wisdom");
        limLeader.setEffect("Your characters enter play as rested.\n[Activate: Main] [Once Per Turn] You may rest 3 of your Don!!: Set up to one Don!! from your Don!! deck as rested. Then, play a cost 5 or lower (Odyssey) type character from your hand.");
        limLeader.setImagePath("/images/cards/OP09/OP09-022.jpg");
        cardRepository.save(limLeader);

        // Characters
        Card adio = new Card();
        adio.setCardNumber("OP09-023");
        adio.setName("Adio");
        adio.setCardType("Character");
        adio.setColor("Green");
        adio.setCost(9);
        adio.setPower(9000);
        // No Counter
        adio.setAffiliations("ODYSSEY");
        adio.setAttribute("Special");
        adio.setEffect("[On Play] If your leader has the ODYSSEY type, set up to 3 of your DON!! active.\n[Opponent's Turn] [Once Per Turn] You may rest 1 of your DON!!: up to 1 of your Leader or Characters gains Power +2000 for the battle.");
        adio.setImagePath("/images/cards/OP09/OP09-023.jpg");
        cardRepository.save(adio);

        Card usopp = new Card();
        usopp.setCardNumber("OP09-024");
        usopp.setName("Usopp");
        usopp.setCardType("Character");
        usopp.setColor("Green");
        usopp.setCost(4);
        usopp.setPower(5000);
        usopp.setCounter(1000);
        usopp.setAffiliations("ODYSSEY / Straw Hat Crew");
        usopp.setAttribute("Ranged");
        usopp.setEffect("[On Play] If you have 2 or more rested character, draw 2 cards then discard 2.");
        usopp.setImagePath("/images/cards/OP09/OP09-024.jpg");
        cardRepository.save(usopp);

        Card crocodile = new Card();
        crocodile.setCardNumber("OP09-025");
        crocodile.setName("Crocodile");
        crocodile.setCardType("Character");
        crocodile.setColor("Green");
        crocodile.setCost(4);
        crocodile.setPower(5000);
        crocodile.setCounter(1000);
        crocodile.setAffiliations("ODYSSEY / The Seven Warlords of the Sea / Baroque Works");
        crocodile.setAttribute("Special");
        crocodile.setEffect("If your leader has the <<Odyssey>> type, this character cannot be KOd in battle by leaders.");
        crocodile.setImagePath("/images/cards/OP09/OP09-025.jpg");
        cardRepository.save(crocodile);

        Card sakazuki = new Card();
        sakazuki.setCardNumber("OP09-026");
        sakazuki.setName("Sakazuki");
        sakazuki.setCardType("Character");
        sakazuki.setColor("Green");
        sakazuki.setCost(6);
        sakazuki.setPower(7000);
        // No Counter
        sakazuki.setAffiliations("ODYSSEY / Navy");
        sakazuki.setAttribute("Special");
        sakazuki.setEffect("[On Play] If you have two or more rested characters in play, KO up to one of your opponents cost 5 or lower characters.");
        sakazuki.setImagePath("/images/cards/OP09/OP09-026.jpg");
        cardRepository.save(sakazuki);

        Card sabo = new Card();
        sabo.setCardNumber("OP09-027");
        sabo.setName("Sabo");
        sabo.setCardType("Character");
        sabo.setColor("Green");
        sabo.setCost(5);
        sabo.setPower(6000);
        sabo.setCounter(1000);
        sabo.setAffiliations("ODYSSEY / Revolutionary Army");
        sabo.setAttribute("Special");
        sabo.setEffect("[When Attacking] [Once Per Turn] If you have three or more rested characters in play, draw one card.");
        sabo.setImagePath("/images/cards/OP09/OP09-027.jpg");
        cardRepository.save(sabo);

        Card sanji = new Card();
        sanji.setCardNumber("OP09-028");
        sanji.setName("Sanji");
        sanji.setCardType("Character");
        sanji.setColor("Green");
        sanji.setCost(5);
        sanji.setPower(6000);
        sanji.setCounter(1000);
        sanji.setAffiliations("ODYSSEY / Straw Hat Crew");
        sanji.setAttribute("Strike");
        sanji.setEffect("[On K.O.] You may put the top or bottom card of your life into your hand: Play up to one cost 4 or lower character with the <<Odyssey>> or <<Strawhat Crew>> type from your trash into play as rested.");
        sanji.setImagePath("/images/cards/OP09/OP09-028.jpg");
        cardRepository.save(sanji);

        Card chopper = new Card();
        chopper.setCardNumber("OP09-029");
        chopper.setName("Tony Tony Chopper");
        chopper.setCardType("Character");
        chopper.setColor("Green");
        chopper.setCost(3);
        chopper.setPower(4000);
        chopper.setCounter(1000);
        chopper.setAffiliations("ODYSSEY / Animal / Straw Hat Crew");
        chopper.setAttribute("Strike");
        chopper.setEffect("[End of Your Turn] Set up to 1 of your (ODYSSEY) type Characters with a cost of 4 or less as active.");
        chopper.setImagePath("/images/cards/OP09/OP09-029.jpg");
        cardRepository.save(chopper);

        Card law = new Card();
        law.setCardNumber("OP09-030");
        law.setName("Trafalgar Law");
        law.setCardType("Character");
        law.setColor("Green");
        law.setCost(3);
        law.setPower(4000);
        law.setCounter(1000);
        law.setAffiliations("ODYSSEY / Supernova / Heart Pirates");
        law.setAttribute("Slash");
        law.setEffect("[On Play] You may return one of your characters to your hand: Play up to one cost 3 or lower <<Odyssey>> type character other than [Trafalgar Law] from your hand.");
        law.setImagePath("/images/cards/OP09/OP09-030.jpg");
        cardRepository.save(law);

        Card doflamingo = new Card();
        doflamingo.setCardNumber("OP09-031");
        doflamingo.setName("Donquixote Donflamingo");
        doflamingo.setCardType("Character");
        doflamingo.setColor("Green");
        doflamingo.setCost(5);
        doflamingo.setPower(6000);
        doflamingo.setCounter(1000);
        doflamingo.setAffiliations("ODYSSEY / The Seven Warlords of the Sea / Donquixote Pirates");
        doflamingo.setAttribute("Special");
        doflamingo.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\n[End of Your Turn] If you have two or more rested characters in play, set this character as active.");
        doflamingo.setImagePath("/images/cards/OP09/OP09-031.jpg");
        cardRepository.save(doflamingo);

        Card rosinante = new Card();
        rosinante.setCardNumber("OP09-032");
        rosinante.setName("Donquixote Rosinante");
        rosinante.setCardType("Character");
        rosinante.setColor("Green");
        rosinante.setCost(3);
        rosinante.setPower(4000);
        rosinante.setCounter(1000);
        rosinante.setAffiliations("ODYSSEY / Navy / Donquixote Pirates");
        rosinante.setAttribute("Special");
        rosinante.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\n[When opponent attack] [Once Per Turn] Set this character as active.");
        rosinante.setImagePath("/images/cards/OP09/OP09-032.jpg");
        cardRepository.save(rosinante);

        Card robin = new Card();
        robin.setCardNumber("OP09-033");
        robin.setName("Nico Robin");
        robin.setCardType("Character");
        robin.setColor("Green");
        robin.setCost(4);
        robin.setPower(5000);
        robin.setCounter(1000);
        robin.setAffiliations("ODYSSEY / Straw Hat Crew");
        robin.setAttribute("Strike");
        robin.setEffect("[On Play] If you have two or more rested characters in play, until the end of your opponent's next turn, all of your characters with the <<Odyssey>> or <<Strawhat Crew>> type can't be KOd by effects.");
        robin.setImagePath("/images/cards/OP09/OP09-033.jpg");
        cardRepository.save(robin);

        Card perona = new Card();
        perona.setCardNumber("OP09-034");
        perona.setName("Perona");
        perona.setCardType("Character");
        perona.setColor("Green");
        perona.setCost(1);
        perona.setPower(2000);
        perona.setCounter(2000);
        perona.setAffiliations("Shikkearu Kingdom / Thriller Bark Pirates");
        perona.setAttribute("Special");
        perona.setEffect("[On Play] Look at the top 5 cards of your deck and reveal up to 1 [Thriller Bark Pirates] type card or a \"Dracule Mihawk\" and put it into your hand. Then, place the rest on the bottom of your deck in any order. Then, discard 1 card from your hand.");
        perona.setImagePath("/images/cards/OP09/OP09-034.jpg");
        cardRepository.save(perona);

        Card ace = new Card();
        ace.setCardNumber("OP09-035");
        ace.setName("Portgas.D.Ace");
        ace.setCardType("Character");
        ace.setColor("Green");
        ace.setCost(5);
        ace.setPower(5000);
        ace.setCounter(2000);
        ace.setAffiliations("ODYSSEY / Whitebeard Pirates");
        ace.setAttribute("Special");
        ace.setEffect("[On Play] If you have two or more rested characters in play, rest up to one of your opponents cost 5 or lower characters.");
        ace.setImagePath("/images/cards/OP09/OP09-035.jpg");
        cardRepository.save(ace);

        Card luffy = new Card();
        luffy.setCardNumber("OP09-036");
        luffy.setName("Monkey.D.Luffy");
        luffy.setCardType("Character");
        luffy.setColor("Green");
        luffy.setCost(5);
        luffy.setPower(6000);
        luffy.setCounter(1000);
        luffy.setAffiliations("ODYSSEY / Supernova / Straw Hat Crew");
        luffy.setAttribute("Strike");
        luffy.setEffect("[On Play] If you have 2 or more rested characters, choose up to 1 of your opponent's cost 6 or lower characters or up to 1 of your opponent's DON!! and rest it.");
        luffy.setImagePath("/images/cards/OP09/OP09-036.jpg");
        cardRepository.save(luffy);

        Card limChar = new Card();
        limChar.setCardNumber("OP09-037");
        limChar.setName("Lim");
        limChar.setCardType("Character");
        limChar.setColor("Green");
        limChar.setCost(3);
        limChar.setPower(5000);
        limChar.setAffiliations("ODYSSEY");
        limChar.setAttribute("Wisdom");
        limChar.setEffect("[On Play] Look at the top 5 cards of your deck, reveal up to one card with the (Odyssey) type other than \"Lim\" and put it in your hand. Then, place the rest at the bottom of your deck in any order.\n[End of Your Turn] If you have 3 or more rested characters in play, set this character as active.");
        limChar.setImagePath("/images/cards/OP09/OP09-037.jpg");
        cardRepository.save(limChar);

        Card robLucci = new Card();
        robLucci.setCardNumber("OP09-038");
        robLucci.setName("Rob Lucci");
        robLucci.setCardType("Character");
        robLucci.setColor("Green");
        robLucci.setCost(4);
        robLucci.setPower(6000);
        robLucci.setCounter(1000);
        robLucci.setAffiliations("ODYSSEY / CP9");
        robLucci.setAttribute("Strike");
        // No Effect
        robLucci.setImagePath("/images/cards/OP09/OP09-038.jpg");
        cardRepository.save(robLucci);

        // Events
        Card gumGum = new Card();
        gumGum.setCardNumber("OP09-039");
        gumGum.setName("Gum-Gum Quattro Mano Jet Cross Shock Bazooka");
        gumGum.setCardType("Event");
        gumGum.setColor("Green");
        gumGum.setCost(1);
        gumGum.setAffiliations("ODYSSEY / Straw Hat Crew");
        gumGum.setEffect("[Counter] If your leader has the <<Odyssey>> type and you have two or more rested characters in play, up to one of your leader or characters gains +2000 power for this turn.\n[Trigger] KO up to one of your opponent's rested cost 4 or lower characters.");
        gumGum.setImagePath("/images/cards/OP09/OP09-039.jpg");
        cardRepository.save(gumGum);

        Card thunderLance = new Card();
        thunderLance.setCardNumber("OP09-040");
        thunderLance.setName("Thunder Lance Flip Pound Phoenix Shot");
        thunderLance.setCardType("Event");
        thunderLance.setColor("Green");
        thunderLance.setCost(3);
        thunderLance.setAffiliations("ODYSSEY / Straw Hat Crew");
        thunderLance.setEffect("[Main] If you have two or more rested characters in play, KO up to one of your opponent's cost 4 or lower characters.\n[Trigger] Rest up to one of your opponent's cost 4 or lower characters.");
        thunderLance.setImagePath("/images/cards/OP09/OP09-040.jpg");
        cardRepository.save(thunderLance);

        Card soulFranky = new Card();
        soulFranky.setCardNumber("OP09-041");
        soulFranky.setName("Soul FRANKY Swing Arm BOXING Solid");
        soulFranky.setCardType("Event");
        soulFranky.setColor("Green");
        soulFranky.setCost(1);
        soulFranky.setAffiliations("ODYSSEY / Straw Hat Crew");
        soulFranky.setEffect("[Counter] Up to 1 of your Leader or Characters gains +2000 power during this battle. Then, if your Leader has the {{ODYSSEY}} type and you have 2 or more rested Characters, set up to 2 of your Characters as active.\n[Trigger] Rest up to 1 of your opponent's Characters with a cost of 4 or less.");
        soulFranky.setImagePath("/images/cards/OP09/OP09-041.jpg");
        cardRepository.save(soulFranky);

        System.out.println("Finished initializing OP09 Green cards");
    }

    private void initializeOP09BlueCards() {
        System.out.println("Initializing OP09 Blue cards...");

        // Leader
        Card buggyLeader = new Card();
        buggyLeader.setCardNumber("OP09-042");
        buggyLeader.setName("Buggy");
        buggyLeader.setCardType("Leader");
        buggyLeader.setColor("Blue");
        buggyLeader.setPower(5000);
        buggyLeader.setLife(5);
        buggyLeader.setAffiliations("The Four Emperors/Cross Guild");
        buggyLeader.setAttribute("Slash");
        buggyLeader.setEffect("[Activate: Main] You may rest 5 DON!! and discard 1 card from your hand: Play up to 1 character with the \"Cross Guild\" type from your hand.");
        buggyLeader.setImagePath("/images/cards/OP09/OP09-042.jpg");
        cardRepository.save(buggyLeader);

        // Characters
        Card alvida = new Card();
        alvida.setCardNumber("OP09-043");
        alvida.setName("Alvida");
        alvida.setCardType("Character");
        alvida.setColor("Blue");
        alvida.setCost(5);
        alvida.setPower(6000);
        alvida.setCounter(1000);
        alvida.setAffiliations("Cross Guild");
        alvida.setAttribute("Strike");
        alvida.setEffect("[On K.O.] If your leader has the \"Cross Guild\" type, play up to 1 cost 5 or lower character card, other than \"Alvida\", from your hand.");
        alvida.setImagePath("/images/cards/OP09/OP09-043.jpg");
        cardRepository.save(alvida);

        Card izou = new Card();
        izou.setCardNumber("OP09-044");
        izou.setName("Izou");
        izou.setCardType("Character");
        izou.setColor("Blue");
        izou.setCost(3);
        izou.setPower(4000);
        izou.setCounter(1000);
        izou.setAffiliations("Wano Kingdom / Whitebeard Pirates");
        izou.setAttribute("Special");
        izou.setEffect("[When Attacking] Look at the top 5 cards for <Wano Kingdom> or <Whitebeard Pirates>, add one to hand and the rest to bottom deck, then Discard 1 card.");
        izou.setImagePath("/images/cards/OP09/OP09-044.jpg");
        cardRepository.save(izou);

        Card cabaji = new Card();
        cabaji.setCardNumber("OP09-045");
        cabaji.setName("Cabaji");
        cabaji.setCardType("Character");
        cabaji.setColor("Blue");
        cabaji.setCost(3);
        cabaji.setPower(5000);
        cabaji.setCounter(2000);
        cabaji.setAffiliations("Cross Guild");
        cabaji.setAttribute("Slash");
        cabaji.setEffect("If you have a character [Buggy] or [Mohji] in play this character can't be KO'd in battle.");
        cabaji.setImagePath("/images/cards/OP09/OP09-045.jpg");
        cardRepository.save(cabaji);

        Card crocodileBlue = new Card();
        crocodileBlue.setCardNumber("OP09-046");
        crocodileBlue.setName("Crocodile");
        crocodileBlue.setCardType("Character");
        crocodileBlue.setColor("Blue");
        crocodileBlue.setCost(7);
        crocodileBlue.setPower(7000);
        crocodileBlue.setCounter(1000);
        crocodileBlue.setAffiliations("Cross Guild / Former Baroque Works");
        crocodileBlue.setAttribute("Special");
        crocodileBlue.setEffect("[On Play] Play up to one Character card with the {Cross Guild} type or with a type including \"Baroque Works\" and a cost of 5 or less from your hand.");
        crocodileBlue.setImagePath("/images/cards/OP09/OP09-046.jpg");
        cardRepository.save(crocodileBlue);

        Card oden = new Card();
        oden.setCardNumber("OP09-047");
        oden.setName("Oden");
        oden.setCardType("Character");
        oden.setColor("Blue");
        oden.setCost(9);
        oden.setPower(10000);
        // No counter
        oden.setAffiliations("Land of Wano / Whitebeard Pirates");
        oden.setAttribute("Slash");
        oden.setEffect("[Double Attack] (This card deals 2 damage.)\n[On K.O.] Draw 2 cards then discard 1 card.");
        oden.setImagePath("/images/cards/OP09/OP09-047.jpg");
        cardRepository.save(oden);

        Card mihawk = new Card();
        mihawk.setCardNumber("OP09-048");
        mihawk.setName("Dracule Mihawk");
        mihawk.setCardType("Character");
        mihawk.setColor("Blue");
        mihawk.setCost(6);
        mihawk.setPower(7000);
        // No counter
        mihawk.setAffiliations("Cross Guild");
        mihawk.setAttribute("Slash");
        mihawk.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\n[On Play] Draw 2 cards, then discard 1 card from you hand.");
        mihawk.setImagePath("/images/cards/OP09/OP09-048.jpg");
        cardRepository.save(mihawk);

        Card jozu = new Card();
        jozu.setCardNumber("OP09-049");
        jozu.setName("Jozu");
        jozu.setCardType("Character");
        jozu.setColor("Blue");
        jozu.setCost(4);
        jozu.setPower(6000);
        jozu.setCounter(1000);
        jozu.setAffiliations("Whitebeard Pirates");
        jozu.setAttribute("Strike");
        // No effect text visible
        jozu.setImagePath("/images/cards/OP09/OP09-049.jpg");
        cardRepository.save(jozu);

        Card nami = new Card();
        nami.setCardNumber("OP09-050");
        nami.setName("Nami");
        nami.setCardType("Character");
        nami.setColor("Blue");
        nami.setCost(1);
        nami.setPower(1000);
        nami.setCounter(1000);
        nami.setAffiliations("East Blue");
        nami.setAttribute("Wisdom");
        nami.setEffect("[When Attacking] Look at the top 5 cards of your deck and reveal up to one blue event card and put it into your hand. Then, place the rest on the bottom of your deck in any order.");
        nami.setImagePath("/images/cards/OP09/OP09-050.jpg");
        cardRepository.save(nami);

        Card buggyChar = new Card();
        buggyChar.setCardNumber("OP09-051");
        buggyChar.setName("Buggy");
        buggyChar.setCardType("Character");
        buggyChar.setColor("Blue");
        buggyChar.setCost(10);
        buggyChar.setPower(12000);
        // No counter
        buggyChar.setAffiliations("Cross Guild / Four Emperors");
        buggyChar.setAttribute("Slash");
        buggyChar.setEffect("[On Play] Return up to one of your opponents characters to the bottom of the deck, then if you do not control 5 characters with a cost of 5 or more, return this character to the bottom of the deck.");
        buggyChar.setImagePath("/images/cards/OP09/OP09-051.jpg");
        cardRepository.save(buggyChar);

        Card marco = new Card();
        marco.setCardNumber("OP09-052");
        marco.setName("Marco");
        marco.setCardType("Character");
        marco.setColor("Blue");
        marco.setCost(3);
        marco.setPower(5000);
        marco.setCounter(1000);
        marco.setAffiliations("Whitebeard Pirates");
        marco.setAttribute("Special");
        marco.setEffect("[Opponent's Turn] You may trash 1 card from your hand: When this character would be KO'd by your opponent's effects, play this character as rested from your trash.");
        marco.setImagePath("/images/cards/OP09/OP09-052.jpg");
        cardRepository.save(marco);

        Card mohji = new Card();
        mohji.setCardNumber("OP09-053");
        mohji.setName("Mohji");
        mohji.setCardType("Character");
        mohji.setColor("Blue");
        mohji.setCost(5);
        mohji.setPower(5000);
        mohji.setCounter(2000);
        mohji.setAffiliations("Cross Guild");
        mohji.setAttribute("Wisdom");
        mohji.setEffect("[On Play] Look at the top 5 cards of your deck and reveal up to one (Richie) and put it into your hand, then place the rest of the cards on the bottom of your deck in any order and play up to one (Richie) from your hand.");
        mohji.setImagePath("/images/cards/OP09/OP09-053.jpg");
        cardRepository.save(mohji);

        Card richie = new Card();
        richie.setCardNumber("OP09-054");
        richie.setName("Richie");
        richie.setCardType("Character");
        richie.setColor("Blue");
        richie.setCost(2);
        richie.setPower(2000);
        richie.setCounter(1000);
        richie.setAffiliations("Animal / Cross Guild");
        richie.setAttribute("Strike");
        richie.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        richie.setImagePath("/images/cards/OP09/OP09-054.jpg");
        cardRepository.save(richie);

        Card mrOne = new Card();
        mrOne.setCardNumber("OP09-055");
        mrOne.setName("Mr.1 (Daz Bones)");
        mrOne.setCardType("Character");
        mrOne.setColor("Blue");
        mrOne.setCost(5);
        mrOne.setPower(7000);
        mrOne.setCounter(1000);
        mrOne.setAffiliations("Cross Guild/Former Baroque Works");
        mrOne.setAttribute("Slash");
        // No effect text visible
        mrOne.setImagePath("/images/cards/OP09/OP09-055.jpg");
        cardRepository.save(mrOne);

        Card mrThree = new Card();
        mrThree.setCardNumber("OP09-056");
        mrThree.setName("Mr.3 (Galdino)");
        mrThree.setCardType("Character");
        mrThree.setColor("Blue");
        mrThree.setCost(1);
        mrThree.setPower(2000);
        mrThree.setCounter(1000);
        mrThree.setAffiliations("Cross Guild/Former Baroque Works");
        mrThree.setAttribute("Special");
        mrThree.setEffect("[On Play] Look at the top 4 cards of your deck and reveal up to 1 card with the (Cross Guild) type or with a type including \"Baroque Works\", other than \"Mr 3 - Galdino\" and put it into your hand. Then place the rest of the cards on the bottom of your deck in any order.");
        mrThree.setImagePath("/images/cards/OP09/OP09-056.jpg");
        cardRepository.save(mrThree);

        // Events
        Card crossGuild = new Card();
        crossGuild.setCardNumber("OP09-057");
        crossGuild.setName("Cross Guild");
        crossGuild.setCardType("Event");
        crossGuild.setColor("Blue");
        crossGuild.setCost(1);
        crossGuild.setAffiliations("Cross Guild");
        crossGuild.setEffect("[Main] Look at the top 4 cards of your deck, reveal and add to your hand up to one card with the type {Cross Guild}, Then return the rest to the bottom of the deck in any order.\n[Trigger] Activate this card's [Main] Effect.");
        crossGuild.setImagePath("/images/cards/OP09/OP09-057.jpg");
        cardRepository.save(crossGuild);

        Card muggyBall = new Card();
        muggyBall.setCardNumber("OP09-058");
        muggyBall.setName("Special Muggy Ball");
        muggyBall.setCardType("Event");
        muggyBall.setColor("Blue");
        muggyBall.setCost(2);
        muggyBall.setAffiliations("Buggy Pirates");
        muggyBall.setEffect("[Main] Your opponent returns 1 of their characters with a cost of 6 or less to the owner's hand.\n[Trigger] Return 1 character with a cost of 3 or less to the owner's hand.");
        muggyBall.setImagePath("/images/cards/OP09/OP09-058.jpg");
        cardRepository.save(muggyBall);

        Card murder = new Card();
        murder.setCardNumber("OP09-059");
        murder.setName("Murder at the Steam Bath");
        murder.setCardType("Event");
        murder.setColor("Blue");
        murder.setCost(2);
        murder.setAffiliations("Buggy Pirates");
        murder.setEffect("[Counter] Give up to one of your leader or characters +3000 power for this battle, then trash up to 2 cards from your hand. Then, trash the same number of cards from the top of your deck.\n[Trigger] Draw a card.");
        murder.setImagePath("/images/cards/OP09/OP09-059.jpg");
        cardRepository.save(murder);

        // Stage
        Card karaiBari = new Card();
        karaiBari.setCardNumber("OP09-060");
        karaiBari.setName("Karai Bari Island");
        karaiBari.setCardType("Stage");
        karaiBari.setColor("Blue");
        karaiBari.setCost(1);
        karaiBari.setAffiliations("Cross Guild");
        karaiBari.setEffect("[Activate: Main] Send 2 cards from your hand to the bottom of your deck and rest this stage: If your leader has <Cross Guild> Draw 2 cards.");
        karaiBari.setImagePath("/images/cards/OP09/OP09-060.jpg");
        cardRepository.save(karaiBari);

        System.out.println("Finished initializing OP09 Blue cards");
    }

    private void initializeOP09PurpleCards() {
        System.out.println("Initializing OP09 Purple cards...");

        // Leaders
        Card luffyLeader = new Card();
        luffyLeader.setCardNumber("OP09-061");
        luffyLeader.setName("Monkey.D.Luffy");
        luffyLeader.setCardType("Leader");
        luffyLeader.setColor("Purple");
        luffyLeader.setPower(5000);
        luffyLeader.setLife(4);
        luffyLeader.setAffiliations("Four Emperors / Straw hat Pirates");
        luffyLeader.setAttribute("Strike");
        luffyLeader.setEffect("[DON!!x1] Your characters have +1 cost.\n[Your Turn] [Once Per Turn] When 2 or more DON!! cards are returned to your DON!! deck from play, set up to one from your DON!! deck as active and up to one from your DON!! deck as rested.");
        luffyLeader.setImagePath("/images/cards/OP09/OP09-061.jpg");
        cardRepository.save(luffyLeader);

        Card robinLeader = new Card();
        robinLeader.setCardNumber("OP09-062");
        robinLeader.setName("Nico Robin");
        robinLeader.setCardType("Leader");
        robinLeader.setColor("Purple");
        robinLeader.setPower(5000);
        robinLeader.setLife(4);
        robinLeader.setAffiliations("Straw hat Crew");
        robinLeader.setAttribute("Strike");
        robinLeader.setEffect("[Banish] (When a character deals damage, the target card is trashed without activating its Trigger.)\n[When Attacking] You may trash one card with a Trigger from your hand : Add up to one DON!! card from your DON!! deck and set it as rested.");
        robinLeader.setImagePath("/images/cards/OP09/OP09-062.jpg");
        cardRepository.save(robinLeader);

        // Characters
        Card usopp = new Card();
        usopp.setCardNumber("OP09-063");
        usopp.setName("Usopp");
        usopp.setCardType("Character");
        usopp.setColor("Purple");
        usopp.setCost(4);
        usopp.setPower(6000);
        usopp.setCounter(1000);
        usopp.setAffiliations("Straw Hat Crew");
        usopp.setAttribute("Ranged");
        // No effect text visible in image
        usopp.setImagePath("/images/cards/OP09/OP09-063.jpg");
        cardRepository.save(usopp);

        Card killer = new Card();
        killer.setCardNumber("OP09-064");
        killer.setName("Killer");
        killer.setCardType("Character");
        killer.setColor("Purple");
        killer.setCost(3);
        killer.setPower(5000);
        killer.setCounter(1000);
        killer.setAffiliations("Kid Pirates");
        killer.setAttribute("Slash");
        killer.setEffect("[On Play] Don-1: Choose one leader with <Kid Pirates> type and activate it.");
        killer.setImagePath("/images/cards/OP09/OP09-064.jpg");
        cardRepository.save(killer);

        Card sanji = new Card();
        sanji.setCardNumber("OP09-065");
        sanji.setName("Sanji");
        sanji.setCardType("Character");
        sanji.setColor("Purple");
        sanji.setCost(7);
        sanji.setPower(7000);
        sanji.setCounter(1000);
        sanji.setAffiliations("Straw Hat Crew");
        sanji.setAttribute("Strike");
        sanji.setEffect("[On Play] You may return one or more of your Don!! cards from play to your Don!! deck: This character gains [Rush] for this turn. Then, rest up to one of your opponents cost 6 or lower characters.");
        sanji.setImagePath("/images/cards/OP09/OP09-065.jpg");
        cardRepository.save(sanji);

        Card jeanBart = new Card();
        jeanBart.setCardNumber("OP09-066");
        jeanBart.setName("Jean Bart");
        jeanBart.setCardType("Character");
        jeanBart.setColor("Purple");
        jeanBart.setCost(4);
        jeanBart.setPower(6000);
        // No counter
        jeanBart.setAffiliations("Heart Pirates");
        jeanBart.setAttribute("Strike");
        jeanBart.setEffect("[On Play] If your opponent has more DON!! cards on their field than you, K.O up to 1 of your opponent's Characters with a cost of 3 or less.");
        jeanBart.setImagePath("/images/cards/OP09/OP09-066.jpg");
        cardRepository.save(jeanBart);

        Card jinbei = new Card();
        jinbei.setCardNumber("OP09-067");
        jinbei.setName("Jinbei");
        jinbei.setCardType("Character");
        jinbei.setColor("Purple");
        jinbei.setCost(7);
        jinbei.setPower(9000);
        jinbei.setCounter(1000);
        jinbei.setAffiliations("Fishman/Straw Hat Crew");
        jinbei.setAttribute("Strike");
        // No effect text visible
        jinbei.setImagePath("/images/cards/OP09/OP09-067.jpg");
        cardRepository.save(jinbei);

        Card chopperPurple = new Card();
        chopperPurple.setCardNumber("OP09-068");
        chopperPurple.setName("Tony Tony Chopper");
        chopperPurple.setCardType("Character");
        chopperPurple.setColor("Purple");
        chopperPurple.setCost(3);
        chopperPurple.setPower(6000);
        chopperPurple.setCounter(1000);
        chopperPurple.setAffiliations("Straw Hat Crew");
        chopperPurple.setAttribute("Strike");
        chopperPurple.setEffect("[End of Your Turn] Return 1 or more DON!! to your DON!! deck: Set this character as active. Then, this character gains [Blocker] until the end of your opponent's next turn");
        chopperPurple.setImagePath("/images/cards/OP09/OP09-068.jpg");
        cardRepository.save(chopperPurple);

        Card lawPurple = new Card();
        lawPurple.setCardNumber("OP09-069");
        lawPurple.setName("Trafalgar Law");
        lawPurple.setCardType("Character");
        lawPurple.setColor("Purple");
        lawPurple.setCost(1);
        lawPurple.setPower(2000);
        lawPurple.setCounter(1000);
        lawPurple.setAffiliations("Heart Pirates");
        lawPurple.setAttribute("Slash");
        lawPurple.setEffect("[On Play] Look at the top 4 cards of your deck and reveal up to one cost 2 or greater card with the {Straw Hat Crew} or {Heart Pirates} type and put it into your hand. Then place the rest of the cards on the bottom of your deck in any order.");
        lawPurple.setImagePath("/images/cards/OP09/OP09-069.jpg");
        cardRepository.save(lawPurple);

        Card namiPurple = new Card();
        namiPurple.setCardNumber("OP09-070");
        namiPurple.setName("Nami");
        namiPurple.setCardType("Character");
        namiPurple.setColor("Purple");
        namiPurple.setCost(3);
        namiPurple.setPower(2000);
        namiPurple.setCounter(2000);
        namiPurple.setAffiliations("Straw Hat Crew");
        namiPurple.setAttribute("Special");
        namiPurple.setEffect("[On Play] Return 1 or more Dons to your don deck: Attached 2 of your rested don to 1 of your leader or Character.");
        namiPurple.setImagePath("/images/cards/OP09/OP09-070.jpg");
        cardRepository.save(namiPurple);

        Card robinPurpleChar = new Card();
        robinPurpleChar.setCardNumber("OP09-071");
        robinPurpleChar.setName("Nico Robin");
        robinPurpleChar.setCardType("Character");
        robinPurpleChar.setColor("Purple");
        robinPurpleChar.setCost(2);
        robinPurpleChar.setPower(2000);
        robinPurpleChar.setCounter(1000);
        robinPurpleChar.setAffiliations("Straw Hat Crew");
        robinPurpleChar.setAttribute("Strike");
        robinPurpleChar.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        robinPurpleChar.setImagePath("/images/cards/OP09/OP09-071.jpg");
        cardRepository.save(robinPurpleChar);

        Card franky = new Card();
        franky.setCardNumber("OP09-072");
        franky.setName("Franky");
        franky.setCardType("Character");
        franky.setColor("Purple");
        franky.setCost(4);
        franky.setPower(5000);
        franky.setCounter(1000);
        franky.setAffiliations("Straw Hat Crew");
        franky.setAttribute("Strike");
        franky.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\n[On Play] DON!!-2: Discard 1 card from your hand: Draw 3 cards.");
        franky.setImagePath("/images/cards/OP09/OP09-072.jpg");
        cardRepository.save(franky);

        Card brook = new Card();
        brook.setCardNumber("OP09-073");
        brook.setName("Brook");
        brook.setCardType("Character");
        brook.setColor("Purple");
        brook.setCost(6);
        brook.setPower(7000);
        brook.setCounter(1000);
        brook.setAffiliations("Straw Hat Crew");
        brook.setAttribute("Slash");
        brook.setEffect("[When Attacking] Return 1 or more don to your don deck: choose 2 of your opponent character, during this turn -2000 Power.");
        brook.setImagePath("/images/cards/OP09/OP09-073.jpg");
        cardRepository.save(brook);

        Card bepo = new Card();
        bepo.setCardNumber("OP09-074");
        bepo.setName("Bepo");
        bepo.setCardType("Character");
        bepo.setColor("Purple");
        bepo.setCost(2);
        bepo.setPower(2000);
        bepo.setCounter(2000);
        bepo.setAffiliations("Minks / Heart Pirates");
        bepo.setAttribute("Strike");
        bepo.setEffect("[Your Turn] [Once Per Turn] When your don cards are returned to your don deck, choose one of your leaders, during this turn +1000 Power.");
        bepo.setImagePath("/images/cards/OP09/OP09-074.jpg");
        cardRepository.save(bepo);

        Card kid = new Card();
        kid.setCardNumber("OP09-075");
        kid.setName("Eustass \"Captain\" Kid");
        kid.setCardType("Character");
        kid.setColor("Purple");
        kid.setCost(3);
        kid.setPower(5000);
        kid.setCounter(1000);
        kid.setAffiliations("Kid Pirates");
        kid.setAttribute("Special");
        kid.setEffect("[On Play] Add the top card of your life to your hand: If your leader has <Kid Pirates> type add 1 DON!! card from your DON!! deck as active.");
        kid.setImagePath("/images/cards/OP09/OP09-075.jpg");
        cardRepository.save(kid);

        Card zoro = new Card();
        zoro.setCardNumber("OP09-076");
        zoro.setName("Roronoa Zoro");
        zoro.setCardType("Character");
        zoro.setColor("Purple");
        zoro.setCost(3);
        zoro.setPower(5000);
        zoro.setCounter(1000);
        zoro.setAffiliations("Straw Hat Crew");
        zoro.setAttribute("Slash");
        zoro.setEffect("[On Play] You may return one or more Don!! cards from play to your Don!! deck: Set up to one Don!! card from your Don!! deck into play as active.");
        zoro.setImagePath("/images/cards/OP09/OP09-076.jpg");
        cardRepository.save(zoro);

        // Events
        Card gumGumLightning = new Card();
        gumGumLightning.setCardNumber("OP09-077");
        gumGumLightning.setName("Gum Gum Lightning");
        gumGumLightning.setCardType("Event");
        gumGumLightning.setColor("Purple");
        gumGumLightning.setCost(2);
        gumGumLightning.setAffiliations("Four Emperors / Straw Hat Crew");
        gumGumLightning.setEffect("[Main] Don!!-2: KO up to one of your opponent's power 6000 or lower characters.\n[Trigger] Set up to one Don!! from your Don!! deck as active.");
        gumGumLightning.setImagePath("/images/cards/OP09/OP09-077.jpg");
        cardRepository.save(gumGumLightning);

        Card gumGumGiant = new Card();
        gumGumGiant.setCardNumber("OP09-078");
        gumGumGiant.setName("Gum Gum Giant");
        gumGumGiant.setCardType("Event");
        gumGumGiant.setColor("Purple");
        gumGumGiant.setCost(1);
        gumGumGiant.setAffiliations("Four Emperors / Straw Hat Crew");
        gumGumGiant.setEffect("[Counter] Don!!-2: You may trash one card from your hand: If your leader has the {Straw Hat Crew} type, give up to one of your leader or characters +4000 power for this battle. Then, draw 2 cards.");
        gumGumGiant.setImagePath("/images/cards/OP09/OP09-078.jpg");
        cardRepository.save(gumGumGiant);

        Card gumGumJumpRope = new Card();
        gumGumJumpRope.setCardNumber("OP09-079");
        gumGumJumpRope.setName("Gum Gum Jump-Rope");
        gumGumJumpRope.setCardType("Event");
        gumGumJumpRope.setColor("Purple");
        gumGumJumpRope.setCost(2);
        gumGumJumpRope.setAffiliations("Four Emperors / Straw Hat Crew");
        gumGumJumpRope.setEffect("[Main] Don!!-2: Rest up to one of your opponent's cost 5 or lower characters. Then, draw a card.\n[Trigger] Set up to one Don!! from your Don!! deck as active.");
        gumGumJumpRope.setImagePath("/images/cards/OP09/OP09-079.jpg");
        cardRepository.save(gumGumJumpRope);

        // OP09-080: Monkey D. Luffy
        Card monkeyDLuffy = new Card();
        monkeyDLuffy.setCardNumber("OP09-119");  // Changed from OP09-080 to OP09-119
        monkeyDLuffy.setName("Monkey D. Luffy");
        monkeyDLuffy.setCardType("Character");
        monkeyDLuffy.setColor("Purple");
        monkeyDLuffy.setCost(9);
        monkeyDLuffy.setPower(10000);
        // No Counter
        monkeyDLuffy.setAffiliations("Straw Hat Crew");
        monkeyDLuffy.setAttribute("Strike");
        monkeyDLuffy.setEffect("[On Play] You may return one or more DON!! cards from play to your DON!! deck: Draw 1 card, then this character gains [Rush] for this turn.");
        monkeyDLuffy.setImagePath("/images/cards/OP09/OP09-119.jpg");  // Updated image path to match card number
        cardRepository.save(monkeyDLuffy);

        // Add the Thousand Sunny stage card at OP09-080
        Card thousandSunny = new Card();
        thousandSunny.setCardNumber("OP09-080");
        thousandSunny.setName("Thousand Sunny");
        thousandSunny.setCardType("Stage");
        thousandSunny.setColor("Purple");
        thousandSunny.setCost(1);
        thousandSunny.setAffiliations("Straw Hat Crew");
        thousandSunny.setEffect("Activate: Main You may rest this stage: If your leader has the {Straw Hat Crew} type, set up to 1 of your DON!! as active.");
        thousandSunny.setImagePath("/images/cards/OP09/OP09-080.jpg");
        cardRepository.save(thousandSunny);

        System.out.println("Finished initializing OP09 Purple cards");
    }

    private void initializeOP09BlackCards() {
        System.out.println("Initializing OP09 Black cards...");

        // Leader
        Card teachLeader = new Card();
        teachLeader.setCardNumber("OP09-081");
        teachLeader.setName("Marshall D. Teach");
        teachLeader.setCardType("Leader");
        teachLeader.setColor("Black");
        teachLeader.setPower(5000);
        teachLeader.setLife(5);
        teachLeader.setAffiliations("Four Emperors / Blackbeard Pirates");
        teachLeader.setAttribute("Special");
        teachLeader.setEffect("Your [On Play] abilities don't activate.\n[Activate: Main] You may trash one card from your hand : Until the end of your opponent's next turn, your opponent's [On Play] abilities don't activate.");
        teachLeader.setImagePath("/images/cards/OP09/OP09-081.jpg");
        cardRepository.save(teachLeader);

        // Characters
        Card avaloPizarro = new Card();
        avaloPizarro.setCardNumber("OP09-082");
        avaloPizarro.setName("Avalo Pizarro");
        avaloPizarro.setCardType("Character");
        avaloPizarro.setColor("Black");
        avaloPizarro.setCost(4);
        avaloPizarro.setPower(6000);
        avaloPizarro.setCounter(1000);
        avaloPizarro.setAffiliations("Blackbeard Pirates");
        avaloPizarro.setAttribute("Special");
        // No effect text visible in the image
        avaloPizarro.setImagePath("/images/cards/OP09/OP09-082.jpg");
        cardRepository.save(avaloPizarro);

        Card vanAugur = new Card();
        vanAugur.setCardNumber("OP09-083");
        vanAugur.setName("Van Augur");
        vanAugur.setCardType("Character");
        vanAugur.setColor("Black");
        vanAugur.setCost(5);
        vanAugur.setPower(6000);
        vanAugur.setCounter(1000);
        vanAugur.setAffiliations("Blackbeard Pirates");
        vanAugur.setAttribute("Ranged");
        vanAugur.setEffect("[Activate: Main] You may rest this character: If your leader has the {Blackbeard Pirates} type, give up to one of your opponent's characters -3 cost for this turn.\n[On K.O.] Draw one card.");
        vanAugur.setImagePath("/images/cards/OP09/OP09-083.jpg");
        cardRepository.save(vanAugur);

        Card catarinaDevon = new Card();
        catarinaDevon.setCardNumber("OP09-084");
        catarinaDevon.setName("Catarina Devon");
        catarinaDevon.setCardType("Character");
        catarinaDevon.setColor("Black");
        catarinaDevon.setCost(5);
        catarinaDevon.setPower(6000);
        catarinaDevon.setCounter(1000);
        catarinaDevon.setAffiliations("Blackbeard Pirates");
        catarinaDevon.setAttribute("Special");
        catarinaDevon.setEffect("[Activate: Main] [Once Per Turn] If your leader has the {Blackbeard Pirates} type, until the end of your opponent's next turn this character gains [Double Attack], [Banish] or [Blocker].");
        catarinaDevon.setImagePath("/images/cards/OP09/OP09-084.jpg");
        cardRepository.save(catarinaDevon);

        Card geckoMoria = new Card();
        geckoMoria.setCardNumber("OP09-085");
        geckoMoria.setName("Gecko Moria");
        geckoMoria.setCardType("Character");
        geckoMoria.setColor("Black");
        geckoMoria.setCost(4);
        geckoMoria.setPower(5000);
        // No Counter
        geckoMoria.setAffiliations("Thriller Bark Pirates");
        geckoMoria.setAttribute("Special");
        geckoMoria.setEffect("[On Play] Play up to 1 Character Card with the Thriller Bark Pirates trait and cost 2 or less from your trash rested.");
        geckoMoria.setImagePath("/images/cards/OP09/OP09-085.jpg");
        cardRepository.save(geckoMoria);

        Card jesusBurgess = new Card();
        jesusBurgess.setCardNumber("OP09-086");
        jesusBurgess.setName("Jesus Burgess");
        jesusBurgess.setCardType("Character");
        jesusBurgess.setColor("Black");
        jesusBurgess.setCost(4);
        jesusBurgess.setPower(5000);
        jesusBurgess.setCounter(1000);
        jesusBurgess.setAffiliations("Blackbeard Pirates");
        jesusBurgess.setAttribute("Strike");
        jesusBurgess.setEffect("This character cannot be KO'd by your opponents effects.\nIf your leader has the {Blackbeard Pirates} type, this character gets +1000 power for every 4 cards in your trash.");
        jesusBurgess.setImagePath("/images/cards/OP09/OP09-086.jpg");
        cardRepository.save(jesusBurgess);

        Card charlottePudding = new Card();
        charlottePudding.setCardNumber("OP09-087");
        charlottePudding.setName("Charlotte Pudding");
        charlottePudding.setCardType("Character");
        charlottePudding.setColor("Black");
        charlottePudding.setCost(2);
        charlottePudding.setPower(0);
        charlottePudding.setCounter(1000);
        charlottePudding.setAffiliations("Big Mom Pirates");
        charlottePudding.setAttribute("Wisdom");
        charlottePudding.setEffect("[On Play] If your opponents hand has 5 or more cards in it, your opponent trashes 1 card from their hand.");
        charlottePudding.setImagePath("/images/cards/OP09/OP09-087.jpg");
        cardRepository.save(charlottePudding);

        Card shiryuu = new Card();
        shiryuu.setCardNumber("OP09-088");
        shiryuu.setName("Shiryuu");
        shiryuu.setCardType("Character");
        shiryuu.setColor("Black");
        shiryuu.setCost(3);
        shiryuu.setPower(4000);
        shiryuu.setCounter(2000);
        shiryuu.setAffiliations("Blackbeard Pirates");
        shiryuu.setAttribute("Slash");
        shiryuu.setEffect("[DON!!x1] [When Attacking] You may trash 2 cards from your hand: Draw 2 cards.");
        shiryuu.setImagePath("/images/cards/OP09/OP09-088.jpg");
        cardRepository.save(shiryuu);

        Card stronger = new Card();
        stronger.setCardNumber("OP09-089");
        stronger.setName("Stronger");
        stronger.setCardType("Character");
        stronger.setColor("Black");
        stronger.setCost(1);
        stronger.setPower(0);
        stronger.setCounter(2000);
        stronger.setAffiliations("Animal / Blackbeard Pirates");
        stronger.setAttribute("Wisdom");
        stronger.setEffect("[Activate: Main] You may trash one card from your hand and this character: If your leader has the {Blackbeard Pirates} type, draw one card. Then give up to one of your opponents characters -2 cost for the turn.");
        stronger.setImagePath("/images/cards/OP09/OP09-089.jpg");
        cardRepository.save(stronger);

        Card docQ = new Card();
        docQ.setCardNumber("OP09-090");
        docQ.setName("Doc Q");
        docQ.setCardType("Character");
        docQ.setColor("Black");
        docQ.setCost(2);
        docQ.setPower(0);
        docQ.setCounter(1000);
        docQ.setAffiliations("Blackbeard Pirates");
        docQ.setAttribute("Special");
        docQ.setEffect("[Activate: Main] You may rest this character: If your leader has the {Blackbeard Pirates} type, KO up to one of your opponents cost 1 or lower character.\n[On K.O.] Draw a card.");
        docQ.setImagePath("/images/cards/OP09/OP09-090.jpg");
        cardRepository.save(docQ);

        Card vascoShot = new Card();
        vascoShot.setCardNumber("OP09-091");
        vascoShot.setName("Vasco Shot");
        vascoShot.setCardType("Character");
        vascoShot.setColor("Black");
        vascoShot.setCost(2);
        vascoShot.setPower(2000);
        vascoShot.setCounter(1000);
        vascoShot.setAffiliations("Blackbeard Pirates");
        vascoShot.setAttribute("Special");
        vascoShot.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        vascoShot.setImagePath("/images/cards/OP09/OP09-091.jpg");
        cardRepository.save(vascoShot);

        Card teachChar = new Card();
        teachChar.setCardNumber("OP09-092");
        teachChar.setName("Marshall D. Teach");
        teachChar.setCardType("Character");
        teachChar.setColor("Black");
        teachChar.setCost(3);
        teachChar.setPower(4000);
        teachChar.setCounter(1000);
        teachChar.setAffiliations("Whitebeard Pirates");
        teachChar.setAttribute("Special");
        teachChar.setEffect("[Activate: Main] You may rest this character: If your hand has 3 or more fewer cards than your opponent's hand, draw 2 cards, then discard 1 card.");
        teachChar.setImagePath("/images/cards/OP09/OP09-092.jpg");
        cardRepository.save(teachChar);

        Card teachBig = new Card();
        teachBig.setCardNumber("OP09-093");
        teachBig.setName("Marshall D Teach");
        teachBig.setCardType("Character");
        teachBig.setColor("Black");
        teachBig.setCost(10);
        teachBig.setPower(12000);
        // No Counter
        teachBig.setAffiliations("Four Emperors / Blackbeard Pirates");
        teachBig.setAttribute("Special");
        teachBig.setEffect("[Blocker]\n[Activate: Main] [Once Per Turn] If your leader has the type {Blackbeard Pirates}, and if this character was played this turn, Up to one of your opponent's leaders effects are negated for the rest of the turn. Then, up to one of your opponent's characters effects are negated until the end of your opponent's next turn, that character also cannot attack.");
        teachBig.setImagePath("/images/cards/OP09/OP09-093.jpg");
        cardRepository.save(teachBig);

        Card pinkBeard = new Card();
        pinkBeard.setCardNumber("OP09-094");
        pinkBeard.setName("Pink Beard");
        pinkBeard.setCardType("Character");
        pinkBeard.setColor("Black");
        pinkBeard.setCost(3);
        pinkBeard.setPower(5000);
        pinkBeard.setCounter(1000);
        pinkBeard.setAffiliations("Blackbeard Pirates");
        pinkBeard.setAttribute("Slash");
        // No effect text visible
        pinkBeard.setImagePath("/images/cards/OP09/OP09-094.jpg");
        cardRepository.save(pinkBeard);

        Card laffitte = new Card();
        laffitte.setCardNumber("OP09-095");
        laffitte.setName("Laffitte");
        laffitte.setCardType("Character");
        laffitte.setColor("Black");
        laffitte.setCost(1);
        laffitte.setPower(1000);
        laffitte.setCounter(1000);
        laffitte.setAffiliations("Blackbeard Pirates");
        laffitte.setAttribute("Strike");
        laffitte.setEffect("[Activate: Main] You may rest this character and one of your Don!!: Look at the top 5 cards of your deck, reveal up to one {Blackbeard Pirates} type card and put it into your hand. Then, place the rest of the cards on the bottom of your deck in any order.");
        laffitte.setImagePath("/images/cards/OP09/OP09-095.jpg");
        cardRepository.save(laffitte);

        // Events
        Card thisIsMyAge = new Card();
        thisIsMyAge.setCardNumber("OP09-096");
        thisIsMyAge.setName("This is MY AGE!!!!");
        thisIsMyAge.setCardType("Event");
        thisIsMyAge.setColor("Black");
        thisIsMyAge.setCost(1);
        thisIsMyAge.setAffiliations("Blackbeard Pirates");
        thisIsMyAge.setEffect("[Main] Look at the top 3 cards of your deck and reveal up to one {Blackbeard Pirates} type card other than [This is MY AGE!!!!] and put it into your hand. Then put the rest of the cards into your trash.\n[Trigger] Activate this card's [Main] effect.");
        thisIsMyAge.setImagePath("/images/cards/OP09/OP09-096.jpg");
        cardRepository.save(thisIsMyAge);

        Card blackSpiral = new Card();
        blackSpiral.setCardNumber("OP09-097");
        blackSpiral.setName("Black Spiral");
        blackSpiral.setCardType("Event");
        blackSpiral.setColor("Black");
        blackSpiral.setCost(2);
        blackSpiral.setAffiliations("Blackbeard Pirates");
        blackSpiral.setEffect("[Counter] Nullify the effects of up to 1 of your opponent's leader or character and give them -4000 power during this turn.\n[Trigger] Nullify the effects of up to 1 of your opponent's leader or character during this turn.");
        blackSpiral.setImagePath("/images/cards/OP09/OP09-097.jpg");
        cardRepository.save(blackSpiral);

        // Stage
        Card blackHole = new Card();
        blackHole.setCardNumber("OP09-098");
        blackHole.setName("Black Hole");
        blackHole.setCardType("Stage");
        blackHole.setColor("Black");
        blackHole.setCost(4);
        blackHole.setAffiliations("Blackbeard Pirates");
        blackHole.setEffect("[Main] If your leader has the \"Blackbeard Pirates\" type, choose up to 1 of your opponent's characters and negate their effect for this turn. Then, if that character has a cost of 4 or less, KO that character.\n[Trigger] Negate the effects of up to one of your opponent's leaders or characters during this turn.");
        blackHole.setImagePath("/images/cards/OP09/OP09-098.jpg");
        cardRepository.save(blackHole);

        Card hachinosu = new Card();
        hachinosu.setCardNumber("OP09-099");
        hachinosu.setName("Hachinosu");
        hachinosu.setCardType("Stage");
        hachinosu.setColor("Black");
        hachinosu.setCost(1);
        hachinosu.setAffiliations("Blackbeard Pirates");
        hachinosu.setEffect("[Activate: Main] You may trash 1 card from your hand then rest this stage: Look at the top 3 cards of your deck, reveal up to one {Blackbeard Pirates} card and put it into your hand. Then place the rest on the bottom of your deck");
        hachinosu.setImagePath("/images/cards/OP09/OP09-099.jpg");
        cardRepository.save(hachinosu);

        System.out.println("Finished initializing OP09 Black cards");
    }

    private void initializeOP09YellowCards() {
        System.out.println("Initializing OP09 Yellow cards...");

        // Characters
        Card karasu = new Card();
        karasu.setCardNumber("OP09-100");
        karasu.setName("Karasu");
        karasu.setCardType("Character");
        karasu.setColor("Yellow");
        karasu.setCost(3);
        karasu.setPower(4000);
        karasu.setCounter(1000);
        karasu.setAffiliations("Revolutionary Army");
        karasu.setAttribute("Special");
        karasu.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\n[Trigger] If your Leader has the {{Revolutionary Army}} type and the total of your and your opponent's Life cards is 5 or less, play this card.");
        karasu.setImagePath("/images/cards/OP09/OP09-100.jpg");
        cardRepository.save(karasu);

        Card kuzan = new Card();
        kuzan.setCardNumber("OP09-101");
        kuzan.setName("Kuzan");
        kuzan.setCardType("Character");
        kuzan.setColor("Yellow");
        kuzan.setCost(4);
        kuzan.setPower(5000);
        kuzan.setCounter(1000);
        kuzan.setAffiliations("Navy");
        kuzan.setAttribute("Special");
        kuzan.setEffect("[On Play] You may place one of your opponents cost 3 or lower characters onto the top or bottom of their life face up: Your opponent trashes one card from their hand.");
        kuzan.setImagePath("/images/cards/OP09/OP09-101.jpg");
        cardRepository.save(kuzan);

        Card professorClover = new Card();
        professorClover.setCardNumber("OP09-102");
        professorClover.setName("Professor Clover");
        professorClover.setCardType("Character");
        professorClover.setColor("Yellow");
        professorClover.setCost(1);
        professorClover.setPower(0);
        professorClover.setCounter(2000);
        professorClover.setAffiliations("Ohara");
        professorClover.setAttribute("Wisdom");
        professorClover.setEffect("[On Play] If your leader is [Nico Robin], look at the top 3 cards of your deck, reveal and add up to one card with [Trigger] to your hand and return the rest to the bottom of the deck in any order of your choosing.\n[Trigger] Activate this card's [On Play] effect");
        professorClover.setImagePath("/images/cards/OP09/OP09-102.jpg");
        cardRepository.save(professorClover);

        Card koala = new Card();
        koala.setCardNumber("OP09-103");
        koala.setName("Koala");
        koala.setCardType("Character");
        koala.setColor("Yellow");
        koala.setCost(6);
        koala.setPower(6000);
        koala.setCounter(1000);
        koala.setAffiliations("Revolutionary Army");
        koala.setAttribute("Strike");
        koala.setEffect("[Blocker]\n[On Play] Your may add the top or bottom of your life to your hand: Play up to 1 cost 4 or less <<Revolutionary Army>> character from your hand and Draw 1 card.");
        koala.setImagePath("/images/cards/OP09/OP09-103.jpg");
        cardRepository.save(koala);

        Card saboYellow = new Card();
        saboYellow.setCardNumber("OP09-104");
        saboYellow.setName("Sabo");
        saboYellow.setCardType("Character");
        saboYellow.setColor("Yellow");
        saboYellow.setCost(7);
        saboYellow.setPower(7000);
        saboYellow.setCounter(1000);
        saboYellow.setAffiliations("Revolutionary Army");
        saboYellow.setAttribute("Special");
        saboYellow.setEffect("[On Play] Place up to one (Revolutionary Army) type character from your hand on top of your life face-up. Then, if you have 2 or more life, put the top or bottom card of your life into your hand.\n[Trigger] If your leader is multi-colored, draw 2 cards.");
        saboYellow.setImagePath("/images/cards/OP09/OP09-104.jpg");
        cardRepository.save(saboYellow);

        Card sanjiYellow = new Card();
        sanjiYellow.setCardNumber("OP09-105");
        sanjiYellow.setName("Sanji");
        sanjiYellow.setCardType("Character");
        sanjiYellow.setColor("Yellow");
        sanjiYellow.setCost(5);
        sanjiYellow.setPower(6000);
        sanjiYellow.setCounter(1000);
        sanjiYellow.setAffiliations("Egghead / Straw Hat Crew");
        sanjiYellow.setAttribute("Strike");
        sanjiYellow.setEffect("[Trigger] If your leader has <Egghead> type, Add the top card from your deck to the top of your life, then discard 2 cards.");
        sanjiYellow.setImagePath("/images/cards/OP09/OP09-105.jpg");
        cardRepository.save(sanjiYellow);

        Card nicoOlivia = new Card();
        nicoOlivia.setCardNumber("OP09-106");
        nicoOlivia.setName("Nico Olivia");
        nicoOlivia.setCardType("Character");
        nicoOlivia.setColor("Yellow");
        nicoOlivia.setCost(1);
        nicoOlivia.setPower(0);
        nicoOlivia.setCounter(2000);
        nicoOlivia.setAffiliations("Ohara");
        nicoOlivia.setAttribute("Wisdom");
        nicoOlivia.setEffect("[On Play] Give up to 1 of your leader \"Nico Robin\" Power +3000 for the turn.\n[Trigger] If your leader is \"Nico Robin\", draw 3 cards, then discard 2 cards.");
        nicoOlivia.setImagePath("/images/cards/OP09/OP09-106.jpg");
        cardRepository.save(nicoOlivia);

        Card nicoRobinYellow = new Card();
        nicoRobinYellow.setCardNumber("OP09-107");
        nicoRobinYellow.setName("Nico Robin");
        nicoRobinYellow.setCardType("Character");
        nicoRobinYellow.setColor("Yellow");
        nicoRobinYellow.setCost(6);
        nicoRobinYellow.setPower(6000);
        nicoRobinYellow.setCounter(1000);
        nicoRobinYellow.setAffiliations("Straw Hat Crew");
        nicoRobinYellow.setAttribute("Special");
        nicoRobinYellow.setEffect("[On Play] If your opponent has 3 or more life cards, trash up to one of the top cards of your opponent's life.\n[Trigger] Play up to one cost 3 or less yellow character from your hand.");
        nicoRobinYellow.setImagePath("/images/cards/OP09/OP09-107.jpg");
        cardRepository.save(nicoRobinYellow);

        Card bartholomewKuma = new Card();
        bartholomewKuma.setCardNumber("OP09-108");
        bartholomewKuma.setName("Bartholomew Kuma");
        bartholomewKuma.setCardType("Character");
        bartholomewKuma.setColor("Yellow");
        bartholomewKuma.setCost(4);
        bartholomewKuma.setPower(5000);
        bartholomewKuma.setCounter(2000);
        bartholomewKuma.setAffiliations("The Seven Warlords of the Sea / Revolutionary Army");
        bartholomewKuma.setAttribute("Strike");
        bartholomewKuma.setEffect("[Trigger] If your Leader has the {{Revolutionary Army}} type and the total of your and your opponent's Life cards is 5 or less, play this card.");
        bartholomewKuma.setImagePath("/images/cards/OP09/OP09-108.jpg");
        cardRepository.save(bartholomewKuma);

        Card jaguarDSaul = new Card();
        jaguarDSaul.setCardNumber("OP09-109");
        jaguarDSaul.setName("Jaguar D. Saul");
        jaguarDSaul.setCardType("Character");
        jaguarDSaul.setColor("Yellow");
        jaguarDSaul.setCost(3);
        jaguarDSaul.setPower(5000);
        jaguarDSaul.setCounter(1000);
        jaguarDSaul.setAffiliations("Ohara/Giants/Navy");
        jaguarDSaul.setAttribute("Strike");
        jaguarDSaul.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\n[Trigger] If your leader is \"Nico Robin\", play this card.");
        jaguarDSaul.setImagePath("/images/cards/OP09/OP09-109.jpg");
        cardRepository.save(jaguarDSaul);

        Card pierre = new Card();
        pierre.setCardNumber("OP09-110");
        pierre.setName("Pierre");
        pierre.setCardType("Character");
        pierre.setColor("Yellow");
        pierre.setCost(2);
        pierre.setPower(2000);
        pierre.setCounter(1000);
        pierre.setAffiliations("Animal / Sky island");
        pierre.setAttribute("Strike");
        pierre.setEffect("[On Play] Draw 2, then discard 2 cards.\n[Trigger] Play this card.");
        pierre.setImagePath("/images/cards/OP09/OP09-110.jpg");
        cardRepository.save(pierre);

        Card brookYellow = new Card();
        brookYellow.setCardNumber("OP09-111");
        brookYellow.setName("Brook");
        brookYellow.setCardType("Character");
        brookYellow.setColor("Yellow");
        brookYellow.setCost(5);
        brookYellow.setPower(6000);
        brookYellow.setCounter(1000);
        brookYellow.setAffiliations("Egghead/ Straw Hat Crew");
        brookYellow.setAttribute("Slash");
        brookYellow.setEffect("[Trigger] If your leader has the {Egghead} type and your opponent has 6 or more cards in their hand, your opponent discards 2 cards from their hand.");
        brookYellow.setImagePath("/images/cards/OP09/OP09-111.jpg");
        cardRepository.save(brookYellow);

        Card beloBetty = new Card();
        beloBetty.setCardNumber("OP09-112");
        beloBetty.setName("Belo Betty");
        beloBetty.setCardType("Character");
        beloBetty.setColor("Yellow");
        beloBetty.setCost(3);
        beloBetty.setPower(4000);
        beloBetty.setCounter(1000);
        beloBetty.setAffiliations("Revolutionary Army");
        beloBetty.setAttribute("Special");
        beloBetty.setEffect("[On Play] If you have 2 or less life, draw 1 card.\n[Trigger] If your Leader has the {{Revolutionary Army}} type and the total of your and your opponent's Life cards is 5 or less, play this card.");
        beloBetty.setImagePath("/images/cards/OP09/OP09-112.jpg");
        cardRepository.save(beloBetty);

        Card morley = new Card();
        morley.setCardNumber("OP09-113");
        morley.setName("Morley");
        morley.setCardType("Character");
        morley.setColor("Yellow");
        morley.setCost(4);
        morley.setPower(6000);
        morley.setCounter(1000);
        morley.setAffiliations("Revolutionary Army");
        morley.setAttribute("Special");
        // No effect is visible in the image
        morley.setImagePath("/images/cards/OP09/OP09-113.jpg");
        cardRepository.save(morley);

        Card lindburg = new Card();
        lindburg.setCardNumber("OP09-114");
        lindburg.setName("Lindburg");
        lindburg.setCardType("Character");
        lindburg.setColor("Yellow");
        lindburg.setCost(3);
        lindburg.setPower(4000);
        lindburg.setCounter(1000);
        lindburg.setAffiliations("Minks / Revolutionary Army");
        lindburg.setAttribute("Special");
        lindburg.setEffect("[On Play] If the total of your and your opponent's Life cards is 5 or less, K.O. up to 1 of your opponent's Characters with 2000 power or less.\\n[Trigger] If your Leader has the {{Revolutionary Army}} type and the total of your and your opponent's Life cards is 5 or less, play this card.");

        // Add Gold D. Roger at position OP09-118
        Card golDRoger = new Card();
        golDRoger.setCardNumber("OP09-118");
        golDRoger.setName("Gol D. Roger");
        golDRoger.setCardType("Character");
        golDRoger.setColor("Red");
        golDRoger.setCost(10);
        golDRoger.setPower(13000);
        // No Counter
        golDRoger.setAffiliations("Pirate King / Roger Pirates");
        golDRoger.setAttribute("Slash");
        golDRoger.setEffect("[Rush] (This card can attack on the turn in which it is played.)\nWhen your opponent activates a [Blocker], if you or your opponent have 0 life, you win the game.");
        golDRoger.setImagePath("/images/cards/OP09/OP09-118.jpg");
        cardRepository.save(golDRoger);

        System.out.println("Finished initializing OP09 Yellow cards");
    }
} // Closing brace for OP09Initializer class