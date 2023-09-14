package com.nero.hua.game.tip;

import com.nero.hua.card.type.tip.impl.*;
import com.nero.hua.enumeration.GameTypeEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class GameTipForFour extends AbstractGameTip {

    public GameTipForFour() {
        super(GameTypeEnumeration.FIGHT_LANDLORD_FOR_FOUR);
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

        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.BOMB_KING_FOUR_MAX, new BombKingFourMaxTip());
    }

}
