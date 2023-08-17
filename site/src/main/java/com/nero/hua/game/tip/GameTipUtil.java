package com.nero.hua.game.tip;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.GameTypeEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class GameTipUtil {

    public static List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration, GameTypeEnumeration gameTypeEnumeration) {
        if (GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE == gameTypeEnumeration) {
            return tipForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, playCardTypeEnumeration);
        }
        return null;
    }

    private static List<List<Integer>> tipForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration) {
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

    private static List<List<Integer>> findBigSingleInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        List<List<Integer>> bigList = new ArrayList<>();
        for (int i = 0; i < formatHandCardEnumerationList.size(); i++) {
            CardEnumeration cardCurrent = formatHandCardEnumerationList.get(i);
            if (cardCurrent.getValue() > formatPlayCardEnumerationList.get(0).getValue()) {
                bigList.add(Arrays.asList(i));
            }
        }
        return bigList;
    }

    private static List<List<Integer>> findBigStraightInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int SINGLE_DUPLICATE_COUNT = 1;
        return findBigSameValueStraightByCountInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, SINGLE_DUPLICATE_COUNT);
    }

    private static List<List<Integer>> findBigPairInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int PAIR_DUPLICATE_COUNT = 2;
        return findBigSameValueWithCountInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, PAIR_DUPLICATE_COUNT);
    }

    private static List<List<Integer>> findBigSameValueWithCountInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, final int duplicateCount) {
        if (formatHandCardEnumerationList.size() < duplicateCount) {
            return null;
        }

        List<List<Integer>> bigList = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < formatHandCardEnumerationList.size() - 1; i++) {
            CardEnumeration cardCurrent = formatHandCardEnumerationList.get(i);
            if (null != formatPlayCardEnumerationList && cardCurrent.getValue() <= formatPlayCardEnumerationList.get(0).getValue()) {
                break;
            }
            CardEnumeration cardEnumerationNext = formatHandCardEnumerationList.get(i + 1);
            if (cardCurrent.getValue() == cardEnumerationNext.getValue()) {
                count++;
            } else {
                count = 1;
            }

            if (duplicateCount == count) {
                List<Integer> big = new ArrayList<>();
                for (int j = i - count + 2; j <= i + 1; j++) {
                    big.add(j);
                }
                bigList.add(big);
                count = 1;
            }
        }

        return bigList;
    }

    private static List<List<Integer>> findBigPairStraightInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int PAIR_DUPLICATE_COUNT = 2;
        return findBigSameValueStraightByCountInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, PAIR_DUPLICATE_COUNT);
    }

    private static List<List<Integer>> findBigSameValueStraightByCountInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, final int duplicateCount) {
        if (null != formatPlayCardEnumerationList.get(0) && CardEnumeration.CARD_114.getValue() == formatPlayCardEnumerationList.get(0).getValue()) {
            return null;
        }

        final int PLAY_CARD_SIZE = formatPlayCardEnumerationList.size();
        if (formatHandCardEnumerationList.size() < PLAY_CARD_SIZE) {
            return null;
        }

        List<List<Integer>> bigTempList = new ArrayList<>();
        List<Integer> tempList= new ArrayList<>();
        for (int i = 0; i < formatHandCardEnumerationList.size(); ) {
            CardEnumeration cardCurrent = formatHandCardEnumerationList.get(i);
            if (cardCurrent.getValue() > CardEnumeration.CARD_114.getValue()) {
                i++;
                continue;
            }

            if (null != formatPlayCardEnumerationList.get(PLAY_CARD_SIZE - 1) && cardCurrent.getValue() <= formatPlayCardEnumerationList.get(PLAY_CARD_SIZE - 1).getValue()) {
                break;
            }

            int tempCount = 1;
            if (i == formatHandCardEnumerationList.size() - 1) {
                if (tempCount >= duplicateCount) {
                    tempList.add(i);
                    if (tempList.size() >= PLAY_CARD_SIZE / duplicateCount) {
                        bigTempList.add(tempList);
                    }
                    break;
                }
            }

            CardEnumeration cardEnumerationNext = formatHandCardEnumerationList.get(i + 1);
            while (null != cardEnumerationNext && cardCurrent.getValue() == cardEnumerationNext.getValue()) {
                i++;
                tempCount++;
                cardCurrent = cardEnumerationNext;
                cardEnumerationNext = i + 1 > formatHandCardEnumerationList.size() - 1 ? null : formatHandCardEnumerationList.get(i + 1);
            }
            if (tempCount >= duplicateCount) {
                tempList.add(i);
            }

            if (null == cardEnumerationNext) {
                if (tempList.size() >= PLAY_CARD_SIZE / duplicateCount) {
                    bigTempList.add(tempList);
                }
                break;
            }

            if (cardCurrent.getValue() - 1 != cardEnumerationNext.getValue()) {
                if (tempList.size() >= PLAY_CARD_SIZE / duplicateCount) {
                    bigTempList.add(tempList);
                }
                tempList = new ArrayList<>();
            }
            i++;
        }

        if (CollectionUtils.isEmpty(bigTempList)) {
            return null;
        }

        List<List<Integer>> bigList = new ArrayList<>();
        for (List<Integer> list : bigTempList) {
            for (int i = 0; i <= list.size() - PLAY_CARD_SIZE / duplicateCount; i++) {
                List<Integer> tempBigList = new ArrayList<>();
                for (int j = i; j < PLAY_CARD_SIZE / duplicateCount + i; j++) {
                    List<Integer> duplicateList = new ArrayList<>();
                    for (int k = duplicateCount; k >= 1; k--) {
                        duplicateList.add(list.get(j) - k + 1);
                    }
                    tempBigList.addAll(duplicateList);
                }
                bigList.add(tempBigList);
            }
        }

        return bigList;
    }

    private static List<List<Integer>> findBigTripleInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int TRIPLE_DUPLICATE_COUNT = 3;
        return findBigSameValueWithCountInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, TRIPLE_DUPLICATE_COUNT);
    }

    private static List<List<Integer>> findBigTripleSingleInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        List<List<Integer>> bigTripleList = findBigTripleInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);

        List<List<Integer>> singleList = findSingleInFormatHandCardListForThree(formatHandCardEnumerationList);

        return mergeBigFirstPartWithRestPartInFormatHandCardListForThree(formatHandCardEnumerationList, bigTripleList, singleList);
    }

    private static List<List<Integer>> findSingleInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList) {
        List<List<Integer>> singleList = new ArrayList<>();
        for (int i = 0; i < formatHandCardEnumerationList.size(); i++) {
            List<Integer> single = Arrays.asList(i);
            singleList.add(single);
        }

        return singleList;
    }

    private static List<List<Integer>> mergeBigFirstPartWithRestPartInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<List<Integer>> bigFirstPartList, List<List<Integer>> restPartList) {
        if (CollectionUtils.isEmpty(bigFirstPartList) || CollectionUtils.isEmpty(restPartList)) {
            return null;
        }

        List<List<Integer>> bigAllPartList = new ArrayList<>();
        for (int i = bigFirstPartList.size() - 1; i >= 0; i--) {
            List<Integer> bigFirstPart = bigFirstPartList.get(i);
            Set<Integer> bigFirstPartSet = new HashSet<>();
            Set<Integer> bigFirstPartValueSet = new HashSet<>();
            for (int j = 0; j < bigFirstPart.size(); j++) {
                bigFirstPartSet.add(bigFirstPart.get(j));
                bigFirstPartValueSet.add(formatHandCardEnumerationList.get(bigFirstPart.get(j)).getValue());
            }

            for (int j = restPartList.size() - 1; j >= 0 ; j--) {
                if(firstPartHasRestPart(formatHandCardEnumerationList, bigFirstPartSet, bigFirstPartValueSet, restPartList.get(j))) {
                    continue;
                }
                List<Integer> bigAllPartPart = new ArrayList<>();
                bigAllPartPart.addAll(bigFirstPart);
                bigAllPartPart.addAll(restPartList.get(j));
                bigAllPartList.add(bigAllPartPart);
            }
        }

        return bigAllPartList;
    }

    private static boolean firstPartHasRestPart(List<CardEnumeration> formatHandCardEnumerationList, Set<Integer> bigFirstPartSet, Set<Integer> bigFirstPartValueSet, List<Integer> restPart) {
        for (Integer restIndex : restPart) {
            if (bigFirstPartSet.contains(restIndex) || bigFirstPartValueSet.contains(formatHandCardEnumerationList.get(restIndex).getValue())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private static List<List<Integer>> findBigTriplePairInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        List<List<Integer>> bigTripleList = findBigTripleInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);

        final int PAIR_DUPLICATE_COUNT = 2;
        List<List<Integer>> pairList = findSameValueWithCountInFormatHandCardListForThree(formatHandCardEnumerationList, PAIR_DUPLICATE_COUNT);

        return mergeBigFirstPartWithRestPartInFormatHandCardListForThree(formatHandCardEnumerationList, bigTripleList, pairList);
    }

    private static List<List<Integer>> findSameValueWithCountInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, int duplicateCount) {
        return findBigSameValueWithCountInFormatHandCardListForThree(formatHandCardEnumerationList, null, duplicateCount);
    }

    private static List<List<Integer>> findBigAirplaneInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int TRIPLE_DUPLICATE_COUNT = 3;
        return findBigSameValueStraightByCountInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, TRIPLE_DUPLICATE_COUNT);
    }

    private static List<List<Integer>> findBigAirplaneSingleInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int AIRPLANE_COUNT = 3;
        final int AIRPLANE_SINGLE_COUNT = 4;
        final int AIRPLANE_SINGLE_GROUP_COUNT = formatPlayCardEnumerationList.size() / AIRPLANE_SINGLE_COUNT;

        List<CardEnumeration> formatPlayCardEnumerationListTemp = new ArrayList<>();
        for (int i = 0; i < AIRPLANE_COUNT * AIRPLANE_SINGLE_GROUP_COUNT; i++) {
            formatPlayCardEnumerationListTemp.add(formatPlayCardEnumerationList.get(i));
        }
        List<List<Integer>> bigAirplaneList = findBigAirplaneInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationListTemp);

        List<List<Integer>> singleList = findSingleInFormatHandCardListForThree(formatHandCardEnumerationList);

        return mergeBigFirstPartWithRestPartByGroupCountInFormatHandCardListForThree(formatHandCardEnumerationList, bigAirplaneList, singleList, AIRPLANE_SINGLE_GROUP_COUNT);
    }

    private static List<List<Integer>> mergeBigFirstPartWithRestPartByGroupCountInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<List<Integer>> bigFirstPartList, List<List<Integer>> restPartList, int groupCount) {
        if (CollectionUtils.isEmpty(bigFirstPartList) || CollectionUtils.isEmpty(restPartList)) {
            return null;
        }

        List<List<Integer>> restPartListRevert = new ArrayList<>();
        for (int i = restPartList.size() - 1; i >= 0; i--) {
            restPartListRevert.add(restPartList.get(i));
        }
        restPartList = restPartListRevert;

        List<List<Integer>> bigAllPartList = new ArrayList<>();
        for (int i = bigFirstPartList.size() - 1; i >= 0; i--) {
            List<Integer> bigFirstPart = bigFirstPartList.get(i);

            Set<Integer> bigFirstPartSet = new HashSet<>();
            Set<Integer> bigFirstPartValueSet = new HashSet<>();
            for (int j = 0; j < bigFirstPart.size(); j++) {
                bigFirstPartSet.add(bigFirstPart.get(j));
                bigFirstPartValueSet.add(formatHandCardEnumerationList.get(bigFirstPart.get(j)).getValue());
            }

            List<Integer> helpChoseRestPartList = new ArrayList<>(groupCount);
            for (int j = 0; j < groupCount; j++) {
                helpChoseRestPartList.add(j);
            }

            do {
                if (firstPartDoNotHasRestPart(formatHandCardEnumerationList, bigFirstPartSet, bigFirstPartValueSet, restPartList, helpChoseRestPartList)) {
                    List<Integer> bigAllPart = new ArrayList<>();
                    bigAllPart.addAll(bigFirstPart);
                    for (int j = 0; j < helpChoseRestPartList.size(); j++) {
                        bigAllPart.addAll(restPartList.get(helpChoseRestPartList.get(j)));
                    }
                    bigAllPartList.add(bigAllPart);
                }
                iteratorForChoseRestPart(restPartList, helpChoseRestPartList, groupCount);
            } while (endForChoseRestPart(restPartList, helpChoseRestPartList, groupCount));
        }

        return bigAllPartList;
    }

    private static boolean firstPartDoNotHasRestPart(List<CardEnumeration> formatHandCardEnumerationList, Set<Integer> bigFirstPartSet, Set<Integer> bigFirstPartValueSet, List<List<Integer>> restPartList, List<Integer> helpChoseRestPartList) {
        for (int i = 0; i < helpChoseRestPartList.size(); i++) {
            List<Integer> rest = restPartList.get(helpChoseRestPartList.get(i));
            for (int j = 0; j < rest.size(); j++) {
                Integer restIndex = rest.get(j);
                if (bigFirstPartSet.contains(restIndex) || bigFirstPartValueSet.contains(formatHandCardEnumerationList.get(restIndex).getValue())) {
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }

    private static void iteratorForChoseRestPart(List<List<Integer>> restPartList, List<Integer> helpChoseRestPartList, int groupCount) {
        boolean carry = Boolean.FALSE;
        int i = helpChoseRestPartList.size() - 1;
        for (; i >= 0; i--) {
            Integer iPosition = helpChoseRestPartList.get(i);
            if (iPosition < restPartList.size() - groupCount + i) {
                helpChoseRestPartList.set(i, iPosition + 1);
                break;
            }
            else {
                helpChoseRestPartList.set(i, iPosition + 1);
                carry = Boolean.TRUE;
            }
        }

        if (carry) {
            i = i == -1 ? 0 : i;
            for (; i < helpChoseRestPartList.size() - 1; i++) {
                helpChoseRestPartList.set(i + 1, helpChoseRestPartList.get(i) + 1);
            }
        }
    }

    private static boolean endForChoseRestPart(List<List<Integer>> restPartList, List<Integer> helpChoseRestPartList, int count) {
        return helpChoseRestPartList.get(0) > restPartList.size() - count ? Boolean.FALSE : Boolean.TRUE;
    }

    private static List<List<Integer>> findBigAirplanePairInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int AIRPLANE_COUNT = 3;
        final int PAIR_COUNT = 2;
        final int AIRPLANE_PAIR_COUNT = 5;
        final int AIRPLANE_PAIR_GROUP_COUNT = formatPlayCardEnumerationList.size() / AIRPLANE_PAIR_COUNT;

        List<CardEnumeration> formatPlayCardEnumerationListTemp = new ArrayList<>();
        for (int i = 0; i < AIRPLANE_COUNT * AIRPLANE_PAIR_GROUP_COUNT; i++) {
            formatPlayCardEnumerationListTemp.add(formatPlayCardEnumerationList.get(i));
        }
        List<List<Integer>> bigAirplaneList = findBigAirplaneInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationListTemp);

        List<List<Integer>> pairList = findSameValueWithCountInFormatHandCardListForThree(formatHandCardEnumerationList, PAIR_COUNT);

        return mergeBigFirstPartWithRestPartByGroupCountInFormatHandCardListForThree(formatHandCardEnumerationList, bigAirplaneList, pairList, AIRPLANE_PAIR_GROUP_COUNT);
    }

    private static List<List<Integer>> findBigAirplanePairStraightInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int AIRPLANE_COUNT = 3;
        final int PAIR_COUNT = 2;
        final int AIRPLANE_PAIR_COUNT = 5;
        final int AIRPLANE_PAIR_GROUP_COUNT = formatPlayCardEnumerationList.size() / AIRPLANE_PAIR_COUNT;

        List<CardEnumeration> formatPlayCardEnumerationListTemp = new ArrayList<>();
        for (int i = 0; i < AIRPLANE_COUNT * AIRPLANE_PAIR_GROUP_COUNT; i++) {
            formatPlayCardEnumerationListTemp.add(formatPlayCardEnumerationList.get(i));
        }
        List<List<Integer>> bigAirplaneList = findBigAirplaneInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationListTemp);

        List<List<Integer>> pairStraightList = findPairStraightInFormatHandCardListForThree(formatHandCardEnumerationList, PAIR_COUNT, AIRPLANE_PAIR_GROUP_COUNT);

        final int GROUP_COUNT = 1;
        return mergeBigFirstPartWithRestPartByGroupCountInFormatHandCardListForThree(formatHandCardEnumerationList, bigAirplaneList, pairStraightList, GROUP_COUNT);
    }

    private static List<List<Integer>> findPairStraightInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, int count, int groupCount) {
        List<CardEnumeration> fakeFormatPlayCardEnumerationList = new ArrayList<>();
        for (int i = 0; i < count * groupCount; i++) {
            fakeFormatPlayCardEnumerationList.add(null);
        }
        return findBigSameValueStraightByCountInFormatHandCardListForThree(formatHandCardEnumerationList, fakeFormatPlayCardEnumerationList, count);
    }

    private static List<List<Integer>> findBigFourSingleInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int FOUR_COUNT = 4;
        final int FOUR_SINGLE_COUNT = 6;
        final int FOUR_SINGLE_GROUP_COUNT = formatPlayCardEnumerationList.size() / FOUR_SINGLE_COUNT;

        List<CardEnumeration> formatPlayCardEnumerationListTemp = new ArrayList<>();
        for (int i = 0; i < FOUR_COUNT * FOUR_SINGLE_GROUP_COUNT; i++) {
            formatPlayCardEnumerationListTemp.add(formatPlayCardEnumerationList.get(i));
        }
        final int FOUR_DUPLICATE_COUNT = 4;
        List<List<Integer>> bigFourList = findBigSameValueWithCountInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, FOUR_DUPLICATE_COUNT);

        List<List<Integer>> singleList = findSingleInFormatHandCardListForThree(formatHandCardEnumerationList);

        final int GROUP_COUNT = 2;
        return mergeBigFirstPartWithRestPartByGroupCountInFormatHandCardListForThree(formatHandCardEnumerationList, bigFourList, singleList, GROUP_COUNT);
    }

    private static List<List<Integer>> findBigFourPairInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int FOUR_COUNT = 4;
        final int PAIR_COUNT = 2;
        final int FOUR_SINGLE_COUNT = 6;
        final int FOUR_SINGLE_GROUP_COUNT = formatPlayCardEnumerationList.size() / FOUR_SINGLE_COUNT;

        List<CardEnumeration> formatPlayCardEnumerationListTemp = new ArrayList<>();
        for (int i = 0; i < FOUR_COUNT * FOUR_SINGLE_GROUP_COUNT; i++) {
            formatPlayCardEnumerationListTemp.add(formatPlayCardEnumerationList.get(i));
        }
        final int FOUR_DUPLICATE_COUNT = 4;
        List<List<Integer>> bigFourList = findBigSameValueWithCountInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, FOUR_DUPLICATE_COUNT);

        List<List<Integer>> pairList = findSameValueWithCountInFormatHandCardListForThree(formatHandCardEnumerationList, PAIR_COUNT);

        final int GROUP_COUNT = 2;
        return mergeBigFirstPartWithRestPartByGroupCountInFormatHandCardListForThree(formatHandCardEnumerationList, bigFourList, pairList, GROUP_COUNT);
    }

    private static List<List<Integer>> findBigBombInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int BOMB_DUPLICATE_COUNT = 4;
        return findBigSameValueWithCountInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, BOMB_DUPLICATE_COUNT);
    }

    private static List<List<Integer>> findBombKingInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
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

    private static List<List<Integer>> mergeTipLists(List<List<Integer>>... tipLists) {
        List<List<Integer>> tipList = null;
        for (int i = 0; i < tipLists.length; i++) {
            if (!CollectionUtils.isEmpty(tipLists[i])) {
                if (null == tipList) {
                    tipList = tipLists[i];
                }
                else {
                    tipList.addAll(tipLists[i]);
                }
            }
        }
        return tipList;
    }
}
