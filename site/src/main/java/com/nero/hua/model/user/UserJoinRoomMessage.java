package com.nero.hua.model.user;

import com.nero.hua.enumeration.MessageTypeEnumeration;
import com.nero.hua.model.base.BaseMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserJoinRoomMessage extends BaseMessage {

    private String userId;

    public UserJoinRoomMessage(String userId) {
        super(MessageTypeEnumeration.USER_JOIN_ROOM);
        this.userId = userId;
    }
}
