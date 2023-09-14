package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class BombNineTip extends BaseDuplicatedTip implements PlayCardTypeTip {

    public BombNineTip() {
        super(PlayCardTypeEnumeration.BOMB_NINE,9);
    }

}
