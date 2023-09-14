package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class BombSevenTip extends BaseDuplicatedTip implements PlayCardTypeTip {

    public BombSevenTip() {
        super(PlayCardTypeEnumeration.BOMB_SEVEN,7);
    }

}
