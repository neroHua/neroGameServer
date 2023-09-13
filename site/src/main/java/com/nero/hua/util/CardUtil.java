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

    public static boolean handCardMapContainsPlayCardMap(Map<CardEnumeration, Integer> handCardMap, Map<CardEnumeration, Integer> playCardMap) {
        for (CardEnumeration cardEnumeration : playCardMap.keySet()) {
            Integer handCardCount = handCardMap.get(cardEnumeration);
            if (null == handCardCount) {
                return Boolean.FALSE;
            }

            Integer playCardCount = playCardMap.get(cardEnumeration);
            if (handCardCount < playCardCount) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public static boolean handCardMapNotContainsPlayCardMap(Map<CardEnumeration, Integer> handCardMap, Map<CardEnumeration, Integer> playCardMap) {
        return !handCardMapContainsPlayCardMap(handCardMap, playCardMap);
    }

    public static void quickSortEachCardList(List<List<CardEnumeration>> dealCardList) {
        for (int i = 0; i < dealCardList.size(); i++) {
            quickSortOneCardList(0, dealCardList.get(i).size() - 1, dealCardList.get(i));
        }
    }

    public static void quickSortOneCardList(int start, int end, List<CardEnumeration> cardList) {
        if (start >= end) {
            return;
        }

        CardEnumeration keyCard = cardList.get(start);
        int i = start;
        int j = end;
        while (i != j) {
            if (cardList.get(i).getValue() < keyCard.getValue()) {
                CardEnumeration temp = cardList.get(j);
                cardList.set(j, cardList.get(i));
                cardList.set(i, temp);
                j--;
            }
            else {
                i++;
            }
        }

        int middle = cardList.get(i).getValue() >= keyCard.getValue() ? i : i - 1;
        if (middle >= start && middle <= end) {
            CardEnumeration temp = cardList.get(middle);
            cardList.set(middle, cardList.get(start));
            cardList.set(start, temp);
        }

        quickSortOneCardList(start, middle - 1, cardList);
        quickSortOneCardList(middle + 1, end, cardList);
    }

    public static int formatCardList(List<CardEnumeration> playCardList) {
        Map<Integer, Integer> playCardValueCountMap = getPlayCardValueCountMap(playCardList);

        quickSortOneCardList(0, playCardList.size() - 1, playCardList);

        Map<Integer, List<CardEnumeration>> playCardCountListMap = getPlayCardCountListMap(playCardList, playCardValueCountMap);

        List<Integer> countList = getSortedPlayCardCountList(playCardCountListMap);

        for (int i = 0, k = 0; i < countList.size(); i++) {
            List<CardEnumeration> cardEnumerationList = playCardCountListMap.get(countList.get(i));
            for (int j = 0; j < cardEnumerationList.size(); j++) {
                playCardList.set(k, cardEnumerationList.get(j));
                k++;
            }
        }

        return countList.get(0);
    }

    private static List<Integer> getSortedPlayCardCountList(Map<Integer, List<CardEnumeration>> playCardCountListMap) {
        List<Integer> countList = new ArrayList<>();
        for (Integer i : playCardCountListMap.keySet()) {
            countList.add(i);
        }

        selectionSort(countList);
        return countList;
    }

    private static Map<Integer, List<CardEnumeration>> getPlayCardCountListMap(List<CardEnumeration> sortedPlayCardList, Map<Integer, Integer> playCardValueCountMap) {
        Map<Integer, List<CardEnumeration>> playCardCountListMap = new HashMap<>();
        for (Integer i : playCardValueCountMap.keySet()) {
            playCardCountListMap.put(playCardValueCountMap.get(i), new LinkedList<>());
        }

        for (int i = 0; i < sortedPlayCardList.size(); i++) {
            CardEnumeration cardEnumeration = sortedPlayCardList.get(i);
            Integer count = playCardValueCountMap.get(cardEnumeration.getValue());
            List<CardEnumeration> cardEnumerationList = playCardCountListMap.get(count);
            cardEnumerationList.add(cardEnumeration);
        }
        return playCardCountListMap;
    }

    public static void selectionSort(List<Integer> countList) {
        if (1 == countList.size()) {
            return;
        }

        for (int i = 0; i < countList.size() - 1; i++) {
            Integer current = countList.get(i);
            for (int j = i + 1; j < countList.size(); j++) {
                Integer tobeCompared = countList.get(j);
                if (tobeCompared > current) {
                    countList.set(i, tobeCompared);
                    countList.set(j, current);
                    current = tobeCompared;
                }
            }
        }
    }

    private static Map<Integer, Integer> getPlayCardValueCountMap(List<CardEnumeration> playCardList) {
        Map<Integer, Integer> playCardValueCountMap = new HashMap<>();

        for (int i = 0; i < playCardList.size(); i++) {
            Integer count = playCardValueCountMap.get(playCardList.get(i).getValue());
            if (null == count) {
                playCardValueCountMap.put(playCardList.get(i).getValue(), 1);
            }
            else {
                playCardValueCountMap.put(playCardList.get(i).getValue(), count + 1);
            }
        }

        return playCardValueCountMap;
    }

}
