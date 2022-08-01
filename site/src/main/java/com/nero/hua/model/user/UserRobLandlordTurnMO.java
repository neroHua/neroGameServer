package com.nero.hua.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRobLandlordTurnMO {

    private final int userIndex;
    private final String userId;
    private boolean doRob;

    public UserRobLandlordTurnMO(int userIndex, String userId) {
        this.userIndex = userIndex;
        this.userId = userId;
    }

    public UserRobLandlordTurnMO(int userIndex, String userId, boolean doRob) {
        this.userIndex = userIndex;
        this.userId = userId;
        this.doRob = doRob;
    }
}
