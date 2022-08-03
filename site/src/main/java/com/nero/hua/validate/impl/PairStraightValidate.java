package com.nero.hua.validate.impl;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import com.nero.hua.validate.PlayCardTypeValidate;

import java.util.List;

public class PairStraightValidate implements PlayCardTypeValidate {

    private static final int MIN_COUNT = 6;
    private static final int GROUP_COUNT = 2;

    @Override
    public PlayCardTypeEnumeration getPlayCardTypeEnumeration() {
        return PlayCardTypeEnumeration.PAIR_STRAIGHT;
    }

    @Override
    public boolean match(List<CardEnumeration> cardEnumerationList) {
        if (cardEnumerationList.size() < MIN_COUNT) {
            return Boolean.FALSE;
        }

        if (0 != cardEnumerationList.size() % GROUP_COUNT) {
            return Boolean.FALSE;
        }

        for (int i = 0; i < cardEnumerationList.size(); i += 2) {
           if (cardEnumerationList.get(i).getValue() != cardEnumerationList.get(i + 1).getValue()) {
               return Boolean.FALSE;
           }
        }
        for (int i = 0; i < cardEnumerationList.size() / GROUP_COUNT; i += 2) {
            if (cardEnumerationList.get(i).getValue() + 1 != cardEnumerationList.get(i + 2).getValue()) {
                return Boolean.FALSE;
            }
        }

        if (cardEnumerationList.get(cardEnumerationList.size() - 1).getValue() >= CardEnumeration.CARD_415.getValue()) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

}
