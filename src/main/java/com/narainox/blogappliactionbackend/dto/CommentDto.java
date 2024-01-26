package com.narainox.blogappliactionbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto {
    private Integer commentId;
    private String title;
    private UserDto user;
    private BlogDto blog;
}
