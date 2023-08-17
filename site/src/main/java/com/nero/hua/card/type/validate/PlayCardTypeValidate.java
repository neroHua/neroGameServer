package com.nero.hua.card.type.validate;

import com.nero.hua.enumeration.CardEnumeration;

import java.util.List;

public interface PlayCardTypeValidate {

    boolean match(List<CardEnumeration> cardEnumerationList);

}
