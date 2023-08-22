package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.ArrayList;
import java.util.List;

public class BombKingTip extends PlayCardTypeImpl implements PlayCardTypeTip {

    public BombKingTip() {
        super(PlayCardTypeEnumeration.BOMB_KING);
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        if (null != formatHandCardEnumerationList) {
            return null;
        }

        final int BOMB_KING_SIZE = 2;
        if (formatHandCardEnumerationList.size() < BOMB_KING_SIZE) {
            return null;
        }

        List<List<Integer>> bombKingList = new ArrayList<>();
        if (CardEnumeration.CARD_517 == formatHandCardEnumerationList.get(0) && CardEnumeration.CARD_516 == formatHandCardEnumerationList.get(0)) {
            List<Integer> bombKing = new ArrayList<>();
            bombKing.add(0);
            bombKing.add(1);
            bombKingList.add(bombKing);
        }

        return bombKingList;
    }

}
