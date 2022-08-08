package com.nero.hua.validate.impl;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.validate.PlayCardTypeValidate;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class AirplanePairValidateTest {

    @Test
    public void testCase01() {
        PlayCardTypeValidate playCardTypeValidate = new AirplanePairValidate();

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
        Assert.assertTrue(playCardTypeValidate.match(cardEnumerationList));
    }

    @Test
    public void testCase02() {
        PlayCardTypeValidate playCardTypeValidate = new AirplanePairValidate();

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
        Assert.assertFalse(playCardTypeValidate.match(cardEnumerationList));
    }

    @Test
    public void testCase03() {
        PlayCardTypeValidate playCardTypeValidate = new AirplanePairValidate();

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
        Assert.assertFalse(playCardTypeValidate.match(cardEnumerationList));
    }
}
