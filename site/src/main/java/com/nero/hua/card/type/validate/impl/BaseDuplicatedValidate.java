package com.nero.hua.card.type.validate.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class BaseDuplicatedValidate extends PlayCardTypeImpl implements PlayCardTypeValidate {

    private final int COUNT;

    public BaseDuplicatedValidate(PlayCardTypeEnumeration playCardTypeEnumeration, int count) {
        super(playCardTypeEnumeration);
        this.COUNT = count;
    }

    @Override
    public Boolean match(List<CardEnumeration> formatPlayCardEnumerationList) {
        if (COUNT != formatPlayCardEnumerationList.size()) {
            return Boolean.FALSE;
        }

        for (int i = 0; i < formatPlayCardEnumerationList.size() - 1; i++ ) {
            if (formatPlayCardEnumerationList.get(i).getValue() != formatPlayCardEnumerationList.get(i + 1).getValue()) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }
}
