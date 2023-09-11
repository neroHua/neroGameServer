package com.nero.hua.game.card.type;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;
import java.util.Set;

public interface GamePlayCardType {

    Set<PlayCardTypeEnumeration> getAvailablePlayCardTypeSet();

    Set<PlayCardTypeEnumeration> getBigAvailablePlayCardTypeSet(PlayCardTypeEnumeration playCardTypeEnumeration);

    Boolean thisPlayCardTypeAvailable(PlayCardTypeEnumeration playCardTypeEnumeration);

    Boolean thisPlayCardTypeNotAvailable(PlayCardTypeEnumeration playCardTypeEnumeration);

    Boolean firstPlayCardBigThanSecondPlayCard(List<CardEnumeration> firstFormatPlayCardEnumerationList,
                                                           PlayCardTypeEnumeration firstPlayCardTypeEnumeration,
                                                           List<CardEnumeration> secondFormatPlayCardEnumerationList,
                                                           PlayCardTypeEnumeration secondPlayCardTypeEnumeration);

}
