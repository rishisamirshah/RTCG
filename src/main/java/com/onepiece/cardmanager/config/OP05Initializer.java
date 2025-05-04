package com.onepiece.cardmanager.config;

import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(5)
public class OP05Initializer extends BaseInitializer {

    private final CardRepository cardRepository;

    @Autowired
    public OP05Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    protected void initialize(String... args) throws Exception {
        // Only initialize if we have no OP05 cards
        if (cardRepository.countBySetAndCardNumberStartingWith("OP05", "OP05") > 0) {
            System.out.println("OP05 cards already exist, skipping initialization");
            return;
        }

        System.out.println("Initializing OP05 cards...");
        
        // Initialize Red cards
        initializeOP05RedCards();

        // Initialize Green cards
        initializeOP05GreenCards();

        // Initialize Blue cards
        initializeOP05BlueCards();

        // Initialize Purple cards
        initializeOP05PurpleCards();

        // Initialize Black cards
        initializeOP05BlackCards();

        // Initialize Yellow cards (and Secret Rares)
        initializeOP05YellowCards();

        System.out.println("Finished initializing OP05 cards");
    }

    private void initializeOP05RedCards() {
        System.out.println("Initializing OP05 Red cards...");

        // Leaders
        Card saboLeader = new Card();
        saboLeader.setCardNumber("OP05-001");
        saboLeader.setName("Sabo");
        saboLeader.setCardType("Leader");
        saboLeader.setColor("Red/Black"); // Dual Color
        saboLeader.setPower(5000);
        saboLeader.setLife(4);
        saboLeader.setAffiliations("Revolutionary Army");
        saboLeader.setAttribute("Special");
        saboLeader.setEffect("DON!!x1 [Opponent's Turn] [Once Per Turn] If one of your characters with 5000 Power or more were to be KO'd, you may instead give that character power -1000 for the turn.");
        saboLeader.setImagePath("/images/cards/OP05/OP05-001.png");
        cardRepository.save(saboLeader);

        Card beloBettyLeader = new Card();
        beloBettyLeader.setCardNumber("OP05-002");
        beloBettyLeader.setName("Belo Betty");
        beloBettyLeader.setCardType("Leader");
        beloBettyLeader.setColor("Red");
        beloBettyLeader.setPower(5000);
        beloBettyLeader.setLife(4);
        beloBettyLeader.setAffiliations("Revolutionary Army");
        beloBettyLeader.setAttribute("Special");
        beloBettyLeader.setEffect("[Activate: Main] [Once Per Turn] You may discard one <Revolutionary Army> type card from your hand: Give up to 3 of your <Revolutionary Army> or Trigger type characters +3000 power for this turn.");
        beloBettyLeader.setImagePath("/images/cards/OP05/OP05-002.png");
        cardRepository.save(beloBettyLeader);

        // Characters
        Card inazuma = new Card();
        inazuma.setCardNumber("OP05-003");
        inazuma.setName("Inazuma");
        inazuma.setCardType("Character");
        inazuma.setColor("Red");
        inazuma.setCost(3);
        inazuma.setPower(4000);
        inazuma.setCounter(1000);
        inazuma.setAffiliations("Revolutionary Army");
        inazuma.setAttribute("Slash");
        inazuma.setEffect("If a character you control other than this character has a power of 7000 or more, this character gains [Rush].");
        inazuma.setImagePath("/images/cards/OP05/OP05-003.png");
        cardRepository.save(inazuma);

        Card emporioIvankov = new Card();
        emporioIvankov.setCardNumber("OP05-004");
        emporioIvankov.setName("Emporio Ivankov");
        emporioIvankov.setCardType("Character");
        emporioIvankov.setColor("Red");
        emporioIvankov.setCost(4);
        emporioIvankov.setPower(5000);
        emporioIvankov.setCounter(1000);
        emporioIvankov.setAffiliations("Revolutionary Army");
        emporioIvankov.setAttribute("Special");
        emporioIvankov.setEffect("[Activate: Main] [Once Per Turn] If this character has 7000 Power or more, play up to 1 <Revolutionary Army> type character other than \"Emporio Ivankov\" with Power 5000 or less.");
        emporioIvankov.setImagePath("/images/cards/OP05/OP05-004.png");
        cardRepository.save(emporioIvankov);

        Card karasu = new Card();
        karasu.setCardNumber("OP05-005");
        karasu.setName("Karasu");
        karasu.setCardType("Character");
        karasu.setColor("Red");
        karasu.setCost(4);
        karasu.setPower(5000);
        karasu.setCounter(1000);
        karasu.setAffiliations("Revolutionary Army");
        karasu.setAttribute("Special");
        karasu.setEffect("[On Play] If your leader's type is {Revolutionary Army}, Give up to 1 of your opponent's Leader or Characters -1000 power during this turn.");
        karasu.setImagePath("/images/cards/OP05/OP05-005.png");
        cardRepository.save(karasu);

        Card koala = new Card();
        koala.setCardNumber("OP05-006");
        koala.setName("Koala");
        koala.setCardType("Character");
        koala.setColor("Red");
        koala.setCost(2);
        koala.setPower(3000);
        koala.setCounter(2000);
        koala.setAffiliations("Revolutionary Army");
        koala.setAttribute("Strike");
        koala.setEffect("[On Play] If your leader has the type <Revolutionary Army>, give up to one opponent's character Power -3000 for this turn.");
        koala.setImagePath("/images/cards/OP05/OP05-006.png");
        cardRepository.save(koala);

        Card saboChar = new Card();
        saboChar.setCardNumber("OP05-007");
        saboChar.setName("Sabo");
        saboChar.setCardType("Character");
        saboChar.setColor("Red");
        saboChar.setCost(6);
        saboChar.setPower(7000);
        // No Counter
        saboChar.setAffiliations("Revolutionary Army");
        saboChar.setAttribute("Special");
        saboChar.setEffect("[On Play] K.O. Up to 2 characters with a combined power of 4000 or less.");
        saboChar.setImagePath("/images/cards/OP05/OP05-007.png");
        cardRepository.save(saboChar);

        Card chakaOP05 = new Card();
        chakaOP05.setCardNumber("OP05-008");
        chakaOP05.setName("Chaka");
        chakaOP05.setCardType("Character");
        chakaOP05.setColor("Red");
        chakaOP05.setCost(5);
        chakaOP05.setPower(6000);
        chakaOP05.setCounter(1000);
        chakaOP05.setAffiliations("Alabasta Kingdom");
        chakaOP05.setAttribute("Slash");
        chakaOP05.setEffect("[DON!!x1] [Activate: Main] [Once Per Turn] Give up to 2 rested DON!! cards to your Leader or 1 of your Characters.");
        chakaOP05.setImagePath("/images/cards/OP05/OP05-008.png");
        cardRepository.save(chakaOP05);

        Card toto = new Card();
        toto.setCardNumber("OP05-009");
        toto.setName("Toto");
        toto.setCardType("Character");
        toto.setColor("Red");
        toto.setCost(1);
        toto.setPower(0);
        toto.setCounter(2000);
        toto.setAffiliations("Alabasta Kingdom");
        toto.setAttribute("Wisdom");
        toto.setEffect("[On Play] If your leader has 0 power, Draw 1 card.");
        toto.setImagePath("/images/cards/OP05/OP05-009.png");
        cardRepository.save(toto);

        Card nicoRobin = new Card();
        nicoRobin.setCardNumber("OP05-010");
        nicoRobin.setName("Nico Robin");
        nicoRobin.setCardType("Character");
        nicoRobin.setColor("Red");
        nicoRobin.setCost(1);
        nicoRobin.setPower(2000);
        nicoRobin.setCounter(1000);
        nicoRobin.setAffiliations("Straw Hat Pirates");
        nicoRobin.setAttribute("Strike");
        nicoRobin.setEffect("[On Play] K.O. up to 1 of your opponent's characters with 1000 power or less.");
        nicoRobin.setImagePath("/images/cards/OP05/OP05-010.png");
        cardRepository.save(nicoRobin);

        Card bartholomewKuma = new Card();
        bartholomewKuma.setCardNumber("OP05-011");
        bartholomewKuma.setName("Bartholomew Kuma");
        bartholomewKuma.setCardType("Character");
        bartholomewKuma.setColor("Red");
        bartholomewKuma.setCost(2);
        bartholomewKuma.setPower(2000);
        bartholomewKuma.setCounter(1000);
        bartholomewKuma.setAffiliations("The Seven Warlords/Revolutionary Army");
        bartholomewKuma.setAttribute("Strike");
        bartholomewKuma.setEffect("[On Play] KO up to 1 opponent's character with Power of 2000 or less.\\n[Trigger] If your leader is mixed-colour, play this card.");
        bartholomewKuma.setImagePath("/images/cards/OP05/OP05-011.png");
        cardRepository.save(bartholomewKuma);

        Card hack = new Card();
        hack.setCardNumber("OP05-012");
        hack.setName("Hack");
        hack.setCardType("Character");
        hack.setColor("Red");
        hack.setCost(3);
        hack.setPower(5000);
        hack.setCounter(1000);
        hack.setAffiliations("Fish-Man / Revolutionary Army");
        hack.setAttribute("Strike");
        // No specific effect text
        hack.setImagePath("/images/cards/OP05/OP05-012.png");
        cardRepository.save(hack);

        Card bunnyJoe = new Card();
        bunnyJoe.setCardNumber("OP05-013");
        bunnyJoe.setName("Bunny Joe");
        bunnyJoe.setCardType("Character");
        bunnyJoe.setColor("Red");
        bunnyJoe.setCost(2);
        bunnyJoe.setPower(2000);
        bunnyJoe.setCounter(1000);
        bunnyJoe.setAffiliations("Revolutionary Army");
        bunnyJoe.setAttribute("Ranged");
        bunnyJoe.setEffect("[Blocker]");
        bunnyJoe.setImagePath("/images/cards/OP05/OP05-013.png");
        cardRepository.save(bunnyJoe);

        Card pellOP05 = new Card();
        pellOP05.setCardNumber("OP05-014");
        pellOP05.setName("Pell");
        pellOP05.setCardType("Character");
        pellOP05.setColor("Red");
        pellOP05.setCost(3);
        pellOP05.setPower(4000);
        pellOP05.setCounter(1000);
        pellOP05.setAffiliations("Alabasta Kingdom");
        pellOP05.setAttribute("Slash");
        pellOP05.setEffect("[DON!!x1] [When Attacking] Give up to 1 of your opponent's characters power -2000 for this turn.");
        pellOP05.setImagePath("/images/cards/OP05/OP05-014.png");
        cardRepository.save(pellOP05);

        Card beloBettyChar = new Card();
        beloBettyChar.setCardNumber("OP05-015");
        beloBettyChar.setName("Belo Betty");
        beloBettyChar.setCardType("Character");
        beloBettyChar.setColor("Red");
        beloBettyChar.setCost(1);
        beloBettyChar.setPower(2000);
        beloBettyChar.setCounter(1000);
        beloBettyChar.setAffiliations("Revolutionary Army");
        beloBettyChar.setAttribute("Special");
        beloBettyChar.setEffect("[On Play] Look at the top 5 cards of your deck; reveal up to 1 {Revolutionary Army} type card other than [Belo Betty] and add it to your hand. Then, place the rest at the bottom of your deck in any order.");
        beloBettyChar.setImagePath("/images/cards/OP05/OP05-015.png");
        cardRepository.save(beloBettyChar);

        Card morley = new Card();
        morley.setCardNumber("OP05-016");
        morley.setName("Morley");
        morley.setCardType("Character");
        morley.setColor("Red");
        morley.setCost(3);
        morley.setPower(5000);
        // No Counter
        morley.setAffiliations("Giant / Revolutionary Army");
        morley.setAttribute("Special");
        morley.setEffect("[When Attacking] If this character has 7000 power or more, your opponent cannot activate [Blocker] during this battle.\\n[Trigger] You may trash 1 card. If your leader is multicolored, play this card.");
        morley.setImagePath("/images/cards/OP05/OP05-016.png");
        cardRepository.save(morley);

        Card lindberg = new Card();
        lindberg.setCardNumber("OP05-017");
        lindberg.setName("Lindberg");
        lindberg.setCardType("Character");
        lindberg.setColor("Red");
        lindberg.setCost(4);
        lindberg.setPower(5000);
        lindberg.setCounter(1000);
        lindberg.setAffiliations("Minks/Revolutionary Army");
        lindberg.setAttribute("Special");
        lindberg.setEffect("[When Attacking] If this character has 7000 power or more, KO up to 1 of your opponent's characters with 3000 power or less.\\n[Trigger] You may discard a card: If your leader is multi-coloured, play this card.");
        lindberg.setImagePath("/images/cards/OP05/OP05-017.png");
        cardRepository.save(lindberg);

        // Events
        Card emporioTensionHormone = new Card();
        emporioTensionHormone.setCardNumber("OP05-018");
        emporioTensionHormone.setName("Emporio Tension Hormone");
        emporioTensionHormone.setCardType("Event");
        emporioTensionHormone.setColor("Red");
        emporioTensionHormone.setCost(3);
        emporioTensionHormone.setAffiliations("Revolutionary Army");
        emporioTensionHormone.setEffect("[Counter] Up to 1 of your leaders or characters gain +3000 Power this battle. Then, play up to 1 character card with the [Revolutionary Army] type with 5000 power or less from your hand.\\n[Trigger] Play up to 1 character card with the [Revolutionary Army] type with 5000 power or less from your hand.");
        emporioTensionHormone.setImagePath("/images/cards/OP05/OP05-018.png");
        cardRepository.save(emporioTensionHormone);

        Card fireFist = new Card();
        fireFist.setCardNumber("OP05-019");
        fireFist.setName("Fire Fist");
        fireFist.setCardType("Event");
        fireFist.setColor("Red");
        fireFist.setCost(2);
        fireFist.setAffiliations("Revolutionary Army");
        fireFist.setEffect("[Main] Give up to 1 of your opponent's characters -4000 Power this turn. Then, if your life has 2 cards or less, K.O. up to 1 of your opponent's characters with 0 or less Power.\\n[Trigger] Activate this card's [Main] effect.");
        fireFist.setImagePath("/images/cards/OP05/OP05-019.png");
        cardRepository.save(fireFist);

        Card brickFist4000 = new Card();
        brickFist4000.setCardNumber("OP05-020");
        brickFist4000.setName("4000 Brick Fist");
        brickFist4000.setCardType("Event");
        brickFist4000.setColor("Red");
        brickFist4000.setCost(2);
        brickFist4000.setAffiliations("Fish-Man / Revolutionary Army");
        brickFist4000.setEffect("[Main] During this turn, up to 1 of your Leader or Characters gains +2000 power. Then, KO up to 1 of your opponent's characters with 2000 power or less.\\n[Trigger] Up to 1 of your Leader or Characters gains +1000 power during this turn.");
        brickFist4000.setImagePath("/images/cards/OP05/OP05-020.png");
        cardRepository.save(brickFist4000);

        System.out.println("Finished initializing OP05 Red cards");
    }

