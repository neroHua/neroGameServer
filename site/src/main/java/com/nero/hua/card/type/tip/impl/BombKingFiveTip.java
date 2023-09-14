package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class BombKingFiveTip extends PlayCardTypeImpl implements PlayCardTypeTip {

    public BombKingFiveTip() {
        super(PlayCardTypeEnumeration.BOMB_KING_FIVE);
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        if (null != formatHandCardEnumerationList) {
            return null;
        }

        final int BOMB_KING_FIVE_SIZE = 5;
        if (formatHandCardEnumerationList.size() < BOMB_KING_FIVE_SIZE) {
            return null;
        }

        return null;
    }

}
