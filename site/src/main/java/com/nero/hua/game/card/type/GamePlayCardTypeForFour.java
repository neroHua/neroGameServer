package com.nero.hua.game.card.type;

import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class GamePlayCardTypeForFour extends BaseGamePlayCardType {

    public GamePlayCardTypeForFour() {

        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.SINGLE);

        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.PAIR);
        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.PAIR_STRAIGHT);

        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.TRIPLE);
        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.TRIPLE_PAIR);

        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.AIRPLANE);
        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT);

        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.BOMB);
        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.BOMB_FIVE);
        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.BOMB_SIX);
        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.BOMB_SEVEN);
        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.BOMB_EIGHT);

        availablePlayCardTypeEnumerationSet.add(PlayCardTypeEnumeration.BOMB_KING_FOUR_MAX);    }

}
