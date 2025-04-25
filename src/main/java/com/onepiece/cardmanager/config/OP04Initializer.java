package com.onepiece.cardmanager.config;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4) // Updated: Run after OP01, OP02, and OP03 initializers
public class OP04Initializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public OP04Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Only initialize if we have no OP04 cards
        if (cardRepository.countBySetAndCardNumberStartingWith("OP04", "OP04") > 0) {
            System.out.println("OP04 cards already exist, skipping initialization");
            return;
        }

        System.out.println("Initializing OP04 cards...");
        
        // First initialize the RED cards from OP04
        initializeOP04RedCards();
        
        // Then initialize the GREEN cards from OP04
        initializeOP04GreenCards();
        
        // Then initialize the BLUE cards from OP04
        initializeOP04BlueCards();
        
        // Then initialize the PURPLE cards from OP04
        initializeOP04PurpleCards();

        // Then initialize the BLACK cards from OP04
        initializeOP04BlackCards();

        // Finally, initialize the YELLOW cards from OP04
        initializeOP04YellowCards();
        
        System.out.println("Finished initializing all OP04 cards");
    }
    
    private void initializeOP04RedCards() {
        System.out.println("Initializing OP04 Red cards...");
        
        // Leaders
        Card nefertariViviLeader = new Card();
        nefertariViviLeader.setCardNumber("OP04-001");
        nefertariViviLeader.setName("Nefertari Vivi");
        nefertariViviLeader.setCardType("Leader");
        nefertariViviLeader.setColor("Red/Blue"); // Dual Color
        nefertariViviLeader.setPower(5000);
        nefertariViviLeader.setLife(5);
        nefertariViviLeader.setAffiliations("Alabasta Kingdom");
        nefertariViviLeader.setAttribute("Slash");
        nefertariViviLeader.setEffect("This Leader cannot attack.\\nActivate: Main Once Per Turn [2] (You may rest the specified number of DON!! cards in your cost area): Draw 1 card, and up to 1 of your Characters gains <Rush> during this turn.");
        nefertariViviLeader.setImagePath("/images/cards/OP04/OP04-001.png");
        cardRepository.save(nefertariViviLeader);

        // Characters
        Card igaram = new Card();
        igaram.setCardNumber("OP04-002");
        igaram.setName("Igaram");
        igaram.setCardType("Character");
        igaram.setColor("Red");
        igaram.setCost(2);
        igaram.setPower(3000);
        igaram.setCounter(1000);
        igaram.setAffiliations("Alabasta Kingdom");
        igaram.setAttribute("Ranged");
        igaram.setEffect("[Main] You may rest this character and give your active leader -5000 Power for the turn: Look at the top 5 cards of your deck, reveal one {Alabasta Kingdom} type card and add it to your hand. Then, place the rest on the bottom of your deck in any order.");
        igaram.setImagePath("/images/cards/OP04/OP04-002.png");
        cardRepository.save(igaram);

        Card usoppOP04 = new Card();
        usoppOP04.setCardNumber("OP04-003");
        usoppOP04.setName("Usopp");
        usoppOP04.setCardType("Character");
        usoppOP04.setColor("Red");
        usoppOP04.setCost(4);
        usoppOP04.setPower(5000);
        usoppOP04.setCounter(1000);
        usoppOP04.setAffiliations("Alabasta Kingdom / Straw Hat Crew");
        usoppOP04.setAttribute("Wisdom");
        usoppOP04.setEffect("[On K.O.] K.O. up to one of your opponent's Characters with an original power of 5000 or less.");
        usoppOP04.setImagePath("/images/cards/OP04/OP04-003.png");
        cardRepository.save(usoppOP04);

        Card karoo = new Card();
        karoo.setCardNumber("OP04-004");
        karoo.setName("Karoo");
        karoo.setCardType("Character");
        karoo.setColor("Red");
        karoo.setCost(1);
        karoo.setPower(2000);
        karoo.setCounter(1000);
        karoo.setAffiliations("Animal / Alabasta Kingdom");
        karoo.setAttribute("Strike");
        karoo.setEffect("[Activate: Main] You may rest this character: Give up to 1 rested DON!! card to each of your {Alabasta} type Characters.");
        karoo.setImagePath("/images/cards/OP04/OP04-004.png");
        cardRepository.save(karoo);

        Card kungFuDugong = new Card();
        kungFuDugong.setCardNumber("OP04-005");
        kungFuDugong.setName("Kung-Fu Dugong");
        kungFuDugong.setCardType("Character");
        kungFuDugong.setColor("Red");
        kungFuDugong.setCost(1);
        kungFuDugong.setPower(1000);
        kungFuDugong.setCounter(1000);
        kungFuDugong.setAffiliations("Animal / Alabasta Kingdom");
        kungFuDugong.setAttribute("Strike");
        kungFuDugong.setEffect("If you have a [Kung-Fu Dugong] in play other than this Character, this Character gains [Blocker]");
        kungFuDugong.setImagePath("/images/cards/OP04/OP04-005.png");
        cardRepository.save(kungFuDugong);

        Card koza = new Card();
        koza.setCardNumber("OP04-006");
        koza.setName("Koza");
        koza.setCardType("Character");
        koza.setColor("Red");
        koza.setCost(3);
        koza.setPower(3000);
        koza.setCounter(2000);
        koza.setAffiliations("Alabasta Kingdom");
        koza.setAttribute("Slash");
        koza.setEffect("[When Attacking] You may give one of your active Leaders -5000 power this turn: This character has +2000 power until your next start of turn.");
        koza.setImagePath("/images/cards/OP04/OP04-006.png");
        cardRepository.save(koza);

        Card sanjiOP04 = new Card();
        sanjiOP04.setCardNumber("OP04-007");
        sanjiOP04.setName("Sanji");
        sanjiOP04.setCardType("Character");
        sanjiOP04.setColor("Red");
        sanjiOP04.setCost(1);
        sanjiOP04.setPower(3000);
        sanjiOP04.setCounter(1000);
        sanjiOP04.setAffiliations("Alabasta Kingdom / Straw Hat Crew");
        sanjiOP04.setAttribute("Strike");
        // No effect text visible on this common card
        sanjiOP04.setImagePath("/images/cards/OP04/OP04-007.png");
        cardRepository.save(sanjiOP04);

        Card chaka = new Card();
        chaka.setCardNumber("OP04-008");
        chaka.setName("Chaka");
        chaka.setCardType("Character");
        chaka.setColor("Red");
        chaka.setCost(3);
        chaka.setPower(5000);
        // No counter value
        chaka.setAffiliations("Alabasta Kingdom");
        chaka.setAttribute("Slash");
        chaka.setEffect("[DON!!x1] [When Attacking] If your leader is \"Nefertari Vivi\", give up to 1 of your opponent's characters -3000 Power for the turn. Then, K.O. up to 1 of your opponent's characters with 0 Power or less.");
        chaka.setImagePath("/images/cards/OP04/OP04-008.png");
        cardRepository.save(chaka);

        Card superSpotBilledDuckSquad = new Card();
        superSpotBilledDuckSquad.setCardNumber("OP04-009");
        superSpotBilledDuckSquad.setName("Super Spot-Billed Duck Squad");
        superSpotBilledDuckSquad.setCardType("Character");
        superSpotBilledDuckSquad.setColor("Red");
        superSpotBilledDuckSquad.setCost(2);
        superSpotBilledDuckSquad.setPower(3000);
        superSpotBilledDuckSquad.setCounter(2000);
        superSpotBilledDuckSquad.setAffiliations("Animal / Alabasta Kingdom");
        superSpotBilledDuckSquad.setAttribute("Strike");
        superSpotBilledDuckSquad.setEffect("[When Attacking] Give up to 1 of your active leaders -5000 during this turn: Return this card to your hand at the end of your turn.");
        superSpotBilledDuckSquad.setImagePath("/images/cards/OP04/OP04-009.png");
        cardRepository.save(superSpotBilledDuckSquad);

        Card tonyTonyChopperOP04 = new Card();
        tonyTonyChopperOP04.setCardNumber("OP04-010");
        tonyTonyChopperOP04.setName("Tony Tony.Chopper");
        tonyTonyChopperOP04.setCardType("Character");
        tonyTonyChopperOP04.setColor("Red");
        tonyTonyChopperOP04.setCost(3);
        tonyTonyChopperOP04.setPower(4000);
        tonyTonyChopperOP04.setCounter(1000);
        tonyTonyChopperOP04.setAffiliations("Animal/Alabasta/Straw Hat Crew");
        tonyTonyChopperOP04.setAttribute("Strike");
        tonyTonyChopperOP04.setEffect("[On Play] Play up to 1 {Animal} type Character card with 3000 power or less from your hand.");
        tonyTonyChopperOP04.setImagePath("/images/cards/OP04/OP04-010.png");
        cardRepository.save(tonyTonyChopperOP04);

        Card namiOP04 = new Card();
        namiOP04.setCardNumber("OP04-011");
        namiOP04.setName("Nami");
        namiOP04.setCardType("Character");
        namiOP04.setColor("Red");
        namiOP04.setCost(2);
        namiOP04.setPower(3000);
        namiOP04.setCounter(1000);
        namiOP04.setAffiliations("Alabasta Kingdom / Straw Hat Pirates");
        namiOP04.setAttribute("Wisdom");
        namiOP04.setEffect("[When Attacking] Reveal 1 card from the top of your deck. If that card was a Character card with 6000 power or more, this Character gains +3000 power during this turn. Then, put the revealed card at the bottom of the deck.");
        namiOP04.setImagePath("/images/cards/OP04/OP04-011.png");
        cardRepository.save(namiOP04);

        Card nefertariCobra = new Card();
        nefertariCobra.setCardNumber("OP04-012");
        nefertariCobra.setName("Nefertari Cobra");
        nefertariCobra.setCardType("Character");
        nefertariCobra.setColor("Red");
        nefertariCobra.setCost(2);
        nefertariCobra.setPower(0);
        nefertariCobra.setCounter(1000);
        nefertariCobra.setAffiliations("Alabasta Kingdom");
        nefertariCobra.setAttribute("Wisdom");
        nefertariCobra.setEffect("[Your Turn] All of your {Alabasta} type Characters other than this Character gain +1000 power.");
        nefertariCobra.setImagePath("/images/cards/OP04/OP04-012.png");
        cardRepository.save(nefertariCobra);

        Card pell = new Card();
        pell.setCardNumber("OP04-013");
        pell.setName("Pell");
        pell.setCardType("Character");
        pell.setColor("Red");
        pell.setCost(5);
        pell.setPower(6000);
        // No counter value
        pell.setAffiliations("Alabasta Kingdom");
        pell.setAttribute("Slash");
        pell.setEffect("[DON!!x1] [When Attacking] K.O. up to 1 of your opponent's Characters with 4000 or less power.");
        pell.setImagePath("/images/cards/OP04/OP04-013.png");
        cardRepository.save(pell);

        Card monkeyDLuffyOP04 = new Card();
        monkeyDLuffyOP04.setCardNumber("OP04-014");
        monkeyDLuffyOP04.setName("Monkey D. Luffy");
        monkeyDLuffyOP04.setCardType("Character");
        monkeyDLuffyOP04.setColor("Red");
        monkeyDLuffyOP04.setCost(8);
        monkeyDLuffyOP04.setPower(9000);
        // No counter value
        monkeyDLuffyOP04.setAffiliations("Alabasta Kingdom / Straw Hat Pirates");
        monkeyDLuffyOP04.setAttribute("Strike");
        monkeyDLuffyOP04.setEffect("[Banish] (When a character deals damage, the target card is trashed without activating its Trigger.)");
        monkeyDLuffyOP04.setImagePath("/images/cards/OP04/OP04-014.png");
        cardRepository.save(monkeyDLuffyOP04);

        Card roronoaZoroOP04 = new Card();
        roronoaZoroOP04.setCardNumber("OP04-015");
        roronoaZoroOP04.setName("Roronoa Zoro");
        roronoaZoroOP04.setCardType("Character");
        roronoaZoroOP04.setColor("Red");
        roronoaZoroOP04.setCost(5);
        roronoaZoroOP04.setPower(6000);
        roronoaZoroOP04.setCounter(1000);
        roronoaZoroOP04.setAffiliations("Alabasta Kingdom / Straw Hat Crew");
        roronoaZoroOP04.setAttribute("Slash");
        roronoaZoroOP04.setEffect("[On Play] Give up to 1 of your opponent's Characters -2000 power during this turn.");
        roronoaZoroOP04.setImagePath("/images/cards/OP04/OP04-015.png");
        cardRepository.save(roronoaZoroOP04);

        // Events
        Card badMannersKickCourse = new Card();
        badMannersKickCourse.setCardNumber("OP04-016");
        badMannersKickCourse.setName("Bad Manners Kick Course");
        badMannersKickCourse.setCardType("Event");
        badMannersKickCourse.setColor("Red");
        badMannersKickCourse.setCost(0);
        badMannersKickCourse.setAffiliations("Alabasta Kingdom / Straw Hat Crew");
        badMannersKickCourse.setEffect("[Counter] You may trash 1 card from your hand: Give up to 1 of your leaders or characters +3000 Power this battle.\n[Trigger] Give up to one of your opponent's leaders or characters -3000 Power for this turn.");
        badMannersKickCourse.setImagePath("/images/cards/OP04/OP04-016.png");
        cardRepository.save(badMannersKickCourse);

        Card happinessPunch = new Card();
        happinessPunch.setCardNumber("OP04-017");
        happinessPunch.setName("Happiness Punch");
        happinessPunch.setCardType("Event");
        happinessPunch.setColor("Red");
        happinessPunch.setCost(1);
        happinessPunch.setAffiliations("Alabasta Kingdom / Straw Hat Crew");
        happinessPunch.setEffect("[Counter] Give up to 1 one of opponent's leaders or characters -2000 Power for the turn. Then, if your leader is active, give up to 1 of your opponent's leaders or characters -1000 Power for the turn.");
        happinessPunch.setImagePath("/images/cards/OP04/OP04-017.png");
        cardRepository.save(happinessPunch);

        Card captivatingDizzinessDance = new Card();
        captivatingDizzinessDance.setCardNumber("OP04-018");
        captivatingDizzinessDance.setName("Captivating Dizziness Dance");
        captivatingDizzinessDance.setCardType("Event");
        captivatingDizzinessDance.setColor("Red");
        captivatingDizzinessDance.setCost(3);
        captivatingDizzinessDance.setAffiliations("Alabasta Kingdom");
        captivatingDizzinessDance.setEffect("[Main] If your Leader has the {Alabasta} type, give up to 2 of your opponent's Characters -2000 power during this turn.\n[Trigger] Activate this card's [Main] effect.");
        captivatingDizzinessDance.setImagePath("/images/cards/OP04/OP04-018.png");
        cardRepository.save(captivatingDizzinessDance);
        
        System.out.println("Finished initializing OP04 Red cards");
    }
    
    private void initializeOP04GreenCards() {
        System.out.println("Initializing OP04 Green cards...");

        // Leaders
        Card donquixoteDoflamingoLeader = new Card();
        donquixoteDoflamingoLeader.setCardNumber("OP04-019");
        donquixoteDoflamingoLeader.setName("Donquixote Doflamingo");
        donquixoteDoflamingoLeader.setCardType("Leader");
        donquixoteDoflamingoLeader.setColor("Green");
        donquixoteDoflamingoLeader.setPower(5000);
        donquixoteDoflamingoLeader.setLife(4);
        donquixoteDoflamingoLeader.setAffiliations("The Seven Warlords of the Sea / Donquixote Pirates");
        donquixoteDoflamingoLeader.setAttribute("Special");
        donquixoteDoflamingoLeader.setEffect("[End of Your Turn] Set up to 2 of your DON!! cards as active.");
        donquixoteDoflamingoLeader.setImagePath("/images/cards/OP04/OP04-019.png");
        cardRepository.save(donquixoteDoflamingoLeader);

        Card isshoLeader = new Card();
        isshoLeader.setCardNumber("OP04-020");
        isshoLeader.setName("Issho");
        isshoLeader.setCardType("Leader");
        isshoLeader.setColor("Green");
        isshoLeader.setPower(5000);
        isshoLeader.setLife(4);
        isshoLeader.setAffiliations("Navy");
        isshoLeader.setAttribute("Special");
        isshoLeader.setEffect("[DON!!x1] [Your Turn] All of your opponent's Characters get -1 to their cost. [End of Turn] ① (You may rest the specified number of DON!! cards in your Cost Area) Set up to 1 of your Characters With a Cost of 5 or less as active.");
        isshoLeader.setImagePath("/images/cards/OP04/OP04-020.png");
        cardRepository.save(isshoLeader);

        // Characters
        Card viola = new Card();
        viola.setCardNumber("OP04-021");
        viola.setName("Viola");
        viola.setCardType("Character");
        viola.setColor("Green");
        viola.setCost(3);
        viola.setPower(3000);
        viola.setCounter(2000);
        viola.setAffiliations("Donquixote Pirates");
        viola.setAttribute("Special");
        viola.setEffect("[When opponent attack] ② (You may rest the specified number of DON!! cards in your Cost Area) Rest up to 1 of your opponent's DON!!.");
        viola.setImagePath("/images/cards/OP04/OP04-021.png");
        cardRepository.save(viola);

        Card eric = new Card();
        eric.setCardNumber("OP04-022");
        eric.setName("Eric");
        eric.setCardType("Character");
        eric.setColor("Green");
        eric.setCost(1);
        eric.setPower(2000);
        eric.setCounter(1000);
        eric.setAffiliations("East Blue");
        eric.setAttribute("Slash");
        eric.setEffect("[Activate: Main] You may rest this character: Rest up to 1 of your opponent's cost 1 or less characters.");
        eric.setImagePath("/images/cards/OP04/OP04-022.png");
        cardRepository.save(eric);

        Card kuroOP04 = new Card();
        kuroOP04.setCardNumber("OP04-023");
        kuroOP04.setName("Kuro");
        kuroOP04.setCardType("Character");
        kuroOP04.setColor("Green");
        kuroOP04.setCost(6);
        kuroOP04.setPower(8000);
        kuroOP04.setCounter(1000);
        kuroOP04.setAffiliations("East Blue / Black Cat Pirates");
        kuroOP04.setAttribute("Slash");
        // Common card, no specific effect listed in image
        kuroOP04.setImagePath("/images/cards/OP04/OP04-023.png");
        cardRepository.save(kuroOP04);

        Card sugar = new Card();
        sugar.setCardNumber("OP04-024");
        sugar.setName("Sugar");
        sugar.setCardType("Character");
        sugar.setColor("Green");
        sugar.setCost(2);
        sugar.setPower(0);
        sugar.setCounter(1000);
        sugar.setAffiliations("Donquixote Pirates");
        sugar.setAttribute("Special");
        sugar.setEffect("[Opponent's Turn] [Once Per Turn] When your opponent plays a character card, if your leader is of the Donquixote Pirates, rest up to 1 of your opponent's Characters, then rest this card. [On Play] Rest up to 1 of your opponent's Characters With a cost of 4 or less.");
        sugar.setImagePath("/images/cards/OP04/OP04-024.png");
        cardRepository.save(sugar);

        Card giolla = new Card();
        giolla.setCardNumber("OP04-025");
        giolla.setName("Giolla");
        giolla.setCardType("Character");
        giolla.setColor("Green");
        giolla.setCost(4);
        giolla.setPower(4000);
        giolla.setCounter(1000);
        giolla.setAffiliations("Donquixote Pirates");
        giolla.setAttribute("Special");
        giolla.setEffect("[opponent attack] ② (You may rest the specified number of DON!! cards in your Cost Area) : Rest up to 1 of your opponent's cost 4 or lower characters.");
        giolla.setImagePath("/images/cards/OP04/OP04-025.png");
        cardRepository.save(giolla);

        Card senorPink = new Card();
        senorPink.setCardNumber("OP04-026");
        senorPink.setName("Senor Pink");
        senorPink.setCardType("Character");
        senorPink.setColor("Green");
        senorPink.setCost(3);
        senorPink.setPower(5000);
        // No Counter
        senorPink.setAffiliations("Donquixote Pirates");
        senorPink.setAttribute("Special");
        senorPink.setEffect("[When Attacking] ① (You may rest the specified number of DON!! cards in your Cost Area) : If your Leader has the {Donquixote Pirates} type, rest up to 1 of your opponent's Characters with a cost of 4 or less. Then, set up to 1 of your DON!! cards as active at the end of this turn.");
        senorPink.setImagePath("/images/cards/OP04/OP04-026.png");
        cardRepository.save(senorPink);

        Card daddyMasterson = new Card();
        daddyMasterson.setCardNumber("OP04-027");
        daddyMasterson.setName("Daddy Masterson");
        daddyMasterson.setCardType("Character");
        daddyMasterson.setColor("Green");
        daddyMasterson.setCost(4);
        daddyMasterson.setPower(5000);
        // No Counter
        daddyMasterson.setAffiliations("East Blue / Former Navy");
        daddyMasterson.setAttribute("Ranged");
        daddyMasterson.setEffect("[DON!!x1] [End of Your Turn] Set this Character as active.");
        daddyMasterson.setImagePath("/images/cards/OP04/OP04-027.png");
        cardRepository.save(daddyMasterson);

        Card diamante = new Card();
        diamante.setCardNumber("OP04-028");
        diamante.setName("Diamante");
        diamante.setCardType("Character");
        diamante.setColor("Green");
        diamante.setCost(5);
        diamante.setPower(6000);
        diamante.setCounter(1000);
        diamante.setAffiliations("Donquixote Pirates");
        diamante.setAttribute("Slash");
        diamante.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) [DON!!x1] [End of Turn] If you have 2 or more active DON!!, set this character as active.");
        diamante.setImagePath("/images/cards/OP04/OP04-028.png");
        cardRepository.save(diamante);

        Card dellinger = new Card();
        dellinger.setCardNumber("OP04-029");
        dellinger.setName("Dellinger");
        dellinger.setCardType("Character");
        dellinger.setColor("Green");
        dellinger.setCost(3);
        dellinger.setPower(4000);
        dellinger.setCounter(1000);
        dellinger.setAffiliations("Donquixote Pirates");
        dellinger.setAttribute("Strike");
        dellinger.setEffect("[End of Your Turn] Set up to 1 of your DON!! as active.");
        dellinger.setImagePath("/images/cards/OP04/OP04-029.png");
        cardRepository.save(dellinger);

        Card trebol = new Card();
        trebol.setCardNumber("OP04-030");
        trebol.setName("Trebol");
        trebol.setCardType("Character");
        trebol.setColor("Green");
        trebol.setCost(6);
        trebol.setPower(6000);
        // No Counter
        trebol.setAffiliations("Donquixote Pirates");
        trebol.setAttribute("Special");
        trebol.setEffect("[On Play] K.O. up to 1 of your opponent's rested Characters with a cost of 5 or less. [When Opponent Attacks] ② (You may rest the specified number of DON!! cards in your Cost Area) Set up to 1 of your opponent's Characters with a cost of 4 or less as rested.");
        trebol.setImagePath("/images/cards/OP04/OP04-030.png");
        cardRepository.save(trebol);

        Card donquixoteDoflamingoChar = new Card();
        donquixoteDoflamingoChar.setCardNumber("OP04-031");
        donquixoteDoflamingoChar.setName("Donquixote Doflamingo");
        donquixoteDoflamingoChar.setCardType("Character");
        donquixoteDoflamingoChar.setColor("Green");
        donquixoteDoflamingoChar.setCost(10);
        donquixoteDoflamingoChar.setPower(10000);
        // No Counter
        donquixoteDoflamingoChar.setAffiliations("Seven Warlords of the Sea / Donquixote Pirates");
        donquixoteDoflamingoChar.setAttribute("Special");
        donquixoteDoflamingoChar.setEffect("[On Play] A total of up to 3 of your opponent's rested Characters or Leaders do not become active during your opponent's next refresh phase");
        donquixoteDoflamingoChar.setImagePath("/images/cards/OP04/OP04-031.png");
        cardRepository.save(donquixoteDoflamingoChar);

        Card baby5 = new Card();
        baby5.setCardNumber("OP04-032");
        baby5.setName("Baby 5");
        baby5.setCardType("Character");
        baby5.setColor("Green");
        baby5.setCost(1);
        baby5.setPower(1000);
        baby5.setCounter(2000);
        baby5.setAffiliations("Donquixote Pirates");
        baby5.setAttribute("Special");
        baby5.setEffect("[End of Your Turn] You may trash this character: Set up to 2 of your DON!! as active.");
        baby5.setImagePath("/images/cards/OP04/OP04-032.png");
        cardRepository.save(baby5);

        Card machvise = new Card();
        machvise.setCardNumber("OP04-033");
        machvise.setName("Machvise");
        machvise.setCardType("Character");
        machvise.setColor("Green");
        machvise.setCost(4);
        machvise.setPower(5000);
        machvise.setCounter(1000);
        machvise.setAffiliations("Donquixote Pirates");
        machvise.setAttribute("Strike");
        machvise.setEffect("[On Play] If your leader is the {Donquixote Pirates} type, rest up to one of your opponent's 5 cost or lower characters. Then, at the end of the turn, set up to 1 of your DON!! as active.");
        machvise.setImagePath("/images/cards/OP04/OP04-033.png");
        cardRepository.save(machvise);

        Card laoG = new Card();
        laoG.setCardNumber("OP04-034");
        laoG.setName("Lao G");
        laoG.setCardType("Character");
        laoG.setColor("Green");
        laoG.setCost(4);
        laoG.setPower(5000);
        laoG.setCounter(1000);
        laoG.setAffiliations("Donquixote Pirates");
        laoG.setAttribute("Strike");
        laoG.setEffect("[End of Your Turn] If you have 3 or more active DON!!, K.O. up to 1 of your opponent's rested characters of 3 or less.");
        laoG.setImagePath("/images/cards/OP04/OP04-034.png");
        cardRepository.save(laoG);

        // Events
        Card spidersWeb = new Card();
        spidersWeb.setCardNumber("OP04-035");
        spidersWeb.setName("Spider's Web");
        spidersWeb.setCardType("Event");
        spidersWeb.setColor("Green");
        spidersWeb.setCost(2);
        spidersWeb.setAffiliations("The Seven Warlords of the Sea / Donquixote Pirates");
        spidersWeb.setEffect("[Counter] Up to 1 of your leaders or characters gains +4000 Power for this battle. Then, set up to 1 of your characters as active. [Trigger] Up to 1 of your leaders gains +2000 Power for the turn.");
        spidersWeb.setImagePath("/images/cards/OP04/OP04-035.png");
        cardRepository.save(spidersWeb);

        Card donquixoteFamily = new Card();
        donquixoteFamily.setCardNumber("OP04-036");
        donquixoteFamily.setName("Donquixote Family");
        donquixoteFamily.setCardType("Event");
        donquixoteFamily.setColor("Green");
        donquixoteFamily.setCost(1);
        donquixoteFamily.setAffiliations("Donquixote Pirates");
        donquixoteFamily.setEffect("[Counter] Look at 5 cards from the top of your deck; reveal up to 1 {Donquixote Pirates} type card and add it to your hand. Then, place the rest at the bottom of your deck in any order. [Trigger] Activate this card's [Counter] effect.");
        donquixoteFamily.setImagePath("/images/cards/OP04/OP04-036.png");
        cardRepository.save(donquixoteFamily);

        Card flapThread = new Card();
        flapThread.setCardNumber("OP04-037");
        flapThread.setName("Flap Thread");
        flapThread.setCardType("Event");
        flapThread.setColor("Green");
        flapThread.setCost(2);
        flapThread.setAffiliations("The Seven Warlords of the Sea / Donquixote Pirates");
        flapThread.setEffect("[Counter] If your leader is the {Donquixote Pirates} type, up to 1 of your leaders or characters gains +2000 Power this turn. [Trigger] K.O. up to 1 of your opponent's rested 4 cost or lower characters.");
        flapThread.setImagePath("/images/cards/OP04/OP04-037.png");
        cardRepository.save(flapThread);

        Card weaklingsCantChoose = new Card();
        weaklingsCantChoose.setCardNumber("OP04-038");
        weaklingsCantChoose.setName("Weaklings Can't Choose the Way They Die");
        weaklingsCantChoose.setCardType("Event");
        weaklingsCantChoose.setColor("Green");
        weaklingsCantChoose.setCost(5);
        weaklingsCantChoose.setAffiliations("The Seven Warlords of the Sea / Donquixote Pirates");
        weaklingsCantChoose.setEffect("[Main] / [Counter] Rest up to 1 of your opponent's leaders or characters. then, K.O. up to 1 of your opponent's rested 6 cost or lower characters. [Trigger] Set up to 5 of your DON!! as active.");
        weaklingsCantChoose.setImagePath("/images/cards/OP04/OP04-038.png");
        cardRepository.save(weaklingsCantChoose);

        System.out.println("Finished initializing OP04 Green cards");
    }
    
    private void initializeOP04BlueCards() {
        System.out.println("Initializing OP04 Blue cards...");
        
        // Leaders
        Card rebeccaLeader = new Card();
        rebeccaLeader.setCardNumber("OP04-039");
        rebeccaLeader.setName("Rebecca");
        rebeccaLeader.setCardType("Leader");
        rebeccaLeader.setColor("Black/Blue"); // Dual Color
        rebeccaLeader.setPower(5000);
        rebeccaLeader.setLife(5);
        rebeccaLeader.setAffiliations("Dressrosa");
        rebeccaLeader.setAttribute("Slash");
        rebeccaLeader.setEffect("This Leader cannot attack.\\nActivate: Main Once Per Turn ① (You may rest the specified number of DON!! cards in your Cost Area): If you have 6 or less cards in your hand, look at 2 cards from the top of your deck; reveal up to 1 {Dressrosa} type card and add it to your hand. Then, trash the rest.");
        rebeccaLeader.setImagePath("/images/cards/OP04/OP04-039.png");
        cardRepository.save(rebeccaLeader);
        
        Card queenLeader = new Card();
        queenLeader.setCardNumber("OP04-040");
        queenLeader.setName("Queen");
        queenLeader.setCardType("Leader");
        queenLeader.setColor("Blue/Yellow"); // Dual Color
        queenLeader.setPower(5000);
        queenLeader.setLife(4);
        queenLeader.setAffiliations("Animal Kingdom Pirates");
        queenLeader.setAttribute("Ranged");
        queenLeader.setEffect("DON!!x1 [When Attacking] If your hand and life total is 4 or less, draw one card. If you have a cost 8 or higher character, you may place up to 1 card from the top of your deck on top of your Life instead of drawing 1 card or drawing 1 card.");
        queenLeader.setImagePath("/images/cards/OP04/OP04-040.png");
        cardRepository.save(queenLeader);

        // Characters
        Card apis = new Card();
        apis.setCardNumber("OP04-041");
        apis.setName("Apis");
        apis.setCardType("Character");
        apis.setColor("Blue");
        apis.setCost(1);
        apis.setPower(0);
        apis.setCounter(2000);
        apis.setAffiliations("East Blue");
        apis.setAttribute("Wisdom");
        apis.setEffect("[On Play] You may trash 2 cards in your hand: Look at the top 5 cards of your deck, reveal up to 1 card with the \"East Blue\" type and add it to your hand. Place the remaining cards at the bottom of your deck in any order.");
        apis.setImagePath("/images/cards/OP04/OP04-041.png");
        cardRepository.save(apis);
        
        Card ipponmatsu = new Card();
        ipponmatsu.setCardNumber("OP04-042");
        ipponmatsu.setName("Ipponmatsu");
        ipponmatsu.setCardType("Character");
        ipponmatsu.setColor("Blue");
        ipponmatsu.setCost(2);
        ipponmatsu.setPower(1000);
        ipponmatsu.setCounter(1000);
        ipponmatsu.setAffiliations("East Blue");
        ipponmatsu.setAttribute("Wisdom");
        ipponmatsu.setEffect("[On Play] Up to 1 of your characters with the {Slash} attribute gain +3000 Power this turn. Then, trash 1 card from the top of your deck.");
        ipponmatsu.setImagePath("/images/cards/OP04/OP04-042.png");
        cardRepository.save(ipponmatsu);

        Card ulti = new Card();
        ulti.setCardNumber("OP04-043");
        ulti.setName("Ulti");
        ulti.setCardType("Character");
        ulti.setColor("Blue");
        ulti.setCost(3);
        ulti.setPower(4000);
        ulti.setCounter(1000);
        ulti.setAffiliations("Animal Kingdom Pirates");
        ulti.setAttribute("Strike");
        ulti.setEffect("[DON!!x1] [When Attacking] Return up to 1 cost 2 or lower character to it's owner's hand or bottom of the deck.");
        ulti.setImagePath("/images/cards/OP04/OP04-043.png");
        cardRepository.save(ulti);

        Card kaidoOP04 = new Card();
        kaidoOP04.setCardNumber("OP04-044");
        kaidoOP04.setName("Kaido");
        kaidoOP04.setCardType("Character");
        kaidoOP04.setColor("Blue");
        kaidoOP04.setCost(10);
        kaidoOP04.setPower(12000);
        // No counter value
        kaidoOP04.setAffiliations("Animal Kingdom Pirates / Four Emperors");
        kaidoOP04.setAttribute("Strike");
        kaidoOP04.setEffect("[On Play] Return up to 1 Character that costs 8 or less and up to 1 Character that costs 3 or less to the owners' hand.");
        kaidoOP04.setImagePath("/images/cards/OP04/OP04-044.png");
        cardRepository.save(kaidoOP04);

        Card kingOP04 = new Card();
        kingOP04.setCardNumber("OP04-045");
        kingOP04.setName("King");
        kingOP04.setCardType("Character");
        kingOP04.setColor("Blue");
        kingOP04.setCost(7);
        kingOP04.setPower(8000);
        kingOP04.setCounter(1000);
        kingOP04.setAffiliations("Animal Kingdom Pirates");
        kingOP04.setAttribute("Slash");
        kingOP04.setEffect("[On Play] Draw 1 card.");
        kingOP04.setImagePath("/images/cards/OP04/OP04-045.png");
        cardRepository.save(kingOP04);

        Card queenChar = new Card();
        queenChar.setCardNumber("OP04-046");
        queenChar.setName("Queen");
        queenChar.setCardType("Character");
        queenChar.setColor("Blue");
        queenChar.setCost(4);
        queenChar.setPower(5000);
        queenChar.setCounter(1000);
        queenChar.setAffiliations("Animal Kingdom Pirates");
        queenChar.setAttribute("Strike");
        queenChar.setEffect("[On Play] If your Leader has the {Animal Kingdom Pirates} type, look at up to 7 cards from the top of your deck; reveal up to 2 total [Plague Rounds] or [Ice Oni] and add them to your hand. Then, place the rest at the bottom of your deck in any order.");
        queenChar.setImagePath("/images/cards/OP04/OP04-046.png");
        cardRepository.save(queenChar);

        Card iceOni = new Card();
        iceOni.setCardNumber("OP04-047");
        iceOni.setName("Ice Oni");
        iceOni.setCardType("Character");
        iceOni.setColor("Blue");
        iceOni.setCost(8);
        iceOni.setPower(0);
        iceOni.setCounter(1000);
        iceOni.setAffiliations("Plague / Animal Kingdom Pirates");
        iceOni.setAttribute("Special");
        iceOni.setEffect("[Your Turn] At the end of battle between this character and an opponent's 5 cost or lower character, place the opponent's character at the bottom of the owner's deck.");
        iceOni.setImagePath("/images/cards/OP04/OP04-047.png");
        cardRepository.save(iceOni);

        Card sasaki = new Card();
        sasaki.setCardNumber("OP04-048");
        sasaki.setName("Sasaki");
        sasaki.setCardType("Character");
        sasaki.setColor("Blue");
        sasaki.setCost(3);
        sasaki.setPower(4000);
        sasaki.setCounter(2000);
        sasaki.setAffiliations("Animal Kingdom Pirates");
        sasaki.setAttribute("Strike");
        sasaki.setEffect("[On Play] Return all cards in your hand to your deck, and shuffle your deck. Then, draw cards equal to the number of cards returned to the deck.");
        sasaki.setImagePath("/images/cards/OP04/OP04-048.png");
        cardRepository.save(sasaki);

        Card jackOP04 = new Card();
        jackOP04.setCardNumber("OP04-049");
        jackOP04.setName("Jack");
        jackOP04.setCardType("Character");
        jackOP04.setColor("Blue");
        jackOP04.setCost(2);
        jackOP04.setPower(3000);
        jackOP04.setCounter(1000);
        jackOP04.setAffiliations("Animal Kingdom Pirates");
        jackOP04.setAttribute("Strike");
        jackOP04.setEffect("[On K.O.] Draw 1 card.");
        jackOP04.setImagePath("/images/cards/OP04/OP04-049.png");
        cardRepository.save(jackOP04);

        Card mrHanger = new Card();
        mrHanger.setCardNumber("OP04-050");
        mrHanger.setName("Mr. Hanger");
        mrHanger.setCardType("Character");
        mrHanger.setColor("Blue");
        mrHanger.setCost(2);
        mrHanger.setPower(0);
        mrHanger.setCounter(1000);
        mrHanger.setAffiliations("East Blue");
        mrHanger.setAttribute("Wisdom");
        mrHanger.setEffect("[Activate: Main] You may trash 1 card from your hand and rest this character: Draw 1 card.");
        mrHanger.setImagePath("/images/cards/OP04/OP04-050.png");
        cardRepository.save(mrHanger);

        Card whosWho = new Card();
        whosWho.setCardNumber("OP04-051");
        whosWho.setName("Who's Who");
        whosWho.setCardType("Character");
        whosWho.setColor("Blue");
        whosWho.setCost(1);
        whosWho.setPower(2000);
        whosWho.setCounter(1000);
        whosWho.setAffiliations("Animal Kingdom Pirates");
        whosWho.setAttribute("Slash");
        whosWho.setEffect("[On Play] Look at the top 5 cards of your deck, reveal up to 1 {Animal Kingdom Pirates} type card other than [Who's Who] and add it to your hand. Place the remaining cards at the bottom of your deck in any order.");
        whosWho.setImagePath("/images/cards/OP04/OP04-051.png");
        cardRepository.save(whosWho);

        Card blackMaria = new Card();
        blackMaria.setCardNumber("OP04-052");
        blackMaria.setName("Black Maria");
        blackMaria.setCardType("Character");
        blackMaria.setColor("Blue");
        blackMaria.setCost(3);
        blackMaria.setPower(3000);
        blackMaria.setCounter(1000);
        blackMaria.setAffiliations("Animal Kingdom Pirates");
        blackMaria.setAttribute("Special");
        blackMaria.setEffect("[Activate: Main] ② (You may rest the specified number of DON!! cards in your Cost Area) and you may rest this Character: Draw 1 card.\\n[Trigger] Play this card.");
        blackMaria.setImagePath("/images/cards/OP04/OP04-052.png");
        cardRepository.save(blackMaria);

        Card pageOne = new Card();
        pageOne.setCardNumber("OP04-053");
        pageOne.setName("Page One");
        pageOne.setCardType("Character");
        pageOne.setColor("Blue");
        pageOne.setCost(4);
        pageOne.setPower(6000);
        // No counter value
        pageOne.setAffiliations("Animal Kingdom Pirates");
        pageOne.setAttribute("Strike");
        pageOne.setEffect("[DON!!x1] [Once Per Turn] When one of your events activate, draw 1 card. Then, place 1 card on bottom of your deck from your hand.");
        pageOne.setImagePath("/images/cards/OP04/OP04-053.png");
        cardRepository.save(pageOne);

        Card rokki = new Card();
        rokki.setCardNumber("OP04-054");
        rokki.setName("Rokki");
        rokki.setCardType("Character");
        rokki.setColor("Blue");
        rokki.setCost(5);
        rokki.setPower(7000);
        rokki.setCounter(1000);
        rokki.setAffiliations("Giant / Animal Kingdom Pirates");
        rokki.setAttribute("Strike");
        // No Effect
        rokki.setImagePath("/images/cards/OP04/OP04-054.png");
        cardRepository.save(rokki);

        // Events
        Card plagueShot = new Card();
        plagueShot.setCardNumber("OP04-055");
        plagueShot.setName("Plague Shot");
        plagueShot.setCardType("Event");
        plagueShot.setColor("Blue");
        plagueShot.setCost(2);
        plagueShot.setAffiliations("Animal Kingdom Pirates");
        plagueShot.setEffect("[Main] You may trash 1 \"Ice Oni\" card from your hand and place 1 character of 4 cost or lower on the bottom of the owner's deck: Play 1 \"Ice Oni\" card from your trash.\\n[Trigger] Activate this card's [Main] effect.");
        plagueShot.setImagePath("/images/cards/OP04/OP04-055.png");
        cardRepository.save(plagueShot);

        Card gumGumRedRoc = new Card();
        gumGumRedRoc.setCardNumber("OP04-056");
        gumGumRedRoc.setName("Gum-Gum Red Roc");
        gumGumRedRoc.setCardType("Event");
        gumGumRedRoc.setColor("Blue");
        gumGumRedRoc.setCost(6);
        gumGumRedRoc.setAffiliations("Straw Hat Crew");
        gumGumRedRoc.setEffect("[Main] Place up to 1 Character at the bottom of its owner's deck.\\n[Trigger] Place up to 1 Character with a cost of 4 or less at the bottom of its owner's deck.");
        gumGumRedRoc.setImagePath("/images/cards/OP04/OP04-056.png");
        cardRepository.save(gumGumRedRoc);

        Card dragonTwisterDemolishingWind = new Card();
        dragonTwisterDemolishingWind.setCardNumber("OP04-057");
        dragonTwisterDemolishingWind.setName("Dragon Twister Demolishing Wind");
        dragonTwisterDemolishingWind.setCardType("Event");
        dragonTwisterDemolishingWind.setColor("Blue");
        dragonTwisterDemolishingWind.setCost(2);
        dragonTwisterDemolishingWind.setAffiliations("Four Emperors / Animal Kingdom Pirates");
        dragonTwisterDemolishingWind.setEffect("[Counter] Give up to 1 of your leaders or characters +4000 Power this battle. Then, place up to 1 cost 1 or lower character on the bottom of its owner's deck.\\n[Trigger] Return up to 1 cost 6 or less character to its owner's hand.");
        dragonTwisterDemolishingWind.setImagePath("/images/cards/OP04/OP04-057.png");
        cardRepository.save(dragonTwisterDemolishingWind);

        System.out.println("Finished initializing OP04 Blue cards");
    }
    
    private void initializeOP04PurpleCards() {
        System.out.println("Initializing OP04 Purple cards...");
        
        // Leaders
        Card crocodileLeaderOP04 = new Card();
        crocodileLeaderOP04.setCardNumber("OP04-058");
        crocodileLeaderOP04.setName("Crocodile");
        crocodileLeaderOP04.setCardType("Leader");
        crocodileLeaderOP04.setColor("Purple/Yellow");
        crocodileLeaderOP04.setPower(5000);
        crocodileLeaderOP04.setLife(4);
        crocodileLeaderOP04.setAffiliations("Seven Warlords of the Sea/ Baroque Works");
        crocodileLeaderOP04.setAttribute("Special");
        crocodileLeaderOP04.setEffect("Opponent's Turn Once Per Turn When you return DON!! from your field to the DON!! deck through one of your effects, add 1 DON!! from your DON!! deck as active.");
        crocodileLeaderOP04.setImagePath("/images/cards/OP04/OP04-058.png");
        cardRepository.save(crocodileLeaderOP04);

        // Characters
        Card iceburgOP04 = new Card();
        iceburgOP04.setCardNumber("OP04-059");
        iceburgOP04.setName("Iceburg");
        iceburgOP04.setCardType("Character");
        iceburgOP04.setColor("Purple");
        iceburgOP04.setCost(1);
        iceburgOP04.setPower(0);
        iceburgOP04.setCounter(1000);
        iceburgOP04.setAffiliations("Water Seven/Galley-La Company");
        iceburgOP04.setAttribute("Wisdom");
        iceburgOP04.setEffect("Opponent attack DON!!-1: If your leader is {Water 7} type, this character gains [Blocker] for the turn.\\n(After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        iceburgOP04.setImagePath("/images/cards/OP04/OP04-059.png");
        cardRepository.save(iceburgOP04);

        Card crocodileCharOP04 = new Card();
        crocodileCharOP04.setCardNumber("OP04-060");
        crocodileCharOP04.setName("Crocodile");
        crocodileCharOP04.setCardType("Character");
        crocodileCharOP04.setColor("Purple");
        crocodileCharOP04.setCost(8);
        crocodileCharOP04.setPower(9000);
        // No counter value
        crocodileCharOP04.setAffiliations("The Seven Warlords of the Sea / Baroque Works");
        crocodileCharOP04.setAttribute("Special");
        crocodileCharOP04.setEffect("[On Play] DON!!-2 If your Leader's type includes {Baroque Works}, place up to 1 card from the top of your deck on top of your Life.\\\\n[When opponent attack] [Once Per Turn] DON!!-1 Draw 1 Card and Trash 1 Card From Your Hand.");
        crocodileCharOP04.setImagePath("/images/cards/OP04/OP04-060.png");
        cardRepository.save(crocodileCharOP04);

        Card tom = new Card();
        tom.setCardNumber("OP04-061");
        tom.setName("Tom");
        tom.setCardType("Character");
        tom.setColor("Purple");
        tom.setCost(3);
        tom.setPower(4000);
        tom.setCounter(1000);
        tom.setAffiliations("Fish-Man / Water 7");
        tom.setAttribute("Wisdom");
        tom.setEffect("[Activate: Main] You may trash this character: If your leader is {Water 7} type, add up to 1 DON!! from your DON!! deck and set it rested.");
        tom.setImagePath("/images/cards/OP04/OP04-061.png");
        cardRepository.save(tom);

        Card bananaCrocodile = new Card();
        bananaCrocodile.setCardNumber("OP04-062");
        bananaCrocodile.setName("Banana Crocodile");
        bananaCrocodile.setCardType("Character");
        bananaCrocodile.setColor("Purple");
        bananaCrocodile.setCost(5);
        bananaCrocodile.setPower(7000);
        bananaCrocodile.setCounter(1000);
        bananaCrocodile.setAffiliations("Animal");
        bananaCrocodile.setAttribute("Strike");
        // No Effect
        bananaCrocodile.setImagePath("/images/cards/OP04/OP04-062.png");
        cardRepository.save(bananaCrocodile);

        Card frankyOP04 = new Card();
        frankyOP04.setCardNumber("OP04-063");
        frankyOP04.setName("Franky");
        frankyOP04.setCardType("Character");
        frankyOP04.setColor("Purple");
        frankyOP04.setCost(1);
        frankyOP04.setPower(1000);
        frankyOP04.setCounter(2000);
        frankyOP04.setAffiliations("Water 7 / Franky Family");
        frankyOP04.setAttribute("Wisdom");
        frankyOP04.setEffect("[When opponent attack] [Once Per Turn] DON!! -1: If your Leader has the {Water 7} type, up to 1 of your Leader or Characters gains +1000 Power during this battle.");
        frankyOP04.setImagePath("/images/cards/OP04/OP04-063.png");
        cardRepository.save(frankyOP04);

        Card missAllSunday = new Card();
        missAllSunday.setCardNumber("OP04-064");
        missAllSunday.setName("Miss All Sunday");
        missAllSunday.setCardType("Character");
        missAllSunday.setColor("Purple");
        missAllSunday.setCost(5);
        missAllSunday.setPower(5000);
        // No Counter
        missAllSunday.setAffiliations("Baroque Works");
        missAllSunday.setAttribute("Wisdom");
        missAllSunday.setEffect("[On Play] Add up to 1 rested Don!! to your cost area and if you have 6 or more Don!! Draw 1 card.\\\\n[Trigger] Don!!-2: (You may return the specified number of DON!! cards from your field to your DON!! deck.): Play this card.");
        missAllSunday.setImagePath("/images/cards/OP04/OP04-064.png");
        cardRepository.save(missAllSunday);

        Card missGoldenWeek = new Card();
        missGoldenWeek.setCardNumber("OP04-065");
        missGoldenWeek.setName("Miss Golden Week (Marianne)");
        missGoldenWeek.setCardType("Character");
        missGoldenWeek.setColor("Purple");
        missGoldenWeek.setCost(2);
        missGoldenWeek.setPower(3000);
        missGoldenWeek.setCounter(1000);
        missGoldenWeek.setAffiliations("Baroque Works");
        missGoldenWeek.setAttribute("Wisdom");
        missGoldenWeek.setEffect("[On Play] If your Leader's type includes \\\"Baroque Works\\\", up to 1 of your opponent's Characters with a cost of 5 or less cannot attack until the start of your next turn.\\\\n[Trigger] DON!!-1 (You may return the specified number of DON!! cards from your field to your DON!! deck): Play this card.");
        missGoldenWeek.setImagePath("/images/cards/OP04/OP04-065.png");
        cardRepository.save(missGoldenWeek);

        Card missValentine = new Card();
        missValentine.setCardNumber("OP04-066");
        missValentine.setName("Miss Valentine (Mikita)");
        missValentine.setCardType("Character");
        missValentine.setColor("Purple");
        missValentine.setCost(2);
        missValentine.setPower(2000);
        missValentine.setCounter(1000);
        missValentine.setAffiliations("Baroque Works");
        missValentine.setAttribute("Strike");
        missValentine.setEffect("[On Play] Look at the top 5 cards of your deck, reveal 1 card with \\\"Baroque Works\\\" in one of its types and add it to your hand. Place the remaining cards at the bottom of your deck in any order.\\\\n[Trigger] DON!!-1 (You may return the specified number of DON!! cards from your field to your DON!! deck): Play this card.");
        missValentine.setImagePath("/images/cards/OP04/OP04-066.png");
        cardRepository.save(missValentine);

        Card missMerryChristmas = new Card();
        missMerryChristmas.setCardNumber("OP04-067");
        missMerryChristmas.setName("Miss Merry Christmas (Drophy)");
        missMerryChristmas.setCardType("Character");
        missMerryChristmas.setColor("Purple");
        missMerryChristmas.setCost(4);
        missMerryChristmas.setPower(4000);
        // No counter value
        missMerryChristmas.setAffiliations("Baroque Works");
        missMerryChristmas.setAttribute("Slash");
        missMerryChristmas.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\\\n[Trigger] DON!! -1 (You may return the specified number of DON!! cards from your field to your DON!! deck): Play this card.");
        missMerryChristmas.setImagePath("/images/cards/OP04/OP04-067.png");
        cardRepository.save(missMerryChristmas);

        Card yokozuna = new Card();
        yokozuna.setCardNumber("OP04-068");
        yokozuna.setName("Yokozuna");
        yokozuna.setCardType("Character");
        yokozuna.setColor("Purple");
        yokozuna.setCost(3);
        yokozuna.setPower(3000);
        yokozuna.setCounter(1000);
        yokozuna.setAffiliations("Animal / Water 7");
        yokozuna.setAttribute("Strike");
        yokozuna.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\\\n[When opponent attack] DON!!-1: Return up to 1 of your opponent's Characters with a cost of 2 or less to its owner's hand.");
        yokozuna.setImagePath("/images/cards/OP04/OP04-068.png");
        cardRepository.save(yokozuna);

        Card mr2BonClay = new Card();
        mr2BonClay.setCardNumber("OP04-069");
        mr2BonClay.setName("Mr.2 (Bon Clay)");
        mr2BonClay.setCardType("Character");
        mr2BonClay.setColor("Purple");
        mr2BonClay.setCost(3);
        mr2BonClay.setPower(4000);
        mr2BonClay.setCounter(1000);
        mr2BonClay.setAffiliations("Baroque Works");
        mr2BonClay.setAttribute("Strike");
        mr2BonClay.setEffect("[When opponent attack] DON!! -1: This character's original power becomes the attacking character or leader's power until the end of the turn.\\\\n[Trigger] DON!!-1: You may play this card");
        mr2BonClay.setImagePath("/images/cards/OP04/OP04-069.png");
        cardRepository.save(mr2BonClay);

        Card mr3Galdino = new Card();
        mr3Galdino.setCardNumber("OP04-070");
        mr3Galdino.setName("Mr.3 (Galdino)");
        mr3Galdino.setCardType("Character");
        mr3Galdino.setColor("Purple");
        mr3Galdino.setCost(3);
        mr3Galdino.setPower(4000);
        mr3Galdino.setCounter(1000);
        mr3Galdino.setAffiliations("Baroque Works");
        mr3Galdino.setAttribute("Special");
        mr3Galdino.setEffect("[Opponent attack] [Once Per Turn] DON!!-1: Give up to 1 of your opponent's characters -1000 Power for this turn.");
        mr3Galdino.setImagePath("/images/cards/OP04/OP04-070.png");
        cardRepository.save(mr3Galdino);

        Card mr4Babe = new Card();
        mr4Babe.setCardNumber("OP04-071");
        mr4Babe.setName("Mr.4(Babe)");
        mr4Babe.setCardType("Character");
        mr4Babe.setColor("Purple");
        mr4Babe.setCost(5);
        mr4Babe.setPower(6000);
        mr4Babe.setCounter(1000);
        mr4Babe.setAffiliations("Baroque Works");
        mr4Babe.setAttribute("Strike");
        mr4Babe.setEffect("[Opponent attack] DON!!-1: This character gains [Blocker] and +1000 Power for this battle.\\\\n(After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        mr4Babe.setImagePath("/images/cards/OP04/OP04-071.png");
        cardRepository.save(mr4Babe);

        Card mr5Gem = new Card();
        mr5Gem.setCardNumber("OP04-072");
        mr5Gem.setName("Mr. 5 (Gem)");
        mr5Gem.setCardType("Character");
        mr5Gem.setColor("Purple");
        mr5Gem.setCost(7);
        mr5Gem.setPower(8000);
        // No Counter Value
        mr5Gem.setAffiliations("Baroque Works");
        mr5Gem.setAttribute("Special");
        mr5Gem.setEffect("[On Opponent's Attack] [Once Per Turn] Don -2, You may rest this character: KO Up to one of your opponents Characters with a cost of 4 or less.");
        mr5Gem.setImagePath("/images/cards/OP04/OP04-072.png");
        cardRepository.save(mr5Gem);

        Card mr13MissFriday = new Card();
        mr13MissFriday.setCardNumber("OP04-073");
        mr13MissFriday.setName("Mr. 13 & Miss Friday");
        mr13MissFriday.setCardType("Character");
        mr13MissFriday.setColor("Purple");
        mr13MissFriday.setCost(3);
        mr13MissFriday.setPower(1000);
        mr13MissFriday.setCounter(2000);
        mr13MissFriday.setAffiliations("Animal/Baroque Works");
        mr13MissFriday.setAttribute("Wisdom");
        mr13MissFriday.setEffect("[Activate: Main] You may trash this Character and 1 of your Characters with a type including \\\"Baroque Works\\\": Add up to 1 DON!! card from your DON!! deck and set it as active.\\\\n[Trigger] Play this card.");
        mr13MissFriday.setImagePath("/images/cards/OP04/OP04-073.png");
        cardRepository.save(mr13MissFriday);

        // Events
        Card colorsTrap = new Card();
        colorsTrap.setCardNumber("OP04-074");
        colorsTrap.setName("Colors Trap");
        colorsTrap.setCardType("Event");
        colorsTrap.setColor("Purple");
        colorsTrap.setCost(1);
        colorsTrap.setAffiliations("Baroque Works");
        colorsTrap.setEffect("[Counter] DON!!-1: Give up to 1 of your leaders or characters +1000 Power for the battle. Then, rest up to 1 of your opponent's cost 4 or lower characters.\\\\n[Trigger] Add up to 1 DON!! card from your DON!! deck and set it as active.");
        colorsTrap.setImagePath("/images/cards/OP04/OP04-074.png");
        cardRepository.save(colorsTrap);

        Card noseFancyCannon = new Card();
        noseFancyCannon.setCardNumber("OP04-075");
        noseFancyCannon.setName("Nose Fancy Cannon");
        noseFancyCannon.setCardType("Event");
        noseFancyCannon.setColor("Purple");
        noseFancyCannon.setCost(3);
        noseFancyCannon.setAffiliations("Baroque Works");
        noseFancyCannon.setEffect("[Counter] Give up to 1 of your leaders or characters +6000 Power for this battle. Then, if your life is 2 or less, add up to 1 DON!! from your DON!! deck set as rested.\\\\n[Trigger] Add up to 1 DON!! from your DON!! deck set as active.");
        noseFancyCannon.setImagePath("/images/cards/OP04/OP04-075.png");
        cardRepository.save(noseFancyCannon);

        Card weaknessIsASinOP04 = new Card();
        weaknessIsASinOP04.setCardNumber("OP04-076");
        weaknessIsASinOP04.setName("Weakness is a Sin");
        weaknessIsASinOP04.setCardType("Event");
        weaknessIsASinOP04.setColor("Purple");
        weaknessIsASinOP04.setCost(1);
        weaknessIsASinOP04.setAffiliations("The Seven Warlords of the Sea/Baroque Works");
        weaknessIsASinOP04.setEffect("Counter DON!!-1: Up to one of your leaders or characters gains +1000 Power this turn.\\\\nTrigger Add up to 1 DON!! card from your DON!! deck and set it as active.");
        weaknessIsASinOP04.setImagePath("/images/cards/OP04/OP04-076.png"); // Now including the image path
        cardRepository.save(weaknessIsASinOP04);

        System.out.println("Finished initializing OP04 Purple cards");
    }
    
    private void initializeOP04BlackCards() {
        System.out.println("Initializing OP04 Black cards...");

        // Characters
        Card ideo = new Card();
        ideo.setCardNumber("OP04-077");
        ideo.setName("Ideo");
        ideo.setCardType("Character");
        ideo.setColor("Black");
        ideo.setCost(2);
        ideo.setPower(2000);
        ideo.setCounter(1000);
        ideo.setAffiliations("Dressrosa");
        ideo.setAttribute("Strike");
        ideo.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        ideo.setImagePath("/images/cards/OP04/OP04-077.png");
        cardRepository.save(ideo);

        Card oimoKashii = new Card();
        oimoKashii.setCardNumber("OP04-078");
        oimoKashii.setName("Oimo & Kashii");
        oimoKashii.setCardType("Character");
        oimoKashii.setColor("Black");
        oimoKashii.setCost(6);
        oimoKashii.setPower(8000);
        oimoKashii.setCounter(1000);
        oimoKashii.setAffiliations("Giant / World Government");
        oimoKashii.setAttribute("Strike");
        // No effect
        oimoKashii.setImagePath("/images/cards/OP04/OP04-078.png");
        cardRepository.save(oimoKashii);

        Card orlombus = new Card();
        orlombus.setCardNumber("OP04-079");
        orlombus.setName("Orlombus");
        orlombus.setCardType("Character");
        orlombus.setColor("Black");
        orlombus.setCost(4);
        orlombus.setPower(5000);
        orlombus.setCounter(1000);
        orlombus.setAffiliations("Dressrosa");
        orlombus.setAttribute("Strike");
        orlombus.setEffect("[Activate: Main] [Once Per Turn] Reduce the cost of up to 1 of your opponent's Characters by -4 during this turn, and trash the top 2 cards of your deck. Then, K.O. 1 of your \"Dressrosa\" type Characters.");
        orlombus.setImagePath("/images/cards/OP04/OP04-079.png");
        cardRepository.save(orlombus);

        Card gyats = new Card();
        gyats.setCardNumber("OP04-080");
        gyats.setName("Gyats");
        gyats.setCardType("Character");
        gyats.setColor("Black");
        gyats.setCost(1);
        gyats.setPower(1000);
        gyats.setCounter(2000);
        gyats.setAffiliations("Dressrosa");
        gyats.setAttribute("Wisdom");
        gyats.setEffect("[On Play] Up to 1 of your Characters with the {Dressrosa} type may attack your opponent's Characters in active during this turn.");
        gyats.setImagePath("/images/cards/OP04/OP04-080.png");
        cardRepository.save(gyats);

        Card cavendish = new Card();
        cavendish.setCardNumber("OP04-081");
        cavendish.setName("Cavendish");
        cavendish.setCardType("Character");
        cavendish.setColor("Black");
        cavendish.setCost(5);
        cavendish.setPower(6000);
        // No Counter
        cavendish.setAffiliations("Dressrosa / Beautiful Pirates");
        cavendish.setAttribute("Slash");
        cavendish.setEffect("[DON!!x1] This Character can attack active Characters.\\n[When Attacking] You may rest your leader: K.O. up to one of your opponent's Characters that cost 1 or less. Then, trash two cards from the top of your deck.");
        cavendish.setImagePath("/images/cards/OP04/OP04-081.png");
        cardRepository.save(cavendish);

        Card kyros = new Card();
        kyros.setCardNumber("OP04-082");
        kyros.setName("Kyros");
        kyros.setCardType("Character");
        kyros.setColor("Black");
        kyros.setCost(3);
        kyros.setPower(5000);
        // No Counter
        kyros.setAffiliations("Dressrosa");
        kyros.setAttribute("Slash");
        kyros.setEffect("If this Character would be K.O.ed, you may instead rest 1 of your Leaders or [Corrida Colosseum].\\n[On Play] If your Leader is [Rebecca], K.O. up to 1 of your opponent's Characters with a cost of 1 or less. Then, trash 1 card from the top of your deck.");
        kyros.setImagePath("/images/cards/OP04/OP04-082.png");
        cardRepository.save(kyros);

        Card sabo = new Card();
        sabo.setCardNumber("OP04-083");
        sabo.setName("Sabo");
        sabo.setCardType("Character");
        sabo.setColor("Black");
        sabo.setCost(5);
        sabo.setPower(6000);
        sabo.setCounter(1000);
        sabo.setAffiliations("Dressrosa/Revolutionary Army");
        sabo.setAttribute("Special");
        sabo.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[On Play] Your characters can't be KOd by card effects until the start of your next turn. Draw 2 trash 2.");
        sabo.setImagePath("/images/cards/OP04/OP04-083.png");
        cardRepository.save(sabo);

        Card stussy = new Card();
        stussy.setCardNumber("OP04-084");
        stussy.setName("Stussy");
        stussy.setCardType("Character");
        stussy.setColor("Black");
        stussy.setCost(2);
        stussy.setPower(3000);
        // No Counter
        stussy.setAffiliations("CP0");
        stussy.setAttribute("Slash");
        stussy.setEffect("[On Play] Look at the top 3 cards of your deck, play up to one 2 cost or lower character that contains the {CP} type other than \"Stussy\". Then, trash the rest.");
        stussy.setImagePath("/images/cards/OP04/OP04-084.png");
        cardRepository.save(stussy);

        Card suleiman = new Card();
        suleiman.setCardNumber("OP04-085");
        suleiman.setName("Suleiman");
        suleiman.setCardType("Character");
        suleiman.setColor("Black");
        suleiman.setCost(3);
        suleiman.setPower(4000);
        suleiman.setCounter(1000);
        suleiman.setAffiliations("Dressrosa");
        suleiman.setAttribute("Slash");
        suleiman.setEffect("[On Play] / [When Attacking] If your leader is {Dressrosa} type, give -2 cost to up to one of your opponent's characters. Then, place 1 card from the top of your deck in the trash.");
        suleiman.setImagePath("/images/cards/OP04/OP04-085.png");
        cardRepository.save(suleiman);

        Card chinjao = new Card();
        chinjao.setCardNumber("OP04-086");
        chinjao.setName("Chinjao");
        chinjao.setCardType("Character");
        chinjao.setColor("Black");
        chinjao.setCost(5);
        chinjao.setPower(6000);
        chinjao.setCounter(1000);
        chinjao.setAffiliations("Dressrosa / Happo Navy");
        chinjao.setAttribute("Strike");
        chinjao.setEffect("[DON!!x1] When the opponent's character battling this one is K.O.'d, draw 2 cards and trash 2 cards from your hand.");
        chinjao.setImagePath("/images/cards/OP04/OP04-086.png");
        cardRepository.save(chinjao);

        Card trafalgarLawOP04 = new Card();
        trafalgarLawOP04.setCardNumber("OP04-087");
        trafalgarLawOP04.setName("Trafalgar Law");
        trafalgarLawOP04.setCardType("Character");
        trafalgarLawOP04.setColor("Black");
        trafalgarLawOP04.setCost(5);
        trafalgarLawOP04.setPower(7000);
        trafalgarLawOP04.setCounter(1000);
        trafalgarLawOP04.setAffiliations("Dressrosa / Heart Pirates");
        trafalgarLawOP04.setAttribute("Slash");
        // No effect
        trafalgarLawOP04.setImagePath("/images/cards/OP04/OP04-087.png");
        cardRepository.save(trafalgarLawOP04);

        Card hajrudin = new Card();
        hajrudin.setCardNumber("OP04-088");
        hajrudin.setName("Hajrudin");
        hajrudin.setCardType("Character");
        hajrudin.setColor("Black");
        hajrudin.setCost(6);
        hajrudin.setPower(7000);
        hajrudin.setCounter(1000);
        hajrudin.setAffiliations("Giant / Dressrosa / New Giant Pirates");
        hajrudin.setAttribute("Strike");
        hajrudin.setEffect("[Activate: Main] You may rest 1 of your Leaders: Reduce the cost of up to 1 of your opponent's Characters by -4 during this turn.");
        hajrudin.setImagePath("/images/cards/OP04/OP04-088.png");
        cardRepository.save(hajrudin);

        Card bartolomeo = new Card();
        bartolomeo.setCardNumber("OP04-089");
        bartolomeo.setName("Bartolomeo");
        bartolomeo.setCardType("Character");
        bartolomeo.setColor("Black");
        bartolomeo.setCost(3);
        bartolomeo.setPower(3000);
        bartolomeo.setCounter(2000);
        bartolomeo.setAffiliations("Dressrosa / Barto Club");
        bartolomeo.setAttribute("Special");
        bartolomeo.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        bartolomeo.setImagePath("/images/cards/OP04/OP04-089.png");
        cardRepository.save(bartolomeo);

        Card monkeyDLuffyOP04Black = new Card();
        monkeyDLuffyOP04Black.setCardNumber("OP04-090");
        monkeyDLuffyOP04Black.setName("Monkey D. Luffy");
        monkeyDLuffyOP04Black.setCardType("Character");
        monkeyDLuffyOP04Black.setColor("Black");
        monkeyDLuffyOP04Black.setCost(7);
        monkeyDLuffyOP04Black.setPower(7000);
        // No counter value
        monkeyDLuffyOP04Black.setAffiliations("Dressrosa / Straw Hat Crew");
        monkeyDLuffyOP04Black.setAttribute("Strike");
        monkeyDLuffyOP04Black.setEffect("This Character can attack active Characters.\\n[Activate: Main] [Once Per Turn] You may return 7 cards from your trash to the bottom of your deck in any order: Set this Character to active. Then, during your next Refresh Phase, this Character cannot be set to active.");
        monkeyDLuffyOP04Black.setImagePath("/images/cards/OP04/OP04-090.png");
        cardRepository.save(monkeyDLuffyOP04Black);

        Card leo = new Card();
        leo.setCardNumber("OP04-091");
        leo.setName("Leo");
        leo.setCardType("Character");
        leo.setColor("Black");
        leo.setCost(1);
        leo.setPower(2000);
        leo.setCounter(1000);
        leo.setAffiliations("Tontatta / Dressrosa");
        leo.setAttribute("Strike");
        leo.setEffect("[On Play] You may rest 1 of your Leader: If your Leader has the {Dressrosa} type, KO up to 1 of your opponents Cost 1 or lower Characters. Then, trash 2 cards from the top of your deck.");
        leo.setImagePath("/images/cards/OP04/OP04-091.png");
        cardRepository.save(leo);

        Card rebecca = new Card();
        rebecca.setCardNumber("OP04-092");
        rebecca.setName("Rebecca");
        rebecca.setCardType("Character");
        rebecca.setColor("Black");
        rebecca.setCost(1);
        rebecca.setPower(2000);
        rebecca.setCounter(1000);
        rebecca.setAffiliations("Dressrosa");
        rebecca.setAttribute("Slash");
        rebecca.setEffect("[On Play] Look at the top 3 cards of your deck, reveal 1 {Dressrosa} type card other than [Rebecca] and add it to your hand. Then trash the remaining cards.");
        rebecca.setImagePath("/images/cards/OP04/OP04-092.png");
        cardRepository.save(rebecca);

        // Events
        Card gumGumKingKongGun = new Card();
        gumGumKingKongGun.setCardNumber("OP04-093");
        gumGumKingKongGun.setName("Gum-Gum King Kong Gun");
        gumGumKingKongGun.setCardType("Event");
        gumGumKingKongGun.setColor("Black");
        gumGumKingKongGun.setCost(3);
        gumGumKingKongGun.setAffiliations("Dressrosa/Straw Hat Crew");
        gumGumKingKongGun.setEffect("[Main] Choose one {Dressrosa} type character, power +6000\\nAfter, if your trash has 15 or more cards, this character gains [Double Attack] for the turn.\\n(This card deals 2 damage.)\\n[Trigger] Draw 3 cards and trash 2 cards.");
        gumGumKingKongGun.setImagePath("/images/cards/OP04/OP04-093.png");
        cardRepository.save(gumGumKingKongGun);

        Card destructiveSwordOfThunder = new Card();
        destructiveSwordOfThunder.setCardNumber("OP04-094");
        destructiveSwordOfThunder.setName("Destructive Sword of Thunder");
        destructiveSwordOfThunder.setCardType("Event");
        destructiveSwordOfThunder.setColor("Black");
        destructiveSwordOfThunder.setCost(4);
        destructiveSwordOfThunder.setAffiliations("Dressrosa");
        destructiveSwordOfThunder.setEffect("[Main] Choose up to one of your opponent's cost 4 or lower characters and K.O. that character. If your trash has at least 15 cards, choose a 6 cost or lower character instead.\\n[Trigger] You may rest your leader: K.O. up to one of your opponent's cost 5 or lower characters.");
        destructiveSwordOfThunder.setImagePath("/images/cards/OP04/OP04-094.png");
        cardRepository.save(destructiveSwordOfThunder);

        Card baaaaarrier = new Card();
        baaaaarrier.setCardNumber("OP04-095");
        baaaaarrier.setName("Baaaaarrier!!");
        baaaaarrier.setCardType("Event");
        baaaaarrier.setColor("Black");
        baaaaarrier.setCost(1);
        baaaaarrier.setAffiliations("Dressrosa / Bart Club");
        baaaaarrier.setEffect("[Counter] Up to one of your leaders or characters gains +2000 Power for this battle. If your trash has at least 15 cards, gain another +2000 Power.\\n[Trigger] Draw 2, trash 1.");
        baaaaarrier.setImagePath("/images/cards/OP04/OP04-095.png");
        cardRepository.save(baaaaarrier);

        // Stages
        Card corridaColosseum = new Card();
        corridaColosseum.setCardNumber("OP04-096");
        corridaColosseum.setName("Corrida Colosseum");
        corridaColosseum.setCardType("Stage");
        corridaColosseum.setColor("Black");
        corridaColosseum.setCost(1);
        corridaColosseum.setAffiliations("Dressrosa");
        corridaColosseum.setEffect("If your Leader has the {Dressrosa} type, your Characters that have the {Dressrosa} type can attack Characters on the turn they are played.");
        corridaColosseum.setImagePath("/images/cards/OP04/OP04-096.png");
        cardRepository.save(corridaColosseum);
        
        System.out.println("Finished initializing OP04 Black cards");
    }
    
    private void initializeOP04YellowCards() {
        System.out.println("Initializing OP04 Yellow cards...");

        // Characters
        Card otama = new Card();
        otama.setCardNumber("OP04-097");
        otama.setName("Otama");
        otama.setCardType("Character");
        otama.setColor("Yellow");
        otama.setCost(1);
        otama.setPower(0);
        otama.setCounter(1000);
        otama.setAffiliations("Land of Wano");
        otama.setAttribute("Wisdom");
        otama.setEffect("[On Play] Place up to 1 of your opponent's {Animal} or {SMILE} type characters on top of their life area face-up.");
        otama.setImagePath("/images/cards/OP04/OP04-097.png");
        cardRepository.save(otama);

        Card toko = new Card();
        toko.setCardNumber("OP04-098");
        toko.setName("Toko");
        toko.setCardType("Character");
        toko.setColor("Yellow");
        toko.setCost(2);
        toko.setPower(0);
        toko.setCounter(1000);
        toko.setAffiliations("Wano Country");
        toko.setAttribute("Wisdom");
        toko.setEffect("[On Play] You may trash 2 cards with the {Wano Country} type from your hand: If your life is 1 or less, add 1 card from the top of your deck to the top of your life.");
        toko.setImagePath("/images/cards/OP04/OP04-098.png");
        cardRepository.save(toko);

        Card oLin = new Card();
        oLin.setCardNumber("OP04-099");
        oLin.setName("O-Lin");
        oLin.setCardType("Character");
        oLin.setColor("Yellow");
        oLin.setCost(7);
        oLin.setPower(7000);
        // No Counter
        oLin.setAffiliations("Land of Wano/Four Emperors/Big Mom Pirates");
        oLin.setAttribute("Special");
        oLin.setEffect("Also treat this card's name as [Charlotte Linlin] according to the rules.\\n[Trigger] if you have 1 or less cards in your Life Area: You may play this card.");
        oLin.setImagePath("/images/cards/OP04/OP04-099.png");
        cardRepository.save(oLin);

        Card caponeBege = new Card();
        caponeBege.setCardNumber("OP04-100");
        caponeBege.setName("Capone Bege");
        caponeBege.setCardType("Character");
        caponeBege.setColor("Yellow");
        caponeBege.setCost(3);
        caponeBege.setPower(3000);
        caponeBege.setCounter(2000);
        caponeBege.setAffiliations("Fire Tank Pirates");
        caponeBege.setAttribute("Ranged");
        caponeBege.setEffect("[Trigger] Up to 1 of your opponent's leaders or Characters cannot attack during this turn.");
        caponeBege.setImagePath("/images/cards/OP04/OP04-100.png");
        cardRepository.save(caponeBege);

        Card carmel = new Card();
        carmel.setCardNumber("OP04-101");
        carmel.setName("Carmel");
        carmel.setCardType("Character");
        carmel.setColor("Yellow");
        carmel.setCost(2);
        carmel.setPower(1000);
        carmel.setCounter(1000);
        carmel.setAffiliations("Sheep's House");
        carmel.setAttribute("Wisdom");
        carmel.setEffect("[Your Turn] [On Play] Draw 1 card.\\n[Trigger] Play this card. Then, K.O. up to 1 opponent's 2 cost or less character.");
        carmel.setImagePath("/images/cards/OP04/OP04-101.png");
        cardRepository.save(carmel);

        Card kinemon = new Card();
        kinemon.setCardNumber("OP04-102");
        kinemon.setName("Kin'emon");
        kinemon.setCardType("Character");
        kinemon.setColor("Yellow");
        kinemon.setCost(6);
        kinemon.setPower(6000);
        // No Counter
        kinemon.setAffiliations("Wano Country");
        kinemon.setAttribute("Slash");
        kinemon.setEffect("[Activate: Main] [Once Per Turn] ① (You may rest the specified number of DON!! cards in your Cost Area) You may add one card from the top or bottom of your life to your hand: This card becomes active.");
        kinemon.setImagePath("/images/cards/OP04/OP04-102.png");
        cardRepository.save(kinemon);

        Card kozukiHiyori = new Card();
        kozukiHiyori.setCardNumber("OP04-103");
        kozukiHiyori.setName("Kozuki Hiyori");
        kozukiHiyori.setCardType("Character");
        kozukiHiyori.setColor("Yellow");
        kozukiHiyori.setCost(2);
        kozukiHiyori.setPower(0);
        kozukiHiyori.setCounter(2000);
        kozukiHiyori.setAffiliations("Wano Country / Kozuki Family");
        kozukiHiyori.setAttribute("Wisdom");
        kozukiHiyori.setEffect("[On Play] Give up to 1 of your leaders or characters with the {Wano Country} type +1000 Power for this turn.\\n[Trigger] Play this card.");
        kozukiHiyori.setImagePath("/images/cards/OP04/OP04-103.png");
        cardRepository.save(kozukiHiyori);

        Card sanjiOP04Yellow = new Card();
        sanjiOP04Yellow.setCardNumber("OP04-104");
        sanjiOP04Yellow.setName("Sanji");
        sanjiOP04Yellow.setCardType("Character");
        sanjiOP04Yellow.setColor("Yellow");
        sanjiOP04Yellow.setCost(4);
        sanjiOP04Yellow.setPower(5000);
        sanjiOP04Yellow.setCounter(1000);
        sanjiOP04Yellow.setAffiliations("Vinsmoke Family");
        sanjiOP04Yellow.setAttribute("Strike");
        sanjiOP04Yellow.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[Trigger] You may trash 1 card in your hand: Play this card.");
        sanjiOP04Yellow.setImagePath("/images/cards/OP04/OP04-104.png");
        cardRepository.save(sanjiOP04Yellow);

        Card charlotteAmande = new Card();
        charlotteAmande.setCardNumber("OP04-105");
        charlotteAmande.setName("Charlotte Amande");
        charlotteAmande.setCardType("Character");
        charlotteAmande.setColor("Yellow");
        charlotteAmande.setCost(3);
        charlotteAmande.setPower(3000);
        charlotteAmande.setCounter(2000);
        charlotteAmande.setAffiliations("Big Mom Pirates");
        charlotteAmande.setAttribute("Slash");
        charlotteAmande.setEffect("[Activate: Main] [Once Per Turn] You may trash 1 card with a Trigger from your hand: Rest up to 1 of your opponent's Characters with a cost of 2 or less.");
        charlotteAmande.setImagePath("/images/cards/OP04/OP04-105.png");
        cardRepository.save(charlotteAmande);

        Card charlotteBavarois = new Card();
        charlotteBavarois.setCardNumber("OP04-106");
        charlotteBavarois.setName("Charlotte Bavarois");
        charlotteBavarois.setCardType("Character");
        charlotteBavarois.setColor("Yellow");
        charlotteBavarois.setCost(3);
        charlotteBavarois.setPower(4000);
        charlotteBavarois.setCounter(1000);
        charlotteBavarois.setAffiliations("Big Mom Pirates");
        charlotteBavarois.setAttribute("Strike");
        charlotteBavarois.setEffect("[DON!!x1] If you have less Life cards than your opponent, this Character gains +1000 power.\\n[Trigger] You may discard 1 card from your hand: Play this card.");
        charlotteBavarois.setImagePath("/images/cards/OP04/OP04-106.png");
        cardRepository.save(charlotteBavarois);

        Card charlottePerospero = new Card();
        charlottePerospero.setCardNumber("OP04-107");
        charlottePerospero.setName("Charlotte Perospero");
        charlottePerospero.setCardType("Character");
        charlottePerospero.setColor("Yellow");
        charlottePerospero.setCost(6);
        charlottePerospero.setPower(8000);
        charlottePerospero.setCounter(1000);
        charlottePerospero.setAffiliations("Big Mom Pirates");
        charlottePerospero.setAttribute("Special");
        // No Effect
        charlottePerospero.setImagePath("/images/cards/OP04/OP04-107.png");
        cardRepository.save(charlottePerospero);

        Card charlotteMoscato = new Card();
        charlotteMoscato.setCardNumber("OP04-108");
        charlotteMoscato.setName("Charlotte Moscato");
        charlotteMoscato.setCardType("Character");
        charlotteMoscato.setColor("Yellow");
        charlotteMoscato.setCost(3);
        charlotteMoscato.setPower(4000);
        charlotteMoscato.setCounter(1000);
        charlotteMoscato.setAffiliations("Big Mom Pirates");
        charlotteMoscato.setAttribute("Slash");
        charlotteMoscato.setEffect("[DON!!x1] This character gains [Banish]. (When a character deals damage, the target card is trashed without activating its Trigger.)\\n[Trigger] You may trash one card from your hand: Play this card.");
        charlotteMoscato.setImagePath("/images/cards/OP04/OP04-108.png");
        cardRepository.save(charlotteMoscato);

        Card tonoyasu = new Card();
        tonoyasu.setCardNumber("OP04-109");
        tonoyasu.setName("Tonoyasu");
        tonoyasu.setCardType("Character");
        tonoyasu.setColor("Yellow");
        tonoyasu.setCost(2);
        tonoyasu.setPower(2000);
        tonoyasu.setCounter(1000);
        tonoyasu.setAffiliations("Wano Country");
        tonoyasu.setAttribute("Wisdom");
        tonoyasu.setEffect("[Activate: Main] You may trash this character: Up to one of your leaders or characters with the {Wano Country} type gain +3000 Power for this turn.");
        tonoyasu.setImagePath("/images/cards/OP04/OP04-109.png");
        cardRepository.save(tonoyasu);

        Card pound = new Card();
        pound.setCardNumber("OP04-110");
        pound.setName("Pound");
        pound.setCardType("Character");
        pound.setColor("Yellow");
        pound.setCost(3);
        pound.setPower(3000);
        pound.setCounter(1000);
        pound.setAffiliations("Whole Cake Island");
        pound.setAttribute("Wisdom");
        pound.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[On K.O.] Place up to 1 of your opponent's cost 3 or lower characters on the top or bottom of your opponent's life face-up.");
        pound.setImagePath("/images/cards/OP04/OP04-110.png");
        cardRepository.save(pound);

        Card hera = new Card();
        hera.setCardNumber("OP04-111");
        hera.setName("Hera");
        hera.setCardType("Character");
        hera.setColor("Yellow");
        hera.setCost(5);
        hera.setPower(3000);
        hera.setCounter(1000);
        hera.setAffiliations("Big Mom Pirates / Homies");
        hera.setAttribute("Special");
        hera.setEffect("[Activate: Main] You may trash 1 of your {Homies} type Characters other than this Character and rest this Character: Set up to 1 of your [Charlotte Linlin] Characters as active.\\n[Trigger] Play this card.");
        hera.setImagePath("/images/cards/OP04/OP04-111.png");
        cardRepository.save(hera);

        Card yamato = new Card();
        yamato.setCardNumber("OP04-112");
        yamato.setName("Yamato");
        yamato.setCardType("Character");
        yamato.setColor("Yellow");
        yamato.setCost(9);
        yamato.setPower(9000);
        // No Counter
        yamato.setAffiliations("Land of Wano");
        yamato.setAttribute("Strike");
        yamato.setEffect("[On Play] K.O. up to one of your opponent's characters with a cost that is equal to or less than the total life of you and your opponent. Then, if you have 1 or less life, you may add up to 1 card from the top of your deck to your life area.");
        yamato.setImagePath("/images/cards/OP04/OP04-112.png");
        cardRepository.save(yamato);

        Card rabian = new Card();
        rabian.setCardNumber("OP04-113");
        rabian.setName("Rabian");
        rabian.setCardType("Character");
        rabian.setColor("Yellow");
        rabian.setCost(2);
        rabian.setPower(3000);
        rabian.setCounter(1000);
        rabian.setAffiliations("Big Mom Pirates / Homies");
        rabian.setAttribute("Special");
        rabian.setEffect("[Trigger] Play this card.");
        rabian.setImagePath("/images/cards/OP04/OP04-113.png");
        cardRepository.save(rabian);

        Card randolph = new Card();
        randolph.setCardNumber("OP04-114");
        randolph.setName("Randolph");
        randolph.setCardType("Character");
        randolph.setColor("Yellow");
        randolph.setCost(5);
        randolph.setPower(7000);
        randolph.setCounter(1000);
        randolph.setAffiliations("Big Mom Pirates / Homies");
        randolph.setAttribute("Slash");
        // No Effect
        randolph.setImagePath("/images/cards/OP04/OP04-114.png");
        cardRepository.save(randolph);

        // Events
        Card gunModoki = new Card();
        gunModoki.setCardNumber("OP04-115");
        gunModoki.setName("Gun Modoki");
        gunModoki.setCardType("Event");
        gunModoki.setColor("Yellow");
        gunModoki.setCost(1);
        gunModoki.setAffiliations("Wano Country / Kozuki Family");
        gunModoki.setEffect("[Main] You may add 1 card from the top or bottom of your life to your hand: Up to 1 of your characters with the {Wano Country} type gain [Double Attack] for the turn.\\n[Trigger] Up to 1 of your leaders or characters gains +1000 for the turn.");
        gunModoki.setImagePath("/images/cards/OP04/OP04-115.png");
        cardRepository.save(gunModoki);

        Card diableJambeJoueShoot = new Card();
        diableJambeJoueShoot.setCardNumber("OP04-116");
        diableJambeJoueShoot.setName("Diable Jambe: Joue Shoot");
        diableJambeJoueShoot.setCardType("Event");
        diableJambeJoueShoot.setColor("Yellow");
        diableJambeJoueShoot.setCost(3);
        diableJambeJoueShoot.setAffiliations("Vinsmoke Family");
        diableJambeJoueShoot.setEffect("[Counter] Up to 1 of your leaders or characters gains +6000 Power for this battle. Then, if you and your opponent's total life is 4 or less, K.O. up to 1 opponent's character of 2 cost or lower.\\n[Trigger] Draw 1 card.");
        diableJambeJoueShoot.setImagePath("/images/cards/OP04/OP04-116.png");
        cardRepository.save(diableJambeJoueShoot);

        Card heavenlyFire = new Card();
        heavenlyFire.setCardNumber("OP04-117");
        heavenlyFire.setName("Heavenly Fire");
        heavenlyFire.setCardType("Event");
        heavenlyFire.setColor("Yellow");
        heavenlyFire.setCost(1);
        heavenlyFire.setAffiliations("Four Emperors / Big Mom Pirates");
        heavenlyFire.setEffect("[Main] Add up to 1 of your opponent's cost 3 or less characters to the top or bottom of your opponent's life face-up.\\n[Trigger] You may add 1 card to your hand from the top or bottom of your life: Place up to one card from your hand on top of your life.");
        heavenlyFire.setImagePath("/images/cards/OP04/OP04-117.png");
        cardRepository.save(heavenlyFire);

        // Secret Rares (Considered Yellow based on file placement, though dual color exists)
        // Note: Vivi Secret Rare is Red/Yellow, but placed here for simplicity of single color methods for now.
        Card nefertariViviSecret = new Card();
        nefertariViviSecret.setCardNumber("OP04-118");
        nefertariViviSecret.setName("Nefertari Vivi");
        nefertariViviSecret.setCardType("Character");
        nefertariViviSecret.setColor("Red/Yellow"); // Dual Color
        nefertariViviSecret.setCost(7);
        nefertariViviSecret.setPower(4000);
        nefertariViviSecret.setCounter(1000);
        nefertariViviSecret.setAffiliations("Alabasta Kingdom");
        nefertariViviSecret.setAttribute("Wisdom");
        nefertariViviSecret.setEffect("All of your red Characters with a cost of 3 or more other than this Character gain [Rush]. (This card can attack on the turn in which it is played.)");
        nefertariViviSecret.setImagePath("/images/cards/OP04/OP04-118.png");
        cardRepository.save(nefertariViviSecret);
        
        // Note: Rosinante Secret Rare is Green/Yellow, placed here for simplicity.
        Card donquixoteRosinanteSecret = new Card();
        donquixoteRosinanteSecret.setCardNumber("OP04-119");
        donquixoteRosinanteSecret.setName("Donquixote Rosinante");
        donquixoteRosinanteSecret.setCardType("Character");
        donquixoteRosinanteSecret.setColor("Green/Yellow"); // Dual Color
        donquixoteRosinanteSecret.setCost(8);
        donquixoteRosinanteSecret.setPower(8000);
        // No Counter
        donquixoteRosinanteSecret.setAffiliations("Navy/Donquixote Pirates");
        donquixoteRosinanteSecret.setAttribute("Special");
        donquixoteRosinanteSecret.setEffect("[Opponent's Turn] If this Character is rested, your active Characters with an original cost of 5 cannot be K.O.'d by effects.\\n[On Play] You may rest this Character: Play up to 1 green Character card with a cost of 5 from your hand.");
        donquixoteRosinanteSecret.setImagePath("/images/cards/OP04/OP04-119.png");
        cardRepository.save(donquixoteRosinanteSecret);

        System.out.println("Finished initializing OP04 Yellow cards");
    }
} 