package com.narainox.blogappliactionbackend.controllers;

import com.narainox.blogappliactionbackend.dto.*;
import com.narainox.blogappliactionbackend.exception.AuthenticationFailedException;
import com.narainox.blogappliactionbackend.exception.RecordNotFoundException;
import com.narainox.blogappliactionbackend.exception.UserAlreadyRegisterException;
import com.narainox.blogappliactionbackend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/v1/")
public class UserController {
    @Autowired
    private UserService userService;

    @PutMapping("/register")
    public ResponseEntity<DBSResponseEntity<JwtResponse>> registerUser(@Valid @RequestBody RegisterUserRequest registerUserRequest)
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try{
            UserDto userDto = userService.registerUser(registerUserRequest);
            JwtResponse jwtResponse=new JwtResponse("jwtResponse");
            dbsResponseEntity.setMessage("User Register Successfully. please login.");
            dbsResponseEntity.setData(jwtResponse);
            return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (UserAlreadyRegisterException userAlreadyRegisterException)
        {
            throw userAlreadyRegisterException;
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/login")
    public ResponseEntity<DBSResponseEntity<JwtResponse>> registerUser(@Valid @RequestBody LoginUserRequest loginUserRequest)
    {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        try{
            UserDto userDto = userService.login(loginUserRequest);
            JwtResponse jwtResponse=new JwtResponse("Jwt Response.");
            dbsResponseEntity.setData(jwtResponse);
            dbsResponseEntity.setMessage("User Login Successfully.");
            return ResponseEntity.ok(dbsResponseEntity);
        }
        catch (RecordNotFoundException recordNotFoundException)
        {
            throw recordNotFoundException;
        }
        catch (AuthenticationFailedException authenticationFailedException)
        {
            throw  authenticationFailedException;
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
