package com.nero.hua.game.card.type;

import com.nero.hua.card.type.validate.impl.*;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class GamePlayCardTypeForThree extends BaseGamePlayCardType {

    public GamePlayCardTypeForThree() {
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.SINGLE, new SingleValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.STRAIGHT, new StraightValidate());

        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.PAIR, new PairValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.PAIR_STRAIGHT, new PairStraightValidate());

        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.TRIPLE, new TripleValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.TRIPLE_SINGLE, new TripleSingleValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.TRIPLE_PAIR, new TriplePairValidate());

        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.AIRPLANE, new AirplaneValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.AIRPLANE_SINGLE, new AirplaneSingleValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.AIRPLANE_PAIR, new AirplanePairValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT, new AirplanePairStraightValidate());

        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.FOUR_SINGLE, new FourSingleValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.FOUR_PAIR, new FourPairValidate());

        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB, new BombValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_KING, new BombKingValidate());
    }

}
