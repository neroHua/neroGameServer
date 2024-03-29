package com.nero.hua.validate.impl;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import com.nero.hua.validate.PlayCardTypeValidate;

import java.util.List;

public class TriplePairValidate implements PlayCardTypeValidate {

    private static final int COUNT = 5;

    @Override
    public PlayCardTypeEnumeration getPlayCardTypeEnumeration() {
        return PlayCardTypeEnumeration.TRIPLE_PAIR;
    }

    @Override
    public boolean match(List<CardEnumeration> cardEnumerationList) {
        if (COUNT != cardEnumerationList.size()) {
            return Boolean.FALSE;
        }

        return cardEnumerationList.get(0).getValue() == cardEnumerationList.get(1).getValue()
            && cardEnumerationList.get(1).getValue() == cardEnumerationList.get(2).getValue()
            && cardEnumerationList.get(3).getValue() == cardEnumerationList.get(4).getValue();
    }

}
