package com.nero.hua.model.user;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.MessageTypeEnumeration;
import com.nero.hua.model.base.BaseMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDoPlayCardMessage extends BaseMessage {

    private String userId;
    private List<CardEnumeration> cardEnumerationList;

    public UserDoPlayCardMessage(String userId, List<CardEnumeration> cardEnumerationList) {
        super(MessageTypeEnumeration.USER_DO_PLAY_CARD);
        this.userId = userId;
        this.cardEnumerationList = cardEnumerationList;
    }
}
