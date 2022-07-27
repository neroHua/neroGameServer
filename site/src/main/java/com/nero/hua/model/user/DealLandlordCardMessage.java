package com.nero.hua.model.user;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.MessageTypeEnumeration;
import com.nero.hua.model.base.BaseMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DealLandlordCardMessage extends BaseMessage {

    private String userId;
    private List<CardEnumeration> cardEnumerationList;

    public DealLandlordCardMessage(String userId, List<CardEnumeration> cardEnumerationList) {
        super(MessageTypeEnumeration.DEAL_LANDLORD_CARD);
        this.userId = userId;
        this.cardEnumerationList = cardEnumerationList;
    }
}
