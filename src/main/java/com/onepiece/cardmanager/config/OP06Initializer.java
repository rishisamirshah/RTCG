package com.onepiece.cardmanager.config;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(6)
public class OP06Initializer extends BaseInitializer {

    private final CardRepository cardRepository;

    @Autowired
    public OP06Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    protected void initialize(String... args) throws Exception {
        // Only initialize if we have no OP06 cards
        if (cardRepository.countBySetAndCardNumberStartingWith("OP06", "OP06") > 0) {
            System.out.println("OP06 cards already exist, skipping initialization");
            return;
        }

        System.out.println("Initializing OP06 cards...");
        
        // Initialize Red cards
        initializeOP06RedCards();

        // Initialize Green cards
        initializeOP06GreenCards();

        // Initialize Blue cards
        initializeOP06BlueCards();

        // Initialize Purple cards
        initializeOP06PurpleCards();

        // Initialize Black cards
        initializeOP06BlackCards();

        // Initialize Yellow cards (and Secret Rares)
        initializeOP06YellowCards();

        System.out.println("Finished initializing OP06 cards");
    }

    private void initializeOP06RedCards() {
        System.out.println("Initializing OP06 Red cards...");

        // Leaders
        Card utaLeader = new Card();
        utaLeader.setCardNumber("OP06-001");
        utaLeader.setName("Uta");
        utaLeader.setCardType("Leader");
        utaLeader.setColor("Red/Purple"); // Dual Color
        utaLeader.setPower(5000);
        utaLeader.setLife(4);
        utaLeader.setAffiliations("FILM");
        utaLeader.setAttribute("Special");
        utaLeader.setEffect("[When Attacking] You may trash 1 FILM type card from your hand: Give up to one of your opponents' characters -2000 power until the end of turn. Then, add up to 1 DON!! from your DON!! deck as rested.");
        utaLeader.setImagePath("/images/cards/OP06/OP06-001.png");
        cardRepository.save(utaLeader);

        // Characters
        Card inazumaRed = new Card();
        inazumaRed.setCardNumber("OP06-002");
        inazumaRed.setName("Inazuma");
        inazumaRed.setCardType("Character");
        inazumaRed.setColor("Red");
        inazumaRed.setCost(4);
        inazumaRed.setPower(5000);
        inazumaRed.setCounter(1000);
        inazumaRed.setAffiliations("Revolutionary Army");
        inazumaRed.setAttribute("Slash");
        inazumaRed.setEffect("When this Character has 7000 power or more, they gain [Banish].");
        inazumaRed.setImagePath("/images/cards/OP06/OP06-002.png");
        cardRepository.save(inazumaRed);

        Card emporioIvankovRed = new Card();
        emporioIvankovRed.setCardNumber("OP06-003");
        emporioIvankovRed.setName("Emporio Ivankov");
        emporioIvankovRed.setCardType("Character");
        emporioIvankovRed.setColor("Red");
        emporioIvankovRed.setCost(5);
        emporioIvankovRed.setPower(6000);
        // No Counter
        emporioIvankovRed.setAffiliations("Revolutionary Army");
        emporioIvankovRed.setAttribute("Special");
        emporioIvankovRed.setEffect("[On Play] Look at the top 3 cards of your deck. Play up to 1 {Revolutionary} type Character Card with power 5000 or less. Then, return the remaining cards to the bottom of your deck in any order.");
        emporioIvankovRed.setImagePath("/images/cards/OP06/OP06-003.png");
        cardRepository.save(emporioIvankovRed);

        Card baronOmatsuri = new Card();
        baronOmatsuri.setCardNumber("OP06-004");
        baronOmatsuri.setName("Baron Omatsuri");
        baronOmatsuri.setCardType("Character");
        baronOmatsuri.setColor("Red");
        baronOmatsuri.setCost(2);
        baronOmatsuri.setPower(3000);
        baronOmatsuri.setCounter(1000);
        baronOmatsuri.setAffiliations("FILM / Omatsuri Island");
        baronOmatsuri.setAttribute("Ranged");
        baronOmatsuri.setEffect("[On Play] Play up to one \"Lily Carnation\" from your hand.");
        baronOmatsuri.setImagePath("/images/cards/OP06/OP06-004.png");
        cardRepository.save(baronOmatsuri);

        Card gasparde = new Card();
        gasparde.setCardNumber("OP06-005");
        gasparde.setName("Gasparde");
        gasparde.setCardType("Character");
        gasparde.setColor("Red");
        gasparde.setCost(6);
        gasparde.setPower(8000);
        gasparde.setCounter(1000);
        gasparde.setAffiliations("FILM / Former Navy / Gasparde Pirates");
        gasparde.setAttribute("Special");
        // No Effect
        gasparde.setImagePath("/images/cards/OP06/OP06-005.png");
        cardRepository.save(gasparde);

        Card saga = new Card();
        saga.setCardNumber("OP06-006");
        saga.setName("Saga");
        saga.setCardType("Character");
        saga.setColor("Red");
        saga.setCost(4);
        saga.setPower(5000);
        saga.setCounter(2000);
        saga.setAffiliations("FILM / Asuka Island");
        saga.setAttribute("Slash");
        saga.setEffect("[DON!!x1] [When Attacking] This character gains +1000 until the start of your next turn. Then, at the end of this turn, trash one of your {Film} type characters.");
        saga.setImagePath("/images/cards/OP06/OP06-006.png");
        cardRepository.save(saga);

        Card shanks = new Card();
        shanks.setCardNumber("OP06-007");
        shanks.setName("Shanks");
        shanks.setCardType("Character");
        shanks.setColor("Red");
        shanks.setCost(10);
        shanks.setPower(12000);
        // No Counter
        shanks.setAffiliations("FILM / Four Emperors / Red Hair Pirates");
        shanks.setAttribute("Slash");
        shanks.setEffect("[On Play] K.O. up to 1 of your opponent's characters with 10000 power or less.");
        shanks.setImagePath("/images/cards/OP06/OP06-007.png");
        cardRepository.save(shanks);

        Card schneider = new Card();
        schneider.setCardNumber("OP06-008");
        schneider.setName("Schneider");
        schneider.setCardType("Character");
        schneider.setColor("Red");
        schneider.setCost(3);
        schneider.setPower(5000);
        schneider.setCounter(1000);
        schneider.setAffiliations("FILM / Straw Hat Chase");
        schneider.setAttribute("Wisdom");
        // No Effect
        schneider.setImagePath("/images/cards/OP06/OP06-008.png");
        cardRepository.save(schneider);

        Card shuraiya = new Card();
        shuraiya.setCardNumber("OP06-009");
        shuraiya.setName("Shuraiya");
        shuraiya.setCardType("Character");
        shuraiya.setColor("Red");
        shuraiya.setCost(3);
        shuraiya.setPower(4000);
        shuraiya.setCounter(1000);
        shuraiya.setAffiliations("FILM / Shipbuilding Town");
        shuraiya.setAttribute("Strike");
        shuraiya.setEffect("[Blocker]\\n[When Attacking] / [When Blocking] [Once Per Turn] This Character's base power becomes the same as the power of your opponent's Leader until the start of your next turn.");
        shuraiya.setImagePath("/images/cards/OP06/OP06-009.png");
        cardRepository.save(shuraiya);

        Card douglasBullet = new Card();
        douglasBullet.setCardNumber("OP06-010");
        douglasBullet.setName("Douglas Bullet");
        douglasBullet.setCardType("Character");
        douglasBullet.setColor("Red");
        douglasBullet.setCost(6);
        douglasBullet.setPower(7000);
        douglasBullet.setCounter(1000);
        douglasBullet.setAffiliations("FILM / The Pirates Fest");
        douglasBullet.setAttribute("Strike");
        douglasBullet.setEffect("If your leader has the type {FILM}, this Character gains [Blocker].");
        douglasBullet.setImagePath("/images/cards/OP06/OP06-010.png");
        cardRepository.save(douglasBullet);

        Card totMusica = new Card();
        totMusica.setCardNumber("OP06-011");
        totMusica.setName("Tot Musica");
        totMusica.setCardType("Character");
        totMusica.setColor("Red");
        totMusica.setCost(5);
        totMusica.setPower(6000);
        totMusica.setCounter(1000);
        totMusica.setAffiliations("FILM");
        totMusica.setAttribute("Special");
        totMusica.setEffect("[Activate: Main] [Once Per Turn] You may rest one of your {Uta}: This character gains +5000 Power for this turn.");
        totMusica.setImagePath("/images/cards/OP06/OP06-011.png");
        cardRepository.save(totMusica);

        Card bearking = new Card();
        bearking.setCardNumber("OP06-012");
        bearking.setName("Bearking");
        bearking.setCardType("Character");
        bearking.setColor("Red");
        bearking.setCost(5);
        bearking.setPower(6000);
        bearking.setCounter(1000);
        bearking.setAffiliations("FILM / Trump Pirates");
        bearking.setAttribute("Strike");
        bearking.setEffect("If your opponent has a leader or character with a base power of 6000 or higher, this character cannot be KO'd in battle.");
        bearking.setImagePath("/images/cards/OP06/OP06-012.png");
        cardRepository.save(bearking);

        Card monkeyDLuffyRed = new Card();
        monkeyDLuffyRed.setCardNumber("OP06-013");
        monkeyDLuffyRed.setName("Monkey D. Luffy");
        monkeyDLuffyRed.setCardType("Character");
        monkeyDLuffyRed.setColor("Red");
        monkeyDLuffyRed.setCost(2);
        monkeyDLuffyRed.setPower(3000);
        monkeyDLuffyRed.setCounter(1000);
        monkeyDLuffyRed.setAffiliations("FILM / Straw Hat Crew");
        monkeyDLuffyRed.setAttribute("Strike");
        monkeyDLuffyRed.setEffect("[On Play] Look at 3 cards from the top of your deck; reveal up to 1 {FILM} type card and add it to your hand. Then, place the rest at the bottom of your deck in any order.\\n[Trigger] Activate this character's [On Play] ability.");
        monkeyDLuffyRed.setImagePath("/images/cards/OP06/OP06-013.png");
        cardRepository.save(monkeyDLuffyRed);

        Card lilyCarnation = new Card();
        lilyCarnation.setCardNumber("OP06-015"); // Card number seems to skip OP06-014
        lilyCarnation.setName("Lily Carnation");
        lilyCarnation.setCardType("Character");
        lilyCarnation.setColor("Red");
        lilyCarnation.setCost(4);
        lilyCarnation.setPower(0);
        lilyCarnation.setCounter(1000);
        lilyCarnation.setAffiliations("FILM / Omatsuri Island");
        lilyCarnation.setAttribute("Special");
        lilyCarnation.setEffect("[Activate: Main] [Once Per Turn] You may trash one of your characters with 6000 power or more: Play up to 1 [FILM] type character card with a power between 2000 to 5000 from your trash, rested.");
        lilyCarnation.setImagePath("/images/cards/OP06/OP06-015.png");
        cardRepository.save(lilyCarnation);

        Card raiseMax = new Card();
        raiseMax.setCardNumber("OP06-016");
        raiseMax.setName("Raise Max");
        raiseMax.setCardType("Character");
        raiseMax.setColor("Red");
        raiseMax.setCost(1);
        raiseMax.setPower(2000);
        raiseMax.setCounter(1000);
        raiseMax.setAffiliations("FILM / Revolutionary Army");
        raiseMax.setAttribute("Wisdom");
        raiseMax.setEffect("[Activate: Main] You may place this Character at the bottom of the owner's deck: Give up to 1 of your opponent's Characters -3000 power during this turn.");
        raiseMax.setImagePath("/images/cards/OP06/OP06-016.png");
        cardRepository.save(raiseMax);

        // Events
        Card meteorStrikeOfLove = new Card();
        meteorStrikeOfLove.setCardNumber("OP06-017");
        meteorStrikeOfLove.setName("Meteor Strike of Love");
        meteorStrikeOfLove.setCardType("Event");
        meteorStrikeOfLove.setColor("Red");
        meteorStrikeOfLove.setCost(2);
        meteorStrikeOfLove.setAffiliations("FILM / Straw Hat Crew");
        meteorStrikeOfLove.setEffect("[Main] / [Counter] You may add 1 Life Card to your hand: Up to 1 of your leader or character gains +3000 power during this turn.");
        meteorStrikeOfLove.setImagePath("/images/cards/OP06/OP06-017.png");
        cardRepository.save(meteorStrikeOfLove);

        Card gumGumKingKongGatling = new Card();
        gumGumKingKongGatling.setCardNumber("OP06-018");
        gumGumKingKongGatling.setName("Gum Gum King Kong Gatling");
        gumGumKingKongGatling.setCardType("Event");
        gumGumKingKongGatling.setColor("Red");
        gumGumKingKongGatling.setCost(2);
        gumGumKingKongGatling.setAffiliations("FILM / Straw Hat Pirates");
        gumGumKingKongGatling.setEffect("[Main] Give up to 1 of your leader or characters +3000 Power. Then, if your opponent has a character with 7000 Power or more, give up to one of your Leaders or Characters +1000 Power for the turn.\\n[Trigger] KO up to 1 of your opponent's characters with 5000 Power or less.");
        gumGumKingKongGatling.setImagePath("/images/cards/OP06/OP06-018.png");
        cardRepository.save(gumGumKingKongGatling);

        Card azureDragonStampFlowingWater = new Card();
        azureDragonStampFlowingWater.setCardNumber("OP06-019");
        azureDragonStampFlowingWater.setName("Azure Dragon Stamp Flowing Water");
        azureDragonStampFlowingWater.setCardType("Event");
        azureDragonStampFlowingWater.setColor("Red");
        azureDragonStampFlowingWater.setCost(3);
        azureDragonStampFlowingWater.setAffiliations("FILM / Straw Hat Crew");
        azureDragonStampFlowingWater.setEffect("[Main] K.O. up to one of your opponent's characters with power 5000 or less.\\n[Trigger] K.O. up to one of your opponent's characters with power 4000 or less.");
        azureDragonStampFlowingWater.setImagePath("/images/cards/OP06/OP06-019.png");
        cardRepository.save(azureDragonStampFlowingWater);
        
        System.out.println("Finished initializing OP06 Red cards");
    }