    private void initializeOP05GreenCards() {
        System.out.println("Initializing OP05 Green cards...");

        // Leaders
        Card donquixoteRosinanteLeader = new Card();
        donquixoteRosinanteLeader.setCardNumber("OP05-022");
        donquixoteRosinanteLeader.setName("Donquixote Rosinante");
        donquixoteRosinanteLeader.setCardType("Leader");
        donquixoteRosinanteLeader.setColor("Green/Blue"); // Dual Color
        donquixoteRosinanteLeader.setPower(5000);
        donquixoteRosinanteLeader.setLife(4);
        donquixoteRosinanteLeader.setAffiliations("Navy/Donquixote Pirates");
        donquixoteRosinanteLeader.setAttribute("Special");
        donquixoteRosinanteLeader.setEffect("[Blocker]\\n[End of Your Turn] If your hand is 6 cards or less, set this leader as active.");
        donquixoteRosinanteLeader.setImagePath("/images/cards/OP05/OP05-022.png");
        cardRepository.save(donquixoteRosinanteLeader);

        // Characters
        Card vergo = new Card();
        vergo.setCardNumber("OP05-023");
        vergo.setName("Vergo");
        vergo.setCardType("Character");
        vergo.setColor("Green");
        vergo.setCost(3);
        vergo.setPower(4000);
        vergo.setCounter(1000);
        vergo.setAffiliations("Navy/Donquixote Pirates");
        vergo.setAttribute("Strike");
        vergo.setEffect("[DON!!x1] [When Attacking] K.O. up to 1 of your opponent's rested characters with a cost of 3 or less.");
        vergo.setImagePath("/images/cards/OP05/OP05-023.png");
        cardRepository.save(vergo);

        Card kyuin = new Card();
        kyuin.setCardNumber("OP05-024");
        kyuin.setName("Kyuin");
        kyuin.setCardType("Character");
        kyuin.setColor("Green");
        kyuin.setCost(2);
        kyuin.setPower(2000);
        kyuin.setCounter(1000);
        kyuin.setAffiliations("Donquixote Pirates");
        kyuin.setAttribute("Strike");
        kyuin.setEffect("[Blocker]");
        kyuin.setImagePath("/images/cards/OP05/OP05-024.png");
        cardRepository.save(kyuin);

        Card gladius = new Card();
        gladius.setCardNumber("OP05-025");
        gladius.setName("Gladius");
        gladius.setCardType("Character");
        gladius.setColor("Green");
        gladius.setCost(5);
        gladius.setPower(6000);
        gladius.setCounter(1000);
        gladius.setAffiliations("Donquixote Pirates");
        gladius.setAttribute("Special");
        gladius.setEffect("[Activate: Main] You may rest this character: Rest up to 1 of your opponent's characters with a cost of 3 or less.");
        gladius.setImagePath("/images/cards/OP05/OP05-025.png");
        cardRepository.save(gladius);

        Card sarquiss = new Card();
        sarquiss.setCardNumber("OP05-026");
        sarquiss.setName("Sarquiss");
        sarquiss.setCardType("Character");
        sarquiss.setColor("Green");
        sarquiss.setCost(4);
        sarquiss.setPower(4000);
        sarquiss.setCounter(1000);
        sarquiss.setAffiliations("Bellamy Pirates");
        sarquiss.setAttribute("Slash");
        sarquiss.setEffect("[DON!!x1] [When Attacking] [Once Per Turn] You may rest one of your characters that costs 3 or more: Set this character as active.");
        sarquiss.setImagePath("/images/cards/OP05/OP05-026.png");
        cardRepository.save(sarquiss);

        Card trafalgarLawGreen = new Card();
        trafalgarLawGreen.setCardNumber("OP05-027");
        trafalgarLawGreen.setName("Trafalgar Law");
        trafalgarLawGreen.setCardType("Character");
        trafalgarLawGreen.setColor("Green");
        trafalgarLawGreen.setCost(1);
        trafalgarLawGreen.setPower(2000);
        trafalgarLawGreen.setCounter(1000);
        trafalgarLawGreen.setAffiliations("Donquixote Pirates");
        trafalgarLawGreen.setAttribute("Wisdom");
        trafalgarLawGreen.setEffect("[Activate: Main] You may trash this character: Rest up to 1 of your opponent's Characters with a cost of 3 or less.");
        trafalgarLawGreen.setImagePath("/images/cards/OP05/OP05-027.png");
        cardRepository.save(trafalgarLawGreen);

        Card donquixoteDoflamingoGreen1 = new Card();
        donquixoteDoflamingoGreen1.setCardNumber("OP05-028");
        donquixoteDoflamingoGreen1.setName("Donquixote Doflamingo");
        donquixoteDoflamingoGreen1.setCardType("Character");
        donquixoteDoflamingoGreen1.setColor("Green");
        donquixoteDoflamingoGreen1.setCost(1);
        donquixoteDoflamingoGreen1.setPower(2000);
        donquixoteDoflamingoGreen1.setCounter(1000);
        donquixoteDoflamingoGreen1.setAffiliations("Donquixote Pirates");
        donquixoteDoflamingoGreen1.setAttribute("Ranged");
        donquixoteDoflamingoGreen1.setEffect("[Activate: Main] You may place this character in your trash: KO up to 1 of your opponent's rested characters with a cost of 2 or less.");
        donquixoteDoflamingoGreen1.setImagePath("/images/cards/OP05/OP05-028.png");
        cardRepository.save(donquixoteDoflamingoGreen1);

        Card donquixoteDoflamingoGreen2 = new Card();
        donquixoteDoflamingoGreen2.setCardNumber("OP05-029");
        donquixoteDoflamingoGreen2.setName("Donquixote Doflamingo");
        donquixoteDoflamingoGreen2.setCardType("Character");
        donquixoteDoflamingoGreen2.setColor("Green");
        donquixoteDoflamingoGreen2.setCost(7);
        donquixoteDoflamingoGreen2.setPower(8000);
        // No counter
        donquixoteDoflamingoGreen2.setAffiliations("Donquixote Pirates");
        donquixoteDoflamingoGreen2.setAttribute("Special");
        donquixoteDoflamingoGreen2.setEffect("[On Opponent's Attack] [Once Per Turn] ① (You may rest the specified DON!! cards in your Cost Area) rest up to 1 of your opponent's characters with a cost of 6 or less.");
        donquixoteDoflamingoGreen2.setImagePath("/images/cards/OP05/OP05-029.png");
        cardRepository.save(donquixoteDoflamingoGreen2);

        Card donquixoteRosinanteChar = new Card();
        donquixoteRosinanteChar.setCardNumber("OP05-030");
        donquixoteRosinanteChar.setName("Donquixote Rosinante");
        donquixoteRosinanteChar.setCardType("Character");
        donquixoteRosinanteChar.setColor("Green");
        donquixoteRosinanteChar.setCost(2);
        donquixoteRosinanteChar.setPower(1000);
        donquixoteRosinanteChar.setCounter(1000);
        donquixoteRosinanteChar.setAffiliations("Navy / Donquixote Pirates");
        donquixoteRosinanteChar.setAttribute("Special");
        donquixoteRosinanteChar.setEffect("[Blocker]\\n[Opponent's Turn] If one of your other rested characters would be KOed, you may instead trash this character.");
        donquixoteRosinanteChar.setImagePath("/images/cards/OP05/OP05-030.png");
        cardRepository.save(donquixoteRosinanteChar);

        Card buffalo = new Card();
        buffalo.setCardNumber("OP05-031");
        buffalo.setName("Buffalo");
        buffalo.setCardType("Character");
        buffalo.setColor("Green");
        buffalo.setCost(3);
        buffalo.setPower(4000);
        buffalo.setCounter(1000);
        buffalo.setAffiliations("Donquixote Pirates");
        buffalo.setAttribute("Strike");
        buffalo.setEffect("[When Attacking] [Once Per Turn] If two or more of your characters are rested, you may set up to one of your cost 1 characters as active.");
        buffalo.setImagePath("/images/cards/OP05/OP05-031.png");
        cardRepository.save(buffalo);

        Card pica = new Card();
        pica.setCardNumber("OP05-032");
        pica.setName("Pica");
        pica.setCardType("Character");
        pica.setColor("Green");
        pica.setCost(4);
        pica.setPower(6000);
        // No counter
        pica.setAffiliations("Donquixote Pirates");
        pica.setAttribute("Strike");
        pica.setEffect("[End of Your Turn] ① (You may rest the specified number of DON!! cards in your Cost Area) Set this character as active.\\n[Once Per Turn] If this character would be K.O'd, you may instead rest up to one of your other 3 cost or more characters not named {Pica}.");
        pica.setImagePath("/images/cards/OP05/OP05-032.png");
        cardRepository.save(pica);

        Card baby5Green1 = new Card();
        baby5Green1.setCardNumber("OP05-033");
        baby5Green1.setName("Baby 5");
        baby5Green1.setCardType("Character");
        baby5Green1.setColor("Green");
        baby5Green1.setCost(1);
        baby5Green1.setPower(1000);
        baby5Green1.setCounter(1000);
        baby5Green1.setAffiliations("Donquixote Pirates");
        baby5Green1.setAttribute("Special");
        baby5Green1.setEffect("[Activate: Main] ①(You may rest the specified number of DON!! cards in your Cost Area) You may rest this card: Play up to 1 {Donquixote Pirates} Character with a cost of 2 or less from your hand.");
        baby5Green1.setImagePath("/images/cards/OP05/OP05-033.png");
        cardRepository.save(baby5Green1);

        Card baby5Green2 = new Card();
        baby5Green2.setCardNumber("OP05-034");
        baby5Green2.setName("Baby 5");
        baby5Green2.setCardType("Character");
        baby5Green2.setColor("Green");
        baby5Green2.setCost(1);
        baby5Green2.setPower(1000);
        baby5Green2.setCounter(1000);
        baby5Green2.setAffiliations("Donquixote Pirates");
        baby5Green2.setAttribute("Special");
        baby5Green2.setEffect("[Activate: Main] ① (You may rest the specified number of DON!! cards in your Cost Area)You may rest this character: Look at the top 5 cards of your deck, reveal up to 1 card with the {Donquixote Pirates} type and add it to your hand. Then, place the remaining cards at the bottom of your deck in any order.");
        baby5Green2.setImagePath("/images/cards/OP05/OP05-034.png");
        cardRepository.save(baby5Green2);

        Card bellamy = new Card();
        bellamy.setCardNumber("OP05-035");
        bellamy.setName("Bellamy");
        bellamy.setCardType("Character");
        bellamy.setColor("Green");
        bellamy.setCost(3);
        bellamy.setPower(5000);
        bellamy.setCounter(1000);
        bellamy.setAffiliations("Donquixote Pirates");
        bellamy.setAttribute("Strike");
        // No Effect
        bellamy.setImagePath("/images/cards/OP05/OP05-035.png");
        cardRepository.save(bellamy);

        Card monet = new Card();
        monet.setCardNumber("OP05-036");
        monet.setName("Monet");
        monet.setCardType("Character");
        monet.setColor("Green");
        monet.setCost(3);
        monet.setPower(1000);
        monet.setCounter(1000);
        monet.setAffiliations("Donquixote Pirates");
        monet.setAttribute("Special");
        monet.setEffect("[Blocker]\\n[When Blocking] rest up to 1 of your opponent's characters with a cost of 4 or less.");
        monet.setImagePath("/images/cards/OP05/OP05-036.png");
        cardRepository.save(monet);

        // Events
        Card whoeverWinsBecomesJustice = new Card();
        whoeverWinsBecomesJustice.setCardNumber("OP05-037");
        whoeverWinsBecomesJustice.setName("Whoever wins this war becomes justice!!!");
        whoeverWinsBecomesJustice.setCardType("Event");
        whoeverWinsBecomesJustice.setColor("Green");
        whoeverWinsBecomesJustice.setCost(0);
        whoeverWinsBecomesJustice.setAffiliations("Donquixote Pirates");
        whoeverWinsBecomesJustice.setEffect("[Counter] You may trash one card from your hand: Your leader or one of your characters gets +3000 during this battle.\\n[Trigger] Rest an opponent's character with a cost of 4 or less.");
        whoeverWinsBecomesJustice.setImagePath("/images/cards/OP05/OP05-037.png");
        cardRepository.save(whoeverWinsBecomesJustice);

        Card charlestone = new Card();
        charlestone.setCardNumber("OP05-038");
        charlestone.setName("Charlestone");
        charlestone.setCardType("Event");
        charlestone.setColor("Green");
        charlestone.setCost(2);
        charlestone.setAffiliations("Donquixote Pirates");
        charlestone.setEffect("[Counter] Up to 1 of your Leader or Characters gains +4000 power during this battle. Then, you may discard a card. If you did, set up to 3 of your Don!! as active.\\n[Trigger] Rest up to 1 of your opponent's Leader or Characters with a cost of 3 or less.");
        charlestone.setImagePath("/images/cards/OP05/OP05-038.png");
        cardRepository.save(charlestone);

        Card betaBettonMeteora = new Card();
        betaBettonMeteora.setCardNumber("OP05-039");
        betaBettonMeteora.setName("Beta Betton Meteora");
        betaBettonMeteora.setCardType("Event");
        betaBettonMeteora.setColor("Green");
        betaBettonMeteora.setCost(2);
        betaBettonMeteora.setAffiliations("Donquixote Pirates");
        betaBettonMeteora.setEffect("[Counter] Up to 1 of your Leader or Characters gains +4000 power during this battle. Then, KO up to 1 of your opponent's rested Characters with a cost of 3 or less.\\n[Trigger] KO up to 1 of your opponent's rested Characters with a cost of 5 or less.");
        betaBettonMeteora.setImagePath("/images/cards/OP05/OP05-039.png");
        cardRepository.save(betaBettonMeteora);

        // Stages
        Card birdCage = new Card();
        birdCage.setCardNumber("OP05-040");
        birdCage.setName("Bird Cage");
        birdCage.setCardType("Stage");
        birdCage.setColor("Green");
        birdCage.setCost(5);
        birdCage.setAffiliations("Donquixote Pirates");
        birdCage.setEffect("If your Leader is [Donquixote Doflamingo], all Characters with a cost of 5 or less will not become active during both player's Refresh Phase.\\n[End of Your Turn] If you have 10 DON!! cards on your field, K.O. all rested Characters with a cost of 5 or less. Then, trash this stage.");
        birdCage.setImagePath("/images/cards/OP05/OP05-040.png");
        cardRepository.save(birdCage);
        
        System.out.println("Finished initializing OP05 Green cards");
    }

