package com.nero.hua.game.card.type;

import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class GamePlayCardTypeForThree extends BaseGamePlayCardType {

    public GamePlayCardTypeForThree() {
        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.SINGLE);
        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.STRAIGHT);

        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.PAIR);
        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.PAIR_STRAIGHT);

        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.TRIPLE);
        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.TRIPLE_SINGLE);
        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.TRIPLE_PAIR);

        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.AIRPLANE);
        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.AIRPLANE_SINGLE);
        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.AIRPLANE_PAIR);
        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT);

        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.FOUR_SINGLE);
        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.FOUR_PAIR);

        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.BOMB);
        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.BOMB_KING);
    }

}
