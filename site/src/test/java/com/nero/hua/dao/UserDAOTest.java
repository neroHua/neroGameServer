package com.nero.hua.dao;

import com.nero.hua.bean.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@ActiveProfiles("dev")
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testSelectById() {
        UserDO userDO = userDAO.selectById(1L);
        Assert.notNull(userDO, "用户1不应该为null");
    }

}
