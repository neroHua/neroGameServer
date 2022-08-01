package com.nero.hua.enumeration;

import lombok.Getter;

@Getter
public enum PlayCardEnumeration {

    NOT_TIME_TO_PLAY_CARD("notTimeToPlayCard", "不是出牌的时候"),
    NOT_YOUR_TURN("notYourTurn", "不是您的轮次"),
    NOT_YOUR_TURN_TO_PLAY_CARD("notYourTurnToRob", "不是您出牌的轮次"),
    NOT_YOUR_TURN_TO_NOT_PLAY_CARD("notYourTurnToNotRob", "不是您不出牌的轮次"),

    CARD_MISS("cardMiss", "缺少牌");

    private String code;
    private String message;

    PlayCardEnumeration(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
