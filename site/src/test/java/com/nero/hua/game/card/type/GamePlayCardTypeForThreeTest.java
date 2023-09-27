package com.nero.hua.game.card.type;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GamePlayCardTypeForThreeTest {

    @Test
    public void testGeneralCalculatePlayCardTypeCase01() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_109);

        PlayCardTypeEnumeration playCardTypeEnumeration = new GamePlayCardTypeForThree().generalCalculatePlayCardType(cardList);
        assertEquals(PlayCardTypeEnumeration.SINGLE, playCardTypeEnumeration);
    }

    @Test
    public void testGeneralCalculatePlayCardTypeCase02() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_109);
        cardList.add(CardEnumeration.CARD_209);

        PlayCardTypeEnumeration playCardTypeEnumeration = new GamePlayCardTypeForThree().generalCalculatePlayCardType(cardList);
        assertEquals(PlayCardTypeEnumeration.PAIR, playCardTypeEnumeration);
    }

    @Test
    public void testGeneralCalculatePlayCardTypeCase03() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_114);
        cardList.add(CardEnumeration.CARD_113);
        cardList.add(CardEnumeration.CARD_112);
        cardList.add(CardEnumeration.CARD_111);
        cardList.add(CardEnumeration.CARD_110);
        cardList.add(CardEnumeration.CARD_109);

        PlayCardTypeEnumeration playCardTypeEnumeration = new GamePlayCardTypeForThree().generalCalculatePlayCardType(cardList);
        assertEquals(PlayCardTypeEnumeration.STRAIGHT, playCardTypeEnumeration);

        cardList.add(0, CardEnumeration.CARD_115);
        playCardTypeEnumeration = new GamePlayCardTypeForThree().generalCalculatePlayCardType(cardList);
        assertNull(playCardTypeEnumeration);
    }

    @Test
    public void testGeneralCalculatePlayCardTypeCase04() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_114);
        cardList.add(CardEnumeration.CARD_214);
        cardList.add(CardEnumeration.CARD_113);
        cardList.add(CardEnumeration.CARD_213);
        cardList.add(CardEnumeration.CARD_112);
        cardList.add(CardEnumeration.CARD_212);

        PlayCardTypeEnumeration playCardTypeEnumeration = new GamePlayCardTypeForThree().generalCalculatePlayCardType(cardList);
        assertEquals(PlayCardTypeEnumeration.PAIR_STRAIGHT, playCardTypeEnumeration);

        cardList.add(0, CardEnumeration.CARD_115);
        cardList.add(0, CardEnumeration.CARD_215);
        playCardTypeEnumeration = new GamePlayCardTypeForThree().generalCalculatePlayCardType(cardList);
        assertNull(playCardTypeEnumeration);
    }

    @Test
    public void testGeneralCalculatePlayCardTypeCase05() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_114);
        cardList.add(CardEnumeration.CARD_214);
        cardList.add(CardEnumeration.CARD_314);
        cardList.add(CardEnumeration.CARD_113);
        cardList.add(CardEnumeration.CARD_213);
        cardList.add(CardEnumeration.CARD_313);
        cardList.add(CardEnumeration.CARD_112);
        cardList.add(CardEnumeration.CARD_212);
        cardList.add(CardEnumeration.CARD_312);

        PlayCardTypeEnumeration playCardTypeEnumeration = new GamePlayCardTypeForThree().generalCalculatePlayCardType(cardList);
        assertEquals(PlayCardTypeEnumeration.AIRPLANE, playCardTypeEnumeration);

        cardList.add(0, CardEnumeration.CARD_115);
        cardList.add(0, CardEnumeration.CARD_215);
        cardList.add(0, CardEnumeration.CARD_215);
        playCardTypeEnumeration = new GamePlayCardTypeForThree().generalCalculatePlayCardType(cardList);
        assertNull(playCardTypeEnumeration);
    }

    @Test
    public void testGeneralCalculatePlayCardTypeCase06() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_114);
        cardList.add(CardEnumeration.CARD_214);
        cardList.add(CardEnumeration.CARD_314);
        cardList.add(CardEnumeration.CARD_113);
        cardList.add(CardEnumeration.CARD_213);
        cardList.add(CardEnumeration.CARD_313);
        cardList.add(CardEnumeration.CARD_104);
        cardList.add(CardEnumeration.CARD_103);

        PlayCardTypeEnumeration playCardTypeEnumeration = new GamePlayCardTypeForThree().generalCalculatePlayCardType(cardList);
        assertEquals(PlayCardTypeEnumeration.AIRPLANE_SINGLE, playCardTypeEnumeration);

        cardList.add(0, CardEnumeration.CARD_115);
        cardList.add(0, CardEnumeration.CARD_215);
        cardList.add(0, CardEnumeration.CARD_215);
        cardList.add(cardList.size() - 1 - 2, CardEnumeration.CARD_105);
        playCardTypeEnumeration = new GamePlayCardTypeForThree().generalCalculatePlayCardType(cardList);
        assertNull(playCardTypeEnumeration);
    }

    @Test
    public void testGeneralCalculatePlayCardTypeCase07() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_114);
        cardList.add(CardEnumeration.CARD_214);
        cardList.add(CardEnumeration.CARD_314);
        cardList.add(CardEnumeration.CARD_113);
        cardList.add(CardEnumeration.CARD_213);
        cardList.add(CardEnumeration.CARD_313);
        cardList.add(CardEnumeration.CARD_104);
        cardList.add(CardEnumeration.CARD_204);
        cardList.add(CardEnumeration.CARD_103);
        cardList.add(CardEnumeration.CARD_203);

        PlayCardTypeEnumeration playCardTypeEnumeration = new GamePlayCardTypeForThree().generalCalculatePlayCardType(cardList);
        assertEquals(PlayCardTypeEnumeration.AIRPLANE_PAIR, playCardTypeEnumeration);

        cardList.add(0, CardEnumeration.CARD_115);
        cardList.add(0, CardEnumeration.CARD_215);
        cardList.add(0, CardEnumeration.CARD_215);
        cardList.add(cardList.size() - 1 - 4, CardEnumeration.CARD_105);
        cardList.add(cardList.size() - 1 - 4, CardEnumeration.CARD_205);
        playCardTypeEnumeration = new GamePlayCardTypeForThree().generalCalculatePlayCardType(cardList);
        assertNull(playCardTypeEnumeration);
    }

    @Test
    public void testGeneralCalculatePlayCardTypeCase08() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_113);
        cardList.add(CardEnumeration.CARD_213);
        cardList.add(CardEnumeration.CARD_313);

        PlayCardTypeEnumeration playCardTypeEnumeration = new GamePlayCardTypeForThree().generalCalculatePlayCardType(cardList);
        assertEquals(PlayCardTypeEnumeration.TRIPLE, playCardTypeEnumeration);
    }

    @Test
    public void testGeneralCalculatePlayCardTypeCase09() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_113);
        cardList.add(CardEnumeration.CARD_213);
        cardList.add(CardEnumeration.CARD_313);
        cardList.add(CardEnumeration.CARD_103);

        PlayCardTypeEnumeration playCardTypeEnumeration = new GamePlayCardTypeForThree().generalCalculatePlayCardType(cardList);
        assertEquals(PlayCardTypeEnumeration.TRIPLE_SINGLE, playCardTypeEnumeration);
    }

    @Test
    public void testGeneralCalculatePlayCardTypeCase10() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_113);
        cardList.add(CardEnumeration.CARD_213);
        cardList.add(CardEnumeration.CARD_313);
        cardList.add(CardEnumeration.CARD_103);
        cardList.add(CardEnumeration.CARD_203);

        PlayCardTypeEnumeration playCardTypeEnumeration = new GamePlayCardTypeForThree().generalCalculatePlayCardType(cardList);
        assertEquals(PlayCardTypeEnumeration.TRIPLE_PAIR, playCardTypeEnumeration);
    }

    @Test
    public void testGeneralCalculatePlayCardTypeCase11() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_113);
        cardList.add(CardEnumeration.CARD_213);
        cardList.add(CardEnumeration.CARD_313);
        cardList.add(CardEnumeration.CARD_413);

        PlayCardTypeEnumeration playCardTypeEnumeration = new GamePlayCardTypeForThree().generalCalculatePlayCardType(cardList);
        assertEquals(PlayCardTypeEnumeration.BOMB, playCardTypeEnumeration);
    }

    @Test
    public void testGeneralCalculatePlayCardTypeCase12() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_113);
        cardList.add(CardEnumeration.CARD_213);
        cardList.add(CardEnumeration.CARD_313);
        cardList.add(CardEnumeration.CARD_413);
        cardList.add(CardEnumeration.CARD_103);
        cardList.add(CardEnumeration.CARD_203);

        PlayCardTypeEnumeration playCardTypeEnumeration = new GamePlayCardTypeForThree().generalCalculatePlayCardType(cardList);
        assertEquals(PlayCardTypeEnumeration.FOUR_SINGLE, playCardTypeEnumeration);
    }

    @Test
    public void testGeneralCalculatePlayCardTypeCase13() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_113);
        cardList.add(CardEnumeration.CARD_213);
        cardList.add(CardEnumeration.CARD_313);
        cardList.add(CardEnumeration.CARD_413);
        cardList.add(CardEnumeration.CARD_114);
        cardList.add(CardEnumeration.CARD_214);
        cardList.add(CardEnumeration.CARD_314);
        cardList.add(CardEnumeration.CARD_414);

        PlayCardTypeEnumeration playCardTypeEnumeration = new GamePlayCardTypeForThree().generalCalculatePlayCardType(cardList);
        assertEquals(PlayCardTypeEnumeration.FOUR_PAIR, playCardTypeEnumeration);
    }

}
