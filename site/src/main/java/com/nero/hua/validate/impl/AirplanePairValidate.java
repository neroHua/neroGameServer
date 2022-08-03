package com.nero.hua.validate.impl;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import com.nero.hua.validate.PlayCardTypeValidate;

import java.util.List;

public class AirplanePairValidate implements PlayCardTypeValidate {

    private static final int MIN_COUNT = 10;
    private static final int GROUP_COUNT = 5;
    private static final int TRIPLE_COUNT = 3;

    @Override
    public PlayCardTypeEnumeration getPlayCardTypeEnumeration() {
        return PlayCardTypeEnumeration.AIRPLANE_PAIR;
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
            if (cardEnumerationList.get(i).getValue() + 1 != cardEnumerationList.get(i + 3).getValue()) {
                return Boolean.FALSE;
            }
        }

        int lastTripleStartIndex = this.calculateLastTripleStartIndex(cardEnumerationList.size());
        if (cardEnumerationList.get(lastTripleStartIndex).getValue() >= CardEnumeration.CARD_415.getValue()) {
            return Boolean.FALSE;
        }

        for (int i = lastTripleStartIndex + 3; i < cardEnumerationList.size(); i += 2) {
            if (cardEnumerationList.get(i).getValue() != cardEnumerationList.get(i + 1).getValue()) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    private int calculateLastTripleStartIndex(int size) {
        return (size / GROUP_COUNT - 1) * TRIPLE_COUNT;
    }

}