    private void initializeOP05BlueCards() {
        System.out.println("Initializing OP05 Blue cards...");

        // Leaders
        Card sakazukiLeader = new Card();
        sakazukiLeader.setCardNumber("OP05-041");
        sakazukiLeader.setName("Sakazuki");
        sakazukiLeader.setCardType("Leader");
        sakazukiLeader.setColor("Blue/Black"); // Dual Color
        sakazukiLeader.setPower(5000);
        sakazukiLeader.setLife(4);
        sakazukiLeader.setAffiliations("Navy");
        sakazukiLeader.setAttribute("Special");
        sakazukiLeader.setEffect("[Activate: Main] [Once Per Turn] You may discard one card: Draw one card.\\n[When Attacking] Give up to one opponent character cost -1.");
        sakazukiLeader.setImagePath("/images/cards/OP05/OP05-041.png");
        cardRepository.save(sakazukiLeader);

        // Characters
        Card isshoBlue = new Card();
        isshoBlue.setCardNumber("OP05-042");
        isshoBlue.setName("Issho");
        isshoBlue.setCardType("Character");
        isshoBlue.setColor("Blue");
        isshoBlue.setCost(6);
        isshoBlue.setPower(6000);
        isshoBlue.setCounter(1000);
        isshoBlue.setAffiliations("Navy");
        isshoBlue.setAttribute("Special");
        isshoBlue.setEffect("[On Play] Until the start of your next turn, up to 1 of your opponent's characters with a cost of 7 or less cannot attack.");
        isshoBlue.setImagePath("/images/cards/OP05/OP05-042.png");
        cardRepository.save(isshoBlue);

        Card ultiBlue = new Card();
        ultiBlue.setCardNumber("OP05-043");
        ultiBlue.setName("Ulti");
        ultiBlue.setCardType("Character");
        ultiBlue.setColor("Blue");
        ultiBlue.setCost(4);
        ultiBlue.setPower(5000);
        ultiBlue.setCounter(1000);
        ultiBlue.setAffiliations("Animal Kingdom Pirates");
        ultiBlue.setAttribute("Strike");
        ultiBlue.setEffect("[On Play] If your leader is multicolored, look at the top 3 cards of your deck and add 1 to your hand. Then, place the rest in any order on the top or bottom of your deck.");
        ultiBlue.setImagePath("/images/cards/OP05/OP05-043.png");
        cardRepository.save(ultiBlue);

        Card johnGiant = new Card();
        johnGiant.setCardNumber("OP05-044");
        johnGiant.setName("John Giant");
        johnGiant.setCardType("Character");
        johnGiant.setColor("Blue");
        johnGiant.setCost(8);
        johnGiant.setPower(10000);
        johnGiant.setCounter(1000);
        johnGiant.setAffiliations("Giant / Navy");
        johnGiant.setAttribute("Slash");
        // No Effect
        johnGiant.setImagePath("/images/cards/OP05/OP05-044.png");
        cardRepository.save(johnGiant);

        Card stainless = new Card();
        stainless.setCardNumber("OP05-045");
        stainless.setName("Stainless");
        stainless.setCardType("Character");
        stainless.setColor("Blue");
        stainless.setCost(4);
        stainless.setPower(5000);
        stainless.setCounter(1000);
        stainless.setAffiliations("Navy");
        stainless.setAttribute("Slash");
        stainless.setEffect("[Activate: Main] Discard 1 card from your hand, and rest this card: Return up to 1 cost 2 or lower character to the bottom of its owner's deck.");
        stainless.setImagePath("/images/cards/OP05/OP05-045.png");
        cardRepository.save(stainless);

        Card dalmatian = new Card();
        dalmatian.setCardNumber("OP05-046");
        dalmatian.setName("Dalmatian");
        dalmatian.setCardType("Character");
        dalmatian.setColor("Blue");
        dalmatian.setCost(4);
        dalmatian.setPower(5000);
        dalmatian.setCounter(1000);
        dalmatian.setAffiliations("Navy");
        dalmatian.setAttribute("Strike");
        dalmatian.setEffect("[On K.O.] Draw 1 card, then place 1 card on the bottom of your deck from your hand.");
        dalmatian.setImagePath("/images/cards/OP05/OP05-046.png");
        cardRepository.save(dalmatian);

        Card basilHawkins = new Card();
        basilHawkins.setCardNumber("OP05-047");
        basilHawkins.setName("Basil Hawkins");
        basilHawkins.setCardType("Character");
        basilHawkins.setColor("Blue");
        basilHawkins.setCost(4);
        basilHawkins.setPower(5000);
        basilHawkins.setCounter(1000);
        basilHawkins.setAffiliations("Animal Kingdom Pirates/Hawkins Pirates");
        basilHawkins.setAttribute("Slash");
        basilHawkins.setEffect("[Blocker]\\n[When Blocking] If you have 3 or less cards in your hand, draw 1 card. Then, this character gains +1000 power for this battle.");
        basilHawkins.setImagePath("/images/cards/OP05/OP05-047.png");
        cardRepository.save(basilHawkins);

        Card bastille = new Card();
        bastille.setCardNumber("OP05-048");
        bastille.setName("Bastille");
        bastille.setCardType("Character");
        bastille.setColor("Blue");
        bastille.setCost(5);
        bastille.setPower(6000);
        bastille.setCounter(1000);
        bastille.setAffiliations("Navy");
        bastille.setAttribute("Slash");
        bastille.setEffect("[DON!!x1] [When Attacking] Place up to 1 Character with a cost of 2 or less to the bottom of the owner's deck.");
        bastille.setImagePath("/images/cards/OP05/OP05-048.png");
        cardRepository.save(bastille);

        Card hatcha = new Card();
        hatcha.setCardNumber("OP05-049");
        hatcha.setName("Hatcha");
        hatcha.setCardType("Character");
        hatcha.setColor("Blue");
        hatcha.setCost(6);
        hatcha.setPower(7000);
        // No Counter
        hatcha.setAffiliations("Giants / Animal Kingdom Pirates");
        hatcha.setAttribute("Strike");
        hatcha.setEffect("[DON!!x1] [When Attacking] Return up to one character with a cost of 3 or less to the owners hand.");
        hatcha.setImagePath("/images/cards/OP05/OP05-049.png");
        cardRepository.save(hatcha);

        Card hina = new Card();
        hina.setCardNumber("OP05-050");
        hina.setName("Hina");
        hina.setCardType("Character");
        hina.setColor("Blue");
        hina.setCost(3);
        hina.setPower(4000);
        hina.setCounter(1000);
        hina.setAffiliations("Navy");
        hina.setAttribute("Special");
        hina.setEffect("[On Play] If your hand has 5 or less cards in it draw 1 card.");
        hina.setImagePath("/images/cards/OP05/OP05-050.png");
        cardRepository.save(hina);

        Card borsalino = new Card();
        borsalino.setCardNumber("OP05-051");
        borsalino.setName("Borsalino");
        borsalino.setCardType("Character");
        borsalino.setColor("Blue");
        borsalino.setCost(7);
        borsalino.setPower(8000);
        // No Counter
        borsalino.setAffiliations("Navy");
        borsalino.setAttribute("Special");
        borsalino.setEffect("[On Play] Place up to 1 character with a cost 4 or lower to the bottom of its owner's deck.");
        borsalino.setImagePath("/images/cards/OP05/OP05-051.png");
        cardRepository.save(borsalino);

        Card maynard = new Card();
        maynard.setCardNumber("OP05-052");
        maynard.setName("Maynard");
        maynard.setCardType("Character");
        maynard.setColor("Blue");
        maynard.setCost(2);
        maynard.setPower(2000);
        maynard.setCounter(1000);
        maynard.setAffiliations("Navy");
        maynard.setAttribute("Wisdom");
        maynard.setEffect("[Blocker]");
        maynard.setImagePath("/images/cards/OP05/OP05-052.png");
        cardRepository.save(maynard);

        Card mozambia = new Card();
        mozambia.setCardNumber("OP05-053");
        mozambia.setName("Mozambia");
        mozambia.setCardType("Character");
        mozambia.setColor("Blue");
        mozambia.setCost(1);
        mozambia.setPower(2000);
        mozambia.setCounter(1000);
        mozambia.setAffiliations("Navy");
        mozambia.setAttribute("Slash");
        mozambia.setEffect("[Your Turn] [Once Per Turn] When you draw a card except for during your draw phase this character gets +2000 during this turn.");
        mozambia.setImagePath("/images/cards/OP05/OP05-053.png");
        cardRepository.save(mozambia);

        Card monkeyDGarp = new Card();
        monkeyDGarp.setCardNumber("OP05-054");
        monkeyDGarp.setName("Monkey D. Garp");
        monkeyDGarp.setCardType("Character");
        monkeyDGarp.setColor("Blue");
        monkeyDGarp.setCost(3);
        monkeyDGarp.setPower(3000);
        monkeyDGarp.setCounter(2000);
        monkeyDGarp.setAffiliations("Navy");
        monkeyDGarp.setAttribute("Strike");
        monkeyDGarp.setEffect("[On Play] Draw 2 cards, then return 2 cards from your hand to the bottom of your deck in your desired order.");
        monkeyDGarp.setImagePath("/images/cards/OP05/OP05-054.png");
        cardRepository.save(monkeyDGarp);

        Card xDrake = new Card();
        xDrake.setCardNumber("OP05-055");
        xDrake.setName("X Drake");
        xDrake.setCardType("Character");
        xDrake.setColor("Blue");
        xDrake.setCost(5);
        xDrake.setPower(6000);
        xDrake.setCounter(1000);
        xDrake.setAffiliations("Navy/Drake Pirates/Animal Kingdom Pirates");
        xDrake.setAttribute("Slash");
        xDrake.setEffect("[Blocker]\\n[On Play] Look at 5 cards from the top of your deck and place them at the top or bottom of your deck in any order.");
        xDrake.setImagePath("/images/cards/OP05/OP05-055.png");
        cardRepository.save(xDrake);

        Card diezBarrels = new Card();
        diezBarrels.setCardNumber("OP05-056");
        diezBarrels.setName("Diez Barrels");
        diezBarrels.setCardType("Character");
        diezBarrels.setColor("Blue");
        diezBarrels.setCost(2);
        diezBarrels.setPower(2000);
        diezBarrels.setCounter(1000);
        diezBarrels.setAffiliations("Former Navy");
        diezBarrels.setAttribute("Strike");
        diezBarrels.setEffect("[On Play] You may place 1 of your characters other than this character on the bottom of your deck: Draw 1 card.");
        diezBarrels.setImagePath("/images/cards/OP05/OP05-056.png");
        cardRepository.save(diezBarrels);

        // Events
        Card houndBlaze = new Card();
        houndBlaze.setCardNumber("OP05-057");
        houndBlaze.setName("Hound Blaze");
        houndBlaze.setCardType("Event");
        houndBlaze.setColor("Blue");
        houndBlaze.setCost(2);
        houndBlaze.setAffiliations("Navy");
        houndBlaze.setEffect("[Main] Up to 1 of your leaders or characters gains +3000 Power this turn. Then, place a character with 2 or less cost on the bottom of its owner's deck.\\n[Trigger] Return a character with a cost of 3 or less to its owner's hand.");
        houndBlaze.setImagePath("/images/cards/OP05/OP05-057.png");
        cardRepository.save(houndBlaze);

        Card wasteOfHumanLife = new Card();
        wasteOfHumanLife.setCardNumber("OP05-058");
        wasteOfHumanLife.setName("It's a Waste of Human Life!");
        wasteOfHumanLife.setCardType("Event");
        wasteOfHumanLife.setColor("Blue");
        wasteOfHumanLife.setCost(8);
        wasteOfHumanLife.setAffiliations("Navy");
        wasteOfHumanLife.setEffect("[Main] Place all cost 3 or lower characters on the bottom of their owner's decks. Then, until there are 5 cards in each players' hands, discard cards.\\n[Trigger] Place all cost 2 or less characters on the bottom of their owner's decks.");
        wasteOfHumanLife.setImagePath("/images/cards/OP05/OP05-058.png");
        cardRepository.save(wasteOfHumanLife);

        Card worldOfViolence = new Card();
        worldOfViolence.setCardNumber("OP05-059");
        worldOfViolence.setName("Let us begin the \"World of Violence\"!!!");
        worldOfViolence.setCardType("Event");
        worldOfViolence.setColor("Blue");
        worldOfViolence.setCost(5);
        worldOfViolence.setAffiliations("Four Emperors/Animal Kingdom Pirates");
        worldOfViolence.setEffect("[Main] If your leader is mixed coloured, draw a card. Then, return a cost 5 or lower character to its owner's hand.\\n[Trigger] If your leader is mixed coloured, draw 2 cards.");
        worldOfViolence.setImagePath("/images/cards/OP05/OP05-059.png");
        cardRepository.save(worldOfViolence);
        
        System.out.println("Finished initializing OP05 Blue cards");
    }

