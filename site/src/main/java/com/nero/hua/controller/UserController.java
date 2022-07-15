package com.nero.hua.controller;

import com.nero.hua.constant.LoginConstant;
import com.nero.hua.model.base.BaseResponse;
import com.nero.hua.model.user.LoginRequest;
import com.nero.hua.model.user.RegisterRequest;
import com.nero.hua.model.user.UserInformationResponse;
import com.nero.hua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "register")
    public BaseResponse<Boolean> register(@RequestBody @Validated RegisterRequest registerRequest) {
        Boolean successLogin = userService.register(registerRequest);

        return new BaseResponse<>(successLogin);
    }

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

    @GetMapping(value = "information")
    public BaseResponse<UserInformationResponse> userInformation(HttpSession httpSession) {
        String userId = (String) httpSession.getAttribute(LoginConstant.USER_ID);
        UserInformationResponse userInformationResponse = userService.getUserInformation(userId);

        return new BaseResponse<>(userInformationResponse);
    }

}
