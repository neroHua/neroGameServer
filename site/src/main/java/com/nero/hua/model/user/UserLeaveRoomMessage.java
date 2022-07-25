package com.nero.hua.model.user;

import com.nero.hua.enumeration.MessageTypeEnumeration;
import com.nero.hua.model.base.BaseMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLeaveRoomMessage extends BaseMessage {

    private String userId;

    public UserLeaveRoomMessage(String userId) {
        super(MessageTypeEnumeration.USER_LEAVE_ROOM);
        this.userId = userId;
    }
}
