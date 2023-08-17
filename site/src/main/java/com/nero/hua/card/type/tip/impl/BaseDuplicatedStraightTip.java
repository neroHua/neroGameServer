package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class BaseDuplicatedStraightTip extends PlayCardTypeImpl implements PlayCardTypeTip {

    private final int DUPLICATE_COUNT;

    public BaseDuplicatedStraightTip(PlayCardTypeEnumeration playCardTypeEnumeration, int DUPLICATE_COUNT) {
        super(playCardTypeEnumeration);
        this.DUPLICATE_COUNT = DUPLICATE_COUNT;
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        return PlayCardTypeTipUtil.findBigSameValueStraightByCountInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, DUPLICATE_COUNT);
    }

}
