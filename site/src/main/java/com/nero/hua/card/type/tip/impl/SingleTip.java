package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleTip extends PlayCardTypeImpl implements PlayCardTypeTip {

    public SingleTip() {
        super(PlayCardTypeEnumeration.SINGLE);
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        List<List<Integer>> bigSingleTipList = findBigSingleInFormatHandCardList(formatHandCardEnumerationList, formatPlayCardEnumerationList);
        return bigSingleTipList;
    }

    private List<List<Integer>> findBigSingleInFormatHandCardList(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
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
