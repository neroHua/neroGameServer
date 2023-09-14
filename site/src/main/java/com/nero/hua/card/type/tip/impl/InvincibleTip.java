package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.ArrayList;
import java.util.List;

public class InvincibleTip extends PlayCardTypeImpl implements PlayCardTypeTip {

    public InvincibleTip() {
        super(PlayCardTypeEnumeration.INVINCIBLE);
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        if (null != formatHandCardEnumerationList) {
            return null;
        }

        final int INVINCIBLE_SIZE = 2;
        if (formatHandCardEnumerationList.size() < INVINCIBLE_SIZE) {
            return null;
        }

        if (null != formatPlayCardEnumerationList) {
            return null;
        }

        // todo left to be finish
        List<List<Integer>> invincibleList = new ArrayList<>();
        if (CardEnumeration.CARD_508 == formatHandCardEnumerationList.get(0)) {
            List<Integer> bombKing = new ArrayList<>();
            bombKing.add(0);
            invincibleList.add(bombKing);
        }

        return invincibleList;
    }

}
