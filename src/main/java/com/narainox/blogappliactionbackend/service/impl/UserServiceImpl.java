package com.narainox.blogappliactionbackend.service.impl;

import com.narainox.blogappliactionbackend.dto.LoginUserRequest;
import com.narainox.blogappliactionbackend.dto.RegisterUserRequest;
import com.narainox.blogappliactionbackend.dto.UserDto;
import com.narainox.blogappliactionbackend.exception.AuthenticationFailedException;
import com.narainox.blogappliactionbackend.exception.RecordNotFoundException;
import com.narainox.blogappliactionbackend.exception.UserAlreadyRegisterException;
import com.narainox.blogappliactionbackend.models.User;
import com.narainox.blogappliactionbackend.repository.UserRepository;
import com.narainox.blogappliactionbackend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto registerUser(RegisterUserRequest registerUserRequest) {
        User userName = userRepository.findByUserName(registerUserRequest.getUserName());
        if (!Objects.isNull(userName)) throw new UserAlreadyRegisterException("User is Already Register With UserName.");
        User user = modelMapper.map(registerUserRequest, User.class);
        user.setUpdatedAt(LocalDateTime.now());
        user.setCreatedAt(LocalDateTime.now());
        User save = userRepository.save(user);
        return modelMapper.map(save, UserDto.class);
    }

    @Override
    public UserDto login(LoginUserRequest loginUserRequest) {
        User userName = userRepository.findByUserName(loginUserRequest.getUserName());
        if (Objects.isNull(userName))throw new RecordNotFoundException("User Is Not Register yet.");
        User user = userRepository.findByUserNameAndPassword(loginUserRequest.getUserName(), loginUserRequest.getPassword());
        if (Objects.isNull(user))throw new AuthenticationFailedException("Password is Incorrect");
        return modelMapper.map(user, UserDto.class);
    }
}
