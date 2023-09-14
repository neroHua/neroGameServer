package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class BombKingSixTip extends PlayCardTypeImpl implements PlayCardTypeTip {

    public BombKingSixTip() {
        super(PlayCardTypeEnumeration.BOMB_KING_SIX);
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        if (null != formatHandCardEnumerationList) {
            return null;
        }

        final int BOMB_KING_SIX_SIZE = 6;
        if (formatHandCardEnumerationList.size() < BOMB_KING_SIX_SIZE) {
            return null;
        }

        return null;
    }

}
