package com.nero.hua.model.user;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class PlayCardRoundMO {

    private int currentTurnUserIndex;

    List<UserPlayCardTurnMO> userPlayCardTurnMOList = new LinkedList<>();

    public void addNewUserToStartPlayCard(int userIndex, String userId) {
        this.currentTurnUserIndex = userIndex;
        userPlayCardTurnMOList.add(new UserPlayCardTurnMO(userIndex, userId));
    }

    public boolean thisRoundFinish(int maxUserCount) {
        if (this.userPlayCardTurnMOList.size() < maxUserCount) {
            return Boolean.FALSE;
        }

        for (int i = 0; i < maxUserCount - 1; i++) {
            if (this.userPlayCardTurnMOList.get(this.userPlayCardTurnMOList.size() - 1 - i).userDoPlayCard()) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

}