    private void initializeOP06GreenCards() {
        System.out.println("Initializing OP06 Green cards...");

        // Leaders
        Card hodyJonesLeader = new Card();
        hodyJonesLeader.setCardNumber("OP06-020");
        hodyJonesLeader.setName("Hody Jones");
        hodyJonesLeader.setCardType("Leader");
        hodyJonesLeader.setColor("Green");
        hodyJonesLeader.setPower(5000);
        hodyJonesLeader.setLife(5);
        hodyJonesLeader.setAffiliations("Fish-Man / New Fish-Man Pirates");
        hodyJonesLeader.setAttribute("Strike");
        hodyJonesLeader.setEffect("[Activate: Main] You may rest this Leader: Rest up to 1 of your opponent's Characters that cost 3 or less, or 1 of their DON!!. Then, during this turn, you can not add life cards to your hand through your own effects.");
        hodyJonesLeader.setImagePath("/images/cards/OP06/OP06-020.png");
        cardRepository.save(hodyJonesLeader);

        Card peronaLeader = new Card();
        peronaLeader.setCardNumber("OP06-021");
        peronaLeader.setName("Perona");
        peronaLeader.setCardType("Leader");
        peronaLeader.setColor("Green/Black"); // Dual Color
        peronaLeader.setPower(5000);
        peronaLeader.setLife(4);
        peronaLeader.setAffiliations("Thriller Bark Pirates");
        peronaLeader.setAttribute("Special");
        peronaLeader.setEffect("[Activate: Main] [Once Per Turn] Choose one of the following effects:\\n• Rest up to 1 of your opponent's characters with a cost of 4 or less.\\n• Up to 1 of your opponent's characters gets -1 cost during this turn");
        peronaLeader.setImagePath("/images/cards/OP06/OP06-021.png");
        cardRepository.save(peronaLeader);

        Card yamatoLeader = new Card();
        yamatoLeader.setCardNumber("OP06-022");
        yamatoLeader.setName("Yamato");
        yamatoLeader.setCardType("Leader");
        yamatoLeader.setColor("Green/Yellow"); // Dual Color
        yamatoLeader.setPower(5000);
        yamatoLeader.setLife(4);
        yamatoLeader.setAffiliations("Land of wano");
        yamatoLeader.setAttribute("Strike");
        yamatoLeader.setEffect("[Double Attack]\\n[Activate: Main] [Once Per Turn] If your opponent has 3 or less life, attach up to 2 rested DON!! to one of your characters.");
        yamatoLeader.setImagePath("/images/cards/OP06/OP06-022.png");
        cardRepository.save(yamatoLeader);

        // Characters
        Card arlong = new Card();
        arlong.setCardNumber("OP06-023");
        arlong.setName("Arlong");
        arlong.setCardType("Character");
        arlong.setColor("Green");
        arlong.setCost(4);
        arlong.setPower(6000);
        // No Counter
        arlong.setAffiliations("Fishman/East Blue/Arlong Pirates");
        arlong.setAttribute("Slash");
        arlong.setEffect("[On Play] You may discard 1 card from your hand: up to 1 of your opponent's rested leaders may not attack until the end of their next turn.\\n[Trigger] Rest up to 1 of your opponent's cost 4 or lower characters.");
        arlong.setImagePath("/images/cards/OP06/OP06-023.png");
        cardRepository.save(arlong);

        Card ikarosMuhhi = new Card();
        ikarosMuhhi.setCardNumber("OP06-024");
        ikarosMuhhi.setName("Ikaros Muhhi");
        ikarosMuhhi.setCardType("Character");
        ikarosMuhhi.setColor("Green");
        ikarosMuhhi.setCost(5);
        ikarosMuhhi.setPower(6000);
        ikarosMuhhi.setCounter(1000);
        ikarosMuhhi.setAffiliations("Fishman/New Fishman Pirates");
        ikarosMuhhi.setAttribute("Slash");
        ikarosMuhhi.setEffect("[On Play] If your leader's type is \"New Fishman Pirates\", play up to 1 4 cost or lower \"Fishman\" character card from your hand. Then, add the top card of your life to your hand.");
        ikarosMuhhi.setImagePath("/images/cards/OP06/OP06-024.png");
        cardRepository.save(ikarosMuhhi);

        Card camie = new Card();
        camie.setCardNumber("OP06-025");
        camie.setName("Camie");
        camie.setCardType("Character");
        camie.setColor("Green");
        camie.setCost(1);
        camie.setPower(2000);
        camie.setCounter(1000);
        camie.setAffiliations("Merfolk");
        camie.setAttribute("Wisdom");
        camie.setEffect("[On Play] Look at the top 4 cards of your deck and reveal up to one {Fishman} or {Merfolk} type card other than [Camie] and reveal it, then put it in your hand. Then, put the rest on the bottom of your deck in any order.");
        camie.setImagePath("/images/cards/OP06/OP06-025.png");
        cardRepository.save(camie);

        Card koushirou = new Card();
        koushirou.setCardNumber("OP06-026");
        koushirou.setName("Koushirou");
        koushirou.setCardType("Character");
        koushirou.setColor("Green");
        koushirou.setCost(3);
        koushirou.setPower(0);
        koushirou.setCounter(1000);
        koushirou.setAffiliations("Shimotsuki Village");
        koushirou.setAttribute("Slash");
        koushirou.setEffect("[On Play] Set up to 1 of your cost 4 or lower [Slash] trait characters active. Then, for this turn, you may not attack your opponent's leader.");
        koushirou.setImagePath("/images/cards/OP06/OP06-026.png");
        cardRepository.save(koushirou);

        Card gyro = new Card();
        gyro.setCardNumber("OP06-027");
        gyro.setName("Gyro");
        gyro.setCardType("Character");
        gyro.setColor("Green");
        gyro.setCost(1);
        gyro.setPower(2000);
        gyro.setCounter(1000);
        gyro.setAffiliations("Gyro Pirates");
        gyro.setAttribute("Slash");
        gyro.setEffect("[On K.O.] Rest up to 1 of your opponent's Characters with a cost of 3 or less.");
        gyro.setImagePath("/images/cards/OP06/OP06-027.png");
        cardRepository.save(gyro);

        Card zeo = new Card();
        zeo.setCardNumber("OP06-028");
        zeo.setName("Zeo");
        zeo.setCardType("Character");
        zeo.setColor("Green");
        zeo.setCost(2);
        zeo.setPower(3000);
        zeo.setCounter(2000);
        zeo.setAffiliations("Fishman/New Fishman Pirates");
        zeo.setAttribute("Wisdom");
        zeo.setEffect("[DON!!x1] [When Attacking] If your leader has the <New Fish-man Pirates> type, set up to 1 of your DON!! active, and this character gains Power +1000 for this turn. Then, add the top card of your life to your hand.");
        zeo.setImagePath("/images/cards/OP06/OP06-028.png");
        cardRepository.save(zeo);

        Card daruma = new Card();
        daruma.setCardNumber("OP06-029");
        daruma.setName("Daruma");
        daruma.setCardType("Character");
        daruma.setColor("Green");
        daruma.setCost(3);
        daruma.setPower(4000);
        daruma.setCounter(1000);
        daruma.setAffiliations("Fishman/New Fishman Pirates");
        daruma.setAttribute("Slash");
        daruma.setEffect("[DON!!x1] [When Attacking] [Once Per Turn] If your leader has the [New Fishman Pirates Type], set this character as active, and give it power +1000 for the turn. Then, add the top card of your life to your hand.");
        daruma.setImagePath("/images/cards/OP06/OP06-029.png");
        cardRepository.save(daruma);

        Card dosun = new Card();
        dosun.setCardNumber("OP06-030");
        dosun.setName("Dosun");
        dosun.setCardType("Character");
        dosun.setColor("Green");
        dosun.setCost(3);
        dosun.setPower(4000);
        dosun.setCounter(1000);
        dosun.setAffiliations("Fishman/New Fishman Pirates");
        dosun.setAttribute("Strike");
        dosun.setEffect("[When Attacking] If your leader has the [New Fishman Pirates] Type, this character cannot be KO'd in battle, and has Power +2000 until the start of your next turn. Then, add the top card of your life to your hand.");
        dosun.setImagePath("/images/cards/OP06/OP06-030.png");
        cardRepository.save(dosun);

        Card hatchan = new Card();
        hatchan.setCardNumber("OP06-031");
        hatchan.setName("Hatchan");
        hatchan.setCardType("Character");
        hatchan.setColor("Green");
        hatchan.setCost(4);
        hatchan.setPower(5000);
        hatchan.setCounter(1000);
        hatchan.setAffiliations("Fishman / Former Arlong Pirates");
        hatchan.setAttribute("Slash");
        hatchan.setEffect("[Trigger] Play up to one <Fishman> or <Merfolk> character with a cost of 3 or less from your hand.");
        hatchan.setImagePath("/images/cards/OP06/OP06-031.png");
        cardRepository.save(hatchan);

        Card hammond = new Card();
        hammond.setCardNumber("OP06-032");
        hammond.setName("Hammond");
        hammond.setCardType("Character");
        hammond.setColor("Green");
        hammond.setCost(2);
        hammond.setPower(2000);
        hammond.setCounter(1000);
        hammond.setAffiliations("Fishman/New Fishman Pirates");
        hammond.setAttribute("Ranged");
        hammond.setEffect("[Blocker]");
        hammond.setImagePath("/images/cards/OP06/OP06-032.png");
        cardRepository.save(hammond);

        Card vanderDecken = new Card();
        vanderDecken.setCardNumber("OP06-033");
        vanderDecken.setName("Vander Decken IX");
        vanderDecken.setCardType("Character");
        vanderDecken.setColor("Green");
        vanderDecken.setCost(2);
        vanderDecken.setPower(2000);
        vanderDecken.setCounter(1000);
        vanderDecken.setAffiliations("Fishman/Flying Pirates");
        vanderDecken.setAttribute("Ranged");
        vanderDecken.setEffect("[On Play] You may trash a <Fishman> type card from your hand or trash a \"Noa's Ark\" from your hand or field: K.O. up to one of your opponent's rested characters.");
        vanderDecken.setImagePath("/images/cards/OP06/OP06-033.png");
        cardRepository.save(vanderDecken);

        Card hyouzou = new Card();
        hyouzou.setCardNumber("OP06-034");
        hyouzou.setName("Hyouzou");
        hyouzou.setCardType("Character");
        hyouzou.setColor("Green");
        hyouzou.setCost(4);
        hyouzou.setPower(6000);
        // No Counter
        hyouzou.setAffiliations("Merfolk");
        hyouzou.setAttribute("Slash");
        hyouzou.setEffect("[Activate: Main] [Once Per Turn] Rest up to one of your opponent's characters with a cost of 4 or less, and this Character gains +1000 power during this turn. Then, add the top card of your life to your hand.");
        hyouzou.setImagePath("/images/cards/OP06/OP06-034.png");
        cardRepository.save(hyouzou);

        Card hodyJonesChar = new Card();
        hodyJonesChar.setCardNumber("OP06-035");
        hodyJonesChar.setName("Hody Jones");
        hodyJonesChar.setCardType("Character");
        hodyJonesChar.setColor("Green");
        hodyJonesChar.setCost(7);
        hodyJonesChar.setPower(8000);
        // No Counter
        hodyJonesChar.setAffiliations("Fishman / New Fishman Pirates");
        hodyJonesChar.setAttribute("Strike");
        hodyJonesChar.setEffect("[Rush]\\n[On Play] Rest up to a total of 2 of your opponents characters and/or don. Then, put the top of your life cards into your hand.");
        hodyJonesChar.setImagePath("/images/cards/OP06/OP06-035.png");
        cardRepository.save(hodyJonesChar);

        Card ryuma = new Card();
        ryuma.setCardNumber("OP06-036");
        ryuma.setName("Ryuma");
        ryuma.setCardType("Character");
        ryuma.setColor("Green");
        ryuma.setCost(4);
        ryuma.setPower(6000);
        // No Counter
        ryuma.setAffiliations("Land of Wano/Thriller Bark Pirates");
        ryuma.setAttribute("Slash");
        ryuma.setEffect("[On Play] / [On K.O.] K.O. up to 1 of your opponent's rested character with a cost of 4 or less.");
        ryuma.setImagePath("/images/cards/OP06/OP06-036.png");
        cardRepository.save(ryuma);

        Card wadatsumi = new Card();
        wadatsumi.setCardNumber("OP06-037");
        wadatsumi.setName("Wadatsumi");
        wadatsumi.setCardType("Character");
        wadatsumi.setColor("Green");
        wadatsumi.setCost(6);
        wadatsumi.setPower(8000);
        wadatsumi.setCounter(1000);
        wadatsumi.setAffiliations("Fishman / Flying Pirates");
        wadatsumi.setAttribute("Strike");
        // No Effect
        wadatsumi.setImagePath("/images/cards/OP06/OP06-037.png");
        cardRepository.save(wadatsumi);

        // Events
        Card billionFoldTrichiliocosm = new Card();
        billionFoldTrichiliocosm.setCardNumber("OP06-038");
        billionFoldTrichiliocosm.setName("Billion-fold World Trichiliocosm");
        billionFoldTrichiliocosm.setCardType("Event");
        billionFoldTrichiliocosm.setColor("Green");
        billionFoldTrichiliocosm.setCost(1);
        billionFoldTrichiliocosm.setAffiliations("Straw Hat Crew/Dressrosa");
        billionFoldTrichiliocosm.setEffect("[Counter] Up to 1 of your Leader or Characters gains +2000 power during this battle. Then, if you have 8 or more rested cards, that card gains an additional +2000 power.\\n[Trigger] KO up to one of your opponent's rested characters with a cost of 3 or less.");
        billionFoldTrichiliocosm.setImagePath("/images/cards/OP06/OP06-038.png");
        cardRepository.save(billionFoldTrichiliocosm);

        Card youCouldntEvenKillMyBoredom = new Card();
        youCouldntEvenKillMyBoredom.setCardNumber("OP06-039");
        youCouldntEvenKillMyBoredom.setName("You couldn't even kill my boredom!!!");
        youCouldntEvenKillMyBoredom.setCardType("Event");
        youCouldntEvenKillMyBoredom.setColor("Green");
        youCouldntEvenKillMyBoredom.setCost(4);
        youCouldntEvenKillMyBoredom.setAffiliations("Straw Hat Crew");
        youCouldntEvenKillMyBoredom.setEffect("[Main] Choose 1 of the following effects:\\n• Rest up to one of your opponent's characters with a cost of 6 or less.\\n• K.O. up to one of your opponent's rested characters with a cost of 4 or less.\\n[Trigger] Activate this card's [Main] effect.");
        youCouldntEvenKillMyBoredom.setImagePath("/images/cards/OP06/OP06-039.png");
        cardRepository.save(youCouldntEvenKillMyBoredom);

        Card sharkArrows = new Card();
        sharkArrows.setCardNumber("OP06-040");
        sharkArrows.setName("Shark Arrows");
        sharkArrows.setCardType("Event");
        sharkArrows.setColor("Green");
        sharkArrows.setCost(2);
        sharkArrows.setAffiliations("Fishman / New Fishman Pirates");
        sharkArrows.setEffect("[Main] K.O. up to 2 of your opponent's rested characters with a cost of 3 or less.\\n[Trigger] Activate this card's [Main] effect.");
        sharkArrows.setImagePath("/images/cards/OP06/OP06-040.png");
        cardRepository.save(sharkArrows);

        // Stages
        Card noahsArk = new Card();
        noahsArk.setCardNumber("OP06-041");
        noahsArk.setName("Noah's Ark");
        noahsArk.setCardType("Stage");
        noahsArk.setColor("Green");
        noahsArk.setCost(6);
        noahsArk.setAffiliations("Fishman Island");
        noahsArk.setEffect("[On Play] Rest all of your opponent's characters.\\n[Trigger] Put this card into play.");
        noahsArk.setImagePath("/images/cards/OP06/OP06-041.png");
        cardRepository.save(noahsArk);

        System.out.println("Finished initializing OP06 Green cards");
    }

