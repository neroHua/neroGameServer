package com.nero.hua.enumeration;

import lombok.Getter;

@Getter
public enum MessageTypeEnumeration {

    USER_JOIN_ROOM("userJoinRoom", "用户加入房间"),
    USER_LEAVE_ROOM("userLeaveRoom", "用户离开房间"),
    CHANGE_USER_PREPARE_STATUS("changeUserPrepareStatus", "用户改变准备状态"),
    DEAL_CARD("dealCard", "发牌"),
    USER_START_ROB_LANDLORD("userStartRobLandlord", "用户开始抢地主"),
    USER_DO_ROB_LANDLORD("userDoRobLandlord", "用户抢地主"),
    USER_DO_NOT_ROB_LANDLORD("userDoNotRobLandlord", "用户不抢地主"),
    DEAL_LANDLORD_CARD("dealLandlordCard", "发地主牌");

    private String code;
    private String message;

    MessageTypeEnumeration(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
