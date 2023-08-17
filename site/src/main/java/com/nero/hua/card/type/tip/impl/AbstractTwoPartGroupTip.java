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

public abstract class AbstractTwoPartGroupTip extends PlayCardTypeImpl implements PlayCardTypeTip {

    public AbstractTwoPartGroupTip(PlayCardTypeEnumeration playCardTypeEnumeration) {
        super(playCardTypeEnumeration);
    }

    protected List<List<Integer>> mergeBigFirstPartWithRestPartByGroupCountInFormatHandCardListForThree(List<CardEnumeration> formatHandCardEnumerationList, List<List<Integer>> bigFirstPartList, List<List<Integer>> restPartList, int groupCount) {
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

    private boolean firstPartDoNotHasRestPart(List<CardEnumeration> formatHandCardEnumerationList,
                                       Set<Integer> bigFirstPartSet, Set<Integer> bigFirstPartValueSet, List<List<Integer>> restPartList, List<Integer> helpChoseRestPartList) {
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

    private void iteratorForChoseRestPart(List<List<Integer>> restPartList, List<Integer> helpChoseRestPartList, int groupCount) {
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

    private boolean endForChoseRestPart(List<List<Integer>> restPartList, List<Integer> helpChoseRestPartList, int count) {
        return helpChoseRestPartList.get(0) > restPartList.size() - count ? Boolean.FALSE : Boolean.TRUE;
    }
}
