package com.nero.hua.util;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import com.nero.hua.model.user.UserPlayCardTurnMO;
import com.nero.hua.validate.PlayCardTypeValidate;
import com.nero.hua.validate.impl.*;

import java.util.*;

public class CardUtil {

    public static Map<PlayCardTypeEnumeration, PlayCardTypeValidate> playCardTypeValidateMap = new HashMap<>();

    static {
        PlayCardTypeValidate playCardTypeValidate = new SingleValidate();
        playCardTypeValidateMap.put(playCardTypeValidate.getPlayCardTypeEnumeration(), playCardTypeValidate);
        playCardTypeValidate = new StraightValidate();
        playCardTypeValidateMap.put(playCardTypeValidate.getPlayCardTypeEnumeration(), playCardTypeValidate);

        playCardTypeValidate = new PairValidate();
        playCardTypeValidateMap.put(playCardTypeValidate.getPlayCardTypeEnumeration(), playCardTypeValidate);
        playCardTypeValidate = new PairStraightValidate();
        playCardTypeValidateMap.put(playCardTypeValidate.getPlayCardTypeEnumeration(), playCardTypeValidate);

        playCardTypeValidate = new TripleValidate();
        playCardTypeValidateMap.put(playCardTypeValidate.getPlayCardTypeEnumeration(), playCardTypeValidate);
        playCardTypeValidate = new TripleSingleValidate();
        playCardTypeValidateMap.put(playCardTypeValidate.getPlayCardTypeEnumeration(), playCardTypeValidate);
        playCardTypeValidate = new TriplePairValidate();
        playCardTypeValidateMap.put(playCardTypeValidate.getPlayCardTypeEnumeration(), playCardTypeValidate);

        playCardTypeValidate = new AirplaneValidate();
        playCardTypeValidateMap.put(playCardTypeValidate.getPlayCardTypeEnumeration(), playCardTypeValidate);
        playCardTypeValidate = new AirplaneSingleValidate();
        playCardTypeValidateMap.put(playCardTypeValidate.getPlayCardTypeEnumeration(), playCardTypeValidate);
        playCardTypeValidate = new AirplanePairValidate();
        playCardTypeValidateMap.put(playCardTypeValidate.getPlayCardTypeEnumeration(), playCardTypeValidate);

        playCardTypeValidate = new FourSingleValidate();
        playCardTypeValidateMap.put(playCardTypeValidate.getPlayCardTypeEnumeration(), playCardTypeValidate);
        playCardTypeValidate = new FourPairValidate();
        playCardTypeValidateMap.put(playCardTypeValidate.getPlayCardTypeEnumeration(), playCardTypeValidate);

        playCardTypeValidate = new BombValidate();
        playCardTypeValidateMap.put(playCardTypeValidate.getPlayCardTypeEnumeration(), playCardTypeValidate);
        playCardTypeValidate = new BombKingValidate();
        playCardTypeValidateMap.put(playCardTypeValidate.getPlayCardTypeEnumeration(), playCardTypeValidate);
    }

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

