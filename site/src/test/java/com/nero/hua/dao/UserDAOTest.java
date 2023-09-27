package com.nero.hua.dao;

import com.nero.hua.SiteApplication;
import com.nero.hua.bean.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Date;

@ActiveProfiles("dev")
@SpringBootTest(classes = { SiteApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testInsertUser() {
        UserDO userDO = new UserDO();

        userDO.setCreateTime(new Date());
        userDO.setUpdateTime(new Date());
        userDO.setCreateUserId(0L);
        userDO.setUpdateUserId(0L);

        userDO.setUserId("testCase001");
        userDO.setPassword("abc123");
        userDO.setNickName("nickName");
        userDAO.insertUser(userDO);

        UserDO userDOQuery = userDAO.selectByUserId("testCase001");
        Assert.notNull(userDOQuery, "用户1不应该为null");
    }

}
