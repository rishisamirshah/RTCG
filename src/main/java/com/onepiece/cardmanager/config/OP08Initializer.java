package com.onepiece.cardmanager.config;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(8) // Order after OP07
public class OP08Initializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public OP08Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Only initialize if we have no OP08 cards
        if (cardRepository.countBySetAndCardNumberStartingWith("OP08", "OP08") > 0) {
            System.out.println("OP08 cards already exist, skipping initialization");
            return;
        }

        System.out.println("Initializing OP08 cards...");
        
        // Initialize Red cards
        initializeOP08RedCards();

        // Initialize Green cards
        initializeOP08GreenCards();

        // Initialize Blue cards
        initializeOP08BlueCards();

        // Initialize Purple cards
        initializeOP08PurpleCards();

        // Initialize Black cards
        initializeOP08BlackCards();

        // Initialize Yellow cards (and Secret Rares)
        initializeOP08YellowCards();

        System.out.println("Finished initializing OP08 cards");
    }

    private void initializeOP08RedCards() {
        System.out.println("Initializing OP08 Red cards...");

        // Leaders
        Card tonyTonyChopperLeader = new Card();
        tonyTonyChopperLeader.setCardNumber("OP08-001");
        tonyTonyChopperLeader.setName("Tony.Tony.Chopper");
        tonyTonyChopperLeader.setCardType("Leader");
        tonyTonyChopperLeader.setColor("Red/Green"); // Dual Color
        tonyTonyChopperLeader.setPower(5000);
        tonyTonyChopperLeader.setLife(4);
        tonyTonyChopperLeader.setAffiliations("Animal / Drum Kingdom / Straw Hat Crew");
        tonyTonyChopperLeader.setAttribute("Strike");
        tonyTonyChopperLeader.setEffect("[Activate: Main] [Once Per Turn] Put up to 1 rested DON!! each on up to 3 of your [Animal] or [Drum Kingdom] type characters.");
        tonyTonyChopperLeader.setImagePath("/images/cards/OP08/OP08-001.png");
        cardRepository.save(tonyTonyChopperLeader);

        Card marcoLeader = new Card();
        marcoLeader.setCardNumber("OP08-002");
        marcoLeader.setName("Marco");
        marcoLeader.setCardType("Leader");
        marcoLeader.setColor("Red/Blue"); // Dual Color
        marcoLeader.setPower(5000);
        marcoLeader.setLife(4);
        marcoLeader.setAffiliations("Whitebeard Pirates");
        marcoLeader.setAttribute("Special");
        marcoLeader.setEffect("[DON!!x1] [Activate: Main] [Once Per Turn] Draw one card, then place one card from your hand on the top or bottom of your deck. Then give up to one of your opponents characters -2000 for this turn.");
        marcoLeader.setImagePath("/images/cards/OP08/OP08-002.png");
        cardRepository.save(marcoLeader);

        // Characters
        Card doctors20 = new Card();
        doctors20.setCardNumber("OP08-003");
        doctors20.setName("20 Doctors");
        doctors20.setCardType("Character");
        doctors20.setColor("Red");
        doctors20.setCost(2);
        doctors20.setPower(2000);
        doctors20.setCounter(1000);
        doctors20.setAffiliations("Drum Kingdom");
        doctors20.setAttribute("Wisdom");
        doctors20.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        doctors20.setImagePath("/images/cards/OP08/OP08-003.png");
        cardRepository.save(doctors20);

        Card kuromarimo = new Card();
        kuromarimo.setCardNumber("OP08-004");
        kuromarimo.setName("Kuromarimo");
        kuromarimo.setCardType("Character");
        kuromarimo.setColor("Red");
        kuromarimo.setCost(4);
        kuromarimo.setPower(5000);
        kuromarimo.setCounter(1000);
        kuromarimo.setAffiliations("Drum Kingdom");
        kuromarimo.setAttribute("Strike");
        kuromarimo.setEffect("[On Play] If you control a \"Chess\", KO up to 1 of your opponent's characters with 3000 Power or less.");
        kuromarimo.setImagePath("/images/cards/OP08/OP08-004.png");
        cardRepository.save(kuromarimo);

        Card chess = new Card();
        chess.setCardNumber("OP08-005");
        chess.setName("Chess");
        chess.setCardType("Character");
        chess.setColor("Red");
        chess.setCost(3);
        chess.setPower(3000);
        chess.setCounter(1000);
        chess.setAffiliations("Drum Kingdom");
        chess.setAttribute("Ranged");
        chess.setEffect("[On Play] Give up to 1 of your opponent's characters -2000 Power for this turn. Then, if you control no \"Kuromarimo\", play a \"Kuromarimo\" from your hand.");
        chess.setImagePath("/images/cards/OP08/OP08-005.png");
        cardRepository.save(chess);

        Card chessmarimo = new Card();
        chessmarimo.setCardNumber("OP08-006");
        chessmarimo.setName("Chessmarimo");
        chessmarimo.setCardType("Character");
        chessmarimo.setColor("Red");
        chessmarimo.setCost(5);
        chessmarimo.setPower(6000);
        chessmarimo.setCounter(1000);
        chessmarimo.setAffiliations("Drum Kingdom");
        chessmarimo.setAttribute("Strike");
        chessmarimo.setEffect("[Your Turn] If you have a [Kuromarimo] and a [Chess] in your trash, this Character gains +2000 power.");
        chessmarimo.setImagePath("/images/cards/OP08/OP08-006.png");
        cardRepository.save(chessmarimo);

        Card tonyTonyChopper = new Card();
        tonyTonyChopper.setCardNumber("OP08-007");
        tonyTonyChopper.setName("Tony Tony .Chopper");
        tonyTonyChopper.setCardType("Character");
        tonyTonyChopper.setColor("Red");
        tonyTonyChopper.setCost(3);
        tonyTonyChopper.setPower(5000);
        // No Counter
        tonyTonyChopper.setAffiliations("Animals / Drum Kingdom / Straw Hat Crew");
        tonyTonyChopper.setAttribute("Strike");
        tonyTonyChopper.setEffect("[Your Turn] [On Play] / [When Attacking] Look at the top 5 cards of your deck, and from among them play up to one {Animal} type character with a power of 4000 or less as rested. Then, place the rest of the cards on the bottom of your deck in any order.");
        tonyTonyChopper.setImagePath("/images/cards/OP08/OP08-007.png");
        cardRepository.save(tonyTonyChopper);

        Card dalton = new Card();
        dalton.setCardNumber("OP08-008");
        dalton.setName("Dalton");
        dalton.setCardType("Character");
        dalton.setColor("Red");
        dalton.setCost(5);
        dalton.setPower(6000);
        dalton.setCounter(1000);
        dalton.setAffiliations("Drum Kingdom");
        dalton.setAttribute("Slash");
        dalton.setEffect("[On Play] Give up to one of your opponents characters -1000 Power for the turn.\\n[DON!!x1] [Activate: Main] [Once Per Turn] You may take the top card of your life and add it to your hand: This character gains [Rush] for the turn.");
        dalton.setImagePath("/images/cards/OP08/OP08-008.png");
        cardRepository.save(dalton);

        Card leekbearMaria = new Card();
        leekbearMaria.setCardNumber("OP08-009");
        leekbearMaria.setName("Leekbear Maria");
        leekbearMaria.setCardType("Character");
        leekbearMaria.setColor("Red");
        leekbearMaria.setCost(3);
        leekbearMaria.setPower(5000);
        leekbearMaria.setCounter(1000);
        leekbearMaria.setAffiliations("Drum Kingdom");
        leekbearMaria.setAttribute("Wisdom");
        // No Effect
        leekbearMaria.setImagePath("/images/cards/OP08/OP08-009.png");
        cardRepository.save(leekbearMaria);

        Card hikingBear = new Card();
        hikingBear.setCardNumber("OP08-010");
        hikingBear.setName("Hiking Bear");
        hikingBear.setCardType("Character");
        hikingBear.setColor("Red");
        hikingBear.setCost(3);
        hikingBear.setPower(3000);
        hikingBear.setCounter(2000);
        hikingBear.setAffiliations("Animal/Drum Kingdom");
        hikingBear.setAttribute("Wisdom");
        hikingBear.setEffect("[DON!!x1] [Activate: Main] [Once Per Turn] Give up to 1 of your \"Animal\" type characters other than this Character +1000 Power for this turn.");
        hikingBear.setImagePath("/images/cards/OP08/OP08-010.png");
        cardRepository.save(hikingBear);

        Card mashuru = new Card();
        mashuru.setCardNumber("OP08-011");
        mashuru.setName("Mashuru");
        mashuru.setCardType("Character");
        mashuru.setColor("Red");
        mashuru.setCost(6);
        mashuru.setPower(8000);
        mashuru.setCounter(1000);
        mashuru.setAffiliations("FILM/Drum Kingdom");
        mashuru.setAttribute("Special");
        // No Effect
        mashuru.setImagePath("/images/cards/OP08/OP08-011.png");
        cardRepository.save(mashuru);

        Card lapahn = new Card();
        lapahn.setCardNumber("OP08-012");
        lapahn.setName("Lapahn");
        lapahn.setCardType("Character");
        lapahn.setColor("Red");
        lapahn.setCost(3);
        lapahn.setPower(3000);
        lapahn.setCounter(1000);
        lapahn.setAffiliations("Animal / Drum Kingdom");
        lapahn.setAttribute("Strike");
        lapahn.setEffect("[DON!!x2] [When Attacking] If your Leader has the {Drum Kingdom} type, K.O. up to 1 of your opponent's Characters with 4000 power or less.");
        lapahn.setImagePath("/images/cards/OP08/OP08-012.png");
        cardRepository.save(lapahn);

        Card robson = new Card();
        robson.setCardNumber("OP08-013");
        robson.setName("Robson");
        robson.setCardType("Character");
        robson.setColor("Red");
        robson.setCost(3);
        robson.setPower(4000);
        robson.setCounter(1000);
        robson.setAffiliations("Animal/Drum Kingdom");
        robson.setAttribute("Wisdom");
        robson.setEffect("[DON!!x2] This character gain [Rush] (This card can attack on the turn in which it is played.)");
        robson.setImagePath("/images/cards/OP08/OP08-013.png");
        cardRepository.save(robson);

        Card wapol = new Card();
        wapol.setCardNumber("OP08-014");
        wapol.setName("Wapol");
        wapol.setCardType("Character");
        wapol.setColor("Red");
        wapol.setCost(6);
        wapol.setPower(6000);
        wapol.setCounter(1000);
        wapol.setAffiliations("Drum Kingdom");
        wapol.setAttribute("Strike");
        wapol.setEffect("[DON!!x1] [When Attacking] Give up to one of your opponents characters -2000 power for this turn, then give this character +2000 power until the end of your opponents next turn.");
        wapol.setImagePath("/images/cards/OP08/OP08-014.png");
        cardRepository.save(wapol);

        Card drKureha = new Card();
        drKureha.setCardNumber("OP08-015");
        drKureha.setName("Dr. Kureha");
        drKureha.setCardType("Character");
        drKureha.setColor("Red");
        drKureha.setCost(1);
        drKureha.setPower(2000);
        drKureha.setCounter(1000);
        drKureha.setAffiliations("Drum Kingdom");
        drKureha.setAttribute("Wisdom");
        drKureha.setEffect("[On Play] Look at the top 4 cards of your deck, choose a {Tony Tony Chopper} or a card with the {Drum Kingdom} type except for Dr. Kureha and reveal it then add it to your hand. Then, put the remaining to the bottom of the deck in any order.");
        drKureha.setImagePath("/images/cards/OP08/OP08-015.png");
        cardRepository.save(drKureha);

        Card drHiriluk = new Card();
        drHiriluk.setCardNumber("OP08-016");
        drHiriluk.setName("Dr Hiriluk");
        drHiriluk.setCardType("Character");
        drHiriluk.setColor("Red");
        drHiriluk.setCost(3);
        drHiriluk.setPower(0);
        drHiriluk.setCounter(2000);
        drHiriluk.setAffiliations("Drum Kingdom");
        drHiriluk.setAttribute("Wisdom");
        drHiriluk.setEffect("[Activate: Main] You may rest this character: If your leader is [Tony Tony Chopper] give all of your [Tony Tony Chopper] characters +2000 power for the rest of the turn.");
        drHiriluk.setImagePath("/images/cards/OP08/OP08-016.png");
        cardRepository.save(drHiriluk);

        // Events
        Card idNeverShootYou = new Card();
        idNeverShootYou.setCardNumber("OP08-017");
        idNeverShootYou.setName("I'd never shoot you!!!!");
        idNeverShootYou.setCardType("Event");
        idNeverShootYou.setColor("Red");
        idNeverShootYou.setCost(2);
        idNeverShootYou.setAffiliations("Drum Kingdom");
        idNeverShootYou.setEffect("[Counter] Give up to 1 of your leaders or characters Power +4000 for the battle. Then, give up to 1 of your opponent's characters power -1000 for the turn.\\n[Trigger] Give up to one of your leaders or characters Power +1000 for the turn.");
        idNeverShootYou.setImagePath("/images/cards/OP08/OP08-017.png");
        cardRepository.save(idNeverShootYou);

        Card clovenHoofRoseo = new Card();
        clovenHoofRoseo.setCardNumber("OP08-018");
        clovenHoofRoseo.setName("Cloven Hoof (Roseo)");
        clovenHoofRoseo.setCardType("Event");
        clovenHoofRoseo.setColor("Red");
        clovenHoofRoseo.setCost(2);
        clovenHoofRoseo.setAffiliations("Animal / Drum Kingdom / Straw Hat Crew");
        clovenHoofRoseo.setEffect("[Activate: Main] Give up to three of your characters +1000 Power for the turn. And then, give up to one opponent's character -2000 Power for the turn.\\n[Trigger] Give up to one of your opponents leaders or characters -3000 Power during this turn.");
        clovenHoofRoseo.setImagePath("/images/cards/OP08/OP08-018.png");
        cardRepository.save(clovenHoofRoseo);

        Card bakuBakuShock = new Card();
        bakuBakuShock.setCardNumber("OP08-019");
        bakuBakuShock.setName("Baku Baku Shock");
        bakuBakuShock.setCardType("Event");
        bakuBakuShock.setColor("Red");
        bakuBakuShock.setCost(3);
        bakuBakuShock.setAffiliations("Drum Kingdom");
        bakuBakuShock.setEffect("[Main] / [Counter] Give up to 1 of your opponent's characters Power -3000 for the turn. Then, give up to 1 of your characters power +3000 for the turn.\\n[Trigger] KO up to 1 of your opponent's characters with 5000 Power or less.");
        bakuBakuShock.setImagePath("/images/cards/OP08/OP08-019.png");
        cardRepository.save(bakuBakuShock);

        // Stages
        Card drumKingdomStage = new Card();
        drumKingdomStage.setCardNumber("OP08-020");
        drumKingdomStage.setName("Drum Kingdom");
        drumKingdomStage.setCardType("Stage");
        drumKingdomStage.setColor("Red");
        drumKingdomStage.setCost(1);
        drumKingdomStage.setAffiliations("Drum Kingdom");
        drumKingdomStage.setEffect("[Opponent's Turn] Your [Drum Kingdom] type characters have Power +1000.");
        drumKingdomStage.setImagePath("/images/cards/OP08/OP08-020.png");
        cardRepository.save(drumKingdomStage);

        System.out.println("Finished initializing OP08 Red cards");
    }

    private void initializeOP08GreenCards() {
        System.out.println("Initializing OP08 Green cards...");

        // Leaders
        Card carrotLeader = new Card();
        carrotLeader.setCardNumber("OP08-021");
        carrotLeader.setName("Carrot");
        carrotLeader.setCardType("Leader");
        carrotLeader.setColor("Green");
        carrotLeader.setPower(5000);
        carrotLeader.setLife(5);
        carrotLeader.setAffiliations("Minks");
        carrotLeader.setAttribute("Special");
        carrotLeader.setEffect("[Activate: Main] [Once Per Turn] If you have a character with the {Minks} type in play, rest up to one of your opponents cost 5 or less characters.");
        carrotLeader.setImagePath("/images/cards/OP08/OP08-021.png");
        cardRepository.save(carrotLeader);

        // Characters
        Card inuarashiGreen = new Card();
        inuarashiGreen.setCardNumber("OP08-022");
        inuarashiGreen.setName("Inuarashi");
        inuarashiGreen.setCardType("Character");
        inuarashiGreen.setColor("Green");
        inuarashiGreen.setCost(5);
        inuarashiGreen.setPower(6000);
        inuarashiGreen.setCounter(1000);
        inuarashiGreen.setAffiliations("Minks/Akazaya Nine");
        inuarashiGreen.setAttribute("Slash");
        inuarashiGreen.setEffect("[On Play] If your leader has the \"Minks\" type, up to 2 of your opponent's rested cost 5 or lower characters cannot be set active during their next Refresh Phase.");
        inuarashiGreen.setImagePath("/images/cards/OP08/OP08-022.png");
        cardRepository.save(inuarashiGreen);

        Card carrotChar = new Card();
        carrotChar.setCardNumber("OP08-023");
        carrotChar.setName("Carrot");
        carrotChar.setCardType("Character");
        carrotChar.setColor("Green");
        carrotChar.setCost(5);
        carrotChar.setPower(6000);
        carrotChar.setCounter(1000);
        carrotChar.setAffiliations("Minks");
        carrotChar.setAttribute("Special");
        carrotChar.setEffect("[On Play] / [When Attacking] Up to one of your opponents rested cost 7 or less characters do not become active during its owners next refresh phase.");
        carrotChar.setImagePath("/images/cards/OP08/OP08-023.png");
        cardRepository.save(carrotChar);

        Card conslot = new Card();
        conslot.setCardNumber("OP08-024");
        conslot.setName("Conslot");
        conslot.setCardType("Character");
        conslot.setColor("Green");
        conslot.setCost(3);
        conslot.setPower(4000);
        conslot.setCounter(1000);
        conslot.setAffiliations("Minks");
        conslot.setAttribute("Slash");
        conslot.setEffect("[When Attacking] Up to 1 of your opponent's rested cost 4 or lower characters cannot be set active during their next Refresh Phase.");
        conslot.setImagePath("/images/cards/OP08/OP08-024.png");
        cardRepository.save(conslot);

        Card shishilian = new Card();
        shishilian.setCardNumber("OP08-025");
        shishilian.setName("Shishilian");
        shishilian.setCardType("Character");
        shishilian.setColor("Green");
        shishilian.setCost(3);
        shishilian.setPower(4000);
        shishilian.setCounter(1000);
        shishilian.setAffiliations("Minks");
        shishilian.setAttribute("Slash");
        shishilian.setEffect("[On Play] Up to 1 of your opponents rested cost 3 or lower characters cannot be set active during their next Refresh Phase.");
        shishilian.setImagePath("/images/cards/OP08/OP08-025.png");
        cardRepository.save(shishilian);

        Card joeBunny = new Card();
        joeBunny.setCardNumber("OP08-026");
        joeBunny.setName("Joe Bunny");
        joeBunny.setCardType("Character");
        joeBunny.setColor("Green");
        joeBunny.setCost(2);
        joeBunny.setPower(3000);
        joeBunny.setCounter(1000);
        joeBunny.setAffiliations("Minks");
        joeBunny.setAttribute("Slash");
        joeBunny.setEffect("[DON!!x1] [When Attacking] Up to 1 of your opponent's rested cost 1 or lower characters cannot be set active during their next Refresh Phase.");
        joeBunny.setImagePath("/images/cards/OP08/OP08-026.png");
        cardRepository.save(joeBunny);

        Card tristan = new Card();
        tristan.setCardNumber("OP08-027");
        tristan.setName("Tristan");
        tristan.setCardType("Character");
        tristan.setColor("Green");
        tristan.setCost(1);
        tristan.setPower(3000);
        tristan.setCounter(1000);
        tristan.setAffiliations("Minks");
        tristan.setAttribute("Wisdom");
        // No Effect
        tristan.setImagePath("/images/cards/OP08/OP08-027.png");
        cardRepository.save(tristan);

        Card nekomamushiGreen = new Card();
        nekomamushiGreen.setCardNumber("OP08-028");
        nekomamushiGreen.setName("Nekomamushi");
        nekomamushiGreen.setCardType("Character");
        nekomamushiGreen.setColor("Green");
        nekomamushiGreen.setCost(5);
        nekomamushiGreen.setPower(6000);
        nekomamushiGreen.setCounter(1000);
        nekomamushiGreen.setAffiliations("Minks/Akazaya Nine");
        nekomamushiGreen.setAttribute("Strike");
        nekomamushiGreen.setEffect("[On Play] If your opponent has 7 or more rested cards, this character gains [Rush]. (This card can attack on the turn in which it is played.)");
        nekomamushiGreen.setImagePath("/images/cards/OP08/OP08-028.png");
        cardRepository.save(nekomamushiGreen);

        Card pekoms = new Card();
        pekoms.setCardNumber("OP08-029");
        pekoms.setName("Pekoms");
        pekoms.setCardType("Character");
        pekoms.setColor("Green");
        pekoms.setCost(4);
        pekoms.setPower(6000);
        // No Counter
        pekoms.setAffiliations("Minks / Big Mom Pirates");
        pekoms.setAttribute("Strike");
        pekoms.setEffect("As long as this character is active, your cost 3 or less {Minks} type characters other than [Pekoms] cannot be KO'd by effects.");
        pekoms.setImagePath("/images/cards/OP08/OP08-029.png");
        cardRepository.save(pekoms);

        Card pedro = new Card();
        pedro.setCardNumber("OP08-030");
        pedro.setName("Pedro");
        pedro.setCardType("Character");
        pedro.setColor("Green");
        pedro.setCost(4);
        pedro.setPower(5000);
        pedro.setCounter(1000);
        pedro.setAffiliations("Minks");
        pedro.setAttribute("Slash");
        pedro.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[On K.O.] Choose 1 :\\n• Rest up to one of your opponents Don!!.\\n• KO up to one of your opponents rested cost 6 or lower characters.");
        pedro.setImagePath("/images/cards/OP08/OP08-030.png");
        cardRepository.save(pedro);

        Card miyagi = new Card();
        miyagi.setCardNumber("OP08-031");
        miyagi.setName("Miyagi");
        miyagi.setCardType("Character");
        miyagi.setColor("Green");
        miyagi.setCost(3);
        miyagi.setPower(1000);
        miyagi.setCounter(1000);
        miyagi.setAffiliations("Minks");
        miyagi.setAttribute("Wisdom");
        miyagi.setEffect("[On Play] Set up to 1 of your cost 2 or lower \"Minks\" type characters active.");
        miyagi.setImagePath("/images/cards/OP08/OP08-031.png");
        cardRepository.save(miyagi);

        Card milky = new Card();
        milky.setCardNumber("OP08-032");
        milky.setName("Milky");
        milky.setCardType("Character");
        milky.setColor("Green");
        milky.setCost(2);
        milky.setPower(0);
        milky.setCounter(2000);
        milky.setAffiliations("Minks");
        milky.setAttribute("Wisdom");
        milky.setEffect("[Activate: Main] You may rest this character: If your leader has the \"Minks\" type, set up to 1 of your rested DON!! active.");
        milky.setImagePath("/images/cards/OP08/OP08-032.png");
        cardRepository.save(milky);

        Card rody = new Card();
        rody.setCardNumber("OP08-033");
        rody.setName("Rody");
        rody.setCardType("Character");
        rody.setColor("Green");
        rody.setCost(1);
        rody.setPower(2000);
        rody.setCounter(1000);
        rody.setAffiliations("Minks");
        rody.setAttribute("Slash");
        rody.setEffect("[On Play] If your leader has the \"Minks\" type, and your opponent has 7 or more rested cards, KO up to one of your opponent's cost 2 or lower characters.");
        rody.setImagePath("/images/cards/OP08/OP08-033.png");
        cardRepository.save(rody);

        Card wanda = new Card();
        wanda.setCardNumber("OP08-034");
        wanda.setName("Wanda");
        wanda.setCardType("Character");
        wanda.setColor("Green");
        wanda.setCost(1);
        wanda.setPower(2000);
        wanda.setCounter(1000);
        wanda.setAffiliations("Minks");
        wanda.setAttribute("Slash");
        wanda.setEffect("[On Play] Look at 5 cards from the top of your deck; reveal up to 1 {Minks} type card other than [Wanda] and add it to your hand. Then, place the rest at the bottom of your deck in any order.");
        wanda.setImagePath("/images/cards/OP08/OP08-034.png");
        cardRepository.save(wanda);

        Card bb = new Card();
        bb.setCardNumber("OP08-035");
        bb.setName("BB");
        bb.setCardType("Character");
        bb.setColor("Green");
        bb.setCost(2);
        bb.setPower(4000);
        bb.setCounter(1000);
        bb.setAffiliations("Minks");
        bb.setAttribute("Strike");
        // No Effect
        bb.setImagePath("/images/cards/OP08/OP08-035.png");
        cardRepository.save(bb);

        // Events
        Card electricalLuna = new Card();
        electricalLuna.setCardNumber("OP08-036");
        electricalLuna.setName("Electrical Luna");
        electricalLuna.setCardType("Event");
        electricalLuna.setColor("Green");
        electricalLuna.setCost(3);
        electricalLuna.setAffiliations("Minks");
        electricalLuna.setEffect("[Main] All of your opponent's rested characters with a cost of 7 or less do not become active during your opponent's next refresh phase.\\n[Trigger] Rest up to one of your opponent's characters.");
        electricalLuna.setImagePath("/images/cards/OP08/OP08-036.png");
        cardRepository.save(electricalLuna);

        Card garchu = new Card();
        garchu.setCardNumber("OP08-037");
        garchu.setName("Garchu");
        garchu.setCardType("Event");
        garchu.setColor("Green");
        garchu.setCost(1);
        garchu.setAffiliations("Minks");
        garchu.setEffect("[Main] You may rest 1 of your \"Minks\" characters: Rest up to 1 of your opponent's characters.\\n[Trigger] Draw 1 card.");
        garchu.setImagePath("/images/cards/OP08/OP08-037.png");
        cardRepository.save(garchu);

        Card weWontGiveOurFriendsUp = new Card();
        weWontGiveOurFriendsUp.setCardNumber("OP08-038");
        weWontGiveOurFriendsUp.setName("We won't give our friends up to our enemies!!!");
        weWontGiveOurFriendsUp.setCardType("Event");
        weWontGiveOurFriendsUp.setColor("Green");
        weWontGiveOurFriendsUp.setCost(1);
        weWontGiveOurFriendsUp.setAffiliations("Minks/Akazaya Nine");
        weWontGiveOurFriendsUp.setEffect("[Main] You may rest 2 of your characters: Until the end of your opponent's next turn, all your characters cannot be KO'd by your opponent's effects.\\n[Trigger] KO up to 1 of your opponent's rested cost 3 or lower characters.");
        weWontGiveOurFriendsUp.setImagePath("/images/cards/OP08/OP08-038.png");
        cardRepository.save(weWontGiveOurFriendsUp);

        // Stages
        Card zou = new Card();
        zou.setCardNumber("OP08-039");
        zou.setName("Zou");
        zou.setCardType("Stage");
        zou.setColor("Green");
        zou.setCost(3);
        zou.setAffiliations("Animal");
        zou.setEffect("[Activate: Main] You may rest this stage: If your leader has the {Minks} type, set up to one of your Don!! as active.\\n[End of Your Turn] Set up to one of your {Minks} type characters as active.");
        zou.setImagePath("/images/cards/OP08/OP08-039.png");
        cardRepository.save(zou);

        System.out.println("Finished initializing OP08 Green cards");
    }

    private void initializeOP08BlueCards() {
        System.out.println("Initializing OP08 Blue cards...");

        // Characters
        Card atmos = new Card();
        atmos.setCardNumber("OP08-040");
        atmos.setName("Atmos");
        atmos.setCardType("Character");
        atmos.setColor("Blue");
        atmos.setCost(4);
        atmos.setPower(5000);
        atmos.setCounter(1000);
        atmos.setAffiliations("Whitebeard Pirates");
        atmos.setAttribute("Slash");
        atmos.setEffect("[On Play] You may reveal 2 cards with a type including \"Whitebeard Pirates\" from your hand: If your Leader's type includes \"Whitebeard Pirates\", return up to 1 of your opponent's Characters with a cost of 4 or less to the owner's hand.");
        atmos.setImagePath("/images/cards/OP08/OP08-040.png");
        cardRepository.save(atmos);

        Card aphelandra = new Card();
        aphelandra.setCardNumber("OP08-041");
        aphelandra.setName("Aphelandra");
        aphelandra.setCardType("Character");
        aphelandra.setColor("Blue");
        aphelandra.setCost(3);
        aphelandra.setPower(4000);
        aphelandra.setCounter(2000);
        aphelandra.setAffiliations("Amazon Lily");
        aphelandra.setAttribute("Slash");
        aphelandra.setEffect("[Activate: Main] You may return this Character to the owner's hand: If your Leader has the {Amazon Lily} type, place up to 1 Character with a cost of 1 or less at the bottom of the owner's deck.");
        aphelandra.setImagePath("/images/cards/OP08/OP08-041.png");
        cardRepository.save(aphelandra);

        Card edwardWeevilBlue = new Card();
        edwardWeevilBlue.setCardNumber("OP08-042");
        edwardWeevilBlue.setName("Edward Weevil");
        edwardWeevilBlue.setCardType("Character");
        edwardWeevilBlue.setColor("Blue");
        edwardWeevilBlue.setCost(4);
        edwardWeevilBlue.setPower(5000);
        edwardWeevilBlue.setCounter(1000);
        edwardWeevilBlue.setAffiliations("The Seven Warlords of the Sea");
        edwardWeevilBlue.setAttribute("Slash");
        edwardWeevilBlue.setEffect("[DON!!x1] [When Attacking] Return up to 1 Character with a cost of 3 or less to the owner's hand.");
        edwardWeevilBlue.setImagePath("/images/cards/OP08/OP08-042.png");
        cardRepository.save(edwardWeevilBlue);

        Card edwardNewgate = new Card();
        edwardNewgate.setCardNumber("OP08-043");
        edwardNewgate.setName("Edward.Newgate");
        edwardNewgate.setCardType("Character");
        edwardNewgate.setColor("Blue");
        edwardNewgate.setCost(10);
        edwardNewgate.setPower(12000);
        // No Counter
        edwardNewgate.setAffiliations("The Four Emperors/Whitebeard Pirates");
        edwardNewgate.setAttribute("Special");
        edwardNewgate.setEffect("[On Play] If your Leader's type includes \"Whitebeard Pirates\" and you have 2 or less Life cards, until the end of your opponent's next turn all of your opponent's Characters cannot attack unless they first discard 2 cards from their hand.");
        edwardNewgate.setImagePath("/images/cards/OP08/OP08-043.png");
        cardRepository.save(edwardNewgate);

        Card kingdew = new Card();
        kingdew.setCardNumber("OP08-044");
        kingdew.setName("Kingdew");
        kingdew.setCardType("Character");
        kingdew.setColor("Blue");
        kingdew.setCost(4);
        kingdew.setPower(4000);
        kingdew.setCounter(2000);
        kingdew.setAffiliations("Whitebeard Pirates");
        kingdew.setAttribute("Strike");
        kingdew.setEffect("[Activate: Main] [Once Per Turn] You may reveal 2 cards with {Whitebeard Pirates} included in their types from your hand: This character gains +2000 power until end of turn.");
        kingdew.setImagePath("/images/cards/OP08/OP08-044.png");
        cardRepository.save(kingdew);

        Card thatch = new Card();
        thatch.setCardNumber("OP08-045");
        thatch.setName("Thatch");
        thatch.setCardType("Character");
        thatch.setColor("Blue");
        thatch.setCost(4);
        thatch.setPower(5000);
        thatch.setCounter(1000);
        thatch.setAffiliations("Whitebeard Pirates");
        thatch.setAttribute("Slash");
        thatch.setEffect("If this character were to be KOd, or removed from play by your opponents effect, you may instead place this character into the trash, and then draw one card.");
        thatch.setImagePath("/images/cards/OP08/OP08-045.png");
        cardRepository.save(thatch);

        Card shakuyaku = new Card();
        shakuyaku.setCardNumber("OP08-046");
        shakuyaku.setName("Shakuyaku");
        shakuyaku.setCardType("Character");
        shakuyaku.setColor("Blue");
        shakuyaku.setCost(5);
        shakuyaku.setPower(6000);
        shakuyaku.setCounter(1000);
        shakuyaku.setAffiliations("Amazon Lily");
        shakuyaku.setAttribute("Wisdom");
        shakuyaku.setEffect("[Your Turn] [Once Per Turn] When a character leaves play from one of your effects, if your opponent has 5 or more cards in hand, they place 1 card from their hand on the bottom of their deck. Then, rest this character.");
        shakuyaku.setImagePath("/images/cards/OP08/OP08-046.png");
        cardRepository.save(shakuyaku);

        Card jozu = new Card();
        jozu.setCardNumber("OP08-047");
        jozu.setName("Jozu");
        jozu.setCardType("Character");
        jozu.setColor("Blue");
        jozu.setCost(6);
        jozu.setPower(7000);
        jozu.setCounter(1000);
        jozu.setAffiliations("Whitebeard Pirates");
        jozu.setAttribute("Strike");
        jozu.setEffect("[On Play] You may return one of your characters other than this card to your hand: Return up to one cost 6 or lower character to the original owners hand.");
        jozu.setImagePath("/images/cards/OP08/OP08-047.png");
        cardRepository.save(jozu);

        Card sweetPea = new Card();
        sweetPea.setCardNumber("OP08-048");
        sweetPea.setName("Sweet Pea");
        sweetPea.setCardType("Character");
        sweetPea.setColor("Blue");
        sweetPea.setCost(4);
        sweetPea.setPower(6000);
        sweetPea.setCounter(1000);
        sweetPea.setAffiliations("amazon lily");
        sweetPea.setAttribute("Strike");
        // No Effect
        sweetPea.setImagePath("/images/cards/OP08/OP08-048.png");
        cardRepository.save(sweetPea);

        Card speedGill = new Card();
        speedGill.setCardNumber("OP08-049");
        speedGill.setName("Speed Gill");
        speedGill.setCardType("Character");
        speedGill.setColor("Blue");
        speedGill.setCost(4);
        speedGill.setPower(5000);
        speedGill.setCounter(1000);
        speedGill.setAffiliations("Whitebeard Pirates");
        speedGill.setAttribute("Slash");
        speedGill.setEffect("[On Play] Reveal the top card of your deck, then place it on the top or bottom of your deck. If that card had {Whitebeard Pirates} included in its type, this character gains [Rush] this turn.");
        speedGill.setImagePath("/images/cards/OP08/OP08-049.png");
        cardRepository.save(speedGill);

        Card namule = new Card();
        namule.setCardNumber("OP08-050");
        namule.setName("Namule");
        namule.setCardType("Character");
        namule.setColor("Blue");
        namule.setCost(3);
        namule.setPower(2000);
        // No Counter
        namule.setAffiliations("Fish-man / Whitebeard Pirates");
        namule.setAttribute("Strike");
        namule.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[On Play] Draw two cards, then return two cards from your hand to the top or bottom of the deck in the order of your choice.");
        namule.setImagePath("/images/cards/OP08/OP08-050.png");
        cardRepository.save(namule);

        Card buckinBlue = new Card();
        buckinBlue.setCardNumber("OP08-051");
        buckinBlue.setName("Buckin");
        buckinBlue.setCardType("Character");
        buckinBlue.setColor("Blue");
        buckinBlue.setCost(1);
        buckinBlue.setPower(2000);
        buckinBlue.setCounter(1000);
        buckinBlue.setAffiliations("Former Rocks Pirates");
        buckinBlue.setAttribute("Wisdom");
        buckinBlue.setEffect("[Your Turn] [On Play] Up to 1 of your [Edward Weevil] cards gains +2000 power during this turn.");
        buckinBlue.setImagePath("/images/cards/OP08/OP08-051.png");
        cardRepository.save(buckinBlue);

        Card portgasDAceBlue = new Card();
        portgasDAceBlue.setCardNumber("OP08-052");
        portgasDAceBlue.setName("Portgas .D. Ace");
        portgasDAceBlue.setCardType("Character");
        portgasDAceBlue.setColor("Blue");
        portgasDAceBlue.setCost(5);
        portgasDAceBlue.setPower(6000);
        portgasDAceBlue.setCounter(1000);
        portgasDAceBlue.setAffiliations("Whitebeard Pirates");
        portgasDAceBlue.setAttribute("Special");
        portgasDAceBlue.setEffect("[On Play] Reveal the top 1 card of your deck, you may put into play up to 1 character with the type [Whitebeard Pirates] and a cost of 4 or less. After this, return the remaining cards to the top or bottom of the deck.");
        portgasDAceBlue.setImagePath("/images/cards/OP08/OP08-052.png");
        cardRepository.save(portgasDAceBlue);

        // Events
        Card thankYouForLovingMe = new Card();
        thankYouForLovingMe.setCardNumber("OP08-053");
        thankYouForLovingMe.setName("Thank you... For Loving me!!!");
        thankYouForLovingMe.setCardType("Event");
        thankYouForLovingMe.setColor("Blue");
        thankYouForLovingMe.setCost(1);
        thankYouForLovingMe.setAffiliations("Whitebeard Pirates");
        thankYouForLovingMe.setEffect("[Main] If your leader's type includes {Whitebeard Pirates} in it, look at the top 3 cards of your deck, reveal up to one card with {Whitebeard Pirates} included in its types, or [Monkey D. Luffy] and put it into your hand. Then, place the rest of the cards on the top or bottom of your deck in any order.\\n[Trigger] Draw 1 card.");
        thankYouForLovingMe.setImagePath("/images/cards/OP08/OP08-053.png");
        cardRepository.save(thankYouForLovingMe);

        Card youCantTakeOurKing = new Card();
        youCantTakeOurKing.setCardNumber("OP08-054");
        youCantTakeOurKing.setName("You Can't Take Our King This Early On");
        youCantTakeOurKing.setCardType("Event");
        youCantTakeOurKing.setColor("Blue");
        youCantTakeOurKing.setCost(3);
        youCantTakeOurKing.setAffiliations("Whitebeard Pirates");
        youCantTakeOurKing.setEffect("[Counter] Give your leader or up to one of your characters +3000 power for this battle. Then, reveal the top card of your deck and play up to one cost 3 or less character with {Whitebeard Pirates} included in its types. Place the remaining on the top or bottom of your deck.");
        youCantTakeOurKing.setImagePath("/images/cards/OP08/OP08-054.png");
        cardRepository.save(youCantTakeOurKing);

        Card phoenixBrand = new Card();
        phoenixBrand.setCardNumber("OP08-055");
        phoenixBrand.setName("Phoenix Brand");
        phoenixBrand.setCardType("Event");
        phoenixBrand.setColor("Blue");
        phoenixBrand.setCost(4);
        phoenixBrand.setAffiliations("Former Whitebeard Pirates");
        phoenixBrand.setEffect("[Main] You may reveal two cards that include {Whitebeard Pirates} typing from your hand: Place up to one cost 6 or lower character on the bottom of its owner's deck.");
        phoenixBrand.setImagePath("/images/cards/OP08/OP08-055.png");
        cardRepository.save(phoenixBrand);

        System.out.println("Finished initializing OP08 Blue cards");
    }

    private void initializeOP08PurpleCards() {
        System.out.println("Initializing OP08 Purple cards...");

        // Leaders
        Card kingLeader = new Card();
        kingLeader.setCardNumber("OP08-057");
        kingLeader.setName("King");
        kingLeader.setCardType("Leader");
        kingLeader.setColor("Purple");
        kingLeader.setPower(5000);
        kingLeader.setLife(4);
        kingLeader.setAffiliations("Animal Kingdom Pirates");
        kingLeader.setAttribute("Special");
        kingLeader.setEffect("[Activate: Main] [Once Per Turn] Don!!-2: Choose one:\\n• If your hand is 5 or less cards, draw 1 card.\\n• Give up to one of your opponents characters -2 cost this turn.");
        kingLeader.setImagePath("/images/cards/OP08/OP08-057.png");
        cardRepository.save(kingLeader);

        Card charlottePuddingLeader = new Card();
        charlottePuddingLeader.setCardNumber("OP08-058");
        charlottePuddingLeader.setName("Charlotte Pudding");
        charlottePuddingLeader.setCardType("Leader");
        charlottePuddingLeader.setColor("Purple/Yellow"); // Dual Color
        charlottePuddingLeader.setPower(5000);
        charlottePuddingLeader.setLife(4);
        charlottePuddingLeader.setAffiliations("Big Mom Pirates");
        charlottePuddingLeader.setAttribute("Wisdom");
        charlottePuddingLeader.setEffect("[When Attacking] You may turn the top 2 life cards of your life face up: Add up to one Don!! card from your Don!! deck as rested.");
        charlottePuddingLeader.setImagePath("/images/cards/OP08/OP08-058.png");
        cardRepository.save(charlottePuddingLeader);

        // Characters
        Card arbel = new Card();
        arbel.setCardNumber("OP08-059");
        arbel.setName("Arbel");
        arbel.setCardType("Character");
        arbel.setColor("Purple");
        arbel.setCost(4);
        arbel.setPower(5000);
        arbel.setCounter(1000);
        arbel.setAffiliations("Lunarian / Animal Kingdom Pirates");
        arbel.setAttribute("Special");
        arbel.setEffect("[Activate: Main] You may place this character in your trash: If your leader has the {Animal Kingdom Pirates} type and you have 10 Don!!, play up to one cost 7 or less [King] from your hand.");
        arbel.setImagePath("/images/cards/OP08/OP08-059.png");
        cardRepository.save(arbel);

        Card kingPurple = new Card();
        kingPurple.setCardNumber("OP08-060");
        kingPurple.setName("King");
        kingPurple.setCardType("Character");
        kingPurple.setColor("Purple");
        kingPurple.setCost(7);
        kingPurple.setPower(8000);
        // No Counter
        kingPurple.setAffiliations("Animal Kingdom Pirates");
        kingPurple.setAttribute("Special");
        kingPurple.setEffect("[On Play] DON!!-1: If your opponent has 5 or more DON!! cards on their field, this Character gains [Rush] until the end of the turn.");
        kingPurple.setImagePath("/images/cards/OP08/OP08-060.png");
        cardRepository.save(kingPurple);

        Card charlotteOven = new Card();
        charlotteOven.setCardNumber("OP08-061");
        charlotteOven.setName("Charlotte Oven");
        charlotteOven.setCardType("Character");
        charlotteOven.setColor("Purple");
        charlotteOven.setCost(5);
        charlotteOven.setPower(6000);
        charlotteOven.setCounter(1000);
        charlotteOven.setAffiliations("Big Mom Pirates");
        charlotteOven.setAttribute("Special");
        charlotteOven.setEffect("[When Attacking] DON!!-1: KO up to 1 of your opponent's cost 3 or lower characters.");
        charlotteOven.setImagePath("/images/cards/OP08/OP08-061.png");
        cardRepository.save(charlotteOven);

        Card charlotteKatakuriSmall = new Card();
        charlotteKatakuriSmall.setCardNumber("OP08-062");
        charlotteKatakuriSmall.setName("Charlotte Katakuri");
        charlotteKatakuriSmall.setCardType("Character");
        charlotteKatakuriSmall.setColor("Purple");
        charlotteKatakuriSmall.setCost(2);
        charlotteKatakuriSmall.setPower(3000);
        charlotteKatakuriSmall.setCounter(1000);
        charlotteKatakuriSmall.setAffiliations("Big Mom Pirates");
        charlotteKatakuriSmall.setAttribute("Strike");
        charlotteKatakuriSmall.setEffect("[Activate: Main] You may trash this character: If your leader has the {Big Mom Pirates} type, play up to one [Charlotte Katakuri] from your hand that has a cost of 3 or greater and a cost less than or equal to the number of Don!! your opponent has.");
        charlotteKatakuriSmall.setImagePath("/images/cards/OP08/OP08-062.png");
        cardRepository.save(charlotteKatakuriSmall);

        Card charlotteKatakuri = new Card();
        charlotteKatakuri.setCardNumber("OP08-063");
        charlotteKatakuri.setName("Charlotte Katakuri");
        charlotteKatakuri.setCardType("Character");
        charlotteKatakuri.setColor("Purple");
        charlotteKatakuri.setCost(6);
        charlotteKatakuri.setPower(7000);
        charlotteKatakuri.setCounter(1000);
        charlotteKatakuri.setAffiliations("Big Mom Pirates");
        charlotteKatakuri.setAttribute("Strike");
        charlotteKatakuri.setEffect("[On Play] You may flip the top card of your Life facedown: Add up to 1 DON!! card from your DON!! deck and set it as active.");
        charlotteKatakuri.setImagePath("/images/cards/OP08/OP08-063.png");
        cardRepository.save(charlotteKatakuri);

        Card charlotteCracker = new Card();
        charlotteCracker.setCardNumber("OP08-064");
        charlotteCracker.setName("Charlotte Cracker");
        charlotteCracker.setCardType("Character");
        charlotteCracker.setColor("Purple");
        charlotteCracker.setCost(4);
        charlotteCracker.setPower(5000);
        charlotteCracker.setCounter(1000);
        charlotteCracker.setAffiliations("Big Mom Pirates");
        charlotteCracker.setAttribute("Slash");
        charlotteCracker.setEffect("[Activate: Main] [Once Per Turn] Don!! -1: Play up to one [Cracker Soldier] from your hand.");
        charlotteCracker.setImagePath("/images/cards/OP08/OP08-064.png");
        cardRepository.save(charlotteCracker);

        Card charlotteSmoothie = new Card();
        charlotteSmoothie.setCardNumber("OP08-065");
        charlotteSmoothie.setName("charlotte smoothie");
        charlotteSmoothie.setCardType("Character");
        charlotteSmoothie.setColor("Purple");
        charlotteSmoothie.setCost(7);
        charlotteSmoothie.setPower(9000);
        charlotteSmoothie.setCounter(1000);
        charlotteSmoothie.setAffiliations("Big Mom Pirates");
        charlotteSmoothie.setAttribute("Special");
        // No Effect
        charlotteSmoothie.setImagePath("/images/cards/OP08/OP08-065.png");
        cardRepository.save(charlotteSmoothie);

        Card charlotteBrulee = new Card();
        charlotteBrulee.setCardNumber("OP08-066");
        charlotteBrulee.setName("Charlotte Brulee");
        charlotteBrulee.setCardType("Character");
        charlotteBrulee.setColor("Purple");
        charlotteBrulee.setCost(4);
        charlotteBrulee.setPower(1000);
        charlotteBrulee.setCounter(1000);
        charlotteBrulee.setAffiliations("Big Mom Pirates");
        charlotteBrulee.setAttribute("Special");
        charlotteBrulee.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[On K.O.] Add up to 1 DON!! from your DON!! deck rested.");
        charlotteBrulee.setImagePath("/images/cards/OP08/OP08-066.png");
        cardRepository.save(charlotteBrulee);

        Card charlottePuddingPurple = new Card();
        charlottePuddingPurple.setCardNumber("OP08-067");
        charlottePuddingPurple.setName("Charlotte Pudding");
        charlottePuddingPurple.setCardType("Character");
        charlottePuddingPurple.setColor("Purple");
        charlottePuddingPurple.setCost(3);
        charlottePuddingPurple.setPower(4000);
        charlottePuddingPurple.setCounter(1000);
        charlottePuddingPurple.setAffiliations("Big Mom Pirates");
        charlottePuddingPurple.setAttribute("Wisdom");
        charlottePuddingPurple.setEffect("[Your Turn] [Once Per Turn] When your Don!! is returned to your Don!! deck, set up to one Don!! from your Don!! deck onto your field as rested.");
        charlottePuddingPurple.setImagePath("/images/cards/OP08/OP08-067.png");
        cardRepository.save(charlottePuddingPurple);

        Card charlottePerosperoPurple = new Card();
        charlottePerosperoPurple.setCardNumber("OP08-068");
        charlottePerosperoPurple.setName("Charlotte Perospero");
        charlottePerosperoPurple.setCardType("Character");
        charlottePerosperoPurple.setColor("Purple");
        charlottePerosperoPurple.setCost(3);
        charlottePerosperoPurple.setPower(5000);
        // No Counter
        charlottePerosperoPurple.setAffiliations("Big Mom Pirates");
        charlottePerosperoPurple.setAttribute("Special");
        charlottePerosperoPurple.setEffect("[On K.O.] Set up to one Don!! from your Don!! deck as rested.\\n[Trigger] Don!! -1: (You may return the specified number of DON!! cards from your field to your DON!! deck): Play this card.");
        charlottePerosperoPurple.setImagePath("/images/cards/OP08/OP08-068.png");
        cardRepository.save(charlottePerosperoPurple);

        Card charlotteLinlin = new Card();
        charlotteLinlin.setCardNumber("OP08-069");
        charlotteLinlin.setName("Charlotte Linlin");
        charlotteLinlin.setCardType("Character");
        charlotteLinlin.setColor("Purple");
        charlotteLinlin.setCost(9);
        charlotteLinlin.setPower(9000);
        // No Counter
        charlotteLinlin.setAffiliations("Former Rocks Pirates / Big Mom Pirates");
        charlotteLinlin.setAttribute("Special");
        charlotteLinlin.setEffect("[On Play] Don!! -1: trash 1 card from your hand: Add up to 1 card from the top of your deck to the top of your life. Then, place up to one of your opponents characters with a cost of 6 or less to the top or bottom of its owner's life face up.");
        charlotteLinlin.setImagePath("/images/cards/OP08/OP08-069.png");
        cardRepository.save(charlotteLinlin);

        Card baronTamago = new Card();
        baronTamago.setCardNumber("OP08-070");
        baronTamago.setName("Baron Tamago");
        baronTamago.setCardType("Character");
        baronTamago.setColor("Purple");
        baronTamago.setCost(3);
        baronTamago.setPower(4000);
        baronTamago.setCounter(1000);
        baronTamago.setAffiliations("Big Mom Pirates");
        baronTamago.setAttribute("Strike");
        baronTamago.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[On K.O.] DON!! -1: Play up to 1 [Vicsount Hiyoko] with a cost of 5 or less from your hand.");
        baronTamago.setImagePath("/images/cards/OP08/OP08-070.png");
        cardRepository.save(baronTamago);

        Card countNiwatori = new Card();
        countNiwatori.setCardNumber("OP08-071");
        countNiwatori.setName("Count Niwatori");
        countNiwatori.setCardType("Character");
        countNiwatori.setColor("Purple");
        countNiwatori.setCost(6);
        countNiwatori.setPower(7000);
        countNiwatori.setCounter(1000);
        countNiwatori.setAffiliations("Big Mom Pirates");
        countNiwatori.setAttribute("Strike");
        countNiwatori.setEffect("[Opponent's Turn] [On K.O.] DON!! -1: Play up to 1 [Baron Tamago] with a cost of 4 or less from your deck, then shuffle your deck.");
        countNiwatori.setImagePath("/images/cards/OP08/OP08-071.png");
        cardRepository.save(countNiwatori);

        Card crackerSoldier = new Card();
        crackerSoldier.setCardNumber("OP08-072");
        crackerSoldier.setName("Cracker Soldier");
        crackerSoldier.setCardType("Character");
        crackerSoldier.setColor("Purple");
        crackerSoldier.setCost(5);
        crackerSoldier.setPower(5000);
        crackerSoldier.setCounter(1000);
        crackerSoldier.setAffiliations("Big Mom Pirates");
        crackerSoldier.setAttribute("Slash");
        crackerSoldier.setEffect("Per the rules, you may have any number of this card included in your deck.\\n[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        crackerSoldier.setImagePath("/images/cards/OP08/OP08-072.png");
        cardRepository.save(crackerSoldier);

        Card viscountHiyoko = new Card();
        viscountHiyoko.setCardNumber("OP08-073");
        viscountHiyoko.setName("Viscount Hiyoko");
        viscountHiyoko.setCardType("Character");
        viscountHiyoko.setColor("Purple");
        viscountHiyoko.setCost(5);
        viscountHiyoko.setPower(6000);
        viscountHiyoko.setCounter(1000);
        viscountHiyoko.setAffiliations("Big Mom Pirates");
        viscountHiyoko.setAttribute("Strike");
        viscountHiyoko.setEffect("[Opponent's Turn] [On K.O.] DON!! -1: Play up to 1 [Count Niwatori] with a cost of 6 or less from your deck, then shuffle your deck.");
        viscountHiyoko.setImagePath("/images/cards/OP08/OP08-073.png");
        cardRepository.save(viscountHiyoko);

        Card blackMariaPurple = new Card();
        blackMariaPurple.setCardNumber("OP08-074");
        blackMariaPurple.setName("Black Maria");
        blackMariaPurple.setCardType("Character");
        blackMariaPurple.setColor("Purple");
        blackMariaPurple.setCost(3);
        blackMariaPurple.setPower(2000);
        blackMariaPurple.setCounter(2000);
        blackMariaPurple.setAffiliations("Animal Kingdom Pirates");
        blackMariaPurple.setAttribute("Special");
        blackMariaPurple.setEffect("[Activate: Main] [Once Per Turn] If you have no other [Black Maria], add up to 5 DON!! cards from your DON!! deck rested. Then at the end of your turn, return DON!! cards from your field to the DON!! deck until the number of DON!! cards on your field is equal to the number on your opponent's field.");
        blackMariaPurple.setImagePath("/images/cards/OP08/OP08-074.png");
        cardRepository.save(blackMariaPurple);

        // Events
        Card candyMaiden = new Card();
        candyMaiden.setCardNumber("OP08-075");
        candyMaiden.setName("Candy Maiden");
        candyMaiden.setCardType("Event");
        candyMaiden.setColor("Purple");
        candyMaiden.setCost(1);
        candyMaiden.setAffiliations("Big Mom Pirates");
        candyMaiden.setEffect("[Main] DON!!-1: Rest up to 1 of your opponent's Characters with a cost of 2 or less. Then, turn all of your Life cards face-down.\\n[Trigger] Add up to 1 DON!! card from your DON!! deck and set it as active.");
        candyMaiden.setImagePath("/images/cards/OP08/OP08-075.png");
        cardRepository.save(candyMaiden);

        Card itsToDieFor = new Card();
        itsToDieFor.setCardNumber("OP08-076");
        itsToDieFor.setName("It's to die for ♡");
        itsToDieFor.setCardType("Event");
        itsToDieFor.setColor("Purple");
        itsToDieFor.setCost(3);
        itsToDieFor.setAffiliations("The Four Emperors / Big Mom Pirates");
        itsToDieFor.setEffect("[Main] Add up to 1 DON!! card from your DON!! deck and set it as active. Then, if your opponent has a Character with 6000 power or more in play, add up to 1 DON!! card from your DON!! deck and set it as active.\\n[Trigger] Add up to 1 DON!! card from your DON!! deck and set it as active.");
        itsToDieFor.setImagePath("/images/cards/OP08/OP08-076.png");
        cardRepository.save(itsToDieFor);

        Card hakaiOceanSovereignty = new Card();
        hakaiOceanSovereignty.setCardNumber("OP08-077");
        hakaiOceanSovereignty.setName("Hakai Ocean Sovereignty");
        hakaiOceanSovereignty.setCardType("Event");
        hakaiOceanSovereignty.setColor("Purple");
        hakaiOceanSovereignty.setCost(6);
        hakaiOceanSovereignty.setAffiliations("Four Emperors / Animal Kingdom Pirates / Big Mom Pirates");
        hakaiOceanSovereignty.setEffect("[Main] Don!!-2: If your leader's type has {Animal Kingdom Pirates} or {Big Mom Pirates} in it, KO up to two of your opponents cost 6 or lower characters.");
        hakaiOceanSovereignty.setImagePath("/images/cards/OP08/OP08-077.png");
        cardRepository.save(hakaiOceanSovereignty);

        System.out.println("Finished initializing OP08 Purple cards");
    }

    private void initializeOP08BlackCards() {
        System.out.println("Initializing OP08 Black cards...");

        // Characters
        Card ultiBlack = new Card();
        ultiBlack.setCardNumber("OP08-078");
        ultiBlack.setName("Ulti");
        ultiBlack.setCardType("Character");
        ultiBlack.setColor("Black");
        ultiBlack.setCost(4);
        ultiBlack.setPower(6000);
        ultiBlack.setCounter(1000);
        ultiBlack.setAffiliations("Animal Kingdom Pirates");
        ultiBlack.setAttribute("Strike");
        // No specific effect
        ultiBlack.setImagePath("/images/cards/OP08/OP08-078.png");
        cardRepository.save(ultiBlack);

        Card kaidoBlack = new Card();
        kaidoBlack.setCardNumber("OP08-079");
        kaidoBlack.setName("Kaido");
        kaidoBlack.setCardType("Character");
        kaidoBlack.setColor("Black");
        kaidoBlack.setCost(9);
        kaidoBlack.setPower(9000);
        // No Counter
        kaidoBlack.setAffiliations("Former Rocks Pirate/Animal Kingdom Pirates");
        kaidoBlack.setAttribute("Strike");
        kaidoBlack.setEffect("[Activate: Main] [Once Per Turn] You may discard one card from your hand: if this character was played this turn, place up to 1 of your opponent's 7 cost or lower characters in the trash. Then, your opponent discards 1 card from their hand.");
        kaidoBlack.setImagePath("/images/cards/OP08/OP08-079.png");
        cardRepository.save(kaidoBlack);

        Card queenBlack = new Card();
        queenBlack.setCardNumber("OP08-080");
        queenBlack.setName("Queen");
        queenBlack.setCardType("Character");
        queenBlack.setColor("Black");
        queenBlack.setCost(1);
        queenBlack.setPower(2000);
        queenBlack.setCounter(1000);
        queenBlack.setAffiliations("Animal Kingdom Pirates");
        queenBlack.setAttribute("Strike");
        queenBlack.setEffect("[On Play] Look at the top 5 cards of your deck, choose a <Animal Kingdom Pirates> except for Queen and add it to your hand, put the remaining to the bottom of the deck in any order.");
        queenBlack.setImagePath("/images/cards/OP08/OP08-080.png");
        cardRepository.save(queenBlack);

        Card guernica = new Card();
        guernica.setCardNumber("OP08-081");
        guernica.setName("Guernica");
        guernica.setCardType("Character");
        guernica.setColor("Black");
        guernica.setCost(1);
        guernica.setPower(2000);
        guernica.setCounter(1000);
        guernica.setAffiliations("CP0");
        guernica.setAttribute("Strike");
        guernica.setEffect("[When Attacking] You may place 3 cards with a type including \"CP\" from your trash at the bottom of your deck in any order: K.O. up to 1 of your opponent's Characters with a cost of 0.");
        guernica.setImagePath("/images/cards/OP08/OP08-081.png");
        cardRepository.save(guernica);

        Card sasakiBlack = new Card();
        sasakiBlack.setCardNumber("OP08-082");
        sasakiBlack.setName("Sasaki");
        sasakiBlack.setCardType("Character");
        sasakiBlack.setColor("Black");
        sasakiBlack.setCost(1);
        sasakiBlack.setPower(1000);
        sasakiBlack.setCounter(2000);
        sasakiBlack.setAffiliations("Animal Kingdom Pirates");
        sasakiBlack.setAttribute("Slash");
        sasakiBlack.setEffect("[Activate: Main] You may rest one of your Don!! and this character: Up to one of your opponents characters gets -2 cost for this turn.");
        sasakiBlack.setImagePath("/images/cards/OP08/OP08-082.png");
        cardRepository.save(sasakiBlack);

        Card sheepshead = new Card();
        sheepshead.setCardNumber("OP08-083");
        sheepshead.setName("Sheepshead");
        sheepshead.setCardType("Character");
        sheepshead.setColor("Black");
        sheepshead.setCost(2);
        sheepshead.setPower(3000);
        sheepshead.setCounter(1000);
        sheepshead.setAffiliations("Animal Kingdom Pirates / SMILE");
        sheepshead.setAttribute("Slash");
        sheepshead.setEffect("[DON!!x1] [Your Turn] Give all of your opponent's Characters -1 cost.");
        sheepshead.setImagePath("/images/cards/OP08/OP08-083.png");
        cardRepository.save(sheepshead);

        Card jackBlack = new Card();
        jackBlack.setCardNumber("OP08-084");
        jackBlack.setName("Jack");
        jackBlack.setCardType("Character");
        jackBlack.setColor("Black");
        jackBlack.setCost(7);
        jackBlack.setPower(8000);
        // No Counter
        jackBlack.setAffiliations("Animal Kingdom Pirates");
        jackBlack.setAttribute("Slash");
        jackBlack.setEffect("This character has +4 cost.\\n[Activate: Main] You may rest this card: Draw one card and trash one card from your hand. Then KO up to one of your opponents cost 3 or lower characters.");
        jackBlack.setImagePath("/images/cards/OP08/OP08-084.png");
        cardRepository.save(jackBlack);

        Card jinbeBlack = new Card();
        jinbeBlack.setCardNumber("OP08-085");
        jinbeBlack.setName("Jinbe");
        jinbeBlack.setCardType("Character");
        jinbeBlack.setColor("Black");
        jinbeBlack.setCost(5);
        jinbeBlack.setPower(6000);
        jinbeBlack.setCounter(1000);
        jinbeBlack.setAffiliations("Fishman / Straw Hat Pirates");
        jinbeBlack.setAttribute("Strike");
        jinbeBlack.setEffect("[DON!!x1] [When Attacking] If you have a character with a cost of 8 or more, KO up to one of your opponent's characters with a cost of 4 or less.");
        jinbeBlack.setImagePath("/images/cards/OP08/OP08-085.png");
        cardRepository.save(jinbeBlack);

        Card ginrummy = new Card();
        ginrummy.setCardNumber("OP08-086");
        ginrummy.setName("Ginrummy");
        ginrummy.setCardType("Character");
        ginrummy.setColor("Black");
        ginrummy.setCost(2);
        ginrummy.setPower(3000);
        ginrummy.setCounter(1000);
        ginrummy.setAffiliations("Animal Kingdom Pirates / SMILE");
        ginrummy.setAttribute("Strike");
        ginrummy.setEffect("[On Play] If your opponent has a Character with a cost of 0, draw 2 cards and trash 2 cards from your hand.");
        ginrummy.setImagePath("/images/cards/OP08/OP08-086.png");
        cardRepository.save(ginrummy);

        Card scratchmanApooBlack = new Card();
        scratchmanApooBlack.setCardNumber("OP08-087");
        scratchmanApooBlack.setName("Scratchman Apoo");
        scratchmanApooBlack.setCardType("Character");
        scratchmanApooBlack.setColor("Black");
        scratchmanApooBlack.setCost(4);
        scratchmanApooBlack.setPower(5000);
        scratchmanApooBlack.setCounter(1000);
        scratchmanApooBlack.setAffiliations("Animal Kingdom Pirates/ On Air Pirates");
        scratchmanApooBlack.setAttribute("Ranged");
        scratchmanApooBlack.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[Activate: Main] [Once Per Turn] Give up to one of your opponents characters cost -1 for this turn.");
        scratchmanApooBlack.setImagePath("/images/cards/OP08/OP08-087.png");
        cardRepository.save(scratchmanApooBlack);

        Card duval = new Card();
        duval.setCardNumber("OP08-088");
        duval.setName("Duval");
        duval.setCardType("Character");
        duval.setColor("Black");
        duval.setCost(1);
        duval.setPower(2000);
        duval.setCounter(2000);
        duval.setAffiliations("Rosy Life Riders");
        duval.setAttribute("Ranged");
        duval.setEffect("[On Play] Give up to 1 of your Characters +1 cost until the end of your opponent's turn.");
        duval.setImagePath("/images/cards/OP08/OP08-088.png");
        cardRepository.save(duval);

        Card basilHawkinsBlack = new Card();
        basilHawkinsBlack.setCardNumber("OP08-089");
        basilHawkinsBlack.setName("Basil Hawkins");
        basilHawkinsBlack.setCardType("Character");
        basilHawkinsBlack.setColor("Black");
        basilHawkinsBlack.setCost(7);
        basilHawkinsBlack.setPower(9000);
        basilHawkinsBlack.setCounter(1000);
        basilHawkinsBlack.setAffiliations("Animal Kingdom Pirates / Hawkins Pirates");
        basilHawkinsBlack.setAttribute("Slash");
        // No Effect
        basilHawkinsBlack.setImagePath("/images/cards/OP08/OP08-089.png");
        cardRepository.save(basilHawkinsBlack);

        Card hamlet = new Card();
        hamlet.setCardNumber("OP08-090");
        hamlet.setName("Hamlet");
        hamlet.setCardType("Character");
        hamlet.setColor("Black");
        hamlet.setCost(3);
        hamlet.setPower(4000);
        hamlet.setCounter(1000);
        hamlet.setAffiliations("Animal Kingdom Pirates / SMILE");
        hamlet.setAttribute("Slash");
        hamlet.setEffect("[On Play] Play up to 1 Character card with the {SMILE} type and a cost of 2 or less from your trash.");
        hamlet.setImagePath("/images/cards/OP08/OP08-090.png");
        cardRepository.save(hamlet);

        Card whosWhoBlack = new Card();
        whosWhoBlack.setCardNumber("OP08-091");
        whosWhoBlack.setName("Who's Who");
        whosWhoBlack.setCardType("Character");
        whosWhoBlack.setColor("Black");
        whosWhoBlack.setCost(5);
        whosWhoBlack.setPower(5000);
        whosWhoBlack.setCounter(2000);
        whosWhoBlack.setAffiliations("Animal Kingdom Pirates / Former CP9");
        whosWhoBlack.setAttribute("Slash");
        whosWhoBlack.setEffect("[On Play] You may discard one card from your hand: KO up to 1 of your opponent's cost 3 or lower characters.\\n[Trigger] KO up to 1 of your opponent's cost 3 or lower characters.");
        whosWhoBlack.setImagePath("/images/cards/OP08/OP08-091.png");
        cardRepository.save(whosWhoBlack);

        Card pageOneBlack = new Card();
        pageOneBlack.setCardNumber("OP08-092");
        pageOneBlack.setName("Page One");
        pageOneBlack.setCardType("Character");
        pageOneBlack.setColor("Black");
        pageOneBlack.setCost(5);
        pageOneBlack.setPower(5000);
        pageOneBlack.setCounter(1000);
        pageOneBlack.setAffiliations("Animal Kingdom Pirates");
        pageOneBlack.setAttribute("Strike");
        pageOneBlack.setEffect("[On Play] Play up to 1 cost 4 or lower \"Ulti\" from your trash.");
        pageOneBlack.setImagePath("/images/cards/OP08/OP08-092.png");
        cardRepository.save(pageOneBlack);

        Card xDrakeBlack = new Card();
        xDrakeBlack.setCardNumber("OP08-093");
        xDrakeBlack.setName("X.Drake");
        xDrakeBlack.setCardType("Character");
        xDrakeBlack.setColor("Black");
        xDrakeBlack.setCost(4);
        xDrakeBlack.setPower(6000);
        // No Counter
        xDrakeBlack.setAffiliations("Navy / Drake Pirates / Animal Kingdom Pirates");
        xDrakeBlack.setAttribute("Slash");
        xDrakeBlack.setEffect("[DON!!x1] This Character gains +2 cost.");
        xDrakeBlack.setImagePath("/images/cards/OP08/OP08-093.png");
        cardRepository.save(xDrakeBlack);

        // Events
        Card imperialFlame = new Card();
        imperialFlame.setCardNumber("OP08-094");
        imperialFlame.setName("Imperial Flame");
        imperialFlame.setCardType("Event");
        imperialFlame.setColor("Black");
        imperialFlame.setCost(2);
        imperialFlame.setAffiliations("Animal Kingdom Pirates");
        imperialFlame.setEffect("[Main] / [Counter] You may place 3 cards from your trash at the bottom of your deck in any order: K.O. up to 1 of your opponent's Characters with a cost of 2 or less.\\n[Trigger] Activate this card's [Main] effect.");
        imperialFlame.setImagePath("/images/cards/OP08/OP08-094.png");
        cardRepository.save(imperialFlame);

        Card ironBodyFangFlash = new Card();
        ironBodyFangFlash.setCardNumber("OP08-095");
        ironBodyFangFlash.setName("Iron Body: Fang Flash");
        ironBodyFangFlash.setCardType("Event");
        ironBodyFangFlash.setColor("Black");
        ironBodyFangFlash.setCost(2);
        ironBodyFangFlash.setAffiliations("Animal Kingdom Pirates / Former CP9");
        ironBodyFangFlash.setEffect("[Main] If you have 10 or more cards in your trash, give up to 1 of your Characters +2000 power until the end of your opponent's turn.\\n[Trigger] Up to 1 of your Leader or Characters gains +2000 power during this turn.");
        ironBodyFangFlash.setImagePath("/images/cards/OP08/OP08-095.png");
        cardRepository.save(ironBodyFangFlash);

        Card peoplesDreamsDontEnd = new Card();
        peoplesDreamsDontEnd.setCardNumber("OP08-096");
        peoplesDreamsDontEnd.setName("People's Dreams... Don't Ever End!!");
        peoplesDreamsDontEnd.setCardType("Event");
        peoplesDreamsDontEnd.setColor("Black");
        peoplesDreamsDontEnd.setCost(1);
        peoplesDreamsDontEnd.setAffiliations("Blackbeard Pirates");
        peoplesDreamsDontEnd.setEffect("[Counter] Trash 1 card from the top of your deck. If that card has a cost of 6 or greater, up to 1 of your Leader or Character cards gains +5000 power during this battle.\\n[Trigger] Play up to 1 black Character card with a cost of 3 or less from your trash.");
        peoplesDreamsDontEnd.setImagePath("/images/cards/OP08/OP08-096.png");
        cardRepository.save(peoplesDreamsDontEnd);

        Card heliceratops = new Card();
        heliceratops.setCardNumber("OP08-097");
        heliceratops.setName("Heliceratops");
        heliceratops.setCardType("Event");
        heliceratops.setColor("Black");
        heliceratops.setCost(3);
        heliceratops.setAffiliations("Animal Kingdom Pirates");
        heliceratops.setEffect("[Main] If your Leader has the {Animal Kingdom Pirates} type, give up to 1 of your opponent's Characters -2 Cost during this turn. Then, K.O. up to 1 of your opponents Characters with a cost of 0.\\n[Trigger] K.O. up to 1 of your opponent's Characters with a cost of 3 or less.");
        heliceratops.setImagePath("/images/cards/OP08/OP08-097.png");
        cardRepository.save(heliceratops);

        System.out.println("Finished initializing OP08 Black cards");
    }

    private void initializeOP08YellowCards() {
        System.out.println("Initializing OP08 Yellow cards (and Secret Rares)...");

        // Leaders
        Card kalgaraLeader = new Card();
        kalgaraLeader.setCardNumber("OP08-098");
        kalgaraLeader.setName("Kalgara");
        kalgaraLeader.setCardType("Leader");
        kalgaraLeader.setColor("Yellow");
        kalgaraLeader.setPower(5000);
        kalgaraLeader.setLife(5);
        kalgaraLeader.setAffiliations("Jaya / Sky Island / Shandorian Warriors");
        kalgaraLeader.setAttribute("Slash");
        kalgaraLeader.setEffect("[DON!!x1] [When Attacking] Put a character with the {Shandorian Warriors} type from your hand into play that has a cost equal to or less than the number of Don!! you control. Then, if you played a card, put the top card of your life into your hand.");
        kalgaraLeader.setImagePath("/images/cards/OP08/OP08-098.png");
        cardRepository.save(kalgaraLeader);

        // Characters
        Card kalgaraChar = new Card();
        kalgaraChar.setCardNumber("OP08-099");
        kalgaraChar.setName("Kalgara");
        kalgaraChar.setCardType("Character");
        kalgaraChar.setColor("Yellow");
        kalgaraChar.setCost(6);
        kalgaraChar.setPower(8000);
        kalgaraChar.setCounter(1000);
        kalgaraChar.setAffiliations("Jaya / Sky Island / Shandoran Warriors");
        kalgaraChar.setAttribute("Slash");
        // No Effect
        kalgaraChar.setImagePath("/images/cards/OP08/OP08-099.png");
        cardRepository.save(kalgaraChar);

        Card southBird = new Card();
        southBird.setCardNumber("OP08-100");
        southBird.setName("South Bird");
        southBird.setCardType("Character");
        southBird.setColor("Yellow");
        southBird.setCost(1);
        southBird.setPower(2000);
        southBird.setCounter(1000);
        southBird.setAffiliations("Animals / Jaya / Sky Island");
        southBird.setAttribute("Wisdom");
        southBird.setEffect("[On Play] Look at the top 7 cards of your deck and play up to one [Upper Yard] from among them. Then, place the rest of the cards on the bottom of your deck in any order.");
        southBird.setImagePath("/images/cards/OP08/OP08-100.png");
        cardRepository.save(southBird);

        Card charlotteAngel = new Card();
        charlotteAngel.setCardNumber("OP08-101");
        charlotteAngel.setName("Charlotte Angel");
        charlotteAngel.setCardType("Character");
        charlotteAngel.setColor("Yellow");
        charlotteAngel.setCost(2);
        charlotteAngel.setPower(3000);
        charlotteAngel.setCounter(1000);
        charlotteAngel.setAffiliations("Big Mom Pirates");
        charlotteAngel.setAttribute("Slash");
        charlotteAngel.setEffect("[Activate: Main] [Once Per Turn] You may trash 1 card from the top of your Life cards: If your Leader has the {Big Mom Pirates} type, add up to 1 card from the top of your deck to the top of your Life cards at the end of this turn.");
        charlotteAngel.setImagePath("/images/cards/OP08/OP08-101.png");
        cardRepository.save(charlotteAngel);

        Card charlotteOpera = new Card();
        charlotteOpera.setCardNumber("OP08-102");
        charlotteOpera.setName("Charlotte Opera");
        charlotteOpera.setCardType("Character");
        charlotteOpera.setColor("Yellow");
        charlotteOpera.setCost(6);
        charlotteOpera.setPower(6000);
        charlotteOpera.setCounter(1000);
        charlotteOpera.setAffiliations("Big Mom Pirates");
        charlotteOpera.setAttribute("Special");
        charlotteOpera.setEffect("[On Play] You may trash 1 card from your hand: K.O. up to 1 of your opponent's Characters with a cost equal to or less than the number of your Life cards.");
        charlotteOpera.setImagePath("/images/cards/OP08/OP08-102.png");
        cardRepository.save(charlotteOpera);

        Card charlotteCustard = new Card();
        charlotteCustard.setCardNumber("OP08-103");
        charlotteCustard.setName("Charlotte Custard");
        charlotteCustard.setCardType("Character");
        charlotteCustard.setColor("Yellow");
        charlotteCustard.setCost(2);
        charlotteCustard.setPower(3000);
        charlotteCustard.setCounter(1000);
        charlotteCustard.setAffiliations("Big Mom Pirates");
        charlotteCustard.setAttribute("Slash");
        charlotteCustard.setEffect("[Activate: Main] [Once Per Turn] You may add the top card of life to your hand: Give up to one of your characters +1000 power until the end of your opponents next turn.");
        charlotteCustard.setImagePath("/images/cards/OP08/OP08-103.png");
        cardRepository.save(charlotteCustard);

        Card charlottePoire = new Card();
        charlottePoire.setCardNumber("OP08-104");
        charlottePoire.setName("Charlotte Poire");
        charlottePoire.setCardType("Character");
        charlottePoire.setColor("Yellow");
        charlottePoire.setCost(1);
        charlottePoire.setPower(2000);
        charlottePoire.setCounter(1000);
        charlottePoire.setAffiliations("Big Mom Pirates");
        charlottePoire.setAttribute("Wisdom");
        charlottePoire.setEffect("[Trigger] You may trash 1 card from your hand: Play this card Then, draw 1 card.");
        charlottePoire.setImagePath("/images/cards/OP08/OP08-104.png");
        cardRepository.save(charlottePoire);

        Card jewelryBonneyYellow = new Card();
        jewelryBonneyYellow.setCardNumber("OP08-105");
        jewelryBonneyYellow.setName("Jewelry Bonney");
        jewelryBonneyYellow.setCardType("Character");
        jewelryBonneyYellow.setColor("Yellow");
        jewelryBonneyYellow.setCost(3);
        jewelryBonneyYellow.setPower(4000);
        jewelryBonneyYellow.setCounter(1000);
        jewelryBonneyYellow.setAffiliations("Egghead / Bonney Pirates");
        jewelryBonneyYellow.setAttribute("Special");
        jewelryBonneyYellow.setEffect("[DON!!x1] [Your Turn] [Once Per Turn] When your opponent loses a life, draw two cards and discard one card from your hand.\\n[Trigger] Draw 2 cards and discard one card from your hand.");
        jewelryBonneyYellow.setImagePath("/images/cards/OP08/OP08-105.png");
        cardRepository.save(jewelryBonneyYellow);

        Card namiYellow = new Card();
        namiYellow.setCardNumber("OP08-106");
        namiYellow.setName("Nami");
        namiYellow.setCardType("Character");
        namiYellow.setColor("Yellow");
        namiYellow.setCost(5);
        namiYellow.setPower(5000);
        namiYellow.setCounter(1000);
        namiYellow.setAffiliations("Egghead / Straw Hat Crew");
        namiYellow.setAttribute("Wisdom");
        namiYellow.setEffect("[On Play] You may trash 1 card with a [Trigger] from your hand: KO up to one of your opponents characters with a cost of 5 or less. Then, if your hand has 3 or less cards in it, draw 1 card.\\n[Trigger] Activate this card's [On Play] effect.");
        namiYellow.setImagePath("/images/cards/OP08/OP08-106.png");
        cardRepository.save(namiYellow);

        Card nitro = new Card();
        nitro.setCardNumber("OP08-107");
        nitro.setName("Nitro");
        nitro.setCardType("Character");
        nitro.setColor("Yellow");
        nitro.setCost(1);
        nitro.setPower(2000);
        nitro.setCounter(1000);
        nitro.setAffiliations("Big Mom Pirates/Homies");
        nitro.setAttribute("Special");
        nitro.setEffect("[Activate: Main] You may rest this character: Give up to one of your [Charlotte Pudding] +2000 power for the turn.");
        nitro.setImagePath("/images/cards/OP08/OP08-107.png");
        cardRepository.save(nitro);

        Card montBlancCricket = new Card();
        montBlancCricket.setCardNumber("OP08-108");
        montBlancCricket.setName("Mont Blanc Cricket");
        montBlancCricket.setCardType("Character");
        montBlancCricket.setColor("Yellow");
        montBlancCricket.setCost(4);
        montBlancCricket.setPower(6000);
        montBlancCricket.setCounter(1000);
        montBlancCricket.setAffiliations("Jaya / Monkey Mountain Allied Force");
        montBlancCricket.setAttribute("Strike");
        // No Effect
        montBlancCricket.setImagePath("/images/cards/OP08/OP08-108.png");
        cardRepository.save(montBlancCricket);

        Card montblancNorland = new Card();
        montblancNorland.setCardNumber("OP08-109");
        montblancNorland.setName("Montblanc Norland");
        montblancNorland.setCardType("Character");
        montblancNorland.setColor("Yellow");
        montblancNorland.setCost(5);
        montblancNorland.setPower(6000);
        montblancNorland.setCounter(1000);
        montblancNorland.setAffiliations("Jaya / Botanist");
        montblancNorland.setAttribute("Slash");
        montblancNorland.setEffect("[On Play] If your leader has the <Shandoran Warrior> type and you have a \"Kalgara\" character in play, add up to 1 card from the top of your deck to the top of your life.");
        montblancNorland.setImagePath("/images/cards/OP08/OP08-109.png");
        cardRepository.save(montblancNorland);

        Card wiperYellow = new Card();
        wiperYellow.setCardNumber("OP08-110");
        wiperYellow.setName("Wiper");
        wiperYellow.setCardType("Character");
        wiperYellow.setColor("Yellow");
        wiperYellow.setCost(4);
        wiperYellow.setPower(5000);
        wiperYellow.setCounter(2000);
        wiperYellow.setAffiliations("Sky Island / Shandoran Warrior");
        wiperYellow.setAttribute("Ranged");
        wiperYellow.setEffect("[On Play] Look at the top 4 cards of your deck, reveal up to 1 {Upper Yard} and then add it to your hand. Then, put the remaining cards to the bottom of the deck in any order and play up to 1 {Upper Yard} from your hand.");
        wiperYellow.setImagePath("/images/cards/OP08/OP08-110.png");
        cardRepository.save(wiperYellow);

        Card sShark = new Card();
        sShark.setCardNumber("OP08-111");
        sShark.setName("S-Shark");
        sShark.setCardType("Character");
        sShark.setColor("Yellow");
        sShark.setCost(4);
        sShark.setPower(5000);
        sShark.setCounter(1000);
        sShark.setAffiliations("Egghead / Seraphim");
        sShark.setAttribute("Special");
        sShark.setEffect("[DON!!x1] [When Attacking] Your opponent cannot activate [Blocker] during this battle.\\n[Trigger] You may trash 1 card from your hand: If you have 2 or less Life cards, play this card.");
        sShark.setImagePath("/images/cards/OP08/OP08-111.png");
        cardRepository.save(sShark);

        Card sSnake = new Card();
        sSnake.setCardNumber("OP08-112");
        sSnake.setName("S-Snake");
        sSnake.setCardType("Character");
        sSnake.setColor("Yellow");
        sSnake.setCost(5);
        sSnake.setPower(6000);
        sSnake.setCounter(1000);
        sSnake.setAffiliations("Egghead / Seraphim");
        sSnake.setAttribute("Special");
        sSnake.setEffect("[On Play] Up to 1 of your opponent's Characters with a cost of 6 or less other than [Monkey. D. Luffy] cannot attack until the end of your opponent's next turn.\\n[Trigger] Activate this card's [On Play] effect.");
        sSnake.setImagePath("/images/cards/OP08/OP08-112.png");
        cardRepository.save(sSnake);

        Card sBear = new Card();
        sBear.setCardNumber("OP08-113");
        sBear.setName("S-Bear");
        sBear.setCardType("Character");
        sBear.setColor("Yellow");
        sBear.setCost(3);
        sBear.setPower(4000);
        sBear.setCounter(1000);
        sBear.setAffiliations("Egghead / Seraphim");
        sBear.setAttribute("Special");
        sBear.setEffect("[Trigger] You may trash 1 card from your hand: If you have 2 or less Life cards, play this card and K.O. up to 1 of your opponent's Characters with a cost of 3 or less.");
        sBear.setImagePath("/images/cards/OP08/OP08-113.png");
        cardRepository.save(sBear);

        Card sHawk = new Card();
        sHawk.setCardNumber("OP08-114");
        sHawk.setName("S-Hawk");
        sHawk.setCardType("Character");
        sHawk.setColor("Yellow");
        sHawk.setCost(4);
        sHawk.setPower(5000);
        sHawk.setCounter(1000);
        sHawk.setAffiliations("Egghead / Seraphim");
        sHawk.setAttribute("Slash");
        sHawk.setEffect("[DON!!x1] While your life total is lower than your opponents, this character has +2000 power and cannot by KO'd in battle by cards with the (Slash) attribute.\\n[Trigger] You may trash 1 card from your hand: If you have 2 or less life, play this character.");
        sHawk.setImagePath("/images/cards/OP08/OP08-114.png");
        cardRepository.save(sHawk);

        // Events
        Card theEarthWontLose = new Card();
        theEarthWontLose.setCardNumber("OP08-115");
        theEarthWontLose.setName("The Earth Won't Lose!!");
        theEarthWontLose.setCardType("Event");
        theEarthWontLose.setColor("Yellow");
        theEarthWontLose.setCost(1);
        theEarthWontLose.setAffiliations("Sky Island / Shandoran Warrior");
        theEarthWontLose.setEffect("[Counter] If your leader has the {Shandoran Warriors} type, your leader or up to one of your characters +3000 power for this battle. Then, play up to one [Upper Yard] from your hand.\\n[Trigger] Draw 2 cards then discard 1 card.");
        theEarthWontLose.setImagePath("/images/cards/OP08/OP08-115.png");
        cardRepository.save(theEarthWontLose);

        Card burnBazooka = new Card();
        burnBazooka.setCardNumber("OP08-116");
        burnBazooka.setName("Burn Bazooka");
        burnBazooka.setCardType("Event");
        burnBazooka.setColor("Yellow");
        burnBazooka.setCost(2);
        burnBazooka.setAffiliations("Sky Island / Shandian Warrior");
        burnBazooka.setEffect("[Counter] Up to 1 of your Leader or Character cards gains +4000 power during this battle. Then, you may add 1 card from the top or bottom of your Life cards to your hand. If you do, add up to 1 card with the {Shandian Warrior} type from your hand to the top of your Life cards face up.");
        burnBazooka.setImagePath("/images/cards/OP08/OP08-116.png");
        cardRepository.save(burnBazooka);

        Card burnBlade = new Card();
        burnBlade.setCardNumber("OP08-117");
        burnBlade.setName("Burn Blade");
        burnBlade.setCardType("Event");
        burnBlade.setColor("Yellow");
        burnBlade.setCost(5);
        burnBlade.setAffiliations("Sky Island/Shandian Warrior");
        burnBlade.setEffect("[Main] You may trash 1 card from the top of your Life cards: K.O. up to 1 of your opponent's Characters with a cost of 7 or less.\\n[Trigger] You may add 1 card from the top of your Life cards to your hand: Add up to 1 card from your hand to the top of your Life cards.");
        burnBlade.setImagePath("/images/cards/OP08/OP08-117.png");
        cardRepository.save(burnBlade);

        // Secret Rares
        Card silversRayleighSecret = new Card();
        silversRayleighSecret.setCardNumber("OP08-118");
        silversRayleighSecret.setName("Silvers Rayleigh");
        silversRayleighSecret.setCardType("Character");
        silversRayleighSecret.setColor("Red/Black"); // Dual Color
        silversRayleighSecret.setCost(8);
        silversRayleighSecret.setPower(8000);
        // No Counter
        silversRayleighSecret.setAffiliations("Former Roger Pirates");
        silversRayleighSecret.setAttribute("Slash");
        silversRayleighSecret.setEffect("[On Play] Choose up to two of your opponents characters. Until the end of your opponents next turn, give one character -3000 power, and the other -2000 power. After this, KO up to one of your opponents characters with a power of 3000 or lower.");
        silversRayleighSecret.setImagePath("/images/cards/OP08/OP08-118.png");
        cardRepository.save(silversRayleighSecret);

        Card kaidoLinlinSecret = new Card();
        kaidoLinlinSecret.setCardNumber("OP08-119");
        kaidoLinlinSecret.setName("Kaido and Linlin");
        kaidoLinlinSecret.setCardType("Character");
        kaidoLinlinSecret.setColor("Purple/Yellow"); // Dual Color
        kaidoLinlinSecret.setCost(10);
        kaidoLinlinSecret.setPower(12000);
        // No Counter
        kaidoLinlinSecret.setAffiliations("Four Emperors / Animal Kingdom Pirates / Big Mom Pirates");
        kaidoLinlinSecret.setAttribute("Strike/Special");
        kaidoLinlinSecret.setEffect("[When Attacking] -10 Don!!: KO all other characters. Then, put up to one card from the top of your deck on your life pile and trash up to one card from the top of your opponent's life pile.");
        kaidoLinlinSecret.setImagePath("/images/cards/OP08/OP08-119.png");
        cardRepository.save(kaidoLinlinSecret);

        System.out.println("Finished initializing OP08 Yellow cards and Secret Rares");
    }
} 