package com.nero.hua.util;

import com.nero.hua.enumeration.CardEnumeration;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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


}
