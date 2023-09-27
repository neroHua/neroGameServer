package com.nero.hua.card.type.validate.impl;

import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class SingleValidateTest {

    @Test
    public void testCase01() {
        PlayCardTypeValidate playCardTypeValidate = new SingleValidate();

        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        cardEnumerationList.add(CardEnumeration.CARD_106);
        cardEnumerationList.add(CardEnumeration.CARD_105);
        cardEnumerationList.add(CardEnumeration.CARD_104);
        cardEnumerationList.add(CardEnumeration.CARD_103);
        Assert.assertFalse(playCardTypeValidate.match(cardEnumerationList));
    }

    @Test
    public void testCase02() {
        PlayCardTypeValidate playCardTypeValidate = new SingleValidate();

        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        cardEnumerationList.add(CardEnumeration.CARD_106);
        Assert.assertTrue(playCardTypeValidate.match(cardEnumerationList));
    }

}
