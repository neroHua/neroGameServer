package com.nero.hua.game.tip;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.GameTypeEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class PlayCardTip {

    public static List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration, GameTypeEnumeration gameTypeEnumeration) {
        if (GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE == gameTypeEnumeration) {
            return tipForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, playCardTypeEnumeration);
        }
        return null;
    }

    private static List<List<Integer>> tipForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration) {
        if (PlayCardTypeEnumeration.SINGLE == playCardTypeEnumeration) {
            return findBigSingleInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
        }
        else if (PlayCardTypeEnumeration.STRAIGHT == playCardTypeEnumeration) {
            return findBigStraightInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
        }
        else if (PlayCardTypeEnumeration.PAIR == playCardTypeEnumeration) {
            return findBigPairInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
        }
        else if (PlayCardTypeEnumeration.PAIR_STRAIGHT == playCardTypeEnumeration) {
            return findBigPairStraightInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
        }
        else if (PlayCardTypeEnumeration.TRIPLE == playCardTypeEnumeration) {
            return findBigTripleInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
        }
        else if (PlayCardTypeEnumeration.TRIPLE_SINGLE == playCardTypeEnumeration) {
            return findBigTripleSingleInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
        }
        else if (PlayCardTypeEnumeration.TRIPLE_PAIR == playCardTypeEnumeration) {
            return findBigTriplePairInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
        }
        else if (PlayCardTypeEnumeration.BOMB == playCardTypeEnumeration) {
            return findBigBombInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList);
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
            if (cardCurrent.getValue() <= formatPlayCardEnumerationList.get(0).getValue()) {
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
        if (CardEnumeration.CARD_114.getValue() == formatPlayCardEnumerationList.get(0).getValue()) {
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

            if (cardCurrent.getValue() <= formatPlayCardEnumerationList.get(PLAY_CARD_SIZE - 1).getValue()) {
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

        return findBigTripleSingleInFormatHandCardListForThree(formatHandCardEnumerationList, bigTripleList, singleList);
    }

    private static List<List<Integer>> findSingleInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList) {
        List<List<Integer>> singleList = new ArrayList<>();
        for (int i = 0; i < formatHandCardEnumerationList.size(); i++) {
            List<Integer> single = Arrays.asList(i);
            singleList.add(single);
        }

        return singleList;
    }

    private static List<List<Integer>> findBigTripleSingleInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<List<Integer>> bigTripleList, List<List<Integer>> singleList) {
        if (CollectionUtils.isEmpty(bigTripleList) || CollectionUtils.isEmpty(singleList)) {
            return null;
        }

        List<List<Integer>> bigTripleSingleList = new ArrayList<>();
        for (int i = bigTripleList.size() - 1; i >= 0; i--) {
            List<Integer> bigTriple = bigTripleList.get(i);
            Set<Integer> bigTripleSet = new HashSet<>();
            Set<Integer> bigTripleValueSet = new HashSet<>();
            for (int j = 0; j < bigTriple.size(); j++) {
                bigTripleSet.add(bigTriple.get(j));
                bigTripleValueSet.add(formatHandCardEnumerationList.get(bigTriple.get(j)).getValue());
            }

            for (int j = singleList.size() - 1; j >= 0 ; j--) {
                if(tripleHasThisPart(formatHandCardEnumerationList, bigTripleSet, bigTripleValueSet, singleList.get(j))) {
                    continue;
                }
                List<Integer> bigTripleSingle = new ArrayList<>();
                bigTripleSingle.addAll(bigTriple);
                bigTripleSingle.addAll(singleList.get(j));
                bigTripleSingleList.add(bigTripleSingle);
            }
        }

        return bigTripleSingleList;
    }

    private static boolean tripleHasThisPart(List<CardEnumeration> formatHandCardEnumerationList, Set<Integer> bigTripleSet, Set<Integer> bigTripleValueSet, List<Integer> single) {
        for (Integer singleIndex : single) {
            if (bigTripleSet.contains(singleIndex) || bigTripleValueSet.contains(formatHandCardEnumerationList.get(singleIndex).getValue())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private static List<List<Integer>> findBigTriplePairInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int TRIPLE_DUPLICATE_COUNT = 3;
        List<List<Integer>> bigTripleList = findBigSameValueWithCountInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, TRIPLE_DUPLICATE_COUNT);

        final int PAIR_DUPLICATE_COUNT = 2;
        List<List<Integer>> pairList = findBigSameValueStraightByCountInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, PAIR_DUPLICATE_COUNT);
        return findBigTriplePairInFormatHandCardListForThree(formatHandCardEnumerationList, bigTripleList, pairList);
    }

    private static List<List<Integer>> findBigTriplePairInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<List<Integer>> bigTripleList, List<List<Integer>> bigPairList) {
        return null;
    }

    private static List<List<Integer>> findBigBombInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        final int BOMB_DUPLICATE_COUNT = 4;
        return findBigSameValueWithCountInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, BOMB_DUPLICATE_COUNT);
    }

}
