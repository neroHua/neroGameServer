package com.nero.hua.convert;

import com.nero.hua.bean.UserDO;
import com.nero.hua.model.user.RegisterRequest;

import java.util.Date;

public class UserConvert {

    public static UserDO convertRequestToDO(RegisterRequest registerRequest) {
        UserDO userDO = new UserDO();

        userDO.setCreateTime(new Date());
        userDO.setUpdateTime(new Date());
        userDO.setCreateUserId(0L);
        userDO.setUpdateUserId(0L);

        userDO.setUserId(registerRequest.getUserId());
        userDO.setPassword(registerRequest.getPassword());
        userDO.setNickName(registerRequest.getNickName());

        return userDO;
    }

}
