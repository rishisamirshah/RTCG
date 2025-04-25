package com.onepiece.cardmanager.config;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class OP01Initializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public OP01Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Only initialize if we have no OP01 cards
        if (cardRepository.countBySetAndCardNumberStartingWith("OP01", "OP01") > 0) {
            System.out.println("OP01 cards already exist, skipping initialization");
            return;
        }

        System.out.println("Initializing OP01 cards...");
        
        // Leaders
        Card zoro = new Card();
        zoro.setCardNumber("OP01-001");
        zoro.setName("Roronoa Zoro");
        zoro.setCardType("Leader");
        zoro.setColor("Red");
        zoro.setPower(5000);
        zoro.setLife(5);
        zoro.setAffiliations("Supernovas/Straw Hat Crew");
        zoro.setEffect("DON!!×1 Your Turn All your Characters gain +1000 power.");
        zoro.setImagePath("/images/cards/OP01/OP01-001.png");
        Card savedZoro = cardRepository.save(zoro);
        System.out.println("Saved card " + savedZoro.getCardNumber() + " with set: " + savedZoro.getSet());

        Card law = new Card();
        law.setCardNumber("OP01-002");
        law.setName("Trafalgar Law");
        law.setCardType("Leader");
        law.setColor("Red/Green");
        law.setPower(5000);
        law.setLife(4);
        law.setAffiliations("Supernovas/Heart Pirates");
        law.setEffect("Activate: Main Once Per Turn [2] (You may rest the specified number of DON!! cards in your Cost Area): If you have 5 Characters, return 1 of your Characters to the owner's hand, then play up to 1 Character with a cost of 5 or less of a different color as the returned Character from your hand.");
        law.setImagePath("/images/cards/OP01/OP01-002.png");
        Card savedLaw = cardRepository.save(law);
        System.out.println("Saved card " + savedLaw.getCardNumber() + " with set: " + savedLaw.getSet());

        Card luffy = new Card();
        luffy.setCardNumber("OP01-003");
        luffy.setName("Monkey D. Luffy");
        luffy.setCardType("Leader");
        luffy.setColor("Red");
        luffy.setPower(5000);
        luffy.setLife(4);
        luffy.setAffiliations("Supernovas/Straw Hat Crew");
        luffy.setEffect("Activate: Main Once Per Turn [4] (You may rest the specified number of DON!! cards in your Cost Area): Set up to 1 of your (Supernovas) or (Straw Hat Crew) type Character cards with a cost of 5 or less as active.");
        luffy.setImagePath("/images/cards/OP01/OP01-003.png");
        Card savedLuffy = cardRepository.save(luffy);
        System.out.println("Saved card " + savedLuffy.getCardNumber() + " with set: " + savedLuffy.getSet());

        // Characters
        Card usopp = new Card();
        usopp.setCardNumber("OP01-004");
        usopp.setName("Usopp");
        usopp.setCardType("Character");
        usopp.setColor("Red");
        usopp.setCost(2);
        usopp.setPower(3000);
        usopp.setCounter(2000);
        usopp.setAttribute("Ranged");
        usopp.setAffiliations("Straw Hat Crew");
        usopp.setEffect("DON!!×1 Your Turn Once Per Turn After your opponent activates an Event, Draw 1 card.");
        usopp.setImagePath("/images/cards/OP01/OP01-004.png");
        cardRepository.save(usopp);

        Card uta = new Card();
        uta.setCardNumber("OP01-005");
        uta.setName("Uta");
        uta.setCardType("Character");
        uta.setColor("Red");
        uta.setCost(4);
        uta.setPower(4000);
        uta.setAttribute("Special");
        uta.setAffiliations("FILM");
        uta.setEffect("On Play Return up to 1 red Character card other than [Uta] with a cost of 3 or less from your trash to your hand.");
        uta.setImagePath("/images/cards/OP01/OP01-005.png");
        cardRepository.save(uta);

        Card otama = new Card();
        otama.setCardNumber("OP01-006");
        otama.setName("Otama");
        otama.setCardType("Character");
        otama.setColor("Red");
        otama.setCost(1);
        otama.setPower(0);
        otama.setCounter(2000);
        otama.setAttribute("Special");
        otama.setAffiliations("Wano Country");
        otama.setEffect("On Play Give up to 1 of your opponent's Characters -2000 power during this turn.");
        otama.setImagePath("/images/cards/OP01/OP01-006.png");
        cardRepository.save(otama);

        Card caribou = new Card();
        caribou.setCardNumber("OP01-007");
        caribou.setName("Caribou");
        caribou.setCardType("Character");
        caribou.setColor("Red");
        caribou.setCost(3);
        caribou.setPower(4000);
        caribou.setCounter(1000);
        caribou.setAttribute("Special");
        caribou.setAffiliations("Supernovas/Caribou Pirates");
        caribou.setEffect("On K.O. K.O. up to 1 of your opponent's Characters with 4000 power or less.");
        caribou.setImagePath("/images/cards/OP01/OP01-007.png");
        cardRepository.save(caribou);

        Card cavendish = new Card();
        cavendish.setCardNumber("OP01-008");
        cavendish.setName("Cavendish");
        cavendish.setCardType("Character");
        cavendish.setColor("Red");
        cavendish.setCost(4);
        cavendish.setPower(5000);
        cavendish.setAttribute("Slash");
        cavendish.setAffiliations("Supernovas/Beautiful Pirates");
        cavendish.setEffect("On Play You may add 1 card from your Life area to your hand: This Character gains Rush during this turn. (This card can attack on the turn in which it is played.)");
        cavendish.setImagePath("/images/cards/OP01/OP01-008.png");
        cardRepository.save(cavendish);

        Card carrot = new Card();
        carrot.setCardNumber("OP01-009");
        carrot.setName("Carrot");
        carrot.setCardType("Character");
        carrot.setColor("Red");
        carrot.setCost(2);
        carrot.setPower(3000);
        carrot.setCounter(1000);
        carrot.setAttribute("Strike");
        carrot.setAffiliations("Mink Tribe");
        carrot.setEffect("Trigger Play this card.");
        carrot.setImagePath("/images/cards/OP01/OP01-009.png");
        cardRepository.save(carrot);
        
        Card komachiyo = new Card();
        komachiyo.setCardNumber("OP01-010");
        komachiyo.setName("Komachiyo");
        komachiyo.setCardType("Character");
        komachiyo.setColor("Red");
        komachiyo.setCost(1);
        komachiyo.setPower(3000);
        komachiyo.setCounter(1000);
        komachiyo.setAttribute("Strike");
        komachiyo.setAffiliations("Animal/Wano Country");
        komachiyo.setImagePath("/images/cards/OP01/OP01-010.png");
        cardRepository.save(komachiyo);

        Card gordon = new Card();
        gordon.setCardNumber("OP01-011");
        gordon.setName("Gordon");
        gordon.setCardType("Character");
        gordon.setColor("Red");
        gordon.setCost(2);
        gordon.setPower(3000);
        gordon.setCounter(2000);
        gordon.setAttribute("Wisdom");
        gordon.setAffiliations("FILM");
        gordon.setEffect("On Play You may place 1 card from your hand at the bottom of your deck: Draw 1 card.");
        gordon.setImagePath("/images/cards/OP01/OP01-011.png");
        cardRepository.save(gordon);

        Card sai = new Card();
        sai.setCardNumber("OP01-012");
        sai.setName("Sai");
        sai.setCardType("Character");
        sai.setColor("Red");
        sai.setCost(2);
        sai.setPower(4000);
        sai.setCounter(1000);
        sai.setAttribute("Slash");
        sai.setAffiliations("Happosui Army");
        sai.setImagePath("/images/cards/OP01/OP01-012.png");
        cardRepository.save(sai);
        
        Card sanji = new Card();
        sanji.setCardNumber("OP01-013");
        sanji.setName("Sanji");
        sanji.setCardType("Character");
        sanji.setColor("Red");
        sanji.setCost(2);
        sanji.setPower(3000);
        sanji.setCounter(2000);
        sanji.setAttribute("Strike");
        sanji.setAffiliations("Straw Hat Crew");
        sanji.setEffect("Activate: Main Once Per Turn You may add 1 card from your Life area to your hand: This Character gains +2000 power during this turn. Then, give this Character up to 2 rested DON!! cards.");
        sanji.setImagePath("/images/cards/OP01/OP01-013.png");
        cardRepository.save(sanji);

        Card jinbe = new Card();
        jinbe.setCardNumber("OP01-014");
        jinbe.setName("Jinbe");
        jinbe.setCardType("Character");
        jinbe.setColor("Red");
        jinbe.setCost(4);
        jinbe.setPower(5000);
        jinbe.setCounter(1000);
        jinbe.setAttribute("Strike");
        jinbe.setAffiliations("Fish-Man/Straw Hat Crew");
        jinbe.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\nDON!!×1 On Block Play up to 1 red Character card with a cost of 2 or less from your hand.");
        jinbe.setImagePath("/images/cards/OP01/OP01-014.png");
        cardRepository.save(jinbe);

        Card tonyChopper = new Card();
        tonyChopper.setCardNumber("OP01-015");
        tonyChopper.setName("Tony Tony.Chopper");
        tonyChopper.setCardType("Character");
        tonyChopper.setColor("Red");
        tonyChopper.setCost(3);
        tonyChopper.setPower(4000);
        tonyChopper.setCounter(1000);
        tonyChopper.setAttribute("Wisdom");
        tonyChopper.setAffiliations("Animal/Straw Hat Crew");
        tonyChopper.setEffect("DON!!×1 When Attacking You may trash 1 card from your hand: Add up to 1 (Straw Hat Crew) type Character card other than [Tony Tony.Chopper] with a cost of 4 or less from your trash to your hand.");
        tonyChopper.setImagePath("/images/cards/OP01/OP01-015.png");
        cardRepository.save(tonyChopper);

        Card nami = new Card();
        nami.setCardNumber("OP01-016");
        nami.setName("Nami");
        nami.setCardType("Character");
        nami.setColor("Red");
        nami.setCost(1);
        nami.setPower(2000);
        nami.setCounter(1000);
        nami.setAttribute("Special");
        nami.setAffiliations("Straw Hat Crew");
        nami.setEffect("On Play Look at 5 cards from the top of your deck; reveal up to 1 (Straw Hat Crew) type card other than [Nami] and add it to your hand. Then, place the rest at the bottom of your deck in any order.");
        nami.setImagePath("/images/cards/OP01/OP01-016.png");
        cardRepository.save(nami);

        Card nicoRobin = new Card();
        nicoRobin.setCardNumber("OP01-017");
        nicoRobin.setName("Nico Robin");
        nicoRobin.setCardType("Character");
        nicoRobin.setColor("Red");
        nicoRobin.setCost(3);
        nicoRobin.setPower(4000);
        nicoRobin.setCounter(1000);
        nicoRobin.setAttribute("Strike");
        nicoRobin.setAffiliations("Straw Hat Crew");
        nicoRobin.setEffect("DON!!×1 When Attacking K.O. up to 1 of your opponent's Characters with 3000 power or less.");
        nicoRobin.setImagePath("/images/cards/OP01/OP01-017.png");
        cardRepository.save(nicoRobin);

        Card hajrudin = new Card();
        hajrudin.setCardNumber("OP01-018");
        hajrudin.setName("Hajrudin");
        hajrudin.setCardType("Character");
        hajrudin.setColor("Red");
        hajrudin.setCost(4);
        hajrudin.setPower(6000);
        hajrudin.setCounter(1000);
        hajrudin.setAttribute("Strike");
        hajrudin.setAffiliations("Giants/New Giant Warrior Pirates");
        hajrudin.setImagePath("/images/cards/OP01/OP01-018.png");
        cardRepository.save(hajrudin);

        Card bartolomeo = new Card();
        bartolomeo.setCardNumber("OP01-019");
        bartolomeo.setName("Bartolomeo");
        bartolomeo.setCardType("Character");
        bartolomeo.setColor("Red");
        bartolomeo.setCost(2);
        bartolomeo.setPower(2000);
        bartolomeo.setCounter(1000);
        bartolomeo.setAttribute("Special");
        bartolomeo.setAffiliations("Supernovas/Barto Club");
        bartolomeo.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\nDON!!×2 Opponent's Turn This Character gains +3000 Power.");
        bartolomeo.setImagePath("/images/cards/OP01/OP01-019.png");
        cardRepository.save(bartolomeo);

        Card hyogoro = new Card();
        hyogoro.setCardNumber("OP01-020");
        hyogoro.setName("Hyogoro");
        hyogoro.setCardType("Character");
        hyogoro.setColor("Red");
        hyogoro.setCost(2);
        hyogoro.setPower(3000);
        hyogoro.setCounter(1000);
        hyogoro.setAttribute("Wisdom");
        hyogoro.setAffiliations("Wano Country");
        hyogoro.setEffect("Activate: Main You may rest this Character: Your Leader or up to 1 of your Characters gains +2000 power during this turn.");
        hyogoro.setImagePath("/images/cards/OP01/OP01-020.png");
        cardRepository.save(hyogoro);

        Card franky = new Card();
        franky.setCardNumber("OP01-021");
        franky.setName("Franky");
        franky.setCardType("Character");
        franky.setColor("Red");
        franky.setCost(3);
        franky.setPower(4000);
        franky.setCounter(1000);
        franky.setAttribute("Ranged");
        franky.setAffiliations("Straw Hat Crew");
        franky.setEffect("DON!!×1 This Character can also attack your opponent's active Characters.");
        franky.setImagePath("/images/cards/OP01/OP01-021.png");
        cardRepository.save(franky);

        Card brook = new Card();
        brook.setCardNumber("OP01-022");
        brook.setName("Brook");
        brook.setCardType("Character");
        brook.setColor("Red");
        brook.setCost(4);
        brook.setPower(5000);
        brook.setCounter(1000);
        brook.setAttribute("Slash");
        brook.setAffiliations("Straw Hat Crew");
        brook.setEffect("DON!!×1 When Attacking Give up to 2 of your opponent's Characters -2000 power during this turn.");
        brook.setImagePath("/images/cards/OP01/OP01-022.png");
        cardRepository.save(brook);

        Card marco = new Card();
        marco.setCardNumber("OP01-023");
        marco.setName("Marco");
        marco.setCardType("Character");
        marco.setColor("Red");
        marco.setCost(3);
        marco.setPower(5000);
        marco.setCounter(1000);
        marco.setAttribute("Special");
        marco.setAffiliations("Former White Beard Pirates");
        marco.setImagePath("/images/cards/OP01/OP01-023.png");
        cardRepository.save(marco);
        
        Card luffyCharacter = new Card();
        luffyCharacter.setCardNumber("OP01-024");
        luffyCharacter.setName("Monkey D. Luffy");
        luffyCharacter.setCardType("Character");
        luffyCharacter.setColor("Red");
        luffyCharacter.setCost(2);
        luffyCharacter.setPower(3000);
        luffyCharacter.setCounter(1000);
        luffyCharacter.setAttribute("Strike");
        luffyCharacter.setAffiliations("Supernovas/Straw Hat Crew");
        luffyCharacter.setEffect("DON!!×2 This Character cannot be K.O.'d when battling (Strike) attribute Characters.\\nActivate: Main Once Per Turn Give this Character up to 2 rested DON!! cards.");
        luffyCharacter.setImagePath("/images/cards/OP01/OP01-024.png");
        cardRepository.save(luffyCharacter);

        Card zoroCharacter = new Card();
        zoroCharacter.setCardNumber("OP01-025");
        zoroCharacter.setName("Roronoa Zoro");
        zoroCharacter.setCardType("Character");
        zoroCharacter.setColor("Red");
        zoroCharacter.setCost(3);
        zoroCharacter.setPower(5000);
        zoroCharacter.setAttribute("Slash");
        zoroCharacter.setAffiliations("Supernovas/Straw Hat Crew");
        zoroCharacter.setEffect("Rush (This card can attack on the turn in which it is played.)");
        zoroCharacter.setImagePath("/images/cards/OP01/OP01-025.png");
        cardRepository.save(zoroCharacter);
        
        // Events
        Card gumGumRedHawk = new Card();
        gumGumRedHawk.setCardNumber("OP01-026");
        gumGumRedHawk.setName("Gum Gum Red Hawk");
        gumGumRedHawk.setCardType("Event");
        gumGumRedHawk.setColor("Red");
        gumGumRedHawk.setCost(2);
        gumGumRedHawk.setAffiliations("Supernovas/Straw Hat Crew");
        gumGumRedHawk.setEffect("Counter Your Leader or up to 1 of your Characters gains +4000 power during this battle. Then, K.O. up to 1 of your opponent's Characters with 4000 power or less.\\nTrigger Give up to 1 of your opponent's Leader or Characters -10000 power during this turn.");
        gumGumRedHawk.setImagePath("/images/cards/OP01/OP01-026.png");
        cardRepository.save(gumGumRedHawk);

        Card roundTable = new Card();
        roundTable.setCardNumber("OP01-027");
        roundTable.setName("Round Table");
        roundTable.setCardType("Event");
        roundTable.setColor("Red");
        roundTable.setCost(4);
        roundTable.setAffiliations("Supernovas/Beautiful Pirates");
        roundTable.setEffect("Main Give up to 1 of your opponent's Characters -10000 power during this turn.");
        roundTable.setImagePath("/images/cards/OP01/OP01-027.png");
        cardRepository.save(roundTable);

        Card greenStarRafflesia = new Card();
        greenStarRafflesia.setCardNumber("OP01-028");
        greenStarRafflesia.setName("Green Star: Rafflesia");
        greenStarRafflesia.setCardType("Event");
        greenStarRafflesia.setColor("Red");
        greenStarRafflesia.setCost(1);
        greenStarRafflesia.setAffiliations("Straw Hat Crew");
        greenStarRafflesia.setEffect("Counter Give up to 1 of your opponent's Leader or Characters -2000 power during this turn.\\nTrigger Activate this card's Counter effect.");
        greenStarRafflesia.setImagePath("/images/cards/OP01/OP01-028.png");
        cardRepository.save(greenStarRafflesia);

        Card radicalBeam = new Card();
        radicalBeam.setCardNumber("OP01-029");
        radicalBeam.setName("Radical Beam!!");
        radicalBeam.setCardType("Event");
        radicalBeam.setColor("Red");
        radicalBeam.setCost(1);
        radicalBeam.setAffiliations("Straw Hat Crew"); // Note: corrected affiliation
        radicalBeam.setEffect("Counter Your Leader or up to 1 of your Characters gains +2000 power during this battle. Then, if you have 2 or less Life cards, that card gains an additional +2000 power during this battle.\\nTrigger Your Leader or up to 1 of your Characters gains +1000 power during this turn.");
        radicalBeam.setImagePath("/images/cards/OP01/OP01-029.png");
        cardRepository.save(radicalBeam);
        
        Card inTwoYears = new Card();
        inTwoYears.setCardNumber("OP01-030");
        inTwoYears.setName("In Two Years!! At the Sabaody Archipelago!!");
        inTwoYears.setCardType("Event");
        inTwoYears.setColor("Red");
        inTwoYears.setCost(1);
        inTwoYears.setAffiliations("Straw Hat Crew");
        inTwoYears.setEffect("Main Look at 5 cards from the top of your deck; reveal up to 1 {Straw Hat Crew} type Character card and add it to your hand. Then, place the rest at the bottom of your deck in any order.\\nTrigger Activate this card's Main effect.");
        inTwoYears.setImagePath("/images/cards/OP01/OP01-030.png");
        cardRepository.save(inTwoYears);
        
        // Green Cards
        Card odenLeader = new Card();
        odenLeader.setCardNumber("OP01-031");
        odenLeader.setName("Kozuki Oden");
        odenLeader.setCardType("Leader");
        odenLeader.setColor("Green");
        odenLeader.setPower(5000);
        odenLeader.setLife(5);
        odenLeader.setAffiliations("Wano Country/Kozuki Family");
        odenLeader.setEffect("Activate: Main Once Per Turn You may trash 1 {Wano Country} type card from your hand: Set up to 2 of your DON!! cards as active.");
        odenLeader.setImagePath("/images/cards/OP01/OP01-031.png");
        cardRepository.save(odenLeader);
        
        Card ashuraDouji = new Card();
        ashuraDouji.setCardNumber("OP01-032");
        ashuraDouji.setName("Ashura Douji");
        ashuraDouji.setCardType("Character");
        ashuraDouji.setColor("Green");
        ashuraDouji.setCost(3);
        ashuraDouji.setPower(4000);
        ashuraDouji.setCounter(1000);
        ashuraDouji.setAttribute("Slash");
        ashuraDouji.setAffiliations("Wano Country/Nine Red Scabbards");
        ashuraDouji.setEffect("DON!!×1 If your opponent has 2 or more rested Characters, this Character gains +2000 power.");
        ashuraDouji.setImagePath("/images/cards/OP01/OP01-032.png");
        cardRepository.save(ashuraDouji);

        Card izou = new Card();
        izou.setCardNumber("OP01-033");
        izou.setName("Izou");
        izou.setCardType("Character");
        izou.setColor("Green");
        izou.setCost(3);
        izou.setPower(3000);
        izou.setCounter(2000);
        izou.setAttribute("Ranged");
        izou.setAffiliations("Wano Country/Former White Beard Pirates");
        izou.setEffect("On Play Rest up to 1 of your opponent's Characters with a cost of 4 or less.");
        izou.setImagePath("/images/cards/OP01/OP01-033.png");
        cardRepository.save(izou);
        
        Card dogstorm = new Card();
        dogstorm.setCardNumber("OP01-034");
        dogstorm.setName("Dog Storm");
        dogstorm.setCardType("Character");
        dogstorm.setColor("Green");
        dogstorm.setCost(3);
        dogstorm.setPower(4000);
        dogstorm.setCounter(1000);
        dogstorm.setAttribute("Slash");
        dogstorm.setAffiliations("Mink Tribe/Wano Country/Nine Red Scabbards");
        dogstorm.setEffect("DON!!x2 When Attacking Set up to 1 of your DON!! as active.");
        dogstorm.setImagePath("/images/cards/OP01/OP01-034.png");
        cardRepository.save(dogstorm);

        Card okiku = new Card();
        okiku.setCardNumber("OP01-035");
        okiku.setName("Okiku");
        okiku.setCardType("Character");
        okiku.setColor("Green");
        okiku.setCost(3);
        okiku.setPower(5000);
        okiku.setAttribute("Slash");
        okiku.setAffiliations("Wano Country/Nine Red Scabbards");
        okiku.setEffect("DON!!×1 When Attacking Once Per Turn Rest up to 1 of your opponent's Characters with a cost of 5 or less.");
        okiku.setImagePath("/images/cards/OP01/OP01-035.png");
        cardRepository.save(okiku);

        Card otsuru = new Card();
        otsuru.setCardNumber("OP01-036");
        otsuru.setName("Otsuru");
        otsuru.setCardType("Character");
        otsuru.setColor("Green");
        otsuru.setCost(1);
        otsuru.setPower(3000);
        otsuru.setCounter(1000);
        otsuru.setAttribute("Wisdom");
        otsuru.setAffiliations("Wano Country");
        otsuru.setImagePath("/images/cards/OP01/OP01-036.png");
        cardRepository.save(otsuru);

        Card kawamatsu = new Card();
        kawamatsu.setCardNumber("OP01-037");
        kawamatsu.setName("Kawamatsu");
        kawamatsu.setCardType("Character");
        kawamatsu.setColor("Green");
        kawamatsu.setCost(2);
        kawamatsu.setPower(3000);
        kawamatsu.setCounter(1000);
        kawamatsu.setAttribute("Slash");
        kawamatsu.setAffiliations("Fish-Man/Wano Country/Nine Red Scabbards");
        kawamatsu.setEffect("Trigger Play this card.");
        kawamatsu.setImagePath("/images/cards/OP01/OP01-037.png");
        cardRepository.save(kawamatsu);
        
        Card kanjuro = new Card();
        kanjuro.setCardNumber("OP01-038");
        kanjuro.setName("Kanjuro");
        kanjuro.setCardType("Character");
        kanjuro.setColor("Green");
        kanjuro.setCost(2);
        kanjuro.setPower(3000);
        kanjuro.setCounter(1000);
        kanjuro.setAttribute("Slash");
        kanjuro.setAffiliations("Wano Country/Nine Red Scabbards");
        kanjuro.setEffect("DON!!x1 When Attacking K.O. up to 1 of your opponent's rested Characters with a cost of 2 or less.\\nOn K.O. Your opponent chooses 1 card from your hand; trash that card.");
        kanjuro.setImagePath("/images/cards/OP01/OP01-038.png");
        cardRepository.save(kanjuro);

        Card killer = new Card();
        killer.setCardNumber("OP01-039");
        killer.setName("Killer");
        killer.setCardType("Character");
        killer.setColor("Green");
        killer.setCost(2);
        killer.setPower(2000);
        killer.setCounter(1000);
        killer.setAttribute("Slash");
        killer.setAffiliations("Supernovas/Kid Pirates");
        killer.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\nDON!!×1 On Block If you have 3 or more Characters, draw 1 card.");
        killer.setImagePath("/images/cards/OP01/OP01-039.png");
        cardRepository.save(killer);

        Card kinemon = new Card();
        kinemon.setCardNumber("OP01-040");
        kinemon.setName("Kin'emon");
        kinemon.setCardType("Character");
        kinemon.setColor("Green");
        kinemon.setCost(6);
        kinemon.setPower(6000);
        kinemon.setAttribute("Slash");
        kinemon.setAffiliations("Wano Country/Nine Red Scabbards");
        kinemon.setEffect("On Play If your Leader is [Kozuki Oden], play up to 1 (Nine Red Scabbards) type Character card with a cost of 3 or less from your hand.\\nDON!!×1 When Attacking Once Per Turn Set up to 1 of your (Nine Red Scabbards) type Characters with a cost of 3 or less as active.");
        kinemon.setImagePath("/images/cards/OP01/OP01-040.png");
        cardRepository.save(kinemon);

        Card kozukiMomonosuke = new Card();
        kozukiMomonosuke.setCardNumber("OP01-041");
        kozukiMomonosuke.setName("Kozuki Momonosuke");
        kozukiMomonosuke.setCardType("Character");
        kozukiMomonosuke.setColor("Green");
        kozukiMomonosuke.setCost(1);
        kozukiMomonosuke.setPower(0);
        kozukiMomonosuke.setCounter(1000);
        kozukiMomonosuke.setAttribute("Wisdom");
        kozukiMomonosuke.setAffiliations("Wano Country/Kozuki Family");
        kozukiMomonosuke.setEffect("Activate: Main [1] (You may rest the specified number of DON!! cards in your Cost Area) you may rest this Character: Look at 5 cards from the top of your deck; reveal up to 1 (Wano Country) type card and add it to your hand. Then, place the rest at the bottom of your deck in any order.");
        kozukiMomonosuke.setImagePath("/images/cards/OP01/OP01-041.png");
        cardRepository.save(kozukiMomonosuke);

        Card komurasaki = new Card();
        komurasaki.setCardNumber("OP01-042");
        komurasaki.setName("Komurasaki");
        komurasaki.setCardType("Character");
        komurasaki.setColor("Green");
        komurasaki.setCost(1);
        komurasaki.setPower(0);
        komurasaki.setCounter(1000);
        komurasaki.setAttribute("Wisdom");
        komurasaki.setAffiliations("Wano Country/Kozuki Family");
        komurasaki.setEffect("On Play [3] (You may rest the specified number of DON!! cards in your Cost Area): If your Leader is [Kozuki Oden], set up to 1 of your (Wano Country) type Characters with a cost of 3 or less as active.");
        komurasaki.setImagePath("/images/cards/OP01/OP01-042.png");
        cardRepository.save(komurasaki);

        Card shinobu = new Card();
        shinobu.setCardNumber("OP01-043");
        shinobu.setName("Shinobu");
        shinobu.setCardType("Character");
        shinobu.setColor("Green");
        shinobu.setCost(3);
        shinobu.setPower(5000);
        shinobu.setCounter(1000);
        shinobu.setAttribute("Special");
        shinobu.setAffiliations("Wano Country");
        shinobu.setImagePath("/images/cards/OP01/OP01-043.png");
        cardRepository.save(shinobu);

        Card shachi = new Card();
        shachi.setCardNumber("OP01-044");
        shachi.setName("Shachi");
        shachi.setCardType("Character");
        shachi.setColor("Green");
        shachi.setCost(3);
        shachi.setPower(4000);
        shachi.setCounter(1000);
        shachi.setAttribute("Strike");
        shachi.setAffiliations("Heart Pirates");
        shachi.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\nOn Play If you do not have [Penguin] in play, play up to 1 [Penguin] card from your hand."); // Note: updated Penguin card name
        shachi.setImagePath("/images/cards/OP01/OP01-044.png");
        cardRepository.save(shachi);

        Card jeanBart = new Card();
        jeanBart.setCardNumber("OP01-045");
        jeanBart.setName("Jean Bart");
        jeanBart.setCardType("Character");
        jeanBart.setColor("Green");
        jeanBart.setCost(4);
        jeanBart.setPower(6000);
        jeanBart.setCounter(1000);
        jeanBart.setAttribute("Strike");
        jeanBart.setAffiliations("Heart Pirates");
        jeanBart.setImagePath("/images/cards/OP01/OP01-045.png");
        cardRepository.save(jeanBart);

        Card denjiro = new Card();
        denjiro.setCardNumber("OP01-046");
        denjiro.setName("Denjiro");
        denjiro.setCardType("Character");
        denjiro.setColor("Green");
        denjiro.setCost(5);
        denjiro.setPower(7000);
        denjiro.setAttribute("Slash");
        denjiro.setAffiliations("Wano Country/Nine Red Scabbards");
        denjiro.setEffect("DON!!×1 When Attacking If your Leader is [Kozuki Oden], set up to 2 of your DON!! cards as active.");
        denjiro.setImagePath("/images/cards/OP01/OP01-046.png");
        cardRepository.save(denjiro);

        Card trafalgarLawCharacter = new Card();
        trafalgarLawCharacter.setCardNumber("OP01-047");
        trafalgarLawCharacter.setName("Trafalgar Law");
        trafalgarLawCharacter.setCardType("Character");
        trafalgarLawCharacter.setColor("Green");
        trafalgarLawCharacter.setCost(5);
        trafalgarLawCharacter.setPower(6000);
        trafalgarLawCharacter.setAttribute("Slash");
        trafalgarLawCharacter.setAffiliations("Supernovas/Heart Pirates");
        trafalgarLawCharacter.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\nOn Play You may return 1 of your Characters to your hand: Play up to 1 Character card with a cost of 3 or less from your hand.");
        trafalgarLawCharacter.setImagePath("/images/cards/OP01/OP01-047.png");
        cardRepository.save(trafalgarLawCharacter);
        
        Card catViper = new Card();
        catViper.setCardNumber("OP01-048");
        catViper.setName("Cat Viper");
        catViper.setCardType("Character");
        catViper.setColor("Green");
        catViper.setCost(2);
        catViper.setPower(3000);
        catViper.setCounter(1000);
        catViper.setAttribute("Slash");
        catViper.setAffiliations("Mink Tribe/Wano Country/Nine Red Scabbards");
        catViper.setEffect("On Play Rest up to 1 of your opponent's Characters with a cost of 3 or less.");
        catViper.setImagePath("/images/cards/OP01/OP01-048.png");
        cardRepository.save(catViper);

        Card bepo = new Card();
        bepo.setCardNumber("OP01-049");
        bepo.setName("Bepo");
        bepo.setCardType("Character");
        bepo.setColor("Green");
        bepo.setCost(4);
        bepo.setPower(4000);
        bepo.setCounter(2000);
        bepo.setAttribute("Strike");
        bepo.setAffiliations("Heart Pirates/Mink Tribe");
        bepo.setEffect("DON!!×1 When Attacking Play up to 1 (Heart Pirates) type Character card other than [Bepo] with a cost of 4 or less from your hand.");
        bepo.setImagePath("/images/cards/OP01/OP01-049.png");
        cardRepository.save(bepo);

        Card penguin = new Card();
        penguin.setCardNumber("OP01-050");
        penguin.setName("Penguin");
        penguin.setCardType("Character");
        penguin.setColor("Green");
        penguin.setCost(3);
        penguin.setPower(2000);
        penguin.setCounter(1000);
        penguin.setAttribute("Strike");
        penguin.setAffiliations("Heart Pirates");
        penguin.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\nOn Play If you do not have [Shachi] in play, play up to 1 [Shachi] card from your hand."); // Note: updated Shachi card name
        penguin.setImagePath("/images/cards/OP01/OP01-050.png");
        cardRepository.save(penguin);

        Card eustassKid = new Card();
        eustassKid.setCardNumber("OP01-051");
        eustassKid.setName("Eustass\"Captain\"Kid");
        eustassKid.setCardType("Character");
        eustassKid.setColor("Green");
        eustassKid.setCost(8);
        eustassKid.setPower(8000);
        eustassKid.setAttribute("Special");
        eustassKid.setAffiliations("Supernovas/Kid Pirates");
        eustassKid.setEffect("DON!!×1 Opponent's Turn If this Character is rested, your opponent cannot attack anything other than Characters named [Eustass\"Captain\"Kid].\\nActivate: Main Once Per Turn You may rest this Character: Play up to 1 Character card with a cost of 3 or less from your hand.");
        eustassKid.setImagePath("/images/cards/OP01/OP01-051.png");
        cardRepository.save(eustassKid);
        
        Card raizo = new Card();
        raizo.setCardNumber("OP01-052");
        raizo.setName("Raizo");
        raizo.setCardType("Character");
        raizo.setColor("Green");
        raizo.setCost(3);
        raizo.setPower(4000);
        raizo.setCounter(1000);
        raizo.setAttribute("Slash");
        raizo.setAffiliations("Wano Country/Nine Red Scabbards");
        raizo.setEffect("When Attacking Once Per Turn If you have 2 or more rested Characters, draw 1 card.");
        raizo.setImagePath("/images/cards/OP01/OP01-052.png");
        cardRepository.save(raizo);

        Card wire = new Card();
        wire.setCardNumber("OP01-053");
        wire.setName("Wire");
        wire.setCardType("Character");
        wire.setColor("Green");
        wire.setCost(2);
        wire.setPower(4000);
        wire.setCounter(1000);
        wire.setAttribute("Slash");
        wire.setAffiliations("Kid Pirates");
        wire.setImagePath("/images/cards/OP01/OP01-053.png");
        cardRepository.save(wire);
        
        Card xDrakeGreen = new Card();
        xDrakeGreen.setCardNumber("OP01-054");
        xDrakeGreen.setName("X.Drake");
        xDrakeGreen.setCardType("Character");
        xDrakeGreen.setColor("Green");
        xDrakeGreen.setCost(5);
        xDrakeGreen.setPower(6000);
        xDrakeGreen.setCounter(1000);
        xDrakeGreen.setAttribute("Slash");
        xDrakeGreen.setAffiliations("Supernovas/Navy/Drake Pirates");
        xDrakeGreen.setEffect("On Play K.O. up to 1 of your opponent's rested Characters with a cost of 4 or less.");
        xDrakeGreen.setImagePath("/images/cards/OP01/OP01-054.png");
        cardRepository.save(xDrakeGreen);
        
        // Green Events
        Card youCanBeMySamurai = new Card();
        youCanBeMySamurai.setCardNumber("OP01-055");
        youCanBeMySamurai.setName("You Can Be My Samurai!!!");
        youCanBeMySamurai.setCardType("Event");
        youCanBeMySamurai.setColor("Green");
        youCanBeMySamurai.setCost(1);
        youCanBeMySamurai.setAffiliations("Wano Country/Kozuki Family");
        youCanBeMySamurai.setEffect("Main You may rest 2 of your Characters: Draw 2 cards.");
        youCanBeMySamurai.setImagePath("/images/cards/OP01/OP01-055.png");
        cardRepository.save(youCanBeMySamurai);
        
        Card demonFace = new Card();
        demonFace.setCardNumber("OP01-056");
        demonFace.setName("Demon Face");
        demonFace.setCardType("Event");
        demonFace.setColor("Green");
        demonFace.setCost(6);
        demonFace.setAffiliations("Supernovas/Hawkins Pirates");
        demonFace.setEffect("Main K.O. up to 2 of your opponent's rested Characters with a cost of 5 or less.");
        demonFace.setImagePath("/images/cards/OP01/OP01-056.png");
        cardRepository.save(demonFace);

        Card paradiseWaterfall = new Card();
        paradiseWaterfall.setCardNumber("OP01-057");
        paradiseWaterfall.setName("Paradise Waterfall");
        paradiseWaterfall.setCardType("Event");
        paradiseWaterfall.setColor("Green");
        paradiseWaterfall.setCost(1);
        paradiseWaterfall.setAffiliations("Wano Country/Kozuki Family");
        paradiseWaterfall.setEffect("Counter Your Leader or up to 1 of your Characters gains +2000 power during this battle. Then, set up to 1 of your Characters as active.\\nTrigger K.O. up to 1 of your opponent's rested Characters with a cost of 4 or less.");
        paradiseWaterfall.setImagePath("/images/cards/OP01/OP01-057.png");
        cardRepository.save(paradiseWaterfall);

        Card punkGibson = new Card();
        punkGibson.setCardNumber("OP01-058");
        punkGibson.setName("Punk Gibson");
        punkGibson.setCardType("Event");
        punkGibson.setColor("Green");
        punkGibson.setCost(2);
        punkGibson.setAffiliations("Supernovas/Kid Pirates");
        punkGibson.setEffect("Counter Your Leader or up to 1 of your Characters gains +4000 power during this battle. Then, rest up to 1 of your opponent's Characters with a cost of 4 or less.\\nTrigger Rest up to 1 of your opponent's Characters.");
        punkGibson.setImagePath("/images/cards/OP01/OP01-058.png");
        Card savedPunkGibson = cardRepository.save(punkGibson);
        System.out.println("Saved card " + savedPunkGibson.getCardNumber() + " with set: " + savedPunkGibson.getSet());
        
        Card beben = new Card();
        beben.setCardNumber("OP01-059");
        beben.setName("Beben!!");
        beben.setCardType("Event");
        beben.setColor("Green");
        beben.setCost(3);
        beben.setAffiliations("Wano Country");
        beben.setEffect("Main You may trash 1 (Wano Country) type card from your hand: Set up to 1 of your (Wano Country) type Character cards with a cost of 3 or less as active.");
        beben.setImagePath("/images/cards/OP01/OP01-059.png");
        cardRepository.save(beben);

        // Blue / Purple / Black Cards
        Card doflamingoLeader = new Card();
        doflamingoLeader.setCardNumber("OP01-060");
        doflamingoLeader.setName("Donquixote Doflamingo");
        doflamingoLeader.setCardType("Leader");
        doflamingoLeader.setColor("Blue"); // Primary color Blue
        doflamingoLeader.setPower(5000);
        doflamingoLeader.setLife(5);
        doflamingoLeader.setAffiliations("The Seven Warlords of the Sea/Donquixote Pirates");
        doflamingoLeader.setEffect("DON!!×2 When Attacking [1] (You may rest the specified number of DON!! cards in your Cost Area): Reveal the top card of your deck. If that card is a (The Seven Warlords of the Sea) type Character card with a cost of 4 or less, you may play that card rested.");
        doflamingoLeader.setImagePath("/images/cards/OP01/OP01-060.png");
        cardRepository.save(doflamingoLeader);
        
        Card kaidoLeader = new Card();
        kaidoLeader.setCardNumber("OP01-061");
        kaidoLeader.setName("Kaido");
        kaidoLeader.setCardType("Leader");
        kaidoLeader.setColor("Purple");
        kaidoLeader.setPower(5000);
        kaidoLeader.setLife(4);
        kaidoLeader.setAffiliations("The Four Emperors/Animal Kingdom Pirates");
        kaidoLeader.setTiming("Your Turn");
        kaidoLeader.setEffect("DON!!×1 Your Turn Once Per Turn When 1 of your opponent's Characters is K.O.'d, you may add 1 DON!! card from your DON!! deck and set it as active.");
        kaidoLeader.setImagePath("/images/cards/OP01/OP01-061.png");
        cardRepository.save(kaidoLeader);

        Card crocodileLeader = new Card();
        crocodileLeader.setCardNumber("OP01-062");
        crocodileLeader.setName("Crocodile");
        crocodileLeader.setCardType("Leader");
        crocodileLeader.setColor("Purple"); // Primary color Purple
        crocodileLeader.setPower(5000);
        crocodileLeader.setLife(4);
        crocodileLeader.setAffiliations("The Seven Warlords of the Sea/Baroque Works");
        crocodileLeader.setEffect("DON!!×1 After you activate an Event, you may draw 1 card if you have 4 or less cards in your hand and haven't drawn a card using this Leader's effect during this turn.");
        crocodileLeader.setImagePath("/images/cards/OP01/OP01-062.png");
        cardRepository.save(crocodileLeader);
        
        Card arlong = new Card();
        arlong.setCardNumber("OP01-063");
        arlong.setName("Arlong");
        arlong.setCardType("Character");
        arlong.setColor("Blue");
        arlong.setCost(4);
        arlong.setPower(5000);
        arlong.setCounter(1000);
        arlong.setAttribute("Slash");
        arlong.setAffiliations("Fish-Man/Arlong Crew");
        arlong.setEffect("DON!!×1 Activate: Main You may rest this Character: Choose 1 card from your opponent's hand and reveal it. If the revealed card is an Event, place 1 card from your opponent's Life area at the bottom of the owner's deck.");
        arlong.setImagePath("/images/cards/OP01/OP01-063.png");
        cardRepository.save(arlong);

        Card alvida = new Card();
        alvida.setCardNumber("OP01-064");
        alvida.setName("Alvida");
        alvida.setCardType("Character");
        alvida.setColor("Blue");
        alvida.setCost(2);
        alvida.setPower(3000);
        alvida.setCounter(2000);
        alvida.setAttribute("Strike");
        alvida.setAffiliations("Buggy Pirates");
        alvida.setEffect("DON!!×1 When Attacking You may trash 1 card from your hand: Return up to 1 of your opponent's Characters with a cost of 3 or less to their hand.");
        alvida.setImagePath("/images/cards/OP01/OP01-064.png");
        cardRepository.save(alvida);

        Card vergo = new Card();
        vergo.setCardNumber("OP01-065");
        vergo.setName("Vergo");
        vergo.setCardType("Character");
        vergo.setColor("Blue"); // Primary color Blue
        vergo.setCost(5);
        vergo.setPower(7000);
        vergo.setCounter(1000);
        vergo.setAttribute("Strike");
        vergo.setAffiliations("Navy/Donquixote Pirates/Punk Hazard");
        vergo.setImagePath("/images/cards/OP01/OP01-065.png");
        cardRepository.save(vergo);

        Card krieg = new Card();
        krieg.setCardNumber("OP01-066");
        krieg.setName("Krieg");
        krieg.setCardType("Character");
        krieg.setColor("Blue");
        krieg.setCost(4);
        krieg.setPower(6000);
        krieg.setCounter(1000);
        krieg.setAttribute("Ranged");
        krieg.setAffiliations("Krieg Pirates");
        krieg.setImagePath("/images/cards/OP01/OP01-066.png");
        cardRepository.save(krieg);

        Card crocodileChar = new Card();
        crocodileChar.setCardNumber("OP01-067");
        crocodileChar.setName("Crocodile");
        crocodileChar.setCardType("Character");
        crocodileChar.setColor("Blue"); // Primary color Blue
        crocodileChar.setCost(7);
        crocodileChar.setPower(7000);
        crocodileChar.setCounter(1000);
        crocodileChar.setAttribute("Special");
        crocodileChar.setAffiliations("The Seven Warlords of the Sea/Baroque Works");
        crocodileChar.setEffect("Banish (When a character deals damage, the target card is trashed without activating its Triggers)\\nDON!!×1 Blue Event cards in your hand cost 1 less to play.");
        crocodileChar.setImagePath("/images/cards/OP01/OP01-067.png");
        cardRepository.save(crocodileChar);

        Card geckoMoria = new Card();
        geckoMoria.setCardNumber("OP01-068");
        geckoMoria.setName("Gecko Moria");
        geckoMoria.setCardType("Character");
        geckoMoria.setColor("Blue"); // Primary color Blue
        geckoMoria.setCost(4);
        geckoMoria.setPower(5000);
        geckoMoria.setCounter(1000);
        geckoMoria.setAttribute("Special");
        geckoMoria.setAffiliations("The Seven Warlords of the Sea/Thriller Bark Pirates");
        geckoMoria.setTiming("Your Turn");
        geckoMoria.setEffect("Your Turn If you have 5 or more cards in your hand, this Character gains Double Attack (This card deals 2 damage).");
        geckoMoria.setImagePath("/images/cards/OP01/OP01-068.png");
        cardRepository.save(geckoMoria);

        Card caesarClown = new Card();
        caesarClown.setCardNumber("OP01-069");
        caesarClown.setName("Caesar Clown");
        caesarClown.setCardType("Character");
        caesarClown.setColor("Blue"); // Primary color Blue
        caesarClown.setCost(4);
        caesarClown.setPower(5000);
        caesarClown.setCounter(1000);
        caesarClown.setAttribute("Special");
        caesarClown.setAffiliations("Scientist/Punk Hazard");
        caesarClown.setEffect("On K.O. Play 1 [Smiley] card from your deck, then shuffle your deck.");
        caesarClown.setImagePath("/images/cards/OP01/OP01-069.png");
        cardRepository.save(caesarClown);

        Card draculeMihawk = new Card();
        draculeMihawk.setCardNumber("OP01-070");
        draculeMihawk.setName("Dracule Mihawk");
        draculeMihawk.setCardType("Character");
        draculeMihawk.setColor("Blue");
        draculeMihawk.setCost(9);
        draculeMihawk.setPower(9000);
        draculeMihawk.setAttribute("Slash");
        draculeMihawk.setAffiliations("The Seven Warlords of the Sea");
        draculeMihawk.setEffect("On Play Place up to 1 Character with a cost of 7 or less at the bottom of the owner's deck.");
        draculeMihawk.setImagePath("/images/cards/OP01/OP01-070.png");
        cardRepository.save(draculeMihawk);

        Card jinbeChar = new Card();
        jinbeChar.setCardNumber("OP01-071");
        jinbeChar.setName("Jinbe");
        jinbeChar.setCardType("Character");
        jinbeChar.setColor("Blue");
        jinbeChar.setCost(4);
        jinbeChar.setPower(2000);
        jinbeChar.setCounter(1000);
        jinbeChar.setAttribute("Strike");
        jinbeChar.setAffiliations("Fish-Man/Straw Hat Crew");
        jinbeChar.setEffect("On Play Place 1 Character with a cost of 3 or less at the bottom of the owner's deck.\\nTrigger Play this card.");
        jinbeChar.setImagePath("/images/cards/OP01/OP01-071.png");
        cardRepository.save(jinbeChar);

        Card smiley = new Card();
        smiley.setCardNumber("OP01-072");
        smiley.setName("Smiley");
        smiley.setCardType("Character");
        smiley.setColor("Blue"); // Primary color Blue
        smiley.setCost(3);
        smiley.setPower(1000);
        smiley.setCounter(1000);
        smiley.setAttribute("Special");
        smiley.setAffiliations("Biological Weapon/Punk Hazard");
        smiley.setTiming("Your Turn");
        smiley.setEffect("DON!!×1 Your Turn This Character gains +1000 power for each card in your hand.");
        smiley.setImagePath("/images/cards/OP01/OP01-072.png");
        cardRepository.save(smiley);

        Card doflamingoChr = new Card();
        doflamingoChr.setCardNumber("OP01-073");
        doflamingoChr.setName("Donquixote Doflamingo");
        doflamingoChr.setCardType("Character");
        doflamingoChr.setColor("Blue");
        doflamingoChr.setCost(3);
        doflamingoChr.setPower(4000);
        doflamingoChr.setCounter(1000);
        doflamingoChr.setAttribute("Special");
        doflamingoChr.setAffiliations("The Seven Warlords of the Sea/Donquixote Pirates");
        doflamingoChr.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\nOn Play Look at 5 cards from the top of your deck and return them to the top or bottom of the deck in any order.");
        doflamingoChr.setImagePath("/images/cards/OP01/OP01-073.png");
        cardRepository.save(doflamingoChr);

        Card bartholomew = new Card();
        bartholomew.setCardNumber("OP01-074");
        bartholomew.setName("Bartholomew Kuma");
        bartholomew.setCardType("Character");
        bartholomew.setColor("Blue"); // Primary color Blue
        bartholomew.setCost(4);
        bartholomew.setPower(5000);
        bartholomew.setCounter(1000);
        bartholomew.setAttribute("Strike");
        bartholomew.setAffiliations("The Seven Warlords of the Sea/Revolutionary Army");
        bartholomew.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\nOn K.O. Play up to 1 [Pacifista] card with a cost of 4 or less from your hand.");
        bartholomew.setImagePath("/images/cards/OP01/OP01-074.png");
        cardRepository.save(bartholomew);

        Card pacifista = new Card();
        pacifista.setCardNumber("OP01-075");
        pacifista.setName("Pacifista");
        pacifista.setCardType("Character");
        pacifista.setColor("Blue"); // Primary color Blue
        pacifista.setCost(4);
        pacifista.setPower(5000);
        pacifista.setCounter(1000);
        pacifista.setAttribute("Strike");
        pacifista.setAffiliations("Biological Weapon/Navy");
        pacifista.setEffect("You may have more than 4 copies of this card in your deck.\\nBlocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        pacifista.setImagePath("/images/cards/OP01/OP01-075.png");
        cardRepository.save(pacifista);

        Card bellamy = new Card();
        bellamy.setCardNumber("OP01-076");
        bellamy.setName("Bellamy");
        bellamy.setCardType("Character");
        bellamy.setColor("Blue");
        bellamy.setCost(2);
        bellamy.setPower(4000);
        bellamy.setCounter(1000);
        bellamy.setAttribute("Strike");
        bellamy.setAffiliations("Dressrosa");
        bellamy.setImagePath("/images/cards/OP01/OP01-076.png");
        cardRepository.save(bellamy);

        Card perona = new Card();
        perona.setCardNumber("OP01-077");
        perona.setName("Perona");
        perona.setCardType("Character");
        perona.setColor("Blue");
        perona.setCost(1);
        perona.setPower(2000);
        perona.setCounter(1000);
        perona.setAttribute("Special");
        perona.setAffiliations("Thriller Bark Pirates");
        perona.setEffect("On Play Look at 5 cards from the top of your deck and return them to the top or bottom of the deck in any order.");
        perona.setImagePath("/images/cards/OP01/OP01-077.png");
        cardRepository.save(perona);
        
        Card hancock = new Card();
        hancock.setCardNumber("OP01-078");
        hancock.setName("Boa Hancock");
        hancock.setCardType("Character");
        hancock.setColor("Blue"); // Primary color Blue
        hancock.setCost(4);
        hancock.setPower(5000);
        hancock.setCounter(1000);
        hancock.setAttribute("Special");
        hancock.setAffiliations("The Seven Warlords of the Sea/Kuja Pirates");
        hancock.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\nDON!!×1 When Attacking/On Block Draw 1 card if there are 5 or less cards in your hand.");
        hancock.setImagePath("/images/cards/OP01/OP01-078.png");
        cardRepository.save(hancock);

        Card missAllSunday = new Card();
        missAllSunday.setCardNumber("OP01-079");
        missAllSunday.setName("Miss All Sunday");
        missAllSunday.setCardType("Character");
        missAllSunday.setColor("Blue");
        missAllSunday.setCost(3);
        missAllSunday.setPower(1000);
        missAllSunday.setCounter(1000);
        missAllSunday.setAttribute("Strike");
        missAllSunday.setAffiliations("Baroque Works");
        missAllSunday.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\nOn K.O. If your Leader has the {Baroque Works} type, return up to 1 Event card from your trash to your hand.");
        missAllSunday.setImagePath("/images/cards/OP01/OP01-079.png");
        cardRepository.save(missAllSunday);

        Card missDoubleFinger = new Card();
        missDoubleFinger.setCardNumber("OP01-080");
        missDoubleFinger.setName("Miss Double Finger (Zala)");
        missDoubleFinger.setCardType("Character");
        missDoubleFinger.setColor("Blue");
        missDoubleFinger.setCost(3);
        missDoubleFinger.setPower(4000);
        missDoubleFinger.setCounter(1000);
        missDoubleFinger.setAttribute("Slash");
        missDoubleFinger.setAffiliations("Baroque Works");
        missDoubleFinger.setEffect("On K.O. Draw 1 card.");
        missDoubleFinger.setImagePath("/images/cards/OP01/OP01-080.png");
        cardRepository.save(missDoubleFinger);

        Card mocha = new Card();
        mocha.setCardNumber("OP01-081");
        mocha.setName("Mocha");
        mocha.setCardType("Character");
        mocha.setColor("Blue");
        mocha.setCost(3);
        mocha.setPower(5000);
        mocha.setCounter(1000);
        mocha.setAttribute("Strike");
        mocha.setAffiliations("Punk Hazard");
        mocha.setImagePath("/images/cards/OP01/OP01-081.png");
        cardRepository.save(mocha);

        Card monet = new Card();
        monet.setCardNumber("OP01-082");
        monet.setName("Monet");
        monet.setCardType("Character");
        monet.setColor("Blue");
        monet.setCost(2);
        monet.setPower(3000);
        monet.setCounter(1000);
        monet.setAttribute("Special");
        monet.setAffiliations("Donquixote Pirates/Punk Hazard");
        monet.setEffect("Trigger Play this card.");
        monet.setImagePath("/images/cards/OP01/OP01-082.png");
        cardRepository.save(monet);

        Card mr1 = new Card();
        mr1.setCardNumber("OP01-083");
        mr1.setName("Mr. 1 (Daz Bones)");
        mr1.setCardType("Character");
        mr1.setColor("Blue");
        mr1.setCost(2);
        mr1.setPower(3000);
        mr1.setCounter(1000);
        mr1.setAttribute("Slash");
        mr1.setAffiliations("Baroque Works");
        mr1.setTiming("Your Turn");
        mr1.setEffect("DON!!×1 Your Turn If your Leader has the {Baroque Works} type, this Character gains +1000 power for every 2 Event cards in your trash.");
        mr1.setImagePath("/images/cards/OP01/OP01-083.png");
        cardRepository.save(mr1);

        Card mr2 = new Card();
        mr2.setCardNumber("OP01-084");
        mr2.setName("Mr. 2 Bon Clay (Bentham)");
        mr2.setCardType("Character");
        mr2.setColor("Blue");
        mr2.setCost(3);
        mr2.setPower(4000);
        mr2.setCounter(2000);
        mr2.setAttribute("Strike");
        mr2.setAffiliations("Baroque Works");
        mr2.setEffect("DON!!×1 When Attacking Look at 5 cards from the top of your deck; reveal up to 1 {Baroque Works} type Event card and add it to your hand. Place the rest at the bottom of your deck in any order.");
        mr2.setImagePath("/images/cards/OP01/OP01-084.png");
        cardRepository.save(mr2);

        Card mr3 = new Card();
        mr3.setCardNumber("OP01-085");
        mr3.setName("Mr. 3 (Galdino)");
        mr3.setCardType("Character");
        mr3.setColor("Blue");
        mr3.setCost(2);
        mr3.setPower(3000);
        mr3.setCounter(1000);
        mr3.setAttribute("Special");
        mr3.setAffiliations("Baroque Works");
        mr3.setEffect("On Play If your Leader has the {Baroque Works} type, up to 1 of your opponent's Characters with a cost of 4 or less cannot attack, until your opponent's next end of turn.");
        mr3.setImagePath("/images/cards/OP01/OP01-085.png");
        cardRepository.save(mr3);
        
        // Blue Events
        Card overheat = new Card();
        overheat.setCardNumber("OP01-086");
        overheat.setName("Overheat");
        overheat.setCardType("Event");
        overheat.setColor("Blue");
        overheat.setCost(2);
        overheat.setAffiliations("The Seven Warlords of the Sea/Donquixote Pirates");
        overheat.setEffect("Counter Your Leader or up to 1 of your Characters gains +4000 power during this battle. Then, return up to 1 active Character with a cost of 3 or less to the owner's hand.\\nTrigger Return up to 1 Character with a cost of 4 or less to the owner's hand.");
        overheat.setImagePath("/images/cards/OP01/OP01-086.png");
        cardRepository.save(overheat);

        Card officerAgents = new Card();
        officerAgents.setCardNumber("OP01-087");
        officerAgents.setName("Officer Agents");
        officerAgents.setCardType("Event");
        officerAgents.setColor("Blue");
        officerAgents.setCost(2);
        officerAgents.setAffiliations("Baroque Works");
        officerAgents.setEffect("Counter Play up to 1 {Baroque Works} type Character card with a cost of 3 or less from your hand.\\nTrigger Activate this card's Counter effect.");
        officerAgents.setImagePath("/images/cards/OP01/OP01-087.png");
        cardRepository.save(officerAgents);

        Card desertSpada = new Card();
        desertSpada.setCardNumber("OP01-088");
        desertSpada.setName("Desert Spada");
        desertSpada.setCardType("Event");
        desertSpada.setColor("Blue");
        desertSpada.setCost(1);
        desertSpada.setAffiliations("The Seven Warlords of the Sea/Baroque Works");
        desertSpada.setEffect("Counter Your Leader or up to 1 of your Characters gains +2000 power during this battle. Then, look at 3 cards from the top of your deck and return them to the top or bottom of the deck in any order.\\nTrigger Draw 2 cards and trash 1 card from your hand.");
        desertSpada.setImagePath("/images/cards/OP01/OP01-088.png");
        cardRepository.save(desertSpada);

        Card crescentCutlass = new Card();
        crescentCutlass.setCardNumber("OP01-089");
        crescentCutlass.setName("Crescent Cutlass");
        crescentCutlass.setCardType("Event");
        crescentCutlass.setColor("Blue");
        crescentCutlass.setCost(3);
        crescentCutlass.setAffiliations("The Seven Warlords of the Sea/Baroque Works");
        crescentCutlass.setEffect("Counter If your Leader has the {The Seven Warlords of the Sea} type, return up to 1 Character with a cost of 5 or less to the owner's hand.");
        crescentCutlass.setImagePath("/images/cards/OP01/OP01-089.png");
        cardRepository.save(crescentCutlass);

        Card baroqueWorks = new Card();
        baroqueWorks.setCardNumber("OP01-090");
        baroqueWorks.setName("Baroque Works");
        baroqueWorks.setCardType("Event");
        baroqueWorks.setColor("Blue");
        baroqueWorks.setCost(1);
        baroqueWorks.setAffiliations("Baroque Works");
        baroqueWorks.setEffect("Main Look at 5 cards from the top of your deck; reveal up to 1 {Baroque Works} type card other than [Baroque Works] and add it to your hand. Then, place the rest at the bottom of your deck in any order.");
        baroqueWorks.setImagePath("/images/cards/OP01/OP01-090.png");
        cardRepository.save(baroqueWorks);
        
        // Purple Cards
        Card kingLeader = new Card();
        kingLeader.setCardNumber("OP01-091");
        kingLeader.setName("King");
        kingLeader.setCardType("Leader");
        kingLeader.setColor("Purple");
        kingLeader.setPower(5000);
        kingLeader.setLife(5);
        kingLeader.setAffiliations("Animal Kingdom Pirates");
        kingLeader.setTiming("Your Turn");
        kingLeader.setEffect("Your Turn If you have 10 DON!! cards on your field, all of your opponent's Characters have -1000 power.");
        kingLeader.setImagePath("/images/cards/OP01/OP01-091.png");
        cardRepository.save(kingLeader);

        Card urashima = new Card();
        urashima.setCardNumber("OP01-092");
        urashima.setName("Urashima");
        urashima.setCardType("Character");
        urashima.setColor("Purple");
        urashima.setCost(7);
        urashima.setPower(9000);
        urashima.setCounter(1000);
        urashima.setAttribute("Strike");
        urashima.setAffiliations("Wano Country");
        urashima.setImagePath("/images/cards/OP01/OP01-092.png");
        cardRepository.save(urashima);

        Card ulti = new Card();
        ulti.setCardNumber("OP01-093");
        ulti.setName("Ulti");
        ulti.setCardType("Character");
        ulti.setColor("Purple");
        ulti.setCost(2);
        ulti.setPower(3000);
        ulti.setCounter(1000);
        ulti.setAttribute("Strike");
        ulti.setAffiliations("Animal Kingdom Pirates");
        ulti.setEffect("On Play [1] (You may rest the specified number of DON!! cards in your Cost Area): Add 1 DON!! card from your DON!! deck and rest it.");
        ulti.setImagePath("/images/cards/OP01/OP01-093.png");
        cardRepository.save(ulti);

        Card kaidoChar = new Card();
        kaidoChar.setCardNumber("OP01-094");
        kaidoChar.setName("Kaido");
        kaidoChar.setCardType("Character");
        kaidoChar.setColor("Purple");
        kaidoChar.setCost(10);
        kaidoChar.setPower(12000);
        kaidoChar.setAttribute("Strike");
        kaidoChar.setAffiliations("The Four Emperors/Animal Kingdom Pirates");
        kaidoChar.setEffect("On Play DON!! -6 (You may return the specified number of DON!! cards from your field to your DON!! deck): If your Leader has the {Animal Kingdom Pirates} type, K.O. all Characters other than this one.");
        kaidoChar.setImagePath("/images/cards/OP01/OP01-094.png");
        cardRepository.save(kaidoChar);

        Card kyoshirou = new Card();
        kyoshirou.setCardNumber("OP01-095");
        kyoshirou.setName("Kyoshirou");
        kyoshirou.setCardType("Character");
        kyoshirou.setColor("Purple");
        kyoshirou.setCost(5);
        kyoshirou.setPower(6000);
        kyoshirou.setCounter(1000);
        kyoshirou.setAttribute("Slash");
        kyoshirou.setAffiliations("Wano Country");
        kyoshirou.setEffect("On Play If you have 8 or more DON!! cards on your field, draw 1 card.");
        kyoshirou.setImagePath("/images/cards/OP01/OP01-095.png");
        cardRepository.save(kyoshirou);

        Card kingChar = new Card();
        kingChar.setCardNumber("OP01-096");
        kingChar.setName("King");
        kingChar.setCardType("Character");
        kingChar.setColor("Purple");
        kingChar.setCost(7);
        kingChar.setPower(7000);
        kingChar.setAttribute("Slash");
        kingChar.setAffiliations("Animal Kingdom Pirates");
        kingChar.setEffect("On Play DON!! -2 (You may return the specified number of DON!! cards from your field to your DON!! deck): K.O. up to 1 of your opponent's Characters with a cost of 3 or less and up to 1 of your opponent's Characters with a cost of 2 or less.");
        kingChar.setImagePath("/images/cards/OP01/OP01-096.png");
        cardRepository.save(kingChar);

        Card queen = new Card();
        queen.setCardNumber("OP01-097");
        queen.setName("Queen");
        queen.setCardType("Character");
        queen.setColor("Purple");
        queen.setCost(6);
        queen.setPower(5000);
        queen.setCounter(1000);
        queen.setAttribute("Strike");
        queen.setAffiliations("Animal Kingdom Pirates");
        queen.setEffect("On Play DON!! -1 (You may return the specified number of DON!! cards from your field to your DON!! deck): This Character gains Rush during this turn. Then, give up to 1 of your opponent's Characters -2000 power during this turn. (This card can attack on the turn in which it is played.)");
        queen.setImagePath("/images/cards/OP01/OP01-097.png");
        Card savedQueen = cardRepository.save(queen);
        System.out.println("Saved card " + savedQueen.getCardNumber() + " with set: " + savedQueen.getSet());

        Card kurozumiOrochi = new Card();
        kurozumiOrochi.setCardNumber("OP01-098");
        kurozumiOrochi.setName("Kurozumi Orochi");
        kurozumiOrochi.setCardType("Character");
        kurozumiOrochi.setColor("Purple");
        kurozumiOrochi.setCost(1);
        kurozumiOrochi.setPower(2000);
        kurozumiOrochi.setCounter(2000);
        kurozumiOrochi.setAttribute("Wisdom");
        kurozumiOrochi.setAffiliations("Wano Country/Kurozumi Family");
        kurozumiOrochi.setEffect("On Play Reveal 1 [Artificial Devil Fruit Smile] from your deck and add it to your hand. Then, shuffle your deck.");
        kurozumiOrochi.setImagePath("/images/cards/OP01/OP01-098.png");
        cardRepository.save(kurozumiOrochi);

        Card kurozumiSemimaru = new Card();
        kurozumiSemimaru.setCardNumber("OP01-099");
        kurozumiSemimaru.setName("Kurozumi Semimaru");
        kurozumiSemimaru.setCardType("Character");
        kurozumiSemimaru.setColor("Purple");
        kurozumiSemimaru.setCost(2);
        kurozumiSemimaru.setPower(3000);
        kurozumiSemimaru.setCounter(1000);
        kurozumiSemimaru.setAttribute("Special");
        kurozumiSemimaru.setAffiliations("Wano Country/Kurozumi Family");
        kurozumiSemimaru.setEffect("{Kurozumi Family} type Characters other than your [Kurozumi Semimaru] cannot be K.O.'d in battle.");
        kurozumiSemimaru.setImagePath("/images/cards/OP01/OP01-099.png");
        cardRepository.save(kurozumiSemimaru);

        Card kurozumiHigurashi = new Card();
        kurozumiHigurashi.setCardNumber("OP01-100");
        kurozumiHigurashi.setName("Kurozumi Higurashi");
        kurozumiHigurashi.setCardType("Character");
        kurozumiHigurashi.setColor("Purple");
        kurozumiHigurashi.setCost(2);
        kurozumiHigurashi.setPower(3000);
        kurozumiHigurashi.setCounter(1000);
        kurozumiHigurashi.setAttribute("Special");
        kurozumiHigurashi.setAffiliations("Wano Country/Kurozumi Family");
        kurozumiHigurashi.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        kurozumiHigurashi.setImagePath("/images/cards/OP01/OP01-100.png");
        cardRepository.save(kurozumiHigurashi);

        Card sasaki = new Card();
        sasaki.setCardNumber("OP01-101");
        sasaki.setName("Sasaki");
        sasaki.setCardType("Character");
        sasaki.setColor("Purple");
        sasaki.setCost(3);
        sasaki.setPower(4000);
        sasaki.setCounter(2000);
        sasaki.setAttribute("Slash");
        sasaki.setAffiliations("Animal Kingdom Pirates");
        sasaki.setEffect("DON!!×1 When Attacking You may trash 1 card from your hand: Add 1 DON!! card from your DON!! deck and rest it.");
        sasaki.setImagePath("/images/cards/OP01/OP01-101.png");
        cardRepository.save(sasaki);

        Card jack = new Card();
        jack.setCardNumber("OP01-102");
        jack.setName("Jack");
        jack.setCardType("Character");
        jack.setColor("Purple");
        jack.setCost(3);
        jack.setPower(4000);
        jack.setCounter(1000);
        jack.setAttribute("Strike");
        jack.setAffiliations("Animal Kingdom Pirates");
        jack.setEffect("When Attacking DON!! -1 (You may return the specified number of DON!! cards from your field to your DON!! deck): Your opponent trashes 1 card from their hand.");
        jack.setImagePath("/images/cards/OP01/OP01-102.png");
        cardRepository.save(jack);

        Card apoo = new Card();
        apoo.setCardNumber("OP01-103");
        apoo.setName("Scratchmen Apoo");
        apoo.setCardType("Character");
        apoo.setColor("Purple");
        apoo.setCost(4);
        apoo.setPower(6000);
        apoo.setCounter(1000);
        apoo.setAttribute("Slash");
        apoo.setAffiliations("Animal Kingdom Pirates/On Air Pirates");
        apoo.setImagePath("/images/cards/OP01/OP01-103.png");
        cardRepository.save(apoo);

        Card speed = new Card();
        speed.setCardNumber("OP01-104");
        speed.setName("Speed");
        speed.setCardType("Character");
        speed.setColor("Purple");
        speed.setCost(2);
        speed.setPower(3000);
        speed.setCounter(1000);
        speed.setAttribute("Strike");
        speed.setAffiliations("Animal Kingdom Pirates/Smile");
        speed.setEffect("Trigger Play this card.");
        speed.setImagePath("/images/cards/OP01/OP01-104.png");
        cardRepository.save(speed);

        Card baoHuang = new Card();
        baoHuang.setCardNumber("OP01-105");
        baoHuang.setName("Bao Huang");
        baoHuang.setCardType("Character");
        baoHuang.setColor("Purple");
        baoHuang.setCost(2);
        baoHuang.setPower(3000);
        baoHuang.setCounter(1000);
        baoHuang.setAttribute("Wisdom");
        baoHuang.setAffiliations("Animal Kingdom Pirates/Smile");
        baoHuang.setEffect("On Play Choose 2 cards from your opponent's hand and reveal them.");
        baoHuang.setImagePath("/images/cards/OP01/OP01-105.png");
        cardRepository.save(baoHuang);

        Card hawkins = new Card();
        hawkins.setCardNumber("OP01-106");
        hawkins.setName("Basil Hawkins");
        hawkins.setCardType("Character");
        hawkins.setColor("Purple");
        hawkins.setCost(4);
        hawkins.setPower(2000);
        hawkins.setCounter(1000);
        hawkins.setAttribute("Slash");
        hawkins.setAffiliations("Animal Kingdom Pirates/Hawkins Pirates");
        hawkins.setEffect("On Play Add 1 DON!! card from your DON!! deck and rest it.\\nTrigger Play this card.");
        hawkins.setImagePath("/images/cards/OP01/OP01-106.png");
        cardRepository.save(hawkins);

        Card babanuki = new Card();
        babanuki.setCardNumber("OP01-107");
        babanuki.setName("Babanuki");
        babanuki.setCardType("Character");
        babanuki.setColor("Purple");
        babanuki.setCost(5);
        babanuki.setPower(7000);
        babanuki.setCounter(1000);
        babanuki.setAttribute("Ranged");
        babanuki.setAffiliations("Animal Kingdom Pirates/Smile");
        babanuki.setImagePath("/images/cards/OP01/OP01-107.png");
        cardRepository.save(babanuki);

        Card kamazo = new Card();
        kamazo.setCardNumber("OP01-108");
        kamazo.setName("Kamazo the Manslayer");
        kamazo.setCardType("Character");
        kamazo.setColor("Purple");
        kamazo.setCost(4);
        kamazo.setPower(5000);
        kamazo.setCounter(1000);
        kamazo.setAttribute("Slash");
        kamazo.setAffiliations("Supernovas/Kid Pirates/Smile");
        kamazo.setEffect("On K.O. DON!! -1 (You may return the specified number of DON!! cards from your field to your DON!! deck): K.O. up to 1 of your opponent's Characters with a cost of 5 or less.");
        kamazo.setImagePath("/images/cards/OP01/OP01-108.png");
        cardRepository.save(kamazo);

        Card whosWho = new Card();
        whosWho.setCardNumber("OP01-109");
        whosWho.setName("Who's.Who");
        whosWho.setCardType("Character");
        whosWho.setColor("Purple");
        whosWho.setCost(2);
        whosWho.setPower(3000);
        whosWho.setCounter(1000);
        whosWho.setAttribute("Slash");
        whosWho.setAffiliations("Animal Kingdom Pirates");
        whosWho.setTiming("Your Turn");
        whosWho.setEffect("DON!!×1 Your Turn If you have 8 or more DON!! on your field, this Character gains +1000 power.");
        whosWho.setImagePath("/images/cards/OP01/OP01-109.png");
        cardRepository.save(whosWho);

        Card fukurokuju = new Card();
        fukurokuju.setCardNumber("OP01-110");
        fukurokuju.setName("Fukurokuju");
        fukurokuju.setCardType("Character");
        fukurokuju.setColor("Purple");
        fukurokuju.setCost(6);
        fukurokuju.setPower(8000);
        fukurokuju.setCounter(1000);
        fukurokuju.setAttribute("Special");
        fukurokuju.setAffiliations("Wano Country/Animal Kingdom Pirates");
        fukurokuju.setImagePath("/images/cards/OP01/OP01-110.png");
        cardRepository.save(fukurokuju);

        Card blackMaria = new Card();
        blackMaria.setCardNumber("OP01-111");
        blackMaria.setName("Black Maria");
        blackMaria.setCardType("Character");
        blackMaria.setColor("Purple");
        blackMaria.setCost(4);
        blackMaria.setPower(5000);
        blackMaria.setCounter(1000);
        blackMaria.setAttribute("Special");
        blackMaria.setAffiliations("Animal Kingdom Pirates");
        blackMaria.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\nOn Block DON!! -1 (You may return the specified number of DON!! cards from your field to your DON!! deck): This Character gains +1000 power during this turn.");
        blackMaria.setImagePath("/images/cards/OP01/OP01-111.png");
        cardRepository.save(blackMaria);

        Card pageOne = new Card();
        pageOne.setCardNumber("OP01-112");
        pageOne.setName("Page One");
        pageOne.setCardType("Character");
        pageOne.setColor("Purple");
        pageOne.setCost(4);
        pageOne.setPower(5000);
        pageOne.setCounter(1000);
        pageOne.setAttribute("Strike");
        pageOne.setAffiliations("Animal Kingdom Pirates");
        pageOne.setEffect("Activate: Main Once Per Turn DON!! -1 (You may return the specified number of DON!! cards from your field to your DON!! deck): This Character can also attack your opponent's active Characters during this turn.");
        pageOne.setImagePath("/images/cards/OP01/OP01-112.png");
        cardRepository.save(pageOne);

        Card holdem = new Card();
        holdem.setCardNumber("OP01-113");
        holdem.setName("Holdem");
        holdem.setCardType("Character");
        holdem.setColor("Purple");
        holdem.setCost(3);
        holdem.setPower(4000);
        holdem.setCounter(1000);
        holdem.setAttribute("Strike");
        holdem.setAffiliations("Animal Kingdom Pirates/Smile");
        holdem.setEffect("On K.O. Add 1 DON!! card from your DON!! deck and rest it.");
        holdem.setImagePath("/images/cards/OP01/OP01-113.png");
        cardRepository.save(holdem);

        Card xDrake = new Card();
        xDrake.setCardNumber("OP01-114");
        xDrake.setName("X.Drake");
        xDrake.setCardType("Character");
        xDrake.setColor("Purple");
        xDrake.setCost(5);
        xDrake.setPower(5000);
        xDrake.setCounter(2000);
        xDrake.setAttribute("Slash");
        xDrake.setAffiliations("Navy/Drake Pirates/Animal Kingdom Pirates");
        xDrake.setEffect("On Play DON!! -1 (You may return the specified number of DON!! cards from your field to your DON!! deck): Your opponent trashes 1 card from their hand.");
        xDrake.setImagePath("/images/cards/OP01/OP01-114.png");
        cardRepository.save(xDrake);
        
        // Purple Events
        Card elephantsMarchoo = new Card();
        elephantsMarchoo.setCardNumber("OP01-115");
        elephantsMarchoo.setName("Elephant's Marchoo");
        elephantsMarchoo.setCardType("Event");
        elephantsMarchoo.setColor("Purple");
        elephantsMarchoo.setCost(4);
        elephantsMarchoo.setAffiliations("Animal Kingdom Pirates/Smile");
        elephantsMarchoo.setEffect("Main K.O. up to 1 of your opponent's Characters with a cost of 2 or less, then add 1 DON!! card from your DON!! deck and set it as active.\\nTrigger Activate this card's Main effect.");
        elephantsMarchoo.setImagePath("/images/cards/OP01/OP01-115.png");
        cardRepository.save(elephantsMarchoo);

        Card artificialSmile = new Card();
        artificialSmile.setCardNumber("OP01-116");
        artificialSmile.setName("Artificial Devil Fruit Smile");
        artificialSmile.setCardType("Event");
        artificialSmile.setColor("Purple");
        artificialSmile.setCost(2);
        artificialSmile.setAffiliations("Animal Kingdom Pirates/Smile");
        artificialSmile.setEffect("Main Look at 5 from the top of your deck; reveal up to 1 {Smile} type Character card with a cost of 3 or less and play it. Then, place the rest at the bottom of your deck in any order.\\nTrigger Activate this card's Main effect.");
        artificialSmile.setImagePath("/images/cards/OP01/OP01-116.png");
        cardRepository.save(artificialSmile);

        Card sheepsHorn = new Card();
        sheepsHorn.setCardNumber("OP01-117");
        sheepsHorn.setName("Sheep's Horn");
        sheepsHorn.setCardType("Event");
        sheepsHorn.setColor("Purple");
        sheepsHorn.setCost(2);
        sheepsHorn.setAffiliations("Animal Kingdom Pirates/Smile");
        sheepsHorn.setEffect("Main DON!! -1 (You may return the specified number of DON!! cards from your field to your DON!! deck): Rest up to 1 of your opponent's Characters with a cost of 6 or less.");
        sheepsHorn.setImagePath("/images/cards/OP01/OP01-117.png");
        cardRepository.save(sheepsHorn);

        Card ultiMortar = new Card();
        ultiMortar.setCardNumber("OP01-118");
        ultiMortar.setName("Ulti-Mortar");
        ultiMortar.setCardType("Event");
        ultiMortar.setColor("Purple");
        ultiMortar.setCost(1);
        ultiMortar.setAffiliations("Animal Kingdom Pirates");
        ultiMortar.setEffect("Counter DON!! -2 (You may return the specified number of DON!! cards from your field to your DON!! deck): Your Leader or up to 1 of your Characters gains +2000 Power during this battle. Then, draw 1 card.\\nTrigger Add 1 DON!! card from your DON!! deck and set it as active.");
        ultiMortar.setImagePath("/images/cards/OP01/OP01-118.png");
        cardRepository.save(ultiMortar);

        Card thunderBagua = new Card();
        thunderBagua.setCardNumber("OP01-119");
        thunderBagua.setName("Thunder Bagua");
        thunderBagua.setCardType("Event");
        thunderBagua.setColor("Purple");
        thunderBagua.setCost(2);
        thunderBagua.setAffiliations("Four Emperors/Animal Kingdom Pirates");
        thunderBagua.setEffect("Counter Your Leader or up to 1 of your Characters gains +4000 power during this battle. Then, if you have 2 or less Life cards, add 1 DON!! card from your DON!! deck and rest it.\\nTrigger Add 1 DON!! card from your DON!! deck and set it as active.");
        thunderBagua.setImagePath("/images/cards/OP01/OP01-119.png");
        cardRepository.save(thunderBagua);

        // Secret Rares
        Card shanks = new Card();
        shanks.setCardNumber("OP01-120");
        shanks.setName("Shanks");
        shanks.setCardType("Character");
        shanks.setColor("Red"); // SEC
        shanks.setCost(9);
        shanks.setPower(10000);
        shanks.setAttribute("Slash");
        shanks.setAffiliations("Four Emperors/Red-Haired Pirates");
        shanks.setEffect("Rush (This card can attack on the turn in which it is played.)\\nWhen Attacking Your opponent cannot activate a Blocker Character that has 2000 or less power during this battle.");
        shanks.setImagePath("/images/cards/OP01/OP01-120.png");
        cardRepository.save(shanks);

        Card yamato = new Card();
        yamato.setCardNumber("OP01-121");
        yamato.setName("Yamato");
        yamato.setCardType("Character");
        yamato.setColor("Green"); // SEC
        yamato.setCost(5);
        yamato.setPower(5000);
        yamato.setCounter(1000);
        yamato.setAttribute("Strike");
        yamato.setAffiliations("Wano Country");
        yamato.setEffect("This card's name is also treated as [Kozuki Oden].\\nDouble Attack (This card deals 2 damage).\\nBanish (When a character deals damage, the target card is trashed without activating its Trigger.)");
        yamato.setImagePath("/images/cards/OP01/OP01-121.png");
        cardRepository.save(yamato);

        System.out.println("Finished initializing OP01 cards");
    }
} 