package com.nero.hua.controller;

import com.nero.hua.constant.LoginConstant;
import com.nero.hua.model.LoginRequest;
import com.nero.hua.model.base.BaseResponse;
import com.nero.hua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "login")
    public BaseResponse<Boolean> login(@RequestBody @Validated LoginRequest loginRequest, HttpSession httpSession) {
        if (null != httpSession.getAttribute(LoginConstant.LOGIN)) {
            return new BaseResponse<>(Boolean.TRUE);
        }

        Boolean successLogin = userService.login(loginRequest);
        httpSession.setAttribute(LoginConstant.LOGIN, Boolean.TRUE);
        httpSession.setAttribute(LoginConstant.USER_ID, loginRequest.getUserId());

        return new BaseResponse<>(successLogin);
    }

    @PostMapping(value = "logout")
    public BaseResponse<Boolean> logout(HttpSession httpSession) {
        if (Boolean.TRUE.equals(httpSession.getAttribute(LoginConstant.LOGIN))) {
            httpSession.removeAttribute(LoginConstant.LOGIN);
            httpSession.removeAttribute(LoginConstant.USER_ID);
            return new BaseResponse<>(Boolean.TRUE);
        }

       return new BaseResponse<>(Boolean.TRUE);
    }

}
