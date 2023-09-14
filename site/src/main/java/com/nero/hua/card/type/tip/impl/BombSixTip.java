package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class BombSixTip extends BaseDuplicatedTip implements PlayCardTypeTip {

    public BombSixTip() {
        super(PlayCardTypeEnumeration.BOMB_SIX,6);
    }

}
