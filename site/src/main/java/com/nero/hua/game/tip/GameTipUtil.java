package com.nero.hua.game.tip;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.GameTypeEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class GameTipUtil {

    public static List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration, GameTypeEnumeration gameTypeEnumeration) {
        if (GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE == gameTypeEnumeration) {
            return tipForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, playCardTypeEnumeration);
        }
        return null;
    }

    private static List<List<Integer>> tipForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration) {
        return new GameTipForThree().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList, playCardTypeEnumeration);
    }

}
