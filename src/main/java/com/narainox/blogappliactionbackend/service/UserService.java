package com.narainox.blogappliactionbackend.service;

import com.narainox.blogappliactionbackend.dto.LoginUserRequest;
import com.narainox.blogappliactionbackend.dto.RegisterUserRequest;
import com.narainox.blogappliactionbackend.dto.UserDto;
import com.narainox.blogappliactionbackend.exception.UsernameNotFoundException;
import com.narainox.blogappliactionbackend.models.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UserDto registerUser(RegisterUserRequest registerUserRequest);
    UserDto login(LoginUserRequest loginUserRequest);
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
