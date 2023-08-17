package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.ArrayList;
import java.util.List;

public class AirplanePairTip extends AbstractTwoPartGroupTip implements PlayCardTypeTip {

    public AirplanePairTip() {
        super(PlayCardTypeEnumeration.AIRPLANE_PAIR);
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int AIRPLANE_COUNT = 3;
        final int PAIR_COUNT = 2;
        final int AIRPLANE_PAIR_COUNT = 5;
        final int AIRPLANE_PAIR_GROUP_COUNT = formatPlayCardEnumerationList.size() / AIRPLANE_PAIR_COUNT;

        List<CardEnumeration> formatPlayCardEnumerationListTemp = new ArrayList<>();
        for (int i = 0; i < AIRPLANE_COUNT * AIRPLANE_PAIR_GROUP_COUNT; i++) {
            formatPlayCardEnumerationListTemp.add(formatPlayCardEnumerationList.get(i));
        }
        List<List<Integer>> bigAirplaneList = PlayCardTypeTipUtil.findBigSameValueStraightByCountInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationListTemp, AIRPLANE_COUNT);

        List<List<Integer>> pairList = PlayCardTypeTipUtil.findBigSameValueWithCountInFormatHandCardListForThree(formatHandCardEnumerationList, null, PAIR_COUNT);

        return mergeBigFirstPartWithRestPartByGroupCountInFormatHandCardListForThree(formatHandCardEnumerationList, bigAirplaneList, pairList, AIRPLANE_PAIR_GROUP_COUNT);
    }

}
