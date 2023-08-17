package com.nero.hua.card.type.validate.impl;

import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class AirplaneSingleValidateTest {

    @Test
    public void testCase01() {
        PlayCardTypeValidate playCardTypeValidate = new AirplaneSingleValidate();

        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        cardEnumerationList.add(CardEnumeration.CARD_114);
        cardEnumerationList.add(CardEnumeration.CARD_214);
        cardEnumerationList.add(CardEnumeration.CARD_314);
        cardEnumerationList.add(CardEnumeration.CARD_113);
        cardEnumerationList.add(CardEnumeration.CARD_213);
        cardEnumerationList.add(CardEnumeration.CARD_313);

        cardEnumerationList.add(CardEnumeration.CARD_407);
        cardEnumerationList.add(CardEnumeration.CARD_406);
        Assert.assertTrue(playCardTypeValidate.match(cardEnumerationList));
    }

    @Test
    public void testCase02() {
        PlayCardTypeValidate playCardTypeValidate = new AirplaneSingleValidate();

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

        cardEnumerationList.add(CardEnumeration.CARD_407);
        cardEnumerationList.add(CardEnumeration.CARD_406);
        cardEnumerationList.add(CardEnumeration.CARD_405);
        Assert.assertFalse(playCardTypeValidate.match(cardEnumerationList));
    }

    @Test
    public void testCase03() {
        PlayCardTypeValidate playCardTypeValidate = new AirplaneSingleValidate();

        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        cardEnumerationList.add(CardEnumeration.CARD_114);
        cardEnumerationList.add(CardEnumeration.CARD_314);
        cardEnumerationList.add(CardEnumeration.CARD_113);
        cardEnumerationList.add(CardEnumeration.CARD_213);
        cardEnumerationList.add(CardEnumeration.CARD_313);

        cardEnumerationList.add(CardEnumeration.CARD_407);
        cardEnumerationList.add(CardEnumeration.CARD_406);
        Assert.assertFalse(playCardTypeValidate.match(cardEnumerationList));
    }

}
