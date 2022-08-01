package com.nero.hua.model.user;

import com.nero.hua.enumeration.CardEnumeration;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserPlayCardTurnMO {

    private final int userIndex;

    private final String userId;

    private List<CardEnumeration> cardList;

    public UserPlayCardTurnMO(int userIndex, String userId) {
        this.userIndex = userIndex;
        this.userId = userId;
    }

    public boolean userDoNotPlayCard() {
        return null == cardList ? Boolean.TRUE : Boolean.FALSE;
    }

}
