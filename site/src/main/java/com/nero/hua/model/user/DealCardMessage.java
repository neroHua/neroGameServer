package com.nero.hua.model.user;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.MessageTypeEnumeration;
import com.nero.hua.model.base.BaseMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DealCardMessage extends BaseMessage {

    private List<CardEnumeration> cardEnumerationList;

    public DealCardMessage(List<CardEnumeration> cardEnumerationList) {
        super(MessageTypeEnumeration.DEAL_CARD);
        this.cardEnumerationList = cardEnumerationList;
    }
}
