package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class PairStraightTip extends BaseDuplicatedStraightTip implements PlayCardTypeTip {

    public PairStraightTip() {
        super(PlayCardTypeEnumeration.PAIR_STRAIGHT,2);
    }

}
