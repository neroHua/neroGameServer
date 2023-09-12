package com.nero.hua.card.type.validate.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class AirplaneValidate extends PlayCardTypeImpl implements PlayCardTypeValidate {

    private static final int MIN_COUNT = 6;

    private static final int GROUP_COUNT = 3;

    public AirplaneValidate() {
        super(PlayCardTypeEnumeration.AIRPLANE);
    }

    @Override
    public Boolean match(List<CardEnumeration> formatPlayCardEnumerationList) {
        if (formatPlayCardEnumerationList.size() < MIN_COUNT) {
            return Boolean.FALSE;
        }

        if (0 != formatPlayCardEnumerationList.size() % GROUP_COUNT) {
            return Boolean.FALSE;
        }

        for (int i = 0; i < formatPlayCardEnumerationList.size(); i += 3) {
            if (formatPlayCardEnumerationList.get(i).getValue() != formatPlayCardEnumerationList.get(i + 1).getValue()
                || formatPlayCardEnumerationList.get(i + 1).getValue() != formatPlayCardEnumerationList.get(i + 2).getValue()) {
                return Boolean.FALSE;
            }
        }
        for (int i = 0; i < formatPlayCardEnumerationList.size() / GROUP_COUNT; i += 3) {
            if (formatPlayCardEnumerationList.get(i).getValue() - 1 != formatPlayCardEnumerationList.get(i + 3).getValue()) {
                return Boolean.FALSE;
            }
        }

        if (formatPlayCardEnumerationList.get(0).getValue() >= CardEnumeration.CARD_415.getValue()) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

}
