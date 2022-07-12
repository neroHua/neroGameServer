package com.nero.hua.service;

import com.nero.hua.model.LoginRequest;
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
public class LoginServiceTest {

    @Autowired
    private LoginService loginService;

    @Test
    public void testLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserId(1L);
        loginRequest.setPassword("abc123");
        Boolean login = loginService.login(loginRequest);
        Assert.isTrue(login, "用户1应该登录成功");
    }

}
