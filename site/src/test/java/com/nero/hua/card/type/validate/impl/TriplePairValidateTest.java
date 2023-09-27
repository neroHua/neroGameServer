package com.nero.hua.card.type.validate.impl;

import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class TriplePairValidateTest {

    @Test
    public void testCase01() {
        PlayCardTypeValidate playCardTypeValidate = new TriplePairValidate();

        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        cardEnumerationList.add(CardEnumeration.CARD_106);
        cardEnumerationList.add(CardEnumeration.CARD_206);
        cardEnumerationList.add(CardEnumeration.CARD_306);
        cardEnumerationList.add(CardEnumeration.CARD_406);
        cardEnumerationList.add(CardEnumeration.CARD_103);
        cardEnumerationList.add(CardEnumeration.CARD_203);
        Assert.assertFalse(playCardTypeValidate.match(cardEnumerationList));
    }

    @Test
    public void testCase02() {
        PlayCardTypeValidate playCardTypeValidate = new TriplePairValidate();

        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        cardEnumerationList.add(CardEnumeration.CARD_106);
        cardEnumerationList.add(CardEnumeration.CARD_206);
        cardEnumerationList.add(CardEnumeration.CARD_306);
        cardEnumerationList.add(CardEnumeration.CARD_103);
        cardEnumerationList.add(CardEnumeration.CARD_203);
        Assert.assertTrue(playCardTypeValidate.match(cardEnumerationList));
    }

    @Test
    public void testCase03() {
        PlayCardTypeValidate playCardTypeValidate = new TriplePairValidate();

        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        cardEnumerationList.add(CardEnumeration.CARD_106);
        cardEnumerationList.add(CardEnumeration.CARD_206);
        cardEnumerationList.add(CardEnumeration.CARD_306);
        cardEnumerationList.add(CardEnumeration.CARD_103);
        Assert.assertFalse(playCardTypeValidate.match(cardEnumerationList));
    }
}
