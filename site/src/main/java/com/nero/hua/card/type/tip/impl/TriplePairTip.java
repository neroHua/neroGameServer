package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class TriplePairTip extends AbstractTwoPartTip implements PlayCardTypeTip {

    public TriplePairTip() {
        super(PlayCardTypeEnumeration.TRIPLE_PAIR,3);
    }

    @Override
    List<List<Integer>> findSecondPartList(List<CardEnumeration> formatHandCardEnumerationList) {
        return PlayCardTypeTipUtil.findBigSameValueWithCountInFormatHandCardListForThree(formatHandCardEnumerationList, null, 2);
    }

}
