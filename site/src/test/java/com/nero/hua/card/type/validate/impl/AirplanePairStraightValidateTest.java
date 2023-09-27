package com.nero.hua.card.type.validate.impl;

import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AirplanePairStraightValidateTest {

    @Test
    public void testCase01() {
        PlayCardTypeValidate playCardTypeValidate = new AirplanePairStraightValidate();

        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        cardEnumerationList.add(CardEnumeration.CARD_114);
        cardEnumerationList.add(CardEnumeration.CARD_214);
        cardEnumerationList.add(CardEnumeration.CARD_314);
        cardEnumerationList.add(CardEnumeration.CARD_113);
        cardEnumerationList.add(CardEnumeration.CARD_213);
        cardEnumerationList.add(CardEnumeration.CARD_313);

        cardEnumerationList.add(CardEnumeration.CARD_304);
        cardEnumerationList.add(CardEnumeration.CARD_404);
        cardEnumerationList.add(CardEnumeration.CARD_303);
        cardEnumerationList.add(CardEnumeration.CARD_403);
        assertTrue(playCardTypeValidate.match(cardEnumerationList));
    }

    @Test
    public void testCase02() {
        PlayCardTypeValidate playCardTypeValidate = new AirplanePairStraightValidate();

        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        cardEnumerationList.add(CardEnumeration.CARD_114);
        cardEnumerationList.add(CardEnumeration.CARD_214);
        cardEnumerationList.add(CardEnumeration.CARD_314);
        cardEnumerationList.add(CardEnumeration.CARD_113);
        cardEnumerationList.add(CardEnumeration.CARD_313);

        cardEnumerationList.add(CardEnumeration.CARD_304);
        cardEnumerationList.add(CardEnumeration.CARD_404);
        cardEnumerationList.add(CardEnumeration.CARD_303);
        cardEnumerationList.add(CardEnumeration.CARD_403);
        assertFalse(playCardTypeValidate.match(cardEnumerationList));
    }

    @Test
    public void testCase03() {
        PlayCardTypeValidate playCardTypeValidate = new AirplanePairStraightValidate();

        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        cardEnumerationList.add(CardEnumeration.CARD_115);
        cardEnumerationList.add(CardEnumeration.CARD_215);
        cardEnumerationList.add(CardEnumeration.CARD_315);
        cardEnumerationList.add(CardEnumeration.CARD_114);
        cardEnumerationList.add(CardEnumeration.CARD_214);
        cardEnumerationList.add(CardEnumeration.CARD_314);
        cardEnumerationList.add(CardEnumeration.CARD_113);
        cardEnumerationList.add(CardEnumeration.CARD_213);
        cardEnumerationList.add(CardEnumeration.CARD_313);

        cardEnumerationList.add(CardEnumeration.CARD_305);
        cardEnumerationList.add(CardEnumeration.CARD_405);
        cardEnumerationList.add(CardEnumeration.CARD_304);
        cardEnumerationList.add(CardEnumeration.CARD_404);
        cardEnumerationList.add(CardEnumeration.CARD_303);
        cardEnumerationList.add(CardEnumeration.CARD_403);
        assertFalse(playCardTypeValidate.match(cardEnumerationList));
    }

    @Test
    public void testCase04() {
        PlayCardTypeValidate playCardTypeValidate = new AirplanePairStraightValidate();

        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        cardEnumerationList.add(CardEnumeration.CARD_113);
        cardEnumerationList.add(CardEnumeration.CARD_213);
        cardEnumerationList.add(CardEnumeration.CARD_313);
        cardEnumerationList.add(CardEnumeration.CARD_112);
        cardEnumerationList.add(CardEnumeration.CARD_212);
        cardEnumerationList.add(CardEnumeration.CARD_312);
        cardEnumerationList.add(CardEnumeration.CARD_111);
        cardEnumerationList.add(CardEnumeration.CARD_211);
        cardEnumerationList.add(CardEnumeration.CARD_311);

        cardEnumerationList.add(CardEnumeration.CARD_306);
        cardEnumerationList.add(CardEnumeration.CARD_406);
        cardEnumerationList.add(CardEnumeration.CARD_304);
        cardEnumerationList.add(CardEnumeration.CARD_404);
        cardEnumerationList.add(CardEnumeration.CARD_303);
        cardEnumerationList.add(CardEnumeration.CARD_403);
        assertFalse(playCardTypeValidate.match(cardEnumerationList));
    }
}