    private void initializeOP05PurpleCards() {
        System.out.println("Initializing OP05 Purple cards...");

        // Leaders
        Card monkeyDLuffyPurpleLeader = new Card();
        monkeyDLuffyPurpleLeader.setCardNumber("OP05-060");
        monkeyDLuffyPurpleLeader.setName("Monkey.D.Luffy");
        monkeyDLuffyPurpleLeader.setCardType("Leader");
        monkeyDLuffyPurpleLeader.setColor("Purple"); 
        monkeyDLuffyPurpleLeader.setPower(5000);
        monkeyDLuffyPurpleLeader.setLife(5);
        monkeyDLuffyPurpleLeader.setAffiliations("Straw Hat Crew");
        monkeyDLuffyPurpleLeader.setAttribute("Strike");
        monkeyDLuffyPurpleLeader.setEffect("[Activate: Main] [Once Per Turn] You may take the top card from your Life cards to your hand: If the amount of DON!! on your field is 0 or 3 or more, add up to 1 DON!! card from your DON!! deck as active.");
        monkeyDLuffyPurpleLeader.setImagePath("/images/cards/OP05/OP05-060.png");
        cardRepository.save(monkeyDLuffyPurpleLeader);

        // Characters
        Card usohachi = new Card();
        usohachi.setCardNumber("OP05-061");
        usohachi.setName("Usohachi");
        usohachi.setCardType("Character");
        usohachi.setColor("Purple");
        usohachi.setCost(3);
        usohachi.setPower(4000);
        usohachi.setCounter(2000);
        usohachi.setAffiliations("Straw Hat Crew");
        usohachi.setAttribute("Ranged");
        usohachi.setEffect("[DON!!x1] [On attack] If you have 8 or more DON!! on your field, rest an opponent's character with a cost of 4 or less.");
        usohachi.setImagePath("/images/cards/OP05/OP05-061.png");
        cardRepository.save(usohachi);

        Card onami = new Card();
        onami.setCardNumber("OP05-062");
        onami.setName("Onami");
        onami.setCardType("Character");
        onami.setColor("Purple");
        onami.setCost(1);
        onami.setPower(1000);
        onami.setCounter(1000);
        onami.setAffiliations("Straw Hat Crew");
        onami.setAttribute("Special");
        onami.setEffect("If you have 10 DON!! on your field, this character gains [Blocker].");
        onami.setImagePath("/images/cards/OP05/OP05-062.png");
        cardRepository.save(onami);

        Card orobi = new Card();
        orobi.setCardNumber("OP05-063");
        orobi.setName("Orobi");
        orobi.setCardType("Character");
        orobi.setColor("Purple");
        orobi.setCost(4);
        orobi.setPower(5000);
        orobi.setCounter(1000);
        orobi.setAffiliations("Straw Hat Crew");
        orobi.setAttribute("Strike");
        orobi.setEffect("[On Play] If you have 8 or more DON!! cards on your field, K.O up to one of your opponent's Characters that costs 3 or less.");
        orobi.setImagePath("/images/cards/OP05/OP05-063.png");
        cardRepository.save(orobi);

        Card killer = new Card();
        killer.setCardNumber("OP05-064");
        killer.setName("Killer");
        killer.setCardType("Character");
        killer.setColor("Purple");
        killer.setCost(1);
        killer.setPower(2000);
        killer.setCounter(1000);
        killer.setAffiliations("Kid Pirates");
        killer.setAttribute("Slash");
        killer.setEffect("[On Play] Look at the top 5 cards of your deck, reveal up to 1 [Kid Pirates] type card other than [Killer] and add it to your hand. Return the rest to the bottom of your deck in any order.");
        killer.setImagePath("/images/cards/OP05/OP05-064.png");
        cardRepository.save(killer);

        Card sangoro = new Card();
        sangoro.setCardNumber("OP05-065");
        sangoro.setName("Sangoro");
        sangoro.setCardType("Character");
        sangoro.setColor("Purple");
        sangoro.setCost(6);
        sangoro.setPower(8000);
        sangoro.setCounter(1000);
        sangoro.setAffiliations("Straw Hat Crew");
        sangoro.setAttribute("Strike");
        // No Effect
        sangoro.setImagePath("/images/cards/OP05/OP05-065.png");
        cardRepository.save(sangoro);

        Card jinbe = new Card();
        jinbe.setCardNumber("OP05-066");
        jinbe.setName("Jinbe");
        jinbe.setCardType("Character");
        jinbe.setColor("Purple");
        jinbe.setCost(5);
        jinbe.setPower(6000);
        jinbe.setCounter(1000);
        jinbe.setAffiliations("Straw Hat Crew");
        jinbe.setAttribute("Strike");
        jinbe.setEffect("[Blocker]\\n[Opponent's Turn] If your board has 10 DON!!, This character has power +1000.");
        jinbe.setImagePath("/images/cards/OP05/OP05-066.png");
        cardRepository.save(jinbe);

        Card zorojuro = new Card();
        zorojuro.setCardNumber("OP05-067");
        zorojuro.setName("Zorojuro");
        zorojuro.setCardType("Character");
        zorojuro.setColor("Purple");
        zorojuro.setCost(3);
        zorojuro.setPower(4000);
        zorojuro.setCounter(1000);
        zorojuro.setAffiliations("Straw Hat Crew");
        zorojuro.setAttribute("Slash");
        zorojuro.setEffect("[When Attacking] If you have 3 or less Life, Add up to 1 Don!! from your Don!! deck and set it as active.");
        zorojuro.setImagePath("/images/cards/OP05/OP05-067.png");
        cardRepository.save(zorojuro);

        Card chopperemon = new Card();
        chopperemon.setCardNumber("OP05-068");
        chopperemon.setName("Chopperemon");
        chopperemon.setCardType("Character");
        chopperemon.setColor("Purple");
        chopperemon.setCost(2);
        chopperemon.setPower(3000);
        chopperemon.setCounter(1000);
        chopperemon.setAffiliations("Animal / Straw Hat Crew");
        chopperemon.setAttribute("Wisdom");
        chopperemon.setEffect("[On Play] If you have 8 or more DON!! on your field, set up to 1 of your purple characters with 6000 power or less and the {Straw Hat Crew} type as active.");
        chopperemon.setImagePath("/images/cards/OP05/OP05-068.png");
        cardRepository.save(chopperemon);

        Card trafalgarLawPurple = new Card();
        trafalgarLawPurple.setCardNumber("OP05-069");
        trafalgarLawPurple.setName("Trafalgar Law");
        trafalgarLawPurple.setCardType("Character");
        trafalgarLawPurple.setColor("Purple");
        trafalgarLawPurple.setCost(3);
        trafalgarLawPurple.setPower(5000);
        // No Counter
        trafalgarLawPurple.setAffiliations("Heart Pirates");
        trafalgarLawPurple.setAttribute("Slash");
        trafalgarLawPurple.setEffect("[When Attacking] If your opponent has more DON!! cards on their field than you, look at 5 cards from the top of your deck; reveal up to 1 {Heart Pirates} type card and add it to your hand. Then, place the rest at the bottom of your deck in any order.");
        trafalgarLawPurple.setImagePath("/images/cards/OP05/OP05-069.png");
        cardRepository.save(trafalgarLawPurple);

        Card franosuke = new Card();
        franosuke.setCardNumber("OP05-070");
        franosuke.setName("Franosuke");
        franosuke.setCardType("Character");
        franosuke.setColor("Purple");
        franosuke.setCost(5);
        franosuke.setPower(4000);
        franosuke.setCounter(2000);
        franosuke.setAffiliations("Straw Hat Crew");
        franosuke.setAttribute("Strike");
        franosuke.setEffect("[DON!!x1] If you have 8 or more DON!! on your field, this character gains [Rush].");
        franosuke.setImagePath("/images/cards/OP05/OP05-070.png");
        cardRepository.save(franosuke);

        Card bepo = new Card();
        bepo.setCardNumber("OP05-071");
        bepo.setName("Bepo");
        bepo.setCardType("Character");
        bepo.setColor("Purple");
        bepo.setCost(3);
        bepo.setPower(5000);
        // No Counter
        bepo.setAffiliations("mink tribe / Heart pirates");
        bepo.setAttribute("Strike");
        bepo.setEffect("[When Attacking] If you have less DON!! cards on your field than your opponent, give up to 1 of your opponent's Characters -2000 power until the end of this turn.");
        bepo.setImagePath("/images/cards/OP05/OP05-071.png");
        cardRepository.save(bepo);

        Card bonekichi = new Card();
        bonekichi.setCardNumber("OP05-072");
        bonekichi.setName("Bonekichi");
        bonekichi.setCardType("Character");
        bonekichi.setColor("Purple");
        bonekichi.setCost(4);
        bonekichi.setPower(6000);
        // No Counter
        bonekichi.setAffiliations("Straw Hat Crew");
        bonekichi.setAttribute("Slash");
        bonekichi.setEffect("[On Play] If your board has 8 or more DON!!, give up to 2 opponent characters power -2000.");
        bonekichi.setImagePath("/images/cards/OP05/OP05-072.png");
        cardRepository.save(bonekichi);

        Card missDoublefinger = new Card();
        missDoublefinger.setCardNumber("OP05-073");
        missDoublefinger.setName("Miss Doublefinger");
        missDoublefinger.setCardType("Character");
        missDoublefinger.setColor("Purple");
        missDoublefinger.setCost(4);
        missDoublefinger.setPower(4000);
        missDoublefinger.setCounter(2000);
        missDoublefinger.setAffiliations("Baroque Works");
        missDoublefinger.setAttribute("Slash");
        missDoublefinger.setEffect("[On Play] You may trash 1 card from your hand: Add up to 1 DON!! card from your DON!! deck and rest it.\\n[Trigger] DON!! -1 (You may return the specified number of DON!! cards from your field to your DON!! deck): Play this card.");
        missDoublefinger.setImagePath("/images/cards/OP05/OP05-073.png");
        cardRepository.save(missDoublefinger);

        Card eustassCaptainKid = new Card();
        eustassCaptainKid.setCardNumber("OP05-074");
        eustassCaptainKid.setName("Eustass'Captain'Kid");
        eustassCaptainKid.setCardType("Character");
        eustassCaptainKid.setColor("Purple");
        eustassCaptainKid.setCost(5);
        eustassCaptainKid.setPower(6000);
        eustassCaptainKid.setCounter(1000);
        eustassCaptainKid.setAffiliations("Kid Pirates");
        eustassCaptainKid.setAttribute("Special");
        eustassCaptainKid.setEffect("[Blocker]\\n[Your Turn] [Once Per Turn] When a DON!! card from your field is returned to your DON!! deck, add 1 DON!! from your DON!! deck as active.");
        eustassCaptainKid.setImagePath("/images/cards/OP05/OP05-074.png");
        cardRepository.save(eustassCaptainKid);

        Card mr1 = new Card();
        mr1.setCardNumber("OP05-075");
        mr1.setName("Mr.1 (Daz Bones)");
        mr1.setCardType("Character");
        mr1.setColor("Purple");
        mr1.setCost(1);
        mr1.setPower(1000);
        mr1.setCounter(1000);
        mr1.setAffiliations("Baroque Works");
        mr1.setAttribute("Slash");
        mr1.setEffect("[On Opponent's Attack] [Once Per Turn] Don -1: Play up to 1 Baroque Works type Character Card with a cost of 3 or less from your hand.");
        mr1.setImagePath("/images/cards/OP05/OP05-075.png");
        cardRepository.save(mr1);

        // Events
        Card whenYoureAtSea = new Card();
        whenYoureAtSea.setCardNumber("OP05-076");
        whenYoureAtSea.setName("When you're at sea you fight pirates!!!");
        whenYoureAtSea.setCardType("Event");
        whenYoureAtSea.setColor("Purple");
        whenYoureAtSea.setCost(1);
        whenYoureAtSea.setAffiliations("Wano Country");
        whenYoureAtSea.setEffect("[Main] Look at the top 3 cards of your deck, reveal up to 1 <Straw Hat Crew>, <Kid Pirates>, or <Heart Pirates> type card and add it to your hand. Then, place the remaining cards at the bottom of your deck in any order.\\n[Trigger] Activate this card's [Main] effect");
        whenYoureAtSea.setImagePath("/images/cards/OP05/OP05-076.png");
        cardRepository.save(whenYoureAtSea);

        Card gammaKnife = new Card();
        gammaKnife.setCardNumber("OP05-077");
        gammaKnife.setName("Gamma Knife");
        gammaKnife.setCardType("Event");
        gammaKnife.setColor("Purple");
        gammaKnife.setCost(2);
        gammaKnife.setAffiliations("Heart Pirates");
        gammaKnife.setEffect("[Main] DON!!-1 Give up to one of your opponent's characters Power -5000.\\n[Trigger] Add up to 1 DON!! from your deck as active.");
        gammaKnife.setImagePath("/images/cards/OP05/OP05-077.png");
        cardRepository.save(gammaKnife);

        Card punkRotten = new Card();
        punkRotten.setCardNumber("OP05-078");
        punkRotten.setName("Punk Rotten");
        punkRotten.setCardType("Event");
        punkRotten.setColor("Purple");
        punkRotten.setCost(2);
        punkRotten.setAffiliations("Kid Pirates");
        punkRotten.setEffect("[Main] DON!!-1 Choose 1 of your leader or character with <Kid Pirates> attribute, give power +5000.\\n[Trigger] Add up to 1 DON!! from your deck as active.");
        punkRotten.setImagePath("/images/cards/OP05/OP05-078.png");
        cardRepository.save(punkRotten);
        
        System.out.println("Finished initializing OP05 Purple cards");
    }

