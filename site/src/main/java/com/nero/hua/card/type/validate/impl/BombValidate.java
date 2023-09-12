package com.nero.hua.card.type.validate.impl;

import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class BombValidate extends BaseDuplicatedValidate {

    public BombValidate() {
        super(PlayCardTypeEnumeration.BOMB, 4);
    }

}
