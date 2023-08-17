package com.nero.hua.card.type.validate.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class AirplaneSingleValidate extends PlayCardTypeImpl implements PlayCardTypeValidate {

    private static final int MIN_COUNT = 8;

    private static final int GROUP_COUNT = 4;

    public AirplaneSingleValidate() {
        super(PlayCardTypeEnumeration.AIRPLANE_SINGLE);
    }

    @Override
    public boolean match(List<CardEnumeration> cardEnumerationList) {
        if (cardEnumerationList.size() < MIN_COUNT) {
            return Boolean.FALSE;
        }

        if (0 != cardEnumerationList.size() % GROUP_COUNT) {
            return Boolean.FALSE;
        }

        for (int i = 0; i < cardEnumerationList.size() / GROUP_COUNT; i += 3) {
            if (cardEnumerationList.get(i).getValue() != cardEnumerationList.get(i + 1).getValue()
                || cardEnumerationList.get(i + 1).getValue() != cardEnumerationList.get(i + 2).getValue()) {
                return Boolean.FALSE;
            }
        }

        for (int i = 0; i < cardEnumerationList.size() / GROUP_COUNT; i += 3) {
            if (cardEnumerationList.get(i).getValue() - 1 != cardEnumerationList.get(i + 3).getValue()) {
                return Boolean.FALSE;
            }
        }

        if (cardEnumerationList.get(0).getValue() >= CardEnumeration.CARD_415.getValue()) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

}
