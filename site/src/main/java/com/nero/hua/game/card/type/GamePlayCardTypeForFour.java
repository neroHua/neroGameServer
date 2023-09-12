package com.nero.hua.game.card.type;

import com.nero.hua.card.type.validate.impl.*;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class GamePlayCardTypeForFour extends BaseGamePlayCardType {

    public GamePlayCardTypeForFour() {
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.SINGLE, new SingleValidate());

        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.PAIR, new PairValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.PAIR_STRAIGHT, new PairStraightValidate());

        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.TRIPLE, new TripleValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.TRIPLE_PAIR, new TriplePairValidate());

        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.AIRPLANE, new AirplaneValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT, new AirplanePairStraightValidate());

        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB, new BombValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_FIVE, new BombFiveValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_SIX, new BombSixValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_SEVEN, new BombSevenValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_EIGHT, new BombEightValidate());

        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_KING_FOUR_MAX, new BombKingFourMaxValidate());
    }

}
