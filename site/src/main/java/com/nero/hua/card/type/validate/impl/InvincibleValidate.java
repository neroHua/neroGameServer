package com.nero.hua.card.type.validate.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class InvincibleValidate extends PlayCardTypeImpl implements PlayCardTypeValidate {

    private static final int COUNT = 1;

    public InvincibleValidate() {
        super(PlayCardTypeEnumeration.INVINCIBLE);
    }

    @Override
    public Boolean match(List<CardEnumeration> formatPlayCardEnumerationList) {
        if (COUNT != formatPlayCardEnumerationList.size()) {
            return Boolean.FALSE;
        }

        return formatPlayCardEnumerationList.get(0).getValue() == CardEnumeration.CARD_108.getValue();
    }
}
