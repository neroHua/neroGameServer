package com.nero.hua.card.type.validate.impl;

import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class StraightValidateTest {

    @Test
    public void testCase01() {
        PlayCardTypeValidate playCardTypeValidate = new StraightValidate();

        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        cardEnumerationList.add(CardEnumeration.CARD_106);
        cardEnumerationList.add(CardEnumeration.CARD_105);
        cardEnumerationList.add(CardEnumeration.CARD_104);
        cardEnumerationList.add(CardEnumeration.CARD_103);
        Assert.assertFalse(playCardTypeValidate.match(cardEnumerationList));
    }

    @Test
    public void testCase02() {
        PlayCardTypeValidate playCardTypeValidate = new StraightValidate();

        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        cardEnumerationList.add(CardEnumeration.CARD_114);
        cardEnumerationList.add(CardEnumeration.CARD_113);
        cardEnumerationList.add(CardEnumeration.CARD_112);
        cardEnumerationList.add(CardEnumeration.CARD_111);
        cardEnumerationList.add(CardEnumeration.CARD_110);
        cardEnumerationList.add(CardEnumeration.CARD_109);
        cardEnumerationList.add(CardEnumeration.CARD_108);
        cardEnumerationList.add(CardEnumeration.CARD_107);
        cardEnumerationList.add(CardEnumeration.CARD_106);
        cardEnumerationList.add(CardEnumeration.CARD_105);
        cardEnumerationList.add(CardEnumeration.CARD_104);
        cardEnumerationList.add(CardEnumeration.CARD_103);
        Assert.assertTrue(playCardTypeValidate.match(cardEnumerationList));

        cardEnumerationList.add(CardEnumeration.CARD_115);
        Assert.assertFalse(playCardTypeValidate.match(cardEnumerationList));

        cardEnumerationList.remove(cardEnumerationList.size() - 1);
        Assert.assertTrue(playCardTypeValidate.match(cardEnumerationList));

        cardEnumerationList.remove(10);
        Assert.assertFalse(playCardTypeValidate.match(cardEnumerationList));
    }

    @Test
    public void testCase03() {
        PlayCardTypeValidate playCardTypeValidate = new StraightValidate();

        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        cardEnumerationList.add(CardEnumeration.CARD_115);
        cardEnumerationList.add(CardEnumeration.CARD_114);
        cardEnumerationList.add(CardEnumeration.CARD_113);
        cardEnumerationList.add(CardEnumeration.CARD_112);
        cardEnumerationList.add(CardEnumeration.CARD_111);
        cardEnumerationList.add(CardEnumeration.CARD_110);
        cardEnumerationList.add(CardEnumeration.CARD_109);
        cardEnumerationList.add(CardEnumeration.CARD_108);
        cardEnumerationList.add(CardEnumeration.CARD_107);
        cardEnumerationList.add(CardEnumeration.CARD_106);
        cardEnumerationList.add(CardEnumeration.CARD_105);
        cardEnumerationList.add(CardEnumeration.CARD_104);
        cardEnumerationList.add(CardEnumeration.CARD_103);
        Assert.assertFalse(playCardTypeValidate.match(cardEnumerationList));
    }

    @Test
    public void testCase04() {
        PlayCardTypeValidate playCardTypeValidate = new StraightValidate();

        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        cardEnumerationList.add(CardEnumeration.CARD_115);
        cardEnumerationList.add(CardEnumeration.CARD_114);
        cardEnumerationList.add(CardEnumeration.CARD_113);
        cardEnumerationList.add(CardEnumeration.CARD_112);
        cardEnumerationList.add(CardEnumeration.CARD_111);
        cardEnumerationList.add(CardEnumeration.CARD_110);
        cardEnumerationList.add(CardEnumeration.CARD_109);
        cardEnumerationList.add(CardEnumeration.CARD_108);
        cardEnumerationList.add(CardEnumeration.CARD_106);
        cardEnumerationList.add(CardEnumeration.CARD_105);
        cardEnumerationList.add(CardEnumeration.CARD_104);
        cardEnumerationList.add(CardEnumeration.CARD_103);
        Assert.assertFalse(playCardTypeValidate.match(cardEnumerationList));
    }
}
