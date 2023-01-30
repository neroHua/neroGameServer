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
    public void testFindBigSingleInFormatHandCardListForThreeCase01() {
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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_114);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_113);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_112);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_111);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_110);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tip);
    }

    @Test
    public void testFindBigStraightInFormatHandCardListForThreeCase02() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_114);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_113);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_112);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_111);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_110);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tip);
    }

    @Test
    public void testFindBigStraightInFormatHandCardListForThreeCase03() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tip);
    }

    @Test
    public void testFindBigStraightInFormatHandCardListForThreeCase04() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_107);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有一中可以选择得牌型", 1, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 6};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
    }

    @Test
    public void testFindBigStraightInFormatHandCardListForThreeCase05() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tipList);
    }

    @Test
    public void testFindBigStraightInFormatHandCardListForThreeCase06() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_112);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有一中可以选择得牌型", 1, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 9};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
    }

    @Test
    public void testFindBigStraightInFormatHandCardListForThreeCase07() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tipList);
    }

    @Test
    public void testFindBigStraightInFormatHandCardListForThreeCase08() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_407);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_405);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有一中可以选择得牌型", 1, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 8, 9};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
    }

    @Test
    public void testFindBigStraightInFormatHandCardListForThreeCase09() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_407);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_405);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tipList);
    }

    @Test
    public void testFindBigStraightInFormatHandCardListForThreeCase10() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_407);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_405);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tipList);
    }

    @Test
    public void testFindBigStraightInFormatHandCardListForThreeCase11() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_112);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_312);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_412);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_107);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有2种可以选择得牌型", 2, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 6, 7, 8};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {10, 11, 12, 14, 15};
        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());
    }

    @Test
    public void testFindBigStraightInFormatHandCardListForThreeCase12() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_112);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_312);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_412);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有3种可以选择得牌型", 3, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 6, 7, 8};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {2, 6, 7, 8, 9};
        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = { 6, 7, 8, 9, 11};
        Assert.assertArrayEquals("提示不正确", expectTip2, tip2.toArray());
    }

    @Test
    public void testFindBigPairStraightInFormatHandCardListForThreeCase01() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_206);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_114);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_214);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_113);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_213);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_112);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_212);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_111);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_211);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_110);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_210);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tip);
    }

    @Test
    public void testFindBigPairStraightInFormatHandCardListForThreeCase02() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_114);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_214);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_113);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_213);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_112);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_212);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_111);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_211);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_110);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_210);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tip);
    }

    @Test
    public void testFindBigPairStraightInFormatHandCardListForThreeCase03() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_206);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tip);
    }

    @Test
    public void testFindBigPairStraightInFormatHandCardListForThreeCase04() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_107);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_207);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有一中可以选择得牌型", 1, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
    }

    @Test
    public void testFindBigPairStraightInFormatHandCardListForThreeCase05() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tipList);
    }

    @Test
    public void testFindBigPairStraightInFormatHandCardListForThreeCase06() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_112);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有一中可以选择得牌型", 1, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 6, 7, 8, 9, 12, 13};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
    }

    @Test
    public void testFindBigPairStraightInFormatHandCardListForThreeCase07() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tipList);
    }

    @Test
    public void testFindBigPairStraightInFormatHandCardListForThreeCase08() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_107);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_207);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有一中可以选择得牌型", 1, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 6, 7, 10, 11, 12, 13};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
    }

    @Test
    public void testFindBigPairStraightInFormatHandCardListForThreeCase09() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_107);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_207);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tipList);
    }

    @Test
    public void testFindBigPairStraightInFormatHandCardListForThreeCase10() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_107);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_207);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tipList);
    }

    @Test
    public void testFindBigPairStraightInFormatHandCardListForThreeCase11() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_112);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_312);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_412);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_107);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_207);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_206);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有2种可以选择得牌型", 2, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 4, 7, 8, 9, 10, 11, 12};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());
    }

    @Test
    public void testFindBigPairStraightInFormatHandCardListForThreeCase12() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_112);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_312);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_412);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有3种可以选择得牌型", 3, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 4, 7, 8, 9, 10, 11, 12};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {3, 4, 7, 8, 9, 10, 11, 12, 13, 14};
        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        Assert.assertArrayEquals("提示不正确", expectTip2, tip2.toArray());
    }

    @Test
    public void testFindBigPairInFormatHandCardListForThreeCase01() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("没有可以选择得牌型", tipList);
    }

    @Test
    public void testFindBigPairInFormatHandCardListForThreeCase02() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("没有可以选择得牌型", 0, tipList.size());
    }

    @Test
    public void testFindBigPairInFormatHandCardListForThreeCase03() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有1种可以选择得牌型", 1, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
    }

    @Test
    public void testFindBigPairInFormatHandCardListForThreeCase04() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有1种可以选择得牌型", 1, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
    }

    @Test
    public void testFindBigPairInFormatHandCardListForThreeCase05() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有2种可以选择得牌型", 2, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {4, 5};
        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());
    }

    @Test
    public void testFindBigPairInFormatHandCardListForThreeCase06() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_411);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有4种可以选择得牌型", 4, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {2, 3};
        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {3, 4};
        Assert.assertArrayEquals("提示不正确", expectTip2, tip2.toArray());

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {6, 7};
        Assert.assertArrayEquals("提示不正确", expectTip3, tip3.toArray());
    }

    @Test
    public void testFindBigBombInFormatHandCardListForThreeCase01() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_406);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.BOMB, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("没有可以选择得牌型", tipList);
    }

    @Test
    public void testFindBigBombInFormatHandCardListForThreeCase02() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_305);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_405);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_406);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.BOMB, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("没有可以选择得牌型", 0, tipList.size());
    }

    @Test
    public void testFindBigBombInFormatHandCardListForThreeCase03() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_409);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_305);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_405);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_406);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.BOMB, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有1种可以选择得牌型", 1, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 4};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
    }

    @Test
    public void testFindBigBombInFormatHandCardListForThreeCase04() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_409);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_406);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.BOMB, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有1种可以选择得牌型", 1, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 4};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
    }

    @Test
    public void testFindBigBombInFormatHandCardListForThreeCase05() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_411);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_409);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_406);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.BOMB, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有2种可以选择得牌型", 2, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 4};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {7, 8, 9, 10};
        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());
    }

    @Test
    public void testFindBigTripleInFormatHandCardListForThreeCase01() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("没有可以选择得牌型", tipList);
    }

    @Test
    public void testFindBigTripleInFormatHandCardListForThreeCase02() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_305);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("没有可以选择得牌型", null);
    }

    @Test
    public void testFindBigTripleInFormatHandCardListForThreeCase03() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有1种可以选择得牌型", 1, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
    }

    @Test
    public void testFindBigTripleInFormatHandCardListForThreeCase04() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有1种可以选择得牌型", 1, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
    }

    @Test
    public void testFindBigTripleInFormatHandCardListForThreeCase05() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有2种可以选择得牌型", 2, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {5, 6, 7};
        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());
    }

    @Test
    public void testFindBigTripleInFormatHandCardListForThreeCase06() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_411);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有2种可以选择得牌型", 2, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {6, 7, 8};
        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());
    }

    @Test
    public void testFindBigTripleSingleInFormatHandCardListForThreeCase01() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("没有可以选择得牌型", tipList);
    }

    @Test
    public void testFindBigTripleSingleInFormatHandCardListForThreeCase02() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_305);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("没有可以选择得牌型", tipList);
    }

    @Test
    public void testFindBigTripleSingleInFormatHandCardListForThreeCase03() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有2种可以选择得牌型", 2, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 4};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {1, 2, 3, 0};
        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());
    }

    @Test
    public void testFindBigTripleSingleInFormatHandCardListForThreeCase04() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有1种可以选择得牌型", 1, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 0};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
    }

    @Test
    public void testFindBigTripleSingleInFormatHandCardListForThreeCase05() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有10种可以选择得牌型", 10, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {5, 6, 7, 4};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {5, 6, 7, 3};
        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {5, 6, 7, 2};
        Assert.assertArrayEquals("提示不正确", expectTip2, tip2.toArray());

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {5, 6, 7, 1};
        Assert.assertArrayEquals("提示不正确", expectTip3, tip3.toArray());

        List<Integer> tip4 = tipList.get(4);
        Integer[] expectTip4 = {5, 6, 7, 0};
        Assert.assertArrayEquals("提示不正确", expectTip4, tip4.toArray());

        List<Integer> tip5 = tipList.get(5);
        Integer[] expectTip5 = {1, 2, 3, 7};
        Assert.assertArrayEquals("提示不正确", expectTip5, tip5.toArray());

        List<Integer> tip6 = tipList.get(6);
        Integer[] expectTip6 = {1, 2, 3, 6};
        Assert.assertArrayEquals("提示不正确", expectTip6, tip6.toArray());

        List<Integer> tip7 = tipList.get(7);
        Integer[] expectTip7 = {1, 2, 3, 5};
        Assert.assertArrayEquals("提示不正确", expectTip7, tip7.toArray());

        List<Integer> tip8 = tipList.get(8);
        Integer[] expectTip8 = {1, 2, 3, 4};
        Assert.assertArrayEquals("提示不正确", expectTip8, tip8.toArray());

        List<Integer> tip9 = tipList.get(9);
        Integer[] expectTip9 = {1, 2, 3, 0};
        Assert.assertArrayEquals("提示不正确", expectTip9, tip9.toArray());
    }

    @Test
    public void testFindBigTripleSingleInFormatHandCardListForThreeCase06() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_411);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有11种可以选择得牌型", 11, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {6, 7, 8, 5};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {6, 7, 8, 4};
        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {6, 7, 8, 3};
        Assert.assertArrayEquals("提示不正确", expectTip2, tip2.toArray());

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {6, 7, 8, 2};
        Assert.assertArrayEquals("提示不正确", expectTip3, tip3.toArray());

        List<Integer> tip4 = tipList.get(4);
        Integer[] expectTip4 = {6, 7, 8, 1};
        Assert.assertArrayEquals("提示不正确", expectTip4, tip4.toArray());

        List<Integer> tip5 = tipList.get(5);
        Integer[] expectTip5 = {6, 7, 8, 0};
        Assert.assertArrayEquals("提示不正确", expectTip5, tip5.toArray());

        List<Integer> tip6 = tipList.get(6);
        Integer[] expectTip6 = {1, 2, 3, 8};
        Assert.assertArrayEquals("提示不正确", expectTip6, tip6.toArray());

        List<Integer> tip7 = tipList.get(7);
        Integer[] expectTip7 = {1, 2, 3, 7};
        Assert.assertArrayEquals("提示不正确", expectTip7, tip7.toArray());

        List<Integer> tip8 = tipList.get(8);
        Integer[] expectTip8 = {1, 2, 3, 6};
        Assert.assertArrayEquals("提示不正确", expectTip8, tip8.toArray());

        List<Integer> tip9 = tipList.get(9);
        Integer[] expectTip9 = {1, 2, 3, 5};
        Assert.assertArrayEquals("提示不正确", expectTip9, tip9.toArray());

        List<Integer> tip10 = tipList.get(10);
        Integer[] expectTip10 = {1, 2, 3, 0};
        Assert.assertArrayEquals("提示不正确", expectTip10, tip10.toArray());
    }

    @Test
    public void testFindBigTriplePairInFormatHandCardListForThreeCase01() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_PAIR, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("没有可以选择得牌型", tipList);
    }

    @Test
    public void testFindBigTriplePairInFormatHandCardListForThreeCase02() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_305);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_PAIR, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("没有可以选择得牌型", tipList);
    }

    @Test
    public void testFindBigTriplePairInFormatHandCardListForThreeCase03() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_PAIR, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有2种可以选择得牌型", 2, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 6};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {2, 3, 4, 0, 1};
        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());
    }

    @Test
    public void testFindBigTriplePairInFormatHandCardListForThreeCase04() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_PAIR, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有1种可以选择得牌型", 1, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 0, 1};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
    }

    @Test
    public void testFindBigTriplePairInFormatHandCardListForThreeCase05() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_PAIR, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有8种可以选择得牌型", 8, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {7, 8, 9, 5, 6};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {7, 8, 9, 3, 4};
        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {7, 8, 9, 2, 3};
        Assert.assertArrayEquals("提示不正确", expectTip2, tip2.toArray());

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {7, 8, 9, 0, 1};
        Assert.assertArrayEquals("提示不正确", expectTip3, tip3.toArray());

        List<Integer> tip5 = tipList.get(4);
        Integer[] expectTip5 = {2, 3, 4, 8, 9};
        Assert.assertArrayEquals("提示不正确", expectTip5, tip5.toArray());

        List<Integer> tip6 = tipList.get(5);
        Integer[] expectTip6 = {2, 3, 4, 7, 8};
        Assert.assertArrayEquals("提示不正确", expectTip6, tip6.toArray());

        List<Integer> tip7 = tipList.get(6);
        Integer[] expectTip7 = {2, 3, 4, 5, 6};
        Assert.assertArrayEquals("提示不正确", expectTip7, tip7.toArray());

        List<Integer> tip8 = tipList.get(7);
        Integer[] expectTip8 = {2, 3, 4, 0, 1};
        Assert.assertArrayEquals("提示不正确", expectTip8, tip8.toArray());
    }

    @Test
    public void testFindBigTriplePairInFormatHandCardListForThreeCase06() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_411);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_PAIR, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有9种可以选择得牌型", 9, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {8, 9, 10, 6, 7};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {8, 9, 10, 4, 5};
        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {8, 9, 10, 3, 4};
        Assert.assertArrayEquals("提示不正确", expectTip2, tip2.toArray());

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {8, 9, 10, 2, 3};
        Assert.assertArrayEquals("提示不正确", expectTip3, tip3.toArray());

        List<Integer> tip4 = tipList.get(4);
        Integer[] expectTip4 = {8, 9, 10, 0, 1};
        Assert.assertArrayEquals("提示不正确", expectTip4, tip4.toArray());

        List<Integer> tip5 = tipList.get(5);
        Integer[] expectTip5 = {2, 3, 4, 9, 10};
        Assert.assertArrayEquals("提示不正确", expectTip5, tip5.toArray());

        List<Integer> tip6 = tipList.get(6);
        Integer[] expectTip6 = {2, 3, 4, 8, 9};
        Assert.assertArrayEquals("提示不正确", expectTip6, tip6.toArray());

        List<Integer> tip7 = tipList.get(7);
        Integer[] expectTip7 = {2, 3, 4, 6, 7};
        Assert.assertArrayEquals("提示不正确", expectTip7, tip7.toArray());

        List<Integer> tip8 = tipList.get(8);
        Integer[] expectTip8 = {2, 3, 4, 0, 1};
        Assert.assertArrayEquals("提示不正确", expectTip8, tip8.toArray());
    }

    @Test
    public void testFindBigAirplaneInFormatHandCardListForThreeCase01() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_206);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_306);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_305);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_114);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_214);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_314);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_113);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_213);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_313);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tip);
    }

    @Test
    public void testFindBigAirplaneInFormatHandCardListForThreeCase02() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_305);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_304);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_303);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_114);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_114);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_114);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_113);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_113);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_113);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tip);
    }

    @Test
    public void testFindBigAirplaneInFormatHandCardListForThreeCase03() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_206);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_306);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_305);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_309);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tip);
    }

    @Test
    public void testFindBigAirplaneInFormatHandCardListForThreeCase04() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_310);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_309);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有一中可以选择得牌型", 1, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 6, 7};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
    }

    @Test
    public void testFindBigAirplaneInFormatHandCardListForThreeCase05() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_310);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_309);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_307);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tipList);
    }

    @Test
    public void testFindBigAirplaneInFormatHandCardListForThreeCase06() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_112);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_312);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_309);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有一中可以选择得牌型", 1, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 6, 7};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
    }

    @Test
    public void testFindBigAirplaneInFormatHandCardListForThreeCase07() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_309);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_307);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tipList);
    }

    @Test
    public void testFindBigAirplaneInFormatHandCardListForThreeCase08() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_107);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_207);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_307);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_307);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有一中可以选择得牌型", 1, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 6, 7, 8, 9, 10, 11};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
    }

    @Test
    public void testFindBigAirplaneInFormatHandCardListForThreeCase09() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_206);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_306);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_307);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tipList);
    }

    @Test
    public void testFindBigAirplaneInFormatHandCardListForThreeCase10() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_206);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_306);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_307);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tipList);
    }

    @Test
    public void testFindBigAirplaneInFormatHandCardListForThreeCase11() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_313);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_112);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_312);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_412);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_107);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_207);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_307);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_206);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_306);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_307);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_305);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有2种可以选择得牌型", 2, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 6, 7, 8, 9, 10, 11};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {12, 13, 14, 15, 16, 17, 18, 19, 20};
        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());
    }

    @Test
    public void testFindBigAirplaneInFormatHandCardListForThreeCase12() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_313);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_112);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_312);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_412);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_310);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_305);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_304);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_303);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有3种可以选择得牌型", 3, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 5, 6, 7, 8, 9, 10};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {5, 6, 7, 8, 9, 10, 11, 12, 13};
        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {8, 9, 10, 11, 12, 13, 14, 15, 16};
        Assert.assertArrayEquals("提示不正确", expectTip2, tip2.toArray());
    }

    @Test
    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase01() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_206);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_306);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_305);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_114);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_214);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_314);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_113);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_213);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_313);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tip);
    }

    @Test
    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase02() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_305);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_304);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_303);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_114);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_114);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_114);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_113);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_113);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_113);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tip);
    }

    @Test
    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase03() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_206);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_306);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_305);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_309);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tip = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertNull("提示的结果应该是没有牌了", tip);
    }

    @Test
    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase04() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_310);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_309);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        Assert.assertEquals("只有6种可以选择得牌型", 6, tipList.size());

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 6, 7, 9, 8};
        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {2, 3, 4, 5, 6, 7, 9, 1};
        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {2, 3, 4, 5, 6, 7, 9, 0};
        Assert.assertArrayEquals("提示不正确", expectTip2, tip2.toArray());

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {2, 3, 4, 5, 6, 7, 8, 1};
        Assert.assertArrayEquals("提示不正确", expectTip3, tip3.toArray());

        List<Integer> tip4 = tipList.get(4);
        Integer[] expectTip4 = {2, 3, 4, 5, 6, 7, 8, 0};
        Assert.assertArrayEquals("提示不正确", expectTip4, tip4.toArray());

        List<Integer> tip5 = tipList.get(5);
        Integer[] expectTip5 = {2, 3, 4, 5, 6, 7, 1, 0};
        Assert.assertArrayEquals("提示不正确", expectTip5, tip5.toArray());
    }
