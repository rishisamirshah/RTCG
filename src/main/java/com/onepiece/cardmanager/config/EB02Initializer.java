package com.onepiece.cardmanager.config;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(13) // After OP sets, ST sets, and EB01
public class EB02Initializer extends BaseInitializer {

    private final CardRepository cardRepository;

    @Autowired
    public EB02Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    protected void initialize(String... args) throws Exception {
        String setCode = "EB02";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // --- Add EB-02 Card Data Below --- 

        // EB02-001: Karoo
        Card karoo = new Card();
        karoo.setCardNumber("EB02-001");
        karoo.setName("Karoo");
        karoo.setCardType("Character");
        karoo.setColor("Red");
        karoo.setCost(5);
        karoo.setPower(7000);
        karoo.setCounter(1000);
        karoo.setAttribute("Strike");
        karoo.setAffiliations("Animal / Alabasta");
        karoo.setEffect(null); // No effect text visible
        karoo.setImagePath("/images/cards/EB02/EB02-001.jpg");
        karoo.setSet(setCode);
        cardRepository.save(karoo);

        // EB02-002: Sabo
        Card sabo = new Card();
        sabo.setCardNumber("EB02-002");
        sabo.setName("Sabo");
        sabo.setCardType("Character");
        sabo.setColor("Red");
        sabo.setCost(4);
        sabo.setPower(5000);
        sabo.setCounter(2000);
        sabo.setAttribute("Special");
        sabo.setAffiliations("Dressrosa / Revolutionary Army");
        sabo.setEffect("Activate: Main You may rest this character: Up to one of your {Revolutionary Army} character other than \"Sabo\" gains +2000 power during this turn.");
        sabo.setImagePath("/images/cards/EB02/EB02-002.jpg");
        sabo.setSet(setCode);
        cardRepository.save(sabo);

        // EB02-003: Tony Tony Chopper
        Card chopper = new Card();
        chopper.setCardNumber("EB02-003");
        chopper.setName("Tony Tony Chopper");
        chopper.setCardType("Character");
        chopper.setColor("Red");
        chopper.setCost(3);
        chopper.setPower(3000);
        chopper.setCounter(1000);
        chopper.setAttribute("Strike");
        chopper.setAffiliations("Animal / Drum Kingdom / Straw Hat Crew");
        chopper.setEffect("DON!!x2 Opponent's Turn This character has +2000 power.\nOn Play If your leader has the {Straw Hat Crew} type, give your leader or one character up to 1 rested DON!! cards.");
        chopper.setImagePath("/images/cards/EB02/EB02-003.jpg");
        chopper.setSet(setCode);
        cardRepository.save(chopper);

        // EB02-004: Don Accino
        Card donAccino = new Card();
        donAccino.setCardNumber("EB02-004");
        donAccino.setName("Don Accino");
        donAccino.setCardType("Character");
        donAccino.setColor("Red");
        donAccino.setCost(8);
        donAccino.setPower(10000);
        donAccino.setCounter(1000);
        donAccino.setAttribute("Special");
        donAccino.setAffiliations("Accino Family");
        donAccino.setEffect(null); // No effect text visible (SAMPLE)
        donAccino.setImagePath("/images/cards/EB02/EB02-004.jpg");
        donAccino.setSet(setCode);
        cardRepository.save(donAccino);

        // EB02-005: Impostor Straw Hat Crew
        Card impostorCrew = new Card();
        impostorCrew.setCardNumber("EB02-005");
        impostorCrew.setName("Impostor Straw Hat Crew");
        impostorCrew.setCardType("Character");
        impostorCrew.setColor("Red");
        impostorCrew.setCost(2);
        impostorCrew.setPower(3000);
        impostorCrew.setCounter(null); // No counter value
        impostorCrew.setAttribute("Ranged");
        impostorCrew.setAffiliations("Impostor Straw Hat Crew");
        impostorCrew.setEffect("Your Turn This Character gains +2000 power.\nOpponent's Turn This Character gets -2000 power.");
        impostorCrew.setImagePath("/images/cards/EB02/EB02-005.jpg");
        impostorCrew.setSet(setCode);
        cardRepository.save(impostorCrew);

        // EB02-006: Yamato
        Card yamato = new Card();
        yamato.setCardNumber("EB02-006");
        yamato.setName("Yamato");
        yamato.setCardType("Character");
        yamato.setColor("Red"); // Primary color is Red, frame indicates Green/Red potentially
        yamato.setCost(6);
        yamato.setPower(7000);
        yamato.setCounter(null); // No counter value
        yamato.setAttribute("Strike");
        yamato.setAffiliations("Land of Wano");
        yamato.setEffect("Activate: Main Once Per Turn If your Leader has the {Land of Wano} type or is [Portgas D. Ace], give up to 1 rested DON!! card to your Leader. Then, this Character gains Rush during this turn.");
        yamato.setImagePath("/images/cards/EB02/EB02-006.jpg");
        yamato.setSet(setCode);
        cardRepository.save(yamato);

        // EB02-007: Carving Hoof Cherry Blossom Blizzard
        Card cherryBlizzard = new Card();
        cherryBlizzard.setCardNumber("EB02-007");
        cherryBlizzard.setName("Carving Hoof Cherry Blossom Blizzard");
        cherryBlizzard.setCardType("Event");
        cherryBlizzard.setColor("Red");
        cherryBlizzard.setCost(3);
        cherryBlizzard.setPower(null);
        cherryBlizzard.setCounter(null);
        cherryBlizzard.setAffiliations("Animal / W7 / Straw Hat Pirates");
        cherryBlizzard.setEffect("Main Give up to 3 of your Leader or Characters gain +1000 Power during this turn. Then, K.O up to one of your opponent's characters with a Power of 3000 or less.\nTrigger K.O up to one of your opponent's characters with a Power of 4000 or less.");
        cherryBlizzard.setImagePath("/images/cards/EB02/EB02-007.jpg");
        cherryBlizzard.setSet(setCode);
        cardRepository.save(cherryBlizzard);

        // EB02-008: Highest Point Reached
        Card highestPoint = new Card();
        highestPoint.setCardNumber("EB02-008");
        highestPoint.setName("Highest Point Reached");
        highestPoint.setCardType("Event");
        highestPoint.setColor("Red"); // Frame color is Red
        highestPoint.setCost(2);
        highestPoint.setPower(null);
        highestPoint.setCounter(null);
        highestPoint.setAffiliations("Music");
        highestPoint.setEffect("Main Look at the top 4 cards of your deck, reveal 1 card with a cost of 4 or more and add it to your hand. Then, place the rest at the bottom of your deck in any order.\nTrigger Activate this card's Main effect.");
        highestPoint.setImagePath("/images/cards/EB02/EB02-008.jpg");
        highestPoint.setSet(setCode);
        cardRepository.save(highestPoint);

        // EB02-009: Thousand Sunny
        Card thousandSunny = new Card();
        thousandSunny.setCardNumber("EB02-009");
        thousandSunny.setName("Thousand Sunny");
        thousandSunny.setCardType("Stage");
        thousandSunny.setColor("Red");
        thousandSunny.setCost(2);
        thousandSunny.setPower(null);
        thousandSunny.setCounter(null);
        thousandSunny.setAffiliations("Straw Hat Crew");
        thousandSunny.setEffect("Activate: Main You may rest this Stage: Give up to 1 currently attached DON!! card's to 1 of your {Straw Hat Crew} type Characters.");
        thousandSunny.setImagePath("/images/cards/EB02/EB02-009.jpg");
        thousandSunny.setSet(setCode);
        cardRepository.save(thousandSunny);

        // --- Green Cards --- 

        // EB02-010: Monkey D. Luffy (Leader)
        Card luffyLeader = new Card();
        luffyLeader.setCardNumber("EB02-010");
        luffyLeader.setName("Monkey D. Luffy");
        luffyLeader.setCardType("Leader");
        luffyLeader.setColor("Green/Purple"); // Dual color
        luffyLeader.setPower(5000);
        luffyLeader.setLife(4);
        luffyLeader.setAttribute("Strike");
        luffyLeader.setAffiliations("Straw Hat Crew");
        luffyLeader.setEffect("Activate: Main Once Per Turn Don!!-2: If you only have {Straw Hat Crew} type Characters in play, set up to 2 of your rested Don!! cards as active. Then, this leader gets +1000 power until the end of your opponent's next turn.");
        luffyLeader.setImagePath("/images/cards/EB02/EB02-010.jpg");
        luffyLeader.setSet(setCode);
        cardRepository.save(luffyLeader);

        // EB02-011: Arlong
        Card arlong = new Card();
        arlong.setCardNumber("EB02-011");
        arlong.setName("Arlong");
        arlong.setCardType("Character");
        arlong.setColor("Green");
        arlong.setCost(3);
        arlong.setPower(4000);
        arlong.setCounter(1000);
        arlong.setAttribute("Slash");
        arlong.setAffiliations("Fish-Man / East Blue / Arlong Pirates");
        arlong.setEffect("On Play If your Leader has the {Fish-Man} or {East Blue} type, give up to 1 rested DON!! to your Leader. Then, up to 1 of your opponent's Characters with a cost of 5 or less cannot be rested until the end of your opponent's next turn.");
        arlong.setImagePath("/images/cards/EB02/EB02-011.jpg");
        arlong.setSet(setCode);
        cardRepository.save(arlong);

        // EB02-012: Gaimon
        Card gaimon = new Card();
        gaimon.setCardNumber("EB02-012");
        gaimon.setName("Gaimon");
        gaimon.setCardType("Character");
        gaimon.setColor("Green");
        gaimon.setCost(1);
        gaimon.setPower(1000);
        gaimon.setCounter(1000);
        gaimon.setAttribute("Wisdom");
        gaimon.setAffiliations("East Blue");
        gaimon.setEffect("If you have a \"Sarfunkel\", this character gains Blocker."); // Effect text partially obscured
        gaimon.setImagePath("/images/cards/EB02/EB02-012.jpg");
        gaimon.setSet(setCode);
        cardRepository.save(gaimon);

        // EB02-013: Carrot
        Card carrot = new Card();
        carrot.setCardNumber("EB02-013");
        carrot.setName("Carrot");
        carrot.setCardType("Character");
        carrot.setColor("Green");
        carrot.setCost(1);
        carrot.setPower(0);
        carrot.setCounter(2000);
        carrot.setAttribute("Special");
        carrot.setAffiliations("Minks");
        carrot.setEffect("On Play If you have 3 or more DON!! cards on the field, look at the top 7 cards of your deck, reveal up to 1 [Zou] and put it into your hand. Then, place the rest on the bottom of your deck in any order and play up to 1 [Zou] from your hand.");
        carrot.setImagePath("/images/cards/EB02/EB02-013.jpg");
        carrot.setSet(setCode);
        cardRepository.save(carrot);

        // EB02-014: Sarfunkle
        Card sarfunkle = new Card();
        sarfunkle.setCardNumber("EB02-014");
        sarfunkle.setName("Sarfunkle");
        sarfunkle.setCardType("Character");
        sarfunkle.setColor("Green");
        sarfunkle.setCost(2);
        sarfunkle.setPower(0);
        sarfunkle.setCounter(1000);
        sarfunkle.setAttribute("Wisdom");
        sarfunkle.setAffiliations("East Blue");
        sarfunkle.setEffect("On Play Play up to one \"Gaimon\" from your hand.");
        sarfunkle.setImagePath("/images/cards/EB02/EB02-014.jpg");
        sarfunkle.setSet(setCode);
        cardRepository.save(sarfunkle);

        // EB02-015: Jewelry Bonney
        Card bonney = new Card();
        bonney.setCardNumber("EB02-015");
        bonney.setName("Jewelry Bonney");
        bonney.setCardType("Character");
        bonney.setColor("Green");
        bonney.setCost(7);
        bonney.setPower(7000);
        bonney.setCounter(1000);
        bonney.setAttribute("Special");
        bonney.setAffiliations("Supernova / Bonnie Pirates");
        bonney.setEffect("On Play Up to one of your opponent's rested characters will not become active during your opponent's next refresh phase. Then, at the end of your turn, set up to 1 of your DON!! cards as active.");
        bonney.setImagePath("/images/cards/EB02/EB02-015.jpg");
        bonney.setSet(setCode);
        cardRepository.save(bonney);

        // EB02-016: Chopperman
        Card chopperman = new Card();
        chopperman.setCardNumber("EB02-016");
        chopperman.setName("Chopperman");
        chopperman.setCardType("Character");
        chopperman.setColor("Green");
        chopperman.setCost(5);
        chopperman.setPower(6000);
        chopperman.setCounter(1000);
        chopperman.setAttribute("Strike");
        chopperman.setAffiliations("Animal / Straw Hat Crew");
        chopperman.setEffect("Also treat this card's name as [Tony Tony. Chopper] according to the rules.\nOn Play Play up to 1 {Animal} type Character with the cost of 3 or lower from your hand.");
        chopperman.setImagePath("/images/cards/EB02/EB02-016.jpg");
        chopperman.setSet(setCode);
        cardRepository.save(chopperman);

        // EB02-017: Nami
        Card nami = new Card();
        nami.setCardNumber("EB02-017");
        nami.setName("Nami");
        nami.setCardType("Character");
        nami.setColor("Green");
        nami.setCost(1);
        nami.setPower(2000);
        nami.setCounter(1000);
        nami.setAttribute("Wisdom");
        nami.setAffiliations("East Blue / Straw Hat Crew");
        nami.setEffect("On Play Look at the top 5 cards of your library and reveal up to one {Strawhat Crew} type card other than \"Nami\" then put it into your hand. Then, place the rest of the cards on the bottom of your deck in any order.");
        nami.setImagePath("/images/cards/EB02/EB02-017.jpg");
        nami.setSet(setCode);
        cardRepository.save(nami);

        // EB02-018: Buggy
        Card buggy = new Card();
        buggy.setCardNumber("EB02-018");
        buggy.setName("Buggy");
        buggy.setCardType("Character");
        buggy.setColor("Green");
        buggy.setCost(4);
        buggy.setPower(6000);
        buggy.setCounter(null); // No Counter
        buggy.setAttribute("Slash");
        buggy.setAffiliations("East Blue / Buggy Pirates");
        buggy.setEffect("On Play If you do not have another \"Buggy\" character in play, up to one of your leaders gains Double Attack until the end of the turn.\nTrigger Rest up to one of your opponent's characters with a cost of 4 or less.");
        buggy.setImagePath("/images/cards/EB02/EB02-018.jpg");
        buggy.setSet(setCode);
        cardRepository.save(buggy);

        // EB02-019: Roronoa Zoro
        Card zoro = new Card();
        zoro.setCardNumber("EB02-019");
        zoro.setName("Roronoa Zoro");
        zoro.setCardType("Character");
        zoro.setColor("Green");
        zoro.setCost(4);
        zoro.setPower(5000);
        zoro.setCounter(1000);
        zoro.setAttribute("Slash");
        zoro.setAffiliations("East Blue / Straw Hat Crew");
        zoro.setEffect("If your opponent has 2 or more characters on the field, this character can attack characters on the turn it is played.\nOn Play If your leader has the type {Strawhat Crew}, rest up to one of your opponent's characters with a cost of 4 or less.");
        zoro.setImagePath("/images/cards/EB02/EB02-019.jpg");
        zoro.setSet(setCode);
        cardRepository.save(zoro);

        // EB02-020: We Are!
        Card weAre = new Card();
        weAre.setCardNumber("EB02-020");
        weAre.setName("We Are!");
        weAre.setCardType("Event");
        weAre.setColor("Green"); // Frame color is Green
        weAre.setCost(2);
        weAre.setPower(null);
        weAre.setCounter(null);
        weAre.setAffiliations("Music");
        weAre.setEffect("Main Look at the top 4 cards of your deck, reveal 1 card with a cost of 4 or more and add it to your hand. Then, place the rest at the bottom of your deck in any order.\nTrigger Activate this card's Main effect.");
        weAre.setImagePath("/images/cards/EB02/EB02-020.jpg");
        weAre.setSet(setCode);
        cardRepository.save(weAre);

        // EB02-021: Gum Gum Giant Pistol
        Card giantPistol = new Card();
        giantPistol.setCardNumber("EB02-021");
        giantPistol.setName("Gum Gum Giant Pistol");
        giantPistol.setCardType("Event");
        giantPistol.setColor("Green");
        giantPistol.setCost(3);
        giantPistol.setPower(null);
        giantPistol.setCounter(null);
        giantPistol.setAffiliations("Straw Hat Crew / W7");
        giantPistol.setEffect("Main Give up to one of your {Straw Hat Crew} type characters +6000 power until end of turn. Then, that character does not become active during your next refresh phase.\nTrigger Rest up to one of your opponent's cost 4 or lower characters.");
        giantPistol.setImagePath("/images/cards/EB02/EB02-021.jpg");
        giantPistol.setSet(setCode);
        cardRepository.save(giantPistol);

        // --- End of Green EB-02 Card Data ---

        // --- Blue Cards ---

        // EB02-022: Usopp
        Card usopp = new Card();
        usopp.setCardNumber("EB02-022");
        usopp.setName("Usopp");
        usopp.setCardType("Character");
        usopp.setColor("Blue");
        usopp.setCost(4);
        usopp.setPower(5000);
        usopp.setCounter(1000);
        usopp.setAttribute("Ranged");
        usopp.setAffiliations("East Blue / Straw Hat Crew");
        usopp.setEffect("On Play If you have 2 or fewer characters with 5000 or more power in play, play up to one power 6000 or lower character from your hand that has no abilities.");
        usopp.setImagePath("/images/cards/EB02/EB02-022.jpg");
        usopp.setSet(setCode);
        cardRepository.save(usopp);

        // EB02-023: Crocodile
        Card crocodile = new Card();
        crocodile.setCardNumber("EB02-023");
        crocodile.setName("Crocodile");
        crocodile.setCardType("Character");
        crocodile.setColor("Blue");
        crocodile.setCost(4);
        crocodile.setPower(5000);
        crocodile.setCounter(1000);
        crocodile.setAttribute("Special");
        crocodile.setAffiliations("The Seven Warlords of the Sea / Baroque Works");
        crocodile.setEffect("Your Turn Once Per Turn When an opponent's Character is returned to its owner's hand by your effect, look at 3 cards from the top of your deck and place them at the top or bottom of your deck in any order.");
        crocodile.setImagePath("/images/cards/EB02/EB02-023.jpg");
        crocodile.setSet(setCode);
        cardRepository.save(crocodile);

        // EB02-024: Sogeking
        Card sogeking = new Card();
        sogeking.setCardNumber("EB02-024");
        sogeking.setName("Sogeking");
        sogeking.setCardType("Character");
        sogeking.setColor("Blue");
        sogeking.setCost(4);
        sogeking.setPower(5000);
        sogeking.setCounter(1000);
        sogeking.setAttribute("Ranged");
        sogeking.setAffiliations("Sniper Island");
        sogeking.setEffect("According to rules, this card's name is also treated as 'Usopp'.\nOn Play Draw 2 cards and place 2 cards from your hand to the bottom of your deck in any order. Then, return up to character with a cost of 1 or less back to the owner's hand."); // Effect text partially obscured
        sogeking.setImagePath("/images/cards/EB02/EB02-024.jpg");
        sogeking.setSet(setCode);
        cardRepository.save(sogeking);

        // EB02-025: Donquixote Rosinante
        Card rosinante = new Card();
        rosinante.setCardNumber("EB02-025");
        rosinante.setName("Donquixote Rosinante");
        rosinante.setCardType("Character");
        rosinante.setColor("Blue");
        rosinante.setCost(2);
        rosinante.setPower(3000);
        rosinante.setCounter(1000);
        rosinante.setAttribute("Special");
        rosinante.setAffiliations("Navy / Donquixote Pirates");
        rosinante.setEffect("Activate: Main You may rest 1 of your DON!! cards and this Character: If your Leader is [Donquixote Rosinante], look at 5 cards from the top of your deck and play up to 1 Character card with a cost of 2 or less rested. Then, place the rest at the bottom of your deck in any order.");
        rosinante.setImagePath("/images/cards/EB02/EB02-025.jpg");
        rosinante.setSet(setCode);
        cardRepository.save(rosinante);

        // EB02-026: Nefeltari Vivi
        Card vivi = new Card();
        vivi.setCardNumber("EB02-026");
        vivi.setName("Nefeltari Vivi");
        vivi.setCardType("Character");
        vivi.setColor("Blue");
        vivi.setCost(3);
        vivi.setPower(2000);
        vivi.setCounter(1000);
        vivi.setAttribute("Slash"); // Attribute looks like Slash
        vivi.setAffiliations("Alabasta");
        vivi.setEffect("On Play If your Leader is multi-colored and you have 5 or less cards in hand, draw 2 cards.");
        vivi.setImagePath("/images/cards/EB02/EB02-026.jpg");
        vivi.setSet(setCode);
        cardRepository.save(vivi);

        // EB02-027: Vista
        Card vista = new Card();
        vista.setCardNumber("EB02-027");
        vista.setName("Vista");
        vista.setCardType("Character");
        vista.setColor("Blue");
        vista.setCost(4);
        vista.setPower(5000);
        vista.setCounter(1000);
        vista.setAttribute("Slash");
        vista.setAffiliations("Whitebeard Pirates");
        vista.setEffect("On Play Place up to 1 of your opponent's characters of 1000 power or less at the bottom of the owner's deck.");
        vista.setImagePath("/images/cards/EB02/EB02-027.jpg");
        vista.setSet(setCode);
        cardRepository.save(vista);

        // EB02-028: Portgas D. Ace
        Card ace = new Card();
        ace.setCardNumber("EB02-028");
        ace.setName("Portgas D. Ace");
        ace.setCardType("Character");
        ace.setColor("Blue");
        ace.setCost(5);
        ace.setPower(5000);
        ace.setCounter(1000);
        ace.setAttribute("Special");
        ace.setAffiliations("Whitebeard Pirates / Alabasta");
        ace.setEffect("On Play If your leader's types include {Whitebeard Pirates}, look at the top 5 cards of your deck, reveal up to one cost 2 character and put it into your hand. Then, place the rest on the bottom of your deck in any order and play up to one cost 2 character from your hand as rested.");
        ace.setImagePath("/images/cards/EB02/EB02-028.jpg");
        ace.setSet(setCode);
        cardRepository.save(ace);

        // EB02-029: Grandpa Ryu
        Card grandpaRyu = new Card();
        grandpaRyu.setCardNumber("EB02-029");
        grandpaRyu.setName("Grandpa Ryu");
        grandpaRyu.setCardType("Character");
        grandpaRyu.setColor("Blue");
        grandpaRyu.setCost(3);
        grandpaRyu.setPower(5000);
        grandpaRyu.setCounter(1000);
        grandpaRyu.setAttribute("Wisdom");
        grandpaRyu.setAffiliations("Animals / East Blue");
        grandpaRyu.setEffect(null); // No effect text visible (SAMPLE)
        grandpaRyu.setImagePath("/images/cards/EB02/EB02-029.jpg");
        grandpaRyu.setSet(setCode);
        cardRepository.save(grandpaRyu);

        // EB02-030: That Time is When Your Friend's Dreams are Laughed at!
        Card thatTime = new Card();
        thatTime.setCardNumber("EB02-030");
        thatTime.setName("That Time is When Your Friend's Dreams are Laughed at!");
        thatTime.setCardType("Event");
        thatTime.setColor("Blue");
        thatTime.setCost(2);
        thatTime.setPower(null);
        thatTime.setCounter(null);
        thatTime.setAffiliations("Straw Hat Crew / Alabasta");
        thatTime.setEffect("Counter This turn, when one of your characters would be KO'd in battle, you may instead discard 1 card from your hand.\nTrigger Draw 1 card.");
        thatTime.setImagePath("/images/cards/EB02/EB02-030.jpg");
        thatTime.setSet(setCode);
        cardRepository.save(thatTime);

        // EB02-031: Hope
        Card hope = new Card();
        hope.setCardNumber("EB02-031");
        hope.setName("Hope");
        hope.setCardType("Event");
        hope.setColor("Blue"); // Frame color is Blue
        hope.setCost(2);
        hope.setPower(null);
        hope.setCounter(null);
        hope.setAffiliations("Music");
        hope.setEffect("Main Look at the top 4 cards of your deck, reveal 1 card with a cost of 4 or more and add it to your hand. Then, place the rest at the bottom of your deck in any order.\nTrigger Activate this card's Main effect.");
        hope.setImagePath("/images/cards/EB02/EB02-031.jpg");
        hope.setSet(setCode);
        cardRepository.save(hope);

        // --- End of Blue EB-02 Card Data ---

        // --- Purple Cards ---

        // EB02-032: Iceburg
        Card iceburg = new Card();
        iceburg.setCardNumber("EB02-032");
        iceburg.setName("Iceburg");
        iceburg.setCardType("Character");
        iceburg.setColor("Purple");
        iceburg.setCost(1);
        iceburg.setPower(0);
        iceburg.setCounter(2000);
        iceburg.setAttribute("Wisdom");
        iceburg.setAffiliations("Water 7 / Galley-La Company");
        iceburg.setEffect("On Play If there are 3 or more DON!! cards on your field, look at 7 cards from the top of your deck; reveal up to 1 [Galley-La Company] and add it to your hand. Then, place the rest at the bottom of your deck in any order and play up to 1 [Galley-La Company] from your hand.");
        iceburg.setImagePath("/images/cards/EB02/EB02-032.jpg");
        iceburg.setSet(setCode);
        cardRepository.save(iceburg);

        // EB02-033: Klabautermann
        Card klabautermann = new Card();
        klabautermann.setCardNumber("EB02-033");
        klabautermann.setName("Klabautermann");
        klabautermann.setCardType("Character");
        klabautermann.setColor("Purple");
        klabautermann.setCost(1);
        klabautermann.setPower(0);
        klabautermann.setCounter(1000);
        klabautermann.setAttribute("Wisdom");
        klabautermann.setAffiliations("Fairy");
        klabautermann.setEffect("If you have a {Going Merry} in play, this character gains Blocker."); // Effect text partially obscured
        klabautermann.setImagePath("/images/cards/EB02/EB02-033.jpg");
        klabautermann.setSet(setCode);
        cardRepository.save(klabautermann);

        // EB02-034: Komei
        Card komei = new Card();
        komei.setCardNumber("EB02-034");
        komei.setName("Komei");
        komei.setCardType("Character");
        komei.setColor("Purple");
        komei.setCost(4);
        komei.setPower(6000);
        komei.setCounter(1000);
        komei.setAttribute("Wisdom");
        komei.setAffiliations("Navy / Foxy Pirates");
        komei.setEffect(null); // No effect text visible (SAMPLE)
        komei.setImagePath("/images/cards/EB02/EB02-034.jpg");
        komei.setSet(setCode);
        cardRepository.save(komei);

        // EB02-035: Sanji & Pudding
        Card sanjiPudding = new Card();
        sanjiPudding.setCardNumber("EB02-035");
        sanjiPudding.setName("Sanji & Pudding");
        sanjiPudding.setCardType("Character");
        sanjiPudding.setColor("Purple");
        sanjiPudding.setCost(5);
        sanjiPudding.setPower(7000);
        sanjiPudding.setCounter(null); // No Counter
        sanjiPudding.setAttribute("Strike"); // Attribute obscured, assuming Strike
        sanjiPudding.setAffiliations("Strawhat Crew / Big Mom Pirates");
        sanjiPudding.setEffect("Your Turn Once Per Turn When 2 or more of your DON!! cards are returned to your DON!! deck, set up to one DON!! card from your DON!! deck as active.\nOn Play If your number of DON!! cards are equal to or less than your opponent's, draw 1 card.");
        sanjiPudding.setImagePath("/images/cards/EB02/EB02-035.jpg");
        sanjiPudding.setSet(setCode);
        cardRepository.save(sanjiPudding);

        // EB02-036: Nico Robin
        Card nicoRobin = new Card();
        nicoRobin.setCardNumber("EB02-036");
        nicoRobin.setName("Nico Robin");
        nicoRobin.setCardType("Character");
        nicoRobin.setColor("Purple");
        nicoRobin.setCost(3);
        nicoRobin.setPower(2000);
        nicoRobin.setCounter(1000);
        nicoRobin.setAttribute("Strike"); // Attribute obscured, assuming Strike based on similar cards
        nicoRobin.setAffiliations("Straw Hat Crew");
        nicoRobin.setEffect("Blocker\nOn K.O. DON!!-1: Look at the top 3 cards of your deck, reveal up to 1 {Strawhat Crew} type card and put it into your hand. Then place the rest on the bottom of your deck in any order.");
        nicoRobin.setImagePath("/images/cards/EB02/EB02-036.jpg");
        nicoRobin.setSet(setCode);
        cardRepository.save(nicoRobin);

        // EB02-037: Franky
        Card franky = new Card();
        franky.setCardNumber("EB02-037");
        franky.setName("Franky");
        franky.setCardType("Character");
        franky.setColor("Purple");
        franky.setCost(3);
        franky.setPower(4000);
        franky.setCounter(1000);
        franky.setAttribute("Strike");
        franky.setAffiliations("Straw Hat Crew / Water Seven");
        franky.setEffect("On Play / When Attacking If your leader has the {Straw Hat Crew} type and the number of your DON!! cards on board are equal to or less than your opponent's, set up to 1 DON!! card from your DON!! deck as rested.");
        franky.setImagePath("/images/cards/EB02/EB02-037.jpg");
        franky.setSet(setCode);
        cardRepository.save(franky);

        // EB02-038: Magellan
        Card magellan = new Card();
        magellan.setCardNumber("EB02-038");
        magellan.setName("Magellan");
        magellan.setCardType("Character");
        magellan.setColor("Purple");
        magellan.setCost(3);
        magellan.setPower(4000);
        magellan.setCounter(1000);
        magellan.setAttribute("Special");
        magellan.setAffiliations("Impel Down");
        magellan.setEffect("On Play Play a 2 Cost or lower {Impel Down} type Character card from your hand.");
        magellan.setImagePath("/images/cards/EB02/EB02-038.jpg");
        magellan.setSet(setCode);
        cardRepository.save(magellan);

        // EB02-039: GERMA 66
        Card germa66 = new Card();
        germa66.setCardNumber("EB02-039");
        germa66.setName("GERMA 66");
        germa66.setCardType("Event");
        germa66.setColor("Purple");
        germa66.setCost(4);
        germa66.setPower(null);
        germa66.setCounter(null);
        germa66.setAffiliations("Vinsmoke Family / Germa 66");
        germa66.setEffect("Main You may discard a character with 4000 or less power and the {Germa 66} type from your hand: If the number of DON!! cards on your board is equal to or less than your opponent's, play a character card from your trash that has 5000 to 7000 power and the same name as the discarded card.");
        germa66.setImagePath("/images/cards/EB02/EB02-039.jpg");
        germa66.setSet(setCode);
        cardRepository.save(germa66);

        // EB02-040: BRAND NEW WORLD
        Card brandNewWorld = new Card();
        brandNewWorld.setCardNumber("EB02-040");
        brandNewWorld.setName("BRAND NEW WORLD");
        brandNewWorld.setCardType("Event");
        brandNewWorld.setColor("Purple"); // Frame color is Purple
        brandNewWorld.setCost(2);
        brandNewWorld.setPower(null);
        brandNewWorld.setCounter(null);
        brandNewWorld.setAffiliations("Music");
        brandNewWorld.setEffect("Main Look at the top 4 cards of your deck, reveal 1 card with a cost of 4 or more and add it to your hand. Then, place the rest at the bottom of your deck in any order.\nTrigger Activate this card's Main effect.");
        brandNewWorld.setImagePath("/images/cards/EB02/EB02-040.jpg");
        brandNewWorld.setSet(setCode);
        cardRepository.save(brandNewWorld);

        // EB02-041: Going Merry
        Card goingMerry = new Card();
        goingMerry.setCardNumber("EB02-041");
        goingMerry.setName("Going Merry");
        goingMerry.setCardType("Event"); // Card says Event, likely Stage based on effect
        goingMerry.setColor("Purple");
        goingMerry.setCost(1);
        goingMerry.setPower(null);
        goingMerry.setCounter(null);
        goingMerry.setAffiliations("Straw Hat Crew");
        goingMerry.setEffect("On Play If your leader has the type {Straw Hat Crew}, draw 1 card.\nActivate: Main You may rest this stage: If the number of DON!! cards in your field is equal or less to the number of DON!! cards on your opponent's field, give up to 1 of your {Straw Hat Crew} type characters +2 cost until the end of your opponent's next turn."); // Corrected wording
        goingMerry.setImagePath("/images/cards/EB02/EB02-041.jpg");
        goingMerry.setSet(setCode);
        cardRepository.save(goingMerry);

        // --- End of Purple EB-02 Card Data ---

        // --- Black Cards ---

        // EB02-042: All-Hunt Grount
        Card grount = new Card();
        grount.setCardNumber("EB02-042");
        grount.setName("All-Hunt Grount");
        grount.setCardType("Character");
        grount.setColor("Black");
        grount.setCost(6);
        grount.setPower(8000);
        grount.setCounter(1000);
        grount.setAttribute("Strike");
        grount.setAffiliations("Navy");
        grount.setEffect(null); // No effect text visible (SAMPLE)
        grount.setImagePath("/images/cards/EB02/EB02-042.jpg");
        grount.setSet(setCode);
        cardRepository.save(grount);

        // EB02-043: Jonathan
        Card jonathan = new Card();
        jonathan.setCardNumber("EB02-043");
        jonathan.setName("Jonathan");
        jonathan.setCardType("Character");
        jonathan.setColor("Black");
        jonathan.setCost(7);
        jonathan.setPower(9000);
        jonathan.setCounter(1000);
        jonathan.setAttribute("Wisdom");
        jonathan.setAffiliations("Navy");
        jonathan.setEffect(null); // No effect text visible (SAMPLE)
        jonathan.setImagePath("/images/cards/EB02/EB02-043.jpg");
        jonathan.setSet(setCode);
        cardRepository.save(jonathan);

        // EB02-044: Sengoku
        Card sengoku = new Card();
        sengoku.setCardNumber("EB02-044");
        sengoku.setName("Sengoku");
        sengoku.setCardType("Character");
        sengoku.setColor("Black");
        sengoku.setCost(7);
        sengoku.setPower(7000);
        sengoku.setCounter(1000);
        sengoku.setAttribute("Wisdom");
        sengoku.setAffiliations("Navy");
        sengoku.setEffect("Blocker\nOn Play Play up to 1 Black {Navy} type Character card with a cost of 4 or less from your trash rested.");
        sengoku.setImagePath("/images/cards/EB02/EB02-044.jpg");
        sengoku.setSet(setCode);
        cardRepository.save(sengoku);

        // EB02-045: Trafalgar Law
        Card law = new Card();
        law.setCardNumber("EB02-045");
        law.setName("Trafalgar Law");
        law.setCardType("Character");
        law.setColor("Black"); // Frame is Black/Green
        law.setCost(5);
        law.setPower(6000);
        law.setCounter(1000);
        law.setAttribute("Slash");
        law.setAffiliations("Dressrosa / Supernova / Heart Pirates");
        law.setEffect("Blocker\nOn Play You may return 2 cards from your trash to the bottom of your deck in any order: Choose one of the following.\n- Draw 1 card.\n- If your opponent has 5 or more cards in their hand, they discard 1 card from their hand.");
        law.setImagePath("/images/cards/EB02/EB02-045.jpg");
        law.setSet(setCode);
        cardRepository.save(law);

        // EB02-046: Hildon
        Card hildon = new Card();
        hildon.setCardNumber("EB02-046");
        hildon.setName("Hildon");
        hildon.setCardType("Character");
        hildon.setColor("Black");
        hildon.setCost(3);
        hildon.setPower(3000);
        hildon.setCounter(2000);
        hildon.setAttribute("Wisdom");
        hildon.setAffiliations("Thriller Bark Pirates");
        hildon.setEffect("On Play Trash 2 cards from the top of your deck, then give up to 1 of your opponent's characters -1 cost during this turn.");
        hildon.setImagePath("/images/cards/EB02/EB02-046.jpg");
        hildon.setSet(setCode);
        cardRepository.save(hildon);

        // EB02-047: Blueno
        Card blueno = new Card();
        blueno.setCardNumber("EB02-047");
        blueno.setName("Blueno");
        blueno.setCardType("Character");
        blueno.setColor("Black");
        blueno.setCost(5);
        blueno.setPower(6000);
        blueno.setCounter(1000);
        blueno.setAttribute("Strike");
        blueno.setAffiliations("CP9");
        blueno.setEffect("Activate: Main You may discard 1 card from your hand and place this character in your trash: Play up to one cost 5 or lower character with {CP} included in its types from your trash.");
        blueno.setImagePath("/images/cards/EB02/EB02-047.jpg");
        blueno.setSet(setCode);
        cardRepository.save(blueno);

        // EB02-048: Brook
        Card brook = new Card();
        brook.setCardNumber("EB02-048");
        brook.setName("Brook");
        brook.setCardType("Character");
        brook.setColor("Black");
        brook.setCost(5);
        brook.setPower(6000);
        brook.setCounter(1000);
        brook.setAttribute("Slash");
        brook.setAffiliations("Straw Hat Crew");
        brook.setEffect("On Play You may add up to one {Laboon} from your trash to your hand.\nOn K.O. You may play up to one 4 Cost or lower {Laboon} from your hand."); // Effect text partially obscured
        brook.setImagePath("/images/cards/EB02/EB02-048.jpg");
        brook.setSet(setCode);
        cardRepository.save(brook);

        // EB02-049: Garp
        Card garp = new Card();
        garp.setCardNumber("EB02-049");
        garp.setName("Garp");
        garp.setCardType("Character");
        garp.setColor("Black");
        garp.setCost(5);
        garp.setPower(6000);
        garp.setCounter(null); // No Counter
        garp.setAttribute("Strike");
        garp.setAffiliations("Navy");
        garp.setEffect("On Play Give your Leader up to 2 rested DON!! cards.\nActivate: Main You may rest this character: If your leader is {Monkey D. Garp}, K.O. up to one of your opponent's cost 1 or lower characters.");
        garp.setImagePath("/images/cards/EB02/EB02-049.jpg");
        garp.setSet(setCode);
        cardRepository.save(garp);

        // EB02-050: Map of the heart
        Card mapOfTheHeart = new Card();
        mapOfTheHeart.setCardNumber("EB02-050");
        mapOfTheHeart.setName("Map of the heart");
        mapOfTheHeart.setCardType("Event");
        mapOfTheHeart.setColor("Black"); // Frame color is Black
        mapOfTheHeart.setCost(2);
        mapOfTheHeart.setPower(null);
        mapOfTheHeart.setCounter(null);
        mapOfTheHeart.setAffiliations("Music");
        mapOfTheHeart.setEffect("Main Look at the top 4 cards of your deck, reveal 1 card with a cost of 4 or more and add it to your hand. Then, place the rest at the bottom of your deck in any order.\nTrigger Activate this card's Main effect.");
        mapOfTheHeart.setImagePath("/images/cards/EB02/EB02-050.jpg");
        mapOfTheHeart.setSet(setCode);
        cardRepository.save(mapOfTheHeart);

        // EB02-051: Three Verse Hum: Arrow Notch Cut
        Card arrowNotchCut = new Card();
        arrowNotchCut.setCardNumber("EB02-051");
        arrowNotchCut.setName("Three Verse Hum: Arrow Notch Cut");
        arrowNotchCut.setCardType("Event");
        arrowNotchCut.setColor("Black");
        arrowNotchCut.setCost(3);
        arrowNotchCut.setPower(null);
        arrowNotchCut.setCounter(null);
        arrowNotchCut.setAffiliations("Former Rumbar Pirates");
        arrowNotchCut.setEffect("Main Choose one of the following:\n- K.O. up to one of your opponent's characters with the cost of 2 or lower.\n- Give up to one of your opponent's characters -4 cost for this turn.");
        arrowNotchCut.setImagePath("/images/cards/EB02/EB02-051.jpg");
        arrowNotchCut.setSet(setCode);
        cardRepository.save(arrowNotchCut);

        // --- End of Black EB-02 Card Data ---

        // --- Yellow Cards ---

        // EB02-052: Enel
        Card enel = new Card();
        enel.setCardNumber("EB02-052");
        enel.setName("Enel");
        enel.setCardType("Character");
        enel.setColor("Yellow");
        enel.setCost(10);
        enel.setPower(11000);
        enel.setCounter(null); // No Counter
        enel.setAttribute("Special");
        enel.setAffiliations("Sky Island");
        enel.setEffect("If your leader has the {Sky Island} type, this character gains Rush.\nWhen Attacking You may trash 1 card from your hand: If your life has 1 or less cards, place up to 1 card from the top of your deck onto your life. Then give this character +1000 power for this turn.");
        enel.setImagePath("/images/cards/EB02/EB02-052.jpg");
        enel.setSet(setCode);
        cardRepository.save(enel);

        // EB02-053: Olga Myskinga
        Card olga = new Card();
        olga.setCardNumber("EB02-053");
        olga.setName("Olga Myskinga");
        olga.setCardType("Character");
        olga.setColor("Yellow");
        olga.setCost(3);
        olga.setPower(4000);
        olga.setCounter(1000);
        olga.setAttribute("Wisdom");
        olga.setAffiliations("Alchemi");
        olga.setEffect("On Play / On K.O. Look at the top card of your or your opponent's Life, move it to the top or bottom of the Life cards.");
        olga.setImagePath("/images/cards/EB02/EB02-053.jpg");
        olga.setSet(setCode);
        cardRepository.save(olga);

        // EB02-054: Sanji
        Card sanji = new Card();
        sanji.setCardNumber("EB02-054");
        sanji.setName("Sanji");
        sanji.setCardType("Character");
        sanji.setColor("Yellow");
        sanji.setCost(5);
        sanji.setPower(6000);
        sanji.setCounter(1000);
        sanji.setAttribute("Strike");
        sanji.setAffiliations("East Blue / Straw Hat Crew");
        sanji.setEffect("Blocker\nOn Play If you have 2 or less life, draw 2 cards and trash 1 card from your hand.");
        sanji.setImagePath("/images/cards/EB02/EB02-054.jpg");
        sanji.setSet(setCode);
        cardRepository.save(sanji);

        // EB02-055: Jinbe
        Card jinbe = new Card();
        jinbe.setCardNumber("EB02-055");
        jinbe.setName("Jinbe");
        jinbe.setCardType("Character");
        jinbe.setColor("Yellow");
        jinbe.setCost(4);
        jinbe.setPower(5000);
        jinbe.setCounter(2000);
        jinbe.setAttribute("Strike");
        jinbe.setAffiliations("Fish-Man / Straw Hat Crew");
        jinbe.setEffect("Trigger If your Leader has the {Merfolk} or {Fish-man} type and you have 2 or less Life cards, play this card.");
        jinbe.setImagePath("/images/cards/EB02/EB02-055.jpg");
        jinbe.setSet(setCode);
        cardRepository.save(jinbe);

        // EB02-056: Vegapunk
        Card vegapunk = new Card();
        vegapunk.setCardNumber("EB02-056");
        vegapunk.setName("Vegapunk");
        vegapunk.setCardType("Character");
        vegapunk.setColor("Yellow");
        vegapunk.setCost(5);
        vegapunk.setPower(0);
        vegapunk.setCounter(1000);
        vegapunk.setAttribute("Wisdom");
        vegapunk.setAffiliations("Egghead / Scientist");
        vegapunk.setEffect("Blocker\nOn Play Look at the top 5 cards of your deck, play up to 1 cost 5 or lower {Scientist} type Character other than \"Vegapunk\". Then, place the rest at the bottom of your deck in any order, and if your opponent has 2 characters or less, discard 1 card.\nTrigger Draw 1 card.");
        vegapunk.setImagePath("/images/cards/EB02/EB02-056.jpg");
        vegapunk.setSet(setCode);
        cardRepository.save(vegapunk);

        // EB02-067: Mad Treasure (Note: Card number typo likely, assuming 057)
        Card madTreasure = new Card();
        madTreasure.setCardNumber("EB02-057"); // Corrected number
        madTreasure.setName("Mad Treasure");
        madTreasure.setCardType("Character");
        madTreasure.setColor("Yellow");
        madTreasure.setCost(4);
        madTreasure.setPower(5000);
        madTreasure.setCounter(1000);
        madTreasure.setAttribute("Special");
        madTreasure.setAffiliations("Treasure Pirates");
        madTreasure.setEffect("When Attacking You may add 1 card from the top or bottom of your Life to your hand: Add up to 1 of your opponent's Characters with a cost of 3 or less to the top or bottom of your opponent's Life.");
        madTreasure.setImagePath("/images/cards/EB02/EB02-067.jpg"); // Using provided image path
        madTreasure.setSet(setCode);
        cardRepository.save(madTreasure);

        // EB02-058: Us!
        Card us = new Card();
        us.setCardNumber("EB02-058");
        us.setName("Us!");
        us.setCardType("Event");
        us.setColor("Yellow"); // Frame color is Yellow
        us.setCost(2);
        us.setPower(null);
        us.setCounter(null);
        us.setAffiliations("Music");
        us.setEffect("Main Look at the top 4 cards of your deck, reveal 1 card with a cost of 4 or more and add it to your hand. Then, place the rest at the bottom of your deck in any order.\nTrigger Activate this card's Main effect.");
        us.setImagePath("/images/cards/EB02/EB02-058.jpg");
        us.setSet(setCode);
        cardRepository.save(us);

        // EB02-059: Without you... I can't become King of the Pirates!!!!
        Card withoutYou = new Card();
        withoutYou.setCardNumber("EB02-059");
        withoutYou.setName("Without you... I can't become King of the Pirates!!!!");
        withoutYou.setCardType("Event");
        withoutYou.setColor("Yellow");
        withoutYou.setCost(4);
        withoutYou.setPower(null);
        withoutYou.setCounter(null);
        withoutYou.setAffiliations("Straw Hat Crew");
        withoutYou.setEffect("Counter Give your Leader or up to one of your Characters +1000 power for this battle. Then, if your life total is 1 or less, play up to one yellow cost 5 or lower {Straw Hat Crew} type or \"Sanji\" Character from your hand.");
        withoutYou.setImagePath("/images/cards/EB02/EB02-059.jpg");
        withoutYou.setSet(setCode);
        cardRepository.save(withoutYou);

        // EB02-060: Going Merry
        Card goingMerryYellow = new Card(); // Different variable name from Purple Going Merry
        goingMerryYellow.setCardNumber("EB02-060");
        goingMerryYellow.setName("Going Merry");
        goingMerryYellow.setCardType("Stage");
        goingMerryYellow.setColor("Yellow");
        goingMerryYellow.setCost(2);
        goingMerryYellow.setPower(null);
        goingMerryYellow.setCounter(null);
        goingMerryYellow.setAffiliations("Straw Hat Crew");
        goingMerryYellow.setEffect("Activate: Main You may rest this stage and turn the top card of your life face-up: Give up to one of your {Strawhat Crew} type characters +1000 power until the end of your opponent's next turn.");
        goingMerryYellow.setImagePath("/images/cards/EB02/EB02-060.jpg");
        goingMerryYellow.setSet(setCode);
        cardRepository.save(goingMerryYellow);

        // --- Secret Rare ---

        // EB02-061: Monkey D. Luffy
        Card luffySec = new Card();
        luffySec.setCardNumber("EB02-061");
        luffySec.setName("Monkey D. Luffy");
        luffySec.setCardType("Character");
        luffySec.setColor("Purple/Yellow"); // Dual color
        luffySec.setCost(6);
        luffySec.setPower(7000);
        luffySec.setCounter(null); // No Counter
        luffySec.setAttribute("Strike");
        luffySec.setAffiliations("Water 7 / Straw Hat Crew");
        luffySec.setEffect("If your Leader is multi-coloured and your opponent has 5 or more DON!! cards on the field, this Character gains Rush.\nWhen Attacking Once per Turn Return 2 of your active DON!! cards to your DON!! deck: Set this Character as active. Then, add the top card of your life to your hand.");
        luffySec.setImagePath("/images/cards/EB02/EB02-061.jpg");
        luffySec.setSet(setCode);
        cardRepository.save(luffySec);

        // --- End of Yellow & SEC EB-02 Card Data ---

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 