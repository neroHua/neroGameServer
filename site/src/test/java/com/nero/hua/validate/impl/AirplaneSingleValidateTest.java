package com.nero.hua.validate.impl;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.validate.PlayCardTypeValidate;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class AirplaneSingleValidateTest {

    @Test
    public void testCase01() {
        PlayCardTypeValidate playCardTypeValidate = new AirplaneSingleValidate();

        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        cardEnumerationList.add(CardEnumeration.CARD_110);
        cardEnumerationList.add(CardEnumeration.CARD_210);
        cardEnumerationList.add(CardEnumeration.CARD_310);
        cardEnumerationList.add(CardEnumeration.CARD_111);
        cardEnumerationList.add(CardEnumeration.CARD_211);
        cardEnumerationList.add(CardEnumeration.CARD_311);
        cardEnumerationList.add(CardEnumeration.CARD_112);
        cardEnumerationList.add(CardEnumeration.CARD_212);
        cardEnumerationList.add(CardEnumeration.CARD_312);
        cardEnumerationList.add(CardEnumeration.CARD_113);
        cardEnumerationList.add(CardEnumeration.CARD_213);
        cardEnumerationList.add(CardEnumeration.CARD_313);
        cardEnumerationList.add(CardEnumeration.CARD_114);
        cardEnumerationList.add(CardEnumeration.CARD_214);
        cardEnumerationList.add(CardEnumeration.CARD_314);

        cardEnumerationList.add(CardEnumeration.CARD_403);
        cardEnumerationList.add(CardEnumeration.CARD_404);
        cardEnumerationList.add(CardEnumeration.CARD_405);
        cardEnumerationList.add(CardEnumeration.CARD_406);
        cardEnumerationList.add(CardEnumeration.CARD_407);
        Assert.assertTrue(playCardTypeValidate.match(cardEnumerationList));


        cardEnumerationList.remove(cardEnumerationList.size() - 1);
        cardEnumerationList.remove(cardEnumerationList.size() - 1);
        cardEnumerationList.remove(cardEnumerationList.size() - 1);
        cardEnumerationList.remove(cardEnumerationList.size() - 1);
        cardEnumerationList.remove(cardEnumerationList.size() - 1);

        cardEnumerationList.add(CardEnumeration.CARD_115);
        cardEnumerationList.add(CardEnumeration.CARD_215);
        cardEnumerationList.add(CardEnumeration.CARD_315);

        cardEnumerationList.add(CardEnumeration.CARD_403);
        cardEnumerationList.add(CardEnumeration.CARD_404);
        cardEnumerationList.add(CardEnumeration.CARD_405);
        cardEnumerationList.add(CardEnumeration.CARD_406);
        cardEnumerationList.add(CardEnumeration.CARD_407);

        cardEnumerationList.add(CardEnumeration.CARD_408);
        Assert.assertFalse(playCardTypeValidate.match(cardEnumerationList));

        cardEnumerationList.remove(cardEnumerationList.size() - 1);
        cardEnumerationList.remove(cardEnumerationList.size() - 1);
        cardEnumerationList.remove(cardEnumerationList.size() - 1);
        cardEnumerationList.remove(cardEnumerationList.size() - 1);
        cardEnumerationList.remove(cardEnumerationList.size() - 1);
        cardEnumerationList.remove(cardEnumerationList.size() - 1);

        cardEnumerationList.remove(cardEnumerationList.size() - 1);
        cardEnumerationList.remove(cardEnumerationList.size() - 1);
        cardEnumerationList.remove(cardEnumerationList.size() - 1);

        cardEnumerationList.add(CardEnumeration.CARD_403);
        cardEnumerationList.add(CardEnumeration.CARD_404);
        cardEnumerationList.add(CardEnumeration.CARD_405);
        cardEnumerationList.add(CardEnumeration.CARD_406);
        cardEnumerationList.add(CardEnumeration.CARD_407);

        cardEnumerationList.remove(4);
        Assert.assertFalse(playCardTypeValidate.match(cardEnumerationList));
    }
}
