package com.nero.hua.model.user;

import com.nero.hua.enumeration.MessageTypeEnumeration;
import com.nero.hua.model.base.BaseMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserWinMessage extends BaseMessage {

    private String userId;

    public UserWinMessage(String userId) {
        super(MessageTypeEnumeration.USER_WIN);
        this.userId = userId;
    }
}