    private void initializeOP05BlackCards() {
        System.out.println("Initializing OP05 Black cards...");

        // Characters
        Card violaBlack = new Card();
        violaBlack.setCardNumber("OP05-079");
        violaBlack.setName("Viola");
        violaBlack.setCardType("Character");
        violaBlack.setColor("Black");
        violaBlack.setCost(2);
        violaBlack.setPower(3000);
        violaBlack.setCounter(1000);
        violaBlack.setAffiliations("Dressrosa");
        violaBlack.setAttribute("Special");
        violaBlack.setEffect("[On Play] Your opponent chooses 3 cards in their trash and they return them to the bottom of their deck in any order.");
        violaBlack.setImagePath("/images/cards/OP05/OP05-079.png");
        cardRepository.save(violaBlack);

        Card elizabelloII = new Card();
        elizabelloII.setCardNumber("OP05-080");
        elizabelloII.setName("Elizabello II");
        elizabelloII.setCardType("Character");
        elizabelloII.setColor("Black");
        elizabelloII.setCost(4);
        elizabelloII.setPower(5000);
        elizabelloII.setCounter(1000);
        elizabelloII.setAffiliations("Prodence Kingdom / Dressrosa");
        elizabelloII.setAttribute("Strike");
        elizabelloII.setEffect("[When Attacking] [Once Per Turn] You may return 20 cards from your trash to your deck and shuffle: During this battle, this Character gains [Double Attack] and +10000 power.");
        elizabelloII.setImagePath("/images/cards/OP05/OP05-080.png");
        cardRepository.save(elizabelloII);

        Card oneLeggedSoldier = new Card();
        oneLeggedSoldier.setCardNumber("OP05-081");
        oneLeggedSoldier.setName("One-Legged Soldier");
        oneLeggedSoldier.setCardType("Character");
        oneLeggedSoldier.setColor("Black");
        oneLeggedSoldier.setCost(2);
        oneLeggedSoldier.setPower(0);
        oneLeggedSoldier.setCounter(2000);
        oneLeggedSoldier.setAffiliations("Dressrosa");
        oneLeggedSoldier.setAttribute("Strike");
        oneLeggedSoldier.setEffect("[Activate: Main] You may send this character to the trash: give up to one of your opponent's characters cost-3.");
        oneLeggedSoldier.setImagePath("/images/cards/OP05/OP05-081.png");
        cardRepository.save(oneLeggedSoldier);

        Card shirahoshi = new Card();
        shirahoshi.setCardNumber("OP05-082");
        shirahoshi.setName("Shirahoshi");
        shirahoshi.setCardType("Character");
        shirahoshi.setColor("Black");
        shirahoshi.setCost(1);
        shirahoshi.setPower(0);
        shirahoshi.setCounter(2000);
        shirahoshi.setAffiliations("Mermaid");
        shirahoshi.setAttribute("Wisdom");
        shirahoshi.setEffect("[Activate: Main] You may rest this character, then return 2 cards from your trash to the bottom of your deck in any order: If your opponent has 6 or more cards in their hand, your opponent discards 1.");
        shirahoshi.setImagePath("/images/cards/OP05/OP05-082.png");
        cardRepository.save(shirahoshi);

        Card stelly = new Card();
        stelly.setCardNumber("OP05-083");
        stelly.setName("Stelly");
        stelly.setCardType("Character");
        stelly.setColor("Black");
        stelly.setCost(2);
        stelly.setPower(4000);
        stelly.setCounter(1000);
        stelly.setAffiliations("Goa Kingdom");
        stelly.setAttribute("Wisdom");
        // No Effect
        stelly.setImagePath("/images/cards/OP05/OP05-083.png");
        cardRepository.save(stelly);

        Card stCharlos = new Card();
        stCharlos.setCardNumber("OP05-084");
        stCharlos.setName("St. Charlos");
        stCharlos.setCardType("Character");
        stCharlos.setColor("Black");
        stCharlos.setCost(3);
        stCharlos.setPower(0);
        stCharlos.setCounter(1000);
        stCharlos.setAffiliations("Celestial Dragon");
        stCharlos.setAttribute("Ranged");
        stCharlos.setEffect("[Your Turn] If all your characters have the [Celestial Dragon] type, then all of your opponents characters get -4 to their cost.");
        stCharlos.setImagePath("/images/cards/OP05/OP05-084.png");
        cardRepository.save(stCharlos);

        Card nefeltariCobraBlack = new Card();
        nefeltariCobraBlack.setCardNumber("OP05-085");
        nefeltariCobraBlack.setName("Nefeltari Cobra");
        nefeltariCobraBlack.setCardType("Character");
        nefeltariCobraBlack.setColor("Black");
        nefeltariCobraBlack.setCost(2);
        nefeltariCobraBlack.setPower(1000);
        nefeltariCobraBlack.setCounter(1000);
        nefeltariCobraBlack.setAffiliations("Alabasta Kingdom");
        nefeltariCobraBlack.setAttribute("Wisdom");
        nefeltariCobraBlack.setEffect("[Blocker]\\n[On Play] Trash the top card of your deck.");
        nefeltariCobraBlack.setImagePath("/images/cards/OP05/OP05-085.png");
        cardRepository.save(nefeltariCobraBlack);

        Card nefeltariViviBlack = new Card();
        nefeltariViviBlack.setCardNumber("OP05-086");
        nefeltariViviBlack.setName("Nefeltari Vivi");
        nefeltariViviBlack.setCardType("Character");
        nefeltariViviBlack.setColor("Black");
        nefeltariViviBlack.setCost(1);
        nefeltariViviBlack.setPower(1000);
        nefeltariViviBlack.setCounter(1000);
        nefeltariViviBlack.setAffiliations("Alabasta Kingdom");
        nefeltariViviBlack.setAttribute("Wisdom");
        nefeltariViviBlack.setEffect("If your trash has 10 cards or more, this character gains [Blocker].");
        nefeltariViviBlack.setImagePath("/images/cards/OP05/OP05-086.png");
        cardRepository.save(nefeltariViviBlack);

        Card hakuba = new Card();
        hakuba.setCardNumber("OP05-087");
        hakuba.setName("Hakuba");
        hakuba.setCardType("Character");
        hakuba.setColor("Black");
        hakuba.setCost(5);
        hakuba.setPower(6000);
        hakuba.setCounter(1000);
        hakuba.setAffiliations("Dressrosa / Beautiful Pirates");
        hakuba.setAttribute("Slash");
        hakuba.setEffect("[DON!!x1] [When Attacking] You may KO one of your characters other than this card: Give up to 1 of your opponent's characters cost -5.");
        hakuba.setImagePath("/images/cards/OP05/OP05-087.png");
        cardRepository.save(hakuba);

        Card mansherry = new Card();
        mansherry.setCardNumber("OP05-088");
        mansherry.setName("Mansherry");
        mansherry.setCardType("Character");
        mansherry.setColor("Black");
        mansherry.setCost(1);
        mansherry.setPower(0);
        mansherry.setCounter(1000);
        mansherry.setAffiliations("Tontatta Tribe / Dressrosa");
        mansherry.setAttribute("Special");
        mansherry.setEffect("[Activate: Main] ① (You may rest the specified number of DON!! cards in your Cost Area) Rest this character, return 2 cards from your trash to the bottom of your deck in any order: Return one cost 3 to 5 black character card from your trash to your hand.");
        mansherry.setImagePath("/images/cards/OP05/OP05-088.png");
        cardRepository.save(mansherry);

        Card saintMjosgard = new Card();
        saintMjosgard.setCardNumber("OP05-089");
        saintMjosgard.setName("Saint Mjosgard");
        saintMjosgard.setCardType("Character");
        saintMjosgard.setColor("Black");
        saintMjosgard.setCost(5);
        saintMjosgard.setPower(1000);
        saintMjosgard.setCounter(1000);
        saintMjosgard.setAffiliations("Celestial Dragon");
        saintMjosgard.setAttribute("Wisdom");
        saintMjosgard.setEffect("[Activate: Main] ①(You may rest the specified number of DON!! cards in your Cost Area) you may rest this character and 1 of your characters: Add up to 1 black character with a cost of 1 or less from your trash to your hand.");
        saintMjosgard.setImagePath("/images/cards/OP05/OP05-089.png");
        cardRepository.save(saintMjosgard);

        Card rikuDoldo = new Card();
        rikuDoldo.setCardNumber("OP05-090");
        rikuDoldo.setName("Riku Doldo the Third");
        rikuDoldo.setCardType("Character");
        rikuDoldo.setColor("Black");
        rikuDoldo.setCost(4);
        rikuDoldo.setPower(5000);
        rikuDoldo.setCounter(1000);
        rikuDoldo.setAffiliations("Dressrosa");
        rikuDoldo.setAttribute("Wisdom");
        rikuDoldo.setEffect("[Blocker]\\n[On Play] / [On K.O.] Select one of your character with <Dressrosa> attribute, give power +2k for the turn.");
        rikuDoldo.setImagePath("/images/cards/OP05/OP05-090.png");
        cardRepository.save(rikuDoldo);

        Card rebeccaBlack = new Card();
        rebeccaBlack.setCardNumber("OP05-091");
        rebeccaBlack.setName("Rebecca");
        rebeccaBlack.setCardType("Character");
        rebeccaBlack.setColor("Black");
        rebeccaBlack.setCost(4);
        rebeccaBlack.setPower(0);
        rebeccaBlack.setCounter(1000);
        rebeccaBlack.setAffiliations("Dressrosa");
        rebeccaBlack.setAttribute("Wisdom");
        rebeccaBlack.setEffect("[Blocker]\\n[On Play] Return up to 1 black character other than \"Rebecca\" with a cost of 3 to 7 from the trash to your hand. Then, play 1 cost 3 or less black character from your hand to the field rested.");
        rebeccaBlack.setImagePath("/images/cards/OP05/OP05-091.png");
        cardRepository.save(rebeccaBlack);

        Card stRosward = new Card();
        stRosward.setCardNumber("OP05-092");
        stRosward.setName("St. Rosward");
        stRosward.setCardType("Character");
        stRosward.setColor("Black");
        stRosward.setCost(5);
        stRosward.setPower(0);
        stRosward.setCounter(1000);
        stRosward.setAffiliations("Celestial Dragon");
        stRosward.setAttribute("Ranged");
        stRosward.setEffect("[Your Turn] If all your characters have the {Celestial Dragon} type, then all of your opponents characters get -6 to their cost.");
        stRosward.setImagePath("/images/cards/OP05/OP05-092.png");
        cardRepository.save(stRosward);

        Card robLucci = new Card();
        robLucci.setCardNumber("OP05-093");
        robLucci.setName("Rob Lucci");
        robLucci.setCardType("Character");
        robLucci.setColor("Black");
        robLucci.setCost(4);
        robLucci.setPower(6000);
        // No Counter
        robLucci.setAffiliations("CP0");
        robLucci.setAttribute("Strike");
        robLucci.setEffect("[On Play] You may place 3 cards from your trash on the bottom of your deck in any order: K.O. up to 1 of your opponent's characters with a cost of 2 or less and up to 1 of your opponent's characters with a cost of 1 or less.");
        robLucci.setImagePath("/images/cards/OP05/OP05-093.png");
        cardRepository.save(robLucci);

        // Events
        Card hauteCouturePatchWork = new Card();
        hauteCouturePatchWork.setCardNumber("OP05-094");
        hauteCouturePatchWork.setName("Haute Couture: Patch*Work");
        hauteCouturePatchWork.setCardType("Event");
        hauteCouturePatchWork.setColor("Black");
        hauteCouturePatchWork.setCost(1);
        hauteCouturePatchWork.setAffiliations("Tontatta Tribe / Dressrosa");
        hauteCouturePatchWork.setEffect("[Main] Give up to 1 of your opponent's characters -3 cost during this turn. Then, up to 1 of your opponent's characters with a cost of 0 isn't set as active during the next Refresh Phase.\\n[Trigger] Draw 2 cards, then trash 1 card from your hand.");
        hauteCouturePatchWork.setImagePath("/images/cards/OP05/OP05-094.png");
        cardRepository.save(hauteCouturePatchWork);

        Card dragonClaw = new Card();
        dragonClaw.setCardNumber("OP05-095");
        dragonClaw.setName("Dragon Claw");
        dragonClaw.setCardType("Event");
        dragonClaw.setColor("Black");
        dragonClaw.setCost(2);
        dragonClaw.setAffiliations("Dressrosa/Revolutionary Army");
        dragonClaw.setEffect("[Counter] Up to 1 of your Leader or Character cards gains +4000 power during this battle. Then, if you have 15 or more cards in your trash, K.O. up to 1 of your opponent's Characters with a cost of 4 or less.");
        dragonClaw.setImagePath("/images/cards/OP05/OP05-095.png");
        cardRepository.save(dragonClaw);

        Card iBid500Million = new Card();
        iBid500Million.setCardNumber("OP05-096");
        iBid500Million.setName("I bid 500 million!!");
        iBid500Million.setCardType("Event");
        iBid500Million.setColor("Black");
        iBid500Million.setCost(3);
        iBid500Million.setAffiliations("Celestial Dragon");
        iBid500Million.setEffect("[Main] K.O. up to 1 of your opponent's cost 1 or lower Characters, or return it to it's owners hand or place it at the top or bottom of it's owner's life. Then, if you have a {Celestial Dragon} type character, draw 1 card.\\n[Trigger] K.O. up to 1 of your opponent's cost 6 or lower Characters, or return it to it's owners hand");
        iBid500Million.setImagePath("/images/cards/OP05/OP05-096.png");
        cardRepository.save(iBid500Million);

        // Stages
        Card theHolyLandMaryGeoise = new Card();
        theHolyLandMaryGeoise.setCardNumber("OP05-097");
        theHolyLandMaryGeoise.setName("The Holy Land Mary Geoise");
        theHolyLandMaryGeoise.setCardType("Stage");
        theHolyLandMaryGeoise.setColor("Black");
        theHolyLandMaryGeoise.setCost(1);
        theHolyLandMaryGeoise.setAffiliations("The Holy Land Mary Geoise");
        theHolyLandMaryGeoise.setEffect("[Your Turn] Character cards that cost 2 or more and have the {Celestial Dragon} type cost 1 less to play from your hand.");
        theHolyLandMaryGeoise.setImagePath("/images/cards/OP05/OP05-097.png");
        cardRepository.save(theHolyLandMaryGeoise);
        
        System.out.println("Finished initializing OP05 Black cards");
    }

