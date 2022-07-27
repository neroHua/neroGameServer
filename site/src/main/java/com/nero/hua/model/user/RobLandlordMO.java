package com.nero.hua.model.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RobLandlordMO {

    private int index;
    private String userId;
    private int count;

    public RobLandlordMO(int index, String userId, int count) {
        this.index = index;
        this.userId = userId;
        this.count = count;
    }
}
