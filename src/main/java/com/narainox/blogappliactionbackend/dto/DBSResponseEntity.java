package com.narainox.blogappliactionbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DBSResponseEntity<T> {
    private String message;
    T data;
}
