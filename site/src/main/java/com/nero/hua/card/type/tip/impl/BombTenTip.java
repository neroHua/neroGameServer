package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class BombTenTip extends BaseDuplicatedTip implements PlayCardTypeTip {

    public BombTenTip() {
        super(PlayCardTypeEnumeration.BOMB_TEN,10);
    }

}
