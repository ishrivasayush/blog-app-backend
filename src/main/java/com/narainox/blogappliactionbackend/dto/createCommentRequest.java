package com.narainox.blogappliactionbackend.dto;

import com.narainox.blogappliactionbackend.models.Blog;
import com.narainox.blogappliactionbackend.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class createCommentRequest {
    private String title;
    private User user;
    private Blog blog;
}
