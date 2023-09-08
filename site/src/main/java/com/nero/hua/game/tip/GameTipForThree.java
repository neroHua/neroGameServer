package com.nero.hua.game.tip;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.card.type.tip.impl.*;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.GameTypeEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import com.nero.hua.game.card.type.GamePlayCardTypeForThree;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameTipForThree extends AbstractGameTip {

    public GameTipForThree() {
        super(GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.SINGLE, new SingleTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.STRAIGHT, new StraightTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.PAIR, new PairTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.PAIR_STRAIGHT, new PairStraightTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.TRIPLE, new TripleTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.TRIPLE_SINGLE, new TripleSingleTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.TRIPLE_PAIR, new TriplePairTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.AIRPLANE, new AirplaneTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.AIRPLANE_SINGLE, new AirplaneSingleTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.AIRPLANE_PAIR, new AirplanePairTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.AIRPLANE_PAIR_STRAIGHT, new AirplanePairStraightTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.FOUR_SINGLE, new FourSingleTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.FOUR_PAIR, new FourPairTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.BOMB, new BombTip());
        playCardTypEnumeratioPlayCardTypeTipMap.put(PlayCardTypeEnumeration.BOMB_KING, new BombKingTip());
    }

    @Override
    public List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration) {
        PlayCardTypeTip playCardTypeTip = playCardTypEnumeratioPlayCardTypeTipMap.get(playCardTypeEnumeration);
        List<List<Integer>> samePlayCardTypeTipList = playCardTypeTip.tip(formatHandCardEnumerationList, formatPlayCardEnumerationList);

        List<List<List<Integer>>> bigPlayCardTypeTipLists = new ArrayList<>();
        Set<PlayCardTypeEnumeration> bigAvaiablePlayCardTypeSet = new GamePlayCardTypeForThree().getBigAvailablePlayCardTypeSet(playCardTypeEnumeration);
        for (PlayCardTypeEnumeration bigPlayCardTypeEnumeration : bigAvaiablePlayCardTypeSet) {
            PlayCardTypeTip bigPlayCardTypeTip = playCardTypEnumeratioPlayCardTypeTipMap.get(bigPlayCardTypeEnumeration);
            bigPlayCardTypeTipLists.add(bigPlayCardTypeTip.tip(formatHandCardEnumerationList, null));
        }

        return mergeTipLists(samePlayCardTypeTipList, bigPlayCardTypeTipLists);
    }

}
