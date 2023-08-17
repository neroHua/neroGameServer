package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class BombTip extends BaseDuplicatedTip implements PlayCardTypeTip {

    public BombTip() {
        super(PlayCardTypeEnumeration.BOMB, 4);
    }

}
