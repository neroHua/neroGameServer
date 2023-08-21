package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.ArrayList;
import java.util.List;

public class AirplaneSingleTip extends AbstractTwoPartGroupTip implements PlayCardTypeTip {

    public AirplaneSingleTip() {
        super(PlayCardTypeEnumeration.AIRPLANE_SINGLE);
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int AIRPLANE_COUNT = 3;
        final int AIRPLANE_SINGLE_COUNT = 4;
        final int AIRPLANE_SINGLE_GROUP_COUNT = formatPlayCardEnumerationList.size() / AIRPLANE_SINGLE_COUNT;

        List<CardEnumeration> formatPlayCardEnumerationListTemp = new ArrayList<>();
        for (int i = 0; i < AIRPLANE_COUNT * AIRPLANE_SINGLE_GROUP_COUNT; i++) {
            formatPlayCardEnumerationListTemp.add(formatPlayCardEnumerationList.get(i));
        }
        List<List<Integer>> bigAirplaneList = PlayCardTypeTipUtil.findBigSameValueStraightByCountInFormatHandCardList(formatHandCardEnumerationList, formatPlayCardEnumerationListTemp, AIRPLANE_COUNT);

        List<List<Integer>> singleList = PlayCardTypeTipUtil.findSingleInFormatHandCardList(formatHandCardEnumerationList);

        return mergeBigFirstPartWithRestPartByGroupCountInFormatHandCardList(formatHandCardEnumerationList, bigAirplaneList, singleList, AIRPLANE_SINGLE_GROUP_COUNT);
    }

}
