package com.nero.hua.service;

import com.nero.hua.SiteApplication;
import com.nero.hua.model.user.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@ActiveProfiles("dev")
@SpringBootTest(classes = { SiteApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testRegister() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserId("testCase002");
        registerRequest.setPassword("abc123");
        registerRequest.setNickName("nickName");
        Boolean result = userService.register(registerRequest);
        assertTrue("注册失败", result);
    }

    @Test
    public void testLogin() {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUserId("testUser001");
//        loginRequest.setPassword("abc123");
//        Boolean login = userService.login(loginRequest);
//        isTrue(login, "用户1应该登录成功");
    }

}
