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
    AIRPLANE_PAIR_STRAIGHT("airplanePairStraight", 0, "飞机带顺对"),

    FOUR_SINGLE("fourSingle", 0, "4带2"),
    FOUR_PAIR("fourPair", 0, "4带2对"),

    BOMB("bomb", 1, "炸弹"),
    BOMB_KING("bombKing", 2, "王炸"),

    BOMB_FIVE("bombFive", 3, "炸弹5"),
    BOMB_KING_THREE_SMALL("bombKingThreeSmall", 4, "王炸3小王"),

    BOMB_SIX("bombSix", 5, "炸弹6"),
    BOMB_KING_THREE_BIG("bombKingThreeBig", 6, "王炸3大王"),

    BOMB_SEVEN("bombSeven", 7, "炸弹7"),
    BOMB_EIGHT("bombEight", 8, "炸弹8"),
    BOMB_KING_FOUR("bombKingFour", 9, "王炸4个王"),
    BOMB_KING_FOUR_MAX("bombKingFourMax", 10, "王炸4大至尊"),

    BOMB_NINE("bombNine", 11, "炸弹9"),
    BOMB_TEN("bombTen", 12, "炸弹10"),
    BOMB_KING_FIVE("bombKingFive", 13, "王炸5个王"),

    BOMB_ELEVEN("bombEleven", 14, "炸弹11"),
    BOMB_TWELVE("bombTwelve", 15, "炸弹12"),
    BOMB_KING_SIX("bombKingSix", 16, "王炸6个王"),
    INVINCIBLE("invincible", 17, "无敌牌");

    private String code;
    private int value;
    private String message;

    PlayCardTypeEnumeration(String code, int value, String message) {
        this.code = code;
        this.value = value;
        this.message = message;
    }
}