    public static boolean playCardNotMatchPlayCardType(List<CardEnumeration> cardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration) {
        return playCardTypeValidateMap.get(playCardTypeEnumeration).match(cardEnumerationList);
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

    public static boolean currentPlayCardListBetterThanLastPlayCardList(UserPlayCardTurnMO lastUserPlayCardTurnMO, List<CardEnumeration> playCardList, PlayCardTypeEnumeration playCardTypeEnumeration) {
        if (null == lastUserPlayCardTurnMO) {
            return Boolean.TRUE;
        }

        PlayCardTypeEnumeration lastPlayCardTypeEnumeration = lastUserPlayCardTurnMO.getPlayCardTypeEnumeration();
        if (playCardTypeEnumeration.getValue() < lastPlayCardTypeEnumeration.getValue()) {
            return Boolean.FALSE;
        }
        else if (playCardTypeEnumeration.getValue() > lastPlayCardTypeEnumeration.getValue()) {
            return Boolean.TRUE;
        }

        if (lastPlayCardTypeEnumeration != playCardTypeEnumeration) {
            return Boolean.FALSE;
        }

        List<CardEnumeration> lastPlayCardList = lastUserPlayCardTurnMO.getCardList();
        return lastPlayCardList.size() == playCardList.size()
                && lastPlayCardList.get(0).getValue() < playCardList.get(0).getValue();
    }

    public static boolean currentPlayCardListNotBetterThanLastPlayCardList(UserPlayCardTurnMO lastUserPlayCardTurnMO, List<CardEnumeration> playCardList, PlayCardTypeEnumeration playCardTypeEnumeration) {
        return !currentPlayCardListBetterThanLastPlayCardList(lastUserPlayCardTurnMO, playCardList, playCardTypeEnumeration);
    }

    public static Map<PlayCardTypeEnumeration, List<CardEnumeration>> generalCalculatePlayCardType(List<CardEnumeration> playCardList) {
        int maxSameValueCardCount = formatCardList(playCardList);

        Map<PlayCardTypeEnumeration, List<CardEnumeration>> playCardTypeMap = new HashMap<>();

        int size = playCardList.size();
        if (1 == maxSameValueCardCount) {
            if (1 == size) {
                playCardTypeMap.put(PlayCardTypeEnumeration.SINGLE, playCardList);
            }
            else if (2 == size) {
                PlayCardTypeValidate playCardTypeValidate = playCardTypeValidateMap.get(PlayCardTypeEnumeration.BOMB_KING);
                if (playCardTypeValidate.match(playCardList)) {
                    playCardTypeMap.put(PlayCardTypeEnumeration.BOMB_KING, playCardList);
                }
            }
            else if (size >= 5) {
                PlayCardTypeValidate playCardTypeValidate = playCardTypeValidateMap.get(PlayCardTypeEnumeration.STRAIGHT);
                if (playCardTypeValidate.match(playCardList)) {
                    playCardTypeMap.put(PlayCardTypeEnumeration.STRAIGHT, playCardList);
                }
            }
        }
        else if (2 == maxSameValueCardCount) {
           if (2 == size) {
               PlayCardTypeValidate playCardTypeValidate = playCardTypeValidateMap.get(PlayCardTypeEnumeration.PAIR);
               if (playCardTypeValidate.match(playCardList)) {
                   playCardTypeMap.put(PlayCardTypeEnumeration.PAIR, playCardList);
               }
           }
           else if (size >= 6) {
               PlayCardTypeValidate playCardTypeValidate = playCardTypeValidateMap.get(PlayCardTypeEnumeration.PAIR_STRAIGHT);
               if (playCardTypeValidate.match(playCardList)) {
                   playCardTypeMap.put(PlayCardTypeEnumeration.PAIR_STRAIGHT, playCardList);
               }
           }
        }
        else if (3 == maxSameValueCardCount) {
            if (3 == size) {
                playCardTypeMap.put(PlayCardTypeEnumeration.TRIPLE, playCardList);
            }
            else if (4 == size) {
                playCardTypeMap.put(PlayCardTypeEnumeration.TRIPLE_SINGLE, playCardList);
            }
            else if (5 == size) {
                PlayCardTypeValidate playCardTypeValidate = playCardTypeValidateMap.get(PlayCardTypeEnumeration.TRIPLE_PAIR);
                if (playCardTypeValidate.match(playCardList)) {
                    playCardTypeMap.put(PlayCardTypeEnumeration.TRIPLE_PAIR, playCardList);
                }
            }
            else if (size % 3 == 0) {
                PlayCardTypeValidate playCardTypeValidate = playCardTypeValidateMap.get(PlayCardTypeEnumeration.AIRPLANE);
                if (playCardTypeValidate.match(playCardList)) {
                    playCardTypeMap.put(PlayCardTypeEnumeration.AIRPLANE, playCardList);
                }
            }
            else if (size % 4 == 0) {
                PlayCardTypeValidate playCardTypeValidate = playCardTypeValidateMap.get(PlayCardTypeEnumeration.AIRPLANE_SINGLE);
                if (playCardTypeValidate.match(playCardList)) {
                    playCardTypeMap.put(PlayCardTypeEnumeration.AIRPLANE_SINGLE, playCardList);
                }
            }
            else if (size % 5 == 0) {
                PlayCardTypeValidate playCardTypeValidate = playCardTypeValidateMap.get(PlayCardTypeEnumeration.AIRPLANE_PAIR);
                if (playCardTypeValidate.match(playCardList)) {
                    playCardTypeMap.put(PlayCardTypeEnumeration.AIRPLANE_PAIR, playCardList);
                }
            }
        }
        else if (4 == maxSameValueCardCount) {
            if (4 == size) {
                playCardTypeMap.put(PlayCardTypeEnumeration.BOMB, playCardList);
            }
            else if (size == 6) {
                playCardTypeMap.put(PlayCardTypeEnumeration.FOUR_SINGLE, playCardList);
            }
            else if (size == 8) {
                playCardTypeMap.put(PlayCardTypeEnumeration.FOUR_PAIR, playCardList);
                List<CardEnumeration> anotherTypeCardList = anotherTypeForFourPair(playCardList);
                PlayCardTypeValidate playCardTypeValidate = playCardTypeValidateMap.get(PlayCardTypeEnumeration.AIRPLANE_SINGLE);
                if (playCardTypeValidate.match(anotherTypeCardList)) {
                    playCardTypeMap.put(PlayCardTypeEnumeration.AIRPLANE_SINGLE, anotherTypeCardList);
                }
            }
        }
        return playCardTypeMap;
    }

    private static List<CardEnumeration> anotherTypeForFourPair(List<CardEnumeration> playCardList) {
        List<CardEnumeration> anotherTypeCardList = new ArrayList<>();
        for (int i = 0; i < playCardList.size(); i++) {
            anotherTypeCardList.add(i, playCardList.get(i));
        }
        anotherTypeCardList.set(3, anotherTypeCardList.get(4));
        anotherTypeCardList.set(6, anotherTypeCardList.get(0));
        return anotherTypeCardList;
    }

    public boolean compareTwoFormattedCardListWithItsType(List<CardEnumeration> playCardList1, PlayCardTypeEnumeration playCardTypeEnumeration1, List<CardEnumeration> playCardList2, PlayCardTypeEnumeration playCardTypeEnumeration2) {
        if (playCardTypeEnumeration1.getValue() > playCardTypeEnumeration2.getValue()) {
            return Boolean.TRUE;
        }
        else if (playCardTypeEnumeration1.getValue() < playCardTypeEnumeration2.getValue()) {
            return Boolean.FALSE;
        }
        else if (playCardTypeEnumeration1.equals(playCardTypeEnumeration2)) {
            return playCardList1.get(0).getValue() > playCardList2.get(0).getValue();
        }
        return Boolean.FALSE;
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
