package com.onepiece.cardmanager.config;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(7) // Order after OP06
public class OP07Initializer implements CommandLineRunner {

    private final CardRepository cardRepository;

    @Autowired
    public OP07Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Only initialize if we have no OP07 cards
        if (cardRepository.countBySetAndCardNumberStartingWith("OP07", "OP07") > 0) {
            System.out.println("OP07 cards already exist, skipping initialization");
            return;
        }

        System.out.println("Initializing OP07 cards...");
        
        // Initialize Red cards
        initializeOP07RedCards();

        // Initialize Green cards
        initializeOP07GreenCards();

        // Initialize Blue cards
        initializeOP07BlueCards();

        // Initialize Purple cards
        initializeOP07PurpleCards();

        // Initialize Black cards
        initializeOP07BlackCards();

        // Initialize Yellow cards (and Secret Rares)
        initializeOP07YellowCards();

        System.out.println("Finished initializing OP07 cards");
    }

    private void initializeOP07RedCards() {
        System.out.println("Initializing OP07 Red cards...");

        // Leaders
        Card monkeyDDragonLeader = new Card();
        monkeyDDragonLeader.setCardNumber("OP07-001");
        monkeyDDragonLeader.setName("Monkey D. Dragon");
        monkeyDDragonLeader.setCardType("Leader");
        monkeyDDragonLeader.setColor("Red");
        monkeyDDragonLeader.setPower(5000);
        monkeyDDragonLeader.setLife(5);
        monkeyDDragonLeader.setAffiliations("Revolutionary Army");
        monkeyDDragonLeader.setAttribute("Special");
        monkeyDDragonLeader.setEffect("[Activate: Main] [Once Per Turn] Give up to a total of 2 of your currently attached don to one of your characters.");
        monkeyDDragonLeader.setImagePath("/images/cards/OP07/OP07-001.png");
        cardRepository.save(monkeyDDragonLeader);

        // Characters
        Card ain = new Card();
        ain.setCardNumber("OP07-002");
        ain.setName("Ain");
        ain.setCardType("Character");
        ain.setColor("Red");
        ain.setCost(7);
        ain.setPower(6000);
        // No Counter
        ain.setAffiliations("Film / Neo Navy");
        ain.setAttribute("Special");
        ain.setEffect("[On Play] Set up to one of your opponents characters power to 0 for the turn.");
        ain.setImagePath("/images/cards/OP07/OP07-002.png");
        cardRepository.save(ain);

        Card outlookIII = new Card();
        outlookIII.setCardNumber("OP07-003");
        outlookIII.setName("Outlook III");
        outlookIII.setCardType("Character");
        outlookIII.setColor("Red");
        outlookIII.setCost(2);
        outlookIII.setPower(0);
        outlookIII.setCounter(1000);
        outlookIII.setAffiliations("Goa Kingdom");
        outlookIII.setAttribute("Wisdom");
        outlookIII.setEffect("[Activate: Main] You may place this card in the trash: Give up to two of your opponents characters -2000 power for the turn.");
        outlookIII.setImagePath("/images/cards/OP07/OP07-003.png");
        cardRepository.save(outlookIII);

        Card curlyDadan = new Card();
        curlyDadan.setCardNumber("OP07-004");
        curlyDadan.setName("Curly Dadan");
        curlyDadan.setCardType("Character");
        curlyDadan.setColor("Red");
        curlyDadan.setCost(2);
        curlyDadan.setPower(3000);
        curlyDadan.setCounter(1000);
        curlyDadan.setAffiliations("Mountain bandits");
        curlyDadan.setAttribute("Slash");
        curlyDadan.setEffect("[On Play] You may trash one card from your hand: Look at the top 5 cards of your deck, reveal and add one card with power 2000 or less to your hand. Then, return the rest of the cards to the bottom of your deck.");
        curlyDadan.setImagePath("/images/cards/OP07/OP07-004.png");
        cardRepository.save(curlyDadan);

        Card carina = new Card();
        carina.setCardNumber("OP07-005");
        carina.setName("Carina");
        carina.setCardType("Character");
        carina.setColor("Red");
        carina.setCost(3);
        carina.setPower(0);
        carina.setCounter(1000);
        carina.setAffiliations("FILM / Gran Tesoro");
        carina.setAttribute("Wisdom");
        carina.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[On Play] Give up to one of your opponents characters -2000 Power for the turn.");
        carina.setImagePath("/images/cards/OP07/OP07-005.png");
        cardRepository.save(carina);

        Card stellyRed = new Card();
        stellyRed.setCardNumber("OP07-006");
        stellyRed.setName("Stelly");
        stellyRed.setCardType("Character");
        stellyRed.setColor("Red");
        stellyRed.setCost(1);
        stellyRed.setPower(1000);
        stellyRed.setCounter(1000);
        stellyRed.setAffiliations("Goa Kingdom");
        stellyRed.setAttribute("Wisdom");
        stellyRed.setEffect("[On Play] You may give your 1 active Leader -5000 power during this turn: Draw 1 card and discard 1 card from your hand.");
        stellyRed.setImagePath("/images/cards/OP07/OP07-006.png");
        cardRepository.save(stellyRed);

        Card dice = new Card();
        dice.setCardNumber("OP07-007");
        dice.setName("Dice");
        dice.setCardType("Character");
        dice.setColor("Red");
        dice.setCost(4);
        dice.setPower(6000);
        dice.setCounter(1000);
        dice.setAffiliations("FILM/Gran Tesoro");
        dice.setAttribute("Strike");
        // No Effect
        dice.setImagePath("/images/cards/OP07/OP07-007.png");
        cardRepository.save(dice);

        Card tanakaSan = new Card();
        tanakaSan.setCardNumber("OP07-008");
        tanakaSan.setName("Tanaka-San");
        tanakaSan.setCardType("Character");
        tanakaSan.setColor("Red");
        tanakaSan.setCost(3);
        tanakaSan.setPower(3000);
        // No Counter
        tanakaSan.setAffiliations("Film/Gran Tesoro");
        tanakaSan.setAttribute("Special");
        tanakaSan.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[Trigger] Play this card.");
        tanakaSan.setImagePath("/images/cards/OP07/OP07-008.png");
        cardRepository.save(tanakaSan);

        Card doguraMagura = new Card();
        doguraMagura.setCardNumber("OP07-009");
        doguraMagura.setName("Dogura & Magura");
        doguraMagura.setCardType("Character");
        doguraMagura.setColor("Red");
        doguraMagura.setCost(2);
        doguraMagura.setPower(3000);
        doguraMagura.setCounter(1000);
        doguraMagura.setAffiliations("Mountain Bandits");
        doguraMagura.setAttribute("Slash");
        doguraMagura.setEffect("[On Play] Give up to 1 of your Red Cost 1 Characters [Double Attack] until the end of this turn.");
        doguraMagura.setImagePath("/images/cards/OP07/OP07-009.png");
        cardRepository.save(doguraMagura);

        Card baccarat = new Card();
        baccarat.setCardNumber("OP07-010");
        baccarat.setName("Baccarat");
        baccarat.setCardType("Character");
        baccarat.setColor("Red");
        baccarat.setCost(3);
        baccarat.setPower(4000);
        baccarat.setCounter(1000);
        baccarat.setAffiliations("FILM / Gran Tesoro");
        baccarat.setAttribute("Special");
        baccarat.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[On Opponent's Attack] [Once Per Turn] You may trash 1 card from your hand: Give up to 1 of your Leader or Characters +2000 power during this battle.");
        baccarat.setImagePath("/images/cards/OP07/OP07-010.png");
        cardRepository.save(baccarat);

        Card bluejam = new Card();
        bluejam.setCardNumber("OP07-011");
        bluejam.setName("Bluejam");
        bluejam.setCardType("Character");
        bluejam.setColor("Red");
        bluejam.setCost(4);
        bluejam.setPower(5000);
        bluejam.setCounter(1000);
        bluejam.setAffiliations("Goa Kingdom / Bluejam Pirates");
        bluejam.setAttribute("Ranged");
        bluejam.setEffect("[DON!!x1] [When Attacking] KO up to one of your opponents characters with 2000 Power or less.");
        bluejam.setImagePath("/images/cards/OP07/OP07-011.png");
        cardRepository.save(bluejam);

        Card porushiumi = new Card();
        porushiumi.setCardNumber("OP07-012");
        porushiumi.setName("Porushuumi");
        porushiumi.setCardType("Character");
        porushiumi.setColor("Red");
        porushiumi.setCost(2);
        porushiumi.setPower(3000);
        porushiumi.setCounter(1000);
        porushiumi.setAffiliations("Goa Kingdom/Bluejam Pirates");
        porushiumi.setAttribute("Slash");
        porushiumi.setEffect("[On Play] Give up to one of your opponents Characters -1000 power for the turn.");
        porushiumi.setImagePath("/images/cards/OP07/OP07-012.png");
        cardRepository.save(porushiumi);

        Card maskedDeuce = new Card();
        maskedDeuce.setCardNumber("OP07-013");
        maskedDeuce.setName("Masked Deuce");
        maskedDeuce.setCardType("Character");
        maskedDeuce.setColor("Red");
        maskedDeuce.setCost(1);
        maskedDeuce.setPower(2000);
        maskedDeuce.setCounter(1000);
        maskedDeuce.setAffiliations("Spade Pirates");
        maskedDeuce.setAttribute("Wisdom");
        maskedDeuce.setEffect("[On Play] If your Leader is [Portgas D. Ace], look at 5 cards from the top of your deck; reveal up to 1 [Portgas D. Ace] or Red Event card and add it to your hand. Then, place the rest at the bottom of your deck in any order.");
        maskedDeuce.setImagePath("/images/cards/OP07/OP07-013.png");
        cardRepository.save(maskedDeuce);

        Card moda = new Card();
        moda.setCardNumber("OP07-014");
        moda.setName("Moda");
        moda.setCardType("Character");
        moda.setColor("Red");
        moda.setCost(1);
        moda.setPower(0);
        moda.setCounter(2000);
        moda.setAffiliations("Lulusia Kingdom");
        moda.setAttribute("Wisdom");
        moda.setEffect("[Your Turn] [On Play] Give up to one of your [Portgas D Ace] +2000 power for the turn.");
        moda.setImagePath("/images/cards/OP07/OP07-014.png");
        cardRepository.save(moda);

        Card monkeyDDragon = new Card();
        monkeyDDragon.setCardNumber("OP07-015");
        monkeyDDragon.setName("Monkey D. Dragon");
        monkeyDDragon.setCardType("Character");
        monkeyDDragon.setColor("Red");
        monkeyDDragon.setCost(8);
        monkeyDDragon.setPower(9000);
        // No Counter
        monkeyDDragon.setAffiliations("Revolutionary Army");
        monkeyDDragon.setAttribute("Special");
        monkeyDDragon.setEffect("[Rush] (This card can attack on the turn in which it is played.)\\n[On Play] Give your leader or up to one of your characters up to 2 rested don!!.");
        monkeyDDragon.setImagePath("/images/cards/OP07/OP07-015.png");
        cardRepository.save(monkeyDDragon);

        // Events
        Card galaxyWink = new Card();
        galaxyWink.setCardNumber("OP07-016");
        galaxyWink.setName("Galaxy Wink");
        galaxyWink.setCardType("Event");
        galaxyWink.setColor("Red");
        galaxyWink.setCost(1);
        galaxyWink.setAffiliations("Revolutionary Army");
        galaxyWink.setEffect("[Main] Give up to one of your characters with the (Revolutionary Type) +2000 Power for the turn. After this, give up to one of your opponents characters -1000 power for the turn.\\n[Trigger] Activate this card's [Main] effect.");
        galaxyWink.setImagePath("/images/cards/OP07/OP07-016.png");
        cardRepository.save(galaxyWink);

        Card dragonsBreath = new Card();
        dragonsBreath.setCardNumber("OP07-017");
        dragonsBreath.setName("Dragon's Breath");
        dragonsBreath.setCardType("Event");
        dragonsBreath.setColor("Red");
        dragonsBreath.setCost(2);
        dragonsBreath.setAffiliations("Revolutionary Army");
        dragonsBreath.setEffect("[Main] KO up to 1 of your opponent's Power 3000 or less characters and up to 1 of your opponent's 1 cost or lower Stage cards.\\n[Trigger] Activate this card's [Main] effect.");
        dragonsBreath.setImagePath("/images/cards/OP07/OP07-017.png");
        cardRepository.save(dragonsBreath);

        Card keepOut = new Card();
        keepOut.setCardNumber("OP07-018");
        keepOut.setName("KEEP OUT");
        keepOut.setCardType("Event");
        keepOut.setColor("Red");
        keepOut.setCost(1);
        keepOut.setAffiliations("Revolutionary Army/Impel Down");
        keepOut.setEffect("[Counter] Give up to one <Revolutionary Army> character +2000 power until the end of YOUR turn.\\n[Trigger] Activate this card's [Counter] effect.");
        keepOut.setImagePath("/images/cards/OP07/OP07-018.png");
        cardRepository.save(keepOut);

        System.out.println("Finished initializing OP07 Red cards");
    }

    private void initializeOP07GreenCards() {
        System.out.println("Initializing OP07 Green cards...");

        // Leaders
        Card jewelryBonneyLeader = new Card();
        jewelryBonneyLeader.setCardNumber("OP07-019");
        jewelryBonneyLeader.setName("Jewelry Bonney");
        jewelryBonneyLeader.setCardType("Leader");
        jewelryBonneyLeader.setColor("Green");
        jewelryBonneyLeader.setPower(5000);
        jewelryBonneyLeader.setLife(5);
        jewelryBonneyLeader.setAffiliations("Supernovas / Bonney Pirates");
        jewelryBonneyLeader.setAttribute("Special");
        jewelryBonneyLeader.setEffect("[When opponent Attacks] [Once Per Turn] ① (You may rest the specified number of DON!! cards in your Cost Area) Rest up to one of your opponents leaders or characters.");
        jewelryBonneyLeader.setImagePath("/images/cards/OP07/OP07-019.png");
        cardRepository.save(jewelryBonneyLeader);

        // Characters
        Card aladdin = new Card();
        aladdin.setCardNumber("OP07-020");
        aladdin.setName("Aladdin");
        aladdin.setCardType("Character");
        aladdin.setColor("Green");
        aladdin.setCost(5);
        aladdin.setPower(6000);
        // No Counter
        aladdin.setAffiliations("Merfolk/Sun Pirates");
        aladdin.setAttribute("Slash");
        aladdin.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[On K.O.] If your leader has the <Fishman> type, summon a 3 cost or lower <Fishman> or <Merfolk> type character card from your hand.");
        aladdin.setImagePath("/images/cards/OP07/OP07-020.png");
        cardRepository.save(aladdin);

        Card uroge = new Card();
        uroge.setCardNumber("OP07-021");
        uroge.setName("Uroge");
        uroge.setCardType("Character");
        uroge.setColor("Green");
        uroge.setCost(4);
        uroge.setPower(5000);
        uroge.setCounter(1000);
        uroge.setAffiliations("Supernovas/Fallen Monk Pirates");
        uroge.setAttribute("Strike");
        uroge.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[End of Your Turn] Set up to one of your Don!! cards as active.");
        uroge.setImagePath("/images/cards/OP07/OP07-021.png");
        cardRepository.save(uroge);

        Card otamaGreen = new Card();
        otamaGreen.setCardNumber("OP07-022");
        otamaGreen.setName("Otama");
        otamaGreen.setCardType("Character");
        otamaGreen.setColor("Green");
        otamaGreen.setCost(1);
        otamaGreen.setPower(0);
        otamaGreen.setCounter(2000);
        otamaGreen.setAffiliations("Land of Wano");
        otamaGreen.setAttribute("Special");
        otamaGreen.setEffect("[On Play] Look at the top 5 cards of your deck, reveal up to one green {Land of Wano} type card other than [Otama] and put it into your hand. Then, place the rest of the cards on the bottom of your deck in any order.");
        otamaGreen.setImagePath("/images/cards/OP07/OP07-022.png");
        cardRepository.save(otamaGreen);

        Card caribou = new Card();
        caribou.setCardNumber("OP07-023");
        caribou.setName("Caribou");
        caribou.setCardType("Character");
        caribou.setColor("Green");
        caribou.setCost(4);
        caribou.setPower(5000);
        caribou.setCounter(1000);
        caribou.setAffiliations("Supernova / Caribou Pirates");
        caribou.setAttribute("Special");
        caribou.setEffect("If you have 6 or more rested DON!! cards, this Character gains +1000 power.\\n[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        caribou.setImagePath("/images/cards/OP07/OP07-023.png");
        cardRepository.save(caribou);

        Card koalaGreen = new Card();
        koalaGreen.setCardNumber("OP07-024");
        koalaGreen.setName("Koala");
        koalaGreen.setCardType("Character");
        koalaGreen.setColor("Green");
        koalaGreen.setCost(3);
        koalaGreen.setPower(0);
        koalaGreen.setCounter(1000);
        koalaGreen.setAffiliations("Foolshout Island");
        koalaGreen.setAttribute("Wisdom");
        koalaGreen.setEffect("[When opponent attack] You may rest this card; Give up to one of your characters with cost 5 or lower and the type {Fishman} [Blocker] for this turn.");
        koalaGreen.setImagePath("/images/cards/OP07/OP07-024.png");
        cardRepository.save(koalaGreen);

        Card coribou = new Card();
        coribou.setCardNumber("OP07-025");
        coribou.setName("Coribou");
        coribou.setCardType("Character");
        coribou.setColor("Green");
        coribou.setCost(3);
        coribou.setPower(3000);
        // No Counter
        coribou.setAffiliations("Supernova / Caribou Pirates");
        coribou.setAttribute("Strike");
        coribou.setEffect("[On Play] Play up to 1 Cost 4 or lower [Caribou] from your hand rested.");
        coribou.setImagePath("/images/cards/OP07/OP07-025.png");
        cardRepository.save(coribou);

        Card jewelryBonney = new Card();
        jewelryBonney.setCardNumber("OP07-026");
        jewelryBonney.setName("Jewelry Bonney");
        jewelryBonney.setCardType("Character");
        jewelryBonney.setColor("Green");
        jewelryBonney.setCost(5);
        jewelryBonney.setPower(6000);
        jewelryBonney.setCounter(1000);
        jewelryBonney.setAffiliations("Supernovas / Bonney Pirates");
        jewelryBonney.setAttribute("Special");
        jewelryBonney.setEffect("[On Play] Up to one of your opponents rested Characters or Don!! do not become active during their next refresh phase.");
        jewelryBonney.setImagePath("/images/cards/OP07/OP07-026.png");
        cardRepository.save(jewelryBonney);

        Card jinbeiGreen = new Card();
        jinbeiGreen.setCardNumber("OP07-027");
        jinbeiGreen.setName("Jinbei");
        jinbeiGreen.setCardType("Character");
        jinbeiGreen.setColor("Green");
        jinbeiGreen.setCost(4);
        jinbeiGreen.setPower(6000);
        jinbeiGreen.setCounter(1000);
        jinbeiGreen.setAffiliations("Fishman/Sun Pirates");
        jinbeiGreen.setAttribute("Strike");
        // No Effect
        jinbeiGreen.setImagePath("/images/cards/OP07/OP07-027.png");
        cardRepository.save(jinbeiGreen);

        Card scratchmenApu = new Card();
        scratchmenApu.setCardNumber("OP07-028");
        scratchmenApu.setName("Scratchmen Apu");
        scratchmenApu.setCardType("Character");
        scratchmenApu.setColor("Green");
        scratchmenApu.setCost(6);
        scratchmenApu.setPower(8000);
        scratchmenApu.setCounter(1000);
        scratchmenApu.setAffiliations("Supernova/On Air Pirates");
        scratchmenApu.setAttribute("Ranged");
        // No Effect
        scratchmenApu.setImagePath("/images/cards/OP07/OP07-028.png");
        cardRepository.save(scratchmenApu);

        Card basilHawkinsGreen = new Card();
        basilHawkinsGreen.setCardNumber("OP07-029");
        basilHawkinsGreen.setName("Basil Hawkins");
        basilHawkinsGreen.setCardType("Character");
        basilHawkinsGreen.setColor("Green");
        basilHawkinsGreen.setCost(6);
        basilHawkinsGreen.setPower(7000);
        // No Counter
        basilHawkinsGreen.setAffiliations("Supernova / Hawkins Pirates");
        basilHawkinsGreen.setAttribute("Slash");
        basilHawkinsGreen.setEffect("If you leader has \"Supernova\" in its types, This character gains [Blocker].\\n[Once Per Turn] If this character were to be removed from play by one of your opponents effects, you may instead rest one of your opponents characters.");
        basilHawkinsGreen.setImagePath("/images/cards/OP07/OP07-029.png");
        cardRepository.save(basilHawkinsGreen);

        Card pappag = new Card();
        pappag.setCardNumber("OP07-030");
        pappag.setName("Pappag");
        pappag.setCardType("Character");
        pappag.setColor("Green");
        pappag.setCost(2);
        pappag.setPower(0);
        pappag.setCounter(2000);
        pappag.setAffiliations("Animal");
        pappag.setAttribute("Wisdom");
        pappag.setEffect("While you have a character {Camie} in play, this character gains [Blocker].");
        pappag.setImagePath("/images/cards/OP07/OP07-030.png");
        cardRepository.save(pappag);

        Card bartolomeoGreen = new Card();
        bartolomeoGreen.setCardNumber("OP07-031");
        bartolomeoGreen.setName("Bartholomeo");
        bartolomeoGreen.setCardType("Character");
        bartolomeoGreen.setColor("Green");
        bartolomeoGreen.setCost(3);
        bartolomeoGreen.setPower(4000);
        bartolomeoGreen.setCounter(1000);
        bartolomeoGreen.setAffiliations("Supernova/bartho Club");
        bartolomeoGreen.setAttribute("Special");
        bartolomeoGreen.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[Your Turn] [Once Per Turn] If a character is rested from your own effects, draw 1 card then trash 1 cards from your hand.");
        bartolomeoGreen.setImagePath("/images/cards/OP07/OP07-031.png");
        cardRepository.save(bartolomeoGreen);

        Card fisherTiger = new Card();
        fisherTiger.setCardNumber("OP07-032");
        fisherTiger.setName("Fisher Tiger");
        fisherTiger.setCardType("Character");
        fisherTiger.setColor("Green");
        fisherTiger.setCost(5);
        fisherTiger.setPower(6000);
        fisherTiger.setCounter(1000);
        fisherTiger.setAffiliations("Fishman/Sun Pirates");
        fisherTiger.setAttribute("Strike");
        fisherTiger.setEffect("This character can attack your opponent's characters on the turn it's played.\\n[On Play] If your leader has the <Fishman> or <Merfolk> type, rest up to 1 of your opponent's 6 cost or lower characters.");
        fisherTiger.setImagePath("/images/cards/OP07/OP07-032.png");
        cardRepository.save(fisherTiger);

        Card monkeyDLuffyGreen = new Card();
        monkeyDLuffyGreen.setCardNumber("OP07-033");
        monkeyDLuffyGreen.setName("Monkey D. Luffy");
        monkeyDLuffyGreen.setCardType("Character");
        monkeyDLuffyGreen.setColor("Green");
        monkeyDLuffyGreen.setCost(5);
        monkeyDLuffyGreen.setPower(6000);
        monkeyDLuffyGreen.setCounter(1000);
        monkeyDLuffyGreen.setAffiliations("Supernova/ Straw Hat Crew");
        monkeyDLuffyGreen.setAttribute("Strike");
        monkeyDLuffyGreen.setEffect("If you have 3 or more characters, your cost 3 or lower characters other than \"Monkey D. Luffy\" cannot be KO'd by your opponent's effects.");
        monkeyDLuffyGreen.setImagePath("/images/cards/OP07/OP07-033.png");
        cardRepository.save(monkeyDLuffyGreen);

        Card roronoaZoroGreen = new Card();
        roronoaZoroGreen.setCardNumber("OP07-034");
        roronoaZoroGreen.setName("Roronoa Zoro");
        roronoaZoroGreen.setCardType("Character");
        roronoaZoroGreen.setColor("Green");
        roronoaZoroGreen.setCost(1);
        roronoaZoroGreen.setPower(2000);
        roronoaZoroGreen.setCounter(1000);
        roronoaZoroGreen.setAffiliations("Supernovas / Strawhat crew");
        roronoaZoroGreen.setAttribute("Slash");
        roronoaZoroGreen.setEffect("[When Attacking] If you have three or more characters in play, this card gains +2000 Power for the turn.");
        roronoaZoroGreen.setImagePath("/images/cards/OP07/OP07-034.png");
        cardRepository.save(roronoaZoroGreen);

        // Events
        Card karmaExposure = new Card();
        karmaExposure.setCardNumber("OP07-035");
        karmaExposure.setName("Karma Exposure");
        karmaExposure.setCardType("Event");
        karmaExposure.setColor("Green");
        karmaExposure.setCost(1);
        karmaExposure.setAffiliations("Supernova / Fallen Monk pirates");
        karmaExposure.setEffect("[Counter] Give up to one leader or character +2000 power for this battle. Then, if you control 3 or more characters, that character gains an additional +1000 Power for this battle.\\n[Trigger] KO up to one of your opponents 4 cost or lower rested Characters.");
        karmaExposure.setImagePath("/images/cards/OP07/OP07-035.png");
        cardRepository.save(karmaExposure);

        Card demonicAura = new Card();
        demonicAura.setCardNumber("OP07-036");
        demonicAura.setName("Demonic Aura Nine-Sword Style Asura: Demon Nine Flash");
        demonicAura.setCardType("Event");
        demonicAura.setColor("Green");
        demonicAura.setCost(2);
        demonicAura.setAffiliations("Supernova/ Straw Hat Crew");
        demonicAura.setEffect("[Main] Up to one of your leader or character cards gains +3000 power during this turn. Then, you may rest one of your cost 3 or greater characters. If you did, rest up to one of your opponent's cost 5 or less characters.\\n[Trigger] You may rest up to one of your opponent's cost 4 or less characters.");
        demonicAura.setImagePath("/images/cards/OP07/OP07-036.png");
        cardRepository.save(demonicAura);

        Card morePizza = new Card();
        morePizza.setCardNumber("OP07-037");
        morePizza.setName("More Pizza!!!");
        morePizza.setCardType("Event");
        morePizza.setColor("Green");
        morePizza.setCost(1);
        morePizza.setAffiliations("Supernova/ Bonney Pirates");
        morePizza.setEffect("[Main] Look at the top 5 cards of your deck and reveal up to one card with the {Supernova} type besides \"More Pizza!!!\" and add it to your hand. Then, place the remaining cards on the bottom of your deck in any order.\\n[Trigger] Draw 1 card");
        morePizza.setImagePath("/images/cards/OP07/OP07-037.png");
        cardRepository.save(morePizza);

        System.out.println("Finished initializing OP07 Green cards");
    }

    private void initializeOP07BlueCards() {
        System.out.println("Initializing OP07 Blue cards...");

        // Leaders
        Card boaHancockLeader = new Card();
        boaHancockLeader.setCardNumber("OP07-038");
        boaHancockLeader.setName("Boa Hancock");
        boaHancockLeader.setCardType("Leader");
        boaHancockLeader.setColor("Blue");
        boaHancockLeader.setPower(5000);
        boaHancockLeader.setLife(5);
        boaHancockLeader.setAffiliations("Seven Warlords of the Sea / Kuja Pirates");
        boaHancockLeader.setAttribute("Special");
        boaHancockLeader.setEffect("[During Your Turn] [Once Per Turn] You may activate this when a character leaves play from one of your abilities. If you have 5 or less cards in hand, draw 1 card.");
        boaHancockLeader.setImagePath("/images/cards/OP07/OP07-038.png");
        cardRepository.save(boaHancockLeader);

        // Characters
        Card edwardWeevil = new Card();
        edwardWeevil.setCardNumber("OP07-039");
        edwardWeevil.setName("Edward Weevil");
        edwardWeevil.setCardType("Character");
        edwardWeevil.setColor("Blue");
        edwardWeevil.setCost(4);
        edwardWeevil.setPower(5000);
        edwardWeevil.setCounter(1000);
        edwardWeevil.setAffiliations("Seven Warlords of the Sea");
        edwardWeevil.setAttribute("Slash");
        edwardWeevil.setEffect("[DON!!x1] [When Attacking] Look at the top 3 cards of your deck and then place them in any order you like at the top or bottom of your deck.");
        edwardWeevil.setImagePath("/images/cards/OP07/OP07-039.png");
        cardRepository.save(edwardWeevil);

        Card crocodileBlue = new Card();
        crocodileBlue.setCardNumber("OP07-040");
        crocodileBlue.setName("Crocodile");
        crocodileBlue.setCardType("Character");
        crocodileBlue.setColor("Blue");
        crocodileBlue.setCost(4);
        crocodileBlue.setPower(5000);
        crocodileBlue.setCounter(2000);
        crocodileBlue.setAffiliations("Seven Warlords of the Sea / Baroque Works");
        crocodileBlue.setAttribute("Special");
        crocodileBlue.setEffect("[On Play] ① (You may rest the specified number of DON!! cards in your Cost Area) Return up to one 2 cost or lower character to the owner's hand.");
        crocodileBlue.setImagePath("/images/cards/OP07/OP07-040.png");
        cardRepository.save(crocodileBlue);

        Card gloriosa = new Card();
        gloriosa.setCardNumber("OP07-041");
        gloriosa.setName("Gloriosa (Elder Nyon)");
        gloriosa.setCardType("Character");
        gloriosa.setColor("Blue");
        gloriosa.setCost(1);
        gloriosa.setPower(0);
        gloriosa.setCounter(1000);
        gloriosa.setAffiliations("Amazon Lily");
        gloriosa.setAttribute("Wisdom");
        gloriosa.setEffect("[On Play] Look at 5 cards from the top of your deck; reveal up to 1 {Amazon Lily} or {Kuja Pirates} type card other than [Gloriosa (Elder Nyon)] and add it to your hand. Then, place the rest at the bottom of your deck in any order.");
        gloriosa.setImagePath("/images/cards/OP07/OP07-041.png");
        cardRepository.save(gloriosa);

        Card geckoMoriaBlue = new Card();
        geckoMoriaBlue.setCardNumber("OP07-042");
        geckoMoriaBlue.setName("Gecko Moria");
        geckoMoriaBlue.setCardType("Character");
        geckoMoriaBlue.setColor("Blue");
        geckoMoriaBlue.setCost(5);
        geckoMoriaBlue.setPower(6000);
        // No Counter
        geckoMoriaBlue.setAffiliations("Seven Warlords of the Sea / Thriller Bark Pirates");
        geckoMoriaBlue.setAttribute("Special");
        geckoMoriaBlue.setEffect("[Once Per Turn] If your leader has the {Seven Warlords of the Sea} type, when this character would leave play by your opponent's effects, instead you may place one of your characters other than [Gecko Moria] on the bottom of your deck.");
        geckoMoriaBlue.setImagePath("/images/cards/OP07/OP07-042.png");
        cardRepository.save(geckoMoriaBlue);

        Card salome = new Card();
        salome.setCardNumber("OP07-043");
        salome.setName("Salome");
        salome.setCardType("Character");
        salome.setColor("Blue");
        salome.setCost(1);
        salome.setPower(2000);
        salome.setCounter(1000);
        salome.setAffiliations("Animal / Kuja Pirates");
        salome.setAttribute("Strike");
        salome.setEffect("[Your Turn] [On Play] Up to one of your [Boa Hancock] gain +2000 Power for the turn.");
        salome.setImagePath("/images/cards/OP07/OP07-043.png");
        cardRepository.save(salome);

        Card mihawk = new Card();
        mihawk.setCardNumber("OP07-044");
        mihawk.setName("Mihawk");
        mihawk.setCardType("Character");
        mihawk.setColor("Blue");
        mihawk.setCost(8);
        mihawk.setPower(10000);
        // No Counter
        mihawk.setAffiliations("Seven Warlords of the Sea");
        mihawk.setAttribute("Slash");
        mihawk.setEffect("[On Play] Draw 1 Card.");
        mihawk.setImagePath("/images/cards/OP07/OP07-044.png");
        cardRepository.save(mihawk);

        Card jinbeBlue = new Card();
        jinbeBlue.setCardNumber("OP07-045");
        jinbeBlue.setName("Jinbe");
        jinbeBlue.setCardType("Character");
        jinbeBlue.setColor("Blue");
        jinbeBlue.setCost(4);
        jinbeBlue.setPower(5000);
        jinbeBlue.setCounter(1000);
        jinbeBlue.setAffiliations("Fishman/Seven Warlords/Sun Pirates");
        jinbeBlue.setAttribute("Strike");
        jinbeBlue.setEffect("[On Play] Play up to 1 Cost 4 or lower <Seven Warlords of the Sea> type character card other than \"Jinbe\" from your hand.");
        jinbeBlue.setImagePath("/images/cards/OP07/OP07-045.png");
        cardRepository.save(jinbeBlue);

        Card sengokuBlue = new Card();
        sengokuBlue.setCardNumber("OP07-046");
        sengokuBlue.setName("Sengoku");
        sengokuBlue.setCardType("Character");
        sengokuBlue.setColor("Blue");
        sengokuBlue.setCost(1);
        sengokuBlue.setPower(2000);
        sengokuBlue.setCounter(1000);
        sengokuBlue.setAffiliations("Navy");
        sengokuBlue.setAttribute("Wisdom");
        sengokuBlue.setEffect("[On Play] Look at the top 5 cards of your deck and reveal up to one card with the {Seven Warlords of the Sea} type and add it to your hand. Then, place the remaining cards on the bottom of your deck in any order.");
        sengokuBlue.setImagePath("/images/cards/OP07/OP07-046.png");
        cardRepository.save(sengokuBlue);

        Card trafalgarLawBlue = new Card();
        trafalgarLawBlue.setCardNumber("OP07-047");
        trafalgarLawBlue.setName("Trafalgar Law");
        trafalgarLawBlue.setCardType("Character");
        trafalgarLawBlue.setColor("Blue");
        trafalgarLawBlue.setCost(4);
        trafalgarLawBlue.setPower(4000);
        trafalgarLawBlue.setCounter(2000);
        trafalgarLawBlue.setAffiliations("Seven Warlords of the Sea / Heart Pirates");
        trafalgarLawBlue.setAttribute("Slash");
        trafalgarLawBlue.setEffect("[Activate: Main] You may return this Character to its owner's hand: If your opponent has 6 or more cards in their hand, they place 1 card from hand on the bottom of their deck.");
        trafalgarLawBlue.setImagePath("/images/cards/OP07/OP07-047.png");
        cardRepository.save(trafalgarLawBlue);

        Card donquixoteDoflamingoBlue = new Card();
        donquixoteDoflamingoBlue.setCardNumber("OP07-048");
        donquixoteDoflamingoBlue.setName("Donquixote Doflamingo");
        donquixoteDoflamingoBlue.setCardType("Character");
        donquixoteDoflamingoBlue.setColor("Blue");
        donquixoteDoflamingoBlue.setCost(3);
        donquixoteDoflamingoBlue.setPower(4000);
        // No Counter
        donquixoteDoflamingoBlue.setAffiliations("The Seven Warlords of the Sea/Donquixote Pirates");
        donquixoteDoflamingoBlue.setAttribute("Special");
        donquixoteDoflamingoBlue.setEffect("[Activate: Main] [Once Per Turn] ② Reveal 1 card from the top of your deck. If that card is a {The Seven Warlords of the Sea} type Character card with a cost of 4 or less, you may play that card rested. Then, place the remaining card on the bottom of your deck.");
        donquixoteDoflamingoBlue.setImagePath("/images/cards/OP07/OP07-048.png");
        cardRepository.save(donquixoteDoflamingoBlue);

        Card buckin = new Card();
        buckin.setCardNumber("OP07-049");
        buckin.setName("Buckin");
        buckin.setCardType("Character");
        buckin.setColor("Blue");
        buckin.setCost(2);
        buckin.setPower(0);
        // No Counter
        buckin.setAffiliations("Weevil's Mom");
        buckin.setAttribute("Wisdom");
        buckin.setEffect("[On Play] Play up to 1 Cost 4 or lower [Edward Weevil] from your hand rested.");
        buckin.setImagePath("/images/cards/OP07/OP07-049.png");
        cardRepository.save(buckin);

        Card boaSandersonia = new Card();
        boaSandersonia.setCardNumber("OP07-050");
        boaSandersonia.setName("Boa Sandersonia");
        boaSandersonia.setCardType("Character");
        boaSandersonia.setColor("Blue");
        boaSandersonia.setCost(3);
        boaSandersonia.setPower(3000);
        boaSandersonia.setCounter(2000);
        boaSandersonia.setAffiliations("Kuja Pirates");
        boaSandersonia.setAttribute("Strike");
        boaSandersonia.setEffect("[On Play] If you have two or more characters in play with the {Amazon Lily} or {Kuja Pirates} type, return up to one of your opponents cost 3 or less character to its owners hand.");
        boaSandersonia.setImagePath("/images/cards/OP07/OP07-050.png");
        cardRepository.save(boaSandersonia);

        Card boaHancock = new Card();
        boaHancock.setCardNumber("OP07-051");
        boaHancock.setName("Boa Hancock");
        boaHancock.setCardType("Character");
        boaHancock.setColor("Blue");
        boaHancock.setCost(6);
        boaHancock.setPower(8000);
        // No Counter
        boaHancock.setAffiliations("Seven Warlords of the Sea / Kuja Pirates");
        boaHancock.setAttribute("Special");
        boaHancock.setEffect("[On Play] Up to one of your opponents characters other than [Monkey D. Luffy] cannot attack until the end of their next turn. Then, place up to one cost 1 or less character on the bottom of its owner's deck.");
        boaHancock.setImagePath("/images/cards/OP07/OP07-051.png");
        cardRepository.save(boaHancock);

        Card boaMarigold = new Card();
        boaMarigold.setCardNumber("OP07-052");
        boaMarigold.setName("Boa Marigold");
        boaMarigold.setCardType("Character");
        boaMarigold.setColor("Blue");
        boaMarigold.setCost(5);
        boaMarigold.setPower(6000);
        boaMarigold.setCounter(1000);
        boaMarigold.setAffiliations("Kuja Pirates");
        boaMarigold.setAttribute("Slash");
        boaMarigold.setEffect("[On Play] If you have two or more characters in play with the {Amazon Lily} or {Kuja Pirates} type, place up to one cost 2 or less character on the bottom of its owners deck.");
        boaMarigold.setImagePath("/images/cards/OP07/OP07-052.png");
        cardRepository.save(boaMarigold);

        Card portugasDAce = new Card();
        portugasDAce.setCardNumber("OP07-053");
        portugasDAce.setName("Portugas.D.Ace");
        portugasDAce.setCardType("Character");
        portugasDAce.setColor("Blue");
        portugasDAce.setCost(5);
        portugasDAce.setPower(6000);
        portugasDAce.setCounter(1000);
        portugasDAce.setAffiliations("Whitebeard Pirates");
        portugasDAce.setAttribute("Special");
        portugasDAce.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[On Play] Draw two cards, then return two cards from your hand to the top or bottom of the deck in the order of your choice.");
        portugasDAce.setImagePath("/images/cards/OP07/OP07-053.png");
        cardRepository.save(portugasDAce);

        Card marguerite = new Card();
        marguerite.setCardNumber("OP07-054");
        marguerite.setName("Marguerite");
        marguerite.setCardType("Character");
        marguerite.setColor("Blue");
        marguerite.setCost(3);
        marguerite.setPower(2000);
        // No Counter
        marguerite.setAffiliations("Amazon Lily");
        marguerite.setAttribute("Wisdom");
        marguerite.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[On Play] Draw a card.");
        marguerite.setImagePath("/images/cards/OP07/OP07-054.png");
        cardRepository.save(marguerite);

        // Events
        Card snakeDance = new Card();
        snakeDance.setCardNumber("OP07-055");
        snakeDance.setName("Snake Dance");
        snakeDance.setCardType("Event");
        snakeDance.setColor("Blue");
        snakeDance.setCost(2);
        snakeDance.setAffiliations("Kuja Pirates");
        snakeDance.setEffect("[Counter] Give up to 1 of your Leader or Characters +4000 power during this battle. Then return up to 1 of your Characters to its owner's hand.\\n[Trigger] You may return 1 of your characters to its owner's hand: Return up to 1 of your opponent's Cost 5 or lower Characters to its owner's hand.");
        snakeDance.setImagePath("/images/cards/OP07/OP07-055.png");
        cardRepository.save(snakeDance);

        Card slaveArrow = new Card();
        slaveArrow.setCardNumber("OP07-056");
        slaveArrow.setName("Slave Arrow");
        slaveArrow.setCardType("Event");
        slaveArrow.setColor("Blue");
        slaveArrow.setCost(1);
        slaveArrow.setAffiliations("Seven Warlords of the Sea/Kuja Pirates");
        slaveArrow.setEffect("[Counter] You may return 1 of your Cost 2 or higher Characters to its owner's hand: Give up to 1 of your Leader or Characters +4000 power during this battle.\\n[Trigger] Draw 2 cards and place 2 cards from your hand on the bottom of your deck.");
        slaveArrow.setImagePath("/images/cards/OP07/OP07-056.png");
        cardRepository.save(slaveArrow);

        Card perfumeFemur = new Card();
        perfumeFemur.setCardNumber("OP07-057");
        perfumeFemur.setName("Perfume Femur");
        perfumeFemur.setCardType("Event");
        perfumeFemur.setColor("Blue");
        perfumeFemur.setCost(2);
        perfumeFemur.setAffiliations("Seven Warlords of the Sea/ Kuja Pirates");
        perfumeFemur.setEffect("[Main] Up to one of your {Seven Warlords of the Sea} type Leader or Character cards gains +2000 power during this turn. Your opponent cannot activate [Blocker] when the selected card attacks.\\n[Trigger] Draw 1 card.");
        perfumeFemur.setImagePath("/images/cards/OP07/OP07-057.png");
        cardRepository.save(perfumeFemur);

        // Stages
        Card isleOfWomen = new Card();
        isleOfWomen.setCardNumber("OP07-058");
        isleOfWomen.setName("Isle Of Women");
        isleOfWomen.setCardType("Stage");
        isleOfWomen.setColor("Blue");
        isleOfWomen.setCost(1);
        isleOfWomen.setAffiliations("Amazon Lily");
        isleOfWomen.setEffect("[Activate: Main] You may discard 1 card from your hand and rest this stage: If your leader has the {Kuja Pirates} type, return up to 1 of your Characters with the {Kuja Pirates} or {Amazon Lily} type to its owner's hand.");
        isleOfWomen.setImagePath("/images/cards/OP07/OP07-058.png");
        cardRepository.save(isleOfWomen);

        System.out.println("Finished initializing OP07 Blue cards");
    }

    private void initializeOP07PurpleCards() {
        System.out.println("Initializing OP07 Purple cards...");

        // Leaders
        Card foxyLeader = new Card();
        foxyLeader.setCardNumber("OP07-059");
        foxyLeader.setName("Foxy");
        foxyLeader.setCardType("Leader");
        foxyLeader.setColor("Purple");
        foxyLeader.setPower(5000);
        foxyLeader.setLife(5);
        foxyLeader.setAffiliations("Foxy Pirates");
        foxyLeader.setAttribute("Special");
        foxyLeader.setEffect("[When Attacking] Don!! -3: If you have 3 or more {Foxy Pirates} characters in play, choose up to one each of your opponents rested leaders and characters. The cards you chose do not become active during their owner's next refresh phase.");
        foxyLeader.setImagePath("/images/cards/OP07/OP07-059.png");
        cardRepository.save(foxyLeader);

        // Characters
        Card itomimizu = new Card();
        itomimizu.setCardNumber("OP07-060");
        itomimizu.setName("Itomimizu");
        itomimizu.setCardType("Character");
        itomimizu.setColor("Purple");
        itomimizu.setCost(3);
        itomimizu.setPower(0);
        itomimizu.setCounter(1000);
        itomimizu.setAffiliations("Foxy Pirates");
        itomimizu.setAttribute("Wisdom");
        itomimizu.setEffect("[Activate: Main] [Once Per Turn] If your leader has the {Foxy Pirates type} and you do not have any other characters in play named [Itomimizu], add up to one rested Don!! from your Don!! deck.");
        itomimizu.setImagePath("/images/cards/OP07/OP07-060.png");
        cardRepository.save(itomimizu);

        Card vinsmokeSanjiPurple = new Card();
        vinsmokeSanjiPurple.setCardNumber("OP07-061");
        vinsmokeSanjiPurple.setName("Vinsmoke Sanji");
        vinsmokeSanjiPurple.setCardType("Character");
        vinsmokeSanjiPurple.setColor("Purple");
        vinsmokeSanjiPurple.setCost(1);
        vinsmokeSanjiPurple.setPower(0);
        vinsmokeSanjiPurple.setCounter(1000);
        vinsmokeSanjiPurple.setAffiliations("Germa Country / Vinsmoke Family");
        vinsmokeSanjiPurple.setAttribute("Strike");
        vinsmokeSanjiPurple.setEffect("[On Play] Don!!-1: If your leader has the type {Vinsmoke Family} draw one card.");
        vinsmokeSanjiPurple.setImagePath("/images/cards/OP07/OP07-061.png");
        cardRepository.save(vinsmokeSanjiPurple);

        Card reijuPurple = new Card();
        reijuPurple.setCardNumber("OP07-062");
        reijuPurple.setName("Reiju");
        reijuPurple.setCardType("Character");
        reijuPurple.setColor("Purple");
        reijuPurple.setCost(1);
        reijuPurple.setPower(2000);
        reijuPurple.setCounter(1000);
        reijuPurple.setAffiliations("Germa Kingdom/ Vinsmoke Family");
        reijuPurple.setAttribute("Strike");
        reijuPurple.setEffect("[On Play] If you have less or equal DON!! than your opponent, return 1 of your 1 cost <Vinsmoke Family> character back to your hand.");
        reijuPurple.setImagePath("/images/cards/OP07/OP07-062.png");
        cardRepository.save(reijuPurple);

        Card capote = new Card();
        capote.setCardNumber("OP07-063");
        capote.setName("Capote");
        capote.setCardType("Character");
        capote.setColor("Purple");
        capote.setCost(3);
        capote.setPower(4000);
        capote.setCounter(1000);
        capote.setAffiliations("Foxy Pirate/Fishman");
        capote.setAttribute("Strike");
        capote.setEffect("[On Play] Don!!-1:If your leader is <Foxy Pirates>, Up to One of your opponents 6 cost or lowerCharacters cannot attack until the end of your opponent turn.");
        capote.setImagePath("/images/cards/OP07/OP07-063.png");
        cardRepository.save(capote);

        Card sanjiSR = new Card();
        sanjiSR.setCardNumber("OP07-064");
        sanjiSR.setName("Sanji");
        sanjiSR.setCardType("Character");
        sanjiSR.setColor("Purple");
        sanjiSR.setCost(6);
        sanjiSR.setPower(6000);
        sanjiSR.setCounter(2000);
        sanjiSR.setAffiliations("Straw Hat Crew");
        sanjiSR.setAttribute("Strike");
        sanjiSR.setEffect("While you have 2 or more don!! cards than your opponent, in your hand this card costs 3 less.\\n[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        sanjiSR.setImagePath("/images/cards/OP07/OP07-064.png");
        cardRepository.save(sanjiSR);

        Card gina = new Card();
        gina.setCardNumber("OP07-065");
        gina.setName("Gina");
        gina.setCardType("Character");
        gina.setColor("Purple");
        gina.setCost(1);
        gina.setPower(0);
        gina.setCounter(2000);
        gina.setAffiliations("Foxy Pirates");
        gina.setAttribute("Wisdom");
        gina.setEffect("[On Play] If your Leader has the {Foxy Pirates} type and the number of DON!! cards on your field is equal to or less than the number on your opponent's field, add up to 1 DON!! card from your DON!! deck and set it as active.");
        gina.setImagePath("/images/cards/OP07/OP07-065.png");
        cardRepository.save(gina);

        Card tonyTonyChopperPurple = new Card();
        tonyTonyChopperPurple.setCardNumber("OP07-066");
        tonyTonyChopperPurple.setName("Tony Tony. Chopper");
        tonyTonyChopperPurple.setCardType("Character");
        tonyTonyChopperPurple.setColor("Purple");
        tonyTonyChopperPurple.setCost(2);
        tonyTonyChopperPurple.setPower(0);
        tonyTonyChopperPurple.setCounter(1000);
        tonyTonyChopperPurple.setAffiliations("Animal / Foxy Pirates");
        tonyTonyChopperPurple.setAttribute("Strike");
        tonyTonyChopperPurple.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[On Play] If your board has DON!! less than or equal to your opponent, add up to 1 DON!! from your DON!! deck rested.");
        tonyTonyChopperPurple.setImagePath("/images/cards/OP07/OP07-066.png");
        cardRepository.save(tonyTonyChopperPurple);

        Card tongjit = new Card();
        tongjit.setCardNumber("OP07-067");
        tongjit.setName("Tongjit");
        tongjit.setCardType("Character");
        tongjit.setColor("Purple");
        tongjit.setCost(1);
        tongjit.setPower(3000);
        tongjit.setCounter(1000);
        tongjit.setAffiliations("long ring long land");
        tongjit.setAttribute("Wisdom");
        // No Effect
        tongjit.setImagePath("/images/cards/OP07/OP07-067.png");
        cardRepository.save(tongjit);

        Card hamburg = new Card();
        hamburg.setCardNumber("OP07-068");
        hamburg.setName("Hamburg");
        hamburg.setCardType("Character");
        hamburg.setColor("Purple");
        hamburg.setCost(5);
        hamburg.setPower(6000);
        hamburg.setCounter(1000);
        hamburg.setAffiliations("Foxy Pirate");
        hamburg.setAttribute("Strike");
        hamburg.setEffect("[DON!!x1] [When Attacking] If your board has DON!! less than or equal to your opponent, add up to 1 DON!! from your DON!! deck rested.");
        hamburg.setImagePath("/images/cards/OP07/OP07-068.png");
        cardRepository.save(hamburg);

        Card pickles = new Card();
        pickles.setCardNumber("OP07-069");
        pickles.setName("Pickles");
        pickles.setCardType("Character");
        pickles.setColor("Purple");
        pickles.setCost(3);
        pickles.setPower(4000);
        pickles.setCounter(1000);
        pickles.setAffiliations("Foxy Pirates");
        pickles.setAttribute("Strike");
        pickles.setEffect("If you have less or equal don than your opponent, Your {Foxy Pirate} characters other than {Pickles} cannot be KOd by your opponents effects.");
        pickles.setImagePath("/images/cards/OP07/OP07-069.png");
        cardRepository.save(pickles);

        Card bigPan = new Card();
        bigPan.setCardNumber("OP07-070");
        bigPan.setName("Big Pan");
        bigPan.setCardType("Character");
        bigPan.setColor("Purple");
        bigPan.setCost(6);
        bigPan.setPower(7000);
        bigPan.setCounter(1000);
        bigPan.setAffiliations("Giant/Fishman/Foxy Pirates");
        bigPan.setAttribute("Strike");
        bigPan.setEffect("[On Play] If you have less or equal DON!! than your opponent, play up to 1 cost 4 or lower <Foxy Pirates> type Character from your hand.");
        bigPan.setImagePath("/images/cards/OP07/OP07-070.png");
        cardRepository.save(bigPan);

        Card foxyChar = new Card();
        foxyChar.setCardNumber("OP07-071");
        foxyChar.setName("Foxy");
        foxyChar.setCardType("Character");
        foxyChar.setColor("Purple");
        foxyChar.setCost(7);
        foxyChar.setPower(7000);
        // No Counter
        foxyChar.setAffiliations("Foxy Pirates");
        foxyChar.setAttribute("Special");
        foxyChar.setEffect("[Opponent's Turn] If your leader has the {Foxy Pirates type}, all your opponent's characters have Power -1000.\\n[Activate: Main] [Once Per Turn] Add up to one rested Don!! from your Don!! deck.");
        foxyChar.setImagePath("/images/cards/OP07/OP07-071.png");
        cardRepository.save(foxyChar);

        Card porche = new Card();
        porche.setCardNumber("OP07-072");
        porche.setName("Porche");
        porche.setCardType("Character");
        porche.setColor("Purple");
        porche.setCost(3);
        porche.setPower(5000);
        // No Counter
        porche.setAffiliations("Foxy Pirates");
        porche.setAttribute("Wisdom");
        porche.setEffect("[On Play] Don!!-1: Look at the top 5 cards of your deck, you may add up to one card with the type [Foxy Pirates] to hand, place the remainder on the bottom of your deck, in any order you like. Then you may play up to one 4000 Power or lower purple character from hand.");
        porche.setImagePath("/images/cards/OP07/OP07-072.png");
        cardRepository.save(porche);

        Card monkeyDLuffyPurple = new Card();
        monkeyDLuffyPurple.setCardNumber("OP07-073");
        monkeyDLuffyPurple.setName("Monkey D. Luffy");
        monkeyDLuffyPurple.setCardType("Character");
        monkeyDLuffyPurple.setColor("Purple");
        monkeyDLuffyPurple.setCost(6);
        monkeyDLuffyPurple.setPower(7000);
        // No Counter
        monkeyDLuffyPurple.setAffiliations("Straw Hat Crew");
        monkeyDLuffyPurple.setAttribute("Strike");
        monkeyDLuffyPurple.setEffect("[Activate: Main] [Once Per Turn] DON!!-3 : If your opponent has 3 or more characters in play, set this character as active.");
        monkeyDLuffyPurple.setImagePath("/images/cards/OP07/OP07-073.png");
        cardRepository.save(monkeyDLuffyPurple);

        Card monda = new Card();
        monda.setCardNumber("OP07-074");
        monda.setName("Monda");
        monda.setCardType("Character");
        monda.setColor("Purple");
        monda.setCost(2);
        monda.setPower(3000);
        monda.setCounter(1000);
        monda.setAffiliations("Animal / Foxy Pirates");
        monda.setAttribute("Strike");
        monda.setEffect("[Activate: Main] You may trash this Character: If your Leader has the {Foxy Pirates} type, add up to 1 DON!! card from your DON!! deck rested.");
        monda.setImagePath("/images/cards/OP07/OP07-074.png");
        cardRepository.save(monda);

        // Events
        Card noroNoroBeam = new Card();
        noroNoroBeam.setCardNumber("OP07-075");
        noroNoroBeam.setName("NoroNoro Beeeeeam");
        noroNoroBeam.setCardType("Event");
        noroNoroBeam.setColor("Purple");
        noroNoroBeam.setCost(1);
        noroNoroBeam.setAffiliations("Foxy Pirates");
        noroNoroBeam.setEffect("[Counter] DON!!-1:Give up to one of your opponents leaders and characters -2000 power for the turn.");
        noroNoroBeam.setImagePath("/images/cards/OP07/OP07-075.png");
        cardRepository.save(noroNoroBeam);

        Card noroNoroBeamSword = new Card();
        noroNoroBeamSword.setCardNumber("OP07-076");
        noroNoroBeamSword.setName("NoroNoro Beam Sword");
        noroNoroBeamSword.setCardType("Event");
        noroNoroBeamSword.setColor("Purple");
        noroNoroBeamSword.setCost(2);
        noroNoroBeamSword.setAffiliations("Foxy Pirates");
        noroNoroBeamSword.setEffect("[Counter] Don!!-1:Give up to one character or leader +2000 Power for this battle. Then, rest up to one of your opponents characters.\\n[Trigger] Add up to 1 DON!! card from your DON!! deck and set it as active.");
        noroNoroBeamSword.setImagePath("/images/cards/OP07/OP07-076.png");
        cardRepository.save(noroNoroBeamSword);

        Card weAreGoingToClaim = new Card();
        weAreGoingToClaim.setCardNumber("OP07-077");
        weAreGoingToClaim.setName("We're going to claim the One Piece!!!");
        weAreGoingToClaim.setCardType("Event");
        weAreGoingToClaim.setColor("Purple");
        weAreGoingToClaim.setCost(1);
        weAreGoingToClaim.setAffiliations("The Four Emperors/Land of Wano");
        weAreGoingToClaim.setEffect("[Main] If your Leader has the {Animal Kingdom Pirates} or {Big Mom Pirates} type, look at 5 cards from the top of your deck; reveal up to 1 {Animal Kingdom Pirates} or {Big Mom Pirates} type card other and add it to your hand.\\n[Trigger] Activate this card's [Main] effect.");
        weAreGoingToClaim.setImagePath("/images/cards/OP07/OP07-077.png");
        cardRepository.save(weAreGoingToClaim);

        Card megadonNinetailsRush = new Card();
        megadonNinetailsRush.setCardNumber("OP07-078");
        megadonNinetailsRush.setName("Megadon ninetails rush");
        megadonNinetailsRush.setCardType("Event");
        megadonNinetailsRush.setColor("Purple");
        megadonNinetailsRush.setCost(3);
        megadonNinetailsRush.setAffiliations("Foxy Pirates");
        megadonNinetailsRush.setEffect("[Main] If you have equal or lower Don than your opponent, Active one of your \"Foxy\".\\n[Trigger] Add up to 1 DON!! from your DON!! deck and set it as active.");
        megadonNinetailsRush.setImagePath("/images/cards/OP07/OP07-078.png");
        cardRepository.save(megadonNinetailsRush);

        System.out.println("Finished initializing OP07 Purple cards");
    }

    private void initializeOP07BlackCards() {
        System.out.println("Initializing OP07 Black cards...");

        // Leaders
        Card robLucciLeader = new Card();
        robLucciLeader.setCardNumber("OP07-079");
        robLucciLeader.setName("Rob Lucci");
        robLucciLeader.setCardType("Leader");
        robLucciLeader.setColor("Black");
        robLucciLeader.setPower(5000);
        robLucciLeader.setLife(5);
        robLucciLeader.setAffiliations("CP0");
        robLucciLeader.setAttribute("Strike");
        robLucciLeader.setEffect("[When Attacking] You may trash the top 2 cards of your deck: Give up to one of your opponents characters -1 cost for this turn.");
        robLucciLeader.setImagePath("/images/cards/OP07/OP07-079.png");
        cardRepository.save(robLucciLeader);

        // Characters
        Card kaku = new Card();
        kaku.setCardNumber("OP07-080");
        kaku.setName("Kaku");
        kaku.setCardType("Character");
        kaku.setColor("Black");
        kaku.setCost(4);
        kaku.setPower(5000);
        kaku.setCounter(2000);
        kaku.setAffiliations("CP0");
        kaku.setAttribute("Slash");
        kaku.setEffect("[On Play] You may place two cards with a type including \"CP\" from your trash to the bottom of your deck in any order: Give up to one of your opponents characters -3 Cost for the turn.");
        kaku.setImagePath("/images/cards/OP07/OP07-080.png");
        cardRepository.save(kaku);

        Card kalifa = new Card();
        kalifa.setCardNumber("OP07-081");
        kalifa.setName("Kalifa");
        kalifa.setCardType("Character");
        kalifa.setColor("Black");
        kalifa.setCost(4);
        kalifa.setPower(5000);
        kalifa.setCounter(1000);
        kalifa.setAffiliations("CP0");
        kalifa.setAttribute("Special");
        kalifa.setEffect("[DON!!x1] [Your Turn] Give all of your opponents -1 cost.");
        kalifa.setImagePath("/images/cards/OP07/OP07-081.png");
        cardRepository.save(kalifa);

        Card captainJohn = new Card();
        captainJohn.setCardNumber("OP07-082");
        captainJohn.setName("Captain John");
        captainJohn.setCardType("Character");
        captainJohn.setColor("Black");
        captainJohn.setCost(2);
        captainJohn.setPower(3000);
        captainJohn.setCounter(1000);
        captainJohn.setAffiliations("Thriller Bark Pirates/Original Rock Pirates");
        captainJohn.setAttribute("Slash");
        captainJohn.setEffect("[On Play] Trash 2 cards from the top of your deck, Give up to 1 of your opponents Character -1 cost during this turn,");
        captainJohn.setImagePath("/images/cards/OP07/OP07-082.png");
        cardRepository.save(captainJohn);

        Card gekkoMoriaBlack = new Card();
        gekkoMoriaBlack.setCardNumber("OP07-083");
        gekkoMoriaBlack.setName("Gekko Moria");
        gekkoMoriaBlack.setCardType("Character");
        gekkoMoriaBlack.setColor("Black");
        gekkoMoriaBlack.setCost(4);
        gekkoMoriaBlack.setPower(5000);
        gekkoMoriaBlack.setCounter(1000);
        gekkoMoriaBlack.setAffiliations("Seven Warlords of the Sea / Thriller Bark Pirates");
        gekkoMoriaBlack.setAttribute("Special");
        gekkoMoriaBlack.setEffect("[Activate: Main] Place 4 cards from your trash with the type {Thriller Bark Pirates} on the bottom of your deck in: This character gains [Banish] and +1000 Power for the turn.");
        gekkoMoriaBlack.setImagePath("/images/cards/OP07/OP07-083.png");
        cardRepository.save(gekkoMoriaBlack);

        Card jisumonda = new Card();
        jisumonda.setCardNumber("OP07-084");
        jisumonda.setName("Jisumonda");
        jisumonda.setCardType("Character");
        jisumonda.setColor("Black");
        jisumonda.setCost(2);
        jisumonda.setPower(2000);
        jisumonda.setCounter(1000);
        jisumonda.setAffiliations("CP0");
        jisumonda.setAttribute("Strike");
        jisumonda.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        jisumonda.setImagePath("/images/cards/OP07/OP07-084.png");
        cardRepository.save(jisumonda);

        Card stussyBlack = new Card();
        stussyBlack.setCardNumber("OP07-085");
        stussyBlack.setName("Stussy");
        stussyBlack.setCardType("Character");
        stussyBlack.setColor("Black");
        stussyBlack.setCost(9);
        stussyBlack.setPower(9000);
        // No Counter
        stussyBlack.setAffiliations("CP0");
        stussyBlack.setAttribute("Special");
        stussyBlack.setEffect("[On Play] You may place one of your characters into the trash: KO up to one of your opponents character.");
        stussyBlack.setImagePath("/images/cards/OP07/OP07-085.png");
        cardRepository.save(stussyBlack);

        Card spandam = new Card();
        spandam.setCardNumber("OP07-086");
        spandam.setName("Spandam");
        spandam.setCardType("Character");
        spandam.setColor("Black");
        spandam.setCost(3);
        spandam.setPower(4000);
        spandam.setCounter(1000);
        spandam.setAffiliations("CP0");
        spandam.setAttribute("Slash");
        spandam.setEffect("[On Play] Place the top 2 cards of your deck into your trash, and give up to one of your opponents characters -2 cost for this turn.");
        spandam.setImagePath("/images/cards/OP07/OP07-086.png");
        cardRepository.save(spandam);

        Card baskerville = new Card();
        baskerville.setCardNumber("OP07-087");
        baskerville.setName("Baskerville");
        baskerville.setCardType("Character");
        baskerville.setColor("Black");
        baskerville.setCost(3);
        baskerville.setPower(3000);
        baskerville.setCounter(2000);
        baskerville.setAffiliations("World Government");
        baskerville.setAttribute("Slash");
        baskerville.setEffect("[Your Turn] If you opponent controls a character with cost 0, this character gains +3000 power.");
        baskerville.setImagePath("/images/cards/OP07/OP07-087.png");
        cardRepository.save(baskerville);

        Card hattori = new Card();
        hattori.setCardNumber("OP07-088");
        hattori.setName("Hattori");
        hattori.setCardType("Character");
        hattori.setColor("Black");
        hattori.setCost(1);
        hattori.setPower(0);
        hattori.setCounter(2000);
        hattori.setAffiliations("Animal / CP0");
        hattori.setAttribute("Strike");
        hattori.setEffect("[On Play] [Your Turn] Give up to one of your (Rob Lucci) +2000 power for the turn.");
        hattori.setImagePath("/images/cards/OP07/OP07-088.png");
        cardRepository.save(hattori);

        Card maha = new Card();
        maha.setCardNumber("OP07-089");
        maha.setName("Maha");
        maha.setCardType("Character");
        maha.setColor("Black");
        maha.setCost(6);
        maha.setPower(8000);
        maha.setCounter(1000);
        maha.setAffiliations("CP0");
        maha.setAttribute("Strike");
        // No Effect
        maha.setImagePath("/images/cards/OP07/OP07-089.png");
        cardRepository.save(maha);

        Card morgans = new Card();
        morgans.setCardNumber("OP07-090");
        morgans.setName("Morgans");
        morgans.setCardType("Character");
        morgans.setColor("Black");
        morgans.setCost(2);
        morgans.setPower(2000);
        morgans.setCounter(1000);
        morgans.setAffiliations("Journalist");
        morgans.setAttribute("Wisdom");
        morgans.setEffect("[On Play] Your opponent discards one card from their hand, and then reveals their hand. Then your opponent draws a card.");
        morgans.setImagePath("/images/cards/OP07/OP07-090.png");
        cardRepository.save(morgans);

        Card monkeyDLuffyBlack = new Card();
        monkeyDLuffyBlack.setCardNumber("OP07-091");
        monkeyDLuffyBlack.setName("Monkey D. Luffy");
        monkeyDLuffyBlack.setCardType("Character");
        monkeyDLuffyBlack.setColor("Black");
        monkeyDLuffyBlack.setCost(5);
        monkeyDLuffyBlack.setPower(6000);
        monkeyDLuffyBlack.setCounter(1000);
        monkeyDLuffyBlack.setAffiliations("Straw Hat Crew");
        monkeyDLuffyBlack.setAttribute("Special");
        monkeyDLuffyBlack.setEffect("[When Attacking] Trash up to 1 of your opponent's Characters with a cost of 2 or less. Then, place any number of Character cards with a cost of 4 or more from your trash at the bottom of your deck in any order. This Character gains +1000 power during this turn.for every 3 cards placed at the bottom of your deck.");
        monkeyDLuffyBlack.setImagePath("/images/cards/OP07/OP07-091.png");
        cardRepository.save(monkeyDLuffyBlack);

        Card yusef = new Card();
        yusef.setCardNumber("OP07-092");
        yusef.setName("Yusef");
        yusef.setCardType("Character");
        yusef.setColor("Black");
        yusef.setCost(1);
        yusef.setPower(2000);
        yusef.setCounter(1000);
        yusef.setAffiliations("CP0");
        yusef.setAttribute("Strike");
        yusef.setEffect("[On Play] Return 2 [CP] cards from your trash to your bottom deck: K.O. 1 of your opponent's characters with a cost of 1 or less.");
        yusef.setImagePath("/images/cards/OP07/OP07-092.png");
        cardRepository.save(yusef);

        Card robLucciChar = new Card();
        robLucciChar.setCardNumber("OP07-093");
        robLucciChar.setName("Rob Lucci");
        robLucciChar.setCardType("Character");
        robLucciChar.setColor("Black");
        robLucciChar.setCost(5);
        robLucciChar.setPower(6000);
        robLucciChar.setCounter(1000);
        robLucciChar.setAffiliations("CP0");
        robLucciChar.setAttribute("Strike");
        robLucciChar.setEffect("[On Play] You may place 3 cards from your trash at the bottom of your deck in any order: Your opponent trashes 1 card from their hand. Then, you may place up to 1 card from your opponent's trash at the bottom of their deck.");
        robLucciChar.setImagePath("/images/cards/OP07/OP07-093.png");
        cardRepository.save(robLucciChar);

        // Events
        Card shave = new Card();
        shave.setCardNumber("OP07-094");
        shave.setName("Shave");
        shave.setCardType("Event");
        shave.setColor("Black");
        shave.setCost(1);
        shave.setAffiliations("CP9");
        shave.setEffect("[Counter] Give up to one character or leader +2000 Power for the battle. Then, if your trash has 10 or more cards, return one card that contains the type \"CP\" to your hand.\\n[Trigger] Return up to one of your characters to hand.");
        shave.setImagePath("/images/cards/OP07/OP07-094.png");
        cardRepository.save(shave);

        Card ironBody = new Card();
        ironBody.setCardNumber("OP07-095");
        ironBody.setName("Iron Body");
        ironBody.setCardType("Event");
        ironBody.setColor("Black");
        ironBody.setCost(2);
        ironBody.setAffiliations("CP9");
        ironBody.setEffect("[Counter] Give uo to one of your leaders or characters +4000 Power for the battle. Then, if your trash has 10 or more cards, give that card another +2000 Power for the battle.\\n[Trigger] Give up to one leader or character +1000 power for the turn.");
        ironBody.setImagePath("/images/cards/OP07/OP07-095.png");
        cardRepository.save(ironBody);

        Card tempestKick = new Card();
        tempestKick.setCardNumber("OP07-096");
        tempestKick.setName("Tempest Kick");
        tempestKick.setCardType("Event");
        tempestKick.setColor("Black");
        tempestKick.setCost(1);
        tempestKick.setAffiliations("CP9");
        tempestKick.setEffect("[Main] Draw one card. After this, if your trash has 10 or more cards, give up to one of your opponents characters -3 cost for the turn.\\n[Trigger] KO up to one of your opponents 3 cost or lower characters.");
        tempestKick.setImagePath("/images/cards/OP07/OP07-096.png");
        cardRepository.save(tempestKick);

        System.out.println("Finished initializing OP07 Black cards");
    }

    private void initializeOP07YellowCards() {
        System.out.println("Initializing OP07 Yellow cards (and Secret Rares)...");

        // Leaders
        Card vegapunkLeader = new Card();
        vegapunkLeader.setCardNumber("OP07-097");
        vegapunkLeader.setName("Vegapunk");
        vegapunkLeader.setCardType("Leader");
        vegapunkLeader.setColor("Yellow");
        vegapunkLeader.setPower(5000);
        vegapunkLeader.setLife(2); // Low life
        vegapunkLeader.setAffiliations("Egghead / Scientist");
        vegapunkLeader.setAttribute("Wisdom");
        vegapunkLeader.setEffect("This leader cannot attack.\\n[Activate: Main] [Once Per Turn] ① (You may rest the specified number of DON!! cards in your Cost Area)Place up to one cost 5 or less card with the {Egghead} type from your hand face-up on top of your life or into play.");
        vegapunkLeader.setImagePath("/images/cards/OP07/OP07-097.png");
        cardRepository.save(vegapunkLeader);

        // Characters
        Card atlas = new Card();
        atlas.setCardNumber("OP07-098");
        atlas.setName("Atlas");
        atlas.setCardType("Character");
        atlas.setColor("Yellow");
        atlas.setCost(5);
        atlas.setPower(6000);
        atlas.setCounter(1000);
        atlas.setAffiliations("Scientist / Egghead");
        atlas.setAttribute("Wisdom");
        atlas.setEffect("If your life is lower than your opponent's life, this card cannot be K.O'd by battle.\\n[Trigger] If your leader is Vegapunk, play this card.");
        atlas.setImagePath("/images/cards/OP07/OP07-098.png");
        cardRepository.save(atlas);

        Card usoppYellow = new Card();
        usoppYellow.setCardNumber("OP07-099");
        usoppYellow.setName("Usopp");
        usoppYellow.setCardType("Character");
        usoppYellow.setColor("Yellow");
        usoppYellow.setCost(1);
        usoppYellow.setPower(2000);
        usoppYellow.setCounter(2000);
        usoppYellow.setAffiliations("Egghead/Straw Hat Crew");
        usoppYellow.setAttribute("Ranged");
        usoppYellow.setEffect("[Trigger] Up to 1 of your \"Egghead\" type leader or characters has +2000 until the end of your next turn.");
        usoppYellow.setImagePath("/images/cards/OP07/OP07-099.png");
        cardRepository.save(usoppYellow);

        Card edison = new Card();
        edison.setCardNumber("OP07-100");
        edison.setName("Edison");
        edison.setCardType("Character");
        edison.setColor("Yellow");
        edison.setCost(4);
        edison.setPower(5000);
        edison.setCounter(2000);
        edison.setAffiliations("Scientist / Egghead");
        edison.setAttribute("Wisdom");
        edison.setEffect("[On Play] If you have 2 or less Life cards, draw 2 cards and trash 2 cards from your hand.\\n[Trigger] If your Leader is [Vegapunk], play this card.");
        edison.setImagePath("/images/cards/OP07/OP07-100.png");
        cardRepository.save(edison);

        Card shaka = new Card();
        shaka.setCardNumber("OP07-101");
        shaka.setName("Shaka");
        shaka.setCardType("Character");
        shaka.setColor("Yellow");
        shaka.setCost(5);
        shaka.setPower(6000);
        shaka.setCounter(1000);
        shaka.setAffiliations("Scientist / Egghead");
        shaka.setAttribute("Wisdom");
        shaka.setEffect("[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)\\n[Trigger] If your leader is \"Vegapunk\", play this card.");
        shaka.setImagePath("/images/cards/OP07/OP07-101.png");
        cardRepository.save(shaka);

        Card jinbeYellow = new Card();
        jinbeYellow.setCardNumber("OP07-102");
        jinbeYellow.setName("Jinbe");
        jinbeYellow.setCardType("Character");
        jinbeYellow.setColor("Yellow");
        jinbeYellow.setCost(5);
        jinbeYellow.setPower(6000);
        jinbeYellow.setCounter(1000);
        jinbeYellow.setAffiliations("Fishman/Egghead/Strawhat Crew");
        jinbeYellow.setAttribute("Strike");
        jinbeYellow.setEffect("[Trigger] Return up to one 4c or lower character to your opponents hand, then add this card to your hand.");
        jinbeYellow.setImagePath("/images/cards/OP07/OP07-102.png");
        cardRepository.save(jinbeYellow);

        Card chopperYellow = new Card();
        chopperYellow.setCardNumber("OP07-103");
        chopperYellow.setName("Chopper");
        chopperYellow.setCardType("Character");
        chopperYellow.setColor("Yellow");
        chopperYellow.setCost(2);
        chopperYellow.setPower(3000);
        chopperYellow.setCounter(1000);
        chopperYellow.setAffiliations("Animal/Egghead/Strawhat pirates");
        chopperYellow.setAttribute("Wisdom");
        chopperYellow.setEffect("[Trigger] choose 1 of your chara with <egghead>, during this turn, it gains [Blocker] Then add this card to your hand.");
        chopperYellow.setImagePath("/images/cards/OP07/OP07-103.png");
        cardRepository.save(chopperYellow);

        Card nicoRobinYellow = new Card();
        nicoRobinYellow.setCardNumber("OP07-104");
        nicoRobinYellow.setName("Nico Robin");
        nicoRobinYellow.setCardType("Character");
        nicoRobinYellow.setColor("Yellow");
        nicoRobinYellow.setCost(3);
        nicoRobinYellow.setPower(4000);
        nicoRobinYellow.setCounter(1000);
        nicoRobinYellow.setAffiliations("Egghead/Straw Hat Crew");
        nicoRobinYellow.setAttribute("Special");
        nicoRobinYellow.setEffect("[Trigger] If your leader has the \"Egghead\" type, draw 2 cards.");
        nicoRobinYellow.setImagePath("/images/cards/OP07/OP07-104.png");
        cardRepository.save(nicoRobinYellow);

        Card pythagoras = new Card();
        pythagoras.setCardNumber("OP07-105");
        pythagoras.setName("Pythagoras");
        pythagoras.setCardType("Character");
        pythagoras.setColor("Yellow");
        pythagoras.setCost(5);
        pythagoras.setPower(6000);
        pythagoras.setCounter(1000);
        pythagoras.setAffiliations("Egghead/Scientist");
        pythagoras.setAttribute("Wisdom");
        pythagoras.setEffect("[On K.O.] If you have 2 or less life, Summon a 4 cost or below character with <Egghead> from your trash, rested.\\n[Trigger] If your leader is \"Vegapunk\", play this card.");
        pythagoras.setImagePath("/images/cards/OP07/OP07-105.png");
        cardRepository.save(pythagoras);

        Card fuza = new Card();
        fuza.setCardNumber("OP07-106");
        fuza.setName("Fuza");
        fuza.setCardType("Character");
        fuza.setColor("Yellow");
        fuza.setCost(4);
        fuza.setPower(6000);
        // No Counter
        fuza.setAffiliations("Animal / Sky Island");
        fuza.setAttribute("Special");
        fuza.setEffect("[DON!!x1] [When Attacking] If you have 1 or less Life cards, K.O. up to 1 of your opponent's Cost 3 or less Characters.");
        fuza.setImagePath("/images/cards/OP07/OP07-106.png");
        cardRepository.save(fuza);

        Card frankyYellow = new Card();
        frankyYellow.setCardNumber("OP07-107");
        frankyYellow.setName("Franky");
        frankyYellow.setCardType("Character");
        frankyYellow.setColor("Yellow");
        frankyYellow.setCost(4);
        frankyYellow.setPower(5000);
        frankyYellow.setCounter(2000);
        frankyYellow.setAffiliations("Egghead/ Strawhat Pirates");
        frankyYellow.setAttribute("Strike");
        frankyYellow.setEffect("[Trigger] Draw one card. Then, if you have 1 or less Life, play this card.");
        frankyYellow.setImagePath("/images/cards/OP07/OP07-107.png");
        cardRepository.save(frankyYellow);

        Card vegaForceOne = new Card();
        vegaForceOne.setCardNumber("OP07-108");
        vegaForceOne.setName("Vega Force One");
        vegaForceOne.setCardType("Character");
        vegaForceOne.setColor("Yellow");
        vegaForceOne.setCost(4);
        vegaForceOne.setPower(6000);
        vegaForceOne.setCounter(1000);
        vegaForceOne.setAffiliations("Egghead");
        vegaForceOne.setAttribute("Strike");
        // No Effect
        vegaForceOne.setImagePath("/images/cards/OP07/OP07-108.png");
        cardRepository.save(vegaForceOne);

        Card monkeyDLuffyYellow = new Card();
        monkeyDLuffyYellow.setCardNumber("OP07-109");
        monkeyDLuffyYellow.setName("Monkey D. Luffy");
        monkeyDLuffyYellow.setCardType("Character");
        monkeyDLuffyYellow.setColor("Yellow");
        monkeyDLuffyYellow.setCost(5);
        monkeyDLuffyYellow.setPower(6000);
        monkeyDLuffyYellow.setCounter(1000);
        monkeyDLuffyYellow.setAffiliations("Four Emperors / Egghead / Strawhat Crew");
        monkeyDLuffyYellow.setAttribute("Strike");
        monkeyDLuffyYellow.setEffect("[Activate: Main] You may place this character in your trash: If your life is 2 or less, KO up to one of your opponents cost4 or less characters. Then, draw one card.\\n[Trigger] KO up to one of your opponents cost 4 or less characters.");
        monkeyDLuffyYellow.setImagePath("/images/cards/OP07/OP07-109.png");
        cardRepository.save(monkeyDLuffyYellow);

        Card york = new Card();
        york.setCardNumber("OP07-110");
        york.setName("York");
        york.setCardType("Character");
        york.setColor("Yellow");
        york.setCost(5);
        york.setPower(6000);
        york.setCounter(1000);
        york.setAffiliations("Scientist / Egghead");
        york.setAttribute("Wisdom");
        york.setEffect("[On Play] You may add the top or bottom card from your life to your hand: KO up to 1 of your opponent's cost 2 or lower characters.\\n[Trigger] If your leader is \"Vegapunk\", play this card.");
        york.setImagePath("/images/cards/OP07/OP07-110.png");
        cardRepository.save(york);

        Card lilith = new Card();
        lilith.setCardNumber("OP07-111");
        lilith.setName("Lillith");
        lilith.setCardType("Character");
        lilith.setColor("Yellow");
        lilith.setCost(3);
        lilith.setPower(5000);
        // No Counter
        lilith.setAffiliations("Scientist / Egghead");
        lilith.setAttribute("Wisdom");
        lilith.setEffect("[On Play] Look at the top 5 cards of your deck and reveal up to one card with the type {Egghead} other than [Lilith] and put it into your hand. Then, put the rest of the cards on the bottom of your deck in any order.\\n[Trigger] If your leader is Vegapunk, play this card.");
        lilith.setImagePath("/images/cards/OP07/OP07-111.png");
        cardRepository.save(lilith);

        Card lucy = new Card();
        lucy.setCardNumber("OP07-112");
        lucy.setName("Lucy");
        lucy.setCardType("Character");
        lucy.setColor("Yellow");
        lucy.setCost(6);
        lucy.setPower(7000);
        // No Counter
        lucy.setAffiliations("Dressrosa/ Revolutionary Army");
        lucy.setAttribute("Strike");
        lucy.setEffect("[When Attacking] [Once Per Turn] You may put the top or bottom card of your life pile into your hand: Rest up to one of your opponents cost 4 or less characters. Then, if your life total is 1 or less, place the top card of your deck onto the top of your life.");
        lucy.setImagePath("/images/cards/OP07/OP07-112.png");
        cardRepository.save(lucy);

        Card roronoaZoroYellow = new Card();
        roronoaZoroYellow.setCardNumber("OP07-113");
        roronoaZoroYellow.setName("Roronoa Zoro");
        roronoaZoroYellow.setCardType("Character");
        roronoaZoroYellow.setColor("Yellow");
        roronoaZoroYellow.setCost(5);
        roronoaZoroYellow.setPower(6000);
        roronoaZoroYellow.setCounter(1000);
        roronoaZoroYellow.setAffiliations("Egghead/Straw Hat Crew");
        roronoaZoroYellow.setAttribute("Slash");
        roronoaZoroYellow.setEffect("[Trigger] If your leader has the type {Egghead}, Rest up to one of your opponents leaders or characters.");
        roronoaZoroYellow.setImagePath("/images/cards/OP07/OP07-113.png");
        cardRepository.save(roronoaZoroYellow);

        // Events
        Card theManWithWorldsGreatestBrain = new Card();
        theManWithWorldsGreatestBrain.setCardNumber("OP07-114");
        theManWithWorldsGreatestBrain.setName("The man with the world's greatest brain");
        theManWithWorldsGreatestBrain.setCardType("Event");
        theManWithWorldsGreatestBrain.setColor("Yellow");
        theManWithWorldsGreatestBrain.setCost(1);
        theManWithWorldsGreatestBrain.setAffiliations("Egghead / Scientist");
        theManWithWorldsGreatestBrain.setEffect("[Main] Look at the top 5 cards of your deck, Add one card with the type {Egghead} other than \"The man with the world's greatest brain\" to your hand. Then, place the rest onthe bottom of the deck in any order you like.\\n[Trigger] Draw one card.");
        theManWithWorldsGreatestBrain.setImagePath("/images/cards/OP07/OP07-114.png");
        cardRepository.save(theManWithWorldsGreatestBrain);

        Card pleaseSaveMe = new Card();
        pleaseSaveMe.setCardNumber("OP07-115");
        pleaseSaveMe.setName("Please Save me !!!");
        pleaseSaveMe.setCardType("Event");
        pleaseSaveMe.setColor("Yellow");
        pleaseSaveMe.setCost(1);
        pleaseSaveMe.setAffiliations("Scientist/Egghead");
        pleaseSaveMe.setEffect("[Counter] If you have 2 or less life, Give up to 1 of your Leader or Characters +3000 power during this battle.\\n[Trigger] Play Up to 1 Cost 5 or lower <Egghead> type character card from your trash.");
        pleaseSaveMe.setImagePath("/images/cards/OP07/OP07-115.png");
        cardRepository.save(pleaseSaveMe);

        Card flameSplit = new Card();
        flameSplit.setCardNumber("OP07-116");
        flameSplit.setName("Flame Split");
        flameSplit.setCardType("Event");
        flameSplit.setColor("Yellow");
        flameSplit.setCost(1);
        flameSplit.setAffiliations("Land of Wano / Nine Red Scabbards");
        flameSplit.setEffect("[Main] / [Counter] Give up to one Leader or Character +1000 Power for the turn. After this, if your opponent has 2 life or less, rest up to one of your opponents 4 cost or lower characters.\\n[Trigger] Rest up to one of your opponents 4 cost or lower chracters.");
        flameSplit.setImagePath("/images/cards/OP07/OP07-116.png");
        cardRepository.save(flameSplit);

        // Stages
        Card eggheadStage = new Card();
        eggheadStage.setCardNumber("OP07-117");
        eggheadStage.setName("Egghead");
        eggheadStage.setCardType("Stage");
        eggheadStage.setColor("Yellow");
        eggheadStage.setCost(2);
        eggheadStage.setAffiliations("Egghead");
        eggheadStage.setEffect("[End of Your Turn] If your life is 3 or less, set up to one of your characters cost 5 or less with the type {Egghead} as active.\\n[Trigger] Play this card.");
        eggheadStage.setImagePath("/images/cards/OP07/OP07-117.png");
        cardRepository.save(eggheadStage);

        // Secret Rares
        Card saboSecret = new Card();
        saboSecret.setCardNumber("OP07-118");
        saboSecret.setName("Sabo");
        saboSecret.setCardType("Character");
        saboSecret.setColor("Red/Black"); // Dual Color
        saboSecret.setCost(8);
        saboSecret.setPower(9000);
        // No Counter
        saboSecret.setAffiliations("Revolutionary Army");
        saboSecret.setAttribute("Special");
        saboSecret.setEffect("[On Play] You may trash 1 card from your hand: KO up to one of your opponent's cost 5 or less characters, and up to one of your opponent's cost 3 or less characters.");
        saboSecret.setImagePath("/images/cards/OP07/OP07-118.png");
        cardRepository.save(saboSecret);

        Card portgasDAceSecret = new Card();
        portgasDAceSecret.setCardNumber("OP07-119");
        portgasDAceSecret.setName("Portgas D. Ace");
        portgasDAceSecret.setCardType("Character");
        portgasDAceSecret.setColor("Blue/Yellow"); // Dual Color
        portgasDAceSecret.setCost(10);
        portgasDAceSecret.setPower(10000);
        // No Counter
        portgasDAceSecret.setAffiliations("Whitebeard Pirates");
        portgasDAceSecret.setAttribute("Special");
        portgasDAceSecret.setEffect("[On Play] You may add up to 1 card from the top of your deck to the top of your life. Then, if you have 2 life cards or less, this character gains [Rush] for this turn.");
        portgasDAceSecret.setImagePath("/images/cards/OP07/OP07-119.png");
        cardRepository.save(portgasDAceSecret);

        System.out.println("Finished initializing OP07 Yellow cards and Secret Rares");
    }
} 