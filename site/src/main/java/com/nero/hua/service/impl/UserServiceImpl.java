package com.nero.hua.service.impl;

import com.nero.hua.bean.UserDO;
import com.nero.hua.dao.UserDAO;
import com.nero.hua.exception.LoginException;
import com.nero.hua.enumeration.LoginEnumeration;
import com.nero.hua.model.LoginRequest;
import com.nero.hua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public Boolean login(LoginRequest loginRequest) {
        UserDO userDO = userDAO.selectByUserId(loginRequest.getUserId());

        if (null == userDO) {
            throw new LoginException(LoginEnumeration.USER_NOT_FOUND);
        }

        if (!userDO.getPassword().equals(loginRequest.getPassword())) {
            throw new LoginException(LoginEnumeration.PASSWORD_NOT_RIGHT);
        }
        else {
            return Boolean.TRUE;
        }
    }

}
