package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class StraightTip extends BaseDuplicatedStraightTip implements PlayCardTypeTip {

    public StraightTip() {
        super(PlayCardTypeEnumeration.STRAIGHT, 1);
    }

}
