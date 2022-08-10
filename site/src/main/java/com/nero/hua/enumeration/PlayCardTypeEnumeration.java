package com.nero.hua.enumeration;

import lombok.Getter;

@Getter
public enum PlayCardTypeEnumeration {

    SINGLE("single", 0, "单牌"),
    STRAIGHT("straight", 0, "顺子"),

    PAIR("pair", 0, "对子"),
    PAIR_STRAIGHT("pairStraight", 0, "连对"),

    TRIPLE("triple", 0, "三不带"),
    TRIPLE_SINGLE("tripleSingle", 0, "三带一"),
    TRIPLE_PAIR("triplePair", 0, "三带一对"),

    AIRPLANE("airplane", 0, "飞机不带"),
    AIRPLANE_SINGLE("airplaneSingle", 0, "飞机带单"),
    AIRPLANE_PAIR("airplanePair", 0, "飞机带对"),

    FOUR_SINGLE("fourSingle", 0, "4带2"),
    FOUR_PAIR("fourPair", 0, "4带2对"),

    BOMB("bomb", 1, "炸弹"),
    BOMB_KING("bombKing", 2, "王炸");

    private String code;
    private int value;
    private String message;

    PlayCardTypeEnumeration(String code, int value, String message) {
        this.code = code;
        this.value = value;
        this.message = message;
    }
}
