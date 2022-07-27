package com.nero.hua.model.user;

import com.nero.hua.enumeration.MessageTypeEnumeration;
import com.nero.hua.model.base.BaseMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDoNotRobLandlordMessage extends BaseMessage {

    private String userId;

    public UserDoNotRobLandlordMessage(String userId) {
        super(MessageTypeEnumeration.USER_DO_NOT_ROB_LANDLORD);
        this.userId = userId;
    }
}
