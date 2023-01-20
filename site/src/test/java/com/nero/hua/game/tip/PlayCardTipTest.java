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

}
