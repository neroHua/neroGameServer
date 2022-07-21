package com.nero.hua.game.manager;

import com.nero.hua.enumeration.CardEnumeration;

import java.util.LinkedList;
import java.util.List;

public class GameManager {

    private static final int COLOR_CARD_COUNT = 52;

    private static final int NORMAL_USER_CARD_COUNT = 17;

    private static final int USER_COUNT = 3;

    public List<CardEnumeration> shuffleCard() {
        List<CardEnumeration> aDeckCardList = getADeckCardList();
        List<CardEnumeration> aShuffledCardList = new LinkedList<>();
        while (!aDeckCardList.isEmpty()) {
            int random = (int) (Math.random() * aDeckCardList.size());
            CardEnumeration randomCard = aDeckCardList.remove(random);
            aShuffledCardList.add(randomCard);
        }
        return aShuffledCardList;
    }

    public List<CardEnumeration> getADeckCardList() {
        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        CardEnumeration[] cardEnumerationArray = CardEnumeration.values();
        for (int i = 0; i < COLOR_CARD_COUNT; i++) {
            cardEnumerationList.add(cardEnumerationArray[i]);
        }
        cardEnumerationList.add(CardEnumeration.CARD_516);
        cardEnumerationList.add(CardEnumeration.CARD_517);

        return cardEnumerationList;
    }

    public List<List<CardEnumeration>> dealCard(List<CardEnumeration> shuffledCardList) {
        List<List<CardEnumeration>> dealCardList = new LinkedList<>();

        for (int i = 0; i < USER_COUNT; i++) {
            List<CardEnumeration> userCardList = new LinkedList<>();
            for (int j = 0; j < NORMAL_USER_CARD_COUNT; j++) {
                userCardList.add(shuffledCardList.remove(0));
            }
            dealCardList.add(userCardList);
        }

        dealCardList.add(shuffledCardList);

        return dealCardList;
    }
}
