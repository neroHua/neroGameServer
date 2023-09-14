package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.ArrayList;
import java.util.List;

public class BombKingFourMaxTip extends PlayCardTypeImpl implements PlayCardTypeTip {

    public BombKingFourMaxTip() {
        super(PlayCardTypeEnumeration.BOMB_KING_FOUR_MAX);
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        if (null != formatHandCardEnumerationList) {
            return null;
        }

        final int BOMB_KING_FOUR_MAX_SIZE = 4;
        if (formatHandCardEnumerationList.size() < BOMB_KING_FOUR_MAX_SIZE) {
            return null;
        }

        if (null != formatPlayCardEnumerationList) {
            return null;
        }

        List<List<Integer>> bombKingList = new ArrayList<>();
        if (CardEnumeration.CARD_517 == formatHandCardEnumerationList.get(0)
                && CardEnumeration.CARD_517 == formatHandCardEnumerationList.get(1)
                && CardEnumeration.CARD_516 == formatHandCardEnumerationList.get(2)
                && CardEnumeration.CARD_516 == formatHandCardEnumerationList.get(3)) {
            List<Integer> bombKing = new ArrayList<>();
            bombKing.add(0);
            bombKing.add(1);
            bombKing.add(2);
            bombKing.add(3);
            bombKingList.add(bombKing);
        }

        return bombKingList;
    }

}
