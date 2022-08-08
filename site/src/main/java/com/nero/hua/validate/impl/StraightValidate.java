package com.nero.hua.validate.impl;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import com.nero.hua.validate.PlayCardTypeValidate;

import java.util.List;

public class StraightValidate implements PlayCardTypeValidate {

    private static final int MIN_COUNT = 5;

    @Override
    public PlayCardTypeEnumeration getPlayCardTypeEnumeration() {
        return PlayCardTypeEnumeration.STRAIGHT;
    }

    @Override
    public boolean match(List<CardEnumeration> cardEnumerationList) {
        if (cardEnumerationList.size() < MIN_COUNT) {
            return Boolean.FALSE;
        }

        for (int i = 1; i < cardEnumerationList.size(); i++) {
           if (cardEnumerationList.get(i).getValue() + 1 != cardEnumerationList.get(i - 1).getValue()) {
               return Boolean.FALSE;
           }
        }

        if (cardEnumerationList.get(0).getValue() >= CardEnumeration.CARD_415.getValue()) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

}
