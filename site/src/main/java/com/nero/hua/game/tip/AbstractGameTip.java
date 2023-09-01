package com.nero.hua.game.tip;

import com.nero.hua.card.type.tip.PlayCardTypeTip;
import com.nero.hua.enumeration.GameTypeEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
