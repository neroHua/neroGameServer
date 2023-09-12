package com.nero.hua.game.card.type;

import com.nero.hua.card.type.validate.impl.*;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class GamePlayCardTypeForFive extends BaseGamePlayCardType {

    public GamePlayCardTypeForFive() {
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.SINGLE, new SingleValidate());

        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.PAIR, new PairValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.PAIR_STRAIGHT, new PairStraightValidate());

        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.TRIPLE, new TripleValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.TRIPLE_PAIR, new TriplePairValidate());

        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.AIRPLANE, new AirplaneValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.AIRPLANE_PAIR, new AirplanePairValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT, new AirplanePairStraightValidate());

        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB, new BombValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_FIVE, new BombFiveValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_SIX, new BombSixValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_SEVEN, new BombSevenValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_EIGHT, new BombEightValidate());

        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_NINE, new BombNineValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_TEN, new BombTenValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_ELEVEN, new BombElevenValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_TWELVE, new BombTwelveValidate());

        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_KING_THREE_SMALL, new BombKingThreeSmallValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_KING_THREE_BIG, new BombKingThreeBigValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_KING_FOUR, new BombKingFourValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_KING_FIVE, new BombKingFiveValidate());
        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.BOMB_KING_SIX, new BombKingSixValidate());

        availablePlayCardTypeEnumerationMap.put(PlayCardTypeEnumeration.INVINCIBLE, new InvincibleValidate());
    }

}