    private void initializeOP06BlueCards() {
        System.out.println("Initializing OP06 Blue cards...");

        // Characters
        Card aramaki = new Card();
        aramaki.setCardNumber("OP06-043");
        aramaki.setName("Aramaki");
        aramaki.setCardType("Character");
        aramaki.setColor("Blue");
        aramaki.setCost(8);
        aramaki.setPower(8000);
        // No Counter
        aramaki.setAffiliations("Navy");
        aramaki.setAttribute("Special");
        aramaki.setEffect("[Blocker]\\n[Activate: Main] [Once Per Turn] Discard one card from your hand and return 1 cost 2 or lower character to the bottom of it's owner's deck. This character gains +3000 power for this turn.");
        aramaki.setImagePath("/images/cards/OP06/OP06-043.png");
        cardRepository.save(aramaki);

        Card gion = new Card();
        gion.setCardNumber("OP06-044");
        gion.setName("Gion");
        gion.setCardType("Character");
        gion.setColor("Blue");
        gion.setCost(4);
        gion.setPower(5000);
        gion.setCounter(2000);
        gion.setAffiliations("Navy");
        gion.setAttribute("Slash");
        gion.setEffect("[Your Turn] [Once Per Turn] When your opponent activates an event, your opponent places one card from their hand at the bottom of their deck.");
        gion.setImagePath("/images/cards/OP06/OP06-044.png");
        cardRepository.save(gion);

        Card kuzan = new Card();
        kuzan.setCardNumber("OP06-045");
        kuzan.setName("Kuzan");
        kuzan.setCardType("Character");
        kuzan.setColor("Blue");
        kuzan.setCost(3);
        kuzan.setPower(5000);
        // No Counter
        kuzan.setAffiliations("Navy");
        kuzan.setAttribute("Special");
        kuzan.setEffect("[On Play] Draw 2 cards, then place 2 cards from your hand at the bottom of your deck in any order.");
        kuzan.setImagePath("/images/cards/OP06/OP06-045.png");
        cardRepository.save(kuzan);

        Card sakazuki = new Card();
        sakazuki.setCardNumber("OP06-046");
        sakazuki.setName("Sakazuki");
        sakazuki.setCardType("Character");
        sakazuki.setColor("Blue");
        sakazuki.setCost(5);
        sakazuki.setPower(6000);
        // No Counter
        sakazuki.setAffiliations("Navy");
        sakazuki.setAttribute("Special");
        sakazuki.setEffect("[On Play] Place up to 1 character with a cost of 2 or less at the bottom of the owner's deck.");
        sakazuki.setImagePath("/images/cards/OP06/OP06-046.png");
        cardRepository.save(sakazuki);

        Card charlottePudding = new Card();
        charlottePudding.setCardNumber("OP06-047");
        charlottePudding.setName("Charlotte Pudding");
        charlottePudding.setCardType("Character");
        charlottePudding.setColor("Blue");
        charlottePudding.setCost(4);
        charlottePudding.setPower(4000);
        charlottePudding.setCounter(1000);
        charlottePudding.setAffiliations("Big Mom Pirates");
        charlottePudding.setAttribute("Wisdom");
        charlottePudding.setEffect("[On Play] Your opponent returns all of their hand cards to their deck and shuffles their deck. Then, your opponent draws 5 cards.");
        charlottePudding.setImagePath("/images/cards/OP06/OP06-047.png");
        cardRepository.save(charlottePudding);

        Card zeff = new Card();
        zeff.setCardNumber("OP06-048");
        zeff.setName("Zeff");
        zeff.setCardType("Character");
        zeff.setColor("Blue");
        zeff.setCost(3);
        zeff.setPower(3000);
        zeff.setCounter(1000);
        zeff.setAffiliations("East Blue");
        zeff.setAttribute("Strike");
        zeff.setEffect("[During Your Turn] When your opponent activates a [Blocker] or event, if your leader has the {East Blue} type, you may put the top 4 cards of your deck into your trash.");
        zeff.setImagePath("/images/cards/OP06/OP06-048.png");
        cardRepository.save(zeff);

        Card sengoku = new Card();
        sengoku.setCardNumber("OP06-049");
        sengoku.setName("Sengoku");
        sengoku.setCardType("Character");
        sengoku.setColor("Blue");
        sengoku.setCost(5);
        sengoku.setPower(7000);
        sengoku.setCounter(1000);
        sengoku.setAffiliations("Navy");
        sengoku.setAttribute("Strike");
        // No Effect
        sengoku.setImagePath("/images/cards/OP06/OP06-049.png");
        cardRepository.save(sengoku);

        Card tashigi = new Card();
        tashigi.setCardNumber("OP06-050");
        tashigi.setName("Tashigi");
        tashigi.setCardType("Character");
        tashigi.setColor("Blue");
        tashigi.setCost(1);
        tashigi.setPower(2000);
        tashigi.setCounter(1000);
        tashigi.setAffiliations("Navy");
        tashigi.setAttribute("Slash");
        tashigi.setEffect("[On Play] Look at the top 5 cards of your deck, reveal up to 1 {Navy} type card other than [Tashigi] and reveal it, then put it into your hand. Then, place the rest on the bottom of your deck in any order.");
        tashigi.setImagePath("/images/cards/OP06/OP06-050.png");
        cardRepository.save(tashigi);

        Card tsuru = new Card();
        tsuru.setCardNumber("OP06-051");
        tsuru.setName("Tsuru");
        tsuru.setCardType("Character");
        tsuru.setColor("Blue");
        tsuru.setCost(5);
        tsuru.setPower(4000);
        tsuru.setCounter(2000);
        tsuru.setAffiliations("Navy");
        tsuru.setAttribute("Special");
        tsuru.setEffect("[On Play] You may trash 2 cards from your hand: Your opponent returns one of their characters to its owner's hand.");
        tsuru.setImagePath("/images/cards/OP06/OP06-051.png");
        cardRepository.save(tsuru);

        Card tokikake = new Card();
        tokikake.setCardNumber("OP06-052");
        tokikake.setName("Tokikake");
        tokikake.setCardType("Character");
        tokikake.setColor("Blue");
        tokikake.setCost(2);
        tokikake.setPower(3000);
        tokikake.setCounter(1000);
        tokikake.setAffiliations("Navy");
        tokikake.setAttribute("Strike");
        tokikake.setEffect("[DON!!x1] If you have 4 or less cards in your hand, this character cannot be K.O'd in battle");
        tokikake.setImagePath("/images/cards/OP06/OP06-052.png");
        cardRepository.save(tokikake);

        Card jaguarDSaul = new Card();
        jaguarDSaul.setCardNumber("OP06-053");
        jaguarDSaul.setName("Jaguar D. Saul");
        jaguarDSaul.setCardType("Character");
        jaguarDSaul.setColor("Blue");
        jaguarDSaul.setCost(2);
        jaguarDSaul.setPower(3000);
        jaguarDSaul.setCounter(1000);
        jaguarDSaul.setAffiliations("Giants / Navy");
        jaguarDSaul.setAttribute("Strike");
        jaguarDSaul.setEffect("[On K.O.] Place up to one character with a cost of 2 or less at the bottom of the owner's deck.");
        jaguarDSaul.setImagePath("/images/cards/OP06/OP06-053.png");
        cardRepository.save(jaguarDSaul);

        Card borsalinoBlue = new Card();
        borsalinoBlue.setCardNumber("OP06-054");
        borsalinoBlue.setName("Borsalino");
        borsalinoBlue.setCardType("Character");
        borsalinoBlue.setColor("Blue");
        borsalinoBlue.setCost(2);
        borsalinoBlue.setPower(4000);
        // No Counter
        borsalinoBlue.setAffiliations("Navy");
        borsalinoBlue.setAttribute("Special");
        borsalinoBlue.setEffect("If you have 5 or less cards in hand, this character gains [Blocker].");
        borsalinoBlue.setImagePath("/images/cards/OP06/OP06-054.png");
        cardRepository.save(borsalinoBlue);

        Card monkeyDGarpBlue = new Card();
        monkeyDGarpBlue.setCardNumber("OP06-055");
        monkeyDGarpBlue.setName("Monkey D. Garp");
        monkeyDGarpBlue.setCardType("Character");
        monkeyDGarpBlue.setColor("Blue");
        monkeyDGarpBlue.setCost(5);
        monkeyDGarpBlue.setPower(7000);
        // No Counter
        monkeyDGarpBlue.setAffiliations("Navy");
        monkeyDGarpBlue.setAttribute("Strike");
        monkeyDGarpBlue.setEffect("[DON!!x2] [When Attacking] If you have 4 or less cards in your hand, your opponent cannot activate [Blocker] during this battle.");
        monkeyDGarpBlue.setImagePath("/images/cards/OP06/OP06-055.png");
        cardRepository.save(monkeyDGarpBlue);

        // Events
        Card amaNoMurakumo = new Card();
        amaNoMurakumo.setCardNumber("OP06-056");
        amaNoMurakumo.setName("Ama no Murakumo");
        amaNoMurakumo.setCardType("Event");
        amaNoMurakumo.setColor("Blue");
        amaNoMurakumo.setCost(2);
        amaNoMurakumo.setAffiliations("Navy");
        amaNoMurakumo.setEffect("[Main] Return up to 1 of your opponent's Cost 2 or lower and up to 1 of your opponent's Cost 1 or lower characters to the bottom of its owner's deck in any order.\\n[Trigger] Activate this card's [Main] effect.");
        amaNoMurakumo.setImagePath("/images/cards/OP06/OP06-056.png");
        cardRepository.save(amaNoMurakumo);

        Card iCouldNeverDoubt = new Card();
        iCouldNeverDoubt.setCardNumber("OP06-057");
        iCouldNeverDoubt.setName("I could never doubt a woman's tears!!!");
        iCouldNeverDoubt.setCardType("Event");
        iCouldNeverDoubt.setColor("Blue");
        iCouldNeverDoubt.setCost(1);
        iCouldNeverDoubt.setAffiliations("Dressrosa / Straw Hat Crew");
        iCouldNeverDoubt.setEffect("[Main] Up to one of your leader or characters gain +1000 for this turn. Then, reveal the top card of your deck and put up to one cost 2 character into play and put the rest on the top of bottom of your deck.\\n[Trigger] Put up to one cost 2 character from your hand into play.");
        iCouldNeverDoubt.setImagePath("/images/cards/OP06/OP06-057.png");
        cardRepository.save(iCouldNeverDoubt);

        Card gravityBladeRagingTiger = new Card();
        gravityBladeRagingTiger.setCardNumber("OP06-058");
        gravityBladeRagingTiger.setName("Gravity Blade Raging Tiger");
        gravityBladeRagingTiger.setCardType("Event");
        gravityBladeRagingTiger.setColor("Blue");
        gravityBladeRagingTiger.setCost(7);
        gravityBladeRagingTiger.setAffiliations("Navy");
        gravityBladeRagingTiger.setEffect("[Main] Place up to 2 cost 6 or less characters in any order on the bottom of their owner's deck.\\n[Trigger] Place up to one cost 5 or less character on the bottom of its owner's deck.");
        gravityBladeRagingTiger.setImagePath("/images/cards/OP06/OP06-058.png");
        cardRepository.save(gravityBladeRagingTiger);

        Card whiteSnake = new Card();
        whiteSnake.setCardNumber("OP06-059");
        whiteSnake.setName("White Snake");
        whiteSnake.setCardType("Event");
        whiteSnake.setColor("Blue");
        whiteSnake.setCost(2);
        whiteSnake.setAffiliations("Navy");
        whiteSnake.setEffect("[Counter] Up to one of your leader or characters gain +1000 for this turn. Then, draw 1 card.\\n[Trigger] Look at the top 5 cards of your deck, then place them in any order at the top or bottom of your deck.");
        whiteSnake.setImagePath("/images/cards/OP06/OP06-059.png");
        cardRepository.save(whiteSnake);
        
        System.out.println("Finished initializing OP06 Blue cards");
    }

