package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.config.BaseInitializer;
import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(23) // Order after ST12
public class ST13Initializer extends BaseInitializer {

    private final CardRepository cardRepository;

    @Autowired
    public ST13Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    protected void initialize(String... args) throws Exception {
        String setCode = "ST13";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // Leader Cards
        Card sabo = new Card();
        sabo.setCardNumber("ST13-001");
        sabo.setName("Sabo");
        sabo.setCardType("LEADER");
        sabo.setLife(4);
        sabo.setColor("RED");
        sabo.setPower(5000);
        sabo.setCost(null);
        sabo.setAffiliations("Dressrosa/Revolutionary Army");
        sabo.setAttribute("DON!!×1");
        sabo.setTiming("Activate: Main");
        sabo.setEffect("Once Per Turn You may add 1 of your cost 3 or higher characters with 7000 Power or higher to the top of your life face up. Give up to 1 of your characters +2000 Power until the start of your next turn.");
        sabo.setImagePath("/images/cards/ST13/ST13-001.png");
        sabo.setCounter(null);
        cardRepository.save(sabo);
        
        Card portgasDAce = new Card();
        portgasDAce.setCardNumber("ST13-002");
        portgasDAce.setName("Portgas D. Ace");
        portgasDAce.setCardType("LEADER");
        portgasDAce.setLife(4);
        portgasDAce.setColor("BLUE");
        portgasDAce.setPower(5000);
        portgasDAce.setCost(null);
        portgasDAce.setAffiliations("Whitebeard Pirates");
        portgasDAce.setAttribute("DON!!×2");
        portgasDAce.setTiming("Activate: Main");
        portgasDAce.setEffect("Once Per Turn Look at the top 5 cards of your deck. Add up to 1 5 cost character card to the top of your life face up. Then, place the remaining cards at the bottom of your deck in any order. At the end of your turn Send all face up cards in your life to the trash.");
        portgasDAce.setImagePath("/images/cards/ST13/ST13-002.png");
        portgasDAce.setCounter(null);
        cardRepository.save(portgasDAce);
        
        Card monkeyDLuffy = new Card();
        monkeyDLuffy.setCardNumber("ST13-003");
        monkeyDLuffy.setName("Monkey D. Luffy");
        monkeyDLuffy.setCardType("LEADER");
        monkeyDLuffy.setLife(4);
        monkeyDLuffy.setColor("YELLOW");
        monkeyDLuffy.setPower(5000);
        monkeyDLuffy.setCost(null);
        monkeyDLuffy.setAffiliations("Supernova/Straw Hat Crew");
        monkeyDLuffy.setAttribute("DON!!×2");
        monkeyDLuffy.setTiming("Activate: Main");
        monkeyDLuffy.setEffect("Once Per Turn You may discard one card from your hand: if your life is at 0 cards, you may add up to 2 5 cost characters from your hand or trash to your life face up.");
        monkeyDLuffy.setImagePath("/images/cards/ST13/ST13-003.png");
        monkeyDLuffy.setCounter(null);
        cardRepository.save(monkeyDLuffy);
        
        // Character Cards
        Card sabo5Cost = new Card();
        sabo5Cost.setCardNumber("ST13-008");
        sabo5Cost.setName("Sabo");
        sabo5Cost.setCardType("CHARACTER");
        sabo5Cost.setColor("RED");
        sabo5Cost.setPower(6000);
        sabo5Cost.setCost(5);
        sabo5Cost.setAffiliations("Dressrosa / Revolutionary Army");
        sabo5Cost.setAttribute(null);
        sabo5Cost.setTiming("On Play");
        sabo5Cost.setEffect("You may trash the top or bottom card of your life: KO. up to one of your opponent's characters with a cost of 5 or less.");
        sabo5Cost.setImagePath("/images/cards/ST13/ST13-008.png");
        sabo5Cost.setCounter(1000);
        cardRepository.save(sabo5Cost);
        
        Card edwardNewgate = new Card();
        edwardNewgate.setCardNumber("ST13-004");
        edwardNewgate.setName("Edward Newgate");
        edwardNewgate.setCardType("CHARACTER");
        edwardNewgate.setColor("RED");
        edwardNewgate.setPower(7000);
        edwardNewgate.setCost(6);
        edwardNewgate.setAffiliations("Four Emperors / Whitebeard Pirates");
        edwardNewgate.setAttribute(null);
        edwardNewgate.setTiming("On Play");
        edwardNewgate.setEffect("Add the top card of your deck to the top of your life cards. Then, look at all your life cards, place 1 of the cards on the top of your deck. Return your remaining life cards in your desired order.");
        edwardNewgate.setImagePath("/images/cards/ST13/ST13-004.png");
        edwardNewgate.setCounter(1000);
        cardRepository.save(edwardNewgate);
        
        Card curlyDadan = new Card();
        curlyDadan.setCardNumber("ST13-006");
        curlyDadan.setName("Curly Dadan");
        curlyDadan.setCardType("CHARACTER");
        curlyDadan.setColor("YELLOW");
        curlyDadan.setPower(4000);
        curlyDadan.setCost(5);
        curlyDadan.setAffiliations("Bandit");
        curlyDadan.setAttribute(null);
        curlyDadan.setTiming("On Play");
        curlyDadan.setEffect("Play up to 1 of each of a cost 2 [Sabo], [Portgas D. Ace], or [Monkey D. Luffy] from your hand.");
        curlyDadan.setImagePath("/images/cards/ST13/ST13-006.png");
        curlyDadan.setCounter(1000);
        cardRepository.save(curlyDadan);
        
        Card emporioIvankov = new Card();
        emporioIvankov.setCardNumber("ST13-005");
        emporioIvankov.setName("Emporio Ivankov");
        emporioIvankov.setCardType("CHARACTER");
        emporioIvankov.setColor("BLUE");
        emporioIvankov.setPower(4000);
        emporioIvankov.setCost(3);
        emporioIvankov.setAffiliations("Revolutionary Army");
        emporioIvankov.setAttribute(null);
        emporioIvankov.setTiming("On Play");
        emporioIvankov.setEffect("You may trash the top or bottom card of your life: Reveal one cost 5 character card from your hand then place it facedown on the top of your life.");
        emporioIvankov.setImagePath("/images/cards/ST13/ST13-005.png");
        emporioIvankov.setCounter(1000);
        cardRepository.save(emporioIvankov);
        
        Card makino = new Card();
        makino.setCardNumber("ST13-012");
        makino.setName("Makino");
        makino.setCardType("CHARACTER");
        makino.setColor("YELLOW");
        makino.setPower(0);
        makino.setCost(1);
        makino.setAffiliations("Windmill Village");
        makino.setAttribute(null);
        makino.setTiming("On Play");
        makino.setEffect("You may add the top or bottom card of your life to your hand: Look at your life cards, then return them in any order.");
        makino.setImagePath("/images/cards/ST13/ST13-012.png");
        makino.setCounter(2000);
        cardRepository.save(makino);
        
        Card youngMonkeyDLuffy = new Card();
        youngMonkeyDLuffy.setCardNumber("ST13-014");
        youngMonkeyDLuffy.setName("Monkey D. Luffy");
        youngMonkeyDLuffy.setCardType("CHARACTER");
        youngMonkeyDLuffy.setColor("YELLOW");
        youngMonkeyDLuffy.setPower(2000);
        youngMonkeyDLuffy.setCost(2);
        youngMonkeyDLuffy.setAffiliations("Goa Kingdom");
        youngMonkeyDLuffy.setAttribute(null);
        youngMonkeyDLuffy.setTiming("Activate: Main");
        youngMonkeyDLuffy.setEffect("You may trash this character: Reveal the top card of your life, if the card is a 5 cost (Monkey D. Luffy) card, you may play it. If you play it, up to 1 of your leaders gets +2000 Power until the end of your opponent's turn.");
        youngMonkeyDLuffy.setImagePath("/images/cards/ST13/ST13-014.png");
        youngMonkeyDLuffy.setCounter(1000);
        cardRepository.save(youngMonkeyDLuffy);
        
        Card youngSabo = new Card();
        youngSabo.setCardNumber("ST13-007");
        youngSabo.setName("Sabo");
        youngSabo.setCardType("CHARACTER");
        youngSabo.setColor("YELLOW");
        youngSabo.setPower(2000);
        youngSabo.setCost(2);
        youngSabo.setAffiliations("Goa Kingdom");
        youngSabo.setAttribute(null);
        youngSabo.setTiming("Activate: Main");
        youngSabo.setEffect("You may trash this character: Reveal the top card of your life, if the card is a 5 cost (Sabo) card, you may play it. If you play it, up to 1 of your leaders gets +2000 Power until the end of your opponent's turn.");
        youngSabo.setImagePath("/images/cards/ST13/ST13-007.png");
        youngSabo.setCounter(1000);
        cardRepository.save(youngSabo);
        
        Card youngPortgasDAce = new Card();
        youngPortgasDAce.setCardNumber("ST13-010");
        youngPortgasDAce.setName("Portgas D. Ace");
        youngPortgasDAce.setCardType("CHARACTER");
        youngPortgasDAce.setColor("YELLOW");
        youngPortgasDAce.setPower(2000);
        youngPortgasDAce.setCost(2);
        youngPortgasDAce.setAffiliations("Goa Kingdom");
        youngPortgasDAce.setAttribute(null);
        youngPortgasDAce.setTiming("Activate: Main");
        youngPortgasDAce.setEffect("You may trash this character: Look at the top card of your life, if the card is a 5 cost (Portgas D. Ace) card you may play it. If you play it, up to 1 of your leader gets +2000 Power until the end of your opponent's turn.");
        youngPortgasDAce.setImagePath("/images/cards/ST13/ST13-010.png");
        youngPortgasDAce.setCounter(1000);
        cardRepository.save(youngPortgasDAce);
        
        Card portgasDAce5Cost = new Card();
        portgasDAce5Cost.setCardNumber("ST13-011");
        portgasDAce5Cost.setName("Portgas D. Ace");
        portgasDAce5Cost.setCardType("CHARACTER");
        portgasDAce5Cost.setColor("YELLOW");
        portgasDAce5Cost.setPower(7000);
        portgasDAce5Cost.setCost(5);
        portgasDAce5Cost.setAffiliations("Whitebeard Pirates");
        portgasDAce5Cost.setAttribute(null);
        portgasDAce5Cost.setTiming("On Play");
        portgasDAce5Cost.setEffect("If you have 2 or less life, this character gains Rush (This card can attack on the turn in which it is played.)");
        portgasDAce5Cost.setImagePath("/images/cards/ST13/ST13-011.png");
        portgasDAce5Cost.setCounter(null);
        cardRepository.save(portgasDAce5Cost);
        
        Card monkeyDLuffy5Cost = new Card();
        monkeyDLuffy5Cost.setCardNumber("ST13-015");
        monkeyDLuffy5Cost.setName("Monkey D. Luffy");
        monkeyDLuffy5Cost.setCardType("CHARACTER");
        monkeyDLuffy5Cost.setColor("GREEN");
        monkeyDLuffy5Cost.setPower(6000);
        monkeyDLuffy5Cost.setCost(5);
        monkeyDLuffy5Cost.setAffiliations("Supernova / Straw Hat Crew");
        monkeyDLuffy5Cost.setAttribute(null);
        monkeyDLuffy5Cost.setTiming("Activate: Main");
        monkeyDLuffy5Cost.setEffect("Once Per Turn This character gains +2000 until the start of your next turn. Then, if you have 1 or more life, draw 1 card and trash the top card of your life.");
        monkeyDLuffy5Cost.setImagePath("/images/cards/ST13/ST13-015.png");
        monkeyDLuffy5Cost.setCounter(1000);
        cardRepository.save(monkeyDLuffy5Cost);
        
        Card monkeyDGarp = new Card();
        monkeyDGarp.setCardNumber("ST13-013");
        monkeyDGarp.setName("Monkey D. Garp");
        monkeyDGarp.setCardType("CHARACTER");
        monkeyDGarp.setColor("YELLOW");
        monkeyDGarp.setPower(2000);
        monkeyDGarp.setCost(1);
        monkeyDGarp.setAffiliations("Navy");
        monkeyDGarp.setAttribute(null);
        monkeyDGarp.setTiming("On Play");
        monkeyDGarp.setEffect("Look at the top 5 cards of your deck, reveal up to 1 [Sabo], [Portgas D. Ace] or [Monkey D. Luffy] card with a cost of 5 or less, then put it into your hand. Then, place the rest on the bottom of your deck in any order.");
        monkeyDGarp.setImagePath("/images/cards/ST13/ST13-013.png");
        monkeyDGarp.setCounter(1000);
        cardRepository.save(monkeyDGarp);
        
        Card shanks = new Card();
        shanks.setCardNumber("ST13-009");
        shanks.setName("Shanks");
        shanks.setCardType("CHARACTER");
        shanks.setColor("GREEN");
        shanks.setPower(7000);
        shanks.setCost(7);
        shanks.setAffiliations("Four Emperors / Red Hair Pirates");
        shanks.setAttribute(null);
        shanks.setTiming("On Play");
        shanks.setEffect("Flip one of your face up life cards face down. If your opponent has 7 or more cards in their hand, send up to 1 card from the top of their life to the trash.");
        shanks.setImagePath("/images/cards/ST13/ST13-009.png");
        shanks.setCounter(null);
        cardRepository.save(shanks);
        
        Card yamato = new Card();
        yamato.setCardNumber("ST13-016");
        yamato.setName("Yamato");
        yamato.setCardType("CHARACTER");
        yamato.setColor("PURPLE");
        yamato.setPower(4000);
        yamato.setCost(5);
        yamato.setAffiliations("Wano Country");
        yamato.setAttribute(null);
        yamato.setTiming("On Play");
        yamato.setEffect("Look at all your life cards, place 1 of the cards on the top of your deck. Then, return your life cards in your desired order.");
        yamato.setImagePath("/images/cards/ST13/ST13-016.png");
        yamato.setCounter(2000);
        cardRepository.save(yamato);
        
        // Event Cards
        Card gumGumJetSpear = new Card();
        gumGumJetSpear.setCardNumber("ST13-018");
        gumGumJetSpear.setName("Gum-Gum Jet Spear");
        gumGumJetSpear.setCardType("EVENT");
        gumGumJetSpear.setColor("RED");
        gumGumJetSpear.setCost(1);
        gumGumJetSpear.setAffiliations("Punk Hazard / Straw Hat Crew");
        gumGumJetSpear.setAttribute(null);
        gumGumJetSpear.setTiming("Counter");
        gumGumJetSpear.setEffect("Give up to 1 of your leader or characters +2000 Power for this battle. Then, if your life is 0, draw 1 card.");
        gumGumJetSpear.setTrigger("You may add the top or bottom card of your life to your hand: Place one card from your hand to the top of your life.");
        gumGumJetSpear.setImagePath("/images/cards/ST13/ST13-018.png");
        gumGumJetSpear.setCounter(null);
        cardRepository.save(gumGumJetSpear);
        
        Card threeBrothersBond = new Card();
        threeBrothersBond.setCardNumber("ST13-019");
        threeBrothersBond.setName("Three Brothers' Bond");
        threeBrothersBond.setCardType("EVENT");
        threeBrothersBond.setColor("GREEN");
        threeBrothersBond.setCost(1);
        threeBrothersBond.setAffiliations("Goa Kingdom");
        threeBrothersBond.setAttribute(null);
        threeBrothersBond.setTiming("Main");
        threeBrothersBond.setEffect("Look at the top 5 cards of your deck and reveal up to one cost 5 or less [Sabo] or [Portgaz D. Ace] or [Monkey D. Luffy] then put it into your hand. Then, place the rest on the bottom of your deck in any order.");
        threeBrothersBond.setTrigger("Activate this card's Main ability");
        threeBrothersBond.setImagePath("/images/cards/ST13/ST13-019.png");
        threeBrothersBond.setCounter(null);
        cardRepository.save(threeBrothersBond);
        
        Card flamingDragonKing = new Card();
        flamingDragonKing.setCardNumber("ST13-017");
        flamingDragonKing.setName("Flaming Dragon King");
        flamingDragonKing.setCardType("EVENT");
        flamingDragonKing.setColor("RED");
        flamingDragonKing.setCost(2);
        flamingDragonKing.setAffiliations("Revolutionary Army / Dressrosa");
        flamingDragonKing.setAttribute(null);
        flamingDragonKing.setTiming("Counter");
        flamingDragonKing.setEffect("Give up to 1 of your leader or characters +4000 Power for this battle. Then, look at all your life cards, and return them in your desired order.");
        flamingDragonKing.setTrigger("You may add the top or bottom card of your life to your hand: Place one card from your hand to the top of your life.");
        flamingDragonKing.setImagePath("/images/cards/ST13/ST13-017.png");
        flamingDragonKing.setCounter(null);
        cardRepository.save(flamingDragonKing);

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 