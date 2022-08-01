package com.nero.hua.model.user;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class RobLandlordRoundMO {

    private int currentTurnUserIndex;

    List<UserRobLandlordTurnMO> userRobLandlordTurnMOList = new LinkedList<>();

    public RobLandlordRoundMO(int currentTurnUserIndex, String userId) {
        this.currentTurnUserIndex = currentTurnUserIndex;
        this.userRobLandlordTurnMOList.add(new UserRobLandlordTurnMO(currentTurnUserIndex, userId));
    }

    public void addNewUserToStartRob(int currentTurnUserIndex, String userId) {
        this.currentTurnUserIndex = currentTurnUserIndex;
        this.userRobLandlordTurnMOList.add(new UserRobLandlordTurnMO(currentTurnUserIndex, userId));
    }

    public void addNewUserToDoRob(int currentTurnUserIndex, String userId) {
        this.currentTurnUserIndex = currentTurnUserIndex;
        this.userRobLandlordTurnMOList.add(new UserRobLandlordTurnMO(currentTurnUserIndex, userId, Boolean.TRUE));
    }
}
