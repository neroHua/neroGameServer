package com.nero.hua.model.base;

import com.nero.hua.enumeration.MessageTypeEnumeration;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseMessage {

    private MessageTypeEnumeration messageTypeEnumeration;

    public BaseMessage(MessageTypeEnumeration messageTypeEnumeration) {
        this.messageTypeEnumeration = messageTypeEnumeration;
    }
}
