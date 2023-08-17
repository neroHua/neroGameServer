package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class AirplaneTip extends BaseDuplicatedTip implements PlayCardTypeTip {

    public AirplaneTip() {
        super(PlayCardTypeEnumeration.AIRPLANE, 3);
    }

}
