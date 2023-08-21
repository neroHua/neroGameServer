package com.nero.hua.card.type.validate.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class TripleSingleValidate extends PlayCardTypeImpl implements PlayCardTypeValidate {

    private static final int COUNT = 4;

    public TripleSingleValidate() {
        super(PlayCardTypeEnumeration.TRIPLE_SINGLE);
    }

    @Override
    public boolean match(List<CardEnumeration> cardEnumerationList) {
        if (COUNT != cardEnumerationList.size()) {
            return Boolean.FALSE;
        }

        return cardEnumerationList.get(0).getValue() == cardEnumerationList.get(1).getValue()
            && cardEnumerationList.get(1).getValue() == cardEnumerationList.get(2).getValue();
    }

}