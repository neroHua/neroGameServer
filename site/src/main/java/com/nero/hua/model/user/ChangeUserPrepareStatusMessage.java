package com.nero.hua.model.user;

import com.nero.hua.enumeration.MessageTypeEnumeration;
import com.nero.hua.model.base.BaseMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeUserPrepareStatusMessage extends BaseMessage {

    private String userId;

    private Boolean prepared;

    public ChangeUserPrepareStatusMessage(String userId, Boolean prepared) {
        super(MessageTypeEnumeration.CHANGE_USER_PREPARE_STATUS);
        this.userId = userId;
        this.prepared = prepared;
    }
}
