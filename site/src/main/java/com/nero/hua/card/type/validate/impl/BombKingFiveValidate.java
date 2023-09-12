package com.nero.hua.card.type.validate.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class BombKingFiveValidate extends PlayCardTypeImpl implements PlayCardTypeValidate {

    private static final int COUNT = 5;

    public BombKingFiveValidate() {
        super(PlayCardTypeEnumeration.BOMB_KING_FIVE);
    }

    @Override
    public Boolean match(List<CardEnumeration> formatPlayCardEnumerationList) {
        if (COUNT != formatPlayCardEnumerationList.size()) {
            return Boolean.FALSE;
        }

        return (formatPlayCardEnumerationList.get(0).getValue() == CardEnumeration.CARD_517.getValue()
                && formatPlayCardEnumerationList.get(1).getValue() == CardEnumeration.CARD_517.getValue()
                && formatPlayCardEnumerationList.get(2).getValue() == CardEnumeration.CARD_516.getValue()
                && formatPlayCardEnumerationList.get(3).getValue() == CardEnumeration.CARD_516.getValue()
                && formatPlayCardEnumerationList.get(4).getValue() == CardEnumeration.CARD_516.getValue())
            || (formatPlayCardEnumerationList.get(0).getValue() == CardEnumeration.CARD_517.getValue()
                && formatPlayCardEnumerationList.get(1).getValue() == CardEnumeration.CARD_517.getValue()
                && formatPlayCardEnumerationList.get(2).getValue() == CardEnumeration.CARD_517.getValue()
                && formatPlayCardEnumerationList.get(3).getValue() == CardEnumeration.CARD_516.getValue()
                && formatPlayCardEnumerationList.get(4).getValue() == CardEnumeration.CARD_516.getValue());
    }

}
