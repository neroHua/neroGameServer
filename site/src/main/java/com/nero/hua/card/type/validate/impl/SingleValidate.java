package com.nero.hua.card.type.validate.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class SingleValidate extends PlayCardTypeImpl implements PlayCardTypeValidate {

    private static final int COUNT = 1;

    public SingleValidate() {
        super(PlayCardTypeEnumeration.SINGLE);
    }

    @Override
    public boolean match(List<CardEnumeration> cardEnumerationList) {
        return COUNT == cardEnumerationList.size();
    }
}
