package com.nero.hua.dao;

import com.nero.hua.bean.UserDO;

public interface UserDAO {

    UserDO selectByUserId(String userId);

}
