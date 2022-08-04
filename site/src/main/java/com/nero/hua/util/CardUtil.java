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

    public static Map<PlayCardTypeEnumeration, List<CardEnumeration>> fastCalculatePlayCardType(List<CardEnumeration> playCardList) {
        Map<PlayCardTypeEnumeration, List<CardEnumeration>> playCardTypeMap = new HashMap<>();
        if (1 == playCardList.size()) {
            playCardTypeMap.put(PlayCardTypeEnumeration.SINGLE, playCardList);
        }
        else if (2 == playCardList.size()){
            if (playCardList.get(0).getValue() == playCardList.get(1).getValue()) {
                playCardTypeMap.put(PlayCardTypeEnumeration.PAIR, playCardList);
            }

            if (playCardList.get(1).getValue() < playCardList.get(0).getValue()) {
                playCardList.add(playCardList.remove(0));
            }
            if (playCardList.get(0) == CardEnumeration.CARD_516 && playCardList.get(1) == CardEnumeration.CARD_517) {
                playCardTypeMap.put(PlayCardTypeEnumeration.BOMB_KING, playCardList);
            }
        }
        else if (3 == playCardList.size()){
            if (playCardList.get(0).getValue() == playCardList.get(1).getValue()
                    && playCardList.get(1).getValue() == playCardList.get(2).getValue()) {
                playCardTypeMap.put(PlayCardTypeEnumeration.TRIPLE, playCardList);
            }
        }
        else if (4 == playCardList.size()){
            if (playCardList.get(0).getValue() == playCardList.get(1).getValue()
                    && playCardList.get(1).getValue() == playCardList.get(2).getValue()
                    && playCardList.get(2).getValue() == playCardList.get(3).getValue()) {
                playCardTypeMap.put(PlayCardTypeEnumeration.BOMB, playCardList);
                playCardTypeMap.put(PlayCardTypeEnumeration.TRIPLE_SINGLE, playCardList);
            }

            formatCardList(playCardList);
        }

        return playCardTypeMap;
    }

    public static void sortEachCardList(List<List<CardEnumeration>> dealCardList) {
        for (int i = 0; i < dealCardList.size(); i++) {
            sortOneCardList(0, dealCardList.get(i).size() - 1, dealCardList.get(i));
        }
    }

    public static void sortOneCardList(int start, int end, List<CardEnumeration> cardList) {
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

        sortOneCardList(start, middle - 1, cardList);
        sortOneCardList(middle + 1, end, cardList);
    }

    private static void formatCardList(List<CardEnumeration> playCardList) {
        Map<Integer, Integer> playCardValueCountMap = getPlayCardValueCountMap(playCardList);

        sortOneCardList(0, playCardList.size() - 1, playCardList);

        Map<Integer, Integer> countStartIndexMap = new HashMap<>();
        for (Integer i : playCardValueCountMap.keySet()) {
            countStartIndexMap.put(playCardValueCountMap.get(i), 0);
        }

        for (int i = 0; i < playCardList.size(); i++) {
            CardEnumeration cardEnumeration = playCardList.get(i);
            Integer count = playCardValueCountMap.get(cardEnumeration.getValue());
            Integer countStartIndex = countStartIndexMap.get(count);
            playCardList.remove(i);
            playCardList.add(countStartIndex, cardEnumeration);
            countStartIndexMap.put(count, countStartIndex + 1);
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
