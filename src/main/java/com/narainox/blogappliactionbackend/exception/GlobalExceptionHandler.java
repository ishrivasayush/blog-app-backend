package com.narainox.blogappliactionbackend.exception;

import com.narainox.blogappliactionbackend.dto.DBSResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DBSResponseEntity> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        dbsResponseEntity.setMessage(errorMessage);
        return new ResponseEntity<>(dbsResponseEntity, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<DBSResponseEntity> handleRecordNotFoundExceptions(
            RecordNotFoundException  ex) {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        dbsResponseEntity.setMessage(ex.getMessage());

        return new ResponseEntity<>(dbsResponseEntity,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<DBSResponseEntity> handleUserNotFoundExceptions(
            UsernameNotFoundException ex) {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        dbsResponseEntity.setMessage(ex.getMessage());

        return new ResponseEntity<>(dbsResponseEntity,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyRegisterException.class)
    public ResponseEntity<DBSResponseEntity> handleUserAlreadyRegisterException(
            UserAlreadyRegisterException  ex) {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        dbsResponseEntity.setMessage(ex.getMessage());

        return new ResponseEntity<>(dbsResponseEntity,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<DBSResponseEntity> handleAuthenticationFailedException(
            AuthenticationFailedException  ex) {
        DBSResponseEntity dbsResponseEntity=new DBSResponseEntity();
        dbsResponseEntity.setMessage(ex.getMessage());
        return new ResponseEntity<>(dbsResponseEntity,HttpStatus.UNAUTHORIZED);
    }
}
