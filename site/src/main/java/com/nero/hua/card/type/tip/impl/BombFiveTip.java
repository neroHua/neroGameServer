package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class BombFiveTip extends BaseDuplicatedTip implements PlayCardTypeTip {

    public BombFiveTip() {
        super(PlayCardTypeEnumeration.BOMB_FIVE, 5);
    }

}
