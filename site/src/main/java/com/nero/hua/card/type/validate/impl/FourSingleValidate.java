package com.nero.hua.card.type.validate.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class FourSingleValidate extends PlayCardTypeImpl implements PlayCardTypeValidate {

    private static final int COUNT = 6;

    public FourSingleValidate() {
        super(PlayCardTypeEnumeration.FOUR_SINGLE);
    }

    @Override
    public Boolean match(List<CardEnumeration> formatPlayCardEnumerationList) {
        if (COUNT != formatPlayCardEnumerationList.size()) {
            return Boolean.FALSE;
        }

        return formatPlayCardEnumerationList.get(0).getValue() == formatPlayCardEnumerationList.get(1).getValue()
            && formatPlayCardEnumerationList.get(1).getValue() == formatPlayCardEnumerationList.get(2).getValue()
            && formatPlayCardEnumerationList.get(2).getValue() == formatPlayCardEnumerationList.get(3).getValue();
    }

}
