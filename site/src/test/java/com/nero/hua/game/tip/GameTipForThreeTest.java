package com.nero.hua.game.tip;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTipForThreeTest {

    @Test
    public void testFindBigSingleInFormatHandCardListForThreeCase01() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList,  PlayCardTypeEnumeration.SINGLE);
        assertEquals(3, tip.size(), "提示不正确");
        assertEquals((int) tip.get(0).get(0), 0, "提示不正确");
        assertEquals((int) tip.get(1).get(0), 1, "提示不正确");
        assertEquals((int) tip.get(2).get(0), 2, "提示不正确");
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

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT);
        assertNull(tip, "提示的结果应该是没有牌了");
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

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT);
        assertNull(tip, "提示的结果应该是没有牌了");
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

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT);
        assertNull(tip, "提示的结果应该是没有牌了");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT);
        assertEquals(1, tipList.size(), "只有一中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 6};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT);
        assertNull(tipList, "提示的结果应该是没有牌了");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT);
        assertEquals(2, tipList.size(), "只有2中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 9};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {6, 7, 8, 9};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT);
        assertEquals(1, tipList.size(), "只有1中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {5, 6, 7, 8};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT);
        assertEquals(2, tipList.size(), "只有2中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 8, 9};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {5, 6, 7, 8};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT);
        assertEquals(1, tipList.size(), "只有1中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {4, 5, 6, 7};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT);
        assertEquals(1, tipList.size(), "只有1中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {4, 5, 6, 7};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT);
        assertEquals(3, tipList.size(), "只有3种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 6, 7, 8};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {10, 11, 12, 14, 15};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {3, 4, 5, 6};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.STRAIGHT);
        assertEquals(4, tipList.size(), "只有4种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 6, 7, 8};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {2, 6, 7, 8, 9};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = { 6, 7, 8, 9, 11};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {3, 4, 5, 6};
        assertArrayEquals(expectTip3, tip3.toArray(), "提示不正确");
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

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT);
        assertNull(tip, "提示的结果应该是没有牌了");
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

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT);
        assertNull(tip, "提示的结果应该是没有牌了");
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

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT);
        assertNull(tip, "提示的结果应该是没有牌了");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT);
        assertEquals(1, tipList.size(), "只有一中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT);
        assertNull(tipList, "提示的结果应该是没有牌了");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT);
        assertEquals(2, tipList.size(), "只有2中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 6, 7, 8, 9, 12, 13};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {10, 11, 12, 13};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT);
        assertEquals(1, tipList.size(), "只有1中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {8, 9, 10, 11};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT);
        assertEquals(2, tipList.size(), "只有2中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 6, 7, 10, 11, 12, 13};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {8, 9, 10, 11};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT);
        assertEquals(1, tipList.size(), "只有1中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {6, 7, 8, 9};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT);
        assertEquals(1, tipList.size(), "只有1中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {6, 7, 8, 9};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT);
        assertEquals(3, tipList.size(), "只有3种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 4, 7, 8, 9, 10, 11, 12};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {5, 6, 7, 8};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR_STRAIGHT);
        assertEquals(4, tipList.size(), "只有4种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 4, 7, 8, 9, 10, 11, 12};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {3, 4, 7, 8, 9, 10, 11, 12, 13, 14};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {5, 6, 7, 8};
        assertArrayEquals(expectTip3, tip3.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigPairInFormatHandCardListForThreeCase01() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR);
        assertNull(tipList, "没有可以选择得牌型");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR);
        assertEquals(null, tipList, "没有可以选择得牌型");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR);
        assertEquals(1, tipList.size(), "只有1种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR);
        assertEquals(1, tipList.size(), "只有1种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR);
        assertEquals(2, tipList.size(), "只有2种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {4, 5};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.PAIR);
        assertEquals(5, tipList.size(), "只有5种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {2, 3};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {3, 4};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {6, 7};
        assertArrayEquals(expectTip3, tip3.toArray(), "提示不正确");

        List<Integer> tip4 = tipList.get(4);
        Integer[] expectTip4 = {1, 2, 3, 4};
        assertArrayEquals(expectTip4, tip4.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.BOMB);
        assertNull(tipList, "没有可以选择得牌型");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.BOMB);
        assertEquals(null, tipList, "没有可以选择得牌型");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.BOMB);
        assertEquals(1, tipList.size(), "只有1种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 4};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.BOMB);
        assertEquals(1, tipList.size(), "只有1种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 4};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.BOMB);
        assertEquals(2, tipList.size(), "只有2种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 4};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {7, 8, 9, 10};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigTripleInFormatHandCardListForThreeCase01() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE);
        assertNull(tipList, "没有可以选择得牌型");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE);
        assertNull(tipList, "没有可以选择得牌型");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE);
        assertEquals(1, tipList.size(), "只有1种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE);
        assertEquals(1, tipList.size(), "只有1种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE);
        assertEquals(2, tipList.size(), "只有2种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {5, 6, 7};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE);
        assertEquals(3, tipList.size(), "只有3种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {6, 7, 8};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {1, 2, 3, 4};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_SINGLE);
        assertNull(tipList, "没有可以选择得牌型");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_SINGLE);
        assertNull(tipList, "没有可以选择得牌型");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_SINGLE);
        assertEquals(2, tipList.size(), "只有2种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 4};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {1, 2, 3, 0};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_SINGLE);
        assertEquals(1, tipList.size(), "只有1种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 0};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_SINGLE);
        assertEquals(10, tipList.size(), "只有10种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {5, 6, 7, 4};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {5, 6, 7, 3};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {5, 6, 7, 2};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {5, 6, 7, 1};
        assertArrayEquals(expectTip3, tip3.toArray(), "提示不正确");

        List<Integer> tip4 = tipList.get(4);
        Integer[] expectTip4 = {5, 6, 7, 0};
        assertArrayEquals(expectTip4, tip4.toArray(), "提示不正确");

        List<Integer> tip5 = tipList.get(5);
        Integer[] expectTip5 = {1, 2, 3, 7};
        assertArrayEquals(expectTip5, tip5.toArray(), "提示不正确");

        List<Integer> tip6 = tipList.get(6);
        Integer[] expectTip6 = {1, 2, 3, 6};
        assertArrayEquals(expectTip6, tip6.toArray(), "提示不正确");

        List<Integer> tip7 = tipList.get(7);
        Integer[] expectTip7 = {1, 2, 3, 5};
        assertArrayEquals(expectTip7, tip7.toArray(), "提示不正确");

        List<Integer> tip8 = tipList.get(8);
        Integer[] expectTip8 = {1, 2, 3, 4};
        assertArrayEquals(expectTip8, tip8.toArray(), "提示不正确");

        List<Integer> tip9 = tipList.get(9);
        Integer[] expectTip9 = {1, 2, 3, 0};
        assertArrayEquals(expectTip9, tip9.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_SINGLE);
        assertEquals(12, tipList.size(), "只有12种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {6, 7, 8, 5};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {6, 7, 8, 4};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {6, 7, 8, 3};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {6, 7, 8, 2};
        assertArrayEquals(expectTip3, tip3.toArray(), "提示不正确");

        List<Integer> tip4 = tipList.get(4);
        Integer[] expectTip4 = {6, 7, 8, 1};
        assertArrayEquals(expectTip4, tip4.toArray(), "提示不正确");

        List<Integer> tip5 = tipList.get(5);
        Integer[] expectTip5 = {6, 7, 8, 0};
        assertArrayEquals(expectTip5, tip5.toArray(), "提示不正确");

        List<Integer> tip6 = tipList.get(6);
        Integer[] expectTip6 = {1, 2, 3, 8};
        assertArrayEquals(expectTip6, tip6.toArray(), "提示不正确");

        List<Integer> tip7 = tipList.get(7);
        Integer[] expectTip7 = {1, 2, 3, 7};
        assertArrayEquals(expectTip7, tip7.toArray(), "提示不正确");

        List<Integer> tip8 = tipList.get(8);
        Integer[] expectTip8 = {1, 2, 3, 6};
        assertArrayEquals(expectTip8, tip8.toArray(), "提示不正确");

        List<Integer> tip9 = tipList.get(9);
        Integer[] expectTip9 = {1, 2, 3, 5};
        assertArrayEquals(expectTip9, tip9.toArray(), "提示不正确");

        List<Integer> tip10 = tipList.get(10);
        Integer[] expectTip10 = {1, 2, 3, 0};
        assertArrayEquals(expectTip10, tip10.toArray(), "提示不正确");

        List<Integer> tip11 = tipList.get(11);
        Integer[] expectTip11 = {1, 2, 3, 4};
        assertArrayEquals(expectTip11, tip11.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_PAIR);
        assertNull(tipList, "没有可以选择得牌型");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_PAIR);
        assertNull(tipList, "没有可以选择得牌型");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_PAIR);
        assertEquals(2, tipList.size(), "只有2种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 6};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {2, 3, 4, 0, 1};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_PAIR);
        assertEquals(1, tipList.size(), "只有1种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 0, 1};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_PAIR);
        assertEquals(8, tipList.size(), "只有8种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {7, 8, 9, 5, 6};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {7, 8, 9, 3, 4};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {7, 8, 9, 2, 3};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {7, 8, 9, 0, 1};
        assertArrayEquals(expectTip3, tip3.toArray(), "提示不正确");

        List<Integer> tip5 = tipList.get(4);
        Integer[] expectTip5 = {2, 3, 4, 8, 9};
        assertArrayEquals(expectTip5, tip5.toArray(), "提示不正确");

        List<Integer> tip6 = tipList.get(5);
        Integer[] expectTip6 = {2, 3, 4, 7, 8};
        assertArrayEquals(expectTip6, tip6.toArray(), "提示不正确");

        List<Integer> tip7 = tipList.get(6);
        Integer[] expectTip7 = {2, 3, 4, 5, 6};
        assertArrayEquals(expectTip7, tip7.toArray(), "提示不正确");

        List<Integer> tip8 = tipList.get(7);
        Integer[] expectTip8 = {2, 3, 4, 0, 1};
        assertArrayEquals(expectTip8, tip8.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.TRIPLE_PAIR);
        assertEquals(10, tipList.size(), "只有10种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {8, 9, 10, 6, 7};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {8, 9, 10, 4, 5};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {8, 9, 10, 3, 4};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {8, 9, 10, 2, 3};
        assertArrayEquals(expectTip3, tip3.toArray(), "提示不正确");

        List<Integer> tip4 = tipList.get(4);
        Integer[] expectTip4 = {8, 9, 10, 0, 1};
        assertArrayEquals(expectTip4, tip4.toArray(), "提示不正确");

        List<Integer> tip5 = tipList.get(5);
        Integer[] expectTip5 = {2, 3, 4, 9, 10};
        assertArrayEquals(expectTip5, tip5.toArray(), "提示不正确");

        List<Integer> tip6 = tipList.get(6);
        Integer[] expectTip6 = {2, 3, 4, 8, 9};
        assertArrayEquals(expectTip6, tip6.toArray(), "提示不正确");

        List<Integer> tip7 = tipList.get(7);
        Integer[] expectTip7 = {2, 3, 4, 6, 7};
        assertArrayEquals(expectTip7, tip7.toArray(), "提示不正确");

        List<Integer> tip8 = tipList.get(8);
        Integer[] expectTip8 = {2, 3, 4, 0, 1};
        assertArrayEquals(expectTip8, tip8.toArray(), "提示不正确");

        List<Integer> tip9 = tipList.get(9);
        Integer[] expectTip9 = {2, 3, 4, 5};
        assertArrayEquals(expectTip9, tip9.toArray(), "提示不正确");
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

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE);
        assertNull(tip, "提示的结果应该是没有牌了");
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

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE);
        assertNull(tip, "提示的结果应该是没有牌了");
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

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE);
        assertNull(tip, "提示的结果应该是没有牌了");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE);
        assertEquals(1, tipList.size(), "只有一中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 6, 7};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE);
        assertNull(tipList, "提示的结果应该是没有牌了");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE);
        assertEquals(1, tipList.size(), "只有一中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 6, 7};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE);
        assertEquals(1, tipList.size(), "只有一中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {5, 6, 7, 8};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE);
        assertEquals(2, tipList.size(), "只有一中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 6, 7, 8, 9, 10, 11};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(1);
        Integer[] expectTip2 = {5, 6, 7, 8};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE);
        assertEquals(1, tipList.size(), "只有一中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {5, 6, 7, 8};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE);
        assertEquals(1, tipList.size(), "只有1种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {5, 6, 7, 8};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE);
        assertEquals(3, tipList.size(), "只有3种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 6, 7, 8, 9, 10, 11};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {12, 13, 14, 15, 16, 17, 18, 19, 20};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {5, 6, 7, 8};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE);
        assertEquals(4, tipList.size(), "只有4种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {5, 6, 7, 8, 9, 10, 11, 12, 13};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {8, 9, 10, 11, 12, 13, 14, 15, 16};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {4, 5, 6, 7};
        assertArrayEquals(expectTip3, tip3.toArray(), "提示不正确");
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

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE);
        assertNull(tip, "提示的结果应该是没有牌了");
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

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE);
        assertNull(tip, "提示的结果应该是没有牌了");
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

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE);
        assertNull(tip, "提示的结果应该是没有牌了");
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

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE);
        assertEquals(6, tipList.size(), "只有6种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 6, 7, 9, 8};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {2, 3, 4, 5, 6, 7, 9, 1};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {2, 3, 4, 5, 6, 7, 9, 0};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {2, 3, 4, 5, 6, 7, 8, 1};
        assertArrayEquals(expectTip3, tip3.toArray(), "提示不正确");

        List<Integer> tip4 = tipList.get(4);
        Integer[] expectTip4 = {2, 3, 4, 5, 6, 7, 8, 0};
        assertArrayEquals(expectTip4, tip4.toArray(), "提示不正确");

        List<Integer> tip5 = tipList.get(5);
        Integer[] expectTip5 = {2, 3, 4, 5, 6, 7, 1, 0};
        assertArrayEquals(expectTip5, tip5.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase05() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_310);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);

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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE);
        assertNull(tipList, "提示的结果应该是没有牌了");
    }

    @Test
    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase06() {
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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE);
        assertEquals(1, tipList.size(), "只有一中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 6, 7, 1, 0};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase07() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE);
        assertEquals(1, tipList.size(), "只有1中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {6, 7, 8, 9};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase08() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE);
        assertEquals(2, tipList.size(), "只有2中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {3, 4, 5, 7, 8, 9, 10, 11, 12, 2, 1, 0};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {6, 7, 8, 9};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase09() {
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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE);
        assertEquals(1, tipList.size(), "只有1中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {5, 6, 7, 8};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase10() {
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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE);
        assertEquals(1, tipList.size(), "只有1中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {5, 6, 7, 8};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase11() {
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
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);

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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE);
        assertEquals(2, tipList.size(), "只有2种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 1, 0};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {5, 6, 7, 8};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplaneSingleInFormatHandCardListForThreeCase12() {
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
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);

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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_SINGLE);
        assertEquals(41, tipList.size(), "只有41种可以选择得牌型");

        List<Integer> tip20 = tipList.get(20);
        Integer[] expectTip20 = {1, 2, 3, 5, 6, 7, 8, 9, 10, 15, 14, 13};
        assertArrayEquals(expectTip20, tip20.toArray(), "提示不正确");

        List<Integer> tip21 = tipList.get(21);
        Integer[] expectTip21 = {1, 2, 3, 5, 6, 7, 8, 9, 10, 15, 14, 12};
        assertArrayEquals(expectTip21, tip21.toArray(), "提示不正确");

        List<Integer> tip22 = tipList.get(22);
        Integer[] expectTip22 = {1, 2, 3, 5, 6, 7, 8, 9, 10, 15, 14, 11};
        assertArrayEquals(expectTip22, tip22.toArray(), "提示不正确");

        List<Integer> tip23 = tipList.get(23);
        Integer[] expectTip23 = {1, 2, 3, 5, 6, 7, 8, 9, 10, 15, 14, 0};
        assertArrayEquals(expectTip23, tip23.toArray(), "提示不正确");

        List<Integer> tip24 = tipList.get(24);
        Integer[] expectTip24 = {1, 2, 3, 5, 6, 7, 8, 9, 10, 15, 13, 12};
        assertArrayEquals(expectTip24, tip24.toArray(), "提示不正确");

        List<Integer> tip25 = tipList.get(25);
        Integer[] expectTip25 = {1, 2, 3, 5, 6, 7, 8, 9, 10, 15, 13, 11};
        assertArrayEquals(expectTip25, tip25.toArray(), "提示不正确");

        List<Integer> tip26 = tipList.get(26);
        Integer[] expectTip26 = {1, 2, 3, 5, 6, 7, 8, 9, 10, 15, 13, 0};
        assertArrayEquals(expectTip26, tip26.toArray(), "提示不正确");

        List<Integer> tip27 = tipList.get(27);
        Integer[] expectTip27 = {1, 2, 3, 5, 6, 7, 8, 9, 10, 15, 12, 11};
        assertArrayEquals(expectTip27, tip27.toArray(), "提示不正确");

        List<Integer> tip28 = tipList.get(28);
        Integer[] expectTip28 = {1, 2, 3, 5, 6, 7, 8, 9, 10, 15, 12, 0};
        assertArrayEquals(expectTip28, tip28.toArray(), "提示不正确");

        List<Integer> tip29 = tipList.get(29);
        Integer[] expectTip29 = {1, 2, 3, 5, 6, 7, 8, 9, 10, 15, 11, 0};
        assertArrayEquals(expectTip29, tip29.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplanePairInFormatHandCardListForThreeCase01() {
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
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_114);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_214);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_314);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_113);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_213);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_313);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR);
        assertNull(tip, "提示的结果应该是没有牌了");
    }

    @Test
    public void testFindBigAirplanePairInFormatHandCardListForThreeCase02() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR);
        assertNull(tip, "提示的结果应该是没有牌了");
    }

    @Test
    public void testFindBigAirplanePairInFormatHandCardListForThreeCase03() {
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
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_309);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR);
        assertNull(tip, "提示的结果应该是没有牌了");
    }

    @Test
    public void testFindBigAirplanePairInFormatHandCardListForThreeCase04() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_310);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_309);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR);
        assertEquals(6, tipList.size(), "只有6种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {4, 5, 6, 7, 8, 9, 12, 13, 10, 11};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {4, 5, 6, 7, 8, 9, 12, 13, 2, 3};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {4, 5, 6, 7, 8, 9, 12, 13, 0, 1};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {4, 5, 6, 7, 8, 9, 10, 11, 2, 3};
        assertArrayEquals(expectTip3, tip3.toArray(), "提示不正确");

        List<Integer> tip4 = tipList.get(4);
        Integer[] expectTip4 = {4, 5, 6, 7, 8, 9, 10, 11, 0, 1};
        assertArrayEquals(expectTip4, tip4.toArray(), "提示不正确");

        List<Integer> tip5 = tipList.get(5);
        Integer[] expectTip5 = {4, 5, 6, 7, 8, 9, 2, 3, 0, 1};
        assertArrayEquals(expectTip5, tip5.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplanePairInFormatHandCardListForThreeCase05() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_310);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);

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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR);
        assertNull(tipList, "提示的结果应该是没有牌了");
    }

    @Test
    public void testFindBigAirplanePairInFormatHandCardListForThreeCase06() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR);
        assertEquals(1, tipList.size(), "只有一中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {4, 5, 6, 7, 8, 9, 2, 3, 0, 1};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplanePairInFormatHandCardListForThreeCase07() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR);
        assertEquals(1, tipList.size(), "只有1中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {9, 10, 11, 12};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplanePairInFormatHandCardListForThreeCase08() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR);
        assertEquals(2, tipList.size(), "只有2中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {6, 7, 8, 10, 11, 12, 13, 14, 15, 4, 5, 2, 3, 0, 1};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {9, 10, 11, 12};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplanePairInFormatHandCardListForThreeCase09() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR);
        assertEquals(1, tipList.size(), "只有1中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {9, 10, 11, 12};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplanePairInFormatHandCardListForThreeCase10() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR);
        assertEquals(1, tipList.size(), "只有1中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {9, 10, 11, 12};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplanePairInFormatHandCardListForThreeCase11() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
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
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);

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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR);
        assertEquals(2, tipList.size(), "只有2种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 2, 3, 0, 1};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {7, 8, 9, 10};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplanePairInFormatHandCardListForThreeCase12() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
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
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);

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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR);
        assertEquals(21, tipList.size(), "只有21种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 17, 18, 15, 16, 3, 4};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 17, 18, 15, 16, 2, 3};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 17, 18, 15, 16, 0, 1};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 17, 18, 3, 4, 2, 3};
        assertArrayEquals(expectTip3, tip3.toArray(), "提示不正确");

        List<Integer> tip4 = tipList.get(4);
        Integer[] expectTip4 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 17, 18, 3, 4, 0, 1};
        assertArrayEquals(expectTip4, tip4.toArray(), "提示不正确");

        List<Integer> tip5 = tipList.get(5);
        Integer[] expectTip5 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 17, 18, 2, 3, 0, 1};
        assertArrayEquals(expectTip5, tip5.toArray(), "提示不正确");

        List<Integer> tip6 = tipList.get(6);
        Integer[] expectTip6 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 3, 4, 2, 3};
        assertArrayEquals(expectTip6, tip6.toArray(), "提示不正确");

        List<Integer> tip7 = tipList.get(7);
        Integer[] expectTip7 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 3, 4, 0, 1};
        assertArrayEquals(expectTip7, tip7.toArray(), "提示不正确");

        List<Integer> tip8 = tipList.get(8);
        Integer[] expectTip8 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 2, 3, 0, 1};
        assertArrayEquals(expectTip8, tip8.toArray(), "提示不正确");

        List<Integer> tip9 = tipList.get(9);
        Integer[] expectTip9 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 3, 4, 2, 3, 0, 1};
        assertArrayEquals(expectTip9, tip9.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplanePairStraightInFormatHandCardListForThreeCase01() {
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
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_114);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_214);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_314);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_113);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_213);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_313);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT);
        assertNull(tip, "提示的结果应该是没有牌了");
    }

    @Test
    public void testFindBigAirplanePairStraightInFormatHandCardListForThreeCase02() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT);
        assertNull(tip, "提示的结果应该是没有牌了");
    }

    @Test
    public void testFindBigAirplanePairStraightInFormatHandCardListForThreeCase03() {
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
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_309);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tip = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT);
        assertNull(tip, "提示的结果应该是没有牌了");
    }

    @Test
    public void testFindBigAirplanePairStraightInFormatHandCardListForThreeCase04() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_310);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_109);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_209);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_309);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT);
        assertEquals(1, tipList.size(), "只有1种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplanePairStraightInFormatHandCardListForThreeCase05() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_310);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);

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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT);
        assertNull(tipList, "提示的结果应该是没有牌了");
    }

    @Test
    public void testFindBigAirplanePairStraightInFormatHandCardListForThreeCase06() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT);
        assertEquals(1, tipList.size(), "只有一中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {6, 7, 8, 9, 10, 11, 2, 3, 4, 5};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplanePairStraightInFormatHandCardListForThreeCase07() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT);
        assertEquals(1, tipList.size(), "只有一中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {9, 10, 11, 12};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplanePairStraightInFormatHandCardListForThreeCase08() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_112);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);
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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT);
        assertEquals(2, tipList.size(), "只有2中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {8, 9, 10, 12, 13, 14, 15, 16, 17, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {11, 12, 13, 14};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplanePairStraightInFormatHandCardListForThreeCase09() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_112);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);
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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT);
        assertEquals(1, tipList.size(), "只有一中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {11, 12, 13, 14};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplanePairStraightInFormatHandCardListForThreeCase10() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_112);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_212);
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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT);
        assertEquals(1, tipList.size(), "只有一中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {11, 12, 13, 14};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplanePairStraightInFormatHandCardListForThreeCase11() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
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
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);

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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT);
        assertEquals(2, tipList.size(), "只有2种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigAirplanePairStraightInFormatHandCardListForThreeCase12() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
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
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);

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
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_105);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_205);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT);
        assertEquals(3, tipList.size(), "只有3种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {2, 3, 4, 6, 7, 8, 9, 10, 11, 15, 16, 17, 18, 19, 20};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {5, 6, 7, 8};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigFourSingleInFormatHandCardListForThreeCase01() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_206);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_306);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_406);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_114);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_214);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_314);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_414);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.FOUR_SINGLE);
        assertEquals(1, tipList.size(), "只有1中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigFourSingleInFormatHandCardListForThreeCase02() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_305);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_405);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_114);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_214);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_314);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_414);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.FOUR_SINGLE);
        assertEquals(1, tipList.size(), "只有1中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigFourSingleInFormatHandCardListForThreeCase03() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_206);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_306);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_406);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_408);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.FOUR_SINGLE);
        assertEquals(1, tipList.size(), "只有1中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigFourSingleInFormatHandCardListForThreeCase04() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_411);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_408);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.FOUR_SINGLE);
        assertEquals(2, tipList.size(), "只有2种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {0, 1, 2, 3, 5, 4};
        assertArrayEquals( expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {0, 1, 2, 3};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigFourSingleInFormatHandCardListForThreeCase05() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_307);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_407);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.FOUR_SINGLE);
        assertNull(tipList, "提示的结果应该是没有牌了");
    }

    @Test
    public void testFindBigFourSingleInFormatHandCardListForThreeCase06() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_411);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_408);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.FOUR_SINGLE);
        assertEquals(2, tipList.size(), "只有2中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 1, 0};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {2, 3, 4, 5};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigFourSingleInFormatHandCardListForThreeCase07() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_107);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_307);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_407);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.FOUR_SINGLE);
        assertEquals(2, tipList.size(), "只有2中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 4, 5, 0};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {1, 2, 3, 4};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigFourSingleInFormatHandCardListForThreeCase08() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_310);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_410);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_406);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.FOUR_SINGLE);
        assertEquals(4, tipList.size(), "只有4种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 4, 6, 5};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {1, 2, 3, 4, 6, 0};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {1, 2, 3, 4, 5, 0};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {1, 2, 3, 4};
        assertArrayEquals(expectTip3, tip3.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigFourPairInFormatHandCardListForThreeCase01() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_206);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_306);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_406);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_114);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_214);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_314);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_414);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.FOUR_PAIR);
        assertEquals(1, tipList.size(), "只有一中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {4, 5, 6, 7};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigFourPairInFormatHandCardListForThreeCase02() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_105);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_205);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_305);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_405);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_114);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_214);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_314);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_414);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.FOUR_PAIR);
        assertEquals(1, tipList.size(), "只有一中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {4, 5, 6, 7};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigFourPairInFormatHandCardListForThreeCase03() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_215);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_206);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_306);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_406);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_408);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.FOUR_PAIR);
        assertEquals(1, tipList.size(), "只有一中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {4, 5, 6, 7};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigFourPairInFormatHandCardListForThreeCase04() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_411);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_408);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.FOUR_PAIR);
        assertEquals(2, tipList.size(), "只有2种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {0, 1, 2, 3, 6, 7, 4, 5};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {0, 1, 2, 3};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigFourPairInFormatHandCardListForThreeCase05() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_307);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_407);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.FOUR_PAIR);
        assertNull(tipList, "提示的结果应该是没有牌了");
    }

    @Test
    public void testFindBigFourPairInFormatHandCardListForThreeCase06() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_114);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_214);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_111);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_211);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_311);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_411);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_108);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_208);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_308);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_408);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.FOUR_PAIR);
        assertEquals(2, tipList.size(), "只有2中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {4, 5, 6, 7, 2, 3, 0, 1};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigFourPairInFormatHandCardListForThreeCase07() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_115);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_108);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_208);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_308);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_408);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_107);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_207);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_106);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_206);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_107);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_207);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_307);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_407);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.FOUR_PAIR);
        assertEquals(2, tipList.size(), "只有2中可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {1, 2, 3, 4, 7, 8, 5, 6};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {1, 2, 3, 4};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");
    }

    @Test
    public void testFindBigFourPairInFormatHandCardListForThreeCase08() {
        List<CardEnumeration> formatHandCardEnumerationList = new LinkedList<>();
        formatHandCardEnumerationList.add(CardEnumeration.CARD_113);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_213);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_110);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_210);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_310);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_410);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_104);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_204);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_103);
        formatHandCardEnumerationList.add(CardEnumeration.CARD_203);

        List<CardEnumeration> formatPlayCardEnumerationList = new LinkedList<>();
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_106);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_206);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_306);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_406);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_104);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_204);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_103);
        formatPlayCardEnumerationList.add(CardEnumeration.CARD_203);

        List<List<Integer>> tipList = new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, PlayCardTypeEnumeration.FOUR_PAIR);
        assertEquals(4, tipList.size(), "只有4种可以选择得牌型");

        List<Integer> tip0 = tipList.get(0);
        Integer[] expectTip0 = {2, 3, 4, 5, 8, 9, 6, 7};
        assertArrayEquals(expectTip0, tip0.toArray(), "提示不正确");

        List<Integer> tip1 = tipList.get(1);
        Integer[] expectTip1 = {2, 3, 4, 5, 8, 9, 0, 1};
        assertArrayEquals(expectTip1, tip1.toArray(), "提示不正确");

        List<Integer> tip2 = tipList.get(2);
        Integer[] expectTip2 = {2, 3, 4, 5, 6, 7, 0, 1};
        assertArrayEquals(expectTip2, tip2.toArray(), "提示不正确");

        List<Integer> tip3 = tipList.get(3);
        Integer[] expectTip3 = {2, 3, 4, 5};
        assertArrayEquals(expectTip3, tip3.toArray(), "提示不正确");
    }

}
