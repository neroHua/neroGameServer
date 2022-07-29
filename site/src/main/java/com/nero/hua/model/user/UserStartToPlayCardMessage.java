package com.nero.hua.model.user;

import com.nero.hua.enumeration.MessageTypeEnumeration;
import com.nero.hua.model.base.BaseMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserStartToPlayCardMessage extends BaseMessage {

    private String userId;

    public UserStartToPlayCardMessage(String userId) {
        super(MessageTypeEnumeration.USER_START_TO_PLAY_CARD);
        this.userId = userId;
    }
}
