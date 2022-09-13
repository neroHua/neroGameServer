package com.nero.hua.enumeration;

import lombok.Getter;

@Getter
public enum GameTypeEnumeration {

    FIGHT_LANDLORD_FOR_THREE("fight_landlord_for_three", "三人斗地主"),

    FIGHT_LANDLORD_FOR_FIVE("fight_landlord_for_five", "五人斗地主逮狗腿子");

    private String code;
    private String description;

    GameTypeEnumeration(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
