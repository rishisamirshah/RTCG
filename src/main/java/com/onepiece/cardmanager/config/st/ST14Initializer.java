package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(24) // Order after ST13
public class ST14Initializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public ST14Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        String setCode = "ST14";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // Leader Card
        Card monkeyDLuffy = new Card();
        monkeyDLuffy.setCardNumber("ST14-001");
        monkeyDLuffy.setName("Monkey D. Luffy");
        monkeyDLuffy.setCardType("LEADER");
        monkeyDLuffy.setLife(5);
        monkeyDLuffy.setColor("RED");
        monkeyDLuffy.setPower(5000);
        monkeyDLuffy.setCost(null);
        monkeyDLuffy.setAffiliations("Straw Hat Crew");
        monkeyDLuffy.setAttribute("DON!!×1");
        monkeyDLuffy.setEffect("Give all of your characters +1 Cost. If you control a Cost 8 or higher character this leader gains +1000 Power.");
        monkeyDLuffy.setImagePath("/images/cards/ST14/ST14-001.png");
        monkeyDLuffy.setCounter(null);
        cardRepository.save(monkeyDLuffy);
        
        // Character Cards
        Card usopp = new Card();
        usopp.setCardNumber("ST14-002");
        usopp.setName("Usopp");
        usopp.setCardType("CHARACTER");
        usopp.setColor("RED");
        usopp.setPower(4000);
        usopp.setCost(3);
        usopp.setAffiliations("Straw Hat Crew");
        usopp.setAttribute("DON!!×1");
        usopp.setTiming("When Attacking");
        usopp.setEffect("If you have a character with a cost of 8 or more, KO up to one of your opponents characters with a cost of 4 or less.");
        usopp.setImagePath("/images/cards/ST14/ST14-002.png");
        usopp.setCounter(1000);
        cardRepository.save(usopp);
        
        Card sanji = new Card();
        sanji.setCardNumber("ST14-003");
        sanji.setName("Sanji");
        sanji.setCardType("CHARACTER");
        sanji.setColor("RED");
        sanji.setPower(6000);
        sanji.setCost(5);
        sanji.setAffiliations("Straw Hat Crew");
        sanji.setAttribute(null);
        sanji.setTiming("On Play");
        sanji.setEffect("If you have a cost 8 or greater character in play, KO up to one of your opponent's cost 5 or lower characters.");
        sanji.setImagePath("/images/cards/ST14/ST14-003.png");
        sanji.setCounter(null);
        cardRepository.save(sanji);
        
        Card jinbe = new Card();
        jinbe.setCardNumber("ST14-004");
        jinbe.setName("Jinbe");
        jinbe.setCardType("CHARACTER");
        jinbe.setColor("BLUE");
        jinbe.setPower(4000);
        jinbe.setCost(3);
        jinbe.setAffiliations("Fishman / Sun Pirates");
        jinbe.setAttribute(null);
        jinbe.setTiming("Activate: Main");
        jinbe.setEffect("Once Per Turn Give up to one of your black characters with the {Straw Hat Crew} +2 cost until the end of your opponents next turn.");
        jinbe.setImagePath("/images/cards/ST14/ST14-004.png");
        jinbe.setCounter(1000);
        cardRepository.save(jinbe);
        
        Card tonyTonyChopper = new Card();
        tonyTonyChopper.setCardNumber("ST14-005");
        tonyTonyChopper.setName("Tony Tony Chopper");
        tonyTonyChopper.setCardType("CHARACTER");
        tonyTonyChopper.setColor("GREEN");
        tonyTonyChopper.setPower(6000);
        tonyTonyChopper.setCost(4);
        tonyTonyChopper.setAffiliations("Animal/Straw Hat Crew");
        tonyTonyChopper.setAttribute(null);
        tonyTonyChopper.setImagePath("/images/cards/ST14/ST14-005.png");
        tonyTonyChopper.setCounter(1000);
        cardRepository.save(tonyTonyChopper);
        
        Card nami = new Card();
        nami.setCardNumber("ST14-006");
        nami.setName("Nami");
        nami.setCardType("CHARACTER");
        nami.setColor("PURPLE");
        nami.setPower(2000);
        nami.setCost(3);
        nami.setAffiliations("Straw Hat Crew");
        nami.setAttribute(null);
        nami.setTiming("On Play");
        nami.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) If you have a character with a cost of 8 or more and you have 0 or less cards in hand, draw 1 card.");
        nami.setImagePath("/images/cards/ST14/ST14-006.png");
        nami.setCounter(1000);
        cardRepository.save(nami);
        
        Card nicoRobin = new Card();
        nicoRobin.setCardNumber("ST14-007");
        nicoRobin.setName("Nico Robin");
        nicoRobin.setCardType("CHARACTER");
        nicoRobin.setColor("GREEN");
        nicoRobin.setPower(7000);
        nicoRobin.setCost(6);
        nicoRobin.setAffiliations("Straw Hat Crew");
        nicoRobin.setAttribute(null);
        nicoRobin.setTiming("On Play / When Attacking");
        nicoRobin.setEffect("If you have an 8 cost or above character on field, Give one of your opponent Character - 5 cost during this turn.");
        nicoRobin.setImagePath("/images/cards/ST14/ST14-007.png");
        nicoRobin.setCounter(1000);
        cardRepository.save(nicoRobin);
        
        Card haredas = new Card();
        haredas.setCardNumber("ST14-008");
        haredas.setName("Haredas");
        haredas.setCardType("CHARACTER");
        haredas.setColor("GREEN");
        haredas.setPower(0);
        haredas.setCost(1);
        haredas.setAffiliations("Sky Island");
        haredas.setAttribute(null);
        haredas.setTiming("Activate: Main");
        haredas.setEffect("You may rest this card: Give up to one of your black characters with the type {Straw Hat Pirates} +2 cost until the end of your opponents next turn. After this, if you control a Cost 8 or higher character, draw one card and trash one card from your hand.");
        haredas.setImagePath("/images/cards/ST14/ST14-008.png");
        haredas.setCounter(2000);
        cardRepository.save(haredas);
        
        Card franky = new Card();
        franky.setCardNumber("ST14-009");
        franky.setName("Franky");
        franky.setCardType("CHARACTER");
        franky.setColor("PURPLE");
        franky.setPower(6000);
        franky.setCost(5);
        franky.setAffiliations("Straw Hat Crew");
        franky.setAttribute("DON!!×1");
        franky.setTiming("Opponent's Turn");
        franky.setEffect("If you have a 6 cost or above character on your field, this character cannot be KO-ed by your opponent's effect and Gain +2000 power.");
        franky.setImagePath("/images/cards/ST14/ST14-009.png");
        franky.setCounter(1000);
        cardRepository.save(franky);
        
        Card brook = new Card();
        brook.setCardNumber("ST14-010");
        brook.setName("Brook");
        brook.setCardType("CHARACTER");
        brook.setColor("GREEN");
        brook.setPower(7000);
        brook.setCost(5);
        brook.setAffiliations("Straw Hat Crew");
        brook.setAttribute(null);
        brook.setImagePath("/images/cards/ST14/ST14-010.png");
        brook.setCounter(1000);
        cardRepository.save(brook);
        
        Card heracles = new Card();
        heracles.setCardNumber("ST14-011");
        heracles.setName("Heracles");
        heracles.setCardType("CHARACTER");
        heracles.setColor("GREEN");
        heracles.setPower(2000);
        heracles.setCost(1);
        heracles.setAffiliations("Boin Archipelago");
        heracles.setAttribute(null);
        heracles.setTiming("Activate: Main");
        heracles.setEffect("You may rest this card: Give up to one of your black characters with the type {Straw Hat Pirates} +2 cost until the end of your opponents next turn.");
        heracles.setImagePath("/images/cards/ST14/ST14-011.png");
        heracles.setCounter(2000);
        cardRepository.save(heracles);
        
        Card monkeyDLuffy8Cost = new Card();
        monkeyDLuffy8Cost.setCardNumber("ST14-012");
        monkeyDLuffy8Cost.setName("Monkey D. Luffy");
        monkeyDLuffy8Cost.setCardType("CHARACTER");
        monkeyDLuffy8Cost.setColor("RED");
        monkeyDLuffy8Cost.setPower(10000);
        monkeyDLuffy8Cost.setCost(8);
        monkeyDLuffy8Cost.setAffiliations("Straw Hat Crew");
        monkeyDLuffy8Cost.setAttribute(null);
        monkeyDLuffy8Cost.setEffect("If you have a cost 10 or greater character on your field, this character gains Rush (This card can attack on the turn in which it is played.)");
        monkeyDLuffy8Cost.setImagePath("/images/cards/ST14/ST14-012.png");
        monkeyDLuffy8Cost.setCounter(null);
        cardRepository.save(monkeyDLuffy8Cost);
        
        Card roronoaZoro = new Card();
        roronoaZoro.setCardNumber("ST14-013");
        roronoaZoro.setName("Roronoa Zoro");
        roronoaZoro.setCardType("CHARACTER");
        roronoaZoro.setColor("GREEN");
        roronoaZoro.setPower(8000);
        roronoaZoro.setCost(6);
        roronoaZoro.setAffiliations("Straw Hat Crew");
        roronoaZoro.setAttribute(null);
        roronoaZoro.setImagePath("/images/cards/ST14/ST14-013.png");
        roronoaZoro.setCounter(1000);
        cardRepository.save(roronoaZoro);
        
        // Event Cards
        Card gumGumGiantRifle = new Card();
        gumGumGiantRifle.setCardNumber("ST14-014");
        gumGumGiantRifle.setName("Gum Gum Giant Rifle");
        gumGumGiantRifle.setCardType("EVENT");
        gumGumGiantRifle.setColor("RED");
        gumGumGiantRifle.setCost(1);
        gumGumGiantRifle.setAffiliations("Straw Hat Crew");
        gumGumGiantRifle.setAttribute(null);
        gumGumGiantRifle.setTiming("Counter");
        gumGumGiantRifle.setEffect("If you control a cost 8 or greater character, give up to one leader or character +3000 Power for this battle.");
        gumGumGiantRifle.setTrigger("Add up to one 2 cost or lower character from your trash to your hand.");
        gumGumGiantRifle.setImagePath("/images/cards/ST14/ST14-014.png");
        gumGumGiantRifle.setCounter(null);
        cardRepository.save(gumGumGiantRifle);
        
        Card gumGumDiableThreeSwordStyleMoutonJetSixHundredPoundCannon = new Card();
        gumGumDiableThreeSwordStyleMoutonJetSixHundredPoundCannon.setCardNumber("ST14-015");
        gumGumDiableThreeSwordStyleMoutonJetSixHundredPoundCannon.setName("GUM GUM Diable Three Sword Style Mouton JET Six Hundred Pound Cannon");
        gumGumDiableThreeSwordStyleMoutonJetSixHundredPoundCannon.setCardType("EVENT");
        gumGumDiableThreeSwordStyleMoutonJetSixHundredPoundCannon.setColor("RED");
        gumGumDiableThreeSwordStyleMoutonJetSixHundredPoundCannon.setCost(2);
        gumGumDiableThreeSwordStyleMoutonJetSixHundredPoundCannon.setAffiliations("Straw Hat Crew");
        gumGumDiableThreeSwordStyleMoutonJetSixHundredPoundCannon.setAttribute(null);
        gumGumDiableThreeSwordStyleMoutonJetSixHundredPoundCannon.setTiming("Main");
        gumGumDiableThreeSwordStyleMoutonJetSixHundredPoundCannon.setEffect("Give your leader or up to one of your characters +3000 power for this turn. Then, if you have a cost 8 or greater character in play, KO up to one of your opponents cost 2 or less characters.");
        gumGumDiableThreeSwordStyleMoutonJetSixHundredPoundCannon.setTrigger("If you have a cost 8 or greater character in play, KO up to one of your opponents cost 5 or lower characters.");
        gumGumDiableThreeSwordStyleMoutonJetSixHundredPoundCannon.setImagePath("/images/cards/ST14/ST14-015.png");
        gumGumDiableThreeSwordStyleMoutonJetSixHundredPoundCannon.setCounter(null);
        cardRepository.save(gumGumDiableThreeSwordStyleMoutonJetSixHundredPoundCannon);
        
        Card iHaveMyCrew = new Card();
        iHaveMyCrew.setCardNumber("ST14-016");
        iHaveMyCrew.setName("I Have My Crew!!");
        iHaveMyCrew.setCardType("EVENT");
        iHaveMyCrew.setColor("GREEN");
        iHaveMyCrew.setCost(1);
        iHaveMyCrew.setAffiliations("Straw Hat Crew");
        iHaveMyCrew.setAttribute(null);
        iHaveMyCrew.setTiming("Main");
        iHaveMyCrew.setEffect("Draw one card. After this, give up to one of your characters +3 Cost until the end of your opponents next turn.");
        iHaveMyCrew.setTrigger("KO up to one of your opponents 3 Cost or lower characters.");
        iHaveMyCrew.setImagePath("/images/cards/ST14/ST14-016.png");
        iHaveMyCrew.setCounter(null);
        cardRepository.save(iHaveMyCrew);
        
        // Stage Card
        Card thousandSunny = new Card();
        thousandSunny.setCardNumber("ST14-017");
        thousandSunny.setName("Thousand Sunny");
        thousandSunny.setCardType("STAGE");
        thousandSunny.setColor("BLUE");
        thousandSunny.setCost(1);
        thousandSunny.setAffiliations("Straw Hat Crew");
        thousandSunny.setAttribute(null);
        thousandSunny.setEffect("Your black characters with the {Straw Hat Crew} type have +1 cost.");
        thousandSunny.setTiming("On Play");
        thousandSunny.setTrigger(null);
        thousandSunny.setImagePath("/images/cards/ST14/ST14-017.png");
        thousandSunny.setCounter(null);
        cardRepository.save(thousandSunny);

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 