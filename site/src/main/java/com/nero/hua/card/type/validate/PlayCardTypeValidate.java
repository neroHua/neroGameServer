package com.nero.hua.card.type.validate;

import com.nero.hua.enumeration.CardEnumeration;

import java.util.List;

public interface PlayCardTypeValidate {

    Boolean match(List<CardEnumeration> formatPlayCardEnumerationList);

}
