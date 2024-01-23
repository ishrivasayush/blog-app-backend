package com.narainox.blogappliactionbackend.service.impl;

import com.narainox.blogappliactionbackend.dto.LoginUserRequest;
import com.narainox.blogappliactionbackend.dto.RegisterUserRequest;
import com.narainox.blogappliactionbackend.exception.AuthenticationFailedException;
import com.narainox.blogappliactionbackend.exception.RecordNotFoundException;
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
        if (!Objects.isNull(userTemp)) throw new UserAlreadyRegisterException("Email id already present in System. Please try another Email id");

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
        User userTemp=userRepository.findByUserName(loginUserRequest.getUserName());
        if (Objects.isNull(userTemp)) throw new RecordNotFoundException("Email id is not yet register. Please register and login.");

        User user=userRepository.findByUserNameAndPassword(loginUserRequest.getUserName(), loginUserRequest.getPassword());
        if (Objects.isNull(userTemp)) throw new AuthenticationFailedException("Password is incorrect.");

        return user;
    }
}
