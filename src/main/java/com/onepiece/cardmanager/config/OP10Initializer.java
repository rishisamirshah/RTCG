package com.onepiece.cardmanager.config;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(10) // Order after OP09
public class OP10Initializer extends BaseInitializer {

    private final CardRepository cardRepository;

    @Autowired
    public OP10Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    protected void initialize(String... args) throws Exception {
        // Only initialize if we have no OP10 cards
        if (cardRepository.countBySetAndCardNumberStartingWith("OP10", "OP10") > 0) {
            System.out.println("OP10 cards already exist, skipping initialization");
            return;
        }

        System.out.println("Initializing OP10 cards...");
        
        // Initialize Red cards
        initializeOP10RedCards();

        // Initialize Green cards
        initializeOP10GreenCards();
        
        // Initialize Blue cards
        initializeOP10BlueCards();
        
        // Initialize Purple cards
        initializeOP10PurpleCards();
        
        // Initialize Black cards
        initializeOP10BlackCards();
        
        // Initialize Yellow cards
        initializeOP10YellowCards();

        System.out.println("Finished initializing OP10 cards");
    }

    private void initializeOP10RedCards() {
        System.out.println("Initializing OP10 Red cards...");

        // Leaders
        Card smoker = new Card();
        smoker.setCardNumber("OP10-001");
        smoker.setName("Smoker");
        smoker.setCardType("Leader");
        smoker.setColor("Red");
        smoker.setPower(5000);
        smoker.setLife(4);
        smoker.setAffiliations("Punk Hazard / Navy");
        smoker.setEffect("Opponent's Turn: Your characters with the {Navy} or {Punk Hazard} trait gain +1000 Power\nActivate: Main (Once Per Turn): If you have a character with 7000 power or more, Set 2 DON!! as active.");
        smoker.setImagePath("/images/cards/OP10/OP10-001.jpg");
        cardRepository.save(smoker);

        Card caesarClownLeader = new Card();
        caesarClownLeader.setCardNumber("OP10-002");
        caesarClownLeader.setName("Caesar Clown");
        caesarClownLeader.setCardType("Leader");
        caesarClownLeader.setColor("Red");
        caesarClownLeader.setPower(5000);
        caesarClownLeader.setLife(4);
        caesarClownLeader.setAffiliations("Scientist / Punk Hazard");
        caesarClownLeader.setEffect("DON!! x2 (When Attacking): You may return 1 of your {Punk Hazard} type Characters with a cost of 2 or more to the owner's hand: K.O. up to 1 of your opponent's Characters with 4000 power or less.");
        caesarClownLeader.setImagePath("/images/cards/OP10/OP10-002.jpg");
        cardRepository.save(caesarClownLeader);

        Card sugar = new Card();
        sugar.setCardNumber("OP10-003");
        sugar.setName("Sugar");
        sugar.setCardType("Leader");
        sugar.setColor("Red");
        sugar.setPower(5000);
        sugar.setLife(4);
        sugar.setAffiliations("Donquixote Pirates");
        sugar.setEffect("End of Your Turn: If you have a character with the {Donquixote Pirates} type with a power of 6000 power or more, set up to 1 of your Don!! as active.\nOpponent's Turn (Once Per Turn): When you activate an event, set up to 1 of your Don!! from you Don!! deck as active.");
        sugar.setImagePath("/images/cards/OP10/OP10-003.jpg");
        cardRepository.save(sugar);

        // Characters
        Card vergo = new Card();
        vergo.setCardNumber("OP10-004");
        vergo.setName("Vergo");
        vergo.setCardType("Character");
        vergo.setColor("Red");
        vergo.setCost(1);
        vergo.setPower(2000);
        vergo.setCounter(1000);
        vergo.setAffiliations("Punk Hazard / Navy / Donquixote Pirates");
        vergo.setAttribute("Strike");
        vergo.setEffect("On Play: Look at the top 5 cards of your deck. Reveal up to one {Punk Hazard} type card other than [Vergo] and put it into your hand. Then place the rest on the bottom of your deck in any order.");
        vergo.setImagePath("/images/cards/OP10/OP10-004.jpg");
        cardRepository.save(vergo);

        Card sanji = new Card();
        sanji.setCardNumber("OP10-005");
        sanji.setName("Sanji");
        sanji.setCardType("Character");
        sanji.setColor("Red");
        sanji.setCost(3);
        sanji.setPower(3000);
        sanji.setCounter(1000);
        sanji.setAffiliations("Punk Hazard / Straw Hat Crew");
        sanji.setEffect("Your Turn: This character gain +3000 power.\nOn K.O: Draw a card.");
        sanji.setImagePath("/images/cards/OP10/OP10-005.jpg");
        cardRepository.save(sanji);

        Card caesarClown = new Card();
        caesarClown.setCardNumber("OP10-006");
        caesarClown.setName("Caesar Clown");
        caesarClown.setCardType("Character");
        caesarClown.setColor("Red");
        caesarClown.setCost(7);
        caesarClown.setPower(7000);
        caesarClown.setCounter(0);
        caesarClown.setAffiliations("Scientist / Punk Hazard");
        caesarClown.setAttribute("Special");
        caesarClown.setEffect("On Play: Look at the top 5 cards of your deck and reveal up to one [Smiley] and put it into your hand. Place the rest of the cards on the bottom of your deck. Then play up to one [Smiley] from your hand.");
        caesarClown.setImagePath("/images/cards/OP10/OP10-006.jpg");
        cardRepository.save(caesarClown);

        Card caesarSoldier = new Card();
        caesarSoldier.setCardNumber("OP10-007");
        caesarSoldier.setName("Caesar's Soldier");
        caesarSoldier.setCardType("Character");
        caesarSoldier.setColor("Red");
        caesarSoldier.setCost(3);
        caesarSoldier.setPower(4000);
        caesarSoldier.setCounter(1000);
        caesarSoldier.setAffiliations("Punk Hazard");
        caesarSoldier.setAttribute("Wisdom");
        caesarSoldier.setEffect("On Play: Play up to 1 {Punk Hazard} type Character card with a cost of 2 or less from your hand.");
        caesarSoldier.setImagePath("/images/cards/OP10/OP10-007.jpg");
        cardRepository.save(caesarSoldier);

        Card scotch = new Card();
        scotch.setCardNumber("OP10-008");
        scotch.setName("Scotch");
        scotch.setCardType("Character");
        scotch.setColor("Red");
        scotch.setCost(2);
        scotch.setPower(1000);
        scotch.setCounter(1000);
        scotch.setAffiliations("Punk Hazard");
        scotch.setEffect("Blocker: (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\nOn Play: If you do not have a (Rock), you may play up to 1 (Rock) from your hand.");
        scotch.setImagePath("/images/cards/OP10/OP10-008.jpg");
        cardRepository.save(scotch);

        Card smiley = new Card();
        smiley.setCardNumber("OP10-009");
        smiley.setName("Smiley");
        smiley.setCardType("Character");
        smiley.setColor("Red");
        smiley.setCost(5);
        smiley.setPower(6000);
        smiley.setCounter(1000);
        smiley.setAffiliations("Biological Weapon / Punk Hazard");
        smiley.setEffect("On Play: If your leader has the {Punk Hazard} type, give up to one of your opponents characters -3000 power for this turn.");
        smiley.setImagePath("/images/cards/OP10/OP10-009.jpg");
        cardRepository.save(smiley);

        Card brownBeard = new Card();
        brownBeard.setCardNumber("OP10-010");
        brownBeard.setName("Chadros Higelyges (Brown Beard)");
        brownBeard.setCardType("Character");
        brownBeard.setColor("Red");
        brownBeard.setCost(3);
        brownBeard.setPower(5000);
        brownBeard.setCounter(0);
        brownBeard.setAffiliations("Punk Hazard / Brownbeard Pirates");
        brownBeard.setAttribute("Slash");
        brownBeard.setEffect("When Attacking: If you have 1 or less Characters with 6000 or more power this character gets +1000 power during this turn.");
        brownBeard.setImagePath("/images/cards/OP10/OP10-010.jpg");
        cardRepository.save(brownBeard);

        Card chopper = new Card();
        chopper.setCardNumber("OP10-011");
        chopper.setName("Tony Tony Chopper");
        chopper.setCardType("Character");
        chopper.setColor("Red");
        chopper.setCost(4);
        chopper.setPower(4000);
        chopper.setCounter(2000);
        chopper.setAffiliations("Punk Hazard / Straw Hat Crew");
        chopper.setAttribute("Strike");
        chopper.setEffect("Blocker: (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\nOpponent's Turn: This character has +2000 power");
        chopper.setImagePath("/images/cards/OP10/OP10-011.jpg");
        cardRepository.save(chopper);

        Card dragon = new Card();
        dragon.setCardNumber("OP10-012");
        dragon.setName("Dragon No.13");
        dragon.setCardType("Character");
        dragon.setColor("Red");
        dragon.setCost(2);
        dragon.setPower(2000);
        dragon.setCounter(1000);
        dragon.setAffiliations("Biological Weapon / Punk Hazard");
        dragon.setEffect("Blocker: (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        dragon.setImagePath("/images/cards/OP10/OP10-012.jpg");
        cardRepository.save(dragon);

        Card nami = new Card();
        nami.setCardNumber("OP10-013");
        nami.setName("Nami");
        nami.setCardType("Character");
        nami.setColor("Red");
        nami.setCost(5);
        nami.setPower(7000);
        nami.setCounter(1000);
        nami.setAffiliations("Punk Hazard / Straw Hat Pirates");
        nami.setAttribute("Strike");
        nami.setImagePath("/images/cards/OP10/OP10-013.jpg");
        cardRepository.save(nami);

        Card franky = new Card();
        franky.setCardNumber("OP10-014");
        franky.setName("Franky");
        franky.setCardType("Character");
        franky.setColor("Red");
        franky.setCost(6);
        franky.setPower(8000);
        franky.setCounter(1000);
        franky.setAffiliations("Animal / Punk Hazard / Straw Hat Pirates");
        franky.setImagePath("/images/cards/OP10/OP10-014.jpg");
        cardRepository.save(franky);

        Card mocha = new Card();
        mocha.setCardNumber("OP10-015");
        mocha.setName("Mocha");
        mocha.setCardType("Character");
        mocha.setColor("Red");
        mocha.setCost(3);
        mocha.setPower(3000);
        mocha.setCounter(2000);
        mocha.setAffiliations("Punk Hazard");
        mocha.setAttribute("Strike");
        mocha.setEffect("On Play: Give up to 1 of your opponent's characters -1000 power during this turn.");
        mocha.setImagePath("/images/cards/OP10/OP10-015.jpg");
        cardRepository.save(mocha);

        Card monet = new Card();
        monet.setCardNumber("OP10-016");
        monet.setName("Monet");
        monet.setCardType("Character");
        monet.setColor("Red");
        monet.setCost(2);
        monet.setPower(3000);
        monet.setCounter(1000);
        monet.setAffiliations("Punk Hazard / Donquixote Pirates");
        monet.setEffect("Activate: Main: You may rest this Character: Give up to 2 rested DON!! cards to your Leader or 1 of your Characters. Then, give up to 1 of your opponent's characters -1000 Power during this turn.");
        monet.setImagePath("/images/cards/OP10/OP10-016.jpg");
        cardRepository.save(monet);

        Card rock = new Card();
        rock.setCardNumber("OP10-017");
        rock.setName("Rock");
        rock.setCardType("Character");
        rock.setColor("Red");
        rock.setCost(2);
        rock.setPower(3000);
        rock.setCounter(1000);
        rock.setAffiliations("Punk Hazard");
        rock.setAttribute("Strike");
        rock.setEffect("On Play: If you do not have a (Scotch), you may play up to 1 (Scotch) from your hand.");
        rock.setImagePath("/images/cards/OP10/OP10-017.jpg");
        cardRepository.save(rock);

        // Events
        Card kamakuraJussoushi = new Card();
        kamakuraJussoushi.setCardNumber("OP10-018");
        kamakuraJussoushi.setName("Kamakura Jussoushi");
        kamakuraJussoushi.setCardType("Event");
        kamakuraJussoushi.setColor("Red");
        kamakuraJussoushi.setCost(2);
        kamakuraJussoushi.setAffiliations("Punk Hazard / Donquixote Pirates");
        kamakuraJussoushi.setEffect("Counter: Choose up to 1 of your leader or character, it gains +3000 during this battle. Afterwards, one of your opponent's leader or character gets -2000 during this turn.\nTrigger: Choose up to 1 of your leader/character, it gets +1000 during this turn.");
        kamakuraJussoushi.setImagePath("/images/cards/OP10/OP10-018.jpg");
        cardRepository.save(kamakuraJussoushi);

        Card divineDeparture = new Card();
        divineDeparture.setCardNumber("OP10-019");
        divineDeparture.setName("Divine Departure");
        divineDeparture.setCardType("Event");
        divineDeparture.setColor("Red");
        divineDeparture.setCost(1);
        divineDeparture.setAffiliations("Four Emperors / Red Hair Pirates");
        divineDeparture.setEffect("Main: You may rest 5 DON!!: KO up to 1 of your opponent's characters with 8000 Power or less.\nCounter: Up to 1 of your Leaders gains +3000 Power during this battle.");
        divineDeparture.setImagePath("/images/cards/OP10/OP10-019.jpg");
        cardRepository.save(divineDeparture);

        Card gumGumUFO = new Card();
        gumGumUFO.setCardNumber("OP10-020");
        gumGumUFO.setName("Gum-Gum UFO");
        gumGumUFO.setCardType("Event");
        gumGumUFO.setColor("Red");
        gumGumUFO.setCost(2);
        gumGumUFO.setAffiliations("Straw Hat Crew / Punk Hazard");
        gumGumUFO.setEffect("Main: Give up to 1 of your opponent's characters -4000 power until the end of this turn. Then if you have 2 or less life give your leader or up to 1 of your characters +1000 power until the end of this turn.\nTrigger: K.O. up to 1 of your opponents 3000 power or less characters.");
        gumGumUFO.setImagePath("/images/cards/OP10/OP10-020.jpg");
        cardRepository.save(gumGumUFO);

        System.out.println("Finished initializing OP10 Red cards");
    }

    private void initializeOP10GreenCards() {
        System.out.println("Initializing OP10 Green cards...");

        // Leaders
        Card trafalgarLaw = new Card();
        trafalgarLaw.setCardNumber("OP10-022");
        trafalgarLaw.setName("Trafalgar Law");
        trafalgarLaw.setCardType("Leader");
        trafalgarLaw.setColor("Green");
        trafalgarLaw.setPower(5000);
        trafalgarLaw.setLife(4);
        trafalgarLaw.setAffiliations("Heart Pirates / Supernova / Dressrosa");
        trafalgarLaw.setEffect("DON!! x1 (Activate: Main) (Once Per Turn): If the total cost of your characters is 5 or more, you can return 1 of your characters to the hand: Reveal the top of your life, and if that card is a {Supernova} type character card with a cost of 5 or less, you can play it.");
        trafalgarLaw.setImagePath("/images/cards/OP10/OP10-022.jpg");
        cardRepository.save(trafalgarLaw);

        // Characters
        Card issho = new Card();
        issho.setCardNumber("OP10-023");
        issho.setName("Issho");
        issho.setCardType("Character");
        issho.setColor("Green");
        issho.setCost(5);
        issho.setPower(6000);
        issho.setCounter(1000);
        issho.setAffiliations("Dressrosa / Navy");
        issho.setAttribute("Slash");
        issho.setEffect("On Play: If your leader has the \"Navy\" type, Rest up to 2 of your opponent's characters with cost 5 or below.");
        issho.setImagePath("/images/cards/OP10/OP10-023.jpg");
        cardRepository.save(issho);

        Card edwardNewgate = new Card();
        edwardNewgate.setCardNumber("OP10-024");
        edwardNewgate.setName("Edward Newgate");
        edwardNewgate.setCardType("Character");
        edwardNewgate.setColor("Green");
        edwardNewgate.setCost(5);
        edwardNewgate.setPower(6000);
        edwardNewgate.setCounter(1000);
        edwardNewgate.setAffiliations("Odyssey / Four Emperors / Whitebeard Pirates");
        edwardNewgate.setAttribute("Special");
        edwardNewgate.setEffect("On Play: If you have 2 or more rested Characters, rest up to 1 of your opponent's Characters of 5 cost or less. Then, KO up to one of your opponents rested Character of 3 cost or less.");
        edwardNewgate.setImagePath("/images/cards/OP10/OP10-024.jpg");
        cardRepository.save(edwardNewgate);

        Card enel = new Card();
        enel.setCardNumber("OP10-025");
        enel.setName("Enel");
        enel.setCardType("Character");
        enel.setColor("Green");
        enel.setCost(5);
        enel.setPower(6000);
        enel.setCounter(1000);
        enel.setAffiliations("Odyssey / Sky Island");
        enel.setAttribute("Special");
        enel.setEffect("On Play: If you have 2 or more rested characters, draw 3 cards and discard 2 cards from your hand.");
        enel.setImagePath("/images/cards/OP10/OP10-025.jpg");
        cardRepository.save(enel);

        Card kinemon1 = new Card();
        kinemon1.setCardNumber("OP10-026");
        kinemon1.setName("Kin'emon");
        kinemon1.setCardType("Character");
        kinemon1.setColor("Green");
        kinemon1.setCost(2);
        kinemon1.setPower(1000);
        kinemon1.setCounter(1000);
        kinemon1.setAffiliations("Punk Hazard / Wano Country / Nine Red Scabbards");
        kinemon1.setAttribute("Slash");
        kinemon1.setEffect("Activate: Main: You may place this character and a \"Kin'emon\" with 0 power from your trash to the bottom of your deck in your any order: Play up to one \"Kin'emon\" with 6 cost from your hand.");
        kinemon1.setImagePath("/images/cards/OP10/OP10-026.jpg");
        cardRepository.save(kinemon1);

        Card kinemon2 = new Card();
        kinemon2.setCardNumber("OP10-027");
        kinemon2.setName("Kin'emon");
        kinemon2.setCardType("Character");
        kinemon2.setColor("Green");
        kinemon2.setCost(2);
        kinemon2.setPower(0);
        kinemon2.setCounter(2000);
        kinemon2.setAffiliations("Punk Hazard / Wano Country / Nine Red Scabbards");
        kinemon2.setAttribute("Slash");
        kinemon2.setEffect("Activate: Main: You may place this character and a \"Kin'emon\" with 1000 power from your trash to the bottom of your deck in your any order: Play up to one \"Kin'emon\" with 6 cost from your hand.");
        kinemon2.setImagePath("/images/cards/OP10/OP10-027.jpg");
        cardRepository.save(kinemon2);

        Card kozukiMomonosuke = new Card();
        kozukiMomonosuke.setCardNumber("OP10-028");
        kozukiMomonosuke.setName("Kozuki Momonosuke");
        kozukiMomonosuke.setCardType("Character");
        kozukiMomonosuke.setColor("Green");
        kozukiMomonosuke.setCost(1);
        kozukiMomonosuke.setPower(1000);
        kozukiMomonosuke.setCounter(1000);
        kozukiMomonosuke.setAffiliations("Punk Hazard / Land of Wano / Kozuki Clan");
        kozukiMomonosuke.setAttribute("Special");
        kozukiMomonosuke.setEffect("Activate: Main: You may rest two of your Don!! and place this character into your trash: Look at the top 5 cards of your deck. Reveal up to two \"The Akazaya 9\" type cards and put them into your hand. Then bottom the rest in any order.");
        kozukiMomonosuke.setImagePath("/images/cards/OP10/OP10-028.jpg");
        cardRepository.save(kozukiMomonosuke);

        Card draculeMihawk = new Card();
        draculeMihawk.setCardNumber("OP10-029");
        draculeMihawk.setName("Dracule Mihawk");
        draculeMihawk.setCardType("Character");
        draculeMihawk.setColor("Green");
        draculeMihawk.setCost(5);
        draculeMihawk.setPower(6000);
        draculeMihawk.setCounter(1000);
        draculeMihawk.setAffiliations("Odyssey / Seven Warlords of the Sea");
        draculeMihawk.setAttribute("Slash");
        draculeMihawk.setEffect("On Play: If you have 2 or more rested characters, set up to one of your cost 5 or lower rested {Odyssey} type characters as active.");
        draculeMihawk.setImagePath("/images/cards/OP10/OP10-029.jpg");
        cardRepository.save(draculeMihawk);

        Card smoker = new Card();
        smoker.setCardNumber("OP10-030");
        smoker.setName("Smoker");
        smoker.setCardType("Character");
        smoker.setColor("Green");
        smoker.setCost(5);
        smoker.setPower(7000);
        smoker.setCounter(0);
        smoker.setAffiliations("Punk Hazard / Navy");
        smoker.setEffect("Banish: (When a character deals damage, the target card is trashed without activating its Trigger)\nActivate: Main: Set up to 2 of your Don!! cards as active. Then, you cannot set your Don!! cards as active through characters effects for the rest of this turn.");
        smoker.setImagePath("/images/cards/OP10/OP10-030.jpg");
        cardRepository.save(smoker);

        Card sengoku = new Card();
        sengoku.setCardNumber("OP10-031");
        sengoku.setName("Sengoku");
        sengoku.setCardType("Character");
        sengoku.setColor("Green");
        sengoku.setCost(5);
        sengoku.setPower(7000);
        sengoku.setCounter(1000);
        sengoku.setAffiliations("Dressrosa / Navy");
        sengoku.setAttribute("Wisdom");
        sengoku.setImagePath("/images/cards/OP10/OP10-031.jpg");
        cardRepository.save(sengoku);

        Card tashigi = new Card();
        tashigi.setCardNumber("OP10-032");
        tashigi.setName("Tashigi");
        tashigi.setCardType("Character");
        tashigi.setColor("Green");
        tashigi.setCost(3);
        tashigi.setPower(4000);
        tashigi.setCounter(2000);
        tashigi.setAffiliations("Punk Hazard / Navy");
        tashigi.setEffect("When one of your green characters other than [Tashigi] would be removed from play due to your opponent's effects, you may instead rest this character.");
        tashigi.setImagePath("/images/cards/OP10/OP10-032.jpg");
        cardRepository.save(tashigi);

        Card nami = new Card();
        nami.setCardNumber("OP10-033");
        nami.setName("Nami");
        nami.setCardType("Character");
        nami.setColor("Green");
        nami.setCost(2);
        nami.setPower(2000);
        nami.setCounter(2000);
        nami.setAffiliations("Odyssey / Straw Hat Pirates");
        nami.setAttribute("Special");
        nami.setEffect("On Play: If you have two or more rested {Odyssey} type Characters, up to one of your opponent's rested Don!! will not become active during your opponent's next Refresh Phase.");
        nami.setImagePath("/images/cards/OP10/OP10-033.jpg");
        cardRepository.save(nami);

        Card franky = new Card();
        franky.setCardNumber("OP10-034");
        franky.setName("Franky");
        franky.setCardType("Character");
        franky.setColor("Green");
        franky.setCost(4);
        franky.setPower(5000);
        franky.setCounter(1000);
        franky.setAffiliations("Odyssey / Straw Hat Crew");
        franky.setAttribute("Strike");
        franky.setEffect("Once Per Turn: If this character were to be KO'd in battle, you may instead add the top card of your life to your hand.");
        franky.setImagePath("/images/cards/OP10/OP10-034.jpg");
        cardRepository.save(franky);

        Card brook = new Card();
        brook.setCardNumber("OP10-035");
        brook.setName("Brook");
        brook.setCardType("Character");
        brook.setColor("Green");
        brook.setCost(3);
        brook.setPower(5000);
        brook.setCounter(0);
        brook.setAffiliations("Odyssey / Straw Hat Crew");
        brook.setAttribute("Slash");
        brook.setEffect("On K.O: Rest up to 1 of your opponent's leader or cost 5 or lower characters.");
        brook.setImagePath("/images/cards/OP10/OP10-035.jpg");
        cardRepository.save(brook);

        Card perona = new Card();
        perona.setCardNumber("OP10-036");
        perona.setName("Perona");
        perona.setCardType("Character");
        perona.setColor("Green");
        perona.setCost(4);
        perona.setPower(5000);
        perona.setCounter(1000);
        perona.setAffiliations("Odyssey / Shikkearu Kingdom / Thriller Bark Pirates");
        perona.setEffect("Your Turn (Once Per Turn): When a character is rested by one of your effects, set up to 1 of your DON!! active.");
        perona.setImagePath("/images/cards/OP10/OP10-036.jpg");
        cardRepository.save(perona);

        Card lim = new Card();
        lim.setCardNumber("OP10-037");
        lim.setName("Lim");
        lim.setCardType("Character");
        lim.setColor("Green");
        lim.setCost(1);
        lim.setPower(0);
        lim.setCounter(1000);
        lim.setAffiliations("Odyssey");
        lim.setAttribute("Wisdom");
        lim.setEffect("Once Per Turn: If this character were to be removed from the board by one of your opponent's effects, you may instead rest 1 of your {Odyssey} Characters.\nEnd of Your Turn: You may set up to 1 of your {Odyssey} type characters active.");
        lim.setImagePath("/images/cards/OP10/OP10-037.jpg");
        cardRepository.save(lim);

        Card roronoaZoro = new Card();
        roronoaZoro.setCardNumber("OP10-038");
        roronoaZoro.setName("Roronoa Zoro");
        roronoaZoro.setCardType("Character");
        roronoaZoro.setColor("Green");
        roronoaZoro.setCost(5);
        roronoaZoro.setPower(6000);
        roronoaZoro.setCounter(1000);
        roronoaZoro.setAffiliations("Odyssey / Supernova / Straw Hat Pirates");
        roronoaZoro.setAttribute("Slash");
        roronoaZoro.setEffect("Opponent's Turn: If you have 2 or more rested characters, this character gains +2000 power.");
        roronoaZoro.setImagePath("/images/cards/OP10/OP10-038.jpg");
        cardRepository.save(roronoaZoro);

        // Events
        Card gumGumDragonFirePistolTwisterStar = new Card();
        gumGumDragonFirePistolTwisterStar.setCardNumber("OP10-039");
        gumGumDragonFirePistolTwisterStar.setName("Gum-Gum Dragon Fire Pistol Twister Star");
        gumGumDragonFirePistolTwisterStar.setCardType("Event");
        gumGumDragonFirePistolTwisterStar.setColor("Green");
        gumGumDragonFirePistolTwisterStar.setCost(3);
        gumGumDragonFirePistolTwisterStar.setAffiliations("Odyssey / Supernova / Straw Hat Pirates");
        gumGumDragonFirePistolTwisterStar.setEffect("Main: If your leader has the \"Odyssey\" type, look at the 5 cards from the top of your deck, reveal up to 2 character cards with the \"Odyssey\" type and add them to your hand. Then, put the rest at the bottom of your deck in any order.\nTrigger: Rest up to one of your opponent's characters with a cost of 5 or less.");
        gumGumDragonFirePistolTwisterStar.setImagePath("/images/cards/OP10/OP10-039.jpg");
        cardRepository.save(gumGumDragonFirePistolTwisterStar);

        Card theWeakDontGetToChoseHowTheyDie = new Card();
        theWeakDontGetToChoseHowTheyDie.setCardNumber("OP10-040");
        theWeakDontGetToChoseHowTheyDie.setName("The Weak Don't Get to Chose How They Die");
        theWeakDontGetToChoseHowTheyDie.setCardType("Event");
        theWeakDontGetToChoseHowTheyDie.setColor("Green");
        theWeakDontGetToChoseHowTheyDie.setCost(5);
        theWeakDontGetToChoseHowTheyDie.setAffiliations("Punk Hazard / Supernova / Heart Pirates");
        theWeakDontGetToChoseHowTheyDie.setEffect("Main / Counter: KO up to one of your opponent's rested characters with a cost of 7 or less.");
        theWeakDontGetToChoseHowTheyDie.setImagePath("/images/cards/OP10/OP10-040.jpg");
        cardRepository.save(theWeakDontGetToChoseHowTheyDie);

        Card radioKnife = new Card();
        radioKnife.setCardNumber("OP10-041");
        radioKnife.setName("Radio Knife");
        radioKnife.setCardType("Event");
        radioKnife.setColor("Green");
        radioKnife.setCost(4);
        radioKnife.setAffiliations("Dressrosa / Supernova / Heart Pirates");
        radioKnife.setEffect("Main: Rest up to 1 of your opponent's cost 6 or lower characters. Then, KO up to 1 of your opponent's rested 5 cost or lower characters.\nTrigger: Rest up to 1 of your opponent's 4 cost characters.");
        radioKnife.setImagePath("/images/cards/OP10/OP10-041.jpg");
        cardRepository.save(radioKnife);

        System.out.println("Finished initializing OP10 Green cards");
    }

    private void initializeOP10BlueCards() {
        System.out.println("Initializing OP10 Blue cards...");

        // Leaders
        Card usopp = new Card();
        usopp.setCardNumber("OP10-042");
        usopp.setName("Usopp");
        usopp.setCardType("Leader");
        usopp.setColor("Blue");
        usopp.setPower(5000);
        usopp.setLife(4);
        usopp.setAffiliations("Dressrosa / StrawHat Crew");
        usopp.setEffect("Your cost 2 and greater {Dressrosa} type characters have +1 cost.\nOpponent's Turn (Once Per Turn): This effect may be activated when one of your {Dressrosa} type Characters are removed from the field by your opponent's effect, or are K.O'd. If you have 5 or less cards in your hand, draw 1 card.");
        usopp.setImagePath("/images/cards/OP10/OP10-042.jpg");
        cardRepository.save(usopp);

        // Characters
        Card ucy = new Card();
        ucy.setCardNumber("OP10-043");
        ucy.setName("Ucy");
        ucy.setCardType("Character");
        ucy.setColor("Blue");
        ucy.setCost(2);
        ucy.setPower(2000);
        ucy.setCounter(2000);
        ucy.setAffiliations("Dressrosa/Animal");
        ucy.setAttribute("Strike");
        ucy.setEffect("On Play: You may rest up to 1 of your \"Dressrosa\" type Leaders or Stages: Up to one of your character [Monkey D. Luffy] <Banish> until the end of turn.");
        ucy.setImagePath("/images/cards/OP10/OP10-043.jpg");
        cardRepository.save(ucy);

        Card kabu = new Card();
        kabu.setCardNumber("OP10-044");
        kabu.setName("Kabu");
        kabu.setCardType("Character");
        kabu.setColor("Blue");
        kabu.setCost(1);
        kabu.setPower(2000);
        kabu.setCounter(1000);
        kabu.setAffiliations("The Tontatta / Dressrosa");
        kabu.setAttribute("Slash");
        kabu.setEffect("On Play: You may rest 1 of your {Dressrosa} type Leader or Stage: Place up to 1 of your opponent's Characters with a Cost of 1 or less to the bottom of its owner's deck.");
        kabu.setImagePath("/images/cards/OP10/OP10-044.jpg");
        cardRepository.save(kabu);

        Card cavendish = new Card();
        cavendish.setCardNumber("OP10-045");
        cavendish.setName("Cavendish");
        cavendish.setCardType("Character");
        cavendish.setColor("Blue");
        cavendish.setCost(4);
        cavendish.setPower(6000);
        cavendish.setCounter(0);
        cavendish.setAffiliations("Dressrosa/Beautiful Pirates");
        cavendish.setAttribute("Slash");
        cavendish.setEffect("When Attacking (Once Per Turn): Draw 2 cards and trash 1 card from your hand.");
        cavendish.setImagePath("/images/cards/OP10/OP10-045.jpg");
        cardRepository.save(cavendish);

        Card kyros = new Card();
        kyros.setCardNumber("OP10-046");
        kyros.setName("Kyros");
        kyros.setCardType("Character");
        kyros.setColor("Blue");
        kyros.setCost(7);
        kyros.setPower(9000);
        kyros.setCounter(0);
        kyros.setAffiliations("Dressrosa");
        kyros.setAttribute("Strike");
        kyros.setEffect("On Play: Return a cost 5 or lower character to its owner's hand.");
        kyros.setImagePath("/images/cards/OP10/OP10-046.jpg");
        cardRepository.save(kyros);

        Card koala = new Card();
        koala.setCardNumber("OP10-047");
        koala.setName("Koala");
        koala.setCardType("Character");
        koala.setColor("Blue");
        koala.setCost(2);
        koala.setPower(3000);
        koala.setCounter(1000);
        koala.setAffiliations("Dressrosa / Revolutionary Army");
        koala.setAttribute("Strike");
        koala.setEffect("When Attacking: You may return 1 of your {Revolutionary Army} type Characters with a cost of 3 or more to the owner's hand: This Character gains +3000 power during this turn.");
        koala.setImagePath("/images/cards/OP10/OP10-047.jpg");
        cardRepository.save(koala);

        Card sai = new Card();
        sai.setCardNumber("OP10-048");
        sai.setName("Sai");
        sai.setCardType("Character");
        sai.setColor("Blue");
        sai.setCost(3);
        sai.setPower(5000);
        sai.setCounter(0);
        sai.setAffiliations("Dressrosa/Happo Navy");
        sai.setAttribute("Slash");
        sai.setEffect("On Play: You may rest 1 of your {Dressrosa} type Leader or Stage: Place up to 1 of your opponent's Characters with a Cost of 1 or less to the bottom of its owner's deck.");
        sai.setImagePath("/images/cards/OP10/OP10-048.jpg");
        cardRepository.save(sai);

        Card sabo = new Card();
        sabo.setCardNumber("OP10-049");
        sabo.setName("Sabo");
        sabo.setCardType("Character");
        sabo.setColor("Blue");
        sabo.setCost(4);
        sabo.setPower(5000);
        sabo.setCounter(2000);
        sabo.setAffiliations("Revolutionary Army / Dressrosa");
        sabo.setEffect("If one of your characters other than \"Sabo\" with an original cost of 7 cost or lower would be removed from the board by your opponent's effect, you may instead return this character to your hand.");
        sabo.setImagePath("/images/cards/OP10/OP10-049.jpg");
        cardRepository.save(sabo);

        Card hajrudin = new Card();
        hajrudin.setCardNumber("OP10-050");
        hajrudin.setName("Hajrudin");
        hajrudin.setCardType("Character");
        hajrudin.setColor("Blue");
        hajrudin.setCost(7);
        hajrudin.setPower(9000);
        hajrudin.setCounter(1000);
        hajrudin.setAffiliations("Giant / Dressrosa / New Giant Pirates");
        hajrudin.setAttribute("Strike");
        hajrudin.setImagePath("/images/cards/OP10/OP10-050.jpg");
        cardRepository.save(hajrudin);

        Card hack = new Card();
        hack.setCardNumber("OP10-051");
        hack.setName("Hack");
        hack.setCardType("Character");
        hack.setColor("Blue");
        hack.setCost(4);
        hack.setPower(5000);
        hack.setCounter(1000);
        hack.setAffiliations("Fishman / Dressrosa / Revolutionary Army");
        hack.setEffect("DON!! x1 (When Attacking): Look at 3 cards from the top of your deck, reveal up to one {Revolutionary Army} type card and add it to your hand. Then, place the rest at the bottom of your deck in any order.");
        hack.setImagePath("/images/cards/OP10/OP10-051.jpg");
        cardRepository.save(hack);

        Card bartolomeo = new Card();
        bartolomeo.setCardNumber("OP10-052");
        bartolomeo.setName("Bartolomeo");
        bartolomeo.setCardType("Character");
        bartolomeo.setColor("Blue");
        bartolomeo.setCost(5);
        bartolomeo.setPower(6000);
        bartolomeo.setCounter(0);
        bartolomeo.setAffiliations("Dressrosa/Barto Club");
        bartolomeo.setEffect("Blocker: (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\nOn Play: Return up to one character with a cost of 1 or below to the bottom of the player's deck.");
        bartolomeo.setImagePath("/images/cards/OP10/OP10-052.jpg");
        cardRepository.save(bartolomeo);

        Card bian = new Card();
        bian.setCardNumber("OP10-053");
        bian.setName("Bian");
        bian.setCardType("Character");
        bian.setColor("Blue");
        bian.setCost(1);
        bian.setPower(1000);
        bian.setCounter(1000);
        bian.setAffiliations("Tontatta / Dressrosa");
        bian.setEffect("If you have a character with the \"Tontatta Kingdom\" type on your field other than \"Bian\", this character gains Blocker");
        bian.setImagePath("/images/cards/OP10/OP10-053.jpg");
        cardRepository.save(bian);

        Card blueGilly = new Card();
        blueGilly.setCardNumber("OP10-054");
        blueGilly.setName("Blue Gilly");
        blueGilly.setCardType("Character");
        blueGilly.setColor("Blue");
        blueGilly.setCost(3);
        blueGilly.setPower(5000);
        blueGilly.setCounter(1000);
        blueGilly.setAffiliations("Dressrosa");
        blueGilly.setAttribute("Strike");
        blueGilly.setImagePath("/images/cards/OP10/OP10-054.jpg");
        cardRepository.save(blueGilly);

        Card marco = new Card();
        marco.setCardNumber("OP10-055");
        marco.setName("Marco");
        marco.setCardType("Character");
        marco.setColor("Blue");
        marco.setCost(3);
        marco.setPower(5000);
        marco.setCounter(0);
        marco.setAffiliations("Whitebeard Pirates");
        marco.setEffect("Blocker: (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\nOn K.O: Return up to 1 of your opponent's character with a cost of 4 or below back to their hand.");
        marco.setImagePath("/images/cards/OP10/OP10-055.jpg");
        cardRepository.save(marco);

        Card mansherry = new Card();
        mansherry.setCardNumber("OP10-056");
        mansherry.setName("Mansherry");
        mansherry.setCardType("Character");
        mansherry.setColor("Blue");
        mansherry.setCost(2);
        mansherry.setPower(0);
        mansherry.setCounter(1000);
        mansherry.setAffiliations("Tontatta / Dressrosa");
        mansherry.setEffect("On Play: You may rest one of your {Dressrosa} type leaders or stage cards, and return one of your cost 4 or greater {Dressrosa} type characters to your hand: Return up to one of your opponent's cost 4 or lower characters to its owner's hand.");
        mansherry.setImagePath("/images/cards/OP10/OP10-056.jpg");
        cardRepository.save(mansherry);

        Card leo = new Card();
        leo.setCardNumber("OP10-057");
        leo.setName("Leo");
        leo.setCardType("Character");
        leo.setColor("Blue");
        leo.setCost(1);
        leo.setPower(2000);
        leo.setCounter(1000);
        leo.setAffiliations("Tontatta / Dressrosa");
        leo.setAttribute("Strike");
        leo.setEffect("On Play: You may rest one of your leader or stage: If your leader is Usopp, look at the top 5 cards of your deck. Reveal up to 2 cards other than [Leo] that have the {Dressrosa} type, and put them into your hand. Put the rest on the bottom of your deck and trash 1 card from your hand.");
        leo.setImagePath("/images/cards/OP10/OP10-057.jpg");
        cardRepository.save(leo);

        Card rebecca = new Card();
        rebecca.setCardNumber("OP10-058");
        rebecca.setName("Rebecca");
        rebecca.setCardType("Character");
        rebecca.setColor("Blue");
        rebecca.setCost(7);
        rebecca.setPower(4000);
        rebecca.setCounter(1000);
        rebecca.setAffiliations("Dressrosa");
        rebecca.setAttribute("Slash");
        rebecca.setEffect("On Play: If there is a cost 8 or greater character in play, draw 1 card. Then reveal up to 2 cost 7 or lower {Dressrosa} type characters other than \"Rebecca\" from your hand. Play one of them as active, then if the other has a cost of 4 or lower play it as rested.");
        rebecca.setImagePath("/images/cards/OP10/OP10-058.jpg");
        cardRepository.save(rebecca);

        // Events
        Card followMe = new Card();
        followMe.setCardNumber("OP10-059");
        followMe.setName("Follow... me... and... I... will... guide... you... all...!!!!");
        followMe.setCardType("Event");
        followMe.setColor("Blue");
        followMe.setCost(1);
        followMe.setAffiliations("Dressrosa / Straw Hat Crew");
        followMe.setEffect("Main: Look at the top 5 cards of your deck, reveal up to 1 \"Dressrosa\" type card and add it to your hand. Then, place the reset on the on the bottom of your deck in any order.\nTrigger: Activate this card's Main effect.");
        followMe.setImagePath("/images/cards/OP10/OP10-059.jpg");
        cardRepository.save(followMe);

        Card bariBariBistol = new Card();
        bariBariBistol.setCardNumber("OP10-060");
        bariBariBistol.setName("Bari-Bari Pistol");
        bariBariBistol.setCardType("Event");
        bariBariBistol.setColor("Blue");
        bariBariBistol.setCost(5);
        bariBariBistol.setAffiliations("Dressrosa / Barto Club");
        bariBariBistol.setEffect("Main: Place up to one of your opponent's character with 6000 power or less at the bottom of the owner's deck.\nTrigger: Activate this card's Main effect.");
        bariBariBistol.setImagePath("/images/cards/OP10/OP10-060.jpg");
        cardRepository.save(bariBariBistol);

        Card specialLongRangedAttack = new Card();
        specialLongRangedAttack.setCardNumber("OP10-061");
        specialLongRangedAttack.setName("Special Long Ranged Attack: Bagworm!");
        specialLongRangedAttack.setCardType("Event");
        specialLongRangedAttack.setColor("Blue");
        specialLongRangedAttack.setCost(3);
        specialLongRangedAttack.setAffiliations("Dressrosa / Straw Hat Crew");
        specialLongRangedAttack.setEffect("Main: Draw 1 card. Then return up to one of your opponent's cost 2 or lower characters to its owners hand.\nTrigger: Return up to one cost 2 or lower character to its owner's hand.");
        specialLongRangedAttack.setImagePath("/images/cards/OP10/OP10-061.jpg");
        cardRepository.save(specialLongRangedAttack);

        System.out.println("Finished initializing OP10 Blue cards");
    }

    private void initializeOP10PurpleCards() {
        System.out.println("Initializing OP10 Purple cards...");

        // Characters
        Card viola = new Card();
        viola.setCardNumber("OP10-062");
        viola.setName("Viola");
        viola.setCardType("Character");
        viola.setColor("Purple");
        viola.setCost(3);
        viola.setPower(4000);
        viola.setCounter(1000);
        viola.setAffiliations("Donquixote Pirates");
        viola.setEffect("Blocker: (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\nOn K.O: DON!! -1: If your leader's type includes \"Donquixote Pirates\", add up to 1 purple event card from your trash to your hand.");
        viola.setImagePath("/images/cards/OP10/OP10-062.jpg");
        cardRepository.save(viola);

        Card vinsmokeSanji = new Card();
        vinsmokeSanji.setCardNumber("OP10-063");
        vinsmokeSanji.setName("Vinsmoke Sanji");
        vinsmokeSanji.setCardType("Character");
        vinsmokeSanji.setColor("Purple");
        vinsmokeSanji.setCost(1);
        vinsmokeSanji.setPower(2000);
        vinsmokeSanji.setCounter(1000);
        vinsmokeSanji.setAffiliations("Germa Kingdom / Vinsmoke Family");
        vinsmokeSanji.setAttribute("Strike");
        vinsmokeSanji.setEffect("On Play: If your leader has {Germa} included in its types, look at the top 5 cards of your deck. Reveal up to one card with {Germa} included in its types and put it into your hand. Place the rest on the bottom of your deck in any order.");
        vinsmokeSanji.setImagePath("/images/cards/OP10/OP10-063.jpg");
        cardRepository.save(vinsmokeSanji);

        Card replicateSoldier = new Card();
        replicateSoldier.setCardNumber("OP10-064");
        replicateSoldier.setName("Replicate soldier");
        replicateSoldier.setCardType("Character");
        replicateSoldier.setColor("Purple");
        replicateSoldier.setCost(2);
        replicateSoldier.setPower(2000);
        replicateSoldier.setCounter(1000);
        replicateSoldier.setAffiliations("Germa Kingdom");
        replicateSoldier.setEffect("Blocker: (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        replicateSoldier.setImagePath("/images/cards/OP10/OP10-064.jpg");
        cardRepository.save(replicateSoldier);

        Card sugar = new Card();
        sugar.setCardNumber("OP10-065");
        sugar.setName("Sugar");
        sugar.setCardType("Character");
        sugar.setColor("Purple");
        sugar.setCost(1);
        sugar.setPower(1000);
        sugar.setCounter(1000);
        sugar.setAffiliations("Donquixote Pirates");
        sugar.setEffect("Activate: Main: You may rest 1 of your DON!! and this character: Look at the top 5 cards of your deck, reveal up to 1 card with the {Donquixote Pirates} type and add it to your hand. Place the rest at the bottom of your deck in any order.");
        sugar.setImagePath("/images/cards/OP10/OP10-065.jpg");
        cardRepository.save(sugar);

        Card giolla = new Card();
        giolla.setCardNumber("OP10-066");
        giolla.setName("Giolla");
        giolla.setCardType("Character");
        giolla.setColor("Purple");
        giolla.setCost(2);
        giolla.setPower(2000);
        giolla.setCounter(2000);
        giolla.setAffiliations("Donquixote Pirates");
        giolla.setEffect("When opponent attack (Once Per Turn): You may rest 2 of your DON!!: Rest up to 1 of your opponent's Characters with a cost of 4 or lower.");
        giolla.setImagePath("/images/cards/OP10/OP10-066.jpg");
        cardRepository.save(giolla);

        Card senorPink = new Card();
        senorPink.setCardNumber("OP10-067");
        senorPink.setName("Senor Pink");
        senorPink.setCardType("Character");
        senorPink.setColor("Purple");
        senorPink.setCost(5);
        senorPink.setPower(6000);
        senorPink.setCounter(0);
        senorPink.setAffiliations("Donquixote Pirates");
        senorPink.setEffect("On Play: DON!!-1: Add up to 1 purple Event card with a cost of 5 or less from your trash to your hand. Then, set up to 1 of your DON!! cards as active.");
        senorPink.setImagePath("/images/cards/OP10/OP10-067.jpg");
        cardRepository.save(senorPink);

        Card diamante = new Card();
        diamante.setCardNumber("OP10-068");
        diamante.setName("Diamante");
        diamante.setCardType("Character");
        diamante.setColor("Purple");
        diamante.setCost(3);
        diamante.setPower(7000);
        diamante.setCounter(1000);
        diamante.setAffiliations("Donquixote Pirates");
        diamante.setImagePath("/images/cards/OP10/OP10-068.jpg");
        cardRepository.save(diamante);

        Card fightingFish = new Card();
        fightingFish.setCardNumber("OP10-069");
        fightingFish.setName("Fighting Fish");
        fightingFish.setCardType("Character");
        fightingFish.setColor("Purple");
        fightingFish.setCost(4);
        fightingFish.setPower(6000);
        fightingFish.setCounter(1000);
        fightingFish.setAffiliations("Animal / Dressrosa");
        fightingFish.setAttribute("Strike");
        fightingFish.setEffect("DON!! x1 (When Attacking): DON!! -1: K.O. up to 1 of your opponent's Characters with a Cost of 1 or lower.");
        fightingFish.setImagePath("/images/cards/OP10/OP10-069.jpg");
        cardRepository.save(fightingFish);

        Card trebol = new Card();
        trebol.setCardNumber("OP10-070");
        trebol.setName("Trebol");
        trebol.setCardType("Character");
        trebol.setColor("Purple");
        trebol.setCost(4);
        trebol.setPower(5000);
        trebol.setCounter(1000);
        trebol.setAffiliations("Donquixote Pirates");
        trebol.setEffect("Blocker: (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\nOn Play: All of your Characters with 1000 base power or less cannot be K.O.'d by your opponent's effects until the end of your opponent's next turn.");
        trebol.setImagePath("/images/cards/OP10/OP10-070.jpg");
        cardRepository.save(trebol);

        Card donquixoteDoflamingo = new Card();
        donquixoteDoflamingo.setCardNumber("OP10-071");
        donquixoteDoflamingo.setName("Donquixote Doflamingo");
        donquixoteDoflamingo.setCardType("Character");
        donquixoteDoflamingo.setColor("Purple");
        donquixoteDoflamingo.setCost(8);
        donquixoteDoflamingo.setPower(9000);
        donquixoteDoflamingo.setCounter(0);
        donquixoteDoflamingo.setAffiliations("The Seven Warlords / Donquixote Pirates");
        donquixoteDoflamingo.setEffect("On Play: DON!!-1: Play up to one 5 cost or lower [Donquixote Pirates] type character card from your hand.\nOnce Per Turn: You may rest one of your DON!!: add up to 1 Active DON!! from your DON!! deck.");
        donquixoteDoflamingo.setImagePath("/images/cards/OP10/OP10-071.jpg");
        cardRepository.save(donquixoteDoflamingo);

        Card donquixoteRosinante = new Card();
        donquixoteRosinante.setCardNumber("OP10-072");
        donquixoteRosinante.setName("Donquixote Rosinante");
        donquixoteRosinante.setCardType("Character");
        donquixoteRosinante.setColor("Purple");
        donquixoteRosinante.setCost(5);
        donquixoteRosinante.setPower(6000);
        donquixoteRosinante.setCounter(1000);
        donquixoteRosinante.setAffiliations("Navy/Donquixote Pirates");
        donquixoteRosinante.setEffect("On Play: You may trash 1 event card from your hand: Draw 2 cards.\nEnd of Your Turn: If you have 7 or more Don!! cards, set up to two of them as active.");
        donquixoteRosinante.setImagePath("/images/cards/OP10/OP10-072.jpg");
        cardRepository.save(donquixoteRosinante);

        Card buffalo = new Card();
        buffalo.setCardNumber("OP10-073");
        buffalo.setName("Buffalo");
        buffalo.setCardType("Character");
        buffalo.setColor("Purple");
        buffalo.setCost(4);
        buffalo.setPower(6000);
        buffalo.setCounter(0);
        buffalo.setAffiliations("Donquixote Pirates");
        buffalo.setAttribute("Strike");
        buffalo.setImagePath("/images/cards/OP10/OP10-073.jpg");
        cardRepository.save(buffalo);

        Card pika = new Card();
        pika.setCardNumber("OP10-074");
        pika.setName("Pika");
        pika.setCardType("Character");
        pika.setColor("Purple");
        pika.setCost(4);
        pika.setPower(5000);
        pika.setCounter(1000);
        pika.setAffiliations("Donquixote Pirates");
        pika.setEffect("Once Per Turn: If this character were to be KO'd by one of your opponents effects, you may instead rest 2 of your DON!!.");
        pika.setImagePath("/images/cards/OP10/OP10-074.jpg");
        cardRepository.save(pika);

        Card foxy = new Card();
        foxy.setCardNumber("OP10-075");
        foxy.setName("Foxy");
        foxy.setCardType("Character");
        foxy.setColor("Purple");
        foxy.setCost(2);
        foxy.setPower(1000);
        foxy.setCounter(2000);
        foxy.setAffiliations("Foxy Pirates");
        foxy.setEffect("Activate:Main: You may trash this Character: If the number of DON!! cards on your field is equal to or less than the number on your opponent's field, draw 1 card.");
        foxy.setImagePath("/images/cards/OP10/OP10-075.jpg");
        cardRepository.save(foxy);

        Card baby5 = new Card();
        baby5.setCardNumber("OP10-076");
        baby5.setName("Baby 5");
        baby5.setCardType("Character");
        baby5.setColor("Purple");
        baby5.setCost(3);
        baby5.setPower(1000);
        baby5.setCounter(2000);
        baby5.setAffiliations("Donquixote Pirates");
        baby5.setEffect("On Play: You may discard 1 card from your hand: If your Leader has the type \"Donquixote Pirates\", add up to 1 DON!! from your DON!! deck and set it as active.");
        baby5.setImagePath("/images/cards/OP10/OP10-076.jpg");
        cardRepository.save(baby5);

        Card bellamy = new Card();
        bellamy.setCardNumber("OP10-077");
        bellamy.setName("Bellamy");
        bellamy.setCardType("Character");
        bellamy.setColor("Purple");
        bellamy.setCost(3);
        bellamy.setPower(4000);
        bellamy.setCounter(1000);
        bellamy.setAffiliations("Donquixote Pirates");
        bellamy.setEffect("Blocker: (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\nWhen Blocking: You may rest 2 don: Add up to one active don from your don deck.");
        bellamy.setImagePath("/images/cards/OP10/OP10-077.jpg");
        cardRepository.save(bellamy);

        // Events
        Card iCanNeverForgive = new Card();
        iCanNeverForgive.setCardNumber("OP10-078");
        iCanNeverForgive.setName("I can never forgive anyone who laughs at my family...!!!!");
        iCanNeverForgive.setCardType("Event");
        iCanNeverForgive.setColor("Purple");
        iCanNeverForgive.setCost(1);
        iCanNeverForgive.setAffiliations("Donquixote Pirates");
        iCanNeverForgive.setEffect("Main / Counter: Look at 3 cards from the top of your deck; reveal up to 1 {Donquixote Pirates} type card other than \"I can never forgive anyone who laughs at my family...!!!!\" and add it to your hand. Then, place the rest at the bottom of your deck in any order.");
        iCanNeverForgive.setImagePath("/images/cards/OP10/OP10-078.jpg");
        cardRepository.save(iCanNeverForgive);

        Card godThread = new Card();
        godThread.setCardNumber("OP10-079");
        godThread.setName("God Thread");
        godThread.setCardType("Event");
        godThread.setColor("Purple");
        godThread.setCost(5);
        godThread.setAffiliations("Seven Warlord of the Sea / Donquixote Pirates");
        godThread.setEffect("Main: KO up to one of your opponent's 5 cost or below characters. Then, add up to one active don from your don deck.\nTrigger: Add up to one active don from your don deck.");
        godThread.setImagePath("/images/cards/OP10/OP10-079.jpg");
        cardRepository.save(godThread);

        Card littleBlackBears = new Card();
        littleBlackBears.setCardNumber("OP10-080");
        littleBlackBears.setName("Little Black Bears");
        littleBlackBears.setCardType("Event");
        littleBlackBears.setColor("Purple");
        littleBlackBears.setCost(3);
        littleBlackBears.setAffiliations("Donquixote Pirates");
        littleBlackBears.setEffect("Counter: Up to one of your characters or leaders gain +4000 for this battle. Then, if you have 7 or more don on your field, and you have 5 or less cards in hand, draw one card.\nTrigger: Add up to one active don from your don deck.");
        littleBlackBears.setImagePath("/images/cards/OP10/OP10-080.jpg");
        cardRepository.save(littleBlackBears);

        System.out.println("Finished initializing OP10 Purple cards");
    }

    private void initializeOP10BlackCards() {
        System.out.println("Initializing OP10 Black cards...");

        // Characters
        Card usopp = new Card();
        usopp.setCardNumber("OP10-081");
        usopp.setName("Usopp");
        usopp.setCardType("Character");
        usopp.setColor("Black");
        usopp.setCost(4);
        usopp.setPower(5000);
        usopp.setCounter(1000);
        usopp.setAffiliations("Dressrosa / Straw Hat Pirates");
        usopp.setAttribute("Special");
        usopp.setEffect("On Play: Rest a stage or leader with the \"Dressrosa\" type: KO a 2 cost or lower character. After that, trash the top card of your deck.");
        usopp.setImagePath("/images/cards/OP10/OP10-081.jpg");
        cardRepository.save(usopp);

        Card kuzan = new Card();
        kuzan.setCardNumber("OP10-082");
        kuzan.setName("Kuzan");
        kuzan.setCardType("Character");
        kuzan.setColor("Black");
        kuzan.setCost(5);
        kuzan.setPower(5000);
        kuzan.setCounter(0);
        kuzan.setAffiliations("Former Navy / Blackbeard Pirates");
        kuzan.setEffect("This Character cannot be removed from the field by your opponent's effects.\nActivate: Main: You may trash this Character: Draw 1 card. Then, play up to 1 {Blackbeard Pirates} type Character card with a cost of 5 or less other than [Kuzan] from your trash.");
        kuzan.setImagePath("/images/cards/OP10/OP10-082.jpg");
        cardRepository.save(kuzan);

        Card kozukiMomonosuke = new Card();
        kozukiMomonosuke.setCardNumber("OP10-083");
        kozukiMomonosuke.setName("Kozuki Momonosuke");
        kozukiMomonosuke.setCardType("Character");
        kozukiMomonosuke.setColor("Black");
        kozukiMomonosuke.setCost(2);
        kozukiMomonosuke.setPower(0);
        kozukiMomonosuke.setCounter(2000);
        kozukiMomonosuke.setAffiliations("Dressrosa/Wano/Kozuki Family");
        kozukiMomonosuke.setEffect("Activate: Main: You may rest this character and one of your Leader or Stages with the \"Dressrosa\" type: Give up to 1 of your opponent's characters cost -2 for the turn.");
        kozukiMomonosuke.setImagePath("/images/cards/OP10/OP10-083.jpg");
        cardRepository.save(kozukiMomonosuke);

        Card sanJuanWolf = new Card();
        sanJuanWolf.setCardNumber("OP10-084");
        sanJuanWolf.setName("San Juan Wolf");
        sanJuanWolf.setCardType("Character");
        sanJuanWolf.setColor("Black");
        sanJuanWolf.setCost(5);
        sanJuanWolf.setPower(7000);
        sanJuanWolf.setCounter(1000);
        sanJuanWolf.setAffiliations("Giants/Blackbeard Pirates");
        sanJuanWolf.setImagePath("/images/cards/OP10/OP10-084.jpg");
        cardRepository.save(sanJuanWolf);

        Card jesusBurgess = new Card();
        jesusBurgess.setCardNumber("OP10-085");
        jesusBurgess.setName("Jesus Burgess");
        jesusBurgess.setCardType("Character");
        jesusBurgess.setColor("Black");
        jesusBurgess.setCost(5);
        jesusBurgess.setPower(6000);
        jesusBurgess.setCounter(0);
        jesusBurgess.setAffiliations("Dressrosa / Blackbeard Pirates");
        jesusBurgess.setAttribute("Strike");
        jesusBurgess.setEffect("DON!! x1: If you have 8 or more cards in your trash, this character gains Rush");
        jesusBurgess.setImagePath("/images/cards/OP10/OP10-085.jpg");
        cardRepository.save(jesusBurgess);

        Card shiryu = new Card();
        shiryu.setCardNumber("OP10-086");
        shiryu.setName("Shiryu");
        shiryu.setCardType("Character");
        shiryu.setColor("Black");
        shiryu.setCost(4);
        shiryu.setPower(5000);
        shiryu.setCounter(1000);
        shiryu.setAffiliations("Blackbeard Pirates");
        shiryu.setEffect("Opponent's Turn: This character gains +2000 power.\nActivate: Main (Once Per Turn): If this is the turn this card was played and if your leader has type {Blackbeard Pirate} , K.O up to 1 of your opponent's characters with an original cost of 3 or less.");
        shiryu.setImagePath("/images/cards/OP10/OP10-086.jpg");
        cardRepository.save(shiryu);

        Card tonyTonyChopper = new Card();
        tonyTonyChopper.setCardNumber("OP10-087");
        tonyTonyChopper.setName("Tony Tony Chopper");
        tonyTonyChopper.setCardType("Character");
        tonyTonyChopper.setColor("Black");
        tonyTonyChopper.setCost(2);
        tonyTonyChopper.setPower(0);
        tonyTonyChopper.setCounter(1000);
        tonyTonyChopper.setAffiliations("Animal / Dressrosa / Straw Hat Pirates");
        tonyTonyChopper.setAttribute("Strike");
        tonyTonyChopper.setEffect("Activate: Main: You may rest this and one of your leader or stage that has the {Dressrosa} type: If your opponent's hand is 5 or greater, your opponent trashes 1 card from their hand. Then, trash the top 2 cards of your deck.");
        tonyTonyChopper.setImagePath("/images/cards/OP10/OP10-087.jpg");
        cardRepository.save(tonyTonyChopper);

        Card nami = new Card();
        nami.setCardNumber("OP10-088");
        nami.setName("Nami");
        nami.setCardType("Character");
        nami.setColor("Black");
        nami.setCost(2);
        nami.setPower(0);
        nami.setCounter(1000);
        nami.setAffiliations("Dressrosa / Straw Hat Pirates");
        nami.setEffect("Activate: Main: You may rest this and one of your leader or stage that has the {Dressrosa} type: Draw one card, then trash 2 cards from the top of your deck.");
        nami.setImagePath("/images/cards/OP10/OP10-088.jpg");
        cardRepository.save(nami);

        Card nicoRobin = new Card();
        nicoRobin.setCardNumber("OP10-089");
        nicoRobin.setName("Nico Robin");
        nicoRobin.setCardType("Character");
        nicoRobin.setColor("Black");
        nicoRobin.setCost(6);
        nicoRobin.setPower(8000);
        nicoRobin.setCounter(1000);
        nicoRobin.setAffiliations("Dressrosa / Straw Hat Pirates");
        nicoRobin.setImagePath("/images/cards/OP10/OP10-089.jpg");
        cardRepository.save(nicoRobin);

        Card franky = new Card();
        franky.setCardNumber("OP10-090");
        franky.setName("Franky");
        franky.setCardType("Character");
        franky.setColor("Black");
        franky.setCost(4);
        franky.setPower(5000);
        franky.setCounter(1000);
        franky.setAffiliations("Dressrosa / Straw Hat Pirates");
        franky.setEffect("Blocker: (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\nOn K.O: Play up to one cost 3 or lower {Dressrosa} type character rested from your trash.");
        franky.setImagePath("/images/cards/OP10/OP10-090.jpg");
        cardRepository.save(franky);

        Card brook = new Card();
        brook.setCardNumber("OP10-091");
        brook.setName("Brook");
        brook.setCardType("Character");
        brook.setColor("Black");
        brook.setCost(3);
        brook.setPower(0);
        brook.setCounter(1000);
        brook.setAffiliations("Dressrosa / Straw Hat Pirates");
        brook.setEffect("Activate: Main: You may rest this character and one leader or stage card with the \"Dressrosa\" type: KO up to one of your opponent's characters with cost 1 or below. Then, trash two cards from the top of your deck.");
        brook.setImagePath("/images/cards/OP10/OP10-091.jpg");
        cardRepository.save(brook);

        Card perona = new Card();
        perona.setCardNumber("OP10-092");
        perona.setName("Perona");
        perona.setCardType("Character");
        perona.setColor("Black");
        perona.setCost(4);
        perona.setPower(5000);
        perona.setCounter(1000);
        perona.setAffiliations("Thriller Bark Pirates");
        perona.setEffect("Activate: Main (Once Per Turn): You may place 2 cards with the <Thriller Bark Pirates> from your trash at the bottom of your deck in any order: Up to 1 of your Characters other than [Perona] gains +2000 power during this turn.");
        perona.setImagePath("/images/cards/OP10/OP10-092.jpg");
        cardRepository.save(perona);

        Card saintHoming = new Card();
        saintHoming.setCardNumber("OP10-093");
        saintHoming.setName("Saint Homing");
        saintHoming.setCardType("Character");
        saintHoming.setColor("Black");
        saintHoming.setCost(1);
        saintHoming.setPower(0);
        saintHoming.setCounter(1000);
        saintHoming.setAffiliations("Celestial Dragons");
        saintHoming.setAttribute("Wisdom");
        saintHoming.setEffect("Activate: Main: You may trash this character: Give up to 1 of your Black Characters Cost +3 until the end of your opponent's next turn.");
        saintHoming.setImagePath("/images/cards/OP10/OP10-093.jpg");
        cardRepository.save(saintHoming);

        Card ryuma = new Card();
        ryuma.setCardNumber("OP10-094");
        ryuma.setName("Ryuma");
        ryuma.setCardType("Character");
        ryuma.setColor("Black");
        ryuma.setCost(4);
        ryuma.setPower(6000);
        ryuma.setCounter(0);
        ryuma.setAffiliations("Wano Country / Thriller Bark Pirates");
        ryuma.setEffect("DON!! x1: This character gains Double Attack");
        ryuma.setImagePath("/images/cards/OP10/OP10-094.jpg");
        cardRepository.save(ryuma);

        Card roronoaZoro = new Card();
        roronoaZoro.setCardNumber("OP10-095");
        roronoaZoro.setName("Roronoa Zoro");
        roronoaZoro.setCardType("Character");
        roronoaZoro.setColor("Black");
        roronoaZoro.setCost(4);
        roronoaZoro.setPower(6000);
        roronoaZoro.setCounter(0);
        roronoaZoro.setAffiliations("Dressrosa/Supernova/Straw Hat Crew");
        roronoaZoro.setAttribute("Slash");
        roronoaZoro.setEffect("On Play: You may rest up to 1 of your \"Dressrosa\" type Leaders or Stages: KO up to 1 of your opponent's cost 4 or lower characters. Then, place the top 2 cards of your deck into your trash.");
        roronoaZoro.setImagePath("/images/cards/OP10/OP10-095.jpg");
        cardRepository.save(roronoaZoro);

        // Events
        Card weDontNeedTheSevenWarlords = new Card();
        weDontNeedTheSevenWarlords.setCardNumber("OP10-096");
        weDontNeedTheSevenWarlords.setName("We don't need the Seven Warlords of the Sea anymore...!!!!");
        weDontNeedTheSevenWarlords.setCardType("Event");
        weDontNeedTheSevenWarlords.setColor("Black");
        weDontNeedTheSevenWarlords.setCost(4);
        weDontNeedTheSevenWarlords.setAffiliations("Navy");
        weDontNeedTheSevenWarlords.setEffect("Main: K.O. up to one of your opponent's Characters with the type \"Seven Warlords of the Sea\" with a cost of 8 or less.\nTrigger: K.O. up to one of your opponent's Characters with the type \"Seven Warlords of the Sea\" with a cost of 4 or less.");
        weDontNeedTheSevenWarlords.setImagePath("/images/cards/OP10/OP10-096.jpg");
        cardRepository.save(weDontNeedTheSevenWarlords);

        Card gumGumRhinoSchneider = new Card();
        gumGumRhinoSchneider.setCardNumber("OP10-097");
        gumGumRhinoSchneider.setName("Gum Gum Rhino Schneider");
        gumGumRhinoSchneider.setCardType("Event");
        gumGumRhinoSchneider.setColor("Black");
        gumGumRhinoSchneider.setCost(1);
        gumGumRhinoSchneider.setAffiliations("Dressrosa/Supernova/Straw Hat Crew");
        gumGumRhinoSchneider.setEffect("Main: Give up to 1 of your \"Dressrosa\" type characters +2000 Power for this turn. Then, if you have 10 or more cards in your trash, that character gains [Banish] for the turn.\nTrigger: Draw 2 cards, then discard 1 card.");
        gumGumRhinoSchneider.setImagePath("/images/cards/OP10/OP10-097.jpg");
        cardRepository.save(gumGumRhinoSchneider);

        Card liberation = new Card();
        liberation.setCardNumber("OP10-098");
        liberation.setName("Liberation");
        liberation.setCardType("Event");
        liberation.setColor("Black");
        liberation.setCost(6);
        liberation.setAffiliations("Blackbeard Pirates");
        liberation.setEffect("Main: If you have 2 or more characters less than your opponent, KO up to 1 of your opponent's characters with an original cost of 6 or less and one with an original cost of 4 or less.\nTrigger: Choose up to 1 of your opponent's leaders and characters, negate it's effect for this turn.");
        liberation.setImagePath("/images/cards/OP10/OP10-098.jpg");
        cardRepository.save(liberation);

        System.out.println("Finished initializing OP10 Black cards");
    }

    private void initializeOP10YellowCards() {
        System.out.println("Initializing OP10 Yellow cards...");

        // Leaders
        Card eustassKidLeader = new Card();
        eustassKidLeader.setCardNumber("OP10-099");
        eustassKidLeader.setName("Eustass \"Captain\" Kid");
        eustassKidLeader.setCardType("Leader");
        eustassKidLeader.setColor("Yellow");
        eustassKidLeader.setPower(5000);
        eustassKidLeader.setLife(5);
        eustassKidLeader.setAffiliations("Supernova / Kid Pirates");
        eustassKidLeader.setAttribute("Special");
        eustassKidLeader.setEffect("End of Your Turn: You may turn the top card of your Life cards face-up: Set up to one of your 3 to 8 cost characters with the {Supernova} type active, that character gains [Blocker] until the end of your opponent's next turn.");
        eustassKidLeader.setImagePath("/images/cards/OP10/OP10-099.jpg");
        cardRepository.save(eustassKidLeader);

        // Characters
        Card inazuma = new Card();
        inazuma.setCardNumber("OP10-100");
        inazuma.setName("Inazuma");
        inazuma.setCardType("Character");
        inazuma.setColor("Yellow");
        inazuma.setCost(4);
        inazuma.setPower(5000);
        inazuma.setCounter(1000);
        inazuma.setAffiliations("Revolutionary Army");
        inazuma.setAttribute("Slash");
        inazuma.setEffect("DON!! x1 (When Attacking): Rest up to 1 of your opponent's Characters with a cost equal to or less than the total of your and your opponent's Life cards.\n" +
                        "Trigger: If your leader has the {Revolutionary Army} type, and the total of your and your opponent's Life cards is less than 5, play this card.");
        inazuma.setImagePath("/images/cards/OP10/OP10-100.jpg");
        cardRepository.save(inazuma);

        Card urouge = new Card();
        urouge.setCardNumber("OP10-101");
        urouge.setName("Urouge");
        urouge.setCardType("Character");
        urouge.setColor("Yellow");
        urouge.setCost(5);
        urouge.setPower(7000);
        urouge.setCounter(1000);
        urouge.setAffiliations("Supernovas / Fallen Monk Pirates");
        urouge.setAttribute("Strike");
        urouge.setImagePath("/images/cards/OP10/OP10-101.jpg");
        cardRepository.save(urouge);

        Card emporioIvankov = new Card();
        emporioIvankov.setCardNumber("OP10-102");
        emporioIvankov.setName("Emporio Ivankov");
        emporioIvankov.setCardType("Character");
        emporioIvankov.setColor("Yellow");
        emporioIvankov.setCost(5);
        emporioIvankov.setPower(6000);
        emporioIvankov.setCounter(1000);
        emporioIvankov.setAffiliations("Revolutionary Army");
        emporioIvankov.setAttribute("Special");
        emporioIvankov.setEffect("Activate: Main (Once Per Turn): Give up to 3 of your {Revolutionary army} type characters +1000 power until end of turn. Then, put the top card of your life into your hand.");
        emporioIvankov.setImagePath("/images/cards/OP10/OP10-102.jpg");
        cardRepository.save(emporioIvankov);

        Card caponeBege = new Card();
        caponeBege.setCardNumber("OP10-103");
        caponeBege.setName("Capone \"Gang\" Bege");
        caponeBege.setCardType("Character");
        caponeBege.setColor("Yellow");
        caponeBege.setCost(1);
        caponeBege.setPower(0);
        caponeBege.setCounter(2000);
        caponeBege.setAffiliations("Supernova / Fire Tank Pirates");
        caponeBege.setAttribute("Ranged");
        caponeBege.setEffect("On Play: You may add 1 card from the top or bottom of your Life cards to your hand: Add up to 1 Character with the type \"Supernova\" from your hand to the top of your Life cards face-up.");
        caponeBege.setImagePath("/images/cards/OP10/OP10-103.jpg");
        cardRepository.save(caponeBege);

        Card caribou = new Card();
        caribou.setCardNumber("OP10-104");
        caribou.setName("Caribou");
        caribou.setCardType("Character");
        caribou.setColor("Yellow");
        caribou.setCost(4);
        caribou.setPower(5000);
        caribou.setCounter(1000);
        caribou.setAffiliations("Supernova / Caribou Pirates");
        caribou.setAttribute("Special");
        caribou.setEffect("DON!! x1: If your leader has the \"Supernova\" type and your opponent has 3 or more life cards, this character cannot be KOed in battle.");
        caribou.setImagePath("/images/cards/OP10/OP10-104.jpg");
        cardRepository.save(caribou);

        Card cavendish = new Card();
        cavendish.setCardNumber("OP10-105");
        cavendish.setName("Cavendish");
        cavendish.setCardType("Character");
        cavendish.setColor("Yellow");
        cavendish.setCost(6);
        cavendish.setPower(8000);
        cavendish.setCounter(1000);
        cavendish.setAffiliations("Dressrosa / Supernova / Beautiful Pirates");
        cavendish.setAttribute("Slash");
        cavendish.setImagePath("/images/cards/OP10/OP10-105.jpg");
        cardRepository.save(cavendish);

        Card killer = new Card();
        killer.setCardNumber("OP10-106");
        killer.setName("Killer");
        killer.setCardType("Character");
        killer.setColor("Yellow");
        killer.setCost(3);
        killer.setPower(5000);
        killer.setCounter(0);
        killer.setAffiliations("Supernovas / Kid Pirates");
        killer.setAttribute("Slash");
        killer.setEffect("On K.O: If your Leader has the type \"Supernovas\", look at 3 cards from the top of your deck; reveal up to 1 \"Supernovas\" or \"Kid Pirates\" type card and add it to your hand. Then, place the rest at the bottom of your deck in any order.");
        killer.setImagePath("/images/cards/OP10/OP10-106.jpg");
        cardRepository.save(killer);

        Card jewelryBonney = new Card();
        jewelryBonney.setCardNumber("OP10-107");
        jewelryBonney.setName("Jewelry Bonney");
        jewelryBonney.setCardType("Character");
        jewelryBonney.setColor("Yellow");
        jewelryBonney.setCost(3);
        jewelryBonney.setPower(4000);
        jewelryBonney.setCounter(1000);
        jewelryBonney.setAffiliations("Supernovas / Bonney Pirates");
        jewelryBonney.setAttribute("Special");
        jewelryBonney.setEffect("Blocker: (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\n" +
                                "On Play: You may add 1 card from the top or bottom of your Life cards to your hand: Add up to 1 {Supernovas} type Character card with a cost of 5 from your hand to the top of your Life cards face-up.");
        jewelryBonney.setImagePath("/images/cards/OP10/OP10-107.jpg");
        cardRepository.save(jewelryBonney);

        Card scratchmenApoo = new Card();
        scratchmenApoo.setCardNumber("OP10-108");
        scratchmenApoo.setName("Scratchmen Apoo");
        scratchmenApoo.setCardType("Character");
        scratchmenApoo.setColor("Yellow");
        scratchmenApoo.setCost(1);
        scratchmenApoo.setPower(1000);
        scratchmenApoo.setCounter(1000);
        scratchmenApoo.setAffiliations("Supernova / On Air Pirates");
        scratchmenApoo.setAttribute("Ranged");
        scratchmenApoo.setEffect("If you have a yellow \"Supernova\" character other than \"Scratchmen Apoo\", this character gain [Blocker]");
        scratchmenApoo.setImagePath("/images/cards/OP10/OP10-108.jpg");
        cardRepository.save(scratchmenApoo);

        Card basilHawkins = new Card();
        basilHawkins.setCardNumber("OP10-109");
        basilHawkins.setName("Basil Hawkins");
        basilHawkins.setCardType("Character");
        basilHawkins.setColor("Yellow");
        basilHawkins.setCost(4);
        basilHawkins.setPower(5000);
        basilHawkins.setCounter(1000);
        basilHawkins.setAffiliations("Supernova / Hawkins Pirates");
        basilHawkins.setAttribute("Slash");
        basilHawkins.setEffect("On K.O: Trash up to 1 card from the top of your opponent's Life cards.\n" +
                               "Trigger: Draw 2 cards and discard 1 card from your hand.");
        basilHawkins.setImagePath("/images/cards/OP10/OP10-109.jpg");
        cardRepository.save(basilHawkins);

        Card heatWire = new Card();
        heatWire.setCardNumber("OP10-110");
        heatWire.setName("Heat & Wire");
        heatWire.setCardType("Character");
        heatWire.setColor("Yellow");
        heatWire.setCost(3);
        heatWire.setPower(4000);
        heatWire.setCounter(1000);
        heatWire.setAffiliations("Kid Pirates");
        heatWire.setAttribute("Strike");
        heatWire.setEffect("On Play: Rest up to 1 of your opponent's Characters with a cost equal to or less than the total of your and your opponent's Life cards.\n" +
                           "Trigger: Play this card.");
        heatWire.setImagePath("/images/cards/OP10/OP10-110.jpg");
        cardRepository.save(heatWire);

        Card monkeyDLuffy = new Card();
        monkeyDLuffy.setCardNumber("OP10-111");
        monkeyDLuffy.setName("Monkey D. Luffy");
        monkeyDLuffy.setCardType("Character");
        monkeyDLuffy.setColor("Yellow");
        monkeyDLuffy.setCost(1);
        monkeyDLuffy.setPower(2000);
        monkeyDLuffy.setCounter(1000);
        monkeyDLuffy.setAffiliations("Supernova / Straw Hat Pirates");
        monkeyDLuffy.setAttribute("Strike");
        monkeyDLuffy.setEffect("On Play: Look at the top 5 cards of your deck, reveal up to 1 card with {Supernova} other than [Monkey D. Luffy] add it to your hand. Then place the rest of the cards at the bottom of your deck in any order.");
        monkeyDLuffy.setImagePath("/images/cards/OP10/OP10-111.jpg");
        cardRepository.save(monkeyDLuffy);

        Card eustassKidChar = new Card();
        eustassKidChar.setCardNumber("OP10-112");
        eustassKidChar.setName("Eustass \"Captain\" Kid");
        eustassKidChar.setCardType("Character");
        eustassKidChar.setColor("Yellow");
        eustassKidChar.setCost(8);
        eustassKidChar.setPower(9000);
        eustassKidChar.setCounter(0);
        eustassKidChar.setAffiliations("Supernova / Kid Pirates");
        eustassKidChar.setAttribute("Special");
        eustassKidChar.setEffect("On Play: You may rest this character. Trash up to 1 card from the top of your opponent's Life cards.\n" +
                               "End of Your Turn: If your opponent has 2 or less Life cards, draw 1 card and discard 1 card from your hand.");
        eustassKidChar.setImagePath("/images/cards/OP10/OP10-112.jpg");
        cardRepository.save(eustassKidChar);

        Card roronoaZoro = new Card();
        roronoaZoro.setCardNumber("OP10-113");
        roronoaZoro.setName("Roronoa Zoro");
        roronoaZoro.setCardType("Character");
        roronoaZoro.setColor("Yellow");
        roronoaZoro.setCost(3);
        roronoaZoro.setPower(5000);
        roronoaZoro.setCounter(0);
        roronoaZoro.setAffiliations("Supernova / Straw Hat Crew");
        roronoaZoro.setAttribute("Slash");
        roronoaZoro.setEffect("If your life total is fewer than your opponent's, this character gains [Rush].\n" +
                              "Trigger: You may trash 1 card from your hand: If your leader has the {Supernova} type, play this character.");
        roronoaZoro.setImagePath("/images/cards/OP10/OP10-113.jpg");
        cardRepository.save(roronoaZoro);

        Card xDrake = new Card();
        xDrake.setCardNumber("OP10-114");
        xDrake.setName("X. Drake");
        xDrake.setCardType("Character");
        xDrake.setColor("Yellow");
        xDrake.setCost(3);
        xDrake.setPower(3000);
        xDrake.setCounter(2000);
        xDrake.setAffiliations("Supernovas / Navy / Drake Pirates");
        xDrake.setAttribute("Slash");
        xDrake.setEffect("Activate: Main: You may rest this character: If the number of your life cards is less than or equal to the number of your opponent's life cards, rest up to one of your opponent's characters with a cost of 4 or less.");
        xDrake.setImagePath("/images/cards/OP10/OP10-114.jpg");
        cardRepository.save(xDrake);

        // Events
        Card letsMeet = new Card();
        letsMeet.setCardNumber("OP10-115");
        letsMeet.setName("Let's meet in the \"New World\"!");
        letsMeet.setCardType("Event");
        letsMeet.setColor("Yellow");
        letsMeet.setCost(2);
        letsMeet.setAffiliations("Supernova / Kid Pirates");
        letsMeet.setEffect("Counter: Give up to one of your leaders or character +4000 power for this battle. Then, if you have 0 life cards, draw one card.\n" +
                           "Trigger: K.O up to 1 of your opponent's characters with a cost equal to or less than your opponent's Life cards.");
        letsMeet.setImagePath("/images/cards/OP10/OP10-115.jpg");
        cardRepository.save(letsMeet);

        Card damnedPunk = new Card();
        damnedPunk.setCardNumber("OP10-116");
        damnedPunk.setName("Damned Punk: Electromagnetic Cannon");
        damnedPunk.setCardType("Event");
        damnedPunk.setColor("Yellow");
        damnedPunk.setCost(4);
        damnedPunk.setAffiliations("Supernova / Kid Pirates");
        damnedPunk.setEffect("Main: Look at up to 1 card from the top of you or your opponent's Life cards and place it at the top or bottom of the Life cards. Then, K.O. up to 1 of your opponent's characters with a cost of 5 or less.\n" +
                             "Trigger: Draw 2 cards and discard 1 card from your hand.");
        damnedPunk.setImagePath("/images/cards/OP10/OP10-116.jpg");
        cardRepository.save(damnedPunk);

        Card room = new Card();
        room.setCardNumber("OP10-117");
        room.setName("ROOM");
        room.setCardType("Event");
        room.setColor("Yellow");
        room.setCost(1);
        room.setAffiliations("Supernova / Heart Pirates");
        room.setEffect("Counter: If you have 1 or less life, give up to 1 of your leader or characters +3000 Power for this battle. Then, set up to 1 of your 5 cost or lower characters active.\n" +
                       "Trigger: Draw 1 card.");
        room.setImagePath("/images/cards/OP10/OP10-117.jpg");
        cardRepository.save(room);
        
        // SECs
        Card monkeyDLuffySEC = new Card();
        monkeyDLuffySEC.setCardNumber("OP10-118");
        monkeyDLuffySEC.setName("Monkey D. Luffy");
        monkeyDLuffySEC.setCardType("Character");
        monkeyDLuffySEC.setColor("Yellow");
        monkeyDLuffySEC.setCost(6);
        monkeyDLuffySEC.setPower(7000);
        monkeyDLuffySEC.setCounter(1000);
        monkeyDLuffySEC.setAffiliations("Dressrosa / Supernovas / Straw Hat Pirates");
        monkeyDLuffySEC.setAttribute("Strike");
        monkeyDLuffySEC.setEffect("Once per turn, this character cannot be K.O'd by your opponent's effects.\n" +
                                  "When Attacking: You may place 3 cards from your trash to the bottom of your deck in any order. Then, if your opponent has 5 or more cards in their hand, opponent trashes 1 card from their hand.");
        monkeyDLuffySEC.setImagePath("/images/cards/OP10/OP10-118.jpg");
        cardRepository.save(monkeyDLuffySEC);

        Card trafalgarLawSEC = new Card();
        trafalgarLawSEC.setCardNumber("OP10-119");
        trafalgarLawSEC.setName("Trafalgar Law");
        trafalgarLawSEC.setCardType("Character");
        trafalgarLawSEC.setColor("Yellow");
        trafalgarLawSEC.setCost(7);
        trafalgarLawSEC.setPower(9000);
        trafalgarLawSEC.setCounter(0);
        trafalgarLawSEC.setAffiliations("Dressrosa / Supernova / Heart Pirates");
        trafalgarLawSEC.setAttribute("Slash");
        trafalgarLawSEC.setEffect("On Play: Reveal a \"Supernovas\" type character card from your hand and add it to the top of your life face down. Then, if your leader has the \"Supernovas\" type, give up to 1 rested DON!! to your leader.");
        trafalgarLawSEC.setImagePath("/images/cards/OP10/OP10-119.jpg");
        cardRepository.save(trafalgarLawSEC);


        System.out.println("Finished initializing OP10 Yellow cards");
    }
} 