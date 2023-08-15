package com.nero.hua.game.tip;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.GameTypeEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class AbstractPlayCardTip implements PlayCardTip {

    GameTypeEnumeration gameTypeEnumeration;

    public AbstractPlayCardTip(GameTypeEnumeration gameTypeEnumeration) {
        this.gameTypeEnumeration = gameTypeEnumeration;
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration) {
        return PlayCardTipUtil.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, playCardTypeEnumeration, this.gameTypeEnumeration);
    }

}
