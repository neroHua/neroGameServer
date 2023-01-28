package com.nero.hua.game.tip;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.GameTypeEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayCardTip {

    public static List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration, GameTypeEnumeration gameTypeEnumeration) {
        if (GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE == gameTypeEnumeration) {
            return tipForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, playCardTypeEnumeration);
        }
        return null;
    }

    private static List<List<Integer>> tipForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration) {
        if (PlayCardTypeEnumeration.SINGLE == playCardTypeEnumeration) {
            return findBigSingleInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
        }
        else if (PlayCardTypeEnumeration.PAIR == playCardTypeEnumeration) {
            return findBigPairInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
        }
        else if (PlayCardTypeEnumeration.STRAIGHT.getValue() == playCardTypeEnumeration.getValue()) {
            return findBigStraightInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
        }
        else if (PlayCardTypeEnumeration.BOMB.getValue() == playCardTypeEnumeration.getValue()) {
            return findBigBombInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
        }
        else if (PlayCardTypeEnumeration.BOMB_KING == playCardTypeEnumeration) {
            return null;
        }

        return null;
    }

    private static List<List<Integer>> findBigSingleInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        List<List<Integer>> bigList = new ArrayList<>();
        for (int i = 0; i < formatHandCardEnumerationList.size(); i++) {
            CardEnumeration cardCurrent = formatHandCardEnumerationList.get(i);
            if (cardCurrent.getValue() > formatPlayCardEnumerationList.get(0).getValue()) {
                bigList.add(Arrays.asList(i));
            }
        }
        return bigList;
    }

    private static List<List<Integer>> findBigPairInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int PAIR_DUPLICATE_COUNT = 2;
        return findBigSameValueWithCountInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, PAIR_DUPLICATE_COUNT);
    }

    private static List<List<Integer>> findBigSameValueWithCountInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, final int duplicateCount) {
        if (formatHandCardEnumerationList.size() < duplicateCount) {
            return null;
        }

        List<List<Integer>> bigList = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < formatHandCardEnumerationList.size() - 1; i++) {
            CardEnumeration cardCurrent = formatHandCardEnumerationList.get(i);
            if (cardCurrent.getValue() <= formatPlayCardEnumerationList.get(0).getValue()) {
                break;
            }
            CardEnumeration cardEnumerationNext = formatHandCardEnumerationList.get(i + 1);
            if (cardCurrent.getValue() == cardEnumerationNext.getValue()) {
                count++;
            } else {
                count = 1;
            }

            if (duplicateCount == count) {
                List<Integer> big = new ArrayList<>();
                for (int j = i - count + 2; j <= i + 1; j++) {
                    big.add(j);
                }
                bigList.add(big);
                count = 1;
            }
        }

        return bigList;
    }

    private static List<List<Integer>> findBigStraightInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        if (CardEnumeration.CARD_114.getValue() == formatPlayCardEnumerationList.get(0).getValue()) {
            return null;
        }

        final int PLAY_CARD_SIZE = formatPlayCardEnumerationList.size();
        if (formatHandCardEnumerationList.size() < PLAY_CARD_SIZE) {
            return null;
        }

        List<List<Integer>> bigTempList = new ArrayList<>();
        List<Integer> tempList= new ArrayList<>();
        for (int i = 0; i < formatHandCardEnumerationList.size(); ) {
            CardEnumeration cardCurrent = formatHandCardEnumerationList.get(i);
            if (cardCurrent.getValue() > CardEnumeration.CARD_114.getValue()) {
                i++;
                continue;
            }

            if (cardCurrent.getValue() <= formatPlayCardEnumerationList.get(PLAY_CARD_SIZE - 1).getValue()) {
                break;
            }

            if (i == formatHandCardEnumerationList.size() - 1) {
                tempList.add(i);
                if (tempList.size() >= PLAY_CARD_SIZE) {
                    bigTempList.add(tempList);
                }
                break;
            }

            CardEnumeration cardEnumerationNext = formatHandCardEnumerationList.get(i + 1);
            while (null != cardEnumerationNext && cardCurrent.getValue() == cardEnumerationNext.getValue()) {
                i++;
                cardCurrent = cardEnumerationNext;
                cardEnumerationNext = i + 1 > formatHandCardEnumerationList.size() - 1 ? null : formatHandCardEnumerationList.get(i + 1);
            }
            tempList.add(i);

            if (null == cardEnumerationNext) {
                if (tempList.size() >= PLAY_CARD_SIZE) {
                    bigTempList.add(tempList);
                }
                break;
            }

            if (cardCurrent.getValue() - 1 != cardEnumerationNext.getValue()) {
                if (tempList.size() >= PLAY_CARD_SIZE) {
                    bigTempList.add(tempList);
                }
                tempList = new ArrayList<>();
            }
            i++;
        }

        if (CollectionUtils.isEmpty(bigTempList)) {
            return null;
        }

        List<List<Integer>> bigList = new ArrayList<>();
        for (List<Integer> list : bigTempList) {
            for (int i = 0; i <= list.size() - PLAY_CARD_SIZE; i++) {
                List<Integer> tempBigList = new ArrayList<>();
                for (int j = i; j < PLAY_CARD_SIZE + i; j++) {
                    tempBigList.add(list.get(j));
                }
                bigList.add(tempBigList);
            }
        }

        return bigList;
    }

    private static List<List<Integer>> findBigBombInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int BOMB_DUPLICATE_COUNT = 4;
        return findBigSameValueWithCountInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, BOMB_DUPLICATE_COUNT);
    }

}