    private void initializeOP05YellowCards() {
        System.out.println("Initializing OP05 Yellow cards (and Secret Rares)...");

        // Leaders
        Card enelLeader = new Card();
        enelLeader.setCardNumber("OP05-098");
        enelLeader.setName("Enel");
        enelLeader.setCardType("Leader");
        enelLeader.setColor("Yellow");
        enelLeader.setPower(5000);
        enelLeader.setLife(4);
        enelLeader.setAffiliations("Sky Island");
        enelLeader.setAttribute("Special");
        enelLeader.setEffect("[Opponent's Turn] [Once Per Turn] When your life hits 0, you may add the top card of your deck to your life. Then, discard 1 card from your hand.");
        enelLeader.setImagePath("/images/cards/OP05/OP05-098.png");
        cardRepository.save(enelLeader);

        // Characters
        Card amazon = new Card();
        amazon.setCardNumber("OP05-099");
        amazon.setName("Amazon");
        amazon.setCardType("Character");
        amazon.setColor("Yellow");
        amazon.setCost(3);
        amazon.setPower(0);
        amazon.setCounter(1000);
        amazon.setAffiliations("Sky Island");
        amazon.setAttribute("Wisdom");
        amazon.setEffect("[On Opponent's Attack] You may rest this character: Your opponent may place 1 card from the top of their life in the trash. If they don't, up to 1 of your opponent's leaders or characters has -2000 Power this turn.");
        amazon.setImagePath("/images/cards/OP05/OP05-099.png");
        cardRepository.save(amazon);

        Card enelChar = new Card();
        enelChar.setCardNumber("OP05-100");
        enelChar.setName("Enel");
        enelChar.setCardType("Character");
        enelChar.setColor("Yellow");
        enelChar.setCost(7);
        enelChar.setPower(7000);
        // No Counter
        enelChar.setAffiliations("Sky Island");
        enelChar.setAttribute("Special");
        enelChar.setEffect("[Rush]\\n[Once Per Turn] If this character were to be removed from the field, you may trash the top card of your life instead. If character [Monkey D. Luffy] is on the field, this effect may not be activated.");
        enelChar.setImagePath("/images/cards/OP05/OP05-100.png");
        cardRepository.save(enelChar);

        Card ohm = new Card();
        ohm.setCardNumber("OP05-101");
        ohm.setName("Ohm");
        ohm.setCardType("Character");
        ohm.setColor("Yellow");
        ohm.setCost(4);
        ohm.setPower(5000);
        ohm.setCounter(1000);
        ohm.setAffiliations("Sky Island / God's Priest");
        ohm.setAttribute("Slash");
        ohm.setEffect("If you have 2 or less Life, this character gains +1000 Power.\\n[On Play] Look at the top 5 cards of your deck; reveal up to 1 [Holy] card and add it to your hand. Then, place the rest on the bottom of your deck in any order. Then, play up to 1 [Holy] from your hand.");
        ohm.setImagePath("/images/cards/OP05/OP05-101.png");
        cardRepository.save(ohm);

        Card gedatsu = new Card();
        gedatsu.setCardNumber("OP05-102");
        gedatsu.setName("Gedatsu");
        gedatsu.setCardType("Character");
        gedatsu.setColor("Yellow");
        gedatsu.setCost(5);
        gedatsu.setPower(6000);
        gedatsu.setCounter(1000);
        gedatsu.setAffiliations("Sky Island / God's Priest");
        gedatsu.setAttribute("Strike");
        gedatsu.setEffect("[On Play] KO up to 1 of your opponent's characters with cost equal or less than their Life.");
        gedatsu.setImagePath("/images/cards/OP05/OP05-102.png");
        cardRepository.save(gedatsu);

        Card kotori = new Card();
        kotori.setCardNumber("OP05-103");
        kotori.setName("Kotori");
        kotori.setCardType("Character");
        kotori.setColor("Yellow");
        kotori.setCost(3);
        kotori.setPower(3000);
        kotori.setCounter(1000);
        kotori.setAffiliations("Sky Island");
        kotori.setAttribute("Special");
        kotori.setEffect("[On Play] If you have [Hotori], K.O. up to 1 of your opponent's characters with a cost equal to or less than the number of your opponent's life cards.");
        kotori.setImagePath("/images/cards/OP05/OP05-103.png");
        cardRepository.save(kotori);

        Card conis = new Card();
        conis.setCardNumber("OP05-104");
        conis.setName("Conis");
        conis.setCardType("Character");
        conis.setColor("Yellow");
        conis.setCost(1);
        conis.setPower(0);
        conis.setCounter(2000);
        conis.setAffiliations("Sky Island");
        conis.setAttribute("Wisdom");
        conis.setEffect("[On Play] You may place 1 of your stage cards on the bottom of your deck: Draw 1 cards, then trash 1.");
        conis.setImagePath("/images/cards/OP05/OP05-104.png");
        cardRepository.save(conis);

        Card satori = new Card();
        satori.setCardNumber("OP05-105");
        satori.setName("Satori");
        satori.setCardType("Character");
        satori.setColor("Yellow");
        satori.setCost(5);
        satori.setPower(5000);
        satori.setCounter(2000);
        satori.setAffiliations("Sky Island / God's Priest");
        satori.setAttribute("Strike");
        satori.setEffect("[Trigger] You may trash 1cards from your hand: Play this card.");
        satori.setImagePath("/images/cards/OP05/OP05-105.png");
        cardRepository.save(satori);

        Card shura = new Card();
        shura.setCardNumber("OP05-106");
        shura.setName("Shura");
        shura.setCardType("Character");
        shura.setColor("Yellow");
        shura.setCost(2);
        shura.setPower(2000);
        shura.setCounter(1000);
        shura.setAffiliations("Sky Island / God's Priests");
        shura.setAttribute("Slash");
        shura.setEffect("[On Play] Look at the top 5 cards of your deck, reveal up to 1 [Sky Island] type card other than [Shura] and add it to your hand. Return the rest to the bottom of your deck in any order.\\n[Trigger] Play this card.");
        shura.setImagePath("/images/cards/OP05/OP05-106.png");
        cardRepository.save(shura);

        Card firstLieutenantSpacey = new Card();
        firstLieutenantSpacey.setCardNumber("OP05-107");
        firstLieutenantSpacey.setName("First Lieutenant Spacey");
        firstLieutenantSpacey.setCardType("Character");
        firstLieutenantSpacey.setColor("Yellow");
        firstLieutenantSpacey.setCost(3);
        firstLieutenantSpacey.setPower(4000);
        firstLieutenantSpacey.setCounter(1000);
        firstLieutenantSpacey.setAffiliations("Moon");
        firstLieutenantSpacey.setAttribute("Ranged");
        firstLieutenantSpacey.setEffect("[Your Turn] [Once Per Turn] When one of your life cards is put into your hand this character gets +2000 this turn.");
        firstLieutenantSpacey.setImagePath("/images/cards/OP05/OP05-107.png");
        cardRepository.save(firstLieutenantSpacey);

        Card nora = new Card();
        nora.setCardNumber("OP05-108");
        nora.setName("Nora");
        nora.setCardType("Character");
        nora.setColor("Yellow");
        nora.setCost(5);
        nora.setPower(7000);
        nora.setCounter(1000);
        nora.setAffiliations("Sky Island");
        nora.setAttribute("Strike");
        // No Effect
        nora.setImagePath("/images/cards/OP05/OP05-108.png");
        cardRepository.save(nora);

        Card pagaya = new Card();
        pagaya.setCardNumber("OP05-109");
        pagaya.setName("Pagaya");
        pagaya.setCardType("Character");
        pagaya.setColor("Yellow");
        pagaya.setCost(1);
        pagaya.setPower(1000);
        pagaya.setCounter(1000);
        pagaya.setAffiliations("Sky Island");
        pagaya.setAttribute("Wisdom");
        pagaya.setEffect("[Once Per Turn] When a Trigger activates, draw 2 cards and trash 2 cards from your hand.");
        pagaya.setImagePath("/images/cards/OP05/OP05-109.png");
        cardRepository.save(pagaya);

        Card holy = new Card();
        holy.setCardNumber("OP05-110");
        holy.setName("Holy");
        holy.setCardType("Character");
        holy.setColor("Yellow");
        holy.setCost(3);
        holy.setPower(5000);
        holy.setCounter(1000);
        holy.setAffiliations("Animal/Sky Island");
        holy.setAttribute("Strike");
        // No Effect
        holy.setImagePath("/images/cards/OP05/OP05-110.png");
        cardRepository.save(holy);

        Card hotori = new Card();
        hotori.setCardNumber("OP05-111");
        hotori.setName("Hotori");
        hotori.setCardType("Character");
        hotori.setColor("Yellow");
        hotori.setCost(3);
        hotori.setPower(3000);
        hotori.setCounter(1000);
        hotori.setAffiliations("Sky Island");
        hotori.setAttribute("Special");
        hotori.setEffect("[On Play] You may play 1 [Kotori] from your hand: Add up to 1 of your opponent's Characters with a cost of 3 or less to the top or bottom of the owner's Life cards face-up.");
        hotori.setImagePath("/images/cards/OP05/OP05-111.png");
        cardRepository.save(hotori);

        Card captainMcKinley = new Card();
        captainMcKinley.setCardNumber("OP05-112");
        captainMcKinley.setName("Captain McKinley");
        captainMcKinley.setCardType("Character");
        captainMcKinley.setColor("Yellow");
        captainMcKinley.setCost(3);
        captainMcKinley.setPower(3000);
        captainMcKinley.setCounter(1000);
        captainMcKinley.setAffiliations("Sky Island");
        captainMcKinley.setAttribute("Wisdom");
        captainMcKinley.setEffect("[Blocker]\\n[On K.O.] Play up 1 cost 1 [Sky Island] type character card from your hand.");
        captainMcKinley.setImagePath("/images/cards/OP05/OP05-112.png");
        cardRepository.save(captainMcKinley);

        Card yama = new Card();
        yama.setCardNumber("OP05-113");
        yama.setName("Yama");
        yama.setCardType("Character");
        yama.setColor("Yellow");
        yama.setCost(2);
        yama.setPower(2000);
        yama.setCounter(1000);
        yama.setAffiliations("Sky Island");
        yama.setAttribute("Slash");
        yama.setEffect("[Blocker]");
        yama.setImagePath("/images/cards/OP05/OP05-113.png");
        cardRepository.save(yama);

        // Events
        Card elThor = new Card();
        elThor.setCardNumber("OP05-114");
        elThor.setName("El Thor");
        elThor.setCardType("Event");
        elThor.setColor("Yellow");
        elThor.setCost(1);
        elThor.setAffiliations("Sky Island");
        elThor.setEffect("[Counter] Give up to 1 of your Leader or Characters +2000 for this battle. Then, if your opponent has 2 or less life, give that card an additional +2000 power.\\n[Trigger] KO up to 1 of your opponents characters with a cost equal or less to their life total.");
        elThor.setImagePath("/images/cards/OP05/OP05-114.png");
        cardRepository.save(elThor);

        Card amaru200MilV = new Card();
        amaru200MilV.setCardNumber("OP05-115");
        amaru200MilV.setName("200,000,000 V Amaru");
        amaru200MilV.setCardType("Event");
        amaru200MilV.setColor("Yellow");
        amaru200MilV.setCost(2);
        amaru200MilV.setAffiliations("Sky Island");
        amaru200MilV.setEffect("[Main] Up to 1 of your leaders or characters gains +3000 Power this turn. Then, if your life is 1 card or less, rest up to 1 of your opponent's characters with a cost of 4 or less.\\n[Trigger] You may trash 2 cards from your hand: Add up to 1 card from the top of your deck to the top of your life.");
        amaru200MilV.setImagePath("/images/cards/OP05/OP05-115.png");
        cardRepository.save(amaru200MilV);

        Card thunderbird30MilV = new Card();
        thunderbird30MilV.setCardNumber("OP05-116");
        thunderbird30MilV.setName("30 Million Volt Thunderbird");
        thunderbird30MilV.setCardType("Event");
        thunderbird30MilV.setColor("Yellow");
        thunderbird30MilV.setCost(2);
        thunderbird30MilV.setAffiliations("Sky Island");
        thunderbird30MilV.setEffect("[Main] KO up to one of your opponent's characters with a cost equal or less than their life.\\n[Trigger] Activate this cards [Main] effect.");
        thunderbird30MilV.setImagePath("/images/cards/OP05/OP05-116.png");
        cardRepository.save(thunderbird30MilV);

        // Stages
        Card upperYard = new Card();
        upperYard.setCardNumber("OP05-117");
        upperYard.setName("Upper Yard");
        upperYard.setCardType("Stage");
        upperYard.setColor("Yellow");
        upperYard.setCost(1);
        upperYard.setAffiliations("Sky Island");
        upperYard.setEffect("[On Play] Look at the top 5 cards of your deck, reveal up to 1 card with the {Sky Island} type and add it to your hand. Then, place the remaining cards at the bottom of your deck in any order.");
        upperYard.setImagePath("/images/cards/OP05/OP05-117.png");
        cardRepository.save(upperYard);
        
        // Secret Rares
        Card kaidoSecret = new Card();
        kaidoSecret.setCardNumber("OP05-118");
        kaidoSecret.setName("Kaido");
        kaidoSecret.setCardType("Character");
        kaidoSecret.setColor("Blue/Yellow"); // Dual Color
        kaidoSecret.setCost(10);
        kaidoSecret.setPower(12000);
        // No Counter
        kaidoSecret.setAffiliations("Four Emperors / Animal Kingdom Pirates");
        kaidoSecret.setAttribute("Special");
        kaidoSecret.setEffect("[On Play] If your opponent has 3 or less Life cards, draw 4 cards.");
        kaidoSecret.setImagePath("/images/cards/OP05/OP05-118.png");
        cardRepository.save(kaidoSecret);

        Card luffySecret = new Card();
        luffySecret.setCardNumber("OP05-119");
        luffySecret.setName("Monkey D. Luffy");
        luffySecret.setCardType("Character");
        luffySecret.setColor("Purple/Yellow"); // Dual Color - Gear 5 Luffy
        luffySecret.setCost(10);
        luffySecret.setPower(12000);
        // No Counter
        luffySecret.setAffiliations("Four Emperors / Straw Hat Crew");
        luffySecret.setAttribute("Strike");
        luffySecret.setEffect("[On Play] DON!! -10: Place all your Characters other than this Character at the bottom of your deck in any order. Then, after this turn, take another turn.\\n[Activate: Main] [Once Per Turn] ① Add one DON!! from your DON!! deck as active.");
        luffySecret.setImagePath("/images/cards/OP05/OP05-119.png");
        cardRepository.save(luffySecret);
        
        System.out.println("Finished initializing OP05 Yellow cards and Secret Rares");
    }
} 