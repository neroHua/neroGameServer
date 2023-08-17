package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class PairTip extends BaseDuplicatedTip implements PlayCardTypeTip {

    public PairTip() {
        super(PlayCardTypeEnumeration.PAIR, 2);
    }

}
