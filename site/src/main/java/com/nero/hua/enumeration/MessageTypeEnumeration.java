package com.nero.hua.enumeration;

import lombok.Getter;

@Getter
public enum MessageTypeEnumeration {

    CHANGE_USER_PREPARE_STATUS("changeUserPrepareStatus", "用户改变准备状态"),
    DEAL_CARD("dealCard", "发牌");

    private String code;
    private String message;

    MessageTypeEnumeration(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
