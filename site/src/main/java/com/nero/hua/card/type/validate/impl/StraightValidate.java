package com.nero.hua.card.type.validate.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class StraightValidate extends PlayCardTypeImpl implements PlayCardTypeValidate {

    private static final int MIN_COUNT = 5;

    public StraightValidate() {
        super(PlayCardTypeEnumeration.STRAIGHT);
    }

    @Override
    public Boolean match(List<CardEnumeration> formatPlayCardEnumerationList) {
        if (formatPlayCardEnumerationList.size() < MIN_COUNT) {
            return Boolean.FALSE;
        }

        for (int i = 1; i < formatPlayCardEnumerationList.size(); i++) {
           if (formatPlayCardEnumerationList.get(i).getValue() + 1 != formatPlayCardEnumerationList.get(i - 1).getValue()) {
               return Boolean.FALSE;
           }
        }

        if (formatPlayCardEnumerationList.get(0).getValue() >= CardEnumeration.CARD_415.getValue()) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

}
