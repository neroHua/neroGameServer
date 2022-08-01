package com.nero.hua.enumeration;

import lombok.Getter;

@Getter
public enum RobLandlordEnumeration {

    NOT_TIME_TO_ROB("notTimeToRob", "不是抢地主的时候"),
    NOT_YOUR_TURN_TO_ROB("notYourTurnToRob", "不是您抢地主的轮次"),
    NOT_YOUR_TURN_TO_NOT_ROB("notYourTurnToNotRob", "不是您不抢地主的轮次");

    private String code;
    private String message;

    RobLandlordEnumeration(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
