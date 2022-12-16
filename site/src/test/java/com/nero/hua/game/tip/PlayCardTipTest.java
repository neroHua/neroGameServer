package com.nero.hua.game.tip;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.GameTypeEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class PlayCardTipTest {

    @Test
    public void findBigSingleInFormatHandCardListForThreeCase01() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("提示不正确", 3, tip.size());
        Assert.assertEquals("提示不正确", (int) tip.get(0).get(0), 0);
        Assert.assertEquals("提示不正确", (int) tip.get(1).get(0), 1);
        Assert.assertEquals("提示不正确", (int) tip.get(2).get(0), 2);
    }

    @Test
    public void testFindBigStraightInFormatHandCardListForThreeCase01() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tip);
    }

    @Test
    public void testFindBigStraightInFormatHandCardListForThreeCase02() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tip);
    }

    @Test
    public void testFindBigStraightInFormatHandCardListForThreeCase03() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_107);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("提示不正确", 1, tip.size());
        Integer[] array = {1, 2, 3, 4, 5};
        Assert.assertArrayEquals(tip.get(0).toArray(new Integer[5]), array);
    }

    @Test
    public void testFindBigStraightInFormatHandCardListForThreeCase04() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_107);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("提示不正确", 2, tip.size());
        Integer[] array0 = {1, 2, 3, 4, 5};
        Integer[] array1 = {2, 3, 4, 5, 6};
        Assert.assertArrayEquals(tip.get(0).toArray(new Integer[5]), array0);
        Assert.assertArrayEquals(tip.get(1).toArray(new Integer[5]), array1);
    }

    @Test
    public void testFindBigStraightInFormatHandCardListForThreeCase05() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_107);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("提示不正确", 1, tip.size());
        Integer[] array = {2, 3, 4, 5, 6};
        Assert.assertArrayEquals(tip.get(0).toArray(new Integer[5]), array);
    }

    @Test
    public void testFindBigStraightInFormatHandCardListForThreeCase06() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_107);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("提示不正确", 1, tip.size());
        Integer[] array = {2, 3, 4, 5, 6};
        Assert.assertArrayEquals(tip.get(0).toArray(new Integer[5]), array);
    }
}
