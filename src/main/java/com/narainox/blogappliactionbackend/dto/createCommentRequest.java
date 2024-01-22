package com.narainox.blogappliactionbackend.dto;

import com.narainox.blogappliactionbackend.models.Blog;
import com.narainox.blogappliactionbackend.models.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class createCommentRequest {
    @NotBlank(message = "Title is required parameter.")
    private String title;
    @NotBlank(message = "User is required parameter.")
    private User user;
    @NotBlank(message = "blog is required parameter.")
    private Blog blog;
}
