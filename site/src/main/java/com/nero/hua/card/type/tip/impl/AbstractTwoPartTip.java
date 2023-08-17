package com.nero.hua.card.type.tip.impl;

import com.nero.hua.card.type.PlayCardTypeImpl;
import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractTwoPartTip extends PlayCardTypeImpl implements PlayCardTypeTip {

    private final int BIG_FIRST_PART_DUPLICATE_COUNT;

    public AbstractTwoPartTip(PlayCardTypeEnumeration playCardTypeEnumeration, int BIG_FIRST_PART_DUPLICATE_COUNT) {
        super(playCardTypeEnumeration);
        this.BIG_FIRST_PART_DUPLICATE_COUNT = BIG_FIRST_PART_DUPLICATE_COUNT;
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        List<List<Integer>> bigFirstPartList = findBigFirstPartList(formatHandCardEnumerationList, formatPlayCardEnumerationList);

        List<List<Integer>> secondPartList = findSecondPartList(formatHandCardEnumerationList);

        return mergeBigFirstPartWithRestPartInFormatHandCardListForThree(formatHandCardEnumerationList, bigFirstPartList, secondPartList);
    }

    private List<List<Integer>> findBigFirstPartList(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList) {
        return PlayCardTypeTipUtil.findBigSameValueWithCountInFormatHandCardListForThree(formatHandCardEnumerationList, formatPlayCardEnumerationList, BIG_FIRST_PART_DUPLICATE_COUNT);
    }

    abstract List<List<Integer>> findSecondPartList(List<CardEnumeration> formatHandCardEnumerationList);

    private List<List<Integer>> mergeBigFirstPartWithRestPartInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<List<Integer>> bigFirstPartList, List<List<Integer>> restPartList) {
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

    private boolean firstPartHasRestPart(List<CardEnumeration> formatHandCardEnumerationList, Set<Integer> bigFirstPartSet, Set<Integer> bigFirstPartValueSet, List<Integer> restPart) {
        for (Integer restIndex : restPart) {
            if (bigFirstPartSet.contains(restIndex) || bigFirstPartValueSet.contains(formatHandCardEnumerationList.get(restIndex).getValue())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

}
