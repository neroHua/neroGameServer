package com.nero.hua.service;

import com.nero.hua.model.user.LoginRequest;
import com.nero.hua.model.user.RegisterRequest;

public interface UserService {

    Boolean register(RegisterRequest registerRequest);

    Boolean login(LoginRequest loginRequest);

}
