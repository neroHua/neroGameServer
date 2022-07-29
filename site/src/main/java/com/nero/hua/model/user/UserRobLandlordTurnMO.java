package com.nero.hua.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRobLandlordTurnMO {

    private final int userIndex;
    private boolean doRob;

    public UserRobLandlordTurnMO(int userIndex) {
        this.userIndex = userIndex;
    }

}
