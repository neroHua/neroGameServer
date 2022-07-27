package com.nero.hua.util;

import com.nero.hua.enumeration.CardEnumeration;

import java.util.*;

public class CardUtil {

    public static Map<CardEnumeration, Integer> convertCardListToCardMap(List<CardEnumeration> cardList) {
        Map<CardEnumeration, Integer> cardMap = new HashMap<>();
        for (int i = 0; i < cardList.size(); i++) {
            if (cardMap.containsKey(cardList.get(i))) {
                Integer count = cardMap.get(cardList.get(i));
                cardMap.put(cardList.get(i), count + 1);
            }
            else {
                cardMap.put(cardList.get(i), 1);
            }
        }

        return cardMap;
    }

    public static List<CardEnumeration> convertCardMapToCardList(Map<CardEnumeration, Integer> cardMap) {
        List<CardEnumeration> cardList = new LinkedList<>();
        Set<CardEnumeration> cardEnumerationSet = cardMap.keySet();
        for (CardEnumeration cardEnumeration : cardEnumerationSet) {
            Integer count = cardMap.get(cardEnumeration);
            for (int i = 0; i < count; i++) {
                cardList.add(cardEnumeration);
            }
        }
        return cardList;
    }
}
