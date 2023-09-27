package com.nero.hua.card.type.validate.impl;

import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AirplaneValidateTest {

    @Test
    public void testCase01() {
        PlayCardTypeValidate playCardTypeValidate = new AirplaneValidate();

        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        cardEnumerationList.add(CardEnumeration.CARD_114);
        cardEnumerationList.add(CardEnumeration.CARD_214);
        cardEnumerationList.add(CardEnumeration.CARD_314);
        cardEnumerationList.add(CardEnumeration.CARD_113);
        cardEnumerationList.add(CardEnumeration.CARD_213);
        cardEnumerationList.add(CardEnumeration.CARD_313);
        assertTrue(playCardTypeValidate.match(cardEnumerationList));
    }

    @Test
    public void testCase02() {
        PlayCardTypeValidate playCardTypeValidate = new AirplaneValidate();

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
        assertFalse(playCardTypeValidate.match(cardEnumerationList));
    }

    @Test
    public void testCase03() {
        PlayCardTypeValidate playCardTypeValidate = new AirplaneValidate();

        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        cardEnumerationList.add(CardEnumeration.CARD_114);
        cardEnumerationList.add(CardEnumeration.CARD_314);
        cardEnumerationList.add(CardEnumeration.CARD_113);
        cardEnumerationList.add(CardEnumeration.CARD_213);
        cardEnumerationList.add(CardEnumeration.CARD_313);
        assertFalse(playCardTypeValidate.match(cardEnumerationList));
    }
}
