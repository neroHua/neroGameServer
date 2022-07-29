package com.nero.hua.model.user;

import com.nero.hua.enumeration.CardEnumeration;
import lombok.Getter;

import java.util.List;

public class UserPlayCardTurnMO {

    @Getter
    private final int userIndex;

    private List<CardEnumeration> cardList;

    public UserPlayCardTurnMO(int userIndex) {
        this.userIndex = userIndex;
    }

    public boolean userDoNotPlayCard() {
        return null == cardList ? Boolean.TRUE : Boolean.FALSE;
    }

}
