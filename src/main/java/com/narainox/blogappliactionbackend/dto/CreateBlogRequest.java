package com.narainox.blogappliactionbackend.dto;

import com.narainox.blogappliactionbackend.models.Comment;
import com.narainox.blogappliactionbackend.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlogRequest {
    private String title;
    private String description;
    private Boolean publish;
    private User user;
    private Comment comment;

}
