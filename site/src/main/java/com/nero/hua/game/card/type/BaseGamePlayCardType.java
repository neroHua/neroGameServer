package com.nero.hua.game.card.type;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class BaseGamePlayCardType implements GamePlayCardType {

    protected final Set<PlayCardTypeEnumeration> availablePlayCardTypeEnumerationSet;

    public BaseGamePlayCardType() {
        this.availablePlayCardTypeEnumerationSet = new HashSet<>();
    }

    @Override
    public Set<PlayCardTypeEnumeration> getAvailablePlayCardTypeSet() {
        Set<PlayCardTypeEnumeration> copyedAvaiablePlayCardTypeEnumerationSet = new HashSet<>();
        for (PlayCardTypeEnumeration avaiablePlayCardTypeEnumeration : availablePlayCardTypeEnumerationSet) {
            copyedAvaiablePlayCardTypeEnumerationSet.add(avaiablePlayCardTypeEnumeration);
        }
        return copyedAvaiablePlayCardTypeEnumerationSet;
    }

    @Override
    public Set<PlayCardTypeEnumeration> getBigAvailablePlayCardTypeSet(PlayCardTypeEnumeration playCardTypeEnumeration) {
        Set<PlayCardTypeEnumeration> bigAvaiablePlayCardTypeEnumerationSet = new HashSet<>();
        for (PlayCardTypeEnumeration avaiablePlayCardTypeEnumeration : availablePlayCardTypeEnumerationSet) {
            if (avaiablePlayCardTypeEnumeration.getValue() > playCardTypeEnumeration.getValue()) {
                bigAvaiablePlayCardTypeEnumerationSet.add(avaiablePlayCardTypeEnumeration);
            }
        }
        return bigAvaiablePlayCardTypeEnumerationSet;
    }

    @Override
    public Boolean thisPlayCardTypeAvailable(PlayCardTypeEnumeration playCardTypeEnumeration) {
        return availablePlayCardTypeEnumerationSet.contains(playCardTypeEnumeration);
    }

    @Override
    public Boolean firstPlayCardBigThanSecondPlayCard(List<CardEnumeration> firstFormatPlayCardEnumerationList,
                                                      PlayCardTypeEnumeration firstPlayCardTypeEnumeration,
                                                      List<CardEnumeration> secondFormatPlayCardEnumerationList,
                                                      PlayCardTypeEnumeration secondPlayCardTypeEnumeration) {
        if (!thisPlayCardTypeAvailable(firstPlayCardTypeEnumeration) || !thisPlayCardTypeAvailable(secondPlayCardTypeEnumeration)) {
            return Boolean.FALSE;
        }

        if (firstPlayCardTypeEnumeration.getValue() < secondPlayCardTypeEnumeration.getValue()) {
            return Boolean.FALSE;
        }
        else if (firstPlayCardTypeEnumeration.getValue() > secondPlayCardTypeEnumeration.getValue()) {
            return Boolean.TRUE;
        }
        else {
            if (firstPlayCardTypeEnumeration == secondPlayCardTypeEnumeration) {
                return firstFormatPlayCardEnumerationList.get(0).getValue() > secondFormatPlayCardEnumerationList.get(0).getValue();
            }
            else {
                return Boolean.FALSE;
            }
        }
    }

}
