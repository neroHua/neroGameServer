package com.nero.hua.card.type.tip.impl;

import com.nero.hua.enumeration.CardEnumeration;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayCardTypeTipUtil {

    static List<List<Integer>> findBigSameValueWithCountInFormatHandCardList(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, final int duplicateCount) {
        if (formatHandCardEnumerationList.size() < duplicateCount) {
            return null;
        }

        List<List<Integer>> bigList = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < formatHandCardEnumerationList.size() - 1; i++) {
            CardEnumeration cardCurrent = formatHandCardEnumerationList.get(i);
            if (null != formatPlayCardEnumerationList && cardCurrent.getValue() <= formatPlayCardEnumerationList.get(0).getValue()) {
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

    static List<List<Integer>> findBigSameValueStraightByCountInFormatHandCardList(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, final int duplicateCount) {
        if (null != formatPlayCardEnumerationList.get(0) && CardEnumeration.CARD_114.getValue() == formatPlayCardEnumerationList.get(0).getValue()) {
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

            if (null != formatPlayCardEnumerationList.get(PLAY_CARD_SIZE - 1) && cardCurrent.getValue() <= formatPlayCardEnumerationList.get(PLAY_CARD_SIZE - 1).getValue()) {
                break;
            }

            int tempCount = 1;
            if (i == formatHandCardEnumerationList.size() - 1) {
                if (tempCount >= duplicateCount) {
                    tempList.add(i);
                    if (tempList.size() >= PLAY_CARD_SIZE / duplicateCount) {
                        bigTempList.add(tempList);
                    }
                    break;
                }
            }

            CardEnumeration cardEnumerationNext = formatHandCardEnumerationList.get(i + 1);
            while (null != cardEnumerationNext && cardCurrent.getValue() == cardEnumerationNext.getValue()) {
                i++;
                tempCount++;
                cardCurrent = cardEnumerationNext;
                cardEnumerationNext = i + 1 > formatHandCardEnumerationList.size() - 1 ? null : formatHandCardEnumerationList.get(i + 1);
            }
            if (tempCount >= duplicateCount) {
                tempList.add(i);
            }

            if (null == cardEnumerationNext) {
                if (tempList.size() >= PLAY_CARD_SIZE / duplicateCount) {
                    bigTempList.add(tempList);
                }
                break;
            }

            if (cardCurrent.getValue() - 1 != cardEnumerationNext.getValue()) {
                if (tempList.size() >= PLAY_CARD_SIZE / duplicateCount) {
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
            for (int i = 0; i <= list.size() - PLAY_CARD_SIZE / duplicateCount; i++) {
                List<Integer> tempBigList = new ArrayList<>();
                for (int j = i; j < PLAY_CARD_SIZE / duplicateCount + i; j++) {
                    List<Integer> duplicateList = new ArrayList<>();
                    for (int k = duplicateCount; k >= 1; k--) {
                        duplicateList.add(list.get(j) - k + 1);
                    }
                    tempBigList.addAll(duplicateList);
                }
                bigList.add(tempBigList);
            }
        }

        return bigList;
    }

    static List<List<Integer>> findSingleInFormatHandCardList(List<CardEnumeration> formatHandCardEnumerationList) {
        List<List<Integer>> singleList = new ArrayList<>();
        for (int i = 0; i < formatHandCardEnumerationList.size(); i++) {
            List<Integer> single = Arrays.asList(i);
            singleList.add(single);
        }

        return singleList;
    }

}
