package com.nero.hua.game.manager;

import com.nero.hua.enumeration.CardEnumeration;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class GameManagerTest {

    @Test
    public void testSortCardCase01() {
        List<CardEnumeration> cardList = new LinkedList<>();
        cardList.add(CardEnumeration.CARD_103);
        cardList.add(CardEnumeration.CARD_104);

        GameManager gameManager = new GameManager();

        gameManager.sortOneCardList(0, cardList.size() - 1, cardList);

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

        GameManager gameManager = new GameManager();

        gameManager.sortOneCardList(0, cardList.size() - 1, cardList);

        Assert.assertEquals(CardEnumeration.CARD_106, cardList.get(0));
        Assert.assertEquals(CardEnumeration.CARD_105, cardList.get(1));
        Assert.assertEquals(CardEnumeration.CARD_104, cardList.get(2));
        Assert.assertEquals(CardEnumeration.CARD_103, cardList.get(3));
    }
}
