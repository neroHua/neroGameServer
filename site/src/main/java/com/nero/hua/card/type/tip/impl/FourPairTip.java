package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.ArrayList;
import java.util.List;

public class FourPairTip extends AbstractTwoPartGroupTip implements PlayCardTypeTip {

    public FourPairTip() {
        super(PlayCardTypeEnumeration.FOUR_PAIR);
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int FOUR_COUNT = 4;
        final int PAIR_COUNT = 2;
        final int FOUR_SINGLE_COUNT = 6;
        final int FOUR_SINGLE_GROUP_COUNT = formatPlayCardEnumerationList.size() / FOUR_SINGLE_COUNT;

        List<CardEnumeration> formatPlayCardEnumerationListTemp = new ArrayList<>();
        for (int i = 0; i < FOUR_COUNT * FOUR_SINGLE_GROUP_COUNT; i++) {
            formatPlayCardEnumerationListTemp.add(formatPlayCardEnumerationList.get(i));
        }
        List<List<Integer>> bigFourList = PlayCardTypeTipUtil.findBigSameValueWithCountInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, FOUR_COUNT);

        List<List<Integer>> pairList = PlayCardTypeTipUtil.findBigSameValueWithCountInFormatHandCardListForThree(formatHandCardEnumerationList, null, PAIR_COUNT);

        final int GROUP_COUNT = 2;
        return mergeBigFirstPartWithRestPartByGroupCountInFormatHandCardListForThree(formatHandCardEnumerationList, bigFourList, pairList, GROUP_COUNT);
    }

}
