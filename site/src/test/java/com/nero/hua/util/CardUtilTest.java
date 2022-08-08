package com.nero.hua.util;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CardUtilTest {

    @Test
    public void testSortCardCase01() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_103);
        cardList.add(CardEnumeration.CARD_104);

        CardUtil.quickSortOneCardList(0, cardList.size() - 1, cardList);

        Assert.assertEquals(CardEnumeration.CARD_104, cardList.get(0));
        Assert.assertEquals(CardEnumeration.CARD_103, cardList.get(1));
    }

    @Test
    public void testSortCardCase02() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_103);
        cardList.add(CardEnumeration.CARD_104);
        cardList.add(CardEnumeration.CARD_105);
        cardList.add(CardEnumeration.CARD_106);

        CardUtil.quickSortOneCardList(0, cardList.size() - 1, cardList);

        Assert.assertEquals(CardEnumeration.CARD_106, cardList.get(0));
        Assert.assertEquals(CardEnumeration.CARD_105, cardList.get(1));
        Assert.assertEquals(CardEnumeration.CARD_104, cardList.get(2));
        Assert.assertEquals(CardEnumeration.CARD_103, cardList.get(3));
    }

    @Test
    public void testSortCase01() {
        List<Integer> countList = new ArrayList();
        countList.add(1);

        CardUtil.selectionSort(countList);

        Assert.assertEquals(1, (int) countList.get(0));
    }

    @Test
    public void testSortCase02() {
        List<Integer> countList = new ArrayList();
        countList.add(1);
        countList.add(2);

        CardUtil.selectionSort(countList);

        Assert.assertEquals(2, (int) countList.get(0));
        Assert.assertEquals(1, (int) countList.get(1));
    }

    @Test
    public void testSortCase03() {
        List<Integer> countList = new ArrayList();
        countList.add(1);
        countList.add(2);
        countList.add(3);

        CardUtil.selectionSort(countList);

        Assert.assertEquals(3, (int) countList.get(0));
        Assert.assertEquals(2, (int) countList.get(1));
        Assert.assertEquals(1, (int) countList.get(2));
    }

    @Test
    public void testFormatCardListCase01() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_103);

        int count = CardUtil.formatCardList(cardList);

        Assert.assertEquals(CardEnumeration.CARD_103, cardList.get(0));
        Assert.assertEquals(1, count);
    }

    @Test
    public void testFormatCardListCase02() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_103);
        cardList.add(CardEnumeration.CARD_203);

        int count = CardUtil.formatCardList(cardList);

        Assert.assertEquals(CardEnumeration.CARD_103.getValue(), cardList.get(0).getValue());
        Assert.assertEquals(CardEnumeration.CARD_103.getValue(), cardList.get(1).getValue());
        Assert.assertEquals(2, count);
    }

    @Test
    public void testFormatCardListCase03() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_103);
        cardList.add(CardEnumeration.CARD_203);
        cardList.add(CardEnumeration.CARD_304);

        int count = CardUtil.formatCardList(cardList);

        Assert.assertEquals(CardEnumeration.CARD_103.getValue(), cardList.get(0).getValue());
        Assert.assertEquals(CardEnumeration.CARD_103.getValue(), cardList.get(1).getValue());
        Assert.assertEquals(CardEnumeration.CARD_304.getValue(), cardList.get(2).getValue());

        Assert.assertEquals(2, count);
    }

    @Test
    public void testFormatCardListCase04() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_103);
        cardList.add(CardEnumeration.CARD_203);
        cardList.add(CardEnumeration.CARD_303);
        cardList.add(CardEnumeration.CARD_304);

        int count = CardUtil.formatCardList(cardList);

        Assert.assertEquals(CardEnumeration.CARD_103.getValue(), cardList.get(0).getValue());
        Assert.assertEquals(CardEnumeration.CARD_103.getValue(), cardList.get(1).getValue());
        Assert.assertEquals(CardEnumeration.CARD_103.getValue(), cardList.get(2).getValue());
        Assert.assertEquals(CardEnumeration.CARD_304.getValue(), cardList.get(3).getValue());
        Assert.assertEquals(3, count);
    }

    @Test
    public void testFormatCardListCase05() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_109);
        cardList.add(CardEnumeration.CARD_516);
        cardList.add(CardEnumeration.CARD_517);

        cardList.add(CardEnumeration.CARD_107);
        cardList.add(CardEnumeration.CARD_207);
        cardList.add(CardEnumeration.CARD_108);
        cardList.add(CardEnumeration.CARD_208);

        cardList.add(CardEnumeration.CARD_103);
        cardList.add(CardEnumeration.CARD_203);
        cardList.add(CardEnumeration.CARD_303);
        cardList.add(CardEnumeration.CARD_106);
        cardList.add(CardEnumeration.CARD_206);
        cardList.add(CardEnumeration.CARD_306);

        cardList.add(CardEnumeration.CARD_104);
        cardList.add(CardEnumeration.CARD_204);
        cardList.add(CardEnumeration.CARD_304);
        cardList.add(CardEnumeration.CARD_404);
        cardList.add(CardEnumeration.CARD_105);
        cardList.add(CardEnumeration.CARD_205);
        cardList.add(CardEnumeration.CARD_305);
        cardList.add(CardEnumeration.CARD_405);

        int count = CardUtil.formatCardList(cardList);

        Assert.assertEquals(CardEnumeration.CARD_105.getValue(), cardList.get(0).getValue());
        Assert.assertEquals(CardEnumeration.CARD_105.getValue(), cardList.get(1).getValue());
        Assert.assertEquals(CardEnumeration.CARD_105.getValue(), cardList.get(2).getValue());
        Assert.assertEquals(CardEnumeration.CARD_105.getValue(), cardList.get(3).getValue());
        Assert.assertEquals(CardEnumeration.CARD_104.getValue(), cardList.get(4).getValue());
        Assert.assertEquals(CardEnumeration.CARD_104.getValue(), cardList.get(5).getValue());
        Assert.assertEquals(CardEnumeration.CARD_104.getValue(), cardList.get(6).getValue());
        Assert.assertEquals(CardEnumeration.CARD_104.getValue(), cardList.get(7).getValue());

        Assert.assertEquals(CardEnumeration.CARD_106.getValue(), cardList.get(8).getValue());
        Assert.assertEquals(CardEnumeration.CARD_106.getValue(), cardList.get(9).getValue());
        Assert.assertEquals(CardEnumeration.CARD_106.getValue(), cardList.get(10).getValue());
        Assert.assertEquals(CardEnumeration.CARD_103.getValue(), cardList.get(11).getValue());
        Assert.assertEquals(CardEnumeration.CARD_103.getValue(), cardList.get(12).getValue());
        Assert.assertEquals(CardEnumeration.CARD_103.getValue(), cardList.get(13).getValue());

        Assert.assertEquals(CardEnumeration.CARD_108.getValue(), cardList.get(14).getValue());
        Assert.assertEquals(CardEnumeration.CARD_108.getValue(), cardList.get(15).getValue());
        Assert.assertEquals(CardEnumeration.CARD_107.getValue(), cardList.get(16).getValue());
        Assert.assertEquals(CardEnumeration.CARD_107.getValue(), cardList.get(17).getValue());

        Assert.assertEquals(CardEnumeration.CARD_517.getValue(), cardList.get(18).getValue());
        Assert.assertEquals(CardEnumeration.CARD_516.getValue(), cardList.get(19).getValue());
        Assert.assertEquals(CardEnumeration.CARD_109.getValue(), cardList.get(20).getValue());
        Assert.assertEquals(4, count);
    }

    @Test
    public void testGeneralCalculatePlayCardTypeCase01() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_109);

        Map<PlayCardTypeEnumeration, List<CardEnumeration>> playCardTypeEnumerationListMap = CardUtil.generalCalculatePlayCardType(cardList);
        Assert.assertEquals(1, playCardTypeEnumerationListMap.size());
        Assert.assertNotNull(playCardTypeEnumerationListMap.get(PlayCardTypeEnumeration.SINGLE));
    }

    @Test
    public void testGeneralCalculatePlayCardTypeCase02() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_109);
        cardList.add(CardEnumeration.CARD_209);

        Map<PlayCardTypeEnumeration, List<CardEnumeration>> playCardTypeEnumerationListMap = CardUtil.generalCalculatePlayCardType(cardList);
        Assert.assertEquals(1, playCardTypeEnumerationListMap.size());
        Assert.assertNotNull(playCardTypeEnumerationListMap.get(PlayCardTypeEnumeration.PAIR));
    }

    @Test
    public void testGeneralCalculatePlayCardTypeCase03() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_109);
        cardList.add(CardEnumeration.CARD_110);
        cardList.add(CardEnumeration.CARD_111);
        cardList.add(CardEnumeration.CARD_112);
        cardList.add(CardEnumeration.CARD_113);
        cardList.add(CardEnumeration.CARD_114);

        Map<PlayCardTypeEnumeration, List<CardEnumeration>> playCardTypeEnumerationListMap = CardUtil.generalCalculatePlayCardType(cardList);
        Assert.assertEquals(1, playCardTypeEnumerationListMap.size());
        Assert.assertNotNull(playCardTypeEnumerationListMap.get(PlayCardTypeEnumeration.STRAIGHT));

        cardList.add(CardEnumeration.CARD_115);
        playCardTypeEnumerationListMap = CardUtil.generalCalculatePlayCardType(cardList);
        Assert.assertEquals(0, playCardTypeEnumerationListMap.size());
    }

    @Test
    public void testGeneralCalculatePlayCardTypeCase04() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_112);
        cardList.add(CardEnumeration.CARD_212);
        cardList.add(CardEnumeration.CARD_113);
        cardList.add(CardEnumeration.CARD_213);
        cardList.add(CardEnumeration.CARD_114);
        cardList.add(CardEnumeration.CARD_214);

        Map<PlayCardTypeEnumeration, List<CardEnumeration>> playCardTypeEnumerationListMap = CardUtil.generalCalculatePlayCardType(cardList);
        Assert.assertEquals(1, playCardTypeEnumerationListMap.size());
        Assert.assertNotNull(playCardTypeEnumerationListMap.get(PlayCardTypeEnumeration.PAIR_STRAIGHT));

        cardList.add(CardEnumeration.CARD_115);
        cardList.add(CardEnumeration.CARD_215);
        playCardTypeEnumerationListMap = CardUtil.generalCalculatePlayCardType(cardList);
        Assert.assertEquals(0, playCardTypeEnumerationListMap.size());
    }

}
