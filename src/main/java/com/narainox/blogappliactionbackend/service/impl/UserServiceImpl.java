package com.narainox.blogappliactionbackend.service.impl;

import com.narainox.blogappliactionbackend.dto.LoginUserRequest;
import com.narainox.blogappliactionbackend.dto.RegisterUserRequest;
import com.narainox.blogappliactionbackend.exception.UserAlreadyRegisterException;
import com.narainox.blogappliactionbackend.models.User;
import com.narainox.blogappliactionbackend.repository.UserRepository;
import com.narainox.blogappliactionbackend.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User regitorUser(RegisterUserRequest registerUserRequest) {
        //if user is already present
        User userTemp=userRepository.findByUserName(registerUserRequest.getUserName());
        if (!Objects.nonNull(userTemp)) throw new UserAlreadyRegisterException("Email id already present in System. Please try another Email id");

        //Create new user
        User user=new User();
        BeanUtils.copyProperties(registerUserRequest,user);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        //save
        return userRepository.save(user);
    }

    @Override
    public User login(LoginUserRequest loginUserRequest) {
        return null;
    }
}
