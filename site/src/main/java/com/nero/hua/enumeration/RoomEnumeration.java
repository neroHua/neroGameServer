package com.nero.hua.enumeration;

import lombok.Getter;

@Getter
public enum RoomEnumeration {

    ROOM_NOT_FOUND("roomNotFound", "找不到房间"),
    ROOM_USER_FULL("roomUserFull", "房间满员");

    private String code;
    private String message;

    RoomEnumeration(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
