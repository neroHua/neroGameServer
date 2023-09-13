package com.nero.hua.game.card.type;

import com.nero.hua.card.type.validate.PlayCardTypeValidate;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.*;

public abstract class BaseGamePlayCardType implements GamePlayCardType {

    protected final Map<PlayCardTypeEnumeration, PlayCardTypeValidate> availablePlayCardTypeEnumerationMap;

    public BaseGamePlayCardType() {
        this.availablePlayCardTypeEnumerationMap = new HashMap<>();
    }

    @Override
    public Set<PlayCardTypeEnumeration> getAvailablePlayCardTypeSet() {
        Set<PlayCardTypeEnumeration> copyedAvaiablePlayCardTypeEnumerationSet = new HashSet<>();
        for (PlayCardTypeEnumeration avaiablePlayCardTypeEnumeration : availablePlayCardTypeEnumerationMap.keySet()) {
            copyedAvaiablePlayCardTypeEnumerationSet.add(avaiablePlayCardTypeEnumeration);
        }
        return copyedAvaiablePlayCardTypeEnumerationSet;
    }

    @Override
    public Set<PlayCardTypeEnumeration> getBigAvailablePlayCardTypeSet(PlayCardTypeEnumeration playCardTypeEnumeration) {
        Set<PlayCardTypeEnumeration> bigAvaiablePlayCardTypeEnumerationSet = new HashSet<>();
        for (PlayCardTypeEnumeration avaiablePlayCardTypeEnumeration : availablePlayCardTypeEnumerationMap.keySet()) {
            if (avaiablePlayCardTypeEnumeration.getValue() > playCardTypeEnumeration.getValue()) {
                bigAvaiablePlayCardTypeEnumerationSet.add(avaiablePlayCardTypeEnumeration);
            }
        }
        return bigAvaiablePlayCardTypeEnumerationSet;
    }

    @Override
    public Boolean thisPlayCardTypeAvailable(PlayCardTypeEnumeration playCardTypeEnumeration) {
        return availablePlayCardTypeEnumerationMap.keySet().contains(playCardTypeEnumeration);
    }

    @Override
    public Boolean thisPlayCardTypeNotAvailable(PlayCardTypeEnumeration playCardTypeEnumeration) {
        return !this.thisPlayCardTypeAvailable(playCardTypeEnumeration);
    }

    @Override
    public Boolean thisFormatPlayCardListMatchPlayCardType(List<CardEnumeration> formatPlayCardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration) {
        if (this.thisPlayCardTypeNotAvailable(playCardTypeEnumeration)) {
            return Boolean.FALSE;
        }

        return this.availablePlayCardTypeEnumerationMap.get(playCardTypeEnumeration).match(formatPlayCardEnumerationList);
    }

    @Override
    public Boolean thisFormatPlayCardListNotMatchPlayCardType(List<CardEnumeration> formatPlayCardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration) {
        return !this.thisFormatPlayCardListMatchPlayCardType(formatPlayCardEnumerationList, playCardTypeEnumeration);
    }

    @Override
    public Boolean firstFormatPlayCardListBigThanSecondFormatPlayCardList(List<CardEnumeration> firstFormatPlayCardEnumerationList,
                                                                          PlayCardTypeEnumeration firstPlayCardTypeEnumeration,
                                                                          List<CardEnumeration> secondFormatPlayCardEnumerationList,
                                                                          PlayCardTypeEnumeration secondPlayCardTypeEnumeration) {
        if (thisPlayCardTypeNotAvailable(firstPlayCardTypeEnumeration) || thisPlayCardTypeNotAvailable(secondPlayCardTypeEnumeration)) {
            return Boolean.FALSE;
        }

        if (firstPlayCardTypeEnumeration.getValue() < secondPlayCardTypeEnumeration.getValue()) {
            return Boolean.FALSE;
        }
        else if (firstPlayCardTypeEnumeration.getValue() > secondPlayCardTypeEnumeration.getValue()) {
            return Boolean.TRUE;
        }
        else {
            if (firstPlayCardTypeEnumeration == secondPlayCardTypeEnumeration
                    && firstFormatPlayCardEnumerationList.size() == secondFormatPlayCardEnumerationList.size()) {
                return firstFormatPlayCardEnumerationList.get(0).getValue() > secondFormatPlayCardEnumerationList.get(0).getValue();
            }
            else {
                return Boolean.FALSE;
            }
        }
    }

    @Override
    public PlayCardTypeEnumeration generalCalculatePlayCardType(List<CardEnumeration> formatPlayCardEnumerationList) {
        Set<PlayCardTypeEnumeration> playCardTypeEnumerationSet = this.availablePlayCardTypeEnumerationMap.keySet();

        List<PlayCardTypeEnumeration> playCardTypeEnumerationList = new ArrayList<>(playCardTypeEnumerationSet);
        for (int i = 0 ; i < playCardTypeEnumerationList.size() - 1; i++) {
            for (int j = i + 1; j < playCardTypeEnumerationList.size(); j++) {
                if (playCardTypeEnumerationList.get(j).getValue() > playCardTypeEnumerationList.get(i).getValue()) {
                    PlayCardTypeEnumeration tempPlayCardTypeEnumeration = playCardTypeEnumerationList.get(j);
                    playCardTypeEnumerationList.set(j, playCardTypeEnumerationList.get(i));
                    playCardTypeEnumerationList.set(i, tempPlayCardTypeEnumeration);
                }
            }
        }

        for (int i = 0; i < playCardTypeEnumerationList.size(); i++ ) {
            if (this.availablePlayCardTypeEnumerationMap.get(playCardTypeEnumerationList.get(i)).match(formatPlayCardEnumerationList)) {
                return playCardTypeEnumerationList.get(i);
            }
        }
        return null;
    }

}
