package com.nero.hua.game.tip;

import com.nero.hua.enumeration.GameTypeEnumeration;
import org.springframework.util.CollectionUtils;

import java.util.List;

public abstract class AbstractGameTip implements GameTip {

    GameTypeEnumeration gameTypeEnumeration;

    public AbstractGameTip(GameTypeEnumeration gameTypeEnumeration) {
        this.gameTypeEnumeration = gameTypeEnumeration;
    }

    protected List<List<Integer>> mergeTipLists(List<List<Integer>>... tipLists) {
        List<List<Integer>> tipList = null;
        for (int i = 0; i < tipLists.length; i++) {
            if (!CollectionUtils.isEmpty(tipLists[i])) {
                if (null == tipList) {
                    tipList = tipLists[i];
                }
                else {
                    tipList.addAll(tipLists[i]);
                }
            }
        }
        return tipList;
    }
}