    private void initializeOP06PurpleCards() {
        System.out.println("Initializing OP06 Purple cards...");

        // Leaders
        Card vinsmokeReijuLeader = new Card();
        vinsmokeReijuLeader.setCardNumber("OP06-042"); // Note: Card numbers seem off, following image numbers
        vinsmokeReijuLeader.setName("Vinsmoke Reiju");
        vinsmokeReijuLeader.setCardType("Leader");
        vinsmokeReijuLeader.setColor("Purple");
        vinsmokeReijuLeader.setPower(5000);
        vinsmokeReijuLeader.setLife(4);
        vinsmokeReijuLeader.setAffiliations("Vinsmoke Family / Germa 66");
        vinsmokeReijuLeader.setAttribute("Special");
        vinsmokeReijuLeader.setEffect("[Your Turn] [Once Per Turn] When one of your DON!! cards on the field is returned to your DON!! deck, draw 1 card.");
        vinsmokeReijuLeader.setImagePath("/images/cards/OP06/OP06-042.png"); // Leader card number is usually 001 or similar, but using provided image number
        cardRepository.save(vinsmokeReijuLeader);

        // Characters
        Card vinsmokeIchiji = new Card();
        vinsmokeIchiji.setCardNumber("OP06-060");
        vinsmokeIchiji.setName("Vinsmoke Ichiji");
        vinsmokeIchiji.setCardType("Character");
        vinsmokeIchiji.setColor("Purple");
        vinsmokeIchiji.setCost(4);
        vinsmokeIchiji.setPower(4000);
        vinsmokeIchiji.setCounter(1000);
        vinsmokeIchiji.setAffiliations("Vinsmoke Family/Germa 66");
        vinsmokeIchiji.setAttribute("Strike");
        vinsmokeIchiji.setEffect("[Activate: Main] DON!!-1, You may trash this character: if your leader has the <<GERMA 66>> Type, you may play up to 1 Cost 7 \"Vinsmoke Ichiji\" from your hand or trash.");
        vinsmokeIchiji.setImagePath("/images/cards/OP06/OP06-060.png");
        cardRepository.save(vinsmokeIchiji);
        
        Card vinsmokeIchijiSR = new Card();
        vinsmokeIchijiSR.setCardNumber("OP06-061");
        vinsmokeIchijiSR.setName("Vinsmoke Ichiji");
        vinsmokeIchijiSR.setCardType("Character");
        vinsmokeIchijiSR.setColor("Purple");
        vinsmokeIchijiSR.setCost(7);
        vinsmokeIchijiSR.setPower(7000);
        // No Counter
        vinsmokeIchijiSR.setAffiliations("Vinsmoke Family / Germa 66");
        vinsmokeIchijiSR.setAttribute("Strike");
        vinsmokeIchijiSR.setEffect("[On Play] If you have equal to or less DON!! on your field than you opponent, give up to 1 of your opponent's Characters -2000 power for this turn, and this Character gains [Rush].");
        vinsmokeIchijiSR.setImagePath("/images/cards/OP06/OP06-061.png");
        cardRepository.save(vinsmokeIchijiSR);

        Card vinsmokeJudge = new Card();
        vinsmokeJudge.setCardNumber("OP06-062");
        vinsmokeJudge.setName("Vinsmoke Judge");
        vinsmokeJudge.setCardType("Character");
        vinsmokeJudge.setColor("Purple");
        vinsmokeJudge.setCost(8);
        vinsmokeJudge.setPower(8000);
        // No Counter
        vinsmokeJudge.setAffiliations("Vinsmoke Family / Germa 66");
        vinsmokeJudge.setAttribute("Slash");
        vinsmokeJudge.setEffect("[On Play] DON!!-1: You may trash 2 cards from your hand: Play up to 4 {Germa 66} type Character cards with 4000 power or less from your trash with different names.\\n[Activate: Main] [Once Per Turn] DON!!-1: Rest up to 1 of your opponent's DON!! cards.");
        vinsmokeJudge.setImagePath("/images/cards/OP06/OP06-062.png");
        cardRepository.save(vinsmokeJudge);

        Card vinsmokeSora = new Card();
        vinsmokeSora.setCardNumber("OP06-063");
        vinsmokeSora.setName("Vinsmoke Sora");
        vinsmokeSora.setCardType("Character");
        vinsmokeSora.setColor("Purple");
        vinsmokeSora.setCost(1);
        vinsmokeSora.setPower(0);
        vinsmokeSora.setCounter(2000);
        vinsmokeSora.setAffiliations("Vinsmoke Family / Germa Kingdom");
        vinsmokeSora.setAttribute("Wisdom");
        vinsmokeSora.setEffect("[On Play] You may discard a card from your hand: if you have equal to or less DON!! on your field than your opponent, add to your hand up to 1 character card of 4000 Power or less that has the {Vinsmoke Family} type from the trash.");
        vinsmokeSora.setImagePath("/images/cards/OP06/OP06-063.png");
        cardRepository.save(vinsmokeSora);

        Card vinsmokeNiji = new Card();
        vinsmokeNiji.setCardNumber("OP06-064");
        vinsmokeNiji.setName("Vinsmoke Niji");
        vinsmokeNiji.setCardType("Character");
        vinsmokeNiji.setColor("Purple");
        vinsmokeNiji.setCost(3);
        vinsmokeNiji.setPower(3000);
        vinsmokeNiji.setCounter(1000);
        vinsmokeNiji.setAffiliations("Vinsmoke Family/Germa 66");
        vinsmokeNiji.setAttribute("Special");
        vinsmokeNiji.setEffect("[Activate: Main] DON!!-1, You may trash this character: if your leader has the <<GERMA 66>> Type, you may play up to 1 Cost 5 \"Vinsmoke Niji\" from your hand or trash.");
        vinsmokeNiji.setImagePath("/images/cards/OP06/OP06-064.png");
        cardRepository.save(vinsmokeNiji);

        Card vinsmokeNijiR = new Card();
        vinsmokeNijiR.setCardNumber("OP06-065");
        vinsmokeNijiR.setName("Vinsmoke Niji");
        vinsmokeNijiR.setCardType("Character");
        vinsmokeNijiR.setColor("Purple");
        vinsmokeNijiR.setCost(5);
        vinsmokeNijiR.setPower(6000);
        vinsmokeNijiR.setCounter(1000);
        vinsmokeNijiR.setAffiliations("Vinsmoke Family / Germa 66");
        vinsmokeNijiR.setAttribute("Special");
        vinsmokeNijiR.setEffect("[On Play] If you have equal to or less DON!! on your field than you opponent, choose one of the following.\\n• K.O. up to 1 of your opponent's Characters that cost 2 or less.\\n• Return up to 1 of your opponent's Characters that cost 4 or less to their owner's hand.");
        vinsmokeNijiR.setImagePath("/images/cards/OP06/OP06-065.png");
        cardRepository.save(vinsmokeNijiR);

        Card vinsmokeYonji = new Card();
        vinsmokeYonji.setCardNumber("OP06-066");
        vinsmokeYonji.setName("Vinsmoke Yonji");
        vinsmokeYonji.setCardType("Character");
        vinsmokeYonji.setColor("Purple");
        vinsmokeYonji.setCost(2);
        vinsmokeYonji.setPower(2000);
        vinsmokeYonji.setCounter(1000);
        vinsmokeYonji.setAffiliations("Vinsmoke Family/Germa 66");
        vinsmokeYonji.setAttribute("Strike");
        vinsmokeYonji.setEffect("[Activate: Main] DON!!-1, You may trash this character: if your leader has the <<GERMA 66>> Type, you may play up to 1 Cost 4 \"Vinsmoke Yonji\" from your hand or trash.");
        vinsmokeYonji.setImagePath("/images/cards/OP06/OP06-066.png");
        cardRepository.save(vinsmokeYonji);

        Card vinsmokeYonjiC = new Card();
        vinsmokeYonjiC.setCardNumber("OP06-067");
        vinsmokeYonjiC.setName("Vinsmoke Yonji");
        vinsmokeYonjiC.setCardType("Character");
        vinsmokeYonjiC.setColor("Purple");
        vinsmokeYonjiC.setCost(4);
        vinsmokeYonjiC.setPower(5000);
        vinsmokeYonjiC.setCounter(1000);
        vinsmokeYonjiC.setAffiliations("Vinsmoke Family / Germa 66");
        vinsmokeYonjiC.setAttribute("Strike");
        vinsmokeYonjiC.setEffect("If you have equal to or less DON!! on your field than your opponent, this Character has +1000 power.\\n[Blocker]");
        vinsmokeYonjiC.setImagePath("/images/cards/OP06/OP06-067.png");
        cardRepository.save(vinsmokeYonjiC);

        Card vinsmokeReiju = new Card();
        vinsmokeReiju.setCardNumber("OP06-068");
        vinsmokeReiju.setName("Vinsmoke Reiju");
        vinsmokeReiju.setCardType("Character");
        vinsmokeReiju.setColor("Purple");
        vinsmokeReiju.setCost(2);
        vinsmokeReiju.setPower(2000);
        vinsmokeReiju.setCounter(1000);
        vinsmokeReiju.setAffiliations("Vinsmoke Family/Germa 66");
        vinsmokeReiju.setAttribute("Special");
        vinsmokeReiju.setEffect("[Activate: Main] DON!!-1, You may trash this character: if your leader has the <<GERMA 66>> Type, you may play up to 1 Cost 4 \"Vinsmoke Reiju\" from your hand or trash.");
        vinsmokeReiju.setImagePath("/images/cards/OP06/OP06-068.png");
        cardRepository.save(vinsmokeReiju);

        Card vinsmokeReijuSR = new Card();
        vinsmokeReijuSR.setCardNumber("OP06-069");
        vinsmokeReijuSR.setName("Vinsmoke Reiju");
        vinsmokeReijuSR.setCardType("Character");
        vinsmokeReijuSR.setColor("Purple");
        vinsmokeReijuSR.setCost(4);
        vinsmokeReijuSR.setPower(5000);
        vinsmokeReijuSR.setCounter(1000);
        vinsmokeReijuSR.setAffiliations("Vinsmoke Family / Germa 66");
        vinsmokeReijuSR.setAttribute("Special");
        vinsmokeReijuSR.setEffect("[On Play] If you have equal to or less DON!! on your field than you opponent, and if you have 5 or less cards in hand, draw 2 cards.");
        vinsmokeReijuSR.setImagePath("/images/cards/OP06/OP06-069.png");
        cardRepository.save(vinsmokeReijuSR);

        Card eldoraggo = new Card();
        eldoraggo.setCardNumber("OP06-070");
        eldoraggo.setName("Eldoraggo");
        eldoraggo.setCardType("Character");
        eldoraggo.setColor("Purple");
        eldoraggo.setCost(5);
        eldoraggo.setPower(7000);
        eldoraggo.setCounter(1000);
        eldoraggo.setAffiliations("FILM / Eldoraggo Pirates");
        eldoraggo.setAttribute("Special");
        // No Effect
        eldoraggo.setImagePath("/images/cards/OP06/OP06-070.png");
        cardRepository.save(eldoraggo);

        Card gildTesoro = new Card();
        gildTesoro.setCardNumber("OP06-071");
        gildTesoro.setName("Gild Tesoro");
        gildTesoro.setCardType("Character");
        gildTesoro.setColor("Purple");
        gildTesoro.setCost(5);
        gildTesoro.setPower(6000);
        gildTesoro.setCounter(1000);
        gildTesoro.setAffiliations("FILM/Gran Tesoro");
        gildTesoro.setAttribute("Special");
        gildTesoro.setEffect("[On Play] DON!!-1 if your leader has the [FILM] type, add 2 cost 4 or lower [FILM] type characters from your trash to your hand.");
        gildTesoro.setImagePath("/images/cards/OP06/OP06-071.png");
        cardRepository.save(gildTesoro);

        Card cosette = new Card();
        cosette.setCardNumber("OP06-072");
        cosette.setName("Cosette");
        cosette.setCardType("Character");
        cosette.setColor("Purple");
        cosette.setCost(1);
        cosette.setPower(0);
        cosette.setCounter(1000);
        cosette.setAffiliations("Germa Kingdom");
        cosette.setAttribute("Wisdom");
        cosette.setEffect("If your leader has the [GERMA 66] type and your board has 2 or more DON!! less than your opponent, this character gains [Blocker].");
        cosette.setImagePath("/images/cards/OP06/OP06-072.png");
        cardRepository.save(cosette);

        Card shiki = new Card();
        shiki.setCardNumber("OP06-073");
        shiki.setName("Shiki");
        shiki.setCardType("Character");
        shiki.setColor("Purple");
        shiki.setCost(2);
        shiki.setPower(1000);
        shiki.setCounter(1000);
        shiki.setAffiliations("FILM/Golden Lion Pirates");
        shiki.setAttribute("Special");
        shiki.setEffect("[Blocker]\\n[On Play] If your board has 8 or more DON!!, draw 1 card, then discard 1 card from your hand.");
        shiki.setImagePath("/images/cards/OP06/OP06-073.png");
        cardRepository.save(shiki);

        Card zephyr = new Card();
        zephyr.setCardNumber("OP06-074");
        zephyr.setName("Zephyr");
        zephyr.setCardType("Character");
        zephyr.setColor("Purple");
        zephyr.setCost(7);
        zephyr.setPower(7000);
        // No Counter
        zephyr.setAffiliations("FILM / Navy");
        zephyr.setAttribute("Strike");
        zephyr.setEffect("[On Play] DON!! -1 Nullify all abilities from up to one of your opponent's characters this turn. Then, if that character has 5000 power or less, KO it.");
        zephyr.setImagePath("/images/cards/OP06/OP06-074.png");
        cardRepository.save(zephyr);

        Card earlBattler = new Card();
        earlBattler.setCardNumber("OP06-075");
        earlBattler.setName("Earl Battler");
        earlBattler.setCardType("Character");
        earlBattler.setColor("Purple");
        earlBattler.setCost(2);
        earlBattler.setPower(3000);
        earlBattler.setCounter(1000);
        earlBattler.setAffiliations("FILM / Crown Island");
        earlBattler.setAttribute("Special");
        earlBattler.setEffect("[On Play] DON!! -1: Rest up to 2 of your opponent's characters of 2 cost or less.");
        earlBattler.setImagePath("/images/cards/OP06/OP06-075.png");
        cardRepository.save(earlBattler);

        Card hitokiriKamazo = new Card();
        hitokiriKamazo.setCardNumber("OP06-076");
        hitokiriKamazo.setName("Hitokiri Kamazo");
        hitokiriKamazo.setCardType("Character");
        hitokiriKamazo.setColor("Purple");
        hitokiriKamazo.setCost(4);
        hitokiriKamazo.setPower(5000);
        hitokiriKamazo.setCounter(2000);
        hitokiriKamazo.setAffiliations("Supernovas / Kidd Pirates / SMILE");
        hitokiriKamazo.setAttribute("Slash");
        hitokiriKamazo.setEffect("[Your Turn] [Once Per Turn] When you return DON!! on your field to your DON!! deck, K.O. up to 1 of your opponent's characters of cost 2 or less.");
        hitokiriKamazo.setImagePath("/images/cards/OP06/OP06-076.png");
        cardRepository.save(hitokiriKamazo);

        // Events
        Card blackBug = new Card();
        blackBug.setCardNumber("OP06-077");
        blackBug.setName("Black Bug");
        blackBug.setCardType("Event");
        blackBug.setColor("Purple");
        blackBug.setCost(4);
        blackBug.setAffiliations("Vinsmoke Family / Germa 66");
        blackBug.setEffect("[Main] If the number of Don!! on your Don!! field is equal to or less than your opponent's Don!! place up to one of your opponent's cost 5 or less characters on the bottom of its owner's deck.\\n[Trigger] Place one of your opponent's cost 4 or less character's on the bottom of its owner's deck.");
        blackBug.setImagePath("/images/cards/OP06/OP06-077.png");
        cardRepository.save(blackBug);

        Card germa66Event = new Card();
        germa66Event.setCardNumber("OP06-078");
        germa66Event.setName("GERMA 66");
        germa66Event.setCardType("Event");
        germa66Event.setColor("Purple");
        germa66Event.setCost(1);
        germa66Event.setAffiliations("Germa Kingdom / Germa 66");
        germa66Event.setEffect("[Main] Look at 5 cards from the top of your deck, reveal up to one card with a type including \"Germa\" other than [GERMA 66] and add it to your hand. Then, place the rest on the bottom of the deck in any order.\\n[Trigger] Draw a card.");
        germa66Event.setImagePath("/images/cards/OP06/OP06-078.png");
        cardRepository.save(germa66Event);

        // Stages
        Card germaKingdom = new Card();
        germaKingdom.setCardNumber("OP06-079");
        germaKingdom.setName("Germa Kingdom");
        germaKingdom.setCardType("Stage");
        germaKingdom.setColor("Purple");
        germaKingdom.setCost(1);
        germaKingdom.setAffiliations("Germa Kingdom");
        germaKingdom.setEffect("[Activate: Main] You may discard 1 card, then rest this stage: Look at the top 3 cards of your deck, reveal up to 1 card with [GERMA] in it's types and add it to your hand. Then, send the remaining cards to the bottom of your deck in any order.");
        germaKingdom.setImagePath("/images/cards/OP06/OP06-079.png");
        cardRepository.save(germaKingdom);

        System.out.println("Finished initializing OP06 Purple cards");
    }

