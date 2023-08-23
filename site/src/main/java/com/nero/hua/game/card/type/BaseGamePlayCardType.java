package com.nero.hua.game.card.type;

import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.HashSet;
import java.util.Set;

public abstract class BaseGamePlayCardType implements GamePlayCardType {

    protected final Set<PlayCardTypeEnumeration> avaiablePlayCardTypeEnumerationSet;

    public BaseGamePlayCardType() {
        this.avaiablePlayCardTypeEnumerationSet = new HashSet<>();
    }

    @Override
    public Set<PlayCardTypeEnumeration> getAvaiablePlayCardTypeSet() {
        Set<PlayCardTypeEnumeration> copyedAvaiablePlayCardTypeEnumerationSet = new HashSet<>();
        for (PlayCardTypeEnumeration avaiablePlayCardTypeEnumeration : avaiablePlayCardTypeEnumerationSet ) {
            copyedAvaiablePlayCardTypeEnumerationSet.add(avaiablePlayCardTypeEnumeration);
        }
        return copyedAvaiablePlayCardTypeEnumerationSet;
    }

    @Override
    public Set<PlayCardTypeEnumeration> getBigAvaiablePlayCardTypeSet(PlayCardTypeEnumeration playCardTypeEnumeration) {
        Set<PlayCardTypeEnumeration> bigAvaiablePlayCardTypeEnumerationSet = new HashSet<>();
        for (PlayCardTypeEnumeration avaiablePlayCardTypeEnumeration : avaiablePlayCardTypeEnumerationSet ) {
            if (avaiablePlayCardTypeEnumeration.getValue() > playCardTypeEnumeration.getValue()) {
                bigAvaiablePlayCardTypeEnumerationSet.add(avaiablePlayCardTypeEnumeration);
            }
        }
        return bigAvaiablePlayCardTypeEnumerationSet;
    }

    @Override
    public Boolean thisPlayCardTypeAvaiable(PlayCardTypeEnumeration playCardTypeEnumeration) {
        return avaiablePlayCardTypeEnumerationSet.contains(playCardTypeEnumeration);
    }

}
