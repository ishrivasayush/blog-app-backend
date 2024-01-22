package com.narainox.blogappliactionbackend.service;

import com.narainox.blogappliactionbackend.dto.LoginUserRequest;
import com.narainox.blogappliactionbackend.dto.RegisterUserRequest;
import com.narainox.blogappliactionbackend.models.User;

public interface UserService {
    User regitorUser(RegisterUserRequest registerUserRequest);
    User login(LoginUserRequest loginUserRequest);
}
