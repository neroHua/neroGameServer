package com.nero.hua.game.tip;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.GameTypeEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public class PlayCardTipForThree extends AbstractPlayCardTip {

    public PlayCardTipForThree() {
        super(GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration) {
        if (PlayCardTypeEnumeration.SINGLE == playCardTypeEnumeration) {
            List<List<Integer>> bigSingleTips = findBigSingleInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = findBigBombInFormatHandCardListForThree(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = findBombKingInFormatHandCardListForThree(formatHandCardEnumerationList, null);

            return mergeTipLists(bigSingleTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.STRAIGHT == playCardTypeEnumeration) {
            List<List<Integer>> bigStraightTips = findBigStraightInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = findBigBombInFormatHandCardListForThree(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = findBombKingInFormatHandCardListForThree(formatHandCardEnumerationList, null);

            return mergeTipLists(bigStraightTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.PAIR == playCardTypeEnumeration) {
            List<List<Integer>> bigPairTips = findBigPairInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = findBigBombInFormatHandCardListForThree(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = findBombKingInFormatHandCardListForThree(formatHandCardEnumerationList, null);

            return mergeTipLists(bigPairTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.PAIR_STRAIGHT == playCardTypeEnumeration) {
            List<List<Integer>> bigPairStraightTips = findBigPairStraightInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = findBigBombInFormatHandCardListForThree(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = findBombKingInFormatHandCardListForThree(formatHandCardEnumerationList, null);

            return mergeTipLists(bigPairStraightTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.TRIPLE == playCardTypeEnumeration) {
            List<List<Integer>> bigTripleTips = findBigTripleInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = findBigBombInFormatHandCardListForThree(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = findBombKingInFormatHandCardListForThree(formatHandCardEnumerationList, null);

            return mergeTipLists(bigTripleTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.TRIPLE_SINGLE == playCardTypeEnumeration) {
            List<List<Integer>> bigTripleSingleTips = findBigTripleSingleInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = findBigBombInFormatHandCardListForThree(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = findBombKingInFormatHandCardListForThree(formatHandCardEnumerationList, null);

            return mergeTipLists(bigTripleSingleTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.TRIPLE_PAIR == playCardTypeEnumeration) {
            List<List<Integer>> bigTriplePairTips = findBigTriplePairInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = findBigBombInFormatHandCardListForThree(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = findBombKingInFormatHandCardListForThree(formatHandCardEnumerationList, null);

            return mergeTipLists(bigTriplePairTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.AIRPLANE == playCardTypeEnumeration) {
            List<List<Integer>> bigAirplaneTips = findBigAirplaneInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = findBigBombInFormatHandCardListForThree(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = findBombKingInFormatHandCardListForThree(formatHandCardEnumerationList, null);

            return mergeTipLists(bigAirplaneTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.AIRPLANE_SINGLE == playCardTypeEnumeration) {
            List<List<Integer>> bigBigAirplaneSingleTips = findBigAirplaneSingleInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = findBigBombInFormatHandCardListForThree(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = findBombKingInFormatHandCardListForThree(formatHandCardEnumerationList, null);

            return mergeTipLists(bigBigAirplaneSingleTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.AIRPLANE_PAIR == playCardTypeEnumeration) {
            List<List<Integer>> bigAirplanePairTips = findBigAirplanePairInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = findBigBombInFormatHandCardListForThree(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = findBombKingInFormatHandCardListForThree(formatHandCardEnumerationList, null);

            return mergeTipLists(bigAirplanePairTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT == playCardTypeEnumeration) {
            List<List<Integer>> bigAirplanePairStraightTips = findBigAirplanePairStraightInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = findBigBombInFormatHandCardListForThree(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = findBombKingInFormatHandCardListForThree(formatHandCardEnumerationList, null);

            return mergeTipLists(bigAirplanePairStraightTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.FOUR_SINGLE == playCardTypeEnumeration) {
            List<List<Integer>> bigFourSingleTips = findBigFourSingleInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = findBigBombInFormatHandCardListForThree(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = findBombKingInFormatHandCardListForThree(formatHandCardEnumerationList, null);

            return mergeTipLists(bigFourSingleTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.FOUR_PAIR == playCardTypeEnumeration) {
            List<List<Integer>> bigFourPairTips = findBigFourPairInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombTips = findBigBombInFormatHandCardListForThree(formatHandCardEnumerationList, null);
            List<List<Integer>> bombKingTip = findBombKingInFormatHandCardListForThree(formatHandCardEnumerationList, null);

            return mergeTipLists(bigFourPairTips, bombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.BOMB == playCardTypeEnumeration) {
            List<List<Integer>> bigBombTips = findBigBombInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
            List<List<Integer>> bombKingTip = findBombKingInFormatHandCardListForThree(formatHandCardEnumerationList, null);

            return mergeTipLists(bigBombTips, bombKingTip);
        }
        else if (PlayCardTypeEnumeration.BOMB_KING == playCardTypeEnumeration) {
            return null;
        }

        return null;
    }

}
