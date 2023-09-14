package com.nero.hua.game.tip;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.GameTypeEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import com.nero.hua.game.card.type.GamePlayCardTypeForThree;
import org.springframework.util.CollectionUtils;

import java.util.*;

public abstract class AbstractGameTip implements GameTip {

    private GameTypeEnumeration gameTypeEnumeration;

    protected Map<PlayCardTypeEnumeration, PlayCardTypeTip> playCardTypEnumeratioPlayCardTypeTipMap;

    public AbstractGameTip(GameTypeEnumeration gameTypeEnumeration) {
        this.gameTypeEnumeration = gameTypeEnumeration;
        this.playCardTypEnumeratioPlayCardTypeTipMap = new HashMap<>();
    }

    protected List<List<Integer>> mergeTipLists(List<List<Integer>> samePlayCardTypeTipList, List<List<List<Integer>>> bigPlayCardTypeTipLists) {
        List<List<Integer>> tipList = null;
        if (!CollectionUtils.isEmpty(samePlayCardTypeTipList)) {
            tipList = samePlayCardTypeTipList;
        }
        for (List<List<Integer>> bigPlayCardTypeTipList : bigPlayCardTypeTipLists) {
            if (!CollectionUtils.isEmpty(bigPlayCardTypeTipList)) {
                if (null == tipList) {
                    tipList = bigPlayCardTypeTipList;
                }
                else {
                    tipList.addAll(bigPlayCardTypeTipList);
                }
            }
        }
        return tipList;
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
