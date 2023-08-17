package com.nero.hua.card.type.validate.impl;

import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class FourPairValidate implements PlayCardTypeValidate {

    private static final int COUNT = 8;

    @Override
    public PlayCardTypeEnumeration getPlayCardTypeEnumeration() {
        return PlayCardTypeEnumeration.FOUR_PAIR;
    }

    @Override
    public boolean match(List<CardEnumeration> cardEnumerationList) {
        if (COUNT != cardEnumerationList.size()) {
            return Boolean.FALSE;
        }

        return cardEnumerationList.get(0).getValue() == cardEnumerationList.get(1).getValue()
            && cardEnumerationList.get(1).getValue() == cardEnumerationList.get(2).getValue()
            && cardEnumerationList.get(2).getValue() == cardEnumerationList.get(3).getValue()
            && cardEnumerationList.get(4).getValue() == cardEnumerationList.get(5).getValue()
            && cardEnumerationList.get(6).getValue() == cardEnumerationList.get(7).getValue();
    }

}
