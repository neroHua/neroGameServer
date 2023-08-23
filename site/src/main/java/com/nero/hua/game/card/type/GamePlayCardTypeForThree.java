package com.nero.hua.game.card.type;

import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class GamePlayCardTypeForThree extends BaseGamePlayCardType {

    public GamePlayCardTypeForThree() {
        avaiablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.SINGLE);
        avaiablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.STRAIGHT);
        avaiablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.PAIR);
        avaiablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.PAIR_STRAIGHT);
        avaiablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.TRIPLE);
        avaiablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.TRIPLE_SINGLE);
        avaiablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.TRIPLE_PAIR);
        avaiablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.AIRPLANE);
        avaiablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.AIRPLANE_SINGLE);
        avaiablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.AIRPLANE_PAIR);
        avaiablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT);
        avaiablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.FOUR_SINGLE);
        avaiablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.FOUR_PAIR);
        avaiablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.BOMB);
        avaiablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.BOMB_KING);
    }

}
