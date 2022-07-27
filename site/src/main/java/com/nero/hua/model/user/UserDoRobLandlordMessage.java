package com.nero.hua.model.user;

import com.nero.hua.enumeration.MessageTypeEnumeration;
import com.nero.hua.model.base.BaseMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDoRobLandlordMessage extends BaseMessage {

    private String userId;

    public UserDoRobLandlordMessage(String userId) {
        super(MessageTypeEnumeration.USER_DO_ROB_LANDLORD);
        this.userId = userId;
    }
}
