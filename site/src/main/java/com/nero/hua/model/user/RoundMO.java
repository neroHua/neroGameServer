package com.nero.hua.model.user;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class RoundMO {

    private int currentTurnUserIndex;

    List<UserPlayCardTurnMO> turnMOList = new LinkedList<>();

    public RoundMO(int currentTurnUserIndex) {
        this.currentTurnUserIndex = currentTurnUserIndex;
    }

    public boolean thisRoundFinish(int maxUserCount) {
        if (this.turnMOList.size() < maxUserCount) {
            return Boolean.FALSE;
        }

        int size = this.turnMOList.size();
        return turnMOList.get(size - 1).userDoNotPlayCard() && turnMOList.get(size - 1).userDoNotPlayCard();
    }
}
