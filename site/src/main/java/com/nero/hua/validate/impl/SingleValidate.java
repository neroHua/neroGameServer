package com.nero.hua.validate.impl;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import com.nero.hua.validate.PlayCardTypeValidate;

import java.util.List;

public class SingleValidate implements PlayCardTypeValidate {

    private static final int COUNT = 1;

    @Override
    public PlayCardTypeEnumeration getPlayCardTypeEnumeration() {
        return PlayCardTypeEnumeration.SINGLE;
    }

    @Override
    public boolean match(List<CardEnumeration> cardEnumerationList) {
        return COUNT == cardEnumerationList.size();
    }
}
