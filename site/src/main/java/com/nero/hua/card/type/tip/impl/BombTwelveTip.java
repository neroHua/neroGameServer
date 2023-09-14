package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class BombTwelveTip extends BaseDuplicatedTip implements PlayCardTypeTip {

    public BombTwelveTip() {
        super(PlayCardTypeEnumeration.BOMB_TWELVE,12);
    }

}
