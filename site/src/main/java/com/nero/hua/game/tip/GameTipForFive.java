package com.nero.hua.game.tip;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.GameTypeEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class GameTipForFive extends AbstractGameTip {

    public GameTipForFive() {
        super(GameTypeEnumeration.FIGHT_LANDLORD_FOR_FIVE);
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration) {
        return null;
    }
}
