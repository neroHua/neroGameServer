package com.nero.hua.card.type.tip;

import com.nero.hua.enumeration.CardEnumeration;

import java.util.List;

public interface PlayCardTypeTip {

    List<List<Integer>> tip(List<CardEnumeration> formatHandCardEnumerationList, List<CardEnumeration> formatPlayCardEnumerationList);

}