//
//    @Test
//    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase05() {
//        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_310);
//
//        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_309);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_307);
//
//        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
//        Assert.assertNull("提示的结果应该是没有牌了", tipList);
//    }
//
//    @Test
//    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase06() {
//        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_112);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_312);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
//
//        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_309);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
//
//        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
//        Assert.assertEquals("只有一中可以选择得牌型", 1, tipList.size());
//
//        List<Integer> tip0 = tipList.get(0);
//        Integer[] expectTip0 = {2, 3, 4, 5, 6, 7};
//        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
//    }
//
//    @Test
//    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase07() {
//        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);
//
//        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_309);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_307);
//
//        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
//        Assert.assertNull("提示的结果应该是没有牌了", tipList);
//    }
//
//    @Test
//    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase08() {
//        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_107);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_207);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_307);
//
//        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_307);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
//
//        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
//        Assert.assertEquals("只有一中可以选择得牌型", 1, tipList.size());
//
//        List<Integer> tip0 = tipList.get(0);
//        Integer[] expectTip0 = {2, 3, 4, 6, 7, 8, 9, 10, 11};
//        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
//    }
//
//    @Test
//    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase09() {
//        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_206);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_306);
//
//        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_307);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
//
//        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
//        Assert.assertNull("提示的结果应该是没有牌了", tipList);
//    }
//
//    @Test
//    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase10() {
//        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_206);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_306);
//
//        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_307);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
//
//        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
//        Assert.assertNull("提示的结果应该是没有牌了", tipList);
//    }
//
//    @Test
//    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase11() {
//        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_313);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_112);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_312);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_412);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_107);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_207);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_307);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_206);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_306);
//
//        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_307);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_305);
//
//        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
//        Assert.assertEquals("只有2种可以选择得牌型", 2, tipList.size());
//
//        List<Integer> tip0 = tipList.get(0);
//        Integer[] expectTip0 = {2, 3, 4, 6, 7, 8, 9, 10, 11};
//        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
//
//        List<Integer> tip1 = tipList.get(1);
//        Integer[] expectTip1 = {12, 13, 14, 15, 16, 17, 18, 19, 20};
//        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());
//    }
//
//    @Test
//    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase12() {
//        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_313);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_112);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_312);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_412);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_310);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_109);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_209);
//        formatHandCardEnumerationList.add(CardEnumeration.CARD_309);
//
//        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_305);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_304);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);
//        formatPlayCardEnumerationList.add(CardEnumeration.CARD_303);
//
//        List<List<Integer>> tipList = PlayCardTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE, GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
//        Assert.assertEquals("只有3种可以选择得牌型", 3, tipList.size());
//
//        List<Integer> tip0 = tipList.get(0);
//        Integer[] expectTip0 = {1, 2, 3, 5, 6, 7, 8, 9, 10};
//        Assert.assertArrayEquals("提示不正确", expectTip0, tip0.toArray());
//
//        List<Integer> tip1 = tipList.get(1);
//        Integer[] expectTip1 = {5, 6, 7, 8, 9, 10, 11, 12, 13};
//        Assert.assertArrayEquals("提示不正确", expectTip1, tip1.toArray());
//
//        List<Integer> tip2 = tipList.get(2);
//        Integer[] expectTip2 = {8, 9, 10, 11, 12, 13, 14, 15, 16};
//        Assert.assertArrayEquals("提示不正确", expectTip2, tip2.toArray());
//    }

}
