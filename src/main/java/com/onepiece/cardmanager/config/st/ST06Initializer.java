package com.onepiece.cardmanager.config.st;

import com.onepiece.cardmanager.config.BaseInitializer;
import com.onepiece.cardmanager.model.Card;
import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(16) // Order after ST05
public class ST06Initializer extends BaseInitializer {

    private final CardRepository cardRepository;

    @Autowired
    public ST06Initializer(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    protected void initialize(String... args) throws Exception {
        String setCode = "ST06";
        // Check if cards for this set already exist
        if (cardRepository.countBySetAndCardNumberStartingWith(setCode, setCode) > 0) {
            System.out.println(setCode + " cards already exist, skipping initialization.");
            return;
        }

        System.out.println("Initializing " + setCode + " cards...");

        // --- Add Card definitions here ---
        
        // ST06-001: Sakazuki (Leader)
        Card sakazukiLeader = new Card();
        sakazukiLeader.setCardNumber("ST06-001");
        sakazukiLeader.setName("Sakazuki");
        sakazukiLeader.setCardType("Leader");
        sakazukiLeader.setColor("Purple");
        sakazukiLeader.setPower(5000);
        sakazukiLeader.setLife(5);
        sakazukiLeader.setAttribute("Strike");
        sakazukiLeader.setAffiliations("Navy");
        sakazukiLeader.setEffect("Activate: Main Once Per Turn 3 (You may rest the specified number of DON!! cards in your Cost Area): You may trash 1 card from your hand: K.O. up to 1 of your opponent's Characters with a cost of 0.");
        sakazukiLeader.setImagePath("/images/cards/ST06/ST06-001.png");
        cardRepository.save(sakazukiLeader);

        // ST06-002: Koby
        Card koby = new Card();
        koby.setCardNumber("ST06-002");
        koby.setName("Koby");
        koby.setCardType("Character");
        koby.setColor("Purple");
        koby.setCost(1);
        koby.setPower(2000);
        koby.setCounter(1000);
        koby.setAttribute("Strike");
        koby.setAffiliations("Navy");
        koby.setEffect("On Play You may trash 1 card from your hand: K.O. up to 1 of your opponent's Characters with a cost of 0.");
        koby.setImagePath("/images/cards/ST06/ST06-002.png");
        cardRepository.save(koby);

        // ST06-003: Django
        Card django = new Card();
        django.setCardNumber("ST06-003");
        django.setName("Django");
        django.setCardType("Character");
        django.setColor("Purple");
        django.setCost(1);
        django.setPower(3000);
        django.setCounter(1000);
        django.setAttribute("Special");
        django.setAffiliations("Navy");
        django.setImagePath("/images/cards/ST06/ST06-003.png");
        cardRepository.save(django);

        // ST06-004: Smoker
        Card smoker = new Card();
        smoker.setCardNumber("ST06-004");
        smoker.setName("Smoker");
        smoker.setCardType("Character");
        smoker.setColor("Purple");
        smoker.setCost(5);
        smoker.setPower(7000);
        smoker.setCounter(1000);
        smoker.setAttribute("Special");
        smoker.setAffiliations("Navy");
        smoker.setEffect("This Character can not be K.O'd by card effects.\\nDON!! ×1 As long as there is a Character that costs 0 in play, this Character gains Double Attack. (This card deals 2 damage.)");
        smoker.setImagePath("/images/cards/ST06/ST06-004.png");
        cardRepository.save(smoker);

        // ST06-005: Sengoku
        Card sengoku = new Card();
        sengoku.setCardNumber("ST06-005");
        sengoku.setName("Sengoku");
        sengoku.setCardType("Character");
        sengoku.setColor("Purple");
        sengoku.setCost(5);
        sengoku.setPower(6000);
        sengoku.setCounter(1000);
        sengoku.setAttribute("Wisdom");
        sengoku.setAffiliations("Navy");
        sengoku.setEffect("When Attacking Give up to 1 of your opponent's Characters -4 to their cost during this turn.");
        sengoku.setImagePath("/images/cards/ST06/ST06-005.png");
        cardRepository.save(sengoku);

        // ST06-006: Tashigi
        Card tashigi = new Card();
        tashigi.setCardNumber("ST06-006");
        tashigi.setName("Tashigi");
        tashigi.setCardType("Character");
        tashigi.setColor("Purple");
        tashigi.setCost(3);
        tashigi.setPower(4000);
        tashigi.setCounter(2000);
        tashigi.setAttribute("Slash");
        tashigi.setAffiliations("Navy");
        tashigi.setEffect("Activate: Main You may rest this Character: Give up to 1 of your opponent's Characters -2 to their cost during this turn.");
        tashigi.setImagePath("/images/cards/ST06/ST06-006.png");
        cardRepository.save(tashigi);

        // ST06-007: Tsuru
        Card tsuru = new Card();
        tsuru.setCardNumber("ST06-007");
        tsuru.setName("Tsuru");
        tsuru.setCardType("Character");
        tsuru.setColor("Purple");
        tsuru.setCost(2);
        tsuru.setPower(2000);
        tsuru.setCounter(1000);
        tsuru.setAttribute("Wisdom");
        tsuru.setAffiliations("Navy");
        tsuru.setEffect("Blocker (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)");
        tsuru.setImagePath("/images/cards/ST06/ST06-007.png");
        cardRepository.save(tsuru);

        // ST06-008: Hina
        Card hina = new Card();
        hina.setCardNumber("ST06-008");
        hina.setName("Hina");
        hina.setCardType("Character");
        hina.setColor("Purple");
        hina.setCost(3);
        hina.setPower(5000);
        hina.setCounter(1000);
        hina.setAttribute("Special");
        hina.setAffiliations("Navy");
        hina.setEffect("On Play Give up to 1 of your opponent's Characters -4 to their cost during this turn.");
        hina.setImagePath("/images/cards/ST06/ST06-008.png");
        cardRepository.save(hina);

        // ST06-009: Fullbody
        Card fullbody = new Card();
        fullbody.setCardNumber("ST06-009");
        fullbody.setName("Fullbody");
        fullbody.setCardType("Character");
        fullbody.setColor("Purple");
        fullbody.setCost(2);
        fullbody.setPower(4000);
        fullbody.setCounter(1000);
        fullbody.setAttribute("Strike");
        fullbody.setAffiliations("Navy");
        fullbody.setImagePath("/images/cards/ST06/ST06-009.png");
        cardRepository.save(fullbody);

        // ST06-010: Helmeppo
        Card helmeppo = new Card();
        helmeppo.setCardNumber("ST06-010");
        helmeppo.setName("Helmeppo");
        helmeppo.setCardType("Character");
        helmeppo.setColor("Purple");
        helmeppo.setCost(2);
        helmeppo.setPower(3000);
        helmeppo.setCounter(1000);
        helmeppo.setAttribute("Slash");
        helmeppo.setAffiliations("Navy");
        helmeppo.setEffect("On Play Give up to 1 of your opponent's Characters -3 to their cost during this turn.");
        helmeppo.setImagePath("/images/cards/ST06/ST06-010.png");
        cardRepository.save(helmeppo);

        // ST06-011: Momonga
        Card momonga = new Card();
        momonga.setCardNumber("ST06-011");
        momonga.setName("Momonga");
        momonga.setCardType("Character");
        momonga.setColor("Purple");
        momonga.setCost(4);
        momonga.setPower(6000);
        momonga.setCounter(1000);
        momonga.setAttribute("Slash");
        momonga.setAffiliations("Navy");
        momonga.setImagePath("/images/cards/ST06/ST06-011.png");
        cardRepository.save(momonga);

        // ST06-012: Monkey D. Garp
        Card monkeyDGarp = new Card();
        monkeyDGarp.setCardNumber("ST06-012");
        monkeyDGarp.setName("Monkey D. Garp");
        monkeyDGarp.setCardType("Character");
        monkeyDGarp.setColor("Purple");
        monkeyDGarp.setCost(5);
        monkeyDGarp.setPower(6000);
        monkeyDGarp.setCounter(1000);
        monkeyDGarp.setAttribute("Strike");
        monkeyDGarp.setAffiliations("Navy");
        monkeyDGarp.setEffect("Activate: Main You may Trash 1 card from your hand and rest this Character: K.O. up to 1 of your opponent's Characters with a cost of 4 or less.");
        monkeyDGarp.setImagePath("/images/cards/ST06/ST06-012.png");
        cardRepository.save(monkeyDGarp);

        // ST06-013: T-Bone
        Card tBone = new Card();
        tBone.setCardNumber("ST06-013");
        tBone.setName("T-Bone");
        tBone.setCardType("Character");
        tBone.setColor("Purple");
        tBone.setCost(3);
        tBone.setPower(5000);
        tBone.setCounter(1000);
        tBone.setAttribute("Slash");
        tBone.setAffiliations("Navy");
        tBone.setImagePath("/images/cards/ST06/ST06-013.png");
        cardRepository.save(tBone);

        // ST06-014: Shockwave
        Card shockwave = new Card();
        shockwave.setCardNumber("ST06-014");
        shockwave.setName("Shockwave");
        shockwave.setCardType("Event");
        shockwave.setColor("Purple");
        shockwave.setCost(2);
        shockwave.setAffiliations("Navy");
        shockwave.setEffect("Counter Up to 1 of your Leader or Character cards gains +4000 power during this battle. Then, K.O. up to 1 of your opponent's active Characters with a cost of 3 or less.");
        shockwave.setTrigger("K.O. up to 1 of your opponent's Characters with a cost of 4 or less.");
        shockwave.setImagePath("/images/cards/ST06/ST06-014.png");
        cardRepository.save(shockwave);

        // ST06-015: Great Eruption
        Card greatEruption = new Card();
        greatEruption.setCardNumber("ST06-015");
        greatEruption.setName("Great Eruption");
        greatEruption.setCardType("Event");
        greatEruption.setColor("Purple");
        greatEruption.setCost(1);
        greatEruption.setAffiliations("Navy");
        greatEruption.setEffect("Main Draw 1 card. Then, give up to 1 of your opponent's Characters -2 to their cost during this turn.");
        greatEruption.setTrigger("Your opponent trashes 1 card from their hand.");
        greatEruption.setImagePath("/images/cards/ST06/ST06-015.png");
        cardRepository.save(greatEruption);

        // ST06-016: White Out
        Card whiteOut = new Card();
        whiteOut.setCardNumber("ST06-016");
        whiteOut.setName("White Out");
        whiteOut.setCardType("Event");
        whiteOut.setColor("Purple");
        whiteOut.setCost(1);
        whiteOut.setAffiliations("Navy");
        whiteOut.setEffect("Counter Your leader or up to 1 of your Charaters gains +2000 power during this battle.");
        whiteOut.setTrigger("Draw 1 card. Your Characters cannot be K.O.'d during this turn.");
        whiteOut.setImagePath("/images/cards/ST06/ST06-016.png");
        cardRepository.save(whiteOut);

        // ST06-017: Marineford
        Card marineford = new Card();
        marineford.setCardNumber("ST06-017");
        marineford.setName("Marineford");
        marineford.setCardType("Stage");
        marineford.setColor("Purple");
        marineford.setCost(1);
        marineford.setAffiliations("Navy");
        marineford.setEffect("On Play Give up to 1 of your opponent's Characters -1 to their cost during this turn.\\nActivate: Main You may rest this Stage: If your Leader has the {Navy} type, give up to 1 of your opponent's Characters -1 to their cost during this turn.");
        marineford.setImagePath("/images/cards/ST06/ST06-017.png");
        cardRepository.save(marineford);

        System.out.println("Finished initializing " + setCode + " cards.");
    }
} 