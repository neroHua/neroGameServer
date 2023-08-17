package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class StraightTip extends PlayCardTypeImpl implements PlayCardTypeTip {

    public StraightTip() {
        super(PlayCardTypeEnumeration.STRAIGHT);
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        List<List<Integer>> bigStraightTips = findBigStraightInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
        return bigStraightTips;
    }

    protected List<List<Integer>> findBigStraightInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int SINGLE_DUPLICATE_COUNT = 1;
        return findBigSameValueStraightByCountInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, SINGLE_DUPLICATE_COUNT);
    }

    protected List<List<Integer>> findBigSameValueStraightByCountInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, final int duplicateCount) {
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

}
