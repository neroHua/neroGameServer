package com.nero.hua.model.user;

import com.nero.hua.enumeration.MessageTypeEnumeration;
import com.nero.hua.model.base.BaseMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserStartRobLandlordMessage extends BaseMessage {

    private String userId;

    public UserStartRobLandlordMessage(String userId) {
        super(MessageTypeEnumeration.USER_START_ROB_LANDLORD);
        this.userId = userId;
    }
}
