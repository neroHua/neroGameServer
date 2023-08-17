package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleTip implements PlayCardTypeTip {

    @Override
    public PlayCardTypeEnumeration getPlayCardTypeEnumeration() {
        return PlayCardTypeEnumeration.SINGLE;
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        List<List<Integer>> bigSingleTips = findBigSingleInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
        return bigSingleTips;
    }

    private List<List<Integer>> findBigSingleInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        List<List<Integer>> bigList = new ArrayList<>();
        for (int i = 0; i < formatHandCardEnumerationList.size(); i++) {
            CardEnumeration cardCurrent = formatHandCardEnumerationList.get(i);
            if (cardCurrent.getValue() > formatPlayCardEnumerationList.get(0).getValue()) {
                bigList.add(Arrays.asList(i));
            }
        }
        return bigList;
    }

}
