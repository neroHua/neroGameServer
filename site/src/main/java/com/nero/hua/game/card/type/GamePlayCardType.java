package com.nero.hua.game.card.type;

import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.Set;

public interface GamePlayCardType {

    Set<PlayCardTypeEnumeration> getAvaiablePlayCardTypeSet();

    Set<PlayCardTypeEnumeration> getBigAvaiablePlayCardTypeSet(PlayCardTypeEnumeration playCardTypeEnumeration);

    Boolean thisPlayCardTypeAvaiable(PlayCardTypeEnumeration playCardTypeEnumeration);

}
