package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.ArrayList;
import java.util.List;

public class FourSingleTip extends AbstractTwoPartGroupTip implements PlayCardTypeTip {

    public FourSingleTip() {
        super(PlayCardTypeEnumeration.FOUR_SINGLE);
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int FOUR_COUNT = 4;
        final int FOUR_SINGLE_COUNT = 6;
        final int FOUR_SINGLE_GROUP_COUNT = formatPlayCardEnumerationList.size() / FOUR_SINGLE_COUNT;

        List<CardEnumeration> formatPlayCardEnumerationListTemp = new ArrayList<>();
        for (int i = 0; i < FOUR_COUNT * FOUR_SINGLE_GROUP_COUNT; i++) {
            formatPlayCardEnumerationListTemp.add(formatPlayCardEnumerationList.get(i));
        }
        List<List<Integer>> bigFourList = PlayCardTypeTipUtil.findBigSameValueWithCountInFormatHandCardList(formatHandCardEnumerationList, formatPlayCardEnumerationList, FOUR_COUNT);

        List<List<Integer>> singleList = PlayCardTypeTipUtil.findSingleInFormatHandCardList(formatHandCardEnumerationList);

        final int GROUP_COUNT = 2;
        return mergeBigFirstPartWithRestPartByGroupCountInFormatHandCardList(formatHandCardEnumerationList, bigFourList, singleList, GROUP_COUNT);
    }
}
