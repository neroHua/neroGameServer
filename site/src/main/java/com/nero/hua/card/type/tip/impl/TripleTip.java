package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class TripleTip extends BaseDuplicatedTip implements PlayCardTypeTip {

    public TripleTip() {
        super(PlayCardTypeEnumeration.TRIPLE, 3);
    }

}
