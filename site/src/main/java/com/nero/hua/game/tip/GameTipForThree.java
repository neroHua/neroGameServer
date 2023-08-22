package com.nero.hua.game.tip;

import com.nero.hua.card.type.tip.impl.*;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.GameTypeEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class GameTipForThree extends AbstractGameTip {

    public GameTipForThree() {
        super(GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration) {
        if (PlayCardTypeEnumeration.SINGLE == playCardTypeEnumeration) {
            List<List<Integer>> bigSingleTips = new SingleTip().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = new BombTip().tip(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = new BombKingTip().tip(formatHandCardEnumerationList, null);

            return mergeTipLists(bigSingleTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.STRAIGHT == playCardTypeEnumeration) {
            List<List<Integer>> bigStraightTips = new StraightTip().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = new BombTip().tip(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = new BombKingTip().tip(formatHandCardEnumerationList, null);

            return mergeTipLists(bigStraightTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.PAIR == playCardTypeEnumeration) {
            List<List<Integer>> bigPairTips = new PairTip().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = new BombTip().tip(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = new BombKingTip().tip(formatHandCardEnumerationList, null);

            return mergeTipLists(bigPairTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.PAIR_STRAIGHT == playCardTypeEnumeration) {
            List<List<Integer>> bigPairStraightTips = new PairStraightTip().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = new BombTip().tip(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = new BombKingTip().tip(formatHandCardEnumerationList, null);

            return mergeTipLists(bigPairStraightTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.TRIPLE == playCardTypeEnumeration) {
            List<List<Integer>> bigTripleTips = new TripleTip().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = new BombTip().tip(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = new BombKingTip().tip(formatHandCardEnumerationList, null);

            return mergeTipLists(bigTripleTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.TRIPLE_SINGLE == playCardTypeEnumeration) {
            List<List<Integer>> bigTripleSingleTips = new TripleSingleTip().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = new BombTip().tip(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = new BombKingTip().tip(formatHandCardEnumerationList, null);

            return mergeTipLists(bigTripleSingleTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.TRIPLE_PAIR == playCardTypeEnumeration) {
            List<List<Integer>> bigTriplePairTips = new TriplePairTip().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = new BombTip().tip(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = new BombKingTip().tip(formatHandCardEnumerationList, null);

            return mergeTipLists(bigTriplePairTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.AIRPLANE == playCardTypeEnumeration) {
            List<List<Integer>> bigAirplaneTips = new AirplaneTip().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = new BombTip().tip(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = new BombKingTip().tip(formatHandCardEnumerationList, null);

            return mergeTipLists(bigAirplaneTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.AIRPLANE_SINGLE == playCardTypeEnumeration) {
            List<List<Integer>> bigBigAirplaneSingleTips = new AirplaneSingleTip().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = new BombTip().tip(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = new BombKingTip().tip(formatHandCardEnumerationList, null);

            return mergeTipLists(bigBigAirplaneSingleTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.AIRPLANE_PAIR == playCardTypeEnumeration) {
            List<List<Integer>> bigAirplanePairTips = new AirplanePairTip().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = new BombTip().tip(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = new BombKingTip().tip(formatHandCardEnumerationList, null);

            return mergeTipLists(bigAirplanePairTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT == playCardTypeEnumeration) {
            List<List<Integer>> bigAirplanePairStraightTips = new AirplanePairStraightTip().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = new BombTip().tip(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = new BombKingTip().tip(formatHandCardEnumerationList, null);

            return mergeTipLists(bigAirplanePairStraightTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.FOUR_SINGLE == playCardTypeEnumeration) {
            List<List<Integer>> bigFourSingleTips = new FourSingleTip().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = new BombTip().tip(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = new BombKingTip().tip(formatHandCardEnumerationList, null);

            return mergeTipLists(bigFourSingleTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.FOUR_PAIR == playCardTypeEnumeration) {
            List<List<Integer>> bigFourPairTips = new FourPairTip().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = new BombTip().tip(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = new BombKingTip().tip(formatHandCardEnumerationList, null);

            return mergeTipLists(bigFourPairTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.BOMB == playCardTypeEnumeration) {
            List<List<Integer>> bigBombTips = new BombTip().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombKingTip = new BombKingTip().tip(formatHandCardEnumerationList, null);

            return mergeTipLists(bigBombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.BOMB_KING == playCardTypeEnumeration) {
            return new BombKingTip().tip(formatHandCardEnumerationList, formatPlayCardEnumerationList);
        }

        return null;
    }

}
