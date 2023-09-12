package com.nero.hua.card.type.validate.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class BombKingThreeBigValidate extends PlayCardTypeImpl implements PlayCardTypeValidate {

    private static final int COUNT = 3;

    public BombKingThreeBigValidate() {
        super(PlayCardTypeEnumeration.BOMB_KING_THREE_BIG);
    }

    @Override
    public Boolean match(List<CardEnumeration> formatPlayCardEnumerationList) {
        if (COUNT != formatPlayCardEnumerationList.size()) {
            return Boolean.FALSE;
        }

        return formatPlayCardEnumerationList.get(0).getValue() == CardEnumeration.CARD_517.getValue()
            && formatPlayCardEnumerationList.get(1).getValue() == CardEnumeration.CARD_517.getValue()
            && formatPlayCardEnumerationList.get(2).getValue() == CardEnumeration.CARD_517.getValue();
    }

}
