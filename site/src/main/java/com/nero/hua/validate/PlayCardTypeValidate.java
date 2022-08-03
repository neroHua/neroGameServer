package com.nero.hua.validate;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;

import java.util.List;

public interface PlayCardTypeValidate {

    PlayCardTypeEnumeration getPlayCardTypeEnumeration();

    boolean match(List<CardEnumeration> cardEnumerationList);

}
