package com.nero.hua.model.user;

import com.nero.hua.enumeration.MessageTypeEnumeration;
import com.nero.hua.model.base.BaseMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDoNotPlayCardMessage extends BaseMessage {

    private String userId;

    public UserDoNotPlayCardMessage(String userId) {
        super(MessageTypeEnumeration.USER_DO_NOT_PLAY_CARD);
        this.userId = userId;
    }
}
