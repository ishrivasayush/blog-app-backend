package com.narainox.blogappliactionbackend.service;

import com.narainox.blogappliactionbackend.dto.LoginUserRequest;
import com.narainox.blogappliactionbackend.dto.RegisterUserRequest;
import com.narainox.blogappliactionbackend.dto.UserDto;
import com.narainox.blogappliactionbackend.models.User;

public interface UserService {
    UserDto registerUser(RegisterUserRequest registerUserRequest);
    UserDto login(LoginUserRequest loginUserRequest);
}
