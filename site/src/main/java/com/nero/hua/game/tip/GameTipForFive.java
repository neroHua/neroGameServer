package com.nero.hua.game.tip;

import com.nero.hua.card.type.tip.impl.*;
import com.nero.hua.enumeration.GameTypeEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class GameTipForFive extends AbstractGameTip {

    public GameTipForFive() {
        super(GameTypeEnumeration.FIGHT_LANDLORD_FOR_FIVE);
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.SINGLE, new SingleTip());

        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.PAIR, new PairTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.PAIR_STRAIGHT, new PairStraightTip());

        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.TRIPLE, new TripleTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.TRIPLE_PAIR, new TriplePairTip());

        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.AIRPLANE, new AirplaneTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.AIRPLANE_PAIR, new AirplanePairTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT, new AirplanePairStraightTip());

        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.BOMB, new BombTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.BOMB_FIVE, new BombFiveTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.BOMB_SIX, new BombSixTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.BOMB_SEVEN, new BombSevenTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.BOMB_EIGHT, new BombEightTip());

        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.BOMB_NINE, new BombNineTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.BOMB_TEN, new BombTenTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.BOMB_ELEVEN, new BombElevenTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.BOMB_TWELVE, new BombTwelveTip());

        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.BOMB_KING_THREE_SMALL, new BombKingThreeSmallTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.BOMB_KING_THREE_BIG, new BombKingThreeBigTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.BOMB_KING_FOUR, new BombKingFourTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.BOMB_KING_FIVE, new BombKingFiveTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.BOMB_KING_SIX, new BombKingSixTip());

        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.INVINCIBLE, new InvincibleTip());
    }

}