    private void initializeOP06BlackCards() {
        System.out.println("Initializing OP06 Black cards...");

        // Leaders
        Card gekkoMoriaLeader = new Card();
        gekkoMoriaLeader.setCardNumber("OP06-080");
        gekkoMoriaLeader.setName("Gekko Moria");
        gekkoMoriaLeader.setCardType("Leader");
        gekkoMoriaLeader.setColor("Black");
        gekkoMoriaLeader.setPower(5000);
        gekkoMoriaLeader.setLife(5);
        gekkoMoriaLeader.setAffiliations("Seven Warlord of the sea/Thriller Bark Pirates");
        gekkoMoriaLeader.setAttribute("Special");
        gekkoMoriaLeader.setEffect("[DON!!x1] [When Attacking] ② Discard 1 card from your hand: put the top 2 cards of your deck into the trash and play 1 {Thriller Bark Pirates} characters with a cost of 4 or less from the trash.");
        gekkoMoriaLeader.setImagePath("/images/cards/OP06/OP06-080.png");
        cardRepository.save(gekkoMoriaLeader);

        // Characters
        Card absalom = new Card();
        absalom.setCardNumber("OP06-081");
        absalom.setName("Absalom");
        absalom.setCardType("Character");
        absalom.setColor("Black");
        absalom.setCost(4);
        absalom.setPower(5000);
        absalom.setCounter(1000);
        absalom.setAffiliations("Thriller Bark Pirates");
        absalom.setAttribute("Ranged");
        absalom.setEffect("[On Play] You may return 2 cards from your trash to the bottom of your deck in any order: KO up to 1 character with a cost of 2 or less.");
        absalom.setImagePath("/images/cards/OP06/OP06-081.png");
        cardRepository.save(absalom);

        Card inuppe = new Card();
        inuppe.setCardNumber("OP06-082");
        inuppe.setName("Inuppe");
        inuppe.setCardType("Character");
        inuppe.setColor("Black");
        inuppe.setCost(2);
        inuppe.setPower(3000);
        inuppe.setCounter(1000);
        inuppe.setAffiliations("Thriller Bark Pirates");
        inuppe.setAttribute("Strike");
        inuppe.setEffect("[On Play] / [On K.O.] If your leader has the <Thriller Bark Pirates> Type, draw 2 cards, then discard 2 cards from your hand.");
        inuppe.setImagePath("/images/cards/OP06/OP06-082.png");
        cardRepository.save(inuppe);

        Card oars = new Card();
        oars.setCardNumber("OP06-083");
        oars.setName("Oars");
        oars.setCardType("Character");
        oars.setColor("Black");
        oars.setCost(4);
        oars.setPower(7000);
        // No Counter
        oars.setAffiliations("Giant / Thriller Bark Pirates");
        oars.setAttribute("Strike");
        oars.setEffect("This character cannot attack.\\n[Activate: Main] You may KO up to one of your {Thriller Bark Pirates} type characters: This character loses all abilities until end of turn.");
        oars.setImagePath("/images/cards/OP06/OP06-083.png");
        cardRepository.save(oars);

        Card jigoroOfTheWind = new Card();
        jigoroOfTheWind.setCardNumber("OP06-084");
        jigoroOfTheWind.setName("Jigorou of the Wind");
        jigoroOfTheWind.setCardType("Character");
        jigoroOfTheWind.setColor("Black");
        jigoroOfTheWind.setCost(2);
        jigoroOfTheWind.setPower(3000);
        jigoroOfTheWind.setCounter(1000);
        jigoroOfTheWind.setAffiliations("Thriller Bark Pirates");
        jigoroOfTheWind.setAttribute("Slash");
        jigoroOfTheWind.setEffect("[On K.O.] Give up to 1 of your leaders or characters +1000 power for this turn.");
        jigoroOfTheWind.setImagePath("/images/cards/OP06/OP06-084.png");
        cardRepository.save(jigoroOfTheWind);

        Card kumacy = new Card();
        kumacy.setCardNumber("OP06-085");
        kumacy.setName("Kumacy");
        kumacy.setCardType("Character");
        kumacy.setColor("Black");
        kumacy.setCost(2);
        kumacy.setPower(3000);
        kumacy.setCounter(1000);
        kumacy.setAffiliations("Thriller Bark Pirates");
        kumacy.setAttribute("Strike");
        kumacy.setEffect("[DON!!x2] [Your Turn] For every 5 cards in your trash, this character gets +1000 power.");
        kumacy.setImagePath("/images/cards/OP06/OP06-085.png");
        cardRepository.save(kumacy);

        Card gekkoMoriaChar = new Card();
        gekkoMoriaChar.setCardNumber("OP06-086");
        gekkoMoriaChar.setName("Gecko Moria");
        gekkoMoriaChar.setCardType("Character");
        gekkoMoriaChar.setColor("Black");
        gekkoMoriaChar.setCost(8);
        gekkoMoriaChar.setPower(9000);
        // No Counter
        gekkoMoriaChar.setAffiliations("Seven Warlords of the Sea/Thriller Bark Pirates");
        gekkoMoriaChar.setAttribute("Special");
        gekkoMoriaChar.setEffect("[On Play] Choose up to one cost 4 or less and up to one cost 2 or less character card from your trash. Play one of them, then play the remaining rested.");
        gekkoMoriaChar.setImagePath("/images/cards/OP06/OP06-086.png");
        cardRepository.save(gekkoMoriaChar);

        Card cerberus = new Card();
        cerberus.setCardNumber("OP06-087");
        cerberus.setName("Cerberus");
        cerberus.setCardType("Character");
        cerberus.setColor("Black");
        cerberus.setCost(2);
        cerberus.setPower(2000);
        cerberus.setCounter(1000);
        cerberus.setAffiliations("Thriller Bark Pirates");
        cerberus.setAttribute("Strike");
        cerberus.setEffect("[Blocker]");
        cerberus.setImagePath("/images/cards/OP06/OP06-087.png");
        cardRepository.save(cerberus);

        Card sai = new Card();
        sai.setCardNumber("OP06-088");
        sai.setName("Sai");
        sai.setCardType("Character");
        sai.setColor("Black");
        sai.setCost(3);
        sai.setPower(4000);
        sai.setCounter(1000);
        sai.setAffiliations("Dressrosa / Happosui Army");
        sai.setAttribute("Slash");
        sai.setEffect("If your Leader has the {Dressrosa} type and your leader is active, this character gains +2000 power.");
        sai.setImagePath("/images/cards/OP06/OP06-088.png");
        cardRepository.save(sai);

        Card tararan = new Card();
        tararan.setCardNumber("OP06-089");
        tararan.setName("Tararan");
        tararan.setCardType("Character");
        tararan.setColor("Black");
        tararan.setCost(2);
        tararan.setPower(3000);
        tararan.setCounter(1000);
        tararan.setAffiliations("Thriller Bark Pirates");
        tararan.setAttribute("Special");
        tararan.setEffect("[On Play] / [On K.O.] Trash the top 3 cards of your deck.");
        tararan.setImagePath("/images/cards/OP06/OP06-089.png");
        cardRepository.save(tararan);

        Card doctorHogback = new Card();
        doctorHogback.setCardNumber("OP06-090");
        doctorHogback.setName("Doctor Hogback");
        doctorHogback.setCardType("Character");
        doctorHogback.setColor("Black");
        doctorHogback.setCost(4);
        doctorHogback.setPower(5000);
        doctorHogback.setCounter(1000);
        doctorHogback.setAffiliations("Thriller Bark Pirates");
        doctorHogback.setAttribute("Wisdom");
        doctorHogback.setEffect("[On Play] Return 2 cards from your trash to the bottom of your deck in any order: put up to one {Thriller Bark} card other than \" Doctor Hogback \" from your trash to your hand.");
        doctorHogback.setImagePath("/images/cards/OP06/OP06-090.png");
        cardRepository.save(doctorHogback);

        Card victoriaCindry = new Card();
        victoriaCindry.setCardNumber("OP06-091");
        victoriaCindry.setName("Victoria Cindry");
        victoriaCindry.setCardType("Character");
        victoriaCindry.setColor("Black");
        victoriaCindry.setCost(1);
        victoriaCindry.setPower(2000);
        victoriaCindry.setCounter(2000);
        victoriaCindry.setAffiliations("Thriller Bark Pirates");
        victoriaCindry.setAttribute("Slash");
        victoriaCindry.setEffect("[On Play] If your Leader has {Thriller Bark Pirates} type, trash 5 cards from the top of your deck");
        victoriaCindry.setImagePath("/images/cards/OP06/OP06-091.png");
        cardRepository.save(victoriaCindry);

        Card brook = new Card();
        brook.setCardNumber("OP06-092");
        brook.setName("Brook");
        brook.setCardType("Character");
        brook.setColor("Black");
        brook.setCost(6);
        brook.setPower(6000);
        // No Counter
        brook.setAffiliations("Former Rumbar Pirates");
        brook.setAttribute("Slash");
        brook.setEffect("[On Play] Choose one:\\n• Put up to one of your opponent's characters with a cost of 4 or less into their trash.\\n• Your opponent puts 3 cards from their trash to the bottom of their deck in any order.");
        brook.setImagePath("/images/cards/OP06/OP06-092.png");
        cardRepository.save(brook);

        Card peronaChar = new Card();
        peronaChar.setCardNumber("OP06-093");
        peronaChar.setName("Perona");
        peronaChar.setCardType("Character");
        peronaChar.setColor("Black");
        peronaChar.setCost(4);
        peronaChar.setPower(5000);
        peronaChar.setCounter(2000);
        peronaChar.setAffiliations("Thriller Bark Pirates");
        peronaChar.setAttribute("Special");
        peronaChar.setEffect("[On Play] If your opponent has 5 or more cards in their hand, choose one of the following:\\n• Your opponent discards 1 from hand\\n• Give up to 1 of your opponent's characters cost -3 for the turn");
        peronaChar.setImagePath("/images/cards/OP06/OP06-093.png");
        cardRepository.save(peronaChar);

        Card lola = new Card();
        lola.setCardNumber("OP06-094");
        lola.setName("Lola");
        lola.setCardType("Character");
        lola.setColor("Black");
        lola.setCost(4);
        lola.setPower(6000);
        lola.setCounter(1000);
        lola.setAffiliations("Thriller Bark Pirates");
        lola.setAttribute("Slash");
        // No Effect
        lola.setImagePath("/images/cards/OP06/OP06-094.png");
        cardRepository.save(lola);

        // Events
        Card shadowsAsgard = new Card();
        shadowsAsgard.setCardNumber("OP06-095");
        shadowsAsgard.setName("Shadow's Asgard");
        shadowsAsgard.setCardType("Event");
        shadowsAsgard.setColor("Black");
        shadowsAsgard.setCost(2);
        shadowsAsgard.setAffiliations("Seven Warlords of the Sea / Thriller Bark Pirates");
        shadowsAsgard.setEffect("[Main] / [Counter] Your Leader gains +1000 power during this turn. Then, you may K.O. any number of your cost 2 or less characters with the \"Thriller Bark Pirates\" type. For each K.O'd character, your leader gains +1000 during this turn.\\n[Trigger] Draw two cards and trash one from your hand.");
        shadowsAsgard.setImagePath("/images/cards/OP06/OP06-095.png");
        cardRepository.save(shadowsAsgard);

        Card nothingHappened = new Card();
        nothingHappened.setCardNumber("OP06-096");
        nothingHappened.setName("...Nothing!!! Happened....!!!");
        nothingHappened.setCardType("Event");
        nothingHappened.setColor("Black");
        nothingHappened.setCost(3);
        nothingHappened.setAffiliations("Straw Hat Crew");
        nothingHappened.setEffect("[Counter] Add the top card of your life to your hand: all of your cost 7 or lower characters cannot be KO'd in battle this turn.\\n[Trigger] Activate this card's [Counter] effect");
        nothingHappened.setImagePath("/images/cards/OP06/OP06-096.png");
        cardRepository.save(nothingHappened);

        Card negativeHollow = new Card();
        negativeHollow.setCardNumber("OP06-097");
        negativeHollow.setName("Negative Hollow");
        negativeHollow.setCardType("Event");
        negativeHollow.setColor("Black");
        negativeHollow.setCost(2);
        negativeHollow.setAffiliations("Thriller Bark Pirates");
        negativeHollow.setEffect("[Main] Trash one card from your opponent's hand.\\n[Trigger] Activate this card's [Main] ability.");
        negativeHollow.setImagePath("/images/cards/OP06/OP06-097.png");
        cardRepository.save(negativeHollow);

        // Stages
        Card thrillerBark = new Card();
        thrillerBark.setCardNumber("OP06-098");
        thrillerBark.setName("Thriller Bark");
        thrillerBark.setCardType("Stage");
        thrillerBark.setColor("Black");
        thrillerBark.setCost(1);
        thrillerBark.setAffiliations("Thriller Bark Pirates");
        thrillerBark.setEffect("[Activate: Main] ① Rest this stage: If your leader has the [Thriller Bark Pirates] type, you may play up to 1 cost 2 or lower [Thriller Bark Pirates] type character card from your trash rested.");
        thrillerBark.setImagePath("/images/cards/OP06/OP06-098.png");
        cardRepository.save(thrillerBark);

        System.out.println("Finished initializing OP06 Black cards");
    }

