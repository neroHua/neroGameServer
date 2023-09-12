package com.nero.hua.card.type.validate.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class FourPairValidate extends PlayCardTypeImpl implements PlayCardTypeValidate {

    private static final int COUNT = 8;

    public FourPairValidate() {
        super(PlayCardTypeEnumeration.FOUR_PAIR);
    }

    @Override
    public Boolean match(List<CardEnumeration> formatPlayCardEnumerationList) {
        if (COUNT != formatPlayCardEnumerationList.size()) {
            return Boolean.FALSE;
        }

        return formatPlayCardEnumerationList.get(0).getValue() == formatPlayCardEnumerationList.get(1).getValue()
            && formatPlayCardEnumerationList.get(1).getValue() == formatPlayCardEnumerationList.get(2).getValue()
            && formatPlayCardEnumerationList.get(2).getValue() == formatPlayCardEnumerationList.get(3).getValue()
            && formatPlayCardEnumerationList.get(4).getValue() == formatPlayCardEnumerationList.get(5).getValue()
            && formatPlayCardEnumerationList.get(6).getValue() == formatPlayCardEnumerationList.get(7).getValue();
    }

}
