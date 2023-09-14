package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class BombEightTip extends BaseDuplicatedTip implements PlayCardTypeTip {

    public BombEightTip() {
        super(PlayCardTypeEnumeration.BOMB_EIGHT,8);
    }

}