    private void initializeOP06YellowCards() {
        System.out.println("Initializing OP06 Yellow cards (and Secret Rares)...");

        // Characters
        Card aisa = new Card();
        aisa.setCardNumber("OP06-099");
        aisa.setName("Aisa");
        aisa.setCardType("Character");
        aisa.setColor("Yellow");
        aisa.setCost(1);
        aisa.setPower(0);
        aisa.setCounter(2000);
        aisa.setAffiliations("Sky Island");
        aisa.setAttribute("Wisdom");
        aisa.setEffect("[On Play] Look at up to 1 card from the top of your or your opponent's Life cards, and place it at the top or bottom of the Life Cards.");
        aisa.setImagePath("/images/cards/OP06/OP06-099.png");
        cardRepository.save(aisa);

        Card inuarashi = new Card();
        inuarashi.setCardNumber("OP06-100");
        inuarashi.setName("Inuarashi");
        inuarashi.setCardType("Character");
        inuarashi.setColor("Yellow");
        inuarashi.setCost(4);
        inuarashi.setPower(5000);
        inuarashi.setCounter(1000);
        inuarashi.setAffiliations("Minks/Land of Wano/The Akazaya Nine");
        inuarashi.setAttribute("Slash");
        inuarashi.setEffect("[DON!!x2] [When Attacking] You may discard 1 card from your hand: K.O. up to one of your opponent's characters with a cost equal to or less than the number of your opponent's current life cards.\\n[Trigger] If your opponent has 3 life cards or less, play this card.");
        inuarashi.setImagePath("/images/cards/OP06/OP06-100.png");
        cardRepository.save(inuarashi);

        Card onamiYellow = new Card();
        onamiYellow.setCardNumber("OP06-101");
        onamiYellow.setName("Onami");
        onamiYellow.setCardType("Character");
        onamiYellow.setColor("Yellow");
        onamiYellow.setCost(2);
        onamiYellow.setPower(3000);
        onamiYellow.setCounter(1000);
        onamiYellow.setAffiliations("Straw Hat Crew");
        onamiYellow.setAttribute("Special");
        onamiYellow.setEffect("[On Play] Give up to 1 of your leaders or characters [Banish] for this turn.\\n[Trigger] KO Up to 1 of your opponent's 5 cost or lower characters.");
        onamiYellow.setImagePath("/images/cards/OP06/OP06-101.png");
        cardRepository.save(onamiYellow);

        Card kamakiri = new Card();
        kamakiri.setCardNumber("OP06-102");
        kamakiri.setName("Kamakiri");
        kamakiri.setCardType("Character");
        kamakiri.setColor("Yellow");
        kamakiri.setCost(3);
        kamakiri.setPower(4000);
        kamakiri.setCounter(1000);
        kamakiri.setAffiliations("Sky Island/Shondora Warrior");
        kamakiri.setAttribute("Slash");
        kamakiri.setEffect("[Activate: Main] [Once Per Turn] Place a 1 cost stage at the bottom of its owner's deck: KO up to 1 of your opponent's cost 2 or lower characters.\\n[Trigger] If you have 2 or less life cards, play this card.");
        kamakiri.setImagePath("/images/cards/OP06/OP06-102.png");
        cardRepository.save(kamakiri);

        Card kawamatsu = new Card();
        kawamatsu.setCardNumber("OP06-103");
        kawamatsu.setName("Kawamatsu");
        kawamatsu.setCardType("Character");
        kawamatsu.setColor("Yellow");
        kawamatsu.setCost(3);
        kawamatsu.setPower(5000);
        // No Counter
        kawamatsu.setAffiliations("Fishman/ Land of wano /Akazaya Nine");
        kawamatsu.setAttribute("Slash");
        kawamatsu.setEffect("[When Attacking] You may discard 2 cards: return up to 1 of your power 0 characters to the top or bottom of its owner's life face up\\n[Trigger] If your opponent's life is at 3 or less, play this card.");
        kawamatsu.setImagePath("/images/cards/OP06/OP06-103.png");
        cardRepository.save(kawamatsu);

        Card kikunojo = new Card();
        kikunojo.setCardNumber("OP06-104");
        kikunojo.setName("Kikunojo");
        kikunojo.setCardType("Character");
        kikunojo.setColor("Yellow");
        kikunojo.setCost(4);
        kikunojo.setPower(6000);
        // No Counter
        kikunojo.setAffiliations("Land of wano /Akazaya Nine");
        kikunojo.setAttribute("Slash");
        kikunojo.setEffect("[On K.O.] If your opponent's life is 3 or less, place the top card of your deck to the top of your life.\\n[Trigger] If your opponent's life is at 3 or less, play this card.");
        kikunojo.setImagePath("/images/cards/OP06/OP06-104.png");
        cardRepository.save(kikunojo);

        Card genbo = new Card();
        genbo.setCardNumber("OP06-105");
        genbo.setName("Genbo");
        genbo.setCardType("Character");
        genbo.setColor("Yellow");
        genbo.setCost(3);
        genbo.setPower(5000);
        genbo.setCounter(1000);
        genbo.setAffiliations("Sky Island/Shandora Warrior");
        genbo.setAttribute("Ranged");
        // No Effect
        genbo.setImagePath("/images/cards/OP06/OP06-105.png");
        cardRepository.save(genbo);

        Card kozukiHiyoriYellow = new Card();
        kozukiHiyoriYellow.setCardNumber("OP06-106");
        kozukiHiyoriYellow.setName("Kozuki Hiyori");
        kozukiHiyoriYellow.setCardType("Character");
        kozukiHiyoriYellow.setColor("Yellow");
        kozukiHiyoriYellow.setCost(2);
        kozukiHiyoriYellow.setPower(0);
        kozukiHiyoriYellow.setCounter(2000);
        kozukiHiyoriYellow.setAffiliations("Wano country / Kozuki Clan");
        kozukiHiyoriYellow.setAttribute("Wisdom");
        kozukiHiyoriYellow.setEffect("[On Play] You may put the top or bottom card of your life pile into your hand: Put up to one card from your hand on the top of your life pile.");
        kozukiHiyoriYellow.setImagePath("/images/cards/OP06/OP06-106.png");
        cardRepository.save(kozukiHiyoriYellow);

        Card kozukiMomonosuke = new Card();
        kozukiMomonosuke.setCardNumber("OP06-107");
        kozukiMomonosuke.setName("Kozuki Momonosuke");
        kozukiMomonosuke.setCardType("Character");
        kozukiMomonosuke.setColor("Yellow");
        kozukiMomonosuke.setCost(5);
        kozukiMomonosuke.setPower(6000);
        // No Counter
        kozukiMomonosuke.setAffiliations("Land of Wano / Kozuki Clan");
        kozukiMomonosuke.setAttribute("Wisdom");
        kozukiMomonosuke.setEffect("[Blocker]\\n[On Play] Place up to one of your {Wano} type characters other than {Kozuki Momonosuke} on the top or bottom of its owners life pile face-up.");
        kozukiMomonosuke.setImagePath("/images/cards/OP06/OP06-107.png");
        cardRepository.save(kozukiMomonosuke);

        Card tenguyamaHitetsu = new Card();
        tenguyamaHitetsu.setCardNumber("OP06-108");
        tenguyamaHitetsu.setName("Tenguyama Hitetsu");
        tenguyamaHitetsu.setCardType("Character");
        tenguyamaHitetsu.setColor("Yellow");
        tenguyamaHitetsu.setCost(1);
        tenguyamaHitetsu.setPower(2000);
        tenguyamaHitetsu.setCounter(1000);
        tenguyamaHitetsu.setAffiliations("Land of Wano/Kouzuki Clan");
        tenguyamaHitetsu.setAttribute("Wisdom");
        tenguyamaHitetsu.setEffect("[Trigger] Up to 1 of your {Land of Wano} type Leader or Character cards gains +2000 power during this turn.");
        tenguyamaHitetsu.setImagePath("/images/cards/OP06/OP06-108.png");
        cardRepository.save(tenguyamaHitetsu);

        Card denjiro = new Card();
        denjiro.setCardNumber("OP06-109");
        denjiro.setName("Denjiro");
        denjiro.setCardType("Character");
        denjiro.setColor("Yellow");
        denjiro.setCost(5);
        denjiro.setPower(6000);
        // No Counter
        denjiro.setAffiliations("Land of wano /Akazaya Nine");
        denjiro.setAttribute("Slash");
        denjiro.setEffect("[DON!!x2] If your opponent's life is at 3 or less, this character cannot be KO'd by effects.\\n[Trigger] If your opponent's life is at 3 or less, play this card.");
        denjiro.setImagePath("/images/cards/OP06/OP06-109.png");
        cardRepository.save(denjiro);

        Card nekomamushi = new Card();
        nekomamushi.setCardNumber("OP06-110");
        nekomamushi.setName("Nekomamushi");
        nekomamushi.setCardType("Character");
        nekomamushi.setColor("Yellow");
        nekomamushi.setCost(4);
        nekomamushi.setPower(5000);
        nekomamushi.setCounter(1000);
        nekomamushi.setAffiliations("Minks/Land of Wano/The Akazaya Nine");
        nekomamushi.setAttribute("Slash");
        nekomamushi.setEffect("[DON!!x2] This Character can also attack your opponent's active Characters.\\n[Trigger] If your opponent has 3 life cards or less, play this card.");
        nekomamushi.setImagePath("/images/cards/OP06/OP06-110.png");
        cardRepository.save(nekomamushi);

        Card braham = new Card();
        braham.setCardNumber("OP06-111");
        braham.setName("Braham");
        braham.setCardType("Character");
        braham.setColor("Yellow");
        braham.setCost(3);
        braham.setPower(4000);
        braham.setCounter(1000);
        braham.setAffiliations("Sky Island / Shandora Warrior");
        braham.setAttribute("Ranged");
        braham.setEffect("[Activate: Main] [Once Per Turn] Place a 1 cost stage at the bottom of its owner's deck: Rest up to 1 of your opponent's Characters with a cost of 4 or less.\\n[Trigger] If you have 2 or less life cards, play this card.");
        braham.setImagePath("/images/cards/OP06/OP06-111.png");
        cardRepository.save(braham);

        Card raizo = new Card();
        raizo.setCardNumber("OP06-112");
        raizo.setName("Raizo");
        raizo.setCardType("Character");
        raizo.setColor("Yellow");
        raizo.setCost(3);
        raizo.setPower(4000);
        raizo.setCounter(1000);
        raizo.setAffiliations("Land of Wano/The Akazaya Nine");
        raizo.setAttribute("Slash");
        raizo.setEffect("[When Attacking] You may discard 1 card from your hand: Rest up to 1 of your opponent's DON!! cards.\\n[Trigger] If your opponent has 3 life cards or less, play this card.");
        raizo.setImagePath("/images/cards/OP06/OP06-112.png");
        cardRepository.save(raizo);

        Card raki = new Card();
        raki.setCardNumber("OP06-113");
        raki.setName("Raki");
        raki.setCardType("Character");
        raki.setColor("Yellow");
        raki.setCost(1);
        raki.setPower(1000);
        raki.setCounter(1000);
        raki.setAffiliations("Sky Island / Shandora Warrior");
        raki.setAttribute("Ranged");
        raki.setEffect("If you have a [Shandora Warrior] type character other than [Raki], this Character gains [Blocker].");
        raki.setImagePath("/images/cards/OP06/OP06-113.png");
        cardRepository.save(raki);

        Card wiper = new Card();
        wiper.setCardNumber("OP06-114");
        wiper.setName("Wiper");
        wiper.setCardType("Character");
        wiper.setColor("Yellow");
        wiper.setCost(5);
        wiper.setPower(7000);
        // No Counter
        wiper.setAffiliations("Sky Island / Shandora Warrior");
        wiper.setAttribute("Ranged");
        wiper.setEffect("[On Play] You may return 1 Cost 1 stage to the bottom of its owner's deck: Look at the top 5 cards of your deck, reveal up to 1 \"Upper Yard\" or [Shandora Warrior] type card and add it to your hand. Then, send the remaining cards to the bottom of your deck in any order.");
        wiper.setImagePath("/images/cards/OP06/OP06-114.png");
        cardRepository.save(wiper);

        // Events
        Card youAreTheOneWhoShouldDisappear = new Card();
        youAreTheOneWhoShouldDisappear.setCardNumber("OP06-115");
        youAreTheOneWhoShouldDisappear.setName("You're the one who should disappear!");
        youAreTheOneWhoShouldDisappear.setCardType("Event");
        youAreTheOneWhoShouldDisappear.setColor("Yellow");
        youAreTheOneWhoShouldDisappear.setCost(0);
        youAreTheOneWhoShouldDisappear.setAffiliations("Sky Island");
        youAreTheOneWhoShouldDisappear.setEffect("[Counter] You may trash one card from your hand: Your leader or up to one of your characters get +3000 for this battle.\\n[Trigger] If you have 0 life cards, put the top card of your deck onto your life pile. Then, trash one card from your hand.");
        youAreTheOneWhoShouldDisappear.setImagePath("/images/cards/OP06/OP06-115.png");
        cardRepository.save(youAreTheOneWhoShouldDisappear);

        Card reject = new Card();
        reject.setCardNumber("OP06-116");
        reject.setName("Reject");
        reject.setCardType("Event");
        reject.setColor("Yellow");
        reject.setCost(4);
        reject.setAffiliations("Sky Island / Shandora Warrior");
        reject.setEffect("[Main] Choose one of the following:\\n• KO up to 1 of your opponent's 5 cost or lower characters.\\n• If your opponent has 1 life, deal 1 damage to them. Then add the top card of your life to your hand.\\n[Trigger] Draw 1 card.");
        reject.setImagePath("/images/cards/OP06/OP06-116.png");
        cardRepository.save(reject);

        // Stages
        Card arkMaxim = new Card();
        arkMaxim.setCardNumber("OP06-117");
        arkMaxim.setName("Ark Maxim");
        arkMaxim.setCardType("Stage");
        arkMaxim.setColor("Yellow");
        arkMaxim.setCost(1);
        arkMaxim.setAffiliations("Sky Island");
        arkMaxim.setEffect("[Activate: Main] [Once Per Turn] You may rest this Stage and one of your [Enel]: K.O. all of your opponent's characters with a cost of 2 or less.");
        arkMaxim.setImagePath("/images/cards/OP06/OP06-117.png");
        cardRepository.save(arkMaxim);

        // Secret Rares
        Card roronoaZoroSecret = new Card();
        roronoaZoroSecret.setCardNumber("OP06-118");
        roronoaZoroSecret.setName("Roronoa Zoro");
        roronoaZoroSecret.setCardType("Character");
        roronoaZoroSecret.setColor("Green/Yellow"); // Dual Color
        roronoaZoroSecret.setCost(9);
        roronoaZoroSecret.setPower(9000);
        // No Counter
        roronoaZoroSecret.setAffiliations("Straw Hat Crew");
        roronoaZoroSecret.setAttribute("Slash");
        roronoaZoroSecret.setEffect("[When Attacking] [Once Per Turn] ① Set this character as active.\\n[Activate: Main] [Once Per Turn] ② Set this character as active.");
        roronoaZoroSecret.setImagePath("/images/cards/OP06/OP06-118.png");
        cardRepository.save(roronoaZoroSecret);

        Card sanjiSecret = new Card();
        sanjiSecret.setCardNumber("OP06-119");
        sanjiSecret.setName("Sanji");
        sanjiSecret.setCardType("Character");
        sanjiSecret.setColor("Blue/Yellow"); // Dual Color
        sanjiSecret.setCost(9);
        sanjiSecret.setPower(9000);
        // No Counter
        sanjiSecret.setAffiliations("Straw Hat Crew");
        sanjiSecret.setAttribute("Strike");
        sanjiSecret.setEffect("[On Play] Reveal the top 1 card of your deck, you may put into play up to 1 revealed character with cost 9 or less other than {Sanji}. Then, place the remaining cards on the bottom of your deck.");
        sanjiSecret.setImagePath("/images/cards/OP06/OP06-119.png");
        cardRepository.save(sanjiSecret);

        System.out.println("Finished initializing OP06 Yellow cards and Secret Rares");
    }
} 