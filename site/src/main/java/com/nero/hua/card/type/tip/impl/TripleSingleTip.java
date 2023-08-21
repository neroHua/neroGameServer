package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class TripleSingleTip extends AbstractTwoPartTip implements PlayCardTypeTip {

    public TripleSingleTip() {
        super(PlayCardTypeEnumeration.TRIPLE_SINGLE,3);
    }

    @Override
    List<List<Integer>> findSecondPartList(List<CardEnumeration> formatHandCardEnumerationList) {
        return PlayCardTypeTipUtil.findSingleInFormatHandCardList(formatHandCardEnumerationList);
    }

}
