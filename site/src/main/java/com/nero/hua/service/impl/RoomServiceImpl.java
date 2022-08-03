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
        return false;
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
                && lastPlayCardList.get(0).getValue() >= playCardList.get(0).getValue();
    }

    public static boolean currentPlayCardListNotBetterThanLastPlayCardList(UserPlayCardTurnMO lastUserPlayCardTurnMO, List<CardEnumeration> playCardList, PlayCardTypeEnumeration playCardTypeEnumeration) {
        return !currentPlayCardListBetterThanLastPlayCardList(lastUserPlayCardTurnMO, playCardList, playCardTypeEnumeration);
    }

}
