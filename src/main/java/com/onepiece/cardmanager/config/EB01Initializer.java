package com.onepiece.cardmanager.config;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(12) // After OP10 and ST sets
public class EB01Initializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public EB01Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        String setCode = "EB01";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // EB01-001: Kozuki Oden (Leader)
        Card kozukiOden = new Card();
        kozukiOden.setCardNumber("EB01-001");
        kozukiOden.setName("Kozuki Oden");
        kozukiOden.setCardType("Leader");
        kozukiOden.setColor("Green");
        kozukiOden.setPower(5000);
        kozukiOden.setLife(4);
        kozukiOden.setAttribute("Slash");
        kozukiOden.setAffiliations("Land of Wano / Kozuki Clan");
        kozukiOden.setEffect("According to the rules, your character cards with the type (Land of Wano) without a counter have +1000 counter.\\nDON!!×1 When Attacking If you have a cost 5 or greater (Land of Wano) character in play, this leader gets +1000 power until the start of your next turn.");
        kozukiOden.setImagePath("/images/cards/EB01/EB01-001.png");
        cardRepository.save(kozukiOden);

        // EB01-002: Izou
        Card izou = new Card();
        izou.setCardNumber("EB01-002");
        izou.setName("Izou");
        izou.setCardType("Character");
        izou.setColor("Red");
        izou.setCost(3);
        izou.setPower(7000);
        izou.setAttribute("Ranged");
        izou.setAffiliations("Land of Wano / Whitebeard Pirates");
        izou.setEffect("On Play Attach up to one rested DON!! to your leader or one of your characters.\\nWhen opponent attack Once Per Turn You may trash 1 card from your hand: If your leader has the (Land of Wano) or (Whitebeard Pirates) type, give up to one of your opponent's leader or character -2000 power for this turn.");
        izou.setImagePath("/images/cards/EB01/EB01-002.png");
        cardRepository.save(izou);

        // EB01-003: Kid and Killer
        Card kidAndKiller = new Card();
        kidAndKiller.setCardNumber("EB01-003");
        kidAndKiller.setName("Kid and Killer");
        kidAndKiller.setCardType("Character");
        kidAndKiller.setColor("Red");
        kidAndKiller.setCost(4);
        kidAndKiller.setPower(5000);
        kidAndKiller.setAttribute("Slash");
        kidAndKiller.setAffiliations("Supernova/Kid Pirates");
        kidAndKiller.setEffect("Rush (This card can attack on the turn in which it is played.)\\nWhen Attacking If your opponent has 2 or less life cards, this character gains +2000 Power until the end of the turn.");
        kidAndKiller.setImagePath("/images/cards/EB01/EB01-003.png");
        cardRepository.save(kidAndKiller);

        // EB01-004: Koza
        Card koza = new Card();
        koza.setCardNumber("EB01-004");
        koza.setName("Koza");
        koza.setCardType("Character");
        koza.setColor("Red");
        koza.setCost(2);
        koza.setPower(3000);
        koza.setCounter(1000);
        koza.setAttribute("Ranged");
        koza.setAffiliations("Alabasta Kingdom");
        koza.setEffect("When Attacking You may give 1 of your active Leaders -5000 Power: Give up to 1 of your opponent's characters power -3000 for this turn.");
        koza.setImagePath("/images/cards/EB01/EB01-004.png");
        cardRepository.save(koza);

        // EB01-005: Doma
        Card doma = new Card();
        doma.setCardNumber("EB01-005");
        doma.setName("Doma");
        doma.setCardType("Character");
        doma.setColor("Red");
        doma.setCost(1);
        doma.setPower(3000);
        doma.setCounter(1000);
        doma.setAttribute("Slash");
        doma.setAffiliations("Whitebeard Pirates Allies");
        doma.setImagePath("/images/cards/EB01/EB01-005.png");
        cardRepository.save(doma);

        // EB01-006: Tony Tony Chopper
        Card chopper = new Card();
        chopper.setCardNumber("EB01-006");
        chopper.setName("Tony Tony Chopper");
        chopper.setCardType("Character");
        chopper.setColor("Red");
        chopper.setCost(3);
        chopper.setPower(4000);
        chopper.setCounter(1000);
        chopper.setAttribute("Strike");
        chopper.setAffiliations("Animal / Straw Hat Crew");
        chopper.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\nDON!!×2 When Attacking Give up to 1 of your opponent's Characters -3000 Power during this turn.");
        chopper.setImagePath("/images/cards/EB01/EB01-006.png");
        cardRepository.save(chopper);

        // EB01-007: Yamato
        Card yamato = new Card();
        yamato.setCardNumber("EB01-007");
        yamato.setName("Yamato");
        yamato.setCardType("Character");
        yamato.setColor("Red");
        yamato.setCost(5);
        yamato.setPower(5000);
        yamato.setCounter(2000);
        yamato.setAttribute("Strike");
        yamato.setAffiliations("Land of Wano");
        yamato.setEffect("Activate: Main Once Per Turn Give up to 1 rested DON!! card to your Leader or 1 of your Characters.");
        yamato.setImagePath("/images/cards/EB01/EB01-007.png");
        cardRepository.save(yamato);

        // EB01-008: Little Oars Jr.
        Card littleOarsJr = new Card();
        littleOarsJr.setCardNumber("EB01-008");
        littleOarsJr.setName("Little Oars Jr.");
        littleOarsJr.setCardType("Character");
        littleOarsJr.setColor("Red");
        littleOarsJr.setCost(6);
        littleOarsJr.setPower(7000);
        littleOarsJr.setCounter(1000);
        littleOarsJr.setAttribute("Strike");
        littleOarsJr.setAffiliations("Giant / Whitebeard Pirates Allies");
        littleOarsJr.setEffect("Once Per Turn If this character would be KOd by an effect, instead you may trash an event or stage card from your hand.");
        littleOarsJr.setImagePath("/images/cards/EB01/EB01-008.png");
        cardRepository.save(littleOarsJr);

        // EB01-009: Shut Up and Come With Us!!
        Card shutUpAndComeWithUs = new Card();
        shutUpAndComeWithUs.setCardNumber("EB01-009");
        shutUpAndComeWithUs.setName("Shut Up and Come With Us!!");
        shutUpAndComeWithUs.setCardType("Event");
        shutUpAndComeWithUs.setColor("Red");
        shutUpAndComeWithUs.setCost(1);
        shutUpAndComeWithUs.setAffiliations("Drum Kingdom / Straw Hat Crew");
        shutUpAndComeWithUs.setEffect("Counter Look at the top 5 cards of your deck and put up to one cost 3 or less (Animal) type character into play. Then, place the rest on the bottom of your deck in any order.");
        shutUpAndComeWithUs.setImagePath("/images/cards/EB01/EB01-009.png");
        cardRepository.save(shutUpAndComeWithUs);

        // EB01-010: There is no way you could defeat me!!
        Card thereIsNoWay = new Card();
        thereIsNoWay.setCardNumber("EB01-010");
        thereIsNoWay.setName("There is no way you could defeat me!!");
        thereIsNoWay.setCardType("Event");
        thereIsNoWay.setColor("Red");
        thereIsNoWay.setCost(3);
        thereIsNoWay.setAffiliations("Water 7 / Straw Hat Crew");
        thereIsNoWay.setEffect("Counter KO up to one of your opponents characters with an original power of 6000 or less.\\nTrigger KO up to one of your opponents characters with an original power of 5000 or less.");
        thereIsNoWay.setImagePath("/images/cards/EB01/EB01-010.png");
        cardRepository.save(thereIsNoWay);

        // EB01-011: Mini Merry II
        Card miniMerryII = new Card();
        miniMerryII.setCardNumber("EB01-011");
        miniMerryII.setName("Mini Merry II");
        miniMerryII.setCardType("Stage");
        miniMerryII.setColor("Red");
        miniMerryII.setCost(1);
        miniMerryII.setAffiliations("Straw Hat Crew");
        miniMerryII.setEffect("Activate: Main You may rest this card and place one of your character cards with an original power of 1000 on the bottom of your deck: Draw 1 card.");
        miniMerryII.setImagePath("/images/cards/EB01/EB01-011.png");
        cardRepository.save(miniMerryII);

        // EB01-012: Cavendish
        Card cavendish = new Card();
        cavendish.setCardNumber("EB01-012");
        cavendish.setName("Cavendish");
        cavendish.setCardType("Character");
        cavendish.setColor("Green");
        cavendish.setCost(3);
        cavendish.setPower(6000);
        cavendish.setCounter(1000);
        cavendish.setAttribute("Slash");
        cavendish.setAffiliations("Supernova/beautiful pirates");
        cavendish.setEffect("On Play // When Attacking If your leader is a Supernova type and you have no other Cavendish on the field, Active 2 Don.");
        cavendish.setImagePath("/images/cards/EB01/EB01-012.png");
        cardRepository.save(cavendish);

        // EB01-013: Kozuki Hiyori
        Card kozukiHiyori = new Card();
        kozukiHiyori.setCardNumber("EB01-013");
        kozukiHiyori.setName("Kozuki Hiyori");
        kozukiHiyori.setCardType("Character");
        kozukiHiyori.setColor("Green");
        kozukiHiyori.setCost(4);
        kozukiHiyori.setPower(0);
        kozukiHiyori.setCounter(1000);
        kozukiHiyori.setAttribute("Wisdom");
        kozukiHiyori.setAffiliations("Land of Wano/Kouzuki Clan");
        kozukiHiyori.setEffect("Activate: Main You may place this card into your trash: Place up to one cost 5 or less (Land of Wano) type character other than [Kozuki Hiyori] from your hand into play. Then, draw one card.");
        kozukiHiyori.setImagePath("/images/cards/EB01/EB01-013.png");
        cardRepository.save(kozukiHiyori);

        // EB01-014: Sanji
        Card sanji = new Card();
        sanji.setCardNumber("EB01-014");
        sanji.setName("Sanji");
        sanji.setCardType("Character");
        sanji.setColor("Green");
        sanji.setCost(4);
        sanji.setPower(5000);
        sanji.setCounter(2000);
        sanji.setAttribute("Strike");
        sanji.setAffiliations("FILM / Straw Hat Crew");
        sanji.setEffect("DON!!x1 Your Turn For every 3 rested Don!! on your field, this characters gains +1000 power.");
        sanji.setImagePath("/images/cards/EB01/EB01-014.png");
        cardRepository.save(sanji);

        // EB01-015: Scratchmen Apoo
        Card scratchmenApoo = new Card();
        scratchmenApoo.setCardNumber("EB01-015");
        scratchmenApoo.setName("Scratchmen Apoo");
        scratchmenApoo.setCardType("Character");
        scratchmenApoo.setColor("Green");
        scratchmenApoo.setCost(1);
        scratchmenApoo.setPower(1000);
        scratchmenApoo.setCounter(2000);
        scratchmenApoo.setAttribute("Special");
        scratchmenApoo.setAffiliations("Supernova / On Air Pirates");
        scratchmenApoo.setEffect("On Play Rest up to one of your opponent's cost 2 or less characters.");
        scratchmenApoo.setImagePath("/images/cards/EB01/EB01-015.png");
        cardRepository.save(scratchmenApoo);

        // EB01-016: Bingou
        Card bingou = new Card();
        bingou.setCardNumber("EB01-016");
        bingou.setName("Bingou");
        bingou.setCardType("Character");
        bingou.setColor("Green");
        bingou.setCost(1);
        bingou.setPower(0);
        bingou.setCounter(1000);
        bingou.setAttribute("Wisdom");
        bingou.setAffiliations("Land of Wano");
        bingou.setEffect("Activate: Main You may rest this character: KO up to 1 of your opponent's cost 1 or lower characters.");
        bingou.setImagePath("/images/cards/EB01/EB01-016.png");
        cardRepository.save(bingou);

        // EB01-017: Blueno
        Card blueno = new Card();
        blueno.setCardNumber("EB01-017");
        blueno.setName("Blueno");
        blueno.setCardType("Character");
        blueno.setColor("Green");
        blueno.setCost(2);
        blueno.setPower(2000);
        blueno.setCounter(1000);
        blueno.setAttribute("Strike");
        blueno.setAffiliations("FILM / CP0");
        blueno.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        blueno.setImagePath("/images/cards/EB01/EB01-017.png");
        cardRepository.save(blueno);

        // EB01-018: Yama san
        Card yamaSan = new Card();
        yamaSan.setCardNumber("EB01-018");
        yamaSan.setName("Yama san");
        yamaSan.setCardType("Character");
        yamaSan.setColor("Green");
        yamaSan.setCost(3);
        yamaSan.setPower(7000);
        yamaSan.setCounter(1000);
        yamaSan.setAttribute("Strike");
        yamaSan.setAffiliations("Animal/Land of Wano");
        yamaSan.setImagePath("/images/cards/EB01/EB01-018.png");
        cardRepository.save(yamaSan);

        // EB01-019: Off White
        Card offWhite = new Card();
        offWhite.setCardNumber("EB01-019");
        offWhite.setName("Off White");
        offWhite.setCardType("Event");
        offWhite.setColor("Green");
        offWhite.setCost(2);
        offWhite.setAffiliations("The Seven Warlords/Donquixote Pirates");
        offWhite.setEffect("Counter Give up to 1 of your Leader or Characters Power +4000 for this battle. Then, look at the top 3 cards of your deck, reveal up to 1 [Donquixote Pirates] type Character card and add it to your hand. Then, return the remaining cards to the bottom of your deck in your desired order.");
        offWhite.setImagePath("/images/cards/EB01/EB01-019.png");
        cardRepository.save(offWhite);

        // EB01-020: Shambles
        Card shambles = new Card();
        shambles.setCardNumber("EB01-020");
        shambles.setName("Shambles");
        shambles.setCardType("Event");
        shambles.setColor("Green");
        shambles.setCost(1);
        shambles.setAffiliations("Supernovas / Heart Pirates");
        shambles.setEffect("Main If your leader has the (Supernovas) type, return one of your characters to its owners hand. Then, put up to one cost 2 or less character of a different color than the returned card from your hand into play.\\nTrigger Activate this card's Main ability.");
        shambles.setImagePath("/images/cards/EB01/EB01-020.png");
        cardRepository.save(shambles);

        // EB01-021: Hannyabal
        Card hannyabal = new Card();
        hannyabal.setCardNumber("EB01-021");
        hannyabal.setName("Hannyabal");
        hannyabal.setCardType("Leader");
        hannyabal.setColor("Purple");
        hannyabal.setPower(5000);
        hannyabal.setLife(4);
        hannyabal.setAttribute("Slash");
        hannyabal.setAffiliations("Impel Down");
        hannyabal.setEffect("At the end of your turn You may return one of your cost 2 or greater (Impel Down) characters to your hand: Set up to one Don!! card from your Don!! deck as active.");
        hannyabal.setImagePath("/images/cards/EB01/EB01-021.png");
        cardRepository.save(hannyabal);

        // EB01-022: Inazuma
        Card inazuma = new Card();
        inazuma.setCardNumber("EB01-022");
        inazuma.setName("Inazuma");
        inazuma.setCardType("Character");
        inazuma.setColor("Blue");
        inazuma.setCost(6);
        inazuma.setPower(7000);
        inazuma.setCounter(1000);
        inazuma.setAttribute("Slash");
        inazuma.setAffiliations("Impel Down / Revolutionary Army");
        inazuma.setEffect("End of Your Turn If you have 2 or less cards in hand, draw 2 cards.");
        inazuma.setImagePath("/images/cards/EB01/EB01-022.png");
        cardRepository.save(inazuma);

        // EB01-023: Edward Weevil
        Card edwardWeevil = new Card();
        edwardWeevil.setCardNumber("EB01-023");
        edwardWeevil.setName("Edward Weevil");
        edwardWeevil.setCardType("Character");
        edwardWeevil.setColor("Blue");
        edwardWeevil.setCost(4);
        edwardWeevil.setPower(6000);
        edwardWeevil.setAttribute("Slash");
        edwardWeevil.setAffiliations("Seven Warlords of the Sea");
        edwardWeevil.setEffect("On Play Draw a card.");
        edwardWeevil.setImagePath("/images/cards/EB01/EB01-023.png");
        cardRepository.save(edwardWeevil);

        // EB01-024: Hamlet
        Card hamlet = new Card();
        hamlet.setCardNumber("EB01-024");
        hamlet.setName("Hamlet");
        hamlet.setCardType("Character");
        hamlet.setColor("Blue");
        hamlet.setCost(3);
        hamlet.setPower(4000);
        hamlet.setCounter(1000);
        hamlet.setAttribute("Slash");
        hamlet.setAffiliations("Animal Kingdom Pirates/SMILE");
        hamlet.setEffect("If you have 4 or less cards in your hand, all of your <SMILE> characters get +1000 power.");
        hamlet.setImagePath("/images/cards/EB01/EB01-024.png");
        cardRepository.save(hamlet);

        // EB01-025: Fortricks
        Card fortricks = new Card();
        fortricks.setCardNumber("EB01-025");
        fortricks.setName("Fortricks");
        fortricks.setCardType("Character");
        fortricks.setColor("Blue");
        fortricks.setCost(3);
        fortricks.setPower(5000);
        fortricks.setCounter(1000);
        fortricks.setAttribute("Slash");
        fortricks.setAffiliations("Animal Kingdom Pirates / SMILE");
        fortricks.setImagePath("/images/cards/EB01/EB01-025.png");
        cardRepository.save(fortricks);

        // EB01-026: Prince Bellett
        Card princeBellett = new Card();
        princeBellett.setCardNumber("EB01-026");
        princeBellett.setName("Prince Bellett");
        princeBellett.setCardType("Character");
        princeBellett.setColor("Blue");
        princeBellett.setCost(2);
        princeBellett.setPower(2000);
        princeBellett.setCounter(2000);
        princeBellett.setAttribute("Ranged");
        princeBellett.setAffiliations("Impel Down");
        princeBellett.setEffect("DON!!x1 When Attacking If you have 1 or less cards in your hand, return up to 1 Character with a cost of 3 or less to the owner's hand.");
        princeBellett.setImagePath("/images/cards/EB01/EB01-026.png");
        cardRepository.save(princeBellett);

        // EB01-027: Mr.1 (Daz Bonez)
        Card mrOne = new Card();
        mrOne.setCardNumber("EB01-027");
        mrOne.setName("Mr.1 (Daz Bonez)");
        mrOne.setCardType("Character");
        mrOne.setColor("Blue");
        mrOne.setCost(5);
        mrOne.setPower(6000);
        mrOne.setCounter(1000);
        mrOne.setAttribute("Slash");
        mrOne.setAffiliations("Baroque Works");
        mrOne.setEffect("If your leader's type includes (Baroque Works), this character gains +1000 power for every 2 event cards in your trash.\\nOn Play Draw 2 cards then trash 1 card from your hand.");
        mrOne.setImagePath("/images/cards/EB01/EB01-027.png");
        cardRepository.save(mrOne);

        // EB01-028: Gum Gum Champion Rifle
        Card gumGumChampionRifle = new Card();
        gumGumChampionRifle.setCardNumber("EB01-028");
        gumGumChampionRifle.setName("Gum Gum Champion Rifle");
        gumGumChampionRifle.setCardType("Event");
        gumGumChampionRifle.setColor("Blue");
        gumGumChampionRifle.setCost(1);
        gumGumChampionRifle.setAffiliations("Straw Hat Crew/Impel Down");
        gumGumChampionRifle.setEffect("Counter If your Leader has the [Impel Down] type, give up to 1 of your leader or characters +2000 Power until the end of this battle. Then, your opponent returns 1 of their active characters to the owner's hand.\\nTrigger Return up to one cost 3 or lower character to the bottom of it's owner's deck");
        gumGumChampionRifle.setImagePath("/images/cards/EB01/EB01-028.png");
        cardRepository.save(gumGumChampionRifle);

        // EB01-029: Sorry, I'm dead
        Card sorryImDead = new Card();
        sorryImDead.setCardNumber("EB01-029");
        sorryImDead.setName("Sorry, I'm dead");
        sorryImDead.setCardType("Event");
        sorryImDead.setColor("Blue");
        sorryImDead.setCost(1);
        sorryImDead.setAffiliations("East Blue / Straw Hat Crew");
        sorryImDead.setEffect("Counter Reveal the top card of your deck. If the revealed card has a cost of 4 or greater, return up to one of your characters to your hand. Then, place the revealed card on the bottom of your deck.\\nTrigger Return up to one cost 8 or less character to its owner's hand.");
        sorryImDead.setImagePath("/images/cards/EB01/EB01-029.png");
        cardRepository.save(sorryImDead);

        // EB01-030: Logue Town
        Card logueTown = new Card();
        logueTown.setCardNumber("EB01-030");
        logueTown.setName("Logue Town");
        logueTown.setCardType("Stage");
        logueTown.setColor("Blue");
        logueTown.setCost(2);
        logueTown.setAffiliations("East Blue");
        logueTown.setEffect("Activate: Main You may place this card and one card from your hand on the bottom of your deck in any order: Draw 2 cards.\\nTrigger Play this card.");
        logueTown.setImagePath("/images/cards/EB01/EB01-030.png");
        cardRepository.save(logueTown);

        // EB01-031: Khalifa
        Card khalifa = new Card();
        khalifa.setCardNumber("EB01-031");
        khalifa.setName("Khalifa");
        khalifa.setCardType("Character");
        khalifa.setColor("Purple");
        khalifa.setCost(5);
        khalifa.setPower(5000);
        khalifa.setCounter(1000);
        khalifa.setAttribute("Wisdom");
        khalifa.setAffiliations("Water 7 / Galley-la Company");
        khalifa.setEffect("On Play Don!!-1: If your leader has the {Water 7} type, return up to 2 cost 4 or less character cards from your trash to your hand.");
        khalifa.setImagePath("/images/cards/EB01/EB01-031.png");
        cardRepository.save(khalifa);

        // EB01-032: Army Wolf
        Card armyWolf = new Card();
        armyWolf.setCardNumber("EB01-032");
        armyWolf.setName("Army Wolf");
        armyWolf.setCardType("Character");
        armyWolf.setColor("Purple");
        armyWolf.setCost(3);
        armyWolf.setPower(7000);
        armyWolf.setCounter(1000);
        armyWolf.setAttribute("Strike");
        armyWolf.setAffiliations("Animal / Impel Down");
        armyWolf.setImagePath("/images/cards/EB01/EB01-032.png");
        cardRepository.save(armyWolf);

        // EB01-033: Blueno
        Card bluenoPurple = new Card();
        bluenoPurple.setCardNumber("EB01-033");
        bluenoPurple.setName("Blueno");
        bluenoPurple.setCardType("Character");
        bluenoPurple.setColor("Purple");
        bluenoPurple.setCost(4);
        bluenoPurple.setPower(5000);
        bluenoPurple.setCounter(1000);
        bluenoPurple.setAttribute("Wisdom");
        bluenoPurple.setAffiliations("Water 7");
        bluenoPurple.setEffect("On Play Don!!-1: If your leader has the [W7] type, play up to 1 cost 5 or lower [W7] type character card other than \"Blueno\" from your hand or trash.");
        bluenoPurple.setImagePath("/images/cards/EB01/EB01-033.png");
        cardRepository.save(bluenoPurple);

        // EB01-034: Miss Wednesday
        Card missWednesday = new Card();
        missWednesday.setCardNumber("EB01-034");
        missWednesday.setName("Miss Wednesday");
        missWednesday.setCardType("Character");
        missWednesday.setColor("Purple");
        missWednesday.setCost(3);
        missWednesday.setPower(4000);
        missWednesday.setCounter(1000);
        missWednesday.setAttribute("Slash");
        missWednesday.setAffiliations("Baroque Works");
        missWednesday.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\nOn opponent's attack Once Per Turn DON!!-1: (You may return the specified number of DON!! cards from your field to your DON!! deck) If your Leader's type includes 'Baroque Works', add up to 1 DON!! card from your DON!! deck and set it as active.");
        missWednesday.setImagePath("/images/cards/EB01/EB01-034.png");
        cardRepository.save(missWednesday);

        // EB01-035: Miss Monday
        Card missMonday = new Card();
        missMonday.setCardNumber("EB01-035");
        missMonday.setName("Miss Monday");
        missMonday.setCardType("Character");
        missMonday.setColor("Purple");
        missMonday.setCost(3);
        missMonday.setPower(5000);
        missMonday.setCounter(1000);
        missMonday.setAttribute("Strike");
        missMonday.setAffiliations("Baroque Works");
        missMonday.setEffect("On Play If your Leader's type includes \"Baroque Works\", give up to 1 of your Leader or Characters +1000 power during this turn.\\nTrigger DON!! -1 (You may return the specified number of DON!! cards from your field to your DON!! deck): Play this card.");
        missMonday.setImagePath("/images/cards/EB01/EB01-035.png");
        cardRepository.save(missMonday);

        // EB01-036: Minochihuahua
        Card minochihuahua = new Card();
        minochihuahua.setCardNumber("EB01-036");
        minochihuahua.setName("Minochihuahua");
        minochihuahua.setCardType("Character");
        minochihuahua.setColor("Purple");
        minochihuahua.setCost(4);
        minochihuahua.setPower(5000);
        minochihuahua.setAttribute("Strike");
        minochihuahua.setAffiliations("Impel Down / Jailer Beast");
        minochihuahua.setEffect("Rush (This card can attack on the turn in which it is played.)\\nOn K.O. If your Leader has the (Impel Down) type, add up to 1 DON!! card from your DON!! deck and rest it.");
        minochihuahua.setImagePath("/images/cards/EB01/EB01-036.png");
        cardRepository.save(minochihuahua);

        // EB01-037: Mr.9
        Card mrNine = new Card();
        mrNine.setCardNumber("EB01-037");
        mrNine.setName("Mr.9");
        mrNine.setCardType("Character");
        mrNine.setColor("Purple");
        mrNine.setCost(3);
        mrNine.setPower(4000);
        mrNine.setCounter(1000);
        mrNine.setAttribute("Strike");
        mrNine.setAffiliations("Baroque Works");
        mrNine.setEffect("On opponent's attack Once Per Turn Don!!-1:(You may return the specified number of DON!! cards from your field to your DON!! deck) K.O. up to one of your opponents cost 2 or less characters.");
        mrNine.setImagePath("/images/cards/EB01/EB01-037.png");
        cardRepository.save(mrNine);

        // EB01-038: Okama Way
        Card okamaWay = new Card();
        okamaWay.setCardNumber("EB01-038");
        okamaWay.setName("Okama Way");
        okamaWay.setCardType("Event");
        okamaWay.setColor("Purple");
        okamaWay.setCost(1);
        okamaWay.setAffiliations("Baroque Works");
        okamaWay.setEffect("Counter DON!!-1 If your leader has \"Baroque Works\" in its Types, choose one of your characters. It becomes the target of the attack.\\nTrigger DON!!-1 Draw 2 cards");
        okamaWay.setImagePath("/images/cards/EB01/EB01-038.png");
        cardRepository.save(okamaWay);

        // EB01-039: Ragnarok
        Card ragnarok = new Card();
        ragnarok.setCardNumber("EB01-039");
        ragnarok.setName("Ragnarok");
        ragnarok.setCardType("Event");
        ragnarok.setColor("Purple");
        ragnarok.setCost(5);
        ragnarok.setAffiliations("The Four Emperors / Animal Kingdom");
        ragnarok.setEffect("Main Don!!-1: KO up to one of your opponents cost 8 or less characters.\\nTrigger Set up to one Don!! from your Don!! deck into play as active.");
        ragnarok.setImagePath("/images/cards/EB01/EB01-039.png");
        cardRepository.save(ragnarok);

        // EB01-040: Kyros
        Card kyros = new Card();
        kyros.setCardNumber("EB01-040");
        kyros.setName("Kyros");
        kyros.setCardType("Leader");
        kyros.setColor("Yellow");
        kyros.setPower(5000);
        kyros.setLife(4);
        kyros.setAttribute("Slash");
        kyros.setAffiliations("Dressrosa");
        kyros.setEffect("Activate: Main Once Per Turn You may turn the top card of your life face up: KO up to one of your opponent's cost 0 characters.");
        kyros.setImagePath("/images/cards/EB01/EB01-040.png");
        cardRepository.save(kyros);

        // EB01-041: Crocus
        Card crocus = new Card();
        crocus.setCardNumber("EB01-041");
        crocus.setName("Crocus");
        crocus.setCardType("Character");
        crocus.setColor("Yellow");
        crocus.setCost(6);
        crocus.setPower(8000);
        crocus.setCounter(1000);
        crocus.setAttribute("Wisdom");
        crocus.setAffiliations("Former Roger Pirates");
        crocus.setImagePath("/images/cards/EB01/EB01-041.png");
        cardRepository.save(crocus);

        // EB01-042: Scarlet
        Card scarlet = new Card();
        scarlet.setCardNumber("EB01-042");
        scarlet.setName("Scarlet");
        scarlet.setCardType("Character");
        scarlet.setColor("Yellow");
        scarlet.setCost(2);
        scarlet.setPower(0);
        scarlet.setCounter(1000);
        scarlet.setAttribute("Wisdom");
        scarlet.setAffiliations("Dressrosa");
        scarlet.setEffect("Activate: Main You may trash this Character: Play up to 1 (Dressrosa) type Character card other than [Scarlet] with a cost of 3 or less from your hand rested. Then, give up to 1 of your opponent's Characters Cost -2 during this turn.");
        scarlet.setImagePath("/images/cards/EB01/EB01-042.png");
        cardRepository.save(scarlet);

        // EB01-043: Spandine
        Card spandine = new Card();
        spandine.setCardNumber("EB01-043");
        spandine.setName("Spandine");
        spandine.setCardType("Character");
        spandine.setColor("Yellow");
        spandine.setCost(3);
        spandine.setPower(2000);
        spandine.setCounter(1000);
        spandine.setAttribute("Wisdom");
        spandine.setAffiliations("CP9");
        spandine.setEffect("On Play You may return 3 cards with [CP] in its Types from your trash to the bottom of your deck in any order: Play up to 1 cost 4 or lower Character Card with [CP] in its types other than \"Spandine\" from your trash rested.");
        spandine.setImagePath("/images/cards/EB01/EB01-043.png");
        cardRepository.save(spandine);

        // EB01-044: Funkfreed
        Card funkfreed = new Card();
        funkfreed.setCardNumber("EB01-044");
        funkfreed.setName("Funkfreed");
        funkfreed.setCardType("Character");
        funkfreed.setColor("Yellow");
        funkfreed.setCost(1);
        funkfreed.setPower(1000);
        funkfreed.setCounter(1000);
        funkfreed.setAttribute("Slash");
        funkfreed.setAffiliations("CP9");
        funkfreed.setEffect("Activate: Main You may rest this Character: Give up to 1 of your [Spandam] Characters +3000 Power during this turn.");
        funkfreed.setImagePath("/images/cards/EB01/EB01-044.png");
        cardRepository.save(funkfreed);

        // EB01-045: Brook
        Card brook = new Card();
        brook.setCardNumber("EB01-045");
        brook.setName("Brook");
        brook.setCardType("Character");
        brook.setColor("Yellow");
        brook.setCost(3);
        brook.setPower(4000);
        brook.setCounter(1000);
        brook.setAttribute("Slash");
        brook.setAffiliations("Rumbar Pirates");
        brook.setEffect("On Play If your opponent has a cost 0 Character, this Character gains Rush (This card can attack on the turn in which it is played.)");
        brook.setImagePath("/images/cards/EB01/EB01-045.png");
        cardRepository.save(brook);

        // EB01-046: Brook
        Card brookBlack = new Card();
        brookBlack.setCardNumber("EB01-046");
        brookBlack.setName("Brook");
        brookBlack.setCardType("Character");
        brookBlack.setColor("Black");
        brookBlack.setCost(3);
        brookBlack.setPower(4000);
        brookBlack.setCounter(1000);
        brookBlack.setAttribute("Slash");
        brookBlack.setAffiliations("Straw Hat Crew");
        brookBlack.setEffect("On Play // When Attacking Give up to one of your opponent's characters cost-1 for this turn. Then, KO up to 1 of your opponent's 0 cost characters.");
        brookBlack.setImagePath("/images/cards/EB01/EB01-046.png");
        cardRepository.save(brookBlack);

        // EB01-047: Laboon
        Card laboon = new Card();
        laboon.setCardNumber("EB01-047");
        laboon.setName("Laboon");
        laboon.setCardType("Character");
        laboon.setColor("Yellow");
        laboon.setCost(2);
        laboon.setPower(0);
        laboon.setCounter(1000);
        laboon.setAttribute("Strike");
        laboon.setAffiliations("Animal");
        laboon.setEffect("Once Per Turn When a Character is K.O'd, draw 1 card and trash 1 card from your hand.");
        laboon.setImagePath("/images/cards/EB01/EB01-047.png");
        cardRepository.save(laboon);

        // EB01-048: Laboon
        Card laboonBlue = new Card();
        laboonBlue.setCardNumber("EB01-048");
        laboonBlue.setName("Laboon");
        laboonBlue.setCardType("Character");
        laboonBlue.setColor("Blue");
        laboonBlue.setCost(4);
        laboonBlue.setPower(5000);
        laboonBlue.setCounter(1000);
        laboonBlue.setAttribute("Strike");
        laboonBlue.setAffiliations("Animal");
        laboonBlue.setEffect("Activate: Main You may rest this character: Give up to one of your opponent's characters cost -4 for this turn.");
        laboonBlue.setImagePath("/images/cards/EB01/EB01-048.png");
        cardRepository.save(laboonBlue);

        // EB01-049: T Bone
        Card tBone = new Card();
        tBone.setCardNumber("EB01-049");
        tBone.setName("T Bone");
        tBone.setCardType("Character");
        tBone.setColor("Yellow");
        tBone.setCost(5);
        tBone.setPower(5000);
        tBone.setCounter(2000);
        tBone.setAttribute("Slash");
        tBone.setAffiliations("Water 7 / Navy");
        tBone.setEffect("On Play KO up to 1 of your opponent's 2 cost or lower characters.");
        tBone.setImagePath("/images/cards/EB01/EB01-049.png");
        cardRepository.save(tBone);

        // EB01-050: I want to live!!!!
        Card iWantToLive = new Card();
        iWantToLive.setCardNumber("EB01-050");
        iWantToLive.setName("I want to live!!!!");
        iWantToLive.setCardType("Event");
        iWantToLive.setColor("Black");
        iWantToLive.setCost(3);
        iWantToLive.setAffiliations("Straw Hat Crew");
        iWantToLive.setEffect("Counter If the number of cards in your trash is 30 or greater, place the top card of your deck on top of your life pile.");
        iWantToLive.setImagePath("/images/cards/EB01/EB01-050.png");
        cardRepository.save(iWantToLive);

        // EB01-051: Shigan (Finger Gun)
        Card shigan = new Card();
        shigan.setCardNumber("EB01-051");
        shigan.setName("Shigan (Finger Gun)");
        shigan.setCardType("Event");
        shigan.setColor("Black");
        shigan.setCost(4);
        shigan.setAffiliations("CP9");
        shigan.setEffect("Main You may trash the top 2 cards of your deck: KO up to one of your opponents cost 5 or less characters.\\nTrigger Activate this card's Main ability.");
        shigan.setImagePath("/images/cards/EB01/EB01-051.png");
        cardRepository.save(shigan);

        // EB01-052: Viola
        Card viola = new Card();
        viola.setCardNumber("EB01-052");
        viola.setName("Viola");
        viola.setCardType("Character");
        viola.setColor("Yellow");
        viola.setCost(2);
        viola.setPower(0);
        viola.setCounter(1000);
        viola.setAttribute("Special");
        viola.setAffiliations("Dressrosa");
        viola.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\nOn Play Choose 1 of the following:\\n・Look at all of your opponent's life. Then return them in any order.\\n・Turn all of your life cards face down.");
        viola.setImagePath("/images/cards/EB01/EB01-052.png");
        cardRepository.save(viola);

        // EB01-053: Gastino
        Card gastino = new Card();
        gastino.setCardNumber("EB01-053");
        gastino.setName("Gastino");
        gastino.setCardType("Character");
        gastino.setColor("Yellow");
        gastino.setCost(3);
        gastino.setPower(5000);
        gastino.setAttribute("Special");
        gastino.setAffiliations("Scientist");
        gastino.setEffect("On Play Place up to 1 of your opponent's cost 3 or lower characters to the top or bottom of their life face-up.\\nTrigger Give up to 2 of your opponent's leader or characters Power -3000.");
        gastino.setImagePath("/images/cards/EB01/EB01-053.png");
        cardRepository.save(gastino);

        // EB01-054: Gan Fall
        Card ganFall = new Card();
        ganFall.setCardNumber("EB01-054");
        ganFall.setName("Gan Fall");
        ganFall.setCardType("Character");
        ganFall.setColor("Yellow");
        ganFall.setCost(3);
        ganFall.setPower(4000);
        ganFall.setCounter(1000);
        ganFall.setAttribute("Strike");
        ganFall.setAffiliations("Sky Island");
        ganFall.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\nOn Play If your opponent has 1 or less life, KO up to 1 of your opponent's cost 3 or lower Characters.");
        ganFall.setImagePath("/images/cards/EB01/EB01-054.png");
        cardRepository.save(ganFall);

        // EB01-055: Charlotte Compote
        Card charlotteCompote = new Card();
        charlotteCompote.setCardNumber("EB01-055");
        charlotteCompote.setName("Charlotte Compote");
        charlotteCompote.setCardType("Character");
        charlotteCompote.setColor("Yellow");
        charlotteCompote.setCost(7);
        charlotteCompote.setPower(9000);
        charlotteCompote.setCounter(1000);
        charlotteCompote.setAttribute("Special");
        charlotteCompote.setAffiliations("Big mom pirates");
        charlotteCompote.setImagePath("/images/cards/EB01/EB01-055.png");
        cardRepository.save(charlotteCompote);

        // EB01-056: Charlotte Flampe
        Card charlotteFlampe = new Card();
        charlotteFlampe.setCardNumber("EB01-056");
        charlotteFlampe.setName("Charlotte Flampe");
        charlotteFlampe.setCardType("Character");
        charlotteFlampe.setColor("Yellow");
        charlotteFlampe.setCost(1);
        charlotteFlampe.setPower(1000);
        charlotteFlampe.setCounter(2000);
        charlotteFlampe.setAttribute("Special");
        charlotteFlampe.setAffiliations("Big Mom Pirates");
        charlotteFlampe.setEffect("On Play You may add 1 card from the top or bottom of your Life cards to your hand: Draw 1 card.");
        charlotteFlampe.setImagePath("/images/cards/EB01/EB01-056.png");
        cardRepository.save(charlotteFlampe);

        // EB01-057: Shirahoshi
        Card shirahoshi = new Card();
        shirahoshi.setCardNumber("EB01-057");
        shirahoshi.setName("Shirahoshi");
        shirahoshi.setCardType("Character");
        shirahoshi.setColor("Yellow");
        shirahoshi.setCost(2);
        shirahoshi.setPower(0);
        shirahoshi.setCounter(1000);
        shirahoshi.setAttribute("Wisdom");
        shirahoshi.setAffiliations("Merfolk");
        shirahoshi.setEffect("When this character is KO'd by your opponent's effects, place up to one card from the top of your deck onto your life.\\nBlocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        shirahoshi.setImagePath("/images/cards/EB01/EB01-057.png");
        cardRepository.save(shirahoshi);

        // EB01-058: Mont Blanc Cricket
        Card montBlancCricket = new Card();
        montBlancCricket.setCardNumber("EB01-058");
        montBlancCricket.setName("Mont Blanc Cricket");
        montBlancCricket.setCardType("Character");
        montBlancCricket.setColor("Yellow");
        montBlancCricket.setCost(2);
        montBlancCricket.setPower(3000);
        montBlancCricket.setCounter(1000);
        montBlancCricket.setAttribute("Strike");
        montBlancCricket.setAffiliations("Saruyama Alliance");
        montBlancCricket.setEffect("DON!!x1 Your Turn If you have 2 or less life, this character has +2000 power.");
        montBlancCricket.setImagePath("/images/cards/EB01/EB01-058.png");
        cardRepository.save(montBlancCricket);

        // EB01-059: Raigo
        Card raigo = new Card();
        raigo.setCardNumber("EB01-059");
        raigo.setName("Raigo");
        raigo.setCardType("Event");
        raigo.setColor("Yellow");
        raigo.setCost(6);
        raigo.setAffiliations("Sky Island");
        raigo.setEffect("Main KO up to one of your opponents characters. Then, trash the top of your life cards so your life total becomes 1.\\nTrigger KO up to one of your opponents characters with a cost equal to or less than you and your opponent's total life cards.");
        raigo.setImagePath("/images/cards/EB01/EB01-059.png");
        cardRepository.save(raigo);

        // EB01-060: I am GOD!!!
        Card iAmGod = new Card();
        iAmGod.setCardNumber("EB01-060");
        iAmGod.setName("I am GOD!!!");
        iAmGod.setCardType("Event");
        iAmGod.setColor("Yellow");
        iAmGod.setCost(4);
        iAmGod.setAffiliations("Sky Island");
        iAmGod.setEffect("Main Put up to one cost 7 or less {Enel} from your hand or trash into play. Then trash the top of your life cards so your life total becomes 1.\\nTrigger Draw 2 cards then trash 1 card from your hand.");
        iAmGod.setImagePath("/images/cards/EB01/EB01-060.png");
        cardRepository.save(iAmGod);

        // EB01-061: Mr.2 Bon Clay (Bentham)
        Card mrTwoBonClay = new Card();
        mrTwoBonClay.setCardNumber("EB01-061");
        mrTwoBonClay.setName("Mr.2 Bon Clay (Bentham)");
        mrTwoBonClay.setCardType("Character");
        mrTwoBonClay.setColor("Purple");
        mrTwoBonClay.setCost(4);
        mrTwoBonClay.setPower(1000);
        mrTwoBonClay.setCounter(1000);
        mrTwoBonClay.setAttribute("Special");
        mrTwoBonClay.setAffiliations("Former Baroque Works");
        mrTwoBonClay.setEffect("On Play Add up to 1 DON!! from your DON!! deck as active.\\nWhen Attacking Choose up to 1 of your opponent's characters. This character has the same base power as the chosen character for this turn.");
        mrTwoBonClay.setImagePath("/images/cards/EB01/EB01-061.png");
        cardRepository.save(mrTwoBonClay);

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 