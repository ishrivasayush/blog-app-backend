package com.narainox.blogappliactionbackend.controllers;

import com.narainox.blogappliactionbackend.dto.*;
import com.narainox.blogappliactionbackend.exception.AuthenticationFailedException;
import com.narainox.blogappliactionbackend.exception.RecordNotFoundException;
import com.narainox.blogappliactionbackend.exception.UserAlreadyRegisterException;
import com.narainox.blogappliactionbackend.models.User;
import com.narainox.blogappliactionbackend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@Validated
@RequestMapping("/api/v1/")
public class UserController {
    @Autowired
    private UserService userService;

    @PutMapping("v1/register")
    public ResponseEntity<DBSResponseEntity<JwtResponse>> registerCall(@Valid @RequestBody RegisterUserRequest registerUserRequest) {
        DBSResponseEntity dbsResponseEntity = new DBSResponseEntity();

        try {
            User user = userService.registerUser(registerUserRequest)
            dbsResponseEntity.setMessage("Registration done successfully.Please check your mail for email verification.");
            return ResponseEntity.ok(dbsResponseEntity);
        } catch (UserAlreadyRegisterException exception) {

            throw exception;
        } catch (Exception exception) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("v1/login")
    public ResponseEntity<DBSResponseEntity<JwtResponse>> loginCall(@Valid @RequestBody LoginUserRequest loginUserRequest) {
        DBSResponseEntity dbsResponseEntity = new DBSResponseEntity();
        try{
            UserDto user = userService.login(loginUserRequest);
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserRequest.getUserName(), loginUserRequest.getPassword()));
            if(!authentication.isAuthenticated()) throw new AuthenticationFailedException("Password is incorrect.");
            JwtResponse jwtResponse = new JwtResponse( jwtService.GenerateToken(user.getUserName()));
            dbsResponseEntity.setData(jwtResponse);
            dbsResponseEntity.setMessage("User login successfully.");
            return ResponseEntity.ok(dbsResponseEntity);
        } catch (RecordNotFoundException exception) {

            throw exception;
        } catch (AuthenticationFailedException exception) {

            throw exception;
        } catch (Exception exception) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("v1/verifyEmailId/{code}")
    public ResponseEntity<DBSResponseEntity<JwtResponse>> verifyEmailIdCall(@PathVariable String code) {
        DBSResponseEntity dbsResponseEntity = new DBSResponseEntity();

        try {
            User user = userService.verifyEmailId(Integer.parseInt(code.substring(0,4)),code.substring(4));
            if(Objects.isNull(user)){
                throw new RecordNotFoundException("Record not present in system.");
            }else {
                JwtResponse jwtResponse = new JwtResponse(jwtService.GenerateToken(user.getUserName()));
                dbsResponseEntity.setData(jwtResponse);
                dbsResponseEntity.setMessage("User login successfully.");
                return ResponseEntity.ok(dbsResponseEntity);
            }
        } catch (RecordNotFoundException exception) {

            throw exception;
        } catch (AuthenticationFailedException exception) {

            throw exception;
        } catch (Exception exception) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
